// Sean Cleary
// Assignment 1
// TA: Caitlin Schaefer
// 9 Jan 2018
// This class is a data structure that stores the number and type of letter in a string. It
// stores the data in a bracketed list.

public class LetterInventory {
   private int[] elementData;
   private int size;

   public static final int COUNTERS = 26;

   // post: constructs an inventory of 26 counters, one for every letter a - z. Adds letters of
   // string data to the inventory.
   public LetterInventory(String data) {
      elementData = new int[COUNTERS];
      data = data.toLowerCase();
      for (int j = 0; j < data.length(); j++) {
         for (int i = 0; i < COUNTERS; i++) {
            if (data.charAt(j) == 'a' + i) {
               elementData[i]++;
               size++;
            }
         }
      }
   }

   // post: returns the number of characters in the inventory.
   public int size() {
      return size;
   }

   // post: returns true if the inventory is empty (size() == 0)
   public boolean isEmpty() {
      return size == 0;
   }

   // pre: 'a' <= letter <= 'z' (CASE INSENSITIVE) (throws IllegalArgumentException if not)
   // post: returns an integer count of the number of occurences of parameter letter
   public int get(char letter) {
      letter = Character.toLowerCase(letter);
      checkChar(letter);
      return elementData[letter - 'a'];
   }

   // post: creates a bracketed, alphabetical version of the inventory. returns [] is empty
   public String toString() {
      if (size == 0) {
         return "[]";
      }
      String result = "[";
      for (int i = 0; i < COUNTERS; i++) {
         for (int j = 0; j < elementData[i]; j++) {
            char letter = (char) ('a' + i);
            result = result + letter;
         }
      }
      result = result + "]";
      return result;
   }

   // pre: 'a' <= letter <= 'z' (CASE INSENSITIVE && value >= 0. throws IllegalArgumentException
   //      if not
   // post: sets the count of the letter entered to the value entered
   public void set(char letter, int value) {
      letter = Character.toLowerCase(letter);
      checkChar(letter);
      if (value < 0) {
         throw new IllegalArgumentException("value : " + value);
      }
      size = size - elementData[letter - 'a']; // remove previous value from size
      size = size + value; // add new value to size
      elementData[letter - 'a'] = value;
   }

   // post: contructs a new LetterInventory and returns the sum of the LetterInventory the method
   // was called on and the LetterInventory of the parameter
   public LetterInventory add(LetterInventory other) {
      LetterInventory sum = new LetterInventory("");
      for (int i = 0; i < COUNTERS; i++) {
         sum.elementData[i] = this.elementData[i] + other.elementData[i];
         sum.size = this.size + other.size;
      }
      return sum;
   }

   // pre: Difference >= 0 (returns null if not)
   // post: contructs a new LetterInventory and returns the difference of the LetterInventory the
   // method was called on and the LetterInventory in the parameter
   public LetterInventory subtract(LetterInventory other) {
      LetterInventory difference = new LetterInventory("");
      for (int i = 0; i < COUNTERS; i++) {
         difference.elementData[i] = this.elementData[i] - other.elementData[i];
         difference.size = this.size - other.size;
         if (difference.elementData[i] < 0) {
            return null;
         }
      }
      return difference;
  }

  // post: checks if the letter passed is between 'a' and 'z'. throws IllegalArgumentException
  // if not
  private void checkChar(char letter) {
     if (letter < 'a' || letter > 'z') {
         throw new IllegalArgumentException("character entered : " + letter);
     }
  }
}
