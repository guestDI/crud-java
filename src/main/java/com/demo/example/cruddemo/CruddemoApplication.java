package com.demo.example.cruddemo;

import com.demo.example.cruddemo.dao.AuthorDAO;
import com.demo.example.cruddemo.entity.Author;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(AuthorDAO authorDAO){
//		return runner -> {
////			createAuthor(authorDAO);
////			createMultipleAuthors(authorDAO);
////			findAuthorById(authorDAO);
////			queryForAuthors(authorDAO);
////			queryAuthorById(authorDAO);
////			updateAuthor(authorDAO);
////			removeAuthorById(authorDAO);
//			removeByLastname(authorDAO);
//		};
//	}

	private void removeByLastname(AuthorDAO authorDAO) {
		authorDAO.deleteByLastName("Doe");
	}

	private void removeAuthorById(AuthorDAO authorDAO) {
		Author myAuthor = authorDAO.findById(1);
		authorDAO.delete(myAuthor);
	}

	private void updateAuthor(AuthorDAO authorDAO) {
		Author myAuthor = authorDAO.findById(1);
		myAuthor.setFirstName("Bye");
		authorDAO.update(myAuthor);
	}

	private void queryAuthorById(AuthorDAO authorDAO) {
		List<Author> authors = authorDAO.findByLastname("King");
		for(Author tmpAuthor : authors){
			System.out.println(tmpAuthor);
		}
	}

	private void queryForAuthors(AuthorDAO authorDAO) {
		List<Author> authors = authorDAO.findAll();
		for(Author tmpAuthor : authors){
			System.out.println(tmpAuthor);
		}
	}

	private void createMultipleAuthors(AuthorDAO authorDAO) {

		// create multiple students
		System.out.println("Creating 3 author objects ...");
		Author tempAuthor1 = new Author("John", "Doe", "john@luv2code.com");
		Author tempAuthor2 = new Author("Mary", "Public", "mary@luv2code.com");
		Author tempAuthor3 = new Author("Bonita", "Applebum", "bonita@luv2code.com");

		// save the student objects
		System.out.println("Saving the authors ...");
		authorDAO.save(tempAuthor1);
		authorDAO.save(tempAuthor2);
		authorDAO.save(tempAuthor3);
	}

	private void createAuthor(AuthorDAO authorDAO) {
		Author newAuthor = new Author("Steven", "King", "sking@email.com");
		authorDAO.save(newAuthor);
	}

	private void findAuthorById(AuthorDAO authorDAO) {
		Author myAuthor = authorDAO.findById(1);
		System.out.println("Reading the author ..." + myAuthor);
	}



}
