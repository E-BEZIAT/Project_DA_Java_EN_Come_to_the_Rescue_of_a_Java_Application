package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

	}
		public Map<String, Integer> getSymptoms() {

			ISymptomReader myReader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");  //lit les symptoms depuis readsymptomdatafile implémenté avec ISymptomsReader
			List<String> symptoms = myReader.getSymptoms();
			return countSymptoms(symptoms);
        }

		public Map<String, Integer> countSymptoms(List<String> symptoms) {

			Map<String, Integer> map = new HashMap<>();

			for (String symptom : symptoms) {
				if (map.containsKey(symptom)) {
					map.put(symptom, map.get(symptom) + 1); // if key already exist, add +1 to the value associate
				} else {
					map.put(symptom, 1); // if key didn't exist, add the key with an associate value of 1
				}
			}
			if (map.isEmpty()) {
			return new HashMap<>();
			}
			return sortSymptoms(map);
		}

		public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

			TreeMap<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
            try {
                return writeSymptoms(sortedSymptoms);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

		public Map<String, Integer> writeSymptoms(Map<String, Integer> symptoms) throws IOException {

			ISymptomWriter myWriter = new WriteSymptomDataToFile();
			myWriter.WriteSymptom(symptoms);
            return symptoms;
        }
}


