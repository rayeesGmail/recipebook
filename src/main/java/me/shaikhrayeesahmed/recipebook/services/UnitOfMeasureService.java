package me.shaikhrayeesahmed.recipebook.services;

import me.shaikhrayeesahmed.recipebook.domains.UnitOfMeasure;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

public interface UnitOfMeasureService {

    Resources<Resource<UnitOfMeasure>> findAll();

    Resource<UnitOfMeasure> save(UnitOfMeasure unitOfMeasure);


}
