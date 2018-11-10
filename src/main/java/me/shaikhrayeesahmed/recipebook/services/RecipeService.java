package me.shaikhrayeesahmed.recipebook.services;

import me.shaikhrayeesahmed.recipebook.domains.Category;
import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import java.util.Set;

public interface RecipeService {

    Resources<Resource<Recipe>> findAll();

    Resources<Resource<Recipe>> findAllByCategories(Set<Category> categories);

}
