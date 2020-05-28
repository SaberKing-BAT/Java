package LYC.源码分析;

public class MainTest {
    public static void main(String[] args) {
        for (int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
    }
}
/*
            1. 主函数public：程序调用的第一个方法，必须是对java环境可见的，及public
            2. 主函数static：jvm调用此方法时不会生成类的实例，所以static
            3. 主函数void:没有返回类型。
            4. String[] args:命令行传入的类型，和参数。IDEA中配置：run->Edit config->program arg
       复习命令：
            1. 进入命令行：IDEA->Terminal或者CMD
            2. 进入Src（项目目录）下
                1.编译：javac -encoding UTF-8 LYC/源码分析/MainTest.java  （需要指定编码，全类名用/分割）
                2.运行：java LYC/源码分析/MainTest arg1 arg2 arg3        （类名不带.java,main参数用空格分割）
        */