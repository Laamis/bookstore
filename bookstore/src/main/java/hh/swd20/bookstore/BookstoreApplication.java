package hh.swd20.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	//Commandlinerunner will add some test data to the db
	@Bean
	public CommandLineRunner demo(BookRepository bRepo, CategoryRepository cRepo) {
		Book book1 = new Book("Harry Potter ja Azkabanin vanki", "J.K. Rowling", 2006, "123986127", 17.90);
		Book book2 = new Book("Harry Potter ja kuoleman varjelukset", "J.K. Rowling", 2008, "12309785", 21.90);
		Category category1 = new Category("Science-Fiction");
		Category category2 = new Category("Fantasy");

		// Let's save the test data to the db
		bRepo.save(book1);
		bRepo.save(book2);
		cRepo.save(category1);
		cRepo.save(category2);
		//now you should be able to access the test-data
		//with the endpoint h2-console
			return null;
	}

}
