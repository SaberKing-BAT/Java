package LYC.Json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName FastJsonToObject
 * @Description Json 和 List的相互转换
 *              一，实体类必须实现Serializable；
 *              二，必须要有 set方法，不然值为空。
 * @Author LYC
 * @Date 2020/6/17 14:49
 * @Version 1.0
 **/

class Person implements Serializable {
    String name;
    int age;
    Date brith;
    BigDecimal num;
    public Person(){}
    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age, Date brith) {
        this.name = name;
        this.age = age;
        this.brith = brith;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   // @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getBrith() {
        return brith;
    }

    //@JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public void setBrith(Date brith) {
        this.brith = brith;
    }

    public int getAge() {
        return age;
    }

    //@JSONField(name = "A")
    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", brith=" + brith +
                ", num=" + num +
                '}';
    }
}
public class FastJsonToObject {
    public static void jsonAndList(){
        String jsonStr="{\"data\":[{\"name\":\"123\",\"age\":\"12\",\"brith\":\"2020-12-12 12:12:12\",\"num\":\"2312\"},{\"name\":\"321\",\"age\":\"22\",\"brith\":\"2020-12-12 12:12:12\",\"num\":\"2312\"}]}";
        JSONObject jsonObjectj = JSONObject.parseObject(jsonStr);
        String listStr =  jsonObjectj.getString("data");
        System.out.println(listStr);
        List<Person> people = JSON.parseArray(listStr,Person.class);
        for (Person p:people
             ) {
            System.out.println(p);
        }
        Date date =new Date();
        String  str= JSON.toJSONString(new Person("123",123,date));
        System.out.println(str);
    }
    public static void jsonAndList2(){
        String str= "[{\"name\":\"123\",\"A\":12,\"brith\":\"2020-12-12 12:12:12\"}]";
        List<Person> people = JSON.parseArray(str,Person.class);
        System.out.println(str);
        for (Person p:people
             ) {
            System.out.println(p);
        }
    }
    public static void main(String[] args) {
        jsonAndList();
//        jsonAndList2();
    }
}
