package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides symptom counting method and data type
 */
public abstract class SymptomsCounter {
    
    /**
     * 
     * @param symptomData A list of symptoms as strings (with possible duplicates)
     * @return A list of unique symptoms with number of occurences
     */
    public static ArrayList<SymptomCount> countSymptomsFromList(List<String> symptomData) {
        ArrayList<SymptomCount> symptomCounts = new ArrayList<SymptomCount>();
        boolean isNewSymptom;

        for (String symptomString : symptomData) {
            //First assumes the symptom is new, then tries to prove otherwise
            isNewSymptom = true;
            for (SymptomCount symptomCount : symptomCounts) {
                if (symptomCount.Name.equals(symptomString)) { //The == operator would always return false
                    symptomCount.Count++;
                    isNewSymptom = false;
                    break;
                }
            }
            if (isNewSymptom) //If symptom is finally new, create a new count for it
                symptomCounts.add(new SymptomCount(symptomString, 1));
        }

        return symptomCounts;
    }

    /**
     * A data structure representing the number of occurences (Count) of a given symptom (Name)
     */
    public static class SymptomCount {
        
        protected String Name;
        protected int Count;

        public SymptomCount (String name, int count) {
            Name = name;
            Count = count;
        }

        @Override
        public String toString() {
            return Name + "=" + Count;
        }
    }
}



