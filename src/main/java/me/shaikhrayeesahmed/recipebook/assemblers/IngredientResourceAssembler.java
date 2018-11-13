package me.shaikhrayeesahmed.recipebook.assemblers;

import me.shaikhrayeesahmed.recipebook.controllers.IngredientController;
import me.shaikhrayeesahmed.recipebook.domains.Ingredient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class IngredientResourceAssembler implements ResourceAssembler<Ingredient, Resource<Ingredient>> {

    @Override
    public Resource<Ingredient> toResource(Ingredient ingredient) {
        return new Resource<>(ingredient,
                linkTo(methodOn(IngredientController.class).one(ingredient.getRecipe().getId(), ingredient.getId())).withSelfRel());
    }

}
