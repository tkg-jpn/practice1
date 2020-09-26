package com.example.sortpractice;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyHeap<E> {
    private E[] elements;
    private int size;

    public MyHeap(){
        this(10);
    }

    public MyHeap(int capacity){
        elements=(E[])new Object[capacity+1];
        size=0;
    }

    public int size(){
        return  size;
    }

    public void ensureCapacity(int minCapacity) {
        elements= Arrays.copyOf(elements,minCapacity);
    }

    public void add(E element){
        int child,parent;
        if(size+1==elements.length){
            ensureCapacity(size*2);
        }
        child=++size;
        parent=child/2;
        while(parent>=1){
            if(((Comparable<E>)element).compareTo(elements[parent])>=0){
                break;
            }
            elements[child]=elements[parent];
            child=parent;
            parent=child/2;
        }
        elements[child]=element;
    }

    public E remove(){
        E retv,hold;
        int child,parent,c_l,c_r;
        if(size==0){
            throw new NoSuchElementException();
        }
        retv=elements[1];
        hold=elements[size--];
        parent=1;
        while(parent<=size/2){
            c_l=parent*2;
            c_r=c_l+1;
            if(c_r<=size&&(((Comparable<E>)elements[c_r]).compareTo(elements[c_l])<0)){
                child=c_r;
            }else{
                child=c_l;
            }
            if(((Comparable<E>)hold).compareTo(elements[child])<=0){
                break;
            }
            elements[parent]=elements[child];
            parent=child;
        }
        elements[parent]=hold;
        elements[size+1]=null;
        return  retv;
    }

    public E peek(){
        if(size==0){
            throw  new NoSuchElementException();
        }
        return  elements[1];
    }

    public void make_heap(E[] values,int size){
        E hold;
        int child,parent,c_l,c_r;
        this.size=size;
        if(size>=elements.length){
            ensureCapacity(size+1);
        }
        for(int i=1;i<=size;i++){
            elements[i]=values[i];
        }
        for(int r=size/2;r>=1;r--){
            hold=elements[r];
            parent=r;
            while (parent<=size/2){
                c_l=parent*2;
                c_r=c_l+1;
                if(c_r<=size&&((Comparable<E>)elements[c_r]).compareTo(elements[c_l])<0){
                    child=c_r;
                }else{
                    child=c_l;
                }
                if(((Comparable<E>)hold).compareTo(elements[child])<=0){
                    break;
                }
                elements[parent]=elements[child];
                parent=child;
            }
            elements[parent]=hold;
        }
    }


}
