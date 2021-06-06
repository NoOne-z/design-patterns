package com.zh.model.strantegy;

/**
 * @author z
 * @date 2021/5/30
 */
public class Pig implements ComparableT<Pig>{
    int food;

    public Pig(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "food=" + food +
                '}';
    }


    @Override
    public int compareTo(Pig pig) {
        if(this.food < pig.food){
            return -1;
        }else if(this.food > pig.food){
            return 1;
        } else {
            return 0;
        }
    }
}
