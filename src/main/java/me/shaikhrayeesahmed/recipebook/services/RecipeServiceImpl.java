package me.shaikhrayeesahmed.recipebook.services;

import me.shaikhrayeesahmed.recipebook.assemblers.CategoryResourceAssembler;
import me.shaikhrayeesahmed.recipebook.assemblers.RecipeResourceAssembler;
import me.shaikhrayeesahmed.recipebook.controllers.CategoryController;
import me.shaikhrayeesahmed.recipebook.controllers.RecipeController;
import me.shaikhrayeesahmed.recipebook.domains.Category;
import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import me.shaikhrayeesahmed.recipebook.dtos.RecipeDTO;
import me.shaikhrayeesahmed.recipebook.repositories.CategoryRepository;
import me.shaikhrayeesahmed.recipebook.repositories.RecipeRepository;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeResourceAssembler recipeResourceAssembler;

    private final CategoryRepository categoryRepository;
    private final CategoryResourceAssembler categoryResourceAssembler;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeResourceAssembler recipeResourceAssembler, CategoryRepository categoryRepository, CategoryResourceAssembler categoryResourceAssembler) {
        this.recipeRepository = recipeRepository;
        this.recipeResourceAssembler = recipeResourceAssembler;
        this.categoryRepository = categoryRepository;
        this.categoryResourceAssembler = categoryResourceAssembler;
    }

    @Override
    public Resources<Resource<Recipe>> findAll() {
        Set<Resource<Recipe>> resources = recipeRepository.findAll().stream()
                .map(recipeResourceAssembler::toResource)
                .collect(Collectors.toSet());

        return new Resources<>(resources, linkTo(methodOn(RecipeController.class).all()).withSelfRel());
    }

    private Resources<Resource<Category>> findAllByRecipes(Set<Recipe> recipes) {

        Set<Resource<Category>> resources = StreamSupport.stream(categoryRepository.findByRecipes(recipes).spliterator(), false)
                .map(categoryResourceAssembler::toResource)
                .collect(Collectors.toSet());

        return new Resources<>(resources, linkTo(methodOn(CategoryController.class).all()).withRel("categories"),
                linkTo(methodOn(RecipeController.class).all()).withRel("recipes"));
    }

    @Override
    public Resources<Resource<Category>> findAllCategories(Long id) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);

        if(!optionalRecipe.isPresent()){
            throw new RuntimeException("entity not found");
        }
        else {
            Set<Recipe> recipes = new HashSet<>();
            recipes.add(optionalRecipe.get());
            return findAllByRecipes(recipes);
        }
    }


    @Override
    public Resource<RecipeDTO> find(Long id) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);

        if(!optionalRecipe.isPresent()){
            throw new RuntimeException("entity not found");
        }
        else {

            Recipe recipe = optionalRecipe.get();

            RecipeDTO recipeDTO = new RecipeDTO(recipe.getId(), recipe.getTitle(), recipe.getDescription(),
                    recipe.getIngredients(), recipe.getNotes());


            return recipeResourceAssembler.toResource(recipeDTO);

        }

    }


    @Transactional
    @Override
    public Resource<Recipe> create(Recipe recipe) {
        return recipeResourceAssembler.toResource(recipeRepository.save(recipe));
    }

}
