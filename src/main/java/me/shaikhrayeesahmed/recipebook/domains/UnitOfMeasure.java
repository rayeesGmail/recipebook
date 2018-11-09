package me.shaikhrayeesahmed.recipebook.domains;

import javax.persistence.Entity;

@Entity
public class UnitOfMeasure extends BaseEntity {

    private String name;
    private String descrition;

    public UnitOfMeasure() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

}
