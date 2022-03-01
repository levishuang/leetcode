package learn_test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @package: learn_test
 * @Description:
 * @author: jilai_huang
 * @date: 2022/2/25 10:39
 */

public class TestReflect {
    public static void main(String[] args) {
        Class student = null;
        try {
            student = Class.forName("learn_test.Student");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        //返回对象的所有公有属性
        Field[] fields = student.getFields();
        for(Field f:fields){
            System.out.println(f);
        }
        System.out.println("----------------------------------");
        //返回对象的所有属性，但不包含继承
        Field[] declaredFields = student.getDeclaredFields();
        for(Field f:declaredFields){
            System.out.println(f);
        }
        System.out.println("----------------------------------");
        //获取对象所有公共方法
        Method[] methods = student.getMethods();
        for(Method m:methods){
            System.out.println(m);
        }
        System.out.println("----------------------------------");
        //获取对象所有方法，但不包含继承
        Method[] declaredMethods = student.getDeclaredMethods();
        for(Method m:declaredMethods){
            System.out.println(m);
        }
        System.out.println("----------------------------------");
        //获取对象的所有公共构造方法
        Constructor[] constructor = student.getConstructors();
        for(Constructor c:constructor){
            System.out.println(c);
        }
        System.out.println("----------------------------------");
        //获取对象的所有构造方法
        Constructor[] declaredConstructor = student.getDeclaredConstructors();
        for(Constructor d:declaredConstructor){
            System.out.println(d);
        }
        System.out.println("----------------------------------");
        Class c = null;
        try {
            c = Class.forName("learn_test.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //实例化默认构造函数
            Student student1 = (Student)c.newInstance();
            student1.setAddress("xuzhou");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            //取得全部构造函数，使用构造函数赋值
            Constructor constructor1 = c.getConstructor(String.class,int.class,String.class,String.class);
            Student student2 = (Student) constructor1.newInstance("sss", 5, "sss", "aaa");
            //获取方法
            Method show = c.getMethod("showInfo");
            //执行方法
            Object object = show.invoke(student2);
            System.out.println(object);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
