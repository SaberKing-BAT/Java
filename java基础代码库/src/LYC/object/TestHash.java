package LYC.object;

import java.util.ArrayList;
import java.util.List;


//万物皆可转object
class Person{
    private String Name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class TestHash {
    //局部变量
    public static void localVariables(){
        String string;
        System.out.println("局部变量不赋值不能使用");
    }
    public static void list(Object object){
        List<Person> people = (List<Person>) object;
        for (Person p:people
             ) {
            System.out.println(p.toString());
        }
    }
    public static void main(String[] args) {
        List<Person> people=new ArrayList<>();
        people.add(new Person());
        list(people);
        localVariables();
    }
}
