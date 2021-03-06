package me.shaikhrayeesahmed.recipebook.services;

import me.shaikhrayeesahmed.recipebook.assemblers.CategoryResourceAssembler;
import me.shaikhrayeesahmed.recipebook.assemblers.RecipeResourceAssembler;
import me.shaikhrayeesahmed.recipebook.controllers.CategoryController;
import me.shaikhrayeesahmed.recipebook.controllers.RecipeController;
import me.shaikhrayeesahmed.recipebook.domains.Category;
import me.shaikhrayeesahmed.recipebook.domains.Recipe;
import me.shaikhrayeesahmed.recipebook.repositories.CategoryRepository;
import me.shaikhrayeesahmed.recipebook.repositories.RecipeRepository;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryResourceAssembler categoryResourceAssembler;

    private final RecipeRepository recipeRepository;
    private final RecipeResourceAssembler recipeResourceAssembler;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryResourceAssembler categoryResourceAssembler, RecipeRepository recipeRepository, RecipeResourceAssembler recipeResourceAssembler) {
        this.categoryRepository = categoryRepository;
        this.categoryResourceAssembler = categoryResourceAssembler;
        this.recipeRepository = recipeRepository;
        this.recipeResourceAssembler = recipeResourceAssembler;
    }

    @Override
    public Resources<Resource<Category>> findAll() {

        Set<Resource<Category>> resources = StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
                .map(categoryResourceAssembler::toResource)
                .collect(Collectors.toSet());

        return new Resources<>(resources, linkTo(methodOn(CategoryController.class).all()).withSelfRel());

    }


    @Override
    public Resource<Category> find(Long id) {

        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if(!optionalCategory.isPresent()){
            throw new RuntimeException("no entity found");
        }

        return categoryResourceAssembler.toResource(optionalCategory.get());
    }

    private Resources<Resource<Recipe>> findAllByCategories(Set<Category> categories) {

        Set<Resource<Recipe>> resources = recipeRepository.findByCategories(categories).stream()
                .map(recipeResourceAssembler::toResource)
                .collect(Collectors.toSet());

        return new Resources<>(resources, linkTo(methodOn(RecipeController.class).all()).withRel("recipes"),
                linkTo(methodOn(CategoryController.class).all()).withRel("categories"));
    }

    @Override
    public Resources<Resource<Recipe>> findAllRecipes(Long id) {
         Optional<Category> optionalCategory = categoryRepository.findById(id);

         if(!optionalCategory.isPresent()){
             throw new RuntimeException("Entity Not found");
         }
         else {

             Set<Category> categories = new HashSet<>();
             categories.add(optionalCategory.get());

             return findAllByCategories(categories);

         }

    }


    @Override
    public Resource<Category> save(Category category) {
        return categoryResourceAssembler.toResource(categoryRepository.save(category));
    }

    @Override
    public Resource<Category> update(Long id, Category category) {
        category.setId(id);
        return categoryResourceAssembler.toResource(categoryRepository.save(category));
    }

    @Override
    @Transactional
    public void delete(Long id) {

        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if(!optionalCategory.isPresent()){
            throw new RuntimeException("no entity found");
        }

        Category category = optionalCategory.get();

        Set<Recipe> recipes = category.getRecipes();

        for(Recipe recipe : recipes){
            recipe.getCategories().remove(category);
        }

        categoryRepository.delete(category);

    }

}
