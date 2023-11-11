package com.example.bolsadevaloresjavafx.estruturadados;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class DynamicArray<T> {
    private int size;
    private int capacity;
    private Object[] elements;

    public DynamicArray() {
        this(0);
    }

    public DynamicArray(int capacity) {
        this.setCapacity(capacity);
        this.elements = new Object[capacity];
        this.size = 0;
    }

    private void grow(int increase) {
        int newCapacity = this.capacity + increase;
        Object[] array = new Object[newCapacity];

        System.arraycopy(this.elements, 0, array, 0, this.capacity);

        this.elements = array;
        this.setCapacity(newCapacity);
    }

    private void reduce(int decrease) {
        int newCapacity = this.capacity - decrease;
        Object[] array = new Object[newCapacity];

        System.arraycopy(this.elements, 0, array, 0, newCapacity);

        this.elements = array;
        this.setCapacity(newCapacity);
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) this.elements[index];
    }

    public void set(int index, T element) {
        this.elements[index] = element;
    }

    public void add(T element) {
        if (this.isFull()) this.grow(1);
        this.elements[this.size++] = element;
    }

    public void add(int index, T element) {
        if (index >= this.size) throw new RuntimeException("Index out of range");
        if (this.isFull()) this.grow(1);
        for (int i = this.size - 1; i >= index; i--) this.elements[i + 1] = this.elements[i];
        this.elements[index] = element;
        this.size++;
    }

    public void addAll(T[] elements) {
        int increase = this.size + elements.length - this.capacity;

        if (increase > 0) this.grow(increase);

        for (T element : elements) {
            this.elements[this.size++] = element;
        }
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (this.isEmpty()) throw new RuntimeException("Dynamic Array is empty");
        T element = (T) this.elements[index];
        for (int i = index; i < this.size - 1; i++) this.elements[i] = this.elements[i + 1];
        this.reduce(1);
        this.size--;
        return element;
    }

    @SuppressWarnings("unchecked")
    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < this.size; i++) consumer.accept((T) this.elements[i]);
    }

    @SuppressWarnings("unchecked")
    public DynamicArray<T> filter(Predicate<T> predicate) {
        DynamicArray<T> filteredElements = new DynamicArray<>();
        for (Object element : this.elements) {
            T e = (T) element;
            if (predicate.test(e)) filteredElements.add(e);
        }
        return filteredElements;
    }


    private boolean isFull() {
        return this.size == this.capacity;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    private void setCapacity(int capacity) {
        if (capacity < 0) throw new RuntimeException("Capacity must be a non-negative number");
        this.capacity = capacity;
    }
}