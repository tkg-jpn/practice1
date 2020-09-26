package com.example.sortpractice;

import java.net.PortUnreachableException;

public class MyHashMap<E> {
    private Node<E>[] buckets;
    private int size;

    private static class Node<E>{
        private E element;
        private Node<E> next;
        Node(E element){
            this.element=element;
            next=null;
        }
    }

    public MyHashMap(){
        this(11);
    }

    public MyHashMap(int capacity){
        buckets=(Node<E>[])new Node[capacity];
        size=0;
    }

    public int size(){
        return size;
    }

    private int hash(E element){
        return element.hashCode()%buckets.length;
    }

    public boolean add(E element){
        Node<E>node,pos;
        int k;
        node=new Node<E>(element);
        k=hash(element);
        pos=buckets[k];
        while (pos!=null){
            if(pos.element.equals(element)){
                return false;
            }
            pos=pos.next;
        }
        node.next=buckets[k];
        buckets[k]=node;
        size++;
        return true;
    }

    public  boolean contains(E element){
        Node<E> pos;
        int k;
        k=hash(element);
        pos=buckets[k];
        while(pos!=null){
            if(pos.element.equals(element)){
                return true;
            }
            pos=pos.next;
        }
        return false;
    }

    public  boolean remove(E element){
        Node<E> q,pos;
        int k;
        k=hash(element);
        pos=buckets[k];
        q=null;
        while(pos!=null){
            if(pos.element.equals(element)){
                if(q!=null){
                    q.next=pos.next;
                }else{
                    buckets[k]=pos.next;
                }
                size--;
                return true;
            }
            q=pos;
            pos=pos.next;
        }
        return false;
    }

}
