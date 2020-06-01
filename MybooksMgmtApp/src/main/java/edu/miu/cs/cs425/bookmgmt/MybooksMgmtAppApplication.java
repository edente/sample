package edu.miu.cs.cs425.bookmgmt;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.miu.cs.cs425.bookmgmt.model.Book;
import edu.miu.cs.cs425.bookmgmt.model.Publisher;
import edu.miu.cs.cs425.bookmgmt.repository.BookRepository;

@SpringBootApplication
public class MybooksMgmtAppApplication implements CommandLineRunner{

	@Autowired
	private BookRepository bookRepository;
 	public static void main(String[] args) {
		SpringApplication.run(MybooksMgmtAppApplication.class, args);
	}
 	private Book saveBook(Book book) {   //that is my save method
 		return bookRepository.save(book);
 	}

	@Override
	public void run(String... args) throws Exception {
		Publisher p1=new Publisher("Pearsons INC.", null);
       
		Book book1 = new Book("123-4567890","Princples of software Enigneering",LocalDate.of(2020,5,28));
        Book book2 = new Book("433-4efw7890","civile Enigneering",LocalDate.of(2020,5,28));
        
        List<Book> books= Arrays.asList(book1, book2);
        
        p1.setBooksPublished(books);
        Book savedBook1= saveBook(book1);	
        System.out.println(savedBook1);
        Book savedBook2= saveBook(book2);	
        System.out.println(savedBook2);
	}

}
