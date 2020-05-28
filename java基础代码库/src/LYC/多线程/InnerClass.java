package LYC.多线程;

public class InnerClass {
    public static void main(String[] args) {

    }
    void runnable(){
        Thread t2 = new Thread(
                new Runnable(){
                    @Override
                    public void run() {
                        while(true){
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("3: "+Thread.currentThread().getName());
                        }
                    }
                }
        );
    }
    void thread(){
        Thread thread=new Thread(){
            @Override
            public void run() {
                System.out.println("123");
            }
        };
    }
    void lamda(){

    }
}
