package homework5;
import java.util.ArrayList;
public class Student {
	private String firstName;
	private String batch;
	private  ArrayList<Book> bookCart ;
	public Student(String firstName,String batch) {
		this.firstName = firstName;
		this.batch = batch;
		bookCart = new ArrayList<Book>();
	}
	public void borrowBook(Book book) {
		//check if bookCart has 3 book or not
		if(bookCart.size() >= 3) {
			System.out.println("You could borrow only maximum 3 books");
		}else {
			// if doesn't have 3 books 
			if(book.isBorrowed()) {
				System.out.println("This book isn't available");
			}else {
				// if have 3 books then allow to borrow
				// we will add books in cart
				bookCart.add(book);
				// tell mark book that borrowed
				book.borrow();
			}
		}
	}
	public void returnBook(Book book) {
		//check if book is returBack or not
		if(bookCart.contains(book)) {
			// this book is returnBack
			book.returnBack();
			// remove book form cart
			bookCart.remove(book);
		}else {
			System.out.println("You didn't borrow this book");
		}
	}
	public ArrayList<Book> getBookCart(){
		return bookCart;
	}
	// outPut toString of name, batch and all the books that student borrowed
	public String toString() {
		String outPut = "";
		outPut += firstName+" " + batch+ " "+ "\n";
		for(Book book : bookCart) {
			outPut +=" " +book.getTitle()+ "\n"; 
		}
		return outPut;
	}
}