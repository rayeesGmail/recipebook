package me.shaikhrayeesahmed.recipebook.repositories;

import me.shaikhrayeesahmed.recipebook.domains.UnitOfMeasure;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UnitOfMeasureRepository extends PagingAndSortingRepository<UnitOfMeasure, Long> {
}
