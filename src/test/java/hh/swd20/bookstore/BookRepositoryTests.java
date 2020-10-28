package hh.swd20.bookstore;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTests {
	
	@Autowired
	private BookRepository bRepo;
	
	
	
	//tests whether a book is created or not 
	@Test
	public void createBookTest() {
	Book book = new  Book("book1","author1", 2000, "123-456-678", 20.00, null);
	bRepo.save(book);
	assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void findByTitleShouldReturnBook() {
		Book book = new  Book("book1","author1", 2000, "123-456-678", 20.00, null);
		bRepo.save(book);
		List<Book> books = bRepo.findByTitle("book1");
		assertThat(books).hasSize(1);
		}
	@Test
	public void deleteCategoryTest() {
		Book book = new  Book("book1","author1", 2000, "123-456-678", 20.00, null);
		bRepo.save(book);
		List<Book> books = bRepo.findByTitle("book1");
		assertThat(books).hasSize(1);
		
		//let's delete this from the repo
		bRepo.deleteById(books.get(0).getId());
		books = bRepo.findByTitle("book1");
		assertThat(books).hasSize(0);
		
	}
	
}
