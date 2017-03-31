package org.abc.star.jrpc.core.invoker;

import org.abc.star.jrpc.core.binding.ReferenceBinding;
import org.abc.star.jrpc.core.protocol.Call;
import org.abc.star.jrpc.core.proxy.ServiceProxy;
import org.abc.star.jrpc.core.transport.Connection;
import org.abc.star.jrpc.core.transport.ConnectionManager;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Created by whs on 2017/3/31.
 */
public class StubServiceInvoker implements ServiceInvoker {
    private ReferenceBinding referenceBinding;
    private ConnectionManager connectionManager;


    public StubServiceInvoker(ConnectionManager connectionManager, ReferenceBinding referenceBinding) {
        this.connectionManager = connectionManager;
        this.referenceBinding = referenceBinding;
    }

    @Override
    public Object invoke(ServiceProxy<?> serviceProxy, Method method, Object[] args) throws Exception {
        String methodName = method.getName();
        Object instance = serviceProxy.getInstance();
        if (methodName.equals("hashCode")) {
            return new Integer(System.identityHashCode(instance));
        } else if (methodName.equals("equals")) {
            return (instance == args[0] ? Boolean.TRUE : Boolean.FALSE);
        } else if (methodName.equals("toString")) {
            return instance.getClass().getName() + "@" + Integer.toHexString(instance.hashCode());
        } else if (methodName.equals("getClass")) {
            return serviceProxy.getService();
        }
        String group = serviceProxy.getGroup();
        int timeout = serviceProxy.getTimeout();
        Class<?> service = serviceProxy.getService();

//        Connection connection = connectionManager.getConnection(referenceBinding.getServiceAddress(service, group));
//        Call call = new Call(service.getName(), group, timeout, methodName, args, method.getParameterTypes());
//        return connection.call(call).get(timeout, TimeUnit.MICROSECONDS);
        return null;
    }
}
