package LYC.反射;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public <T> List<T> test(T t){
        List<T> list=new ArrayList<>();
        T t1=
        return list;
    }

    public static void main(String[] args) {

    }
}
class A{
    private String name;
    private int age;
    public A() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class B{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public B() {
    }
}