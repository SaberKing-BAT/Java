package LYC.多线程.多线程_1;
class Libai{
    private int status;//无敌变量
    public Libai(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
    public synchronized void setStatus(int status) {
        this.status = status;
    }
}
class Jifei{
    private Libai libai=null;
    public Jifei(Libai libai) {
        this.libai = libai;
    }
    public void jifei() throws InterruptedException {
        //synchronized (libai){
            if (libai.getStatus()==0){
                System.out.println("击飞开始");
                System.out.println("击飞中...");
                Thread.sleep(500);
                System.out.println("击飞结束");
            }
     //  }
    }
}

public class Libaiduanda {
    private static Libai libai=new Libai(0);
    static synchronized Libai getLibai(){
        return  libai;
    }
    public static void main(String[] args) {

       new Thread(){
           public void run(){
               synchronized (libai){
                   Jifei jifei=new Jifei(getLibai());
                   try {
                       jifei.jifei();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       }.start();
        new Thread(){
            public void run(){
                try {
                    getLibai().setStatus(1);
                    System.out.println("李白无敌开始");
                    System.out.println("李白无敌中");
                    Thread.sleep(2000);
                    System.out.println("李白无敌结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
