package com.campusdual.classroom;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JSONFileCreator {
    private static final String OUTPUT_PATH = "src/main/resources/shoppingList.json";

    public static void createDocument() {
        File file = new File(OUTPUT_PATH);
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        String ln = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(ln);
        sb.append("  \"items\": [").append(ln);
        sb.append("    { \"text\": \"Manzana\", \"quantity\": 2 },").append(ln);
        sb.append("    { \"text\": \"Leche\", \"quantity\": 1 },").append(ln);
        sb.append("    { \"text\": \"Pan\", \"quantity\": 3 },").append(ln);
        sb.append("    { \"text\": \"Huevo\", \"quantity\": 2 },").append(ln);
        sb.append("    { \"text\": \"Queso\", \"quantity\": 1 },").append(ln);
        sb.append("    { \"text\": \"Cereal\", \"quantity\": 1 },").append(ln);
        sb.append("    { \"text\": \"Agua\", \"quantity\": 4 },").append(ln);
        sb.append("    { \"text\": \"Yogur\", \"quantity\": 6 },").append(ln);
        sb.append("    { \"text\": \"Arroz\", \"quantity\": 2 }").append(ln);
        sb.append("  ]").append(ln);
        sb.append("}").append(ln);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(sb.toString());
        } catch (IOException e) {
            System.out.println("Error al escribir JSON: " + e.getMessage());
        }
    }
}


