package me.shaikhrayeesahmed.recipebook.assemblers;

import me.shaikhrayeesahmed.recipebook.domains.Category;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;

public class CategoryResourceAssembler implements ResourceAssembler<Category, Resource<Category>> {

    @Override
    public Resource<Category> toResource(Category category) {
        return null;
    }
}
