package me.shaikhrayeesahmed.recipebook.bootstrap;

import me.shaikhrayeesahmed.recipebook.domains.*;
import me.shaikhrayeesahmed.recipebook.repositories.CategoryRepository;
import me.shaikhrayeesahmed.recipebook.repositories.RecipeRepository;
import me.shaikhrayeesahmed.recipebook.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeRepository recipeRepository;

    public Bootstrap(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository,
                     RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Category indian = new Category();
        indian.setName("Indian");
        indian.setDescription("Cuisen of Indian Sub Continent");

        categoryRepository.save(indian);

        Category hyderabadi = new Category();
        hyderabadi.setName("Hyderabadi");
        hyderabadi.setDescription("Cusine from the city of nizam Hyderabad");

        categoryRepository.save(hyderabadi);

        UnitOfMeasure litter = new UnitOfMeasure();
        litter.setName("Litter");
        litter.setDescription("Litter is a unit of measure used to measure liquids");

        UnitOfMeasure kilo = new UnitOfMeasure();
        kilo.setName("Kilo Gram");
        kilo.setDescription("Kilo Gram is unit of measure used to measure solids");

        List<UnitOfMeasure> unitOfMeasures = new ArrayList<>();
        unitOfMeasures.add(litter);
        unitOfMeasures.add(kilo);

        unitOfMeasureRepository.saveAll(unitOfMeasures);

        Ingredient water = new Ingredient();
        water.setName("Water");
        water.setDescription("warm water");
        water.setUnitOfMeasure(litter);
        water.setAmount(1);

        Ingredient rice = new Ingredient();
        rice.setName("Rice");
        rice.setDescription("Basmati Rice");
        rice.setAmount(1);
        rice.setUnitOfMeasure(kilo);

        Ingredient oil = new Ingredient();

        oil.setName("Oil");
        oil.setDescription("Refined Oil");
        oil.setUnitOfMeasure(litter);
        oil.setAmount(1);

        Note note = new Note();
        note.setNo(1);
        note.setDetails("light up the gas stow and put a clean dish on it");

        Note note2 = new Note();
        note2.setNo(2);
        note2.setDetails("Pour some oil into the dish");

        Recipe biryani = new Recipe();
        biryani.setTitle("Hyderabadi Biryani");
        biryani.setDescrition("Special Dish brought you from the city of nizam Hyderabad.");

        biryani.getIngredients().add(water);
        biryani.getIngredients().add(oil);
        biryani.getIngredients().add(rice);

        water.setRecipe(biryani);
        oil.setRecipe(biryani);
        rice.setRecipe(biryani);

        biryani.getNotes().add(note);
        biryani.getNotes().add(note2);

        note.setRecipe(biryani);
        note2.setRecipe(biryani);

        biryani.getCategories().add(indian);
        biryani.getCategories().add(hyderabadi);

        indian.getRecipes().add(biryani);
        hyderabadi.getRecipes().add(biryani);

        System.out.println("Loading data");

        recipeRepository.save(biryani);

        System.out.println("Data loaded successfully.");

    }



}
