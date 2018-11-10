package me.shaikhrayeesahmed.recipebook.controllers;

import me.shaikhrayeesahmed.recipebook.domains.Category;
import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import me.shaikhrayeesahmed.recipebook.services.RecipeService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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



}
