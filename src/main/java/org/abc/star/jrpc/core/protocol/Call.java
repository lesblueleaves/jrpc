package org.abc.star.jrpc.core.protocol;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by whs on 2017/3/29.
 */
public class Call implements Serializable {
    private static final long serialVersionUID = 1L;

    private String group;

    private String service;

    private String method;

    private int timeout;

    private Object[] params;

    private Class<?>[] paramTypes;

    public Call() {
        super();
    }

    public Call(String service, String group, int timeout, String method, Object[] params, Class<?>[] paramTypes) {
        super();
        this.group = group;
        this.service = service;
        this.method = method;
        this.timeout = timeout;
        this.params = params;
        this.paramTypes = paramTypes;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Class<?>[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class<?>[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    @Override
    public String toString() {
        return "Call{" +
                "group='" + group + '\'' +
                ", service='" + service + '\'' +
                ", method='" + method + '\'' +
                ", timeout=" + timeout +
                ", params=" + Arrays.toString(params) +
                '}';
    }
}
