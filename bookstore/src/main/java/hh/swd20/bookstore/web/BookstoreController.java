package hh.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

@Controller
public class BookstoreController {
	@Autowired
	private BookRepository repo;
	
	@GetMapping("/index")
	public String indexPage(Model model) {
		model.addAttribute("books", repo.findAll());		
		return "bookstore";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		repo.deleteById(id);
		
	
		return "redirect:/index";
	}
	
	@RequestMapping("/newbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "newbook";
	}
	
	@PostMapping("/save")
	public String save(Book book) {
		repo.save(book);
		return "redirect:/index";
	}
	@RequestMapping("/update/{id}")
	public String update(@PathVariable("id")Long id, Model model) {
		model.addAttribute("book", repo.findById(id));
		return "update";
		
	}
}
