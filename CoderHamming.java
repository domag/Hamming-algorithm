package com.company;

import java.util.ArrayList;

/**
 * Created by Monika on 01.02.2017.
 */
public class CoderHamming {
    int wiadBit;
    int infBit;
    int k;
    int[][] G;

    CoderHamming(int wiadBit, int infBit, int k){
        this.infBit = infBit;
        this.wiadBit = wiadBit;
        this.k = k;
        G = new int [][]{
            { 1, 0, 0, 0},
            { 0, 1, 0, 0},
            { 0, 0, 1, 0},
            { 0, 0, 0, 1},
            { 0, 1, 1, 1},
            { 1, 0, 1, 1},
            { 1, 1, 0, 1},
        };
    }

    public ArrayList<ArrayList<Integer>> multiCode (ArrayList<ArrayList<Integer>> messages){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < messages.size(); i++) {
            result.add(code(messages.get(i)));
        }
        return result;
    }

    public ArrayList<Integer> code(ArrayList<Integer> wiad) {
        ArrayList<Integer> zakWiad = new ArrayList<>();// wiad = _ _ _ _
        int tmppValue = 0;

        for (int i = 0; i < G.length; i++) {
            tmppValue = 0;
            for (int j = 0; j < G[i].length; j++) {
                tmppValue += G[i][j]*wiad.get(j);
            }
            zakWiad.add(tmppValue % 2);
        }

        return zakWiad;
    }

}
