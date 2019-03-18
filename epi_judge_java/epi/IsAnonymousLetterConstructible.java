package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.Map;

public class IsAnonymousLetterConstructible {
  @EpiTest(testDataFile = "is_anonymous_letter_constructible.tsv")

  public static boolean isLetterConstructibleFromMagazine(String letterText,
                                                          String magazineText) {
    Map<Character, Integer> letterFreq = new HashMap<>();
    for(char c: letterText.toCharArray()){
      if(letterFreq.containsKey(c)){
        letterFreq.put(c, letterFreq.get(c)+1);
      }
      else{
        letterFreq.put(c, 1);
      }
    }
    for(char c: magazineText.toCharArray()){
      if(letterFreq.containsKey(c)){
        Integer freq = letterFreq.get(c);
        if(freq==1){
          letterFreq.remove(c);
          if(letterFreq.isEmpty())
            return true;
        }
        else{
          letterFreq.put(c, freq-1);
        }
      }
    }
    return letterFreq.isEmpty();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsAnonymousLetterConstructible.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
