package com.example.chatroom.data_structure;

import com.example.chatroom.models.User;

public class UserBag {
    private User[] users;
    private int size;

    public UserBag(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }
        users = new User[initialCapacity];
        size = 0;
    }

    public void addUser(User user) {
        // 确保数组有足够的空间
        if (size == users.length) {
            // 如果数组满了，扩容
            increaseCapacity();
        }
        users[size++] = user;
    }

    private void increaseCapacity() {
        User[] newUsers = new User[users.length * 2];
        System.arraycopy(users, 0, newUsers, 0, users.length);
        users = newUsers;
    }

    public User getUser(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return users[index];
    }

    public int getSize() {
        return size;
    }
}
