package me.shaikhrayeesahmed.recipebook.controllers;

import me.shaikhrayeesahmed.recipebook.domains.Ingredient;
import me.shaikhrayeesahmed.recipebook.services.IngredientService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/recipes/{recipeid}/ingredients")
    public ResponseEntity<Resources<Resource<Ingredient>>> all(@PathVariable Long recipeid){
        return new ResponseEntity<>(ingredientService.findAll(recipeid), HttpStatus.OK);
    }

    @GetMapping("recipes/{recipeid}/ingredients/{ingredientid}")
    public ResponseEntity<Resource<Ingredient>> one(@PathVariable Long recipeid, @PathVariable Long ingredientid){
        Resource<Ingredient> resource = ingredientService.find(recipeid, ingredientid);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }


    @PutMapping("recipes/{recipeid}/ingredients/{ingredientid}")
    public ResponseEntity<Resource<Ingredient>> update(@PathVariable Long recipeid, @PathVariable Long ingredientid,
                                                       @RequestBody Ingredient ingredient){
        return new ResponseEntity<>(ingredientService.update(recipeid, ingredientid, ingredient), HttpStatus.CREATED);
    }


    @DeleteMapping("recipes/{recipeid}/ingredients/{ingredientid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long recipeid, @PathVariable Long ingredientid){
        ingredientService.delete(recipeid, ingredientid);
    }





}
