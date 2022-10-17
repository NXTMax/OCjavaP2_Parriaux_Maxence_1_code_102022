package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data to an outpout destination
 * The important part is, the argument passed to the method, which is a map of String/Integer
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomWriter {
	/**
	 * If no data is available, print an empty output
	 * 
	 * @param symptomCounts a Map of symptoms Name(key)/Count(value)
	 */
	void PrintSymptoms (Map<String, Integer> symptomCounts);
}
