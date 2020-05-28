package LYC.循环语句;

public class Continue {
    public static void main(String[] args) {
        for (int j = 0; j < 10; j++){
            if (j%2==1)
                continue;//跳过后面的语句进入循环体，开始下一次循环
            System.out.println(j);
        }
    }
}
