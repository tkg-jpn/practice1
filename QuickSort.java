package com.example.sortpractice;

public class QuickSort {
    private int[] result;
    public QuickSort(int[] item){
        int size=item.length;
        sort(item,0,size);
    }

    private void sort(int[] sortItem,int head,int size){
        int hold;
        int firstIndex=head;
        int lastIndex=head+size-1;
        int medium=sortItem[(firstIndex+lastIndex)/2];
        while (true) {
            while(sortItem[firstIndex]<medium){
                firstIndex++;
            }
            while(sortItem[lastIndex]>medium){
                lastIndex--;
            }
            if (firstIndex>=lastIndex){
                break;
            }
            hold=sortItem[firstIndex];
            sortItem[firstIndex]=sortItem[lastIndex];
            sortItem[lastIndex]=hold;
            firstIndex++;
            lastIndex--;
        }
        if(firstIndex-head>1){
            sort(sortItem,head,firstIndex-head);
        }
        if (lastIndex+2<head+size){
            sort(sortItem,lastIndex+1,head+size-1-lastIndex);
        }
        this.result=sortItem;
    }

    public int[] getSortItem() {
        return this.result;
    }
}
