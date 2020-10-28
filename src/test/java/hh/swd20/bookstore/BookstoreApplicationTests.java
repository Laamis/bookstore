package hh.swd20.bookstore;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import hh.swd20.bookstore.web.BookstoreController;
import hh.swd20.bookstore.web.CategoryController;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {

//This class contains smoke tests for different controllers
	// for bookstorecontroller:
	@Autowired
	private BookstoreController bCont;

	@Test
	public void contextLoadsBCont() throws Exception {
		assertThat(bCont).isNotNull();
	}

	// for categorycontroller:
	@Autowired
	private CategoryController cCont;

	@Test
	public void contextLoadsCCont() throws Exception {
		assertThat(cCont).isNotNull();

	}

}
