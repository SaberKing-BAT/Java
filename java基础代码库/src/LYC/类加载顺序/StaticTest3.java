package LYC.类加载顺序;

public class StaticTest3 {
    String string="你好";

    public static void main(String[] args) {
        staticFunction();
    }

    static StaticTest3 st = new StaticTest3();

    static {   //静态代码块
        if (st==null)
            System.out.println("null");
        System.out.println("1"+st.string);
    }

    {       // 实例代码块
        System.out.println("2");
    }

    StaticTest3() {    // 实例构造器
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {   // 静态方法
        System.out.println("4");
    }

    int a = 110;    // 实例变量
    static int b = 112;     // 静态变量


}
