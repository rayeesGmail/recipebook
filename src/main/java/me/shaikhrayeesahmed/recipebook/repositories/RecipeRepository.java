package me.shaikhrayeesahmed.recipebook.repositories;

import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RecipeRepository extends PagingAndSortingRepository<Recipe, Long> {
}
