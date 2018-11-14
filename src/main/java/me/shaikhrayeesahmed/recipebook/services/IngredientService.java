package me.shaikhrayeesahmed.recipebook.services;

import me.shaikhrayeesahmed.recipebook.domains.Ingredient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

public interface IngredientService {

    Resources<Resource<Ingredient>> findAll(Long recipeid);

    Resource<Ingredient> find(Long recipeid, Long ingredientid);

    Resource<Ingredient> save(Long recipeid, Ingredient ingredient);

    Resource<Ingredient> update(Long recipeid, Long ingredientid, Ingredient ingredient);

    void delete(Long recipeid, Long ingredientid);

}
