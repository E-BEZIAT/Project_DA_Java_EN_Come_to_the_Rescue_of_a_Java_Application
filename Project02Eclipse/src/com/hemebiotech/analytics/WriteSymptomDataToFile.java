package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public abstract class WriteSymptomDataToFile implements ISymptomWriter {

    private Logger logger;
    private AutoCloseable writer;

    {
       // logger = LogManager.getLogger(String.valueOf(WriteSymptomDataToFile.class));
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {
        StringBuilder RESULT = new StringBuilder(); //StringBuilder construit le contenu du fichier
        RESULT.append("This is a Symptom File\n\n");

        for(String symptome : symptoms.keySet()) {
            RESULT.append(symptome).append("\t").append(symptoms.get(symptome)).append("\n");
        }
        ArrayList<String> result = new ArrayList<String>();

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Project02Eclipse/result.out"));
                writer.write(RESULT.toString());
                writer.close();
            } catch (IOException e) {
         //       logger.log("Impossible d'ecrire dans le fichier"); // If the fonction can't write in the file, a message will appear
            } catch (Exception e) {
                throw new RuntimeException(e); // captur all exceptions and launch again with RuntimeException
            }

    }


    public abstract boolean containsKey(String readLine);

    public abstract Object get(String s);

    public abstract void put(String readLine, Object o);
}

