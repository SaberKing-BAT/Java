package LYC.反射;

import java.lang.reflect.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class ClassTest {
    public static <T> List<T> test(Class<T> T) throws IllegalAccessException, InstantiationException {
        List<T> list = new ArrayList<>();
        Class c = T.getClass();
        Field[] fields = c.getFields();
        for (Field f : fields
        ) {
            System.out.println(f.getName());

        }
        //Object o=c.newInstance();
        return list;
    }

    public static <T> void test1(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        Class<?> c = tClass;
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields
        ) {
            System.out.println(f.getName());
        }
        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods
        ) {
            System.out.println(m.getName());
        }
        Object o = c.newInstance();

    }

    public static <T> List<T> parsingExcel(Class<T> tClass, String[] config) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        List<T> list = new ArrayList<>();
        Map<String, Class[]> methodMap = new HashMap();
        Method[] methods = tClass.getDeclaredMethods();
        for (Method m : methods
        ) {
            methodMap.put(m.getName(), m.getParameterTypes());
        }

        T t = tClass.newInstance();
        for (int i = 0; i < config.length; i++) {
            if (config[i] != null && !"".equals(config[i])) {
                Method method = tClass.getDeclaredMethod(config[i], methodMap.get(config[i]));
                String parameterTypeName = methodMap.get(config[i])[0].getTypeName();
                switch (parameterTypeName) {
                    case "int":
                        method.invoke(t, 123);
                        break;
                    case "java.lang.String":
                        method.invoke(t, "lyc");
                        break;
                    case "boolean":
                        break;
                }
            }
        }
        System.out.println(t);
        list.add(t);

        return list;
    }
    /**
     * @Author: LYC
     * @Date: 2020/11/26 17:37
     * @Param: [clzss]
     * @return: java.lang.String
     * @TODO: getName 不靠谱（数组的时候），用getTypeName()
     */
    public static String printTypeName(Class clzss) {
        System.out.println("=====================8种基本类型==========================");
        System.out.println(byte.class + "\n" + short.class + "\n" + int.class + "\n" + long.class + "\n" + float.class + "\n" + double.class + "\n" + char.class + "\n" + boolean.class);
        System.out.println("=========================================================");
        System.out.println(int.class.getName());
        System.out.println(new ArrayList<>().getClass().getName());
        System.out.println(new ArrayList<>().getClass().getTypeName());
        System.out.println(new HashMap<>().getClass().getTypeName());
        System.out.println(new HashSet<>().getClass().getTypeName());
        System.out.println(new HashMap<>().getClass().getTypeName());
        System.out.println(String.class.getTypeName());
        System.out.println(String.class.getName());
        System.out.println(String[].class.getName());
        System.out.println(String[].class.getTypeName());
        System.out.println(int[].class.getTypeName());
        System.out.println(int[].class.getName());
        List<Map<String, Object>> list = new ArrayList<>();
        System.out.println(list.getClass().getName());
        System.out.println(list.getClass().getTypeName());
        System.out.println(A.class.getName());
        System.out.println(A.class.getTypeName());
        System.out.println(clzss.getTypeName());
        System.out.println(BigDecimal.class.getTypeName());
        System.out.println(BigInteger.class.getTypeName());
        return clzss.getTypeName();
    }

    public static void feildType(String FieldName) throws NoSuchFieldException {
        Field field = A.class.getDeclaredField(FieldName);
        //Field field1 = A.class.getField("list");//getField只能用在public修饰的字段

        Type type = field.getGenericType();
        if (type instanceof ParameterizedType) {
            System.out.println("ParameterizedType");
            ParameterizedType type1 = (ParameterizedType) type;
            System.out.println(type1.getRawType().getTypeName());

            System.out.println(type1.getRawType() instanceof Class);//getRawType()返回的实际是Class类型而非Type，且不能强转成ParameterizedType
            System.out.println(type1.getRawType() instanceof ParameterizedType);


            Class type2 = (Class) (type1.getRawType());
            System.out.println(type2.getName());
//            System.out.println(type3.getRawType().getTypeName());
//            System.out.println((ParameterizedType)(type1.getRawType()) instanceof Class);

            Type[] types = ((ParameterizedType) type).getActualTypeArguments();
            for (Type t : types
            ) {
                System.out.println(t.getTypeName());
                ((ParameterizedType) t).getActualTypeArguments();
            }
        }
        if (type instanceof GenericArrayType)
            System.out.println("GenericArrayType");
        if (type instanceof TypeVariable)
            System.out.println("TypeVariable <D>");
        if (type instanceof WildcardType)
            System.out.println("WildcardType");
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //test1(A.class);
        //parsingExcel(A.class,new String[]{"setName","setAge"});
        printTypeName(int.class);
        // feildType("b");
        feildType("list");
        //feildType("ints");
        // feildType("strs");
        //feildType("name");

    }
}

class A {
    private String name;
    private int age;
    private List<Map<String, List<String>>> list;
    private int[] ints;
    private String strs[];
    private B b;

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

    public List<Map<String, List<String>>> getList() {
        return list;
    }

    public void setList(List<Map<String, List<String>>> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class B {
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

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}