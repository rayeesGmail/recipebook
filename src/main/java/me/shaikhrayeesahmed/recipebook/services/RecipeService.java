package me.shaikhrayeesahmed.recipebook.services;

import me.shaikhrayeesahmed.recipebook.domains.Category;
import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

public interface RecipeService {

    Resources<Resource<Recipe>> findAll();

    Resources<Resource<Category>> findAllCategories(Long id);

    Resource<Recipe> find(Long id);

    Resource<Recipe> create(Recipe recipe);

    Resource<Recipe> update(Long id, Recipe recipe);

    void delete(Long id);

}
