package hh.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository cRepo;
	
	@GetMapping("/categorylist")
	public String getCategories(Model model) {
		
		model.addAttribute("categories", cRepo.findAll());
		return "categorylist";
	}
	
	@RequestMapping("/newcategory")
	public String newCategory(Model model) {
		model.addAttribute("category", new Category());
		return "newcategory";
	}
	@PostMapping("/savecategory")
	public String save(Category category) {
		cRepo.save(category);
		return "redirect:/categorylist";
	}
}
