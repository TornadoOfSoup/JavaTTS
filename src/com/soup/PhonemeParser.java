package com.soup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class PhonemeParser {

    static LinkedHashMap<String, String> phonemeMap = new LinkedHashMap<String, String>();
    static LinkedHashMap<String, String> suffixMap = new LinkedHashMap<String, String>();
    static LinkedHashMap<String, String> specificWordMap = new LinkedHashMap<String, String>();

    //static final char[] HARD_CONSONANTS = new char[]{};

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
        phonemeMap.put("ab", "/uh/b/");
        phonemeMap.put("ay", "/Ay/");
        phonemeMap.put("ai", "/Ay/");
        phonemeMap.put("ei", "/Ay/");
        //phonemeMap.put("a_e", "/Ay/");
        phonemeMap.put("airs", "/eh/r/s/");
        phonemeMap.put("aw", "/aw/");
        phonemeMap.put("aft", "a/f/t/");

        phonemeMap.put("ck", "/k/");
        phonemeMap.put("cc", "/k/");
        phonemeMap.put("cause", "/k/uh/z/");

        phonemeMap.put("ee", "/E/");
        phonemeMap.put("er", "/er/");
        //phonemeMap.put("e", "/eh/"); //this might break everything
        phonemeMap.put("ew", "/OOO/");

        phonemeMap.put("ing", "/i/ng/");
        phonemeMap.put("in", "/i/n/");
        phonemeMap.put("irs", "/er/s/");
        phonemeMap.put("urs", "/er/s/");

        phonemeMap.put("ll", "/l/");

        phonemeMap.put("ou", "/ou/");
        phonemeMap.put("ow", "/ou/");
        phonemeMap.put("oo", "/OOO/");

        phonemeMap.put("so", "/s/uh/");

        phonemeMap.put("to", "/t/Oh/");

        phonemeMap.put("un", "/uh/n/");
        phonemeMap.put("up", "/uh/p/");
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

        suffixMap.put("ake", "Ay/k/");

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

        suffixMap.put("aw", "/aw/");

        suffixMap.put("ay", "/Ay/");
        suffixMap.put("ey", "/Ay/");

        suffixMap.put("cause", "k/uh/z/");

        suffixMap.put("cide", "/s/Iy/d/");

        suffixMap.put("cule", "/k/U/l/");

        suffixMap.put("cy", "/s/E/");

        suffixMap.put("dom", "/d/uh/m/");

        suffixMap.put("ed", "/d/");

        suffixMap.put("ee", "/E/");

        suffixMap.put("en", "/eh/n/");

        suffixMap.put("ency", "/eh/n/s/E");

        suffixMap.put("er", "/er/");

        suffixMap.put("ese", "/E/z/");

        suffixMap.put("ess", "/eh/s");

        suffixMap.put("est", "/eh/s/t/");

        suffixMap.put("ette", "/eh/t");

        suffixMap.put("ful", "/f/oo/l");

        suffixMap.put("fy", "/f/Iy/");

        suffixMap.put("hood", "/h/oo/d/");

        suffixMap.put("ick", "/i/k/");
        suffixMap.put("icc", "/i/k/"); //lelelelel

        suffixMap.put("ile", "/Iy/l/");

        suffixMap.put("ily", "/i/l/E/");

        suffixMap.put("ing", "/i/ng/");
        suffixMap.put("ink", "/i/n/k/");

        suffixMap.put("tious", "/sh/uh/s/");
        suffixMap.put("cious", "/sh/uh/s/");

        suffixMap.put("ious", "/E/uh/s/");

        suffixMap.put("ish", "/i/sh/");

        suffixMap.put("ism", "/i/z/m/");

        suffixMap.put("ist", "/i/s/t/");

        suffixMap.put("ite", "/Iy/t/");
        suffixMap.put("ight", "/Iy/t/");

        suffixMap.put("ity", "/i/t/E/");

        suffixMap.put("ive", "/i/v/");

        suffixMap.put("ize", "/Iy/z/");
        suffixMap.put("ise", "/Iy/z/");
        suffixMap.put("yze", "/Iy/z/");
        suffixMap.put("yse", "/Iy/z/");

        suffixMap.put("less", "/l/eh/s/");

        suffixMap.put("let", "/l/i/t/");

        suffixMap.put("like", "/l/Iy/k/");

        suffixMap.put("ll", "/l/");

        suffixMap.put("ly", "/l/E/");

        suffixMap.put("ment", "/m/eh/n/t/");

        suffixMap.put("nd", "/n/d/");

        suffixMap.put("ness", "/n/eh/s/");

        suffixMap.put("nym", "/n/i/m/");

        suffixMap.put("oid", "/o/Iy/d/");

        suffixMap.put("or", "/Oh/r/");
        suffixMap.put("ory", "/Oh/r/E/");

        suffixMap.put("ou", "/OOO/");
        suffixMap.put("ous", "/uh/s/");
        suffixMap.put("ould", "/oo/d/");

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
        //specificWordMap.put("table", "t/Ay/b/l/");

        specificWordMap.put("to", "t/OOO/");
        specificWordMap.put("do", "d/OOO/");
        specificWordMap.put("of", "uh/v/");
        specificWordMap.put("this", "th/i/s/");
        specificWordMap.put("but", "b/uh/t/");
        specificWordMap.put("by", "b/Iy/");
        specificWordMap.put("my", "m/Iy/");
        specificWordMap.put("they", "th/ay/");
        specificWordMap.put("one", "hw/uh/n/");
        specificWordMap.put("there", "th/Ay/r/");
        specificWordMap.put("what", "hw/uh/t/");
        specificWordMap.put("so", "s/Oh/");
        specificWordMap.put("up", "uh/p/");
        specificWordMap.put("if", "i/f/");
        specificWordMap.put("who", "h/OOO/");
        specificWordMap.put("are", "aw/r/");
        specificWordMap.put("look", "l/oo/k/");
        specificWordMap.put("me", "m/E/");
        specificWordMap.put("can", "k/a/n/");
        specificWordMap.put("time", "t/Iy/m/");
        specificWordMap.put("hello", "h/eh/l/Oh");
        specificWordMap.put("hi", "h/Iy/");
        specificWordMap.put("know", "n/Oh/");
        specificWordMap.put("into", "i/n/t/OOO/");
        specificWordMap.put("your", "y/Oh/er/");
        specificWordMap.put("could", "k/oo/d/");
        specificWordMap.put("them", "th/eh/m/");
        specificWordMap.put("other", "uh/th/er/");
        specificWordMap.put("only", "Oh/n/l/E");
        specificWordMap.put("come", "k/uh/m");
        specificWordMap.put("its", "i/t/s/");
        specificWordMap.put("it's", "i/t/s/");
        specificWordMap.put("over", "Oh/v/er/");
        specificWordMap.put("also", "aw/l/s/Oh/");
        specificWordMap.put("use", "u/s/");
        specificWordMap.put("two", "t/OOO/");
        specificWordMap.put("work", "w/er/k/");
        specificWordMap.put("bork", "b/Oh/r/k/");
        specificWordMap.put("well", "w/eh/l/");
        specificWordMap.put("tell", "t/eh/l/");
        specificWordMap.put("even", "E/v/eh/n/");
        specificWordMap.put("any", "eh/n/E/");
        specificWordMap.put("most", "m/Oh/s/t/");
        specificWordMap.put("us", "uh/s/");
        specificWordMap.put("open", "Oh/p/eh/n/");
        specificWordMap.put("through", "th/r/OOO/");
        specificWordMap.put("fire", "f/Iy/r/");
        specificWordMap.put("head", "h/eh/d/");
        specificWordMap.put("today", "t/OOO/d/Ay/");

        specificWordMap.put("the", "th/uh/");
        specificWordMap.put("able", "Ay/b/l/");
        specificWordMap.put("eye", "Iy/");
        specificWordMap.put("i", "Iy/");
        specificWordMap.put("let", "l/eh/t/");
        specificWordMap.put("butterwhales", "b/uh/t/er/hw/Ay/l/s/");
        specificWordMap.put("satan", "s/Ay/t/eh/n/");

    }

    public String parse(String string) {
        string = string.toLowerCase();
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
        String parsedWord = word.trim();
        boolean hasSuffix = false;
        boolean hasSilentE = false;

        ParseResult specificWordResult = parseSpecificWord(word);
        if (specificWordResult.isChanged()) {
            parsedWord = specificWordResult.getString();
        } else {

            for (String suffix : suffixMap.keySet()) {
                if (word.endsWith(suffix)) {
                    parsedWord = parsedWord.replace(suffix, "/" + suffixMap.get(suffix));
                    System.out.println("suffix: " + suffix + ", replacing with " + suffixMap.get(suffix));
                    hasSuffix = true;
                }
            }

            if (!hasSuffix) {
                if (word.length() > 3) {
                    if (word.endsWith("e") && !word.endsWith("ee")) {
                        parsedWord = parsedWord.substring(0, word.length() - 1);
                        hasSilentE = true;
                    }
                }

                if (parsedWord.endsWith("c")) {
                    parsedWord = parsedWord.substring(0, parsedWord.length() - 1) + "/k/"; //replace c with k
                } else if (parsedWord.endsWith("y")) {
                    parsedWord = parsedWord.substring(0, parsedWord.length() - 1) + "/E/"; //replace y with ee
                } else if (parsedWord.endsWith("s") && !parsedWord.endsWith("ss")) {
                    parsedWord = parsedWord.substring(0, parsedWord.length() - 1) + "/z/"; //replace s with z
                } else if (parsedWord.endsWith("v")) {
                    parsedWord = parsedWord.substring(0, parsedWord.length() - 1) + "/v/";
                } else if (parsedWord.endsWith("r")) {
                    parsedWord = parsedWord.substring(0, parsedWord.length() - 1) + "/r/";
                } else if (parsedWord.endsWith("m")) {
                    parsedWord = parsedWord.substring(0, parsedWord.length() - 1) + "/m/";
                } else if (parsedWord.endsWith("p")) {
                    parsedWord = parsedWord.substring(0, parsedWord.length() - 1) + "/p/";
                } else if (parsedWord.endsWith("l")) {
                    parsedWord = parsedWord.substring(0, parsedWord.length() - 1) + "/l/";
                } else if (parsedWord.endsWith("o")) {
                    parsedWord = parsedWord.substring(0, parsedWord.length() - 1) + "/Oh/";
                }

                if (parsedWord.endsWith("ff")) {
                    parsedWord = parsedWord.substring(0, parsedWord.length() - 2) + "/f/";
                } else if (parsedWord.endsWith("f")) {
                    parsedWord = parsedWord.substring(0, parsedWord.length() - 1) + "/v/";
                }

                if (parsedWord.endsWith("nn")) {
                    parsedWord = parsedWord.substring(0, parsedWord.length() - 2) + "/n/";
                } else if (parsedWord.endsWith("n")) {
                    parsedWord = parsedWord.substring(0, parsedWord.length() - 1) + "/n/";
                }

                if (parsedWord.endsWith("tt")) {
                    parsedWord = parsedWord.substring(0, parsedWord.length() - 2) + "/t/";
                } else if (parsedWord.endsWith("t")) {
                    parsedWord = parsedWord.substring(0, parsedWord.length() - 1) + "/t/";
                }

                //endings end here

            }

            if (parsedWord.startsWith("ph")) {
                parsedWord = parsedWord.replaceFirst("ph", "/f/");
            } else if (parsedWord.startsWith("p")) {
                parsedWord = parsedWord.replaceFirst("p", "/p/");
            }

            if (parsedWord.startsWith("th")) {
                parsedWord = parsedWord.replaceFirst("th", "/th/");
            } else if (parsedWord.startsWith("t")) {
                parsedWord = parsedWord.replaceFirst("t", "/t/");
            }

            if (parsedWord.startsWith("al")) {
                parsedWord = parsedWord.replaceFirst("al", "/aw/l/");
            } else if (parsedWord.startsWith("a")) {
                //todo figure something out here
            }

            if (parsedWord.startsWith("fr")) {
                parsedWord = parsedWord.replaceFirst("fr", "/f/r/");
            } else if (parsedWord.startsWith("f")) {
                parsedWord = parsedWord.replaceFirst("f", "/f/");
            }

            if (parsedWord.startsWith("gr")) {
                parsedWord = parsedWord.replaceFirst("gr", "/g/r/");
            } else if (parsedWord.startsWith("g")) {
                parsedWord = parsedWord.replaceFirst("g", "/g/");
            }


            if (parsedWord.startsWith("b")) {
                parsedWord = parsedWord.replaceFirst("b", "/b/");
            }

            if (parsedWord.startsWith("d")) {
                parsedWord = parsedWord.replaceFirst("d", "/d/");
            }

            if (parsedWord.startsWith("kn")) {
                parsedWord = parsedWord.replaceFirst("kn", "/n/");
            } else if (parsedWord.startsWith("k")) {
                parsedWord = parsedWord.replaceFirst("k", "/k/");
            }

            if (parsedWord.startsWith("f")) {
                parsedWord = parsedWord.replaceFirst("f", "/f/");
            }

            if (parsedWord.startsWith("n")) {
                parsedWord = parsedWord.replaceFirst("n", "/n/");
            }

            if (parsedWord.startsWith("m")) {
                parsedWord = parsedWord.replaceFirst("m", "/m/");
            }

            if (parsedWord.startsWith("h")) {
                parsedWord = parsedWord.replaceFirst("h", "/h/");
            }

            if (parsedWord.startsWith("r")) {
                parsedWord = parsedWord.replaceFirst("r", "/r/");
            }

            if (parsedWord.startsWith("y")) {
                parsedWord = parsedWord.replaceFirst("y", "/y/");
            }

            if (parsedWord.startsWith("sh")) {
                parsedWord = parsedWord.replaceFirst("sh", "/sh/");
            } else if (parsedWord.startsWith("s")) {
                parsedWord = parsedWord.replaceFirst("s", "/s/");
            }

            if (parsedWord.startsWith("wh")) {
                parsedWord = parsedWord.replaceFirst("wh", "/hw/");
            } else if (parsedWord.startsWith("w")) {
                parsedWord = parsedWord.replaceFirst("w", "/w/");
            }

            if (parsedWord.startsWith("h")) {
                parsedWord = parsedWord.replaceFirst("h", "/h/");
            }

            //TODO implement figuring out what words sound like
            //below here is phoneme matching

            for (String phoneme : phonemeMap.keySet()) {
                if (parsedWord.contains(phoneme)) {
                    //todo something to check if it's editing something that's already been edited
                    parsedWord = parsedWord.replace(phoneme, phonemeMap.get(phoneme));
                }
            }

            if (hasSilentE) {
                //do things with silent E knowledge
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
