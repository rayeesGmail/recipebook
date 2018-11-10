package me.shaikhrayeesahmed.recipebook.repositories;

import me.shaikhrayeesahmed.recipebook.domains.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngrdientRepository extends JpaRepository<Ingredient, Long> {
}
