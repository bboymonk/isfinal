package com.isfinal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by wjb on 2018/1/29.
 * 添加分支
 */
public class Wjb {
    private Wjb(){}
    private static class innerWjb{
        private static final Wjb instnce = new Wjb();
    }
    public static Wjb getInstance(){
        return innerWjb.instnce;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Wjb w1 = Wjb.getInstance();
        Wjb w2 = Wjb.getInstance();

        Class<Wjb> clazz = (Class<Wjb>)Class.forName("com.isfinal.Wjb");
        Constructor<Wjb> c = clazz.getDeclaredConstructor(null);
        c.setAccessible(true);
        Wjb a = c.newInstance();
        Wjb b = c.newInstance();

        System.out.println(w1);
        System.out.println(w2);
        System.out.println(a);
        System.out.println(b);






    }


}
