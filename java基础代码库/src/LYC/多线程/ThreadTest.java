package LYC.多线程;

public class ThreadTest extends Thread{
    public static void main(String[] args) {
        ThreadTest threadTest1 = new ThreadTest();
        ThreadTest threadTest2 = new ThreadTest();
        threadTest1.start();
        threadTest2.start();
    }
    public void run(){
        for (int i = 1;i < 10; i++){
            System.out.println(i);
        }
    }


}
