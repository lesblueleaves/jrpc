package org.abc.star.jrpc.core.proxy;

import org.abc.star.jrpc.core.invoker.ServiceInvoker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by whs on 2017/3/29.
 */
public class StubProxyFactory implements ServiceProxyFactory {
    private ServiceInvoker serviceInvoker;

    public StubProxyFactory(ServiceInvoker serviceInvoker) {
        this.serviceInvoker = serviceInvoker;
    }

    @Override
    public <T> ServiceProxy<T> create(Class<T> serviceInterface, String group, int timeout, T serviceObject) throws Exception {
        ProxyInvocationHandler<T> handler = new ProxyInvocationHandler<>();
        T proxy = serviceInterface.cast(Proxy.newProxyInstance(serviceInterface.getClassLoader(),
                new Class[]{serviceInterface}, handler));
        ServiceProxy<T> serviceProxy = new ServiceProxy<T>(serviceInterface, group, timeout, proxy);
        handler.serviceProxy = serviceProxy;
        return serviceProxy;
    }

    private class ProxyInvocationHandler<T> implements InvocationHandler {

        private ServiceProxy<T> serviceProxy;

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return serviceInvoker.invoke(serviceProxy, method, args);
        }
    }

}
