package me.shaikhrayeesahmed.recipebook.repositories;

import me.shaikhrayeesahmed.recipebook.domains.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
