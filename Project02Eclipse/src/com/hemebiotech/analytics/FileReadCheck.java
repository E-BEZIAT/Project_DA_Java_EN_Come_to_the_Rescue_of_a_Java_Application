package com.hemebiotech.analytics;

import java.io.File;
import java.nio.file.Paths;

public class FileReadCheck {

    public static void main(String[] args) {
        // Chemin du fichier
        File file = Paths.get("Project02Eclipse/symptoms.txt").toFile();

        // Vérification si le fichier existe et est lisible
        if (file.exists()) {
            if (file.canRead()) {
                System.out.println("Le fichier est lisible.");
            } else {
                System.out.println("Le fichier existe mais il n'est pas lisible.");
            }
        } else {
            System.out.println("Le fichier n'existe pas.");
        }
    }
}
