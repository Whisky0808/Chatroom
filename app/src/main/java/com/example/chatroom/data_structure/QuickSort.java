package com.example.chatroom.data_structure;


import com.example.chatroom.models.ChatMessage;
import java.util.Date;
import java.util.List;

public class QuickSort {

    // A utility function to swap two elements
    static void swap(ListInterface<ChatMessage> messages, int i, int j) {
        ChatMessage temp = messages.get(i);
        messages.set(i, messages.get(j));
        messages.set(j, temp);
    }

    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    static int partition(ListInterface<ChatMessage> messages, int low, int high) {
        // Choosing the pivot
        Date pivot = messages.get(high).dateObject;

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than the pivot
            if (messages.get(j).dateObject.before(pivot)) {
                // Increment index of smaller element
                i++;
                swap(messages, i, j);
            }
        }
        swap(messages, i + 1, high);
        return (i + 1);
    }

    public static void quickSort(ListInterface<ChatMessage> messages, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[p] is now at right place
            int pi = partition(messages, low, high);

            // Separately sort elements before partition and after partition
            quickSort(messages, low, pi - 1);
            quickSort(messages, pi + 1, high);
        }
    }
}

