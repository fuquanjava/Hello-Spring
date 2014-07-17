package hello.spring.autoproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * fuquanemail@gamil.com
 * Date: 14-7-1 下午5:17
 */
public class JDKProxyFactory implements InvocationHandler {

    private Object target;


    /**单例*/
    private JDKProxyFactory(){}

    public static class JDKProxy{
        private static  final  JDKProxyFactory instance = new JDKProxyFactory();
        public static  JDKProxyFactory  getInstance(){
            return instance;
        }

    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return  null;

    }
}
