package me.shaikhrayeesahmed.recipebook.assemblers;

import me.shaikhrayeesahmed.recipebook.domains.UnitOfMeasure;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;

public class UnitOfMeasureResourceAssembler implements ResourceAssembler<UnitOfMeasure, Resource<UnitOfMeasure>> {

    @Override
    public Resource<UnitOfMeasure> toResource(UnitOfMeasure unitOfMeasure) {
        return null;
    }
}
