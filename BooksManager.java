import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;
import java.io.*;
/**
 * This class represents a Book Manager 
 * @author Matthew Fishman
 * @date 2/3/2015
 */
public class BooksManager{

ArrayList<Book> books = new ArrayList<Book>();//creates a new ArrayList of type book
	/** 
	 * This method adds a Book instance to the List of books. It will check
	 * if a book with the same title is already in the list. If the Book instance
	 * currently trying to be added has the same title it will not added. If the book
	 * instance doesnt match the title of any of the other book instances it will be added to
	 * the list. 
	 */

	public boolean addBook(Book newBook){
		//iterates through the list of books checking for duplicates
		for(Book book : books){
			if (book.compareTo(newBook) == 0){ //if duplicates found it will return false and not add the book
				return false;
			}
		}
		books.add(newBook);//if the book is not a duplicate it will add the book to the list
		return true;
	}
	/**
	 * This method will remove a Book instance from the List of books. It will iterate
	 * through the list of books comparing the Book instance to all the other books in the
	 * list of books. If the Book instance matches a book title from the List of books the 
	 * book will be removed. If tge book does not match it will do nothing and return false
	 */
	public boolean deleteBook(String bookTitle){
		//iterates through the list of books checking for a matching title
		for (Book book : books){
			if(book.getBookTitle().compareTo(bookTitle) == 0){//If title matches removes the book
				books.remove(book);
				return true;
			}
		}
		return false;
	}

	/**
	 * This method reads in a text file of books. It will then split the text on each
	 * line by a comma. It will assign each text seperated by a comma to an Array. The method
	 * will then make a new book and assign in order the text in the array by index to the book's constructor.
	 * It will also fill in blank data for the information not recieved. 
	 */
	public void readInBooks(){
		Scanner bookInput; 
		File inFile = new File("Books.txt");//read in the test file
		try{
			bookInput = new Scanner(inFile);
			
			//iterates through the text file adding each book
			while(bookInput.hasNext()){
				String inputLine = bookInput.nextLine();//Line for each book
				String[] bookArray= inputLine.split(",");//split the text by comma
				addBook(new Book(bookArray[0], bookArray[1], bookArray[2], "no borrower" , Integer.parseInt(bookArray[3]), null, null, true));//adds the new Book 
			}

			bookInput.close();//close file
		}
		//catch if the file is not found
		catch (FileNotFoundException e){
			System.out.println(e);
			System.exit(1);	
		} 
	}	
		/**
		 * This method will display the Book instances found in the list of books. The method will interate
		 * through the list of books and prints each Book instance out using System.out.println and the .toString() 
		 * method found in the book class. 
		 */
		public void displayLibraryList(){
			System.out.println("List of books: " +"\n");
			System.out.println(">########################################################################");
			for(Book book : books){//iterates through the list of books
				System.out.print(book.toString());//prints out each book; calls to .toString() from Book class
			}
			System.out.println(">########################################################################" +"\n");
		}

		/** 
		 * This method will be called from the Library class to set the information when a Book instance is borrowed
		 * from the list of books. It will iterate through the list of books and check using the if statement if the
		 * book title the borrower is looking for matches a book found in the list of books. It will also check if the book
		 * is available or not. If both conditions are met the method with set the borrow's name, today's date to the borrowDate
		 * the return date to whatever date was inputed in the terminal and set the books availibity to false. 
		 */
		public boolean borrowBook(String bookTitle, String borrowerName, Calendar returnDate){
			for (Book book : books){//iterates through the lists of books
				if(book.getBookTitle().compareTo(bookTitle) == 0 && book.getStatus() == true){//checks if book is in the list of books and is available
					book.setBorrowName(borrowerName);
					book.setBorrowDate(Calendar.getInstance());
					book.setReturnDate(returnDate);
					book.setStatus(false);
					return true;
				}
			}
			return false;
		}
		/**
		 * This method will be called from the Library class when a borrowed book is being returned. When a book
		 * is being returned it will check the list of books for the book being return and check if the book is part
		 * of the list of books. It will also check if the book is not available. If the book matches these comparisons 
		 * the method will set the books avaialbity to true. 
		 */ 
		public boolean returnBook(String bookTitle){
			for (Book book : books){//iterates through the lists of books
				if(book.getBookTitle().compareTo(bookTitle) == 0 && book.getStatus() == false){//checks if the titles match and the book is not available
					book.setStatus(true);//sets the book to available 
					return true;
				}
			}	
			return false;
		}
		// Method to sort the books based on their authors 
		public void sortAuthors(){
			// Anonymous class is created in the second parameter
			Collections.sort(books, new Comparator<Book>(){
				public int compare(Book book1, Book book2){
				return book1.getBookAuthor().compareTo(book2.getBookAuthor());
				}
			});// end sort parameters
		}// close sortAuthors() method 

		// Method to sort the books based on their authors 
		public void sortReturnDate(){
			// Anonymous class is created in the second parameter
			Collections.sort(books, new Comparator<Book>(){
				// Method inside of anonymous class
				public int compare(Book book1, Book book2){
					return book1.getReturnDate().compareTo(book2.getReturnDate());
				}
			});// end sort parameters
			// For loop to go through ArrayList of books 
			for (Book book : books){
				// If book is available, print out the book 
				if (book.getStatus() == true){
					System.out.println(book.toString());
				}
				else
					System.out.println(book.toString());
			}
		}// close sortAuthors() method 
}