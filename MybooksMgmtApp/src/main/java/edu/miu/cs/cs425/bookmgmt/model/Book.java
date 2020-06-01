package edu.miu.cs.cs425.bookmgmt.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Books")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bookId;
	@NotBlank(message="ISBN is required")
	@Column(name="Isbn", unique= true, nullable= false)
	private String isbn;
	@NotBlank(message="title is required")
 	private String title;
	@DateTimeFormat(pattern="yyyy--MM--dd")
	public LocalDate datePublished;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="published_by",nullable=false)
	private Publisher publishedBy;
	public Book(Long bookId, String isbn, String title,LocalDate datePublished ) {
		super();
		this.bookId = bookId;
		this.isbn = isbn;
		this.title = title;
		this.datePublished=datePublished;
		
	}
	
	
	 

	public Book(@NotBlank(message = "ISBN is required") String isbn,
			@NotBlank(message = "title is required") String title, LocalDate datePublished) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.datePublished = datePublished;
		this.publishedBy=publishedBy;
	}




	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Publisher getPublishedBy() {
		return publishedBy;
	}




	public void setPublishedBy(Publisher publishedBy) {
		this.publishedBy = publishedBy;
	}




	@Override
	public String toString() {
		return String.format("Book [bookId=%s, isbn=%s, title=%s, datePublished=%s,publisher=%s]", bookId, isbn, title,
				datePublished,this.publishedBy);
	}
	public LocalDate getDatePublished() {
		return datePublished;
	}
	public void setDatePublished(LocalDate datePublished) {
		this.datePublished = datePublished;
	}
	

	
	
}
