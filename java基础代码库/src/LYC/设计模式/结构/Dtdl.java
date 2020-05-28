package LYC.设计模式.结构;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Dtdl {
    //接口
    interface Shop{}
    //实现类
    class ShopImpl implements Shop{
        void buy(){
            System.out.println("Buy 东西");
        }
    }
    class Dali implements InvocationHandler{

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }

}
