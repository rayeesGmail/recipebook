package me.shaikhrayeesahmed.recipebook.repositories;

import me.shaikhrayeesahmed.recipebook.domains.Ingredient;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IngrdientRepository extends PagingAndSortingRepository<Ingredient, Long> {
}
