package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Monika on 01.02.2017.
 */
public class DecoderHamming {
    int[][]H;

    DecoderHamming(){
        H = new int[][]{
                { 0, 0, 0, 1, 1, 1, 1},
                { 0, 1, 1, 0, 0, 1, 1},
                { 1, 0, 1, 0, 1, 0, 1},
        };
    }

    ArrayList<ArrayList<Integer>> multiDecode(ArrayList<ArrayList<Integer>> messages){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < messages.size(); i++) {
            result.add(decode(messages.get(i)));
        }
        return result;
    }

    ArrayList decode(ArrayList<Integer> wiad){//wiad = _ _ _ _ _ _ _
        ArrayList result = new ArrayList();//odkodowany CIAG (dl 7)
        ArrayList decodedMessage;//odkodowana wiadmosc (dl 4)
        int tmpValue = 0;
        boolean isCorrect = true;
        for (int i = 0; i < H.length; i++) {
            tmpValue = 0;
            for (int j = 0; j < H[i].length; j++) {
                tmpValue += H[i][j]*wiad.get(j);
            }

            tmpValue = tmpValue%2;
            result.add(tmpValue);
            if(tmpValue != 0){
                isCorrect = false;
            }
        }
        if (!isCorrect){
            decodedMessage = new ArrayList(correct(wiad, result).subList(0,4));
        } else{
            decodedMessage = new ArrayList(wiad.subList(0,4));
        }

        return decodedMessage;
    }

    ArrayList<Integer> correct(ArrayList<Integer> wiad, ArrayList<Integer> bit){
        int bitNumber = 0;
        for (int i = bit.size() - 1; i >= 0; i--) {
            bitNumber += bit.get(i) * Math.pow(2,i);
        }
        --bitNumber;//index w tablicy wiec -1

        if (wiad.get(bitNumber) == 0){
            wiad.set(bitNumber, 1);
        } else{
            wiad.set(bitNumber,0);
        }

        return wiad;
    }

    File saveToFile(String saveFileText, ArrayList<ArrayList<Integer>> decodedMessages){

        File savedFile = new File(saveFileText);
        try {
            PrintWriter printWriter = new PrintWriter(saveFileText);
            for (int i = 0; i < decodedMessages.size(); i++) {
                printWriter.println(decodedMessages.get(i).toString().replaceAll("\\[", "").replaceAll("\\]","").replaceAll(",",""));
            }
//            printWriter.println(result);


            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return savedFile;
    }
}
