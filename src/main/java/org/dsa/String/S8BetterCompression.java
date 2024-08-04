package org.dsa.String;

import java.util.*;

public class S8BetterCompression {
//    Question - accumulate similar words and its frequencies also print in sorted order EG - a11b12a10d13 = a21b12d13
    public static String accumulateAndSort(String input) {
        // Create a map to store character frequencies
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Loop through the input string
        int i = 0;
        while (i < input.length()) {
            char character = input.charAt(i);
            StringBuilder frequencyBuilder = new StringBuilder();

            // Extract the frequency number
            i++;
            while (i < input.length() && Character.isDigit(input.charAt(i))) {
                frequencyBuilder.append(input.charAt(i));
                i++;
            }
            int frequency = Integer.parseInt(frequencyBuilder.toString());

            // Update the frequency map
            frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + frequency);

        }
        // Create a TreeMap to sort the map by keys (characters)
        TreeMap<Character, Integer> sortedMap = new TreeMap<>(frequencyMap);

        // Construct the output string
        StringBuilder output = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
            output.append(entry.getKey()).append(entry.getValue());
        }

        return output.toString();
    }

    public static void main(String[] args) {
        String input = "a321b34a12c10";
        String output = accumulateAndSort(input);
        System.out.println(output); // Output: a333b34c10
    }
}
