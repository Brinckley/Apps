package com.company;

interface IQueue<T>{
    void add(T item);
    T remove();

    boolean isEmpty();

}

public class Queue<T> implements IQueue<T>{

    @Override
    public void add(T item) {

    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
