package teht.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String title;
	private String author;
	private String isbn;
	private int bookyear;
	private int price;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="categoryid")
	private Category category;
	
	public Book() {
		super();
	}
	
	public Book(String title, String author, String isbn, int year, int price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.bookyear = year;
		this.price = price;
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", bookYear="
				+ bookyear + ", price=" + price + "]";
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getBookYear() {
		return bookyear;
	}

	public void setBookYear(int bookYear) {
		this.bookyear = bookYear;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
