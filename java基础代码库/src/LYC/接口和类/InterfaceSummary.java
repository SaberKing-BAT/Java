package LYC.接口和类;

/*
    接口的访问修饰符可以是public ，或者default(friendly)就是友好的意思，没有修饰。
    访问修饰符	        作用域
    public	        外部包，本包，类内部，子类
    private	        类内部
    protected	    本包，类内部，子类
    default (friendly)	类内部，本包
*/
public abstract interface InterfaceSummary {  //默认修饰是abstract
    public static final int a=0; //默认修饰 public static final
    public abstract void fun1(); // 默认修饰 public abstract



    class A implements InterfaceSummary{
        public static void main(String[] args) {
           new A().fun1();
        }

        @Override
        public void fun1() {
            System.out.println("实现接口方法");
        }
    }
}
interface inter1{}