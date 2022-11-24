package com.destillary.challange;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/*
A friend has provided you with their phone’s lock screen combination, a series of numbers,
and told you it represents something significant to them.
You know that the lock screen numbers come associated with a set of letters (eg, 2 → ABC, 3→ DEF, .....),
so it seems reasonable to assume their lock screen combination could be a word or phrase.
Your challenge is to write a function which, given the lock screen number as an input,
returns a list of all of the possible strings that number might represent.
Your code must be compilable, executable, and include test cases.

*Bonus points*: Once you have a function that returns all the possible strings, you’ll probably notice
the list can be pretty large. Can you come up with an additional function that can help you review the
result by ranking them by how likely they are to be an actual word or phrase?


Lockscreen Keyboard

   1     2     3
       [ABC] [DEF]

   4     5     6
 [GHI] [JKL] [MNO]

   7     8     9
[PQRS] [TUV] [WXYZ]

         0

Lock screen combination:
22

Output:
[ AA, AB, AC, BA, BB, BC, CA, CB, CC ]


Lock screen combination:
234

Output
[
  ADG,
  ADH,
  ADI,
  AEG,
  AEH,
  AEI,
  AFG,
  AFH,
  AFI,
  BDG,
  BDH,
  BDI,
  BEG,
  BEH,
  BEI,
  BFG,
  BFH,
  BFI,
  CDG,
  CDH,
  CEG,
  CEH,
  CEI,
  CFG,
  CFH,
  CFI
]

*Bonus Points*

Lock screen combination: 93553663 "WELLDONE"

*/

class Solution {

    public static void main(String[] args) {
        List<String> combinations = getCombinations("93553663");
        combinations.forEach(System.out::println);
    }

    public static List<String> getCombinations(String input){
        List<List<Character>> chars = new ArrayList<>();
        for(char c : input.toCharArray()) {
            List<Character> characters = getCharsForDigit(c);
            chars.add(characters);
        }
         List<String> combinations = new ArrayList<>();

        getCombinations(chars, combinations, 0, "");

        return combinations;
    }

    public static void getCombinations(List<List<Character>> chars, List<String> combinations, int depth, String current) {
        if (depth == chars.size()) {
            combinations.add(current);
            return;
        }

        for (int i = 0; i < chars.get(depth).size(); i++) {
            getCombinations(chars, combinations, depth + 1, current + chars.get(depth).get(i));
        }
    }
    
    public static List<Character> getCharsForDigit(char i){
        switch (i) {
            case '2':
                return Arrays.asList('A', 'B', 'C');
            case '3':
                return Arrays.asList('D', 'E', 'F');
            case '4':
                return Arrays.asList('G', 'H', 'I');
            case '5':
                return Arrays.asList('J', 'K', 'L');
            case '6':
                return Arrays.asList('M', 'N', 'O');
            case '7':
                return Arrays.asList('P', 'Q', 'R', 'S');
            case '8':
                return Arrays.asList('T', 'U', 'V');
            case '9':
                return Arrays.asList('W', 'X', 'Y', 'Z');
            default:
                return Arrays.asList('-');
        }
    }
}
