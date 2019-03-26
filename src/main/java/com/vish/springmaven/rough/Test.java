package com.vish.springmaven.rough;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {



        String[] unorderdStrings = {"z8.doc","z1.doc","z10.doc","z100.doc","z13.doc","z101.doc","z11.doc",
                "z19.doc","z102.doc","z14.doc","z15.doc","z17.doc","z18.doc","z2.doc","z20.doc","z3.doc",
                "z4.doc","z16.doc","z5.doc","z6.doc","z12.doc","z7.doc","z9.doc"
        };

        Map<String, String> alphaNumsMap = covertAlphaNumsToMap(unorderdStrings);

        alphaNumsMap.keySet();
    }

    private static Map<String, String> covertAlphaNumsToMap(String[] alphaNums){
        String[] unorderdStrings = {"z8.doc","z1.doc","z10.doc","z100.doc","z13.doc","z101.doc","z11.doc",
                "z19.doc","z102.doc","z14.doc","z15.doc","z17.doc","z18.doc","z2.doc","z20.doc","z3.doc",
                "z4.doc","z16.doc","z5.doc","z6.doc","z12.doc","z7.doc","z9.doc"
        };

        Map<String, String> myMap = new HashMap<>();
        for (String s: alphaNums) {
            String numStr = "";
            for(char c: s.toCharArray()){
                if(Character.isLetter(c)){
                    numStr += (int)c;
                } else {
                    numStr += c;
                }
            }
            myMap.put(numStr, s);
        }

        return myMap;
    }


}
