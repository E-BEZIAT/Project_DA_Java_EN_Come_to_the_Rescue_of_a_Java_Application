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
	 * @param filepath is a path to the file symptoms.txt, who's contain the symptoms list.
	 * The class ReadSymptomDataFromFile read the file symptoms.txt where are the symptoms list.
	 * The function read line by line as long as the line isn't null and if the length of the file isn't 0.
	 * There is a try/catch in case of problem, it would tell us if the problem is from the reading.
	 */

	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = Paths.get(filepath).toFile(); //change string into file
	}

	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		int length = (int) filepath.length();

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

