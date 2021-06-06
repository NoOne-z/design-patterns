package com.zh.model.strantegy;

/**
 * @author z
 * @date 2021/5/30
 */
public class Sorter {
    //选择排序
    public void sort(int[] a) {
        for(int i=0;i<a.length-1;i++){
            int minPos=i;
            for(int j=i+1;j<a.length;j++){
                minPos= a[j] < a[minPos] ? j : minPos;
            }
            wap(a,i,minPos);
        }
    }
    static void wap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void sort(Cat[] a) {
        for(int i=0;i<a.length-1;i++){
            int minPos=i;
            for(int j=i+1;j<a.length;j++){
                minPos= a[j].compareTo(a[minPos])==-1 ? j : minPos;
            }
            awap(a,i,minPos);
        }
    }
    static void awap(Cat[] a,int i,int j){
        Cat temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }




}
