package learn_test;

/**
 * @package: learn_test
 * @Description:
 * @author: jilai_huang
 * @date: 2022/2/25 10:34
 */

public class Student extends Person {
    public String className;
    private String address;

    public Student() {
        super();
    }

    public Student(String name, int age, String className, String address) {
        super(name, age);
        this.className = className;
        this.address = address;
    }

    public Student(String className) {
        this.className = className;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "name=" + name + ",age=" + age + ",class=" + className + ",address=" + address;
    }

}

