package LYC.多线程;

public class RunnableTest implements Runnable{
    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        Thread thread=new Thread(runnableTest);
        thread.start();

    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println(i);
        }
    }
}
