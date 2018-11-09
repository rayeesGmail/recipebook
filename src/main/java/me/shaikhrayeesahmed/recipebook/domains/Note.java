package me.shaikhrayeesahmed.recipebook.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.core.Relation;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Relation(collectionRelation = "notes")
public class Note extends BaseEntity {

    private int no;
    private String details;

    @JsonIgnore
    @ManyToOne
    private Recipe recipe;

    public Note() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
