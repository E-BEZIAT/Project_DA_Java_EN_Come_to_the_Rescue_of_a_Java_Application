package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
	}

	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		int length = (int) filepath.length();   //

		if (length > 0) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(String.valueOf(filepath)));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			}
			catch (IOException e) {
				System.out.println("Erreur durant la lecture");
				e.printStackTrace();
			}
		}
		return result;
	}
}

