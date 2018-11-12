package me.shaikhrayeesahmed.recipebook.domains;

import org.springframework.hateoas.core.Relation;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Relation(collectionRelation = "units")
public class UnitOfMeasure extends BaseEntity {

    private String name;
    private String description;

    @OneToOne(mappedBy = "unitOfMeasure")
    private Ingredient ingredient;

    public UnitOfMeasure() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
