/**
 * This class represents data for a book and implements it
 * @author Matthew Fishman
 * @date 2/3/2015
 */

import java.util.Calendar;

// Book implements comparable books to compare titles of books
public class Book implements Comparable<Book>{

	//Instance Variables 
	private String bookTitle, bookAuthor, publisher, borrowerName;
	private int publicationYear;
	private boolean status;
	private Calendar borrowDate, returnDate;
	
	
	/**
	 * This is the Book constructor.
	 * Takes in the String parameters bookTitle, bookAuthor, publisher, and borrowerName.
	 * Takes in the int parameter publicationYear
	 * Takes in the boolean parameter status
	 * Takes in the Calendar parameters borrowDate and returnDate.
	 *
	 */ 

	public Book(String bookTitle, String bookAuthor, String publisher, String borrowerName,
	int publicationYear, Calendar borrowDate, Calendar returnDate, boolean status){
	
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.publisher = publisher;
		this.borrowerName = borrowerName;
		this.publicationYear = publicationYear;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.status = status;
	}
	
	/**
	 * Gets the title of the Book
	 */
	public String getBookTitle() {

		return bookTitle;
	}

	/**
	 * Gets the author of the Book
	 */
	public String getBookAuthor() {

		return bookAuthor;
	}

	/**
	 * Gets the publiser of the Book
	 */
	public String getPublisher() {

		return publisher;
	}

	/**
	 * Gets the Borrower's name of the Book
	 */
	public String getBorrowerName() {

		return borrowerName;
	}

	/**
	 * Gets the publication year of the Book
	 */
	public int getPublicationYear() {

		return publicationYear;
	}

	/**
	 * Gets the date the book was borrowed
	 */
	public Calendar getborrowDate() {

		return borrowDate;
	}

	/**
	 * Gets the date when the book must be returned
	 */
	public Calendar getReturnDate() {

		if(this.returnDate == null)
		{
			return Calendar.getInstance();
		}
		else
		return this.returnDate;
	}

	/**
	 * Gets the status of the Book(whether the book is available or not)
	 */
	public boolean getStatus() {

		return status;
	}
	/**
	 * This method sets the avaiablity status of the book
	 */
	public void setStatus(boolean toSetStatus) {
		
		status = toSetStatus;
	}

	/**
	 * This method sets the date the book must be returned 
	 */
	public void setReturnDate(Calendar toSetReturnDate) {

		returnDate = toSetReturnDate;
	}

	/**
	 * This method sets the date the book was borrowed
	 */
	public void setBorrowDate(Calendar toSetBorrowDate) {

		borrowDate = toSetBorrowDate;
	}

	/**
	 * This method sets the name of the person who borrowed the book
	 */
	public void setBorrowName(String toSetBorrowName) {

		borrowerName = toSetBorrowName;
	}
	
	/**
	 * This method compares one Book's title to another. 
	 */
	public int compareTo(Book bookToCompare){
		return this.bookTitle.compareTo(bookToCompare.bookTitle);
	}

	/**
	 * This method sets the book's infromation to type string. It uses the if statement to check whether
	 * the book is available or not. If the book is available it prints out the book including the returnDate, borrowDate
	 * and borrower's name. If the book is not available it will not print out the books return date, borrow date and the
	 * borrower's name 
	 */
	public String toString(){
		if(this.status == false){
			return "\n" + "Title: " + this.bookTitle + "\n" + "Author: " + this.bookAuthor + "\n" + "Publisher: " + this.publisher + "\n" + "Publication Year: " + this.publicationYear + "\n" + "Status: " + this.status + "\n" + "Borrower's Name: " + this.borrowerName + "\n" + "Borrow Date: " + this.borrowDate.getTime() + "\n" + "Return Date: " + this.returnDate.getTime() + "\n";	 	
		}
		else{
			return "\n" + "Title: " + this.bookTitle + "\n" + "Author: " + this.bookAuthor + "\n" + "Publisher: " + this.publisher + "\n" + "Publication Year: " + this.publicationYear + "\n" + "Status: " + this.status + "\n";	 	
		}
	}

}