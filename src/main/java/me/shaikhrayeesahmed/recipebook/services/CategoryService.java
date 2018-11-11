package me.shaikhrayeesahmed.recipebook.services;

import me.shaikhrayeesahmed.recipebook.domains.Category;
import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

public interface CategoryService {

    Resources<Resource<Category>> findAll();

    Resources<Resource<Recipe>> findAllRecipes(Long id);

    Resource<Category> save(Category category);

}
