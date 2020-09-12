package hh.swd20.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class BookstoreController {
	@RequestMapping("/index")
	public String indexPage() {
		// Thymeleaf-module is included in the project.
		// Currrently index only returns this string, but in the future, the site will
		// be Thymeleaf capable.
		return "This is the index-page for a bookstore!";
	}

}
