package me.shaikhrayeesahmed.recipebook.assemblers;

import me.shaikhrayeesahmed.recipebook.controllers.UnitOfMeasureController;
import me.shaikhrayeesahmed.recipebook.domains.UnitOfMeasure;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class UnitOfMeasureResourceAssembler implements ResourceAssembler<UnitOfMeasure, Resource<UnitOfMeasure>> {

    @Override
    public Resource<UnitOfMeasure> toResource(UnitOfMeasure unitOfMeasure) {
        return new Resource<>(unitOfMeasure,
                linkTo(methodOn(UnitOfMeasureController.class).one(unitOfMeasure.getId())).withSelfRel(),
                linkTo(methodOn(UnitOfMeasureController.class).all()).withRel("units"));
    }

}
