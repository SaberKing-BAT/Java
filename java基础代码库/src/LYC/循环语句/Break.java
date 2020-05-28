package LYC.循环语句;
/*
    break 跳出多重循环的三种方式。
    1. 标志位 flag： break flag；
    2. 加判断
*/
public class Break {
    public static void main(String[] args) {
        break1();
        break2();
        break3();
    }
    // 方法1
    static void break1(){
        flag1:
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                System.out.println(j);
                break flag1;
            }
        }
    }
    //方法2
    static void break2(){
        boolean flag=true;
        for (int i = 0; i < 10 && flag; i++){
            for (int j = 0; j < 10 && flag; j++){
                System.out.println(j);
                flag=false;
            }
        }
    }

    static void break3(){
        boolean flag=true;
        for (int i = 0; i < 10 && flag; i++){
            for (int j = 0; j < 10; j++){
                System.out.println(j);
                flag=false;
                break;
            }
        }
    }
}
