package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;


public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public static void main(String args[]) throws Exception {

	}
		public List<String> getSymptoms() {
		System.out.println("Répertoire de travail : " + System.getProperty("user.dir"));
		ISymptomReader myReader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");  //lit les symptoms depuis readsymptomdatafile implémenté avec ISymptomsReader
		List<String> symptoms = myReader.getSymptoms();
            return symptoms;
        }

		public Map<String, Integer> countSymptoms(List<String> symptoms) {
		System.out.println("symptoms size : " + symptoms.size());
		Map<String, Integer> map = new HashMap<>();

		for (String symptom : symptoms) {
			if (map.containsKey(symptom)) {
				map.put(symptom, map.get(symptom + 1)); // if key already exist, add +1 to the value associate
			} else {
				map.put(symptom, 1); // if key didn't exist, add the key with an associate value of 1
			}
		}
		if (map.isEmpty()) {
		return new HashMap<>();

		}
		return map;
		}

		public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

			TreeMap<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);

			// for (Map.Entry<String, Integer> entry : sortedSymptoms.entrySet()) { // Trie le Map grâce au TreeMap (ordre alphabétique)
				return sortedSymptoms;


            // }

		}

		public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {

			ISymptomWriter myWriter = new WriteSymptomDataToFile() {
				@Override
				public boolean containsKey(String readLine) {
					return false;
				}

				@Override
				public Object get(String s) {
					return null;
				}

				@Override
				public void put(String readLine, Object o) {

				}
			};

		}


	}


	//int i = 0;
	//int headCount = 0;
	//while (line != null) {
	//	i++;
	//	System.out.println("symptom from file: " + line);
	//	if (line.equals("headache")) {
	//		headCount++;
	//		System.out.println("number of headaches: " + headCount);
	//	}
	//	else if (line.equals("rush")) {
	//		rashCount++;
	//	}
	//	else if (line.contains("pupils")) {
	//		pupilCount++;
	//	}

	//	line = reader.readLine();	// get another symptom
	//}



	// next generate output
	//FileWriter writer = new FileWriter ("result.out");
	//writer.write("headache: " + headacheCount + "\n");
	//writer.write("rash: " + rashCount + "\n");
	//writer.write("dialated pupils: " + pupilCount + "\n");
	//writer.close();


