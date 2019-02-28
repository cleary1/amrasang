# Purpose:
Rearranges the letters of words to form different words. The new word(s) are an anagram for the first word(s).

# How it works:
This program solves anagrams using Recursive Backtracking to test all combinations of letters against a dictionary.

This LetterInventory class creates an integer array of letter counters that keeps track of how many of occurrences of each letter are in a phrase. The AnagramSolver class uses this to test if a phrase can be rearranged by subtracting letters from the input phrase recursively until there are no suitable words left in the dictionary or until all letters have been substracted from a phrase. The paths that have excess letters are ignored and the paths that use all letters are printed to console.

# Sample Output:
```
  Welcome to the xxx anagram solver.


  phrase to scramble (return to quit)? Sean Cleary
  Max words to include (0 for no max)? 2
  [ala, scenery]
  [sea, larceny]
  [else, canary]
  [sale, carney]
  [slay, careen]
  [yearn, scale]
  [canary, else]
  [careen, slay]
  [carney, lase]
  [carney, sale]
  [carney, seal]
  [seance, aryl]
  [cleanse, ray]
  [larceny, sea]
  [scenery, ala]
```
### Disclaimer:
I made this program for a class so the original idea is not mine.
