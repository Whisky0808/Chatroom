package com.example.chatroom.data_structure;
public class SuperArrayList<T> implements SuperList<T> {
    private Object[] elements; // Use Object array to store elements to avoid generic array creation issues
    private int size = 0;      // The number of elements actually stored

    private static final int DEFAULT_CAPACITY = 10; // Default initial capacity

    public SuperArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    @Override
    public void add(T element) {
        ensureCapacity(); // Ensure there is enough space before adding
        elements[size++] = element; // Add element and increment size
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index]; // Cast is safe here
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // Clear to let GC do its work
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
