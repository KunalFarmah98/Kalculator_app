package com.apps.kunalfarmah.kalculator;

import java.util.ArrayList;

public class RecyclerList {
    int txt;
    int img;


    public RecyclerList( int text,int color){
        txt =text;
        img = color;
    }


    public static ArrayList<RecyclerList> getlist(){
        ArrayList<RecyclerList> values = new ArrayList<>();

        values.add(new RecyclerList(R.string.usg1, R.color.col1));
        values.add(new RecyclerList(R.string.usg2, R.color.col2));
        values.add(new RecyclerList(R.string.usg3, R.color.col3));
        values.add(new RecyclerList(R.string.usg4, R.color.col4));
        values.add(new RecyclerList(R.string.usg5, R.color.col5));
        values.add(new RecyclerList(R.string.usg6, R.color.col6));

        return values;
    }

    public int get_Text(){
        return txt;
    }

    public int get_image(){
        return img;
    }



}