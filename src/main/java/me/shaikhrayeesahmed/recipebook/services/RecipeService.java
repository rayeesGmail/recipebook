package me.shaikhrayeesahmed.recipebook.services;

import me.shaikhrayeesahmed.recipebook.domains.Category;
import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import me.shaikhrayeesahmed.recipebook.dtos.RecipeDTO;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

public interface RecipeService {

    Resources<Resource<Recipe>> findAll();

    Resources<Resource<Category>> findAllCategories(Long id);

    Resource<RecipeDTO> find(Long id);

    Resource<Recipe> create(Recipe recipe);

}
