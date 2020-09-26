package com.example.sortpractice;

public class CombSort {
    private int[] sortItem;

    public CombSort(int[] item){
        this.sortItem=item;
        sort();
    }

    private void sort(){
        int gap=sortItem.length;
        int counter=0;
        do {
            int index=0;
            counter=0;
            gap= Math.toIntExact((long) Math.floor(gap / 1.3));
            if(gap==0){gap=1;}
            while (index + gap < sortItem.length) {
                if (sortItem[index] > sortItem[index + gap]) {
                    int holder = sortItem[index];
                    sortItem[index] = sortItem[index + gap];
                    sortItem[index + gap] = holder;
                    counter++;
                }
                index++;
            }
            if(gap<=1&&counter==0){
                break;
            }
        }while (true);
    }

    public int[] getSortItem(){
        return this.sortItem;
    }
}
