package me.shaikhrayeesahmed.recipebook.services;

import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

public interface RecipeService {

    Resources<Resource<Recipe>> findAll();

}
