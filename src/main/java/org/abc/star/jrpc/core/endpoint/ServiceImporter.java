package org.abc.star.jrpc.core.endpoint;

/**
 * Created by whs on 2017/3/31.
 */
public interface ServiceImporter {
    public abstract <T> T importService(Class<T> sic);

    public abstract <T> T importService(Class<T> sic, String group);

    public abstract <T> T importService(Class<T> sic, String group, int timeout);

    public abstract void destroy();
}
