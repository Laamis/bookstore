package hh.swd20.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;
import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	//Commandlinerunner will add some test data to the db
	@Bean
	public CommandLineRunner demo(BookRepository bRepo, CategoryRepository cRepo, UserRepository uRepo) {
		return (args) -> {
		Category category1 = new Category("Science-Fiction");
		Category category2 = new Category("Fantasy");
		cRepo.save(category1);
		cRepo.save(category2);
		
		Book book1 = new Book("Harry Potter ja Azkabanin vanki", "J.K. Rowling", 2006, "123986127", 17.90, category2);
		Book book2 = new Book("Harry Potter ja kuoleman varjelukset", "J.K. Rowling", 2008, "12309785", 19.90, category2);
		

		// Let's save the test data to the db
		bRepo.save(book1);
		bRepo.save(book2);
		
		//credentials are user1/user and admin1/admin for testing purposes
		User user1 = new User("user1","$2a$10$B39x3bbrj5RRBXXbgDPwteLsNMQ.vnkmiR3iTgAPVM5YDf6pFYIoi","erkki@mail.com","USER");
		User user2 = new User("admin1", "$2a$10$YS1Shd4/McfRLipUDucm2unIrwZ2hFp/upWpD3FDh7dRoJzkcqJE.", "jarmo@mail.com", "ADMIN");
		
		//saving the users to the db
		uRepo.save(user1);
		uRepo.save(user2);
		
		//now you should be able to access the test-data
		//with the endpoint h2-console
			};
	
	}
	
}
