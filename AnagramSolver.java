// Sean Cleary
// Assignment 6 (Anagram Solver)
// TA: Caitlin Schaefer
// 22 February 2018
// This class prints a bracketed, comma-seperated list of words that are anagrams for the given
// word or phrase.

import java.util.*;

public class AnagramSolver {
   private List<String> dictionary; // the current group of words being used
   
   // pre : takes in a List as a parameter that is the current dictionary being used.
   public AnagramSolver(List<String> list) {
      dictionary = list;
   }
   
   // pre : takes in a phrase (String) and an max number of words (Integer) as parameters. Throws
   //       IllegalArgumentException if max is less than 0. 
   // post: prints all the different letter combinations of the inputed phrase 
   public void print(String s, int max) {
      if (max < 0) {
         throw new IllegalArgumentException();
      }
      List<String> result = new ArrayList<String>();
      LetterInventory phraseInventory = new LetterInventory(s);
      List<String> prunedDictionary = new ArrayList<String>();
      Map<String, LetterInventory> inventoryMap = new HashMap<String, LetterInventory>();
      for (String word : dictionary) {
         inventoryMap.put(word, new LetterInventory(word));
         if (phraseInventory.subtract(inventoryMap.get(word)) != null) {
            prunedDictionary.add(word);
         }
      }
      print(phraseInventory, result, prunedDictionary, inventoryMap, max);
   }
   
   // pre: takes in a inventory of letters (phraseInventory), a list of word combinations (result),
   //      the dictionary of relevant words (prunedDictionary), a map of letter inventorys 
   //      (inventoryMap), and a max number of words (max).
   // post: helper method to print(String s, int max)
   private void print(LetterInventory phraseInventory, List<String> result,
                      List<String> prunedDictionary, Map<String, LetterInventory> inventoryMap,
                      int max) {
      if (phraseInventory.isEmpty()) {
         if (result.size() <= max || max == 0) {
            System.out.println(result);
         }
      } else {
         for (String word : prunedDictionary) {
            if (phraseInventory.subtract(inventoryMap.get(word)) != null) {
               result.add(word);
               phraseInventory = phraseInventory.subtract(inventoryMap.get(word));
               print(phraseInventory, result, prunedDictionary, inventoryMap, max);
               phraseInventory = phraseInventory.add(inventoryMap.get(word));
               result.remove(result.size() - 1);
            }
         }
      }
   }
}