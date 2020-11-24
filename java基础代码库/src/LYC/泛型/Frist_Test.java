package LYC.泛型;

import com.sun.jna.WString;

import static javafx.scene.input.KeyCode.T;

public class Frist_Test {

    public static void main(String[] args) {
        A a3=new A();       //编译器警告，未受类型检测
        A<String,Double> a=new A<>();  //java1.6以后（不含1.6），声明了A<String> 就可以，后面new可以省略<String>
        a.setFirst("haha");
        a.setSecond("wawa");
       // A<int> a1=new A<int>();
        /*
        *  1. <>中为引用类型，不能为基本类型，
        *  2. 8种基本类型，不属于object，
        *  3. 泛型类型擦除时，会把类型转成object，万物皆可object！！
        * */
        A<Integer,Double> a1=new A<>();
        a1.setSecond(1);
        a1.setSecond(2);

    }
}

/*
* 泛型类
* */
class  A<T,U>{
    private T first ;
    private T second;
    public  A(){
        first=null;
        second=null;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}