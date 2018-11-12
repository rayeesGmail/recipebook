package me.shaikhrayeesahmed.recipebook.assemblers;

import me.shaikhrayeesahmed.recipebook.controllers.CategoryController;
import me.shaikhrayeesahmed.recipebook.domains.Category;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class CategoryResourceAssembler implements ResourceAssembler<Category, Resource<Category>> {

    @Override
    public Resource<Category> toResource(Category category) {
        return new Resource<>(category,
                linkTo(methodOn(CategoryController.class).one(category.getId())).withSelfRel(),
                linkTo(methodOn(CategoryController.class).recipes(category.getId())).withRel("recipes"),
                linkTo(methodOn(CategoryController.class).all()).withRel("categories"));
    }

}
