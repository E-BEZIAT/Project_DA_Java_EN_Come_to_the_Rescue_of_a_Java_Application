package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    /**
     * the class WriteSymptom is the writer. It creates a file named result.txt and write in the file the keys with their associate value.
     * write.close() is uses to stop writing, otherwise the file would not have anything write inside.
     */
    public void WriteSymptom(Map<String, Integer> symptoms) {
        StringBuilder RESULT = new StringBuilder();
        RESULT.append("This is a Symptom File\n\n");
        
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

