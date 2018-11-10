package me.shaikhrayeesahmed.recipebook.assemblers;

import me.shaikhrayeesahmed.recipebook.controllers.RecipeController;
import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class RecipeResourceAssembler implements ResourceAssembler<Recipe, Resource<Recipe>> {

    @Override
    public Resource<Recipe> toResource(Recipe recipe) {
        return new Resource<>(recipe, linkTo(methodOn(RecipeController.class).categories(recipe.getId())).withRel("categories"),
                linkTo(methodOn(RecipeController.class).all()).withRel("recipes"));
    }

}
