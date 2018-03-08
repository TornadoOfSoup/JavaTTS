package com.soup;

import java.util.ArrayList;
import java.util.HashMap;

public class PhonemeParser {

    static HashMap<String, String> phonemeMap = new HashMap<String, String>();
    static HashMap<String, String> suffixMap = new HashMap<String, String>();
    static HashMap<String, String> specificWordMap = new HashMap<String, String>();

    public PhonemeParser() {
        if (phonemeMap.isEmpty()) {
            buildPhonemeMap();
        }
        if (suffixMap.isEmpty()) {
            buildSuffixMap();
        }
        if (specificWordMap.isEmpty()) {
            buildSpecificWordMap();
        }
    }

    private void buildPhonemeMap() {
        phonemeMap.put("ay", "Ay/");
        phonemeMap.put("ai", "Ay/");
        phonemeMap.put("a_e", "Ay/");
    }

    private void buildSuffixMap() {
        suffixMap.put("ation", "/Ay/sh/uh/n/");
        suffixMap.put("cian", "/sh/uh/n/");
        suffixMap.put("tion", "/sh/uh/n/");
        suffixMap.put("sion", "/zh/uh/n/");

        suffixMap.put("able", "/uh/b/l/");
        suffixMap.put("ible", "/i/b/l/");

        suffixMap.put("ade", "/Ay/d/");

        suffixMap.put("age", "/uh/j/");

        suffixMap.put("al", "/uh/l/");

        suffixMap.put("an", "/eh/n/");
        suffixMap.put("ian", "/E/eh/n/");

        suffixMap.put("ance", "/eh/n/s/");
        suffixMap.put("ence", "/eh/n/s/");

        suffixMap.put("ant", "/eh/n/t/");
        suffixMap.put("ent", "/eh/n/t/");

        suffixMap.put("ar", "/er/");
        suffixMap.put("ard", "/er/d/");

        suffixMap.put("arian", "/eh/r/E/eh/n/");
        suffixMap.put("arium", "/eh/r/E/uh/m/");
        suffixMap.put("ary", "/eh/r/E/");

        suffixMap.put("ate", "/eh/t/");

        suffixMap.put("cide", "/s/Iy/d/");

        suffixMap.put("cule", "/k/U/l/");

        suffixMap.put("cy", "/s/E/");

        suffixMap.put("dom", "/d/uh/m/");

        suffixMap.put("ed", "/d/");

        suffixMap.put("en", "/eh/n/");

        suffixMap.put("ency", "/eh/n/s/E");

        suffixMap.put("er", "/r/");

        suffixMap.put("ese", "/E/z/");

        suffixMap.put("ess", "/eh/s");

        suffixMap.put("est", "/eh/s/t/");

        suffixMap.put("ette", "/eh/t");

        suffixMap.put("ful", "/f/oo/l");

        suffixMap.put("fy", "/f/Iy/");

        suffixMap.put("hood", "/h/oo/d/");

        suffixMap.put("ile", "/Iy/l/");

        suffixMap.put("ily", "/i/l/E/");

        suffixMap.put("ing", "/i/ng/");

        suffixMap.put("tious", "/sh/uh/s/");
        suffixMap.put("cious", "/sh/uh/s/");

        suffixMap.put("ious", "/E/uh/s/");

        suffixMap.put("ish", "/i/sh/");

        suffixMap.put("ism", "/i/z/m/");

        suffixMap.put("ist", "/i/s/t/");

        suffixMap.put("ite", "/Iy/t/");

        suffixMap.put("ity", "/i/t/E/");

        suffixMap.put("ive", "/i/v/");

        suffixMap.put("ize", "/Iy/z/");
        suffixMap.put("ise", "/Iy/z/");
        suffixMap.put("yze", "/Iy/z/");
        suffixMap.put("yse", "/Iy/z/");

        suffixMap.put("less", "/l/eh/s/");

        suffixMap.put("let", "/l/i/t/");

        suffixMap.put("like", "/l/Iy/k/");

        suffixMap.put("ment", "/m/eh/n/t/");

        suffixMap.put("ness", "/n/eh/s/");

        suffixMap.put("nym", "/n/i/m/");

        suffixMap.put("oid", "/o/Iy/d/");

        suffixMap.put("ory", "/Oh/r/E/");

        suffixMap.put("ous", "/uh/s/");

        suffixMap.put("phile", "/f/Iy/l/");

        suffixMap.put("ship", "/sh/i/p/");

        suffixMap.put("some", "/s/uh/m/");

        suffixMap.put("th", "/th/");

        suffixMap.put("tude", "/t/OOO/d/");

        suffixMap.put("ty", "/t/E/");

        suffixMap.put("que", "/k/");

        suffixMap.put("ular", "/U/l/r/");

        suffixMap.put("ure", "/U/r/");

        suffixMap.put("ware", "/w/eh/r/");

        suffixMap.put("wise", "/w/Iy/z/");
    }

    private void buildSpecificWordMap() {
        specificWordMap.put("able", "Ay/b/l");
        specificWordMap.put("eye", "Iy/");
        specificWordMap.put("I", "Iy/");
        specificWordMap.put("let", "l/eh/t/");

    }

    public String parse(String string) {
        StringBuilder parsedStringBuilder = new StringBuilder();
        String[] words = string.split(" ");
        ArrayList<String> parsedWords = new ArrayList<String>();

        for (String word : words) {
            parsedWords.add(parseWord(word));
        }

        for (String word : parsedWords) {
            parsedStringBuilder.append(word + " ");
        }
        return parsedStringBuilder.toString();
    }

    private String parseWord(String word) {
        String parsedWord = word;
        boolean hasSuffix = false;

        ParseResult specificWordResult = parseSpecificWord(word);
        if (specificWordResult.isChanged()) {
            parsedWord = specificWordResult.getString();
        } else {

            for (String suffix : suffixMap.keySet()) {
                if (word.endsWith(suffix)) {
                    parsedWord = word.replace(suffix, "/" + suffixMap.get(suffix));
                    System.out.println("suffix: " + suffix + ", replacing with " + suffixMap.get(suffix));
                    hasSuffix = true;
                }
            }

            if (!hasSuffix) {
                if (word.length() > 3) {
                    if (word.endsWith("e") && !word.endsWith("ee")) {
                        parsedWord = word.substring(0, word.length() - 1);
                    }
                }

                if (word.endsWith("c")) {
                    parsedWord = word.substring(0, word.length() - 1) + 'k'; //replace c with k
                } else if (word.endsWith("y")) {
                    parsedWord = word.substring(0, word.length() - 1) + "ee"; //replace y with ee
                } else if (word.endsWith("s") && !word.endsWith("ss")) {
                    parsedWord = word.substring(0, word.length() - 1) + "z"; //replace s with z
                }

                //TODO implement figuring out what words sound like
            }

        }

        parsedWord = parsedWord.replace("//", "/");
        return parsedWord;
    }

    private ParseResult parseSpecificWord(String word) {
        ParseResult result = new ParseResult(false, word);

        if (specificWordMap.containsKey(word)) {
            result.setString(specificWordMap.get(word));
            result.setChanged(true);
        }

        return result;
    }
}
