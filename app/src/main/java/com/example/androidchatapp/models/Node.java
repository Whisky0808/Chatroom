package com.example.androidchatapp.models;

public class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(T dataPortion) {
        this(dataPortion, null, null);
    }

    public Node(T dataPortion, Node<T> nextNode, Node<T> prevNode) {
        data = dataPortion;
        next = nextNode;
        prev = prevNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T newData) {
        data = newData;
    }

    public Node<T> getNextNode() {
        return next;
    }

    public void setNextNode(Node<T> nextNode) {
        next = nextNode;
    }

    public Node<T> getPrevNode() {
        return prev;
    }

    public void setPrevNode(Node<T> prevNode) {
        prev = prevNode;
    }
}
