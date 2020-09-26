package com.example.sortpractice;

public class ShakerSort {
    private int[] sortItem;

    public ShakerSort(int[] item){
        sortItem=item;
        sort();
    }

    private void sort(){
        int lastIndex=sortItem.length-1;
        int firstIndex=0;
        while (firstIndex<lastIndex){
                for (int j = firstIndex; j < lastIndex; j++) {
                    int holder=sortItem[j];
                    int next=sortItem[j+1];
                    if(holder>next){
                        sortItem[j]=next;
                        sortItem[j+1]=holder;
                    }
                }
                lastIndex--;
                for(int j=lastIndex;j>firstIndex;j--){
                    int holder=sortItem[j];
                    int next=sortItem[j-1];
                    if(holder<next){
                        sortItem[j]=next;
                        sortItem[j-1]=holder;
                    }
                }
                firstIndex++;

        }
    }
    public int[] getSortItem(){
        return sortItem;
    }
}
