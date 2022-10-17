package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Provides a symptom counting method
 */
public abstract class SymptomsCounter {
    
    /**
     * 
     * @param symptomData A list of symptoms as strings (with possible duplicates)
     * @return A map with unique symptoms as keys and number of occurences as values
     */
    public static Map<String, Integer> countSymptomsFromList(List<String> symptomData) {
        Map<String, Integer> symptomCounts = new TreeMap<String, Integer>();
        boolean isNewSymptom;

        for (String symptomString : symptomData) {
            //First assumes the symptom is new, then tries to prove otherwise
            isNewSymptom = true;
            for (Map.Entry<String,Integer> symptomCount : symptomCounts.entrySet()) {
                String countKey = symptomCount.getKey();
                if (countKey.equals(symptomString)) { //The == operator would always return false
                    symptomCounts.put(countKey, symptomCount.getValue()+1); //Increments the value of the symptomCount entry
                    isNewSymptom = false;
                    break;
                }
            }
            if (isNewSymptom) //If symptom is finally new, create a new count for it
                symptomCounts.put(symptomString, 1);
        }

        return symptomCounts;
    }
}
