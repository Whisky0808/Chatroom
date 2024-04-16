package com.example.androidchatapp.models;


import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedNodeList<T> implements ListInterface<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;

    public LinkedNodeList() {
        size = 0;
        first = null;
        last = null;
    }

    /**
     * Check if the specified position is within the range of the list
     * @param index the specified position
     */
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Inserts the specified element at the beginning of this list
     * @param newEntry the element to add
     * @return {@code true}
     */
    public boolean addFirst(T newEntry) {
        Node<T> f = first;
        Node<T> newNode = new Node<>(newEntry, f, null);
        first = newNode;

        if (f == null) {
            last = newNode;
        }
        else {
            f.setPrevNode(newNode);
        }

        size++;
        return true;
    }

    /**
     * Appends the specified element to the end of this list
     * @param newEntry the element to add
     * @return {@code true}
     */
    public boolean addLast(T newEntry) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(newEntry, null, l);
        last = newNode;

        if (l == null) {
            first = newNode;
        }
        else {
            l.setNextNode(newNode);
        }

        size++;
        return true;
    }

    /**
     * Appends the specified element to the end of this list
     * @param newEntry the element to add
     * @return {@code true}
     */
    @Override
    public boolean add(T newEntry) {
        addLast(newEntry);
        return true;
    }

    /**
     * Retrieves and removes the first element of this list
     * @return the data represented by the removed element
     */
    public T removeFirst() {
        Node<T> f = first;

        if (f == null) {
            throw new NoSuchElementException();
        }

        final T removed = f.getData();

        Node<T> next = f.getNextNode();
        f.setData(null);
        f.setNextNode(null);
        first = next;

        if (next == null) {
            last = null;
        }
        else {
            next.setPrevNode(null);
        }

        size--;
        return removed;
    }

    /**
     * Retrieves and removes the last element of this list
     * @return the data represented by the removed element
     */
    public T removeLast() {
        Node<T> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }

        final T removed = l.getData();

        Node<T> prev = l.getPrevNode();
        l.setData(null);
        l.setPrevNode(null);
        last = prev;

        if (prev == null) {
            first = null;
        }
        else {
            prev.setNextNode(null);
        }

        size--;
        return removed;
    }

    /**
     * Retrieves and removes the head (first element) of this list
     * @return the data represented by the removed element
     */
    @Override
    public T remove() {
        return removeFirst();
    }

    /**
     * Removes all of the elements from this list
     * The list will be empty after this call returns
     */
    @Override
    public void clear() {
        for (Node<T> n = first; n != null; ) {
            Node<T> next = n.getNextNode();
            n.setData(null);
            n.setNextNode(null);
            n.setPrevNode(null);
            n = next;
        }
        first = last = null;
        size = 0;
    }

    /**
     * Returns the first element in the list
     * @return the data represented by the first element
     */
    public T getFirst() {
        Node<T> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return f.getData();
    }

    /**
     * Returns the last element in the list
     * @return the data represented by the last element
     */
    public T getLast() {
        Node<T> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return l.getData();
    }

    /**
     * Returns the element at the specified position in the list
     * @param index the specified position
     * @return the data represented by the specified element
     */
    @Override
    public T get(int index) {
        checkElementIndex(index);

        T data = null;
        if (index < size / 2) {
            Node<T> n = first;
            for (int i = 0; i < index; i++) {
                n = n.getNextNode();
            }
            data = n.getData();
        }
        else {
            Node<T> n = last;
            for (int i = size - 1; i > index; i--) {
                n = n.getPrevNode();
            }
            data = n.getData();
        }
        return data;
    }

    /**
     * Returns the current size of this list
     * @return size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns whether this list is empty or not
     * @return true when this list is empty, false when not
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the index of specified element in this list
     * @param o the specified element
     * @return the index of the element if it is in this list, -1 if not
     */
    private int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<T> n = first; n != null; n = n.getNextNode()) {
                if (n.getData() == null) {
                    return index;
                }
                index++;
            }
        }
        else {
            for (Node<T> n = first; n != null; n = n.getNextNode()) {
                if (o.equals(n.getData())) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    /**
     * Returns true if this list contians the specified element
     * @param o element whose presence in this collection is to be tested
     * @return true if this list contains the specified element, false if not
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence
     * @return an array containing all of the elements in this list in proper sequence
     */
    @NonNull
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size]; // Unchecked cast

        int index = 0;
        Node<T> currentNode = first;
        while ((index < size) && (currentNode != null))
        {
            result[index] = currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        }
        return result;
    }

    public void sort(Comparator<? super T> c) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);
//        ListIterator<T> i = this.listIterator();
//        for (Object e : a) {
//            i.next();
//            i.set((T) e);
//        }
    }
}
