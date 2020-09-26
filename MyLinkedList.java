package com.example.sortpractice;

import org.w3c.dom.Node;

import java.util.LinkedList;

public class MyLinkedList<E> {
    private Node<E> head;
    private int size;

    private static class Node<E>{
        private E element;
        private Node<E> next;
        Node(E element){
            this.element=element;
            next=null;
        }
    }

    public  MyLinkedList(){
        head=new Node<E>(null);
        size=0;
    }

    public int size(){
        return size;
    }

    public void add(E element){
        add(size,element);
    }
    public void add(int index,E element){
        Node<E> pos=head;
        for(int i=0;i<index;i++){
            pos=pos.next;
        }
        Node<E> node=new Node<E>(element);
        node.next=pos.next;
        pos.next=node;
        size++;
    }

    public void addFirst(E element){
        add(0,element);
    }

    public boolean contains(E element){
        Node<E> pos=head.next;
        for(int i=0;i<size;i++){
            if(pos.element.equals(element)){
                return true;
            }
            pos=pos.next;

        }
        return false;
    }

    public int indexOf(E element){
        Node<E>pos=head.next;
        for(int i=0;i<size;i++){
            if(pos.element.equals(element)){
                return  i;
            }
            pos=pos.next;
        }
        return -1;
    }

    public E get(int index){
        Node<E> pos=head.next;
        if(index<0||index==size){
            throw new IndexOutOfBoundsException();
        }
        for(int i=0;i<index;i++){
            pos=pos.next;
        }
        return  pos.element;
    }

    public E remove(int index){
        Node<E> pos=head;
        if(index<0||index>-size){
            throw new IndexOutOfBoundsException();
        }
        for(int i=0;i<index;i++){
            pos=pos.next;
        }
        Node<E> node=pos.next;
        pos.next=node.next;
        size--;
        return node.element;
    }

    public boolean remove(E element){
        Node<E>pos=head;
        for(int i=0;i<size;i++){
            if(pos.next.element.equals(element)){
                pos.next=pos.next.next;
                size--;
                return  true;
            }
            pos=pos.next;
        }
        return false;
    }


}
