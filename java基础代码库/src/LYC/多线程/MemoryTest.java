package LYC.多线程;

public class MemoryTest {
    public static void main(String[] args) {
        for ( int i = 1;i < 1000;i++) {
            Thread thread=new Thread(){
                @Override
                public void run() {
                    try {
                        System.out.println("睡眠2s...");
                       for (int j=0;j<10000;j++) {
                           String string = new String("123");
                       }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }
    }
}
