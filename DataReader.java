package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Monika on 02.02.2017.
 */
public class DataReader {
    private File inFile; //plik wejsciowy
    int count;
    private ArrayList<ArrayList<Integer>> messages;


    public DataReader(File inFile) {
        this.inFile = inFile;
        messages = new ArrayList<ArrayList<Integer>>();
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public ArrayList<ArrayList<Integer>> getMessages() {
        return messages;
    }

    public void readMessages(){
        String line;
        Scanner in;
        Scanner in2;
        ArrayList <Integer>tmpList;
        try {
            in = new Scanner(inFile);
            while(in.hasNextLine()){
                count++;
                line = in.nextLine();
                tmpList = new ArrayList<>();
                in2 = new Scanner(line);
                while(in2.hasNextInt()){
                    tmpList.add(in2.nextInt());
                }
                messages.add(tmpList);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
