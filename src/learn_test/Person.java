package learn_test;

/**
 * @package: learn_test
 * @Description:反射学习
 * @author: jilai_huang
 * @date: 2022/2/25 10:28
 */

public class Person {
    public String name;
    public int age;

    public Person() {
        super();
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String showInfo() {
        return "name=" + name + ", age=" + age;
    }
}
