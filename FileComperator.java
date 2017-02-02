package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Monika on 02.02.2017.
 */
public class FileComperator {
    File source, destination;
    int correctCount;
    int allCount;

    public FileComperator(File source, File destination) {
        this.source = source;
        this.destination = destination;
        correctCount = 0;
        allCount = 0;
    }

    double compare(){
        double result = 0.;
        String sourceLine, destinationLine;

        try {
            Scanner sourceScanner = new Scanner(source);
            Scanner destScanner   = new Scanner(destination);
            while (sourceScanner.hasNextLine() && destScanner.hasNextInt()){
                ++allCount;
                sourceLine = sourceScanner.nextLine();
                destinationLine = destScanner.nextLine();

                if(sourceLine.equals(destinationLine)){
                    correctCount++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        result = (double)correctCount / (double)allCount;

        return result;
    }
}
