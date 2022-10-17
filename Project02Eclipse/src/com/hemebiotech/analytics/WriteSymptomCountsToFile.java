package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomCountsToFile implements ISymptomWriter {

    private String FilePath;

    /**
	 * 
	 * @param filePath a full or partial path to the output file
	 */
    WriteSymptomCountsToFile(String filePath) {
        this.FilePath = filePath;
    }

    @Override
    public void PrintSymptoms(Map<String, Integer> symptomCounts) {
        try {
            FileWriter writer = new FileWriter(FilePath);
            for (Map.Entry<String,Integer> symptomCount : symptomCounts.entrySet()) {
                writer.write(symptomCount.toString() + '\n'); //Lucky me, the toString format for Map entries goes "key=value"
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
