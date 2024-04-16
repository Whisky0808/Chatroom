package com.example.chatroom.data_structure;

public interface SuperList<T> {
    void add(T element);
    T get(int index);
    void remove(int index);
    int size();

    boolean isEmpty();
}



