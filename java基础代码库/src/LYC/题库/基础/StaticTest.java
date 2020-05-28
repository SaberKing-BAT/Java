package LYC.题库.基础;

public class StaticTest {
    public static void main(String[] args) {
        Test[] tests=new Test[3];
        for (int i=0;i<3;i++){
            tests[i] = new Test();
        }
        System.out.println(Test.i);
        System.out.println(tests[0].getJ());

    }
}
class Test{
    public static int i = 0;
    private int j = 0;
    public Test(){
        i++;
        j++;
    }
    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
//类变量是属于类的，所有对象实例可以操作，和共享的。
//成员变量是每个实例对象私有的。