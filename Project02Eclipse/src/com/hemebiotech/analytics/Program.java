package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Program {

    public static void main(String[] args) {
        { //mocking the parameter for testing
            args = new String[2];
            args[0] = "Project02Eclipse/symptoms.txt";
            args[1] = "Project02Eclipse/result.out";
        }
        
        ReadSymptomDataFromFile symptomFileReader = new ReadSymptomDataFromFile(args[0]);
        Map<String, Integer> symptomCounts = SymptomsCounter.countSymptomsFromList(symptomFileReader.GetSymptoms());

        try {
            FileWriter writer = new FileWriter(args[1]);
            for (Map.Entry<String,Integer> symptomCount : symptomCounts.entrySet()) {
                writer.write(symptomCount.toString() + '\n'); //Lucky me, the toString format for Map entries goes "key=value"
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
