package me.shaikhrayeesahmed.recipebook.services;

import me.shaikhrayeesahmed.recipebook.assemblers.UnitOfMeasureResourceAssembler;
import me.shaikhrayeesahmed.recipebook.controllers.UnitOfMeasureController;
import me.shaikhrayeesahmed.recipebook.domains.UnitOfMeasure;
import me.shaikhrayeesahmed.recipebook.repositories.UnitOfMeasureRepository;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureResourceAssembler unitOfMeasureResourceAssembler;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasureResourceAssembler unitOfMeasureResourceAssembler) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureResourceAssembler = unitOfMeasureResourceAssembler;
    }

    @Override
    public Resources<Resource<UnitOfMeasure>> findAll() {
        Set<Resource<UnitOfMeasure>> resources = unitOfMeasureRepository.findAll().stream()
                .map(unitOfMeasureResourceAssembler::toResource)
                .collect(Collectors.toSet());

        return new Resources<>(resources, linkTo(methodOn(UnitOfMeasureController.class).all()).withSelfRel());
    }


    @Override
    public Resource<UnitOfMeasure> find(Long id) {

        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findById(id);

        if(!optionalUnitOfMeasure.isPresent()){
            throw new RuntimeException("entity not found");
        }

        return unitOfMeasureResourceAssembler.toResource(optionalUnitOfMeasure.get());

    }

    @Override
    public Resource<UnitOfMeasure> save(UnitOfMeasure unitOfMeasure) {
        return unitOfMeasureResourceAssembler.toResource(unitOfMeasureRepository.save(unitOfMeasure));
    }

}
