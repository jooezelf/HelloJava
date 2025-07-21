package chap06_1;

public class Book {
	
	String book;
	int numb;
	int price;
	
	Book(int numb, String book, int price){
		this.book = book;
		this.numb = numb;
		this.price = price;
		
		
		}

	public void setBook(String book) {
		this.book = book;
	}

	public void setNumb(int numb) {
		this.numb = numb;
	}

	public void setPrice(int price) {
		this.price = price;
	}
} // end class
