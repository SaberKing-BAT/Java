package LYC.反射;



interface Animal{
    public void say();
}
class Cat implements Animal{

    @Override
    public void say() {
        System.out.println("喵喵喵");
    }
}
class Dog implements Animal{

    @Override
    public void say() {
        System.out.println("汪汪汪");
    }
}
public class Interfaces_Test {
    public static void main(String[] args) {
        Animal animal=new Cat();
        animal.say();
    }
}
