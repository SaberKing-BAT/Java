package LYC.object;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/**
 * @ClassName ObjectParam
 * @Description TODO
 * @Author LYC
 * @Date 2020/6/18 17:08
 * @Version 1.0
 **/
class people{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void say(){
        System.out.println("人");
    }
}
class annimal{
    void say(){
        System.out.println("动物");
    }
}
public class ObjectParam {

    public static Object returnObject(){
        String name="gaga";
        return name;
    }

    public static void say(Object object){

    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        people people=new people();
       // people.setName(returnObject());
       /* Class c=Class.forName("LYC.object.people");
       Object o= c.newInstance();
       c.getDeclaredMethod("say").invoke(o);*/
        Class c=Class.forName("java.lang.String");
        Object o= c.getConstructor(String.class).newInstance("fdsfsd");
        String str=(String) c.getDeclaredMethod("toString").invoke(o);
        System.out.println(str);
        System.out.println(String.class.getName());
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
    }
}
