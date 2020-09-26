package com.example.sortpractice;

public class InsertSort {
    private int[] sortItem;
    public InsertSort(int[] factor) {
        this.sortItem=factor;
        sort();
    }

    private void sort(){
        int j,i;
        for(i=0;i<sortItem.length;i++){
            int holder=sortItem[i];
            for(j=i;j>0&&sortItem[j-1]>holder;j--) {
                sortItem[j]=sortItem[j-1];
            }
            sortItem[j]=holder;
        }
    }

    public int[] getSortItem() {
        return sortItem;
    }
}
