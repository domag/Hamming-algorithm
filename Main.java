package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<ArrayList<Integer>> messages;
        DataReader dataReader = new DataReader(new File("src/sourceText.txt"));
        CoderHamming coderHamming = new CoderHamming(7,4,3);
        dataReader.readMessages();
        messages = dataReader.getMessages();
        System.out.println("*****************WIADOMOSCI*****************");
        for (int i = 0; i < messages.size(); i++) {
            System.out.println(messages.get(i));
        }
        ArrayList <ArrayList<Integer>> result = coderHamming.multiCode(messages);
        System.out.println("*****************KODER*********************");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        System.out.println("*****************BSC*********************");
        Bsc bsc = new Bsc(0.2);
        ArrayList wiadBsc = bsc.sendMulti(result);
        for (int i = 0; i < wiadBsc.size(); i++) {
            System.out.println(wiadBsc.get(i));
        }
        System.out.println("*****************DEKODER*********************");
        DecoderHamming decoderHamming = new DecoderHamming();

        ArrayList<ArrayList<Integer>> result3 = decoderHamming.multiDecode(wiadBsc);
        for (int i = 0; i < result3.size(); i++) {
            System.out.println(result3.get(i));
        }

        decoderHamming.saveToFile("src/results.txt", result3);
        FileComperator fileComperator = new FileComperator(new File("src/sourceText.txt"), new File("src/results.txt"));
        System.out.println(fileComperator.compare());
    }
}
