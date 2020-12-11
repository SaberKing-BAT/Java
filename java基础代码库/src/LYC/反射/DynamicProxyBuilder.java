package LYC.反射;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class ProxyBuilder implements InvocationHandler {

    Object subject;

    public ProxyBuilder(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
public class DynamicProxyBuilder {


}




