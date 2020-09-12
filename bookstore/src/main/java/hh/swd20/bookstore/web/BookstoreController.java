package hh.swd20.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import domain.Book;

@Controller
public class BookstoreController {
	@GetMapping("/index")
	public String indexPage(Model model) {
		// let's add thymeleaf stuff
		Book hp1 = new Book("Harry Potter,", "J.K. Rowling", 2003, "12323-13234-21", 12.90);
		model.addAttribute("book1", hp1.toString());
		return "bookstore";
	}

}
