package me.shaikhrayeesahmed.recipebook.services;

import me.shaikhrayeesahmed.recipebook.domains.Category;
import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

public interface CategoryService {

    Resources<Resource<Category>> findAll();

    Resource<Category> find(Long id);

    Resources<Resource<Recipe>> findAllRecipes(Long id);

    Resource<Category> save(Category category);

    Resource<Category> update(Long id, Category category);

    void delete(Long id);

}
