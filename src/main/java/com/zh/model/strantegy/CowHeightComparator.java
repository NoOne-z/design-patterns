package com.zh.model.strantegy;

/**
 * @author z
 * @date 2021/5/31
 */
public class CowHeightComparator implements Comparator<Cow>{

    @Override
    public int compare(Cow t1, Cow t2) {
        //当前weight小，即小
        if(t1.height < t2.height){
            return -1;
        }else if(t1.height > t2.height){
            return 1;
        }else{
            return 0;
        }
    }
}
