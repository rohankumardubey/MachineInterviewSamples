package org.apache.practise.machinecoding.autocompletesystem;


public class AutoCompleteSystemTest {
  public static void main(String[] args) {
   String[] sentence = {"i love you", "island", "ironman", "i love leetcode"};
   int[] d = {5,3,2,2};
    AutoCompleteSystem autocompleteSystem = new AutoCompleteSystem(sentence, d);
    System.out.println(autocompleteSystem.input('i'));
    System.out.println(autocompleteSystem.input(' '));
    System.out.println(autocompleteSystem.input('u'));
    System.out.println(autocompleteSystem.input('v'));
    System.out.println(autocompleteSystem.input('#'));
    System.out.println(autocompleteSystem.input('i'));
    System.out.println(autocompleteSystem.input(' '));
    System.out.println(autocompleteSystem.input('u'));
  }
}
