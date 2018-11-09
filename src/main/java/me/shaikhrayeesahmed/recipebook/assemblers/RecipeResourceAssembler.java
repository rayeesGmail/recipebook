package me.shaikhrayeesahmed.recipebook.assemblers;

import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;

public class RecipeResourceAssembler implements ResourceAssembler<Recipe, Resource<Recipe>> {

    @Override
    public Resource<Recipe> toResource(Recipe recipe) {
        return null;
    }

}
