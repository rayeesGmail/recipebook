package me.shaikhrayeesahmed.recipebook.services;

import me.shaikhrayeesahmed.recipebook.assemblers.IngredientResourceAssembler;
import me.shaikhrayeesahmed.recipebook.controllers.IngredientController;
import me.shaikhrayeesahmed.recipebook.controllers.RecipeController;
import me.shaikhrayeesahmed.recipebook.domains.Ingredient;
import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import me.shaikhrayeesahmed.recipebook.repositories.IngrdientRepository;
import me.shaikhrayeesahmed.recipebook.repositories.RecipeRepository;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final RecipeRepository recipeRepository;
    private final IngrdientRepository ingrdientRepository;
    private final IngredientResourceAssembler ingredientResourceAssembler;

    public IngredientServiceImpl(RecipeRepository recipeRepository, IngrdientRepository ingrdientRepository,
                                 IngredientResourceAssembler ingredientResourceAssembler) {
        this.recipeRepository = recipeRepository;
        this.ingrdientRepository = ingrdientRepository;
        this.ingredientResourceAssembler = ingredientResourceAssembler;
    }


    @Override
    public Resources<Resource<Ingredient>> findAll(Long recipeid) {

        Optional<Recipe> optionalRecipe = recipeRepository.findById(recipeid);

        if(!optionalRecipe.isPresent()){
            throw new RuntimeException("entity not present");
        }

        Set<Resource<Ingredient>> resources = ingrdientRepository.findAllByRecipe(optionalRecipe.get())
                .stream()
                .map(ingredientResourceAssembler::toResource)
                .collect(Collectors.toSet());

        return new Resources<>(resources,
                linkTo(methodOn(IngredientController.class).all(recipeid)).withSelfRel(),
                linkTo(methodOn(RecipeController.class).one(recipeid)).withRel("recipe"));
    }

    @Override
    public Resource<Ingredient> find(Long recipeid, Long ingredientid) {
        Optional<Ingredient> optionalIngredient = ingrdientRepository.findById(ingredientid);
        if(!optionalIngredient.isPresent()){
            throw new RuntimeException("Entity not found");
        }
        return ingredientResourceAssembler.toResource(optionalIngredient.get());
    }

    @Override
    public Resource<Ingredient> update(Long recipeid, Long ingredientid, Ingredient ingredient) {
        ingredient.setId(ingredientid);

        Optional<Recipe> optionalRecipe = recipeRepository.findById(recipeid);

        if(!optionalRecipe.isPresent()){
            throw new RuntimeException("no entity found");
        }

        ingredient.setRecipe(optionalRecipe.get());

        return ingredientResourceAssembler.toResource(ingrdientRepository.save(ingredient));
    }

    @Override
    public void delete(Long recipeid, Long ingredientid) {
        ingrdientRepository.deleteById(ingredientid);
    }

}
