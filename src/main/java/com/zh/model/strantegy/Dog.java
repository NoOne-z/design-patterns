package com.zh.model.strantegy;

/**
 * @author z
 * @date 2021/5/30
 */
public class Dog implements Comparable{
    int food;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Dog dog =(Dog)o;
        if(this.food < dog.food){
            return -1;
        }else if(this.food > dog.food){
            return 1;
        } else {
            return 0;
        }
    }
}
