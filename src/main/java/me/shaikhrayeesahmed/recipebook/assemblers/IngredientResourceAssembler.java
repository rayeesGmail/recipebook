package me.shaikhrayeesahmed.recipebook.assemblers;

import me.shaikhrayeesahmed.recipebook.domains.Ingredient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;

public class IngredientResourceAssembler implements ResourceAssembler<Ingredient, Resource<Ingredient>> {

    @Override
    public Resource<Ingredient> toResource(Ingredient ingredient) {
        return null;
    }

}
