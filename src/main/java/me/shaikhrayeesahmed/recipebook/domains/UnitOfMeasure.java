package me.shaikhrayeesahmed.recipebook.domains;

import org.springframework.hateoas.core.Relation;

import javax.persistence.Entity;

@Entity
@Relation(collectionRelation = "units")
public class UnitOfMeasure extends BaseEntity {

    private String name;
    private String description;

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
