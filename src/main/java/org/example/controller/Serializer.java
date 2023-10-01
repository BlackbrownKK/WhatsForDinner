package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.model.Ingredient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Serializer {
    private final File fileWithIngredients;
    private ObjectMapper mapper;

    private final String path = "src/main/resources/baseIngredients";


    public Serializer() {
        this.fileWithIngredients = new File(path);
        this.mapper = new ObjectMapper();
        // Configure the ObjectMapper to pretty-print JSON
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public void serialize(Ingredient ingredient) {
        try {
            // Read existing ingredients from the file
            List<Ingredient> existingIngredients = new ArrayList<>();
            if (fileWithIngredients.exists()) {
                existingIngredients = mapper.readValue(fileWithIngredients, mapper.getTypeFactory().constructCollectionType(List.class, Ingredient.class));

            }
            // Add the new ingredient to the existing list
            existingIngredients.add(ingredient);

            // Serialize the updated list and write it back to the file
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
            writer.writeValue(fileWithIngredients, existingIngredients);
        } catch (IOException e) {
            System.out.println("Cannot create or update the file!");
            e.printStackTrace();
        }
    }


    public Optional<Ingredient> deserialize() {
        try {
            return Optional.of(mapper
                    .readValue(new File(path), Ingredient.class));
        } catch (IOException e) {
            System.out.println("Cannot read file");
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
