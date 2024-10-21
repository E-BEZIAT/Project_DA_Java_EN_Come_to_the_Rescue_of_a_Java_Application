package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    public void WriteSymptom(Map<String, Integer> symptoms) {
        StringBuilder RESULT = new StringBuilder(); //StringBuilder build the file
        RESULT.append("This is a Symptom File\n\n");
        String filename = "result";
        try {
            File newFile = new File("result.txt");
            boolean success = newFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
                FileWriter writer = new FileWriter("result.txt");
            for(Map.Entry<String, Integer> symptome : symptoms.entrySet()) {
                RESULT.append(symptome.getKey() + " : " + symptome.getValue() + "\n");
            }
            writer.write(RESULT.toString());
            writer.close();
        }
        catch (IOException e) {
            System.out.println("erreur durant l'écriture" + e.getMessage());
            e.printStackTrace();
        }
    }
}

