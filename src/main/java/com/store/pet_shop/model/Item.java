package com.store.pet_shop.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id; //id товара

    @NotBlank
    private String type; //тип товара

    @NotBlank
    private String name; //название товара

    @NotBlank
    private String cost; //стоимость товара

    public Item(){
        super();
    }

    public Item(@NotBlank String type, @NotBlank String name, @NotBlank String cost) {
        super();
        this.type = type;
        this.name = name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", type= " + type + ", name=" + name + ", cost=" + cost + '}';
    }
}
