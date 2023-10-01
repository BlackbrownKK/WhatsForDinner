package org.example.model;

import java.util.List;
import java.util.Map;

public class Dish {

    private String nameOfDosh;
    private Map<Ingredient, Double> ingredientList;

    public Dish(String nameOfDosh, Map<Ingredient, Double> ingredientList) {
        this.nameOfDosh = nameOfDosh;
        this.ingredientList = ingredientList;
    }

    public String getNameOfDosh() {
        return nameOfDosh;
    }

    public void setNameOfDosh(String nameOfDosh) {
        this.nameOfDosh = nameOfDosh;
    }

    public Map<Ingredient, Double> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(Map<Ingredient, Double> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
