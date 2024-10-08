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
        logger = LogManager.getLogger(String.valueOf(WriteSymptomDataToFile.class));
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {
        StringBuilder RESULT = new StringBuilder(); //StringBuilder construit le contenu du fichier
        RESULT.append("This is a Symptom File\n\n");

        for(String symptome : symptoms.keySet()) {
            RESULT.append(symptome).append("\t").append(symptoms.get(symptome)).append("\n");
        }
        ArrayList<String> result = new ArrayList<String>();

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"));
                writer.write(RESULT.toString());
            } catch (IOException e) {
                logger.log("Impossible d'ecrire dans le fichier");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

    }


    }

