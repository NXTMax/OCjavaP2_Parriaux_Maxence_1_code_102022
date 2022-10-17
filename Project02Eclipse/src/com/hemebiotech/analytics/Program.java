package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.hemebiotech.analytics.SymptomsCounter.SymptomCount;

public class Program {

    public static void main(String[] args) {
        { //mocking the parameter for testing
            args = new String[2];
            args[0] = "Project02Eclipse/symptoms.txt";
            args[1] = "Project02Eclipse/result.out";
        }
        
        ReadSymptomDataFromFile symptomFileReader = new ReadSymptomDataFromFile(args[0]);
        ArrayList<SymptomCount> symptomCounts = SymptomsCounter.countSymptomsFromList(symptomFileReader.GetSymptoms());

        try {
            FileWriter writer = new FileWriter(args[1]);
            for (SymptomCount symptomCount : symptomCounts) {
                writer.write(symptomCount.toString() + '\n');
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
