package me.shaikhrayeesahmed.recipebook.services;

import me.shaikhrayeesahmed.recipebook.assemblers.CategoryResourceAssembler;
import me.shaikhrayeesahmed.recipebook.controllers.CategoryController;
import me.shaikhrayeesahmed.recipebook.domains.Category;
import me.shaikhrayeesahmed.recipebook.repositories.CategoryRepository;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryResourceAssembler categoryResourceAssembler;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryResourceAssembler categoryResourceAssembler) {
        this.categoryRepository = categoryRepository;
        this.categoryResourceAssembler = categoryResourceAssembler;
    }

    @Override
    public Resources<Resource<Category>> findAll() {

        Set<Resource<Category>> resources = StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
                .map(categoryResourceAssembler::toResource)
                .collect(Collectors.toSet());

        return new Resources<>(resources, linkTo(methodOn(CategoryController.class).all()).withSelfRel());

    }


}
