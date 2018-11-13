package me.shaikhrayeesahmed.recipebook.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.core.Relation;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Relation(collectionRelation = "recipes")
public class Recipe extends BaseEntity {

    private String title;
    private String description;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<Note> notes = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany
    @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public Recipe() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
        for(Ingredient ingredient : ingredients){
            ingredient.setRecipe(this);
        }
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
        for(Note note : notes){
            note.setRecipe(this);
        }
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

}
