package LYC.多线程.Voliet;

public class WriterAndRead {
    volatile  int n=0;
    public static void VolietTest(){
        WriterAndRead writerAndRead=new WriterAndRead();
        Thread thread1=new Thread(){
            @Override
            public void run() {
                System.out.println("写操作！"+writerAndRead.n);
                writerAndRead.n=1;
            }
        };
        Thread thread2=new Thread(){
            @Override
            public void run() {
                System.out.println("读操作："+writerAndRead.n);
            }
        };
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        VolietTest();
       // System.out.println(n);
    }
}
