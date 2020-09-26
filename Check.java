package com.example.sortpractice;

public class Check {
    private int[] elements;
    public Check(int[] elements){
        this.elements=elements;
    }

    public boolean result(){
        for(int i=0;i<elements.length-2;i++){
            if(elements[i]>elements[i+1]){
                return false;
            }
        }
        return true;
    }
}
