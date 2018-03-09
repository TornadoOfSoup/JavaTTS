package com.soup;

public class Main {

    public static void main(String[] args) {

        PhonemeParser parser = new PhonemeParser();

        String parsedString = parser.parse("know");
        System.out.println(parsedString);


        PhonemePlayer player = new PhonemePlayer(parsedString);
        player.play();
    }

}
