package hh.swd20.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.CategoryRepository;

@Controller
public class BookstoreController {
	@Autowired
	private BookRepository repo;
	
	@Autowired
	private CategoryRepository cRepo;
	
	@GetMapping("/index")
	public String indexPage(Model model) {
		model.addAttribute("books", repo.findAll());		
		return "bookstore";
	}
	
	//REST-API that returns all books as a json
	@GetMapping("/books")
	public @ResponseBody List<Book> apiList(Model model) {
		return (List<Book>) repo.findAll();
	}
	
	
	//REST-API that returns a single book by id 
	@GetMapping("/books/{id}")
	public @ResponseBody Optional<Book> getBookRest(@PathVariable("id")Long id){
		return repo.findById(id);
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		repo.deleteById(id);
		
	
		return "redirect:/index";
	}
	
	@RequestMapping("/newbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", cRepo.findAll());
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
		model.addAttribute("categories", cRepo.findAll());
		return "update";
		
	}
}
