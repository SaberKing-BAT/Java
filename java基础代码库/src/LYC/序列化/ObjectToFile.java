package LYC.序列化;

import LYC.common.Person;
import oracle.sql.BFILE;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ObjectToFile {
    private static String fileName="D:\\study\\TempFolder\\serialize.txt";
    public static void objectToFile(Object obj, String fileName) throws IOException {
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fileName,true));
        oos.writeObject(obj);
        oos.close();
    }
    public static Object fileToObject(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fileName));
        Object object= ois.readObject();
        ois.close();
        return object;
    }

    public static void testObjectToFile()  {
        List<Person> personList=new ArrayList<>();
        List<Person> family=new ArrayList<>();

        Person p1=new Person("lili",12,true,null);
        family.add(p1);
        Person p2=new Person("wawa",24,true,family);
        personList.add(p1);
        personList.add(p2);
        try {
            objectToFile(personList,fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void testFileToObject(){
        try {
            List<Person> personList= (List<Person>) fileToObject(fileName);
            for (Person p:personList
                 ) {
                System.out.println(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void test3(){
        Person p1=new Person("jj",12,true,null);
        Person p2=new Person("ll",14,true,null);
        try {
            objectToFile(p1,fileName);
            objectToFile(p2,fileName);
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fileName));
            Person rp1= (Person) ois.readObject();
            Person rp2= (Person) ois.readObject();
            ois.close();
            System.out.println(rp1);
            System.out.println(rp2);
        } catch (Exception e) {
            e.printStackTrace();
            /*
            * java.io.StreamCorruptedException: invalid type code: AC
            * 由于用FileInputStream（文件名，true）向同一个文件中序列化对象，每次都会向文件中序列化一个header。在反序列化的时候每个 ObjectInputStream
            * 对象只会读取一个header，那么当遇到第二个的时候就会报错，导致出现异常。
            * 详情：https://blog.csdn.net/mingyang_2016/article/details/75208117
            */
        }

    }
    public static void main(String[] args) {
//        testObjectToFile();
//        testFileToObject();
        test3();
    }
}
