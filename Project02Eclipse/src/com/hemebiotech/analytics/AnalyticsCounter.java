package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;

public class AnalyticsCounter {

	/**
	 * getSymptoms is reading "symptoms.txt" file.
	 * It uses the class ReadSymptomDataFromFile who is implement by the ISymptomReader interface
	 * @return symptoms and it's count
	 */
		public Map<String, Integer> getSymptoms() {

			ISymptomReader myReader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
			List<String> symptoms = myReader.getSymptoms();
			return countSymptoms(symptoms);
        }

	/**
	 * countSymptoms uses the map function to count the symptoms in the file read just before.
	 * is the key already exist, it adds +1 to the associate value, if not it create a new key with a default value of 1
	 * @param symptoms List of symptoms extracted from a file
	 * @return symptoms and it's count
	 */
		public Map<String, Integer> countSymptoms(List<String> symptoms) {

			Map<String, Integer> map = new HashMap<>();

			for (String symptom : symptoms) {
				if (map.containsKey(symptom)) {
					map.put(symptom, map.get(symptom) + 1);
				} else {
					map.put(symptom, 1);
				}
			}
			if (map.isEmpty()) {
			return new HashMap<>();
			}
			return sortSymptoms(map);
		}

	/**
	 * sortSymptoms sort the symptoms (keys) in alphabetical order, with the associate value. It uses TreeMap who doing
	 * a sort automatically
	 * @param symptoms list of symptoms
	 * @return sorted list
	 */
		public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

			TreeMap<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
            try {
                return writeSymptoms(sortedSymptoms);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

	/**
	 * writeSymptoms uses WriteSymptomDataToFile, it's a class who write in a .txt file.
	 * WriteSymptomDataToFile is implement by the interface ISymptomWriter.
	 * @param symptoms list of symptoms
	 * @return symptoms
	 * @throws IOException exception
	 */
		public Map<String, Integer> writeSymptoms(Map<String, Integer> symptoms) throws IOException {

			ISymptomWriter myWriter = new WriteSymptomDataToFile();
			myWriter.WriteSymptom(symptoms);
            return symptoms;
        }
}


