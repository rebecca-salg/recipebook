package se.group2.Recepies;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class RecepiesApplicationTests {

	@Autowired
	RecipeRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	void testSearch() {
		List<Recipe> results = repository.findByTitleIgnoreCase("spaghetti");
		Assert.hasText("spaghetti", results.get(0).getTitle());

		results = repository.findByTitleIgnoreCase("rabarber");
		Assert.isTrue("Rabarberpaj med sås".equals(results.get(0).getTitle()), "Checking that title matches");
	}

	@Test
	void testAddRecipe() {
		Recipe recipe = new Recipe();
		repository.save(recipe);
	}
}
