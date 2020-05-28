package LYC.题库.基础;

public class Operation {
    public static void main(String[] args) {
        int i=1,j=2;
        i+=++j;
        System.out.println(i);
        System.out.println(i+++j<<2);//4+4*
    }
}
/*
    1. 算式中的++j不会改变自身，j还是原来的值
    2. <<位移运算优先级低于+-x/
    3. ++j在运算中是独立的不可分割的
    4.位移 x << 1 = x*2; x << 2 = x * 2*2扩大2的n次幂
* */