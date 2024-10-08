package com.hemebiotech.analytics;

import java.io.*;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;	// ?
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {

		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt")); // //Je n'arrive pas à mettre un try/catch ici
		String readLine = reader.readLine();
		BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"));
		String writeSymptoms = writer.write();

		WriteSymptomDataToFile writeSymptomsFile = new WriteSymptomDataToFile() {
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

		if(writeSymptomsFile.containsKey(readLine)) {
			writeSymptomsFile.put(readLine, writeSymptomsFile.get(readLine + 1));
		}else {
			writeSymptomsFile.put(readLine, 1);
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
	}
}

