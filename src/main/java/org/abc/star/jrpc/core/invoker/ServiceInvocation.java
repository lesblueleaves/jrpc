package org.abc.star.jrpc.core.invoker;

/**
 * Created by whs on 2017/3/31.
 */
public interface ServiceInvocation {
    public Object proceed() throws Throwable;
}
