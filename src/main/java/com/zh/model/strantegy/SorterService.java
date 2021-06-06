package com.zh.model.strantegy;

/**
 * @author z
 * @date 2021/5/30
 */
public class SorterService {
    //无泛型
    public void sort(Comparable[] a) {
        for(int i=0;i<a.length-1;i++){
            int minPos=i;
            for(int j=i+1;j<a.length;j++){
                minPos= a[j] .compareTo(a[minPos]) == -1 ? j : minPos;
            }
            wap(a,i,minPos);
        }
    }
    static void wap(Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //添加泛型
    public void sort(ComparableT[] a) {
        for(int i=0;i<a.length-1;i++){
            int minPos=i;
            for(int j=i+1;j<a.length;j++){
                minPos= a[j] .compareTo(a[minPos]) == -1 ? j : minPos;
            }
            wap(a,i,minPos);
        }
    }
    static void wap(ComparableT[] a,int i,int j){
        ComparableT temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
