package hh.swd20.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	//Commandlinerunner will add some test data to the db
	@Bean
	public CommandLineRunner demo(BookRepository repo) {
		Book book1 = new Book("Harry Potter ja Azkabanin vanki", "J.K. Rowling", 2006, "123986127", 17.90);
		Book book2 = new Book("Harry Potter ja kuoleman varjelukset", "J.K. Rowling", 2008, "12309785", 21.90);

		// Let's save the test data to the db
		repo.save(book1);
		repo.save(book2);
		//now you should be able to access the test-data
		//with the endpoint h2-console
			return null;
	}

}
