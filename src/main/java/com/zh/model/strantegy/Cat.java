package com.zh.model.strantegy;

/**
 * @author z
 * @date 2021/5/30
 */
public class Cat {
    int weight,height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
    //定义cat比较方式
    public int compareTo(Cat c){
        //当前weight小，即小
        if(this.weight < c.weight){
            return -1;
        }else if(this.weight > c.weight){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
