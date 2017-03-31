package org.abc.star.jrpc.core.transport;

import org.abc.star.jrpc.core.RpcException;
import org.abc.star.jrpc.core.protocol.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by whs on 2017/3/30.
 */
public class ResultFuture {
    private Lock lock = new ReentrantLock();

    private Condition ready = lock.newCondition();

    private boolean done;

    private Result result;

    private List<ResultFutureListener> listeners;

    public ResultFuture() {
        super();
    }

    public Object get() throws InterruptedException {
        lock.lock();
        try {
            while (!done) {
                ready.await();
            }
            return getValue();
        } finally {
            lock.unlock();
        }
    }

    public Object get(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
        lock.lock();
        try {
            if (!done) {
                boolean success = ready.await(timeout, unit);
                if (!success) {
                    throw new TimeoutException("operation timeout (" + timeout + " " + unit + ")");
                }
            }
            return getValue();
        } finally {
            lock.unlock();
        }
    }

    public void setResult(Result result) {
        setValue(result);
    }

    private Object getValue() {
        if (result.getCode() != 200) {
            Throwable fault = (Throwable) result.getData();
            if (fault != null) {
                throw new RpcException(result.getCode(), result.getMessage(), fault);
            } else {
                throw new RpcException(result.getCode(), result.getMessage());
            }
        } else {
            return result.getData();
        }
    }

    private void setValue(Result result) {
        lock.lock();
        try {
            if (done) {
                return;
            }
            this.result = result;
            done = true;
            this.ready.signalAll();
        } finally {
            lock.unlock();
        }
        if (listeners != null) {
            for (ResultFutureListener listener : listeners) {
                notifyListener(listener);
            }
        }
    }

    private void notifyListener(ResultFutureListener listener) {
        if (listener != null) {
            try {
                listener.complete(this);
            } catch (Exception e) {

            }
        }
    }

    public ResultFuture addListener(ResultFutureListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("listener");
        }
        boolean notifyNow = false;
        lock.lock();
        try {
            if (done) {
                notifyNow = true;
            } else {
                if (listeners == null) {
                    listeners = new ArrayList<ResultFutureListener>(1);
                }
                listeners.add(listener);
            }
        }finally {
            lock.unlock();
        }
        return this;
    }
}
