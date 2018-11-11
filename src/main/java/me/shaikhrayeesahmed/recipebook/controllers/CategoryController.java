package me.shaikhrayeesahmed.recipebook.controllers;

import me.shaikhrayeesahmed.recipebook.domains.Category;
import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import me.shaikhrayeesahmed.recipebook.services.CategoryService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public Resources<Resource<Category>> all(){
        return categoryService.findAll();
    }

    @GetMapping("/categories/{id}/recipes")
    public Resources<Resource<Recipe>> recipes(@PathVariable Long id){

        return categoryService.findAllRecipes(id);

    }

    @PostMapping("/categories")
    public ResponseEntity<Resource<Category>> create(@RequestBody Category category) throws URISyntaxException {
        Resource<Category> resource = categoryService.save(category);
        return new ResponseEntity<>(resource, HttpStatus.CREATED);
    }



}
