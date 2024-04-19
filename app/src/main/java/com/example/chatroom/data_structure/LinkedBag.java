package com.example.chatroom.data_structure;

import java.util.NoSuchElementException;

public class LinkedBag<T> implements BagInterface<T> {
    private Node<T> first;
    private int size;

    public LinkedBag()
    {
        first = null;
        size = 0;
    }

    /**
     * Gets the current number of entries in this bag.
     *
     * @return The integer number of entries currently in the bag.
     */
    @Override
    public int getCurrentSize() {
        return size;
    }

    /**
     * Sees whether this bag is empty.
     *
     * @return True if the bag is empty, or false if not.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if not.
     */
    @Override
    public boolean add(T newEntry) {
        Node<T> f = first;
        Node<T> newNode = new Node<>(newEntry, f, null);
        first = newNode;

        if (f != null)  {
            f.setPrevNode(newNode);
        }

        size++;

        return true;
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return Either the removed entry, if the removal.
     * was successful, or null.
     */
    @Override
    public T remove() {
        Node<T> f = first;

        if (f == null) {
            throw new NoSuchElementException();
        }

        final T removed = f.getData();

        Node<T> next = f.getNextNode();
        f.setData(null);
        f.setNextNode(null);
        first = next;

        if (next != null) {
            next.setPrevNode(null);
        }

        size--;
        return removed;
    }

    /**
     * Removes one occurrence of a given entry from this bag, if possible.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    @Override
    public boolean remove(T anEntry) {
        boolean result = false;

        Node<T> nodeN = getReferenceTo(anEntry);
        if (nodeN != null) {
            nodeN.setData(first.getData());
            first = first.getNextNode();
            size--;
            result = true;
        }

        return result;
    }

    // Locates a given entry within this bag.
    // Returns a reference to the node containing the entry, if located,
    // or null otherwise.
    private Node<T> getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = first;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            } else {
                currentNode = currentNode.getNextNode();
            }
        }
        return currentNode;
    }

    /**
     * Removes all entries from this bag.
     */
    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the bag.
     */
    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        int loopCounter = 0;
        Node currentNode = first;
        while ((loopCounter < size) && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData())) {
                frequency++;
            }
            loopCounter++;
            currentNode = currentNode.getNextNode();
        }
        return frequency;
    }

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry The entry to find.
     * @return True if the bag contains anEntry, or false if not.
     */
    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = first;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        }
        return found;
    }

    /**
     * Returns the element at the specified position in the bag
     * @param index the specified position
     * @return the data represented by the specified element
     */
    @Override
    public T get(int index) {
        checkElementIndex(index);

        Node<T> n = first;
        for (int i = 0; i < index; i++) {
            n = n.getNextNode();
        }
        T data = n.getData();

        return data;
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
     * Retrieves all entries that are in this bag.
     *
     * @return A newly allocated array of all the entries in the bag.
     * Note: If the bag is empty, the returned array is empty.
     */
    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[size]; // Unchecked cast

        int index = 0;
        Node currentNode = first;
        while ((index < size) && (currentNode != null))
        {
            result[index] = (T) currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        } // end while

        return result;
    }
}
