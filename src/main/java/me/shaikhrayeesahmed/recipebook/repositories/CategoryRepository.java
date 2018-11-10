package me.shaikhrayeesahmed.recipebook.repositories;

import me.shaikhrayeesahmed.recipebook.domains.Category;
import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByRecipes(Set<Recipe> recipes);

}
