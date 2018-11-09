package me.shaikhrayeesahmed.recipebook.services;

import me.shaikhrayeesahmed.recipebook.domains.Category;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

public interface CategoryService {

    Resources<Resource<Category>> findAll();

}
