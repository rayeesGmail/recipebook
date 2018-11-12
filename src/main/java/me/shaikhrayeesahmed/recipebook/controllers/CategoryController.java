package me.shaikhrayeesahmed.recipebook.controllers;

import me.shaikhrayeesahmed.recipebook.domains.Category;
import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import me.shaikhrayeesahmed.recipebook.services.CategoryService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Resource<Category>> create(@RequestBody Category category) {
        Resource<Category> resource = categoryService.save(category);
        return new ResponseEntity<>(resource, HttpStatus.CREATED);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Resource<Category>> update(@PathVariable Long id, @RequestBody Category category) {
        return new ResponseEntity<>(categoryService.update(id, category), HttpStatus.CREATED);
    }

    @DeleteMapping("/categories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }


}
