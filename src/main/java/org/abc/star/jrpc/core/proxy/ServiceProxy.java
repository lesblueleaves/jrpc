package org.abc.star.jrpc.core.proxy;

/**
 * Created by whs on 2017/3/29.
 */
public class ServiceProxy<T> {
    private Class<T> service;
    private String group;
    private int timeout;
    private T instance;

    public ServiceProxy(Class<T> service, String group, int timeout, T instance) {
        super();
        this.service = service;
        this.group = group;
        this.timeout = timeout;
        this.instance = instance;
    }

    public Class<T> getService() {
        return service;
    }

    public String getGroup() {
        return group;
    }

    public int getTimeout() {
        return timeout;
    }

    public T getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "ServiceProxy{" +
                "service=" + service +
                ", group='" + group + '\'' +
                ", timeout=" + timeout +
                ", instance=" + instance +
                '}';
    }
}
