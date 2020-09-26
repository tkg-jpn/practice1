package com.example.sortpractice;

public class MergeSort {
    private int[] sortedList;

    public MergeSort(int[] elements){
        int[] work=new int[elements.length/2];
        sort(elements,0,elements.length,work);
    }

    private void sort(int[] list,int head,int size,int[] work){
        int splitSize;
        int i,j,k;
        if(size<=1){
            return;
        }
        splitSize=size/2;
        sort(list,head,splitSize,work);
        sort(list,head+splitSize,size-splitSize,work);
        //前半部分を作業用配列に移動
        for(i=0;i<splitSize;i++){
            work[i]=list[head+i];
        }
        i=0;
        j=head+splitSize;
        k=head;
        while(i<splitSize&&j<head+size){
            if(work[i]<=list[j]){
                list[k++]=work[i++];
            }else{
                list[k++]=list[j++];
            }
        }
        while(i<splitSize){
            list[k++]=work[i++];
        }
        this.sortedList=list;
    }

    public int[] getSortItem(){
        return sortedList;
    }
}
