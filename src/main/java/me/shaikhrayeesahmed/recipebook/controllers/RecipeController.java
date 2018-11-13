package me.shaikhrayeesahmed.recipebook.controllers;

import me.shaikhrayeesahmed.recipebook.domains.Category;
import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import me.shaikhrayeesahmed.recipebook.services.RecipeService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes")
    public Resources<Resource<Recipe>> all(){
        return recipeService.findAll();
    }


    @GetMapping("/recipes/{id}/categories")
    public Resources<Resource<Category>> categories(@PathVariable Long id){
        return recipeService.findAllCategories(id);
    }

    @GetMapping("/recipes/{id}")
    public Resource<Recipe> one(@PathVariable Long id){
        return recipeService.find(id);
    }

    @PostMapping("/recipes")
    public ResponseEntity<Resource<Recipe>> create(@RequestBody Recipe recipe){
        return new ResponseEntity<>(recipeService.create(recipe), HttpStatus.CREATED);
    }

    @PutMapping("/recipes/{id}")
    public ResponseEntity<Resource<Recipe>> update(@PathVariable Long id, @RequestBody Recipe recipe){
        return new ResponseEntity<>(recipeService.update(id, recipe), HttpStatus.CREATED);
    }

    @DeleteMapping("/recipes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        recipeService.delete(id);
    }




}
