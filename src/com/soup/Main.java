package com.soup;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PhonemeParser parser = new PhonemeParser();
        System.out.println("Enter desired TTS string.");

        String input = "";
        Scanner scanner = new Scanner(System.in);

        while (!input.equals("!!!")) {
            input = scanner.nextLine();

            String parsedString = parser.parse(input);
            System.out.println(parsedString);


            PhonemePlayer player = new PhonemePlayer(parsedString);
            player.play();

        }
    }

}
