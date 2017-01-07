//package library;
/**
 * This class is the driver of the library application. It represents a textual graphical interface for the application
 * @author Matthew Fishman
 * @date 2-3-2015
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class Library {



	static int choice ; //user choice
	static Scanner userInput = new Scanner(System.in); //scanner object for reading input
    public BooksManager booksManager = new BooksManager();//Creates a new BooksManager 

    /**
		* This method displays the main menu
	 **/
	public static void displayMenu(){
		System.out.println(">########################################################################");
		System.out.println("> Choose one of the options below by typing the corresponding number: ");
		System.out.println(">====================================================================");
		System.out.println("1- Display library list.");
		System.out.println("2- Add a book to the Library.");
		System.out.println("3- Borrow a book.");
		System.out.println("4- Return a book.");
		System.out.println("5- Delete a book.");
		System.out.println("6- Display and sort by Author's name");
		System.out.println("7- Display and sort by return date");
		System.out.println("0- Exit.");
		System.out.println(">########################################################################");
		System.out.println("> Enter your option here: ");
		choice = userInput.nextInt();//User inputs a choice (integer).

	}


    /**
		* This method will read user input to create an instance of Book
	 **/
	public void createBook(){
		
		userInput.nextLine();//fix to stop it from skipping title

		System.out.println("> Enter the title of the book: ");//user input of book title
		String title = userInput.nextLine();

		System.out.println("> Enter the author of the book: ");//user input of book's author
		String author = userInput.nextLine();

		System.out.println("> Enter the publisher of the book: ");//user input of book's publisher
		String publisher = userInput.nextLine();

		System.out.println("> Enter the publication year of the book: ");//user input of book's publication year
		String publicationYear = userInput.nextLine();

		String borrower = "nobody";//no borrower
		Calendar borrowDate = null;//no borrow date
		Calendar returnDate = null;//no return date

		boolean status = true;
		//calls to the addBook() method in the BooksManager class
		booksManager.addBook(new Book(title,author,publisher,borrower,Integer.parseInt(publicationYear),borrowDate,returnDate,status));//adds the book with the Book constructor's parameters
	}


    /**
		* Main application loop
	 **/

	public void run(){

		System.out.println("Loading list of Books");
		booksManager.readInBooks();
		this.displayMenu();//Displays the main menu and ask for choice.


			while(choice != 0){
					//Choice 1:
					if(choice == 1){

					booksManager.displayLibraryList();//displays the list of books
					}

					//Choice 2:
					if(choice == 2){
						createBook();//calls to the method for a user to make a new book

					}
				//Choice 3:
					if(choice == 3){
						//ask user to enter book information

						System.out.println("Borrow a book" + "\n");
						userInput.nextLine();//fix so user can input title

						System.out.println("> Enter the book's title: ");
						String bookTitle = userInput.nextLine();//has user input the title of the book they want to take out

						System.out.println("> Enter the borrower's name: ");
						String borrowerName = userInput.nextLine();//" " name of the borrower
						
						System.out.println("> Enter the return date's day: ");
						int borrowDay = Integer.parseInt(userInput.nextLine());//" " day the book needs to be returned
						System.out.println("> Month?: ");
						int borrowMonth = Integer.parseInt(userInput.nextLine());//" " month the book needs to be returned
						System.out.println("> Year?: ");
						int borrowYear = Integer.parseInt(userInput.nextLine());//" " year the book needs to be returned

						Calendar returnDate = Calendar.getInstance();//has the returnDate set to a calendar instance
						returnDate.set(borrowYear,borrowMonth-1,borrowDay);//sets the return date to the date the user inputed
						
						booksManager.borrowBook(bookTitle, borrowerName, returnDate);//calls to the borrowBook() method in the BooksManager class and sends over the users inputed parameters
					}
					//Choice 4:
					if(choice == 4){
						//ask user to enter book information
						userInput.nextLine();//fix so user can enter book's name

						System.out.println(">Enter the borrowed book's name: ");
						String bookTitle = userInput.nextLine();//has the user input the book they're returning
						
						booksManager.returnBook(bookTitle);//calls to the returnBook() method in the BooksManager class and sends over the parameter of the bookTitle the user inputed.
					}
					//Choice 5:
					if(choice == 5){
						//ask user to enter book information
						userInput.nextLine();//fix so user dcan input book's name

						System.out.println(">Enter the book's name you want deleted: ");
						String bookTitle = userInput.nextLine();//has the user input the book they're deleting

						booksManager.deleteBook(bookTitle);//calls to the deletedBook() method in the BooksManager class and sends over the parameter of the bookTitle the user inputed. 
					}
					
					if(choice == 6){
						booksManager.sortAuthors();
						System.out.println("---------------------------------------------------------------------------------\n");
						System.out.println("Books are sorted by author!\n");
						System.out.println("---------------------------------------------------------------------------------\n");

					}

					if(choice == 7){
						booksManager.sortReturnDate();
						System.out.println("---------------------------------------------------------------------------------\n");
						System.out.println("Books are sorted by the return date!\n");
						System.out.println("---------------------------------------------------------------------------------\n");	
					}

					//Choice 0:
					if(choice == 0){
						System.exit(0);;
					}
					this.displayMenu();

			}//end of while loop.

		System.out.println("####  You have Exited the Library!  ####");

		}//End of run() method.


	/**
	 * ===================================================================================================
	 * End of Class Methods.
	 * ===================================================================================================
	 */

	public static void main(String[] args){

		System.out.println("> Welcome to the library!");

		Library lib = new Library();
		lib.run();

	}//End of Main Method.

}