package com.example.sortpractice;

public class SimpleSort {
    private int[] sortItem;

    public SimpleSort(int[] Item){
        this.sortItem=Item;
        sort();
    }

    private void sort(){
        for (int i=0;i<sortItem.length;i++){
            int minIndex=i;
            int min=this.sortItem[i];
            for(int j=i;j<sortItem.length;j++){
                if(min>this.sortItem[j]){
                    min=this.sortItem[j];
                    minIndex=j;
                }
            }
            this.sortItem[minIndex]=this.sortItem[i];
            this.sortItem[i]=min;
        }
    }

    public int[] getSortItem(){
        return this.sortItem;
    }
}
