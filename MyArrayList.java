package com.example.sortpractice;


import java.util.Arrays;

public class MyArrayList<E> {
    private E[] elements;
    private int size;

    public MyArrayList(){
        this(10);
    }

    public MyArrayList(int capacity){
        elements=(E[])new Object[capacity];
        size=0;
    }

    private void ensureCapacity(int minCapacity){
        elements= Arrays.copyOf(elements,minCapacity);
    }

    public int size(){return size;}

    public boolean add(E element){
        if(size==elements.length){
            ensureCapacity(size*2);
        }
        elements[size++]=element;
        return true;
    }

    public boolean contains(E element){
        for(int i=0;i<elements.length;i++){
            if(elements[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    public E get(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    public boolean remove(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException();
        }
        for(int i=index;i<(elements.length-1);i++){
            elements[i]=elements[i++];
        }
        elements[elements.length-1]=null;
        size--;
        return true;
    }

    public boolean remove(E element){
        for(int i=0;i<elements.length;i++){
            if(elements[i]==element){
                for(int j=i;j<(elements.length-1);j++){
                    elements[j]=elements[j++];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean replace(int index,E element){
        elements[index]=element;
        return true;
    }

    public boolean insert(int index,E element){
        if(index>=0&&index<=elements.length){
            if (size==elements.length) {
                ensureCapacity(size * 2);
            }
            for(int i=elements.length;i>=index;i--){
                elements[i+1]=elements[i];
            }
        }else{throw new IndexOutOfBoundsException();}
        return true;
    }
}
