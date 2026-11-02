package com.itheima.datasructure.array;

import java.util.Iterator;
import java.util.function.Consumer;

/***
 * 动态数组
 */
public class DynamicArray implements Iterable<Integer> {
    private int size = 0;
    private int capacity = 8;
    private int[] array = new int[capacity];

    public void addLast(int element) {
        // array[size] = element;
        // size++;
        add(size, element);
    }

    public void add(int index, int element) {
        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    public int get(int index) {
        return array[index];
    }

    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            // System.out.println(array[i]);
            consumer.accept(array[i]);

        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
