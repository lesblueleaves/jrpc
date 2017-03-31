package org.abc.star.jrpc.core.invoker;

import org.abc.star.jrpc.core.proxy.ServiceProxy;

import java.lang.reflect.Method;

/**
 * Created by whs on 2017/3/31.
 */
public class SkeletonServiceInvoker implements ServiceInvoker {
    @Override
    public Object invoke(ServiceProxy<?> serviceProxy, Method method, Object[] args) throws Exception {
        return method.invoke(serviceProxy.getInstance(), args);
    }
}
