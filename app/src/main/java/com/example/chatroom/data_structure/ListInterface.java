package com.example.chatroom.data_structure;

import java.util.Comparator;

public interface ListInterface<T> {

    /**
     * Returns the current size of this list
     * @return size
     */
    public int size();

    /**
     * Returns the element at the specified position in the list
     * @param index the specified position
     * @return the data represented by the specified element
     */
    public T get(int index);

    /**
     * Appends the specified element to the end of this list
     * @param newEntry the element to add
     * @return {@code true}
     */
    public boolean add(T newEntry);

    /**
     * Retrieves and removes the head (first element) of this list
     * @return the data represented by the removed element
     */
    public T remove();

    /**
     * Removes all of the elements from this list
     * The list will be empty after this call returns
     */
    public void clear();

    /**
     * Returns whether this list is empty or not
     * @return true when this list is empty, false when not
     */
    public boolean isEmpty();

    /**
     * Returns true if this list contians the specified element
     * @param o element whose presence in this collection is to be tested
     * @return true if this list contains the specified element, false if not
     */
    public boolean contains(Object o);

    /**
     * Returns an array containing all of the elements in this list in proper sequence
     * @return an array containing all of the elements in this list in proper sequence
     */
    public Object[] toArray();

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param index the specified position
     * @param entry the new element to replace
     * @return the replaced element
     */
    public T set(int index, T entry);
}
