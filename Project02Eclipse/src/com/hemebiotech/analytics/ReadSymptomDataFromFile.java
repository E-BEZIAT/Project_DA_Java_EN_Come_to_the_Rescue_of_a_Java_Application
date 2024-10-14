package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ReadSymptomDataFromFile implements ISymptomReader {

	private final File filepath;

	/**
	 *
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */


	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = Paths.get("Project02Eclipse/symptoms.txt").toFile(); //change string into file

		System.out.println("chemin portable " + this.filepath.getAbsolutePath());
	}

	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		int length = (int) filepath.length();   //

		if (length > 0) {
			try {
				System.out.println("Répertoire de travail : " + System.getProperty("user.dir"));
				BufferedReader reader = new BufferedReader (new FileReader(String.valueOf(filepath)));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}

