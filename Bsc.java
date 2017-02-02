package com.company;

import java.util.ArrayList;

/**
 * Created by Monika on 01.02.2017.
 */
public class Bsc {
    double error_probability;

    public Bsc(double f){
        error_probability = f;
    }

    public ArrayList<ArrayList<Integer>> sendMulti(ArrayList<ArrayList<Integer>> messages){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < messages.size(); i++) {
            result.add(send(messages.get(i)));
        }
        return result;
    }

    public ArrayList<Integer> send(ArrayList<Integer> x){
        ArrayList x_temp = x;
        for(int i = 0; i<x.size();i++)
            if(Math.random()<error_probability){
                if (x.get(i) == 0){
                    x_temp.set(i, 1);

                } else{
                    x_temp.set(i,0);
                }
            }
        return x_temp;
    }
}
