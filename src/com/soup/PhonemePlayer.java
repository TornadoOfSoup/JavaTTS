package com.soup;

import javax.sound.sampled.*;
import java.io.File;

public class PhonemePlayer {
    String[] phonemes;

    public PhonemePlayer() {
        this("");
    }

    public PhonemePlayer(String phenomeString) {
        phonemes = phenomeString.split("/");

        for (String phoneme : phonemes) {
            System.out.println(phoneme);
        }
    }

    public void play() {
        for (String phoneme : phonemes) {
            if (!phoneme.isEmpty() && !phoneme.equals(" ")) {
                playPhoneme("phenomes/" + phoneme.trim() + ".wav");
            }
        }
    }

    public static void playPhoneme(String path) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try {
            File file = new File(classloader.getResource(path).getFile());
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            AudioFormat format = stream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip) AudioSystem.getLine(info);

            clip.open(stream);
            clip.start();

            while(clip.getFrameLength() > clip.getFramePosition() + 200) { }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
