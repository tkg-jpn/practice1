package com.example.sortpractice;

import java.util.Arrays;

//Git練習中

public class MyQueue<E> {
    private E[] elements;
    private int front;
    private int rear;

    public MyQueue(){
        this(10);
    }

    public MyQueue(int initialCapacity){
        elements=(E[])new Object[initialCapacity];
        front=rear=0;
    }

    private void ensureCapacity(int minCapacity){
        int i,j;
        E[]hold = elements;
        elements=(E[])new Object[minCapacity];
        for(j=0,i=front;i<hold.length;j++,i++){
            elements[j]=hold[i];
        }
        for(i=0;i<rear;j++,i++){
            elements[j]=hold[i];
        }
        front=0;
        rear=hold.length;
    }

    public E peek(){
        return elements[front];
    }

    public void add(E item){
        elements[rear++]=item;
        if(rear==elements.length){
            rear=0;
        }
        if(front==rear){
            ensureCapacity(elements.length*2);
        }
    }

    public  void clear(){
        if(front<rear){
            Arrays.fill(elements,front,rear,null);
        }else {
            Arrays.fill(elements,0,rear,null);
            Arrays.fill(elements,front,elements.length,null);
        }
        front=rear=0;
    }
}
