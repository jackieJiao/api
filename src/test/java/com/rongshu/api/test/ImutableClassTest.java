package com.rongshu.api.test;

import java.util.Date;

public class ImutableClassTest {
    //声明为final的基本类型数据总是不可变的
    private final double fMass;
    //不可变的对象属性 (String对象不可变)
    private final String fName;
    //可变对象的属性,因为可变属性只能被这个类改变，采用深度拷贝的方法来复制一个对象并传入副本的引用
    private final Date fDateOfDiscovery;

    public ImutableClassTest(double aMass, String aName, Date aDateOfDiscovery) {
        fMass = aMass;
        fName = aName;
        //创建aDateOfDiscovery的一个私有拷贝
        //这是保持fDateOfDiscovery属性为private的唯一方式, 并且保护这个
        //类不受调用者对于原始aDateOfDiscovery对象所做任何改变的影响
        //fDateOfDiscovery = new Date(aDateOfDiscovery.getTime());
        fDateOfDiscovery=new Date(aDateOfDiscovery.getTime());
    }
    //返回一个基本类型值.
    public double getMass() {
        return fMass;
    }
    //调用者得到内部属性的一个直接引用. 由于String是不可变的所以没什么影响
    public String getName() {
        return fName;
    }
    //返回一个可变对象的一个保护性拷贝.调用者可以任意改变返回的Date对象,但是不会
    //影响类的内部.为什么? 因为它们没有fDate的一个引用. 更准确的说, 它们
    //使用的是和fDate有着相同数据的另一个Date对象
    public Date getDateOfDiscovery() {
       // return new Date(fDateOfDiscovery.getTime());
       // return fDateOfDiscovery;
        return new Date((fDateOfDiscovery.getTime()));
    }

    public static void main(String[] args) {
        ImutableClassTest planet = new ImutableClassTest(1.0D, "earth", new Date());
        Date date = planet.getDateOfDiscovery();

        date.setTime(111111111L);
        System.out.println("the value of fDateOfDiscovery of internal class : " + planet.fDateOfDiscovery.getTime());
        System.out.println("the value of date after change its value : " + date.getTime());
    }

}
