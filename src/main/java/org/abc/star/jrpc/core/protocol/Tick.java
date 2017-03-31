package org.abc.star.jrpc.core.protocol;

import java.io.Serializable;

/**
 * Created by whs on 2017/3/29.
 */
public class Tick implements Serializable {
    private static final long serialVersionUID = 1L;

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int increase() {
        return ++count;
    }

    @Override
    public String toString() {
        return "Tick{" +
                "count=" + count +
                '}';
    }
}
