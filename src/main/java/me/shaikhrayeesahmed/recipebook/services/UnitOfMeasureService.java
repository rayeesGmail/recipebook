package me.shaikhrayeesahmed.recipebook.services;

import me.shaikhrayeesahmed.recipebook.domains.UnitOfMeasure;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

public interface UnitOfMeasureService {

    Resources<Resource<UnitOfMeasure>> findAll();

    Resource<UnitOfMeasure> find(Long id);

    Resource<UnitOfMeasure> save(UnitOfMeasure unitOfMeasure);

    Resource<UnitOfMeasure> update(Long id, UnitOfMeasure unitOfMeasure);

    void delete(Long id);

}
