package LYC.common;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {
    String name;
    int age;
    boolean married;
    List<Person> family;

    public Person(String name, int age, boolean married, List<Person> family) {
        this.name = name;
        this.age = age;
        this.married = married;
        this.family = family;
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

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public List<Person> getFamily() {
        return family;
    }

    public void setFamily(List<Person> family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", married=" + married +
                ", family=" + family +
                '}';
    }
}
