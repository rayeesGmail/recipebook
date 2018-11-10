package me.shaikhrayeesahmed.recipebook.services;

import me.shaikhrayeesahmed.recipebook.assemblers.RecipeResourceAssembler;
import me.shaikhrayeesahmed.recipebook.controllers.RecipeController;
import me.shaikhrayeesahmed.recipebook.domains.Category;
import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import me.shaikhrayeesahmed.recipebook.repositories.RecipeRepository;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeResourceAssembler recipeResourceAssembler;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeResourceAssembler recipeResourceAssembler) {
        this.recipeRepository = recipeRepository;
        this.recipeResourceAssembler = recipeResourceAssembler;
    }

    @Override
    public Resources<Resource<Recipe>> findAll() {
        Set<Resource<Recipe>> resources = recipeRepository.findAll().stream()
                .map(recipeResourceAssembler::toResource)
                .collect(Collectors.toSet());

        return new Resources<>(resources, linkTo(methodOn(RecipeController.class).all()).withSelfRel());
    }

    @Override
    public Resources<Resource<Recipe>> findAllByCategories(Set<Category> categories) {

        Set<Resource<Recipe>> resources = recipeRepository.findByCategories(categories).stream()
                .map(recipeResourceAssembler::toResource)
                .collect(Collectors.toSet());

        return new Resources<>(resources);

    }
}