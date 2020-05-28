package LYC.类加载顺序;

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
    public int getJ() { return j; }
    public void setJ(int j) {
        this.j = j;
    }
}
//类变量是属于类的，所有对象实例可以操作，和共享的。
//成员变量是每个实例对象私有的。
//普通方法可以操作static变量；
//static方法不能操作非static成员变量；（私有（实例对象的）可以操作公有，但是公有（类的）无法操作私有：
// 因为私有是个性的，不是共性的，是后期赋值的）