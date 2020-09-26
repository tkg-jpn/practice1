package com.example.sortpractice;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<E> {
    private E[] elements;
    private int size;

    public MyStack(){
        this(10);
    }

    public MyStack(int initialCapacity){
        elements=(E[])new Object[initialCapacity];
        size=0;
    }

    private void ensureCapacity(int minCapacity){
        elements= Arrays.copyOf(elements,minCapacity);
    }

    public boolean empty(){
        return size==0;
    }

    public E peek(){
        return elements[size-1];
    }

    public E pop(){
        if (size==0){
            throw new EmptyStackException();
        }
        E item=elements[--size];
        elements[size]=null;
        return item;
    }

    public E push(E item){
        if(size==elements.length) {
            ensureCapacity(size * 2);
        }
        return  elements[size++]=item;
    }

    public int search(E item){
        for(int index=1;size-index>=0;index++){
            if(elements[size-index].equals(item)){
                return index;
            }
        }
        return  -1;
    }

    public void disp(){
        if(size>0){
            for(int index=0;index<size-1;index++){
                System.out.print(elements[index]+",");
            }
            System.out.println(elements[size-1]);
        }
    }

}
