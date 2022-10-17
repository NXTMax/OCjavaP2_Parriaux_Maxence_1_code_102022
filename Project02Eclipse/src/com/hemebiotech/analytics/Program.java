package com.hemebiotech.analytics;

import java.util.Map;

public class Program {

    public static void main(String[] args) {
        { //mocking the parameters for testing
            args = new String[2];
            args[0] = "Project02Eclipse/symptoms.txt";
            args[1] = "Project02Eclipse/results.out";
        }
        
        ReadSymptomDataFromFile symptomFileReader = new ReadSymptomDataFromFile(args[0]);
        WriteSymptomCountsToFile symptomCountsFileWriter = new WriteSymptomCountsToFile(args[1]);

        Map<String, Integer> symptomCounts = SymptomsCounter.countSymptomsFromList(symptomFileReader.GetSymptoms());
        symptomCountsFileWriter.PrintSymptoms(symptomCounts);
    }
}
