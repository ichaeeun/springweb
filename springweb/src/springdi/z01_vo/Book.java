package springdi.z01_vo;

import org.springframework.stereotype.Component;

//springdi.z01_vo.Book
@Component
public class Book {
	private String name;
	private int price;
	private String Author;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String name, int price, String author) {
		super();
		this.name = name;
		this.price = price;
		Author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	
	
	
}
