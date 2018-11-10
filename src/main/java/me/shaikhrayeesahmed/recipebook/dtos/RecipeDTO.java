package me.shaikhrayeesahmed.recipebook.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.shaikhrayeesahmed.recipebook.domains.Ingredient;
import me.shaikhrayeesahmed.recipebook.domains.Note;

import java.util.HashSet;
import java.util.Set;

public class RecipeDTO {

    @JsonIgnore
    private Long id;

    private String title;
    private String description;

    private Set<Ingredient> ingredients = new HashSet<>();

    private Set<Note> notes = new HashSet<>();


    public RecipeDTO(Long id, String title, String description, Set<Ingredient> ingredients, Set<Note> notes) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public Set<Note> getNotes() {
        return notes;
    }

}
