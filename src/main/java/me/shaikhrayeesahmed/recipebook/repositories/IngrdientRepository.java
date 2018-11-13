package me.shaikhrayeesahmed.recipebook.repositories;

import me.shaikhrayeesahmed.recipebook.domains.Ingredient;
import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngrdientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAllByRecipe(Recipe recipe);

}
