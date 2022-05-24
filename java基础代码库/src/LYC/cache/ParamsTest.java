package LYC.cache;

import java.util.ArrayList;
import java.util.List;

public class ParamsTest {
    class Person {
        List list=new ArrayList();
    }
    void test1(){
        List list=new ArrayList();
        Person person=new Person();
        change(list,person);
        System.out.println(list.get(0));
        System.out.println(person.list.get(0));
    }
    List change(List list,Person person){
        person.list.add("fdsf");
        list.add("fdsaf");
        return list ;
    }

    public static void main(String[] args) {
        new ParamsTest().test1();
    }
}
