package com.zh.model.strantegy;

import java.util.Arrays;

/**
 * @author z
 * @date 2021/5/30
 */
public class Main {

    public static void main(String[] args) {
        //通过sorter的重载方法对int类型数组进行排序
        int[] a={9,2,5,4,6,8,0};
        //通过sorter的重载方法对cat类型数组进行排序
        Cat[] cat={new Cat(9,9),new Cat(3,3),new Cat(1,1),new Cat(5,5)};
        Sorter sorter = new Sorter();
        sorter.sort(a);
        sorter.sort(cat);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(cat));
        //问题1：现在想对各种类型数组进行排序，只能不停的重载吗？

        // out和err混用记录：out和err的一个区别是，out往往是带缓存的，而err没有缓存（默认设置，可以改）。
        // 所以如果你用标准出错打印出来的东西可以马上显示在屏幕，
        // 而标准输出打印出来的东西可能要再积累几个字符才能一起打印出来。
        // 如果你在应用中混用标准输出和标准出错就可能看到这个问题。
        System.out.println("----------------------------------");
        //思路：sort（Object[] a）但是Object 没有compareTo()；所以不可取。
        //      实现Comparable接口 谁想排序，谁实现该接口，重写compareTo()；以Dog和SorterService举例
        Dog[] dog={new Dog(7),new Dog(2),new Dog(1),new Dog(5)};
        SorterService sorterService = new SorterService();
        sorterService.sort(dog);
        System.out.println(Arrays.toString(dog));
        //问题2：compareTo(Object o)涉及强转类型，有可能出现问题


        System.out.println("----------------------------------");
        //思路：将Comparable接口添加泛型，实现该接口时，指定泛型类型；以Pig和ComparableT举例
        Pig[] pig={new Pig(7),new Pig(2),new Pig(1),new Pig(5)};
        sorterService.sort(pig);
        System.out.println(Arrays.toString(pig));
        //问题3：虽然此时sort方法可以让实现ComparableT方法的类进行排序，仍不够灵活
        //  比如，cat目前比较方式是通过weight，我还想通过height比较，怎么办？换言之，cat比较方式可以灵活指定。
        //  总不能将compareTo方法中的代码换掉（违背开闭原则：对扩展开放，对修改关闭），
        //  即使如此，当我想同时拥有更多的比较方式，怎么办？


        System.out.println("----------------------------------");
        //思路：策略模式：自定义比较器（类）实现Comparator接口
        // 以Cow，Comparator，SorterT，以及Cow的各种比较器举例
        Cow[] cow={new Cow(9,6),new Cow(3,2),new Cow(1,3),new Cow(5,7)};
        SorterT<Cow> sorterT = new SorterT<>();
        sorterT.sort(cow,new CowWeightComparator());
        System.out.println(Arrays.toString(cow));
        sorterT.sort(cow,new CowHeightComparator());
        System.out.println(Arrays.toString(cow));

        //策略模式定义：包含一个策略接口和一组策略实现类；策略的创建交给工厂类完成，封装策略创建细节。

        //应用场景：客户端具体确定使用哪种策略，有两种确定方式：
        //          编译时静态确定（静态map，根据不同type，返回不同策略）
        //          运行时动态确定（工厂类，根据不同type，返回新创建的不同策略对象；最典型应用场景）

    }
}
