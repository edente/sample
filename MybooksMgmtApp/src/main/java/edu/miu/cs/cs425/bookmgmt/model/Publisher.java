package edu.miu.cs.cs425.bookmgmt.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="publishers")
public class Publisher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer publisherId;
	@NotBlank
	private String name;
	@OneToMany(mappedBy="publishedBy")
	private List<Book> booksPublished;
	public Publisher(String name, List<Book> booksPublished) {
		super();
		this.name = name;
		this.booksPublished=booksPublished;
	}
	
	
	public Publisher() {
		super();
	}

	public Integer getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<Book> getBooksPublished() {
		return booksPublished;
	}


	public void setBooksPublished(List<Book> booksPublished) {
		this.booksPublished = booksPublished;
	}


	@Override
	public String toString() {
		return String.format("PublisherId [publisherId=%s, name=%s]", publisherId, name);
	}
	
	

}
