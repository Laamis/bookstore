package hh.swd20.bookstore;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import hh.swd20.bookstore.domain.CategoryRepository;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTests {

	@Autowired
	private CategoryRepository cRepo;

	// testing creation of a category-entity
	@Test
	public void createCategoryTest() {
		Category category = new Category("Cooking");
		// we can use crud-operations provided by jpa
		cRepo.save(category);
		assertThat(category.getCategoryId()).isNotNull();
	}

	// testing updating the category-entity's name
	@Test
	public void saveShouldUpdateCategory() {
		Category category = new Category("Cooking");
		category.setName("Fishing");
		assertThat(category.getName()).isEqualTo("Fishing");
	}

	// testing finding category by name
	@Test
	public void findByNameShouldReturnCategory() {
		Category category = new Category("Cooking");
		cRepo.save(category);
		List<Category> categories = cRepo.findByName("Cooking");
		assertThat(categories).hasSize(1);
	}

	@Test
	public void deleteCategoryTest() {
		Category category = new Category("Cooking");
		cRepo.save(category);
		List<Category> categories = cRepo.findByName("Cooking");
		assertThat(categories).hasSize(1);

		cRepo.deleteById(categories.get(0).getCategoryId());
		categories = cRepo.findByName("Cooking");
		assertThat(categories).hasSize(0);

		// cRepo.deleteById(category.getCategoryId());
		// assertThat(cRepo.findAll()).isNull();

	}
}