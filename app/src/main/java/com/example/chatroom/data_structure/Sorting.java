package com.example.chatroom.data_structure;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorting<T extends Comparable<T>> extends ArrayList<T>{
    public Sorting(){
        super();
    }
    public void sortList(){
        Object List = null;
        Collections.sort(this);
    }
    public void sortList(Comparator<T> comparator) {
        Collections.sort(this, comparator);
    }

}
