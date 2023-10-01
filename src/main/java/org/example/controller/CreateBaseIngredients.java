package org.example.controller;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.example.model.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateBaseIngredients {

    public void initialiseBaseIngredients() {
        CsvReader csvReader = new CsvReader();
        String[][] dataTable = csvReader.perCsV();
        Serializer serializer = new Serializer();
        for (String[] ing : dataTable) {
            Ingredient temp = new Ingredient(readIntFromTable(ing[0]), ing[1], readIntFromTable(ing[2]));
            serializer.serialize(temp);
        }
    }


    private int readIntFromTable(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // Handle the case where the input is not a valid integer, if needed
            // You can throw an exception or set a default value here
            return 0; // Default to 0 in case of invalid input
        }
    }


    private double readDoubleFromTable(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            // Handle the case where the input is not a valid integer, if needed
            // You can throw an exception or set a default value here
            return 0; // Default to 0 in case of invalid input
        }
    }
}
