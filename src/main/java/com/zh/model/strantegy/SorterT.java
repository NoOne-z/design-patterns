package com.zh.model.strantegy;

/**
 * @author z
 * @date 2021/5/31
 */
public class SorterT<T> {
    public void sort(T[] a,Comparator<T> comparator) {
        for(int i=0;i<a.length-1;i++){
            int minPos=i;
            for(int j=i+1;j<a.length;j++){
                minPos= comparator.compare(a[j],a[minPos]) == -1 ? j : minPos;
            }
            wap(a,i,minPos);
        }
    }
    //由于泛型，去掉了static
    void wap(T[] a,int i,int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
