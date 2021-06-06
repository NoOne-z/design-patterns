package com.zh.model.strantegy;

/**
 * @author z
 * @date 2021/5/31
 */
public class Cow {
    int weight,height;

    public Cow(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
