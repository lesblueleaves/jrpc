package org.abc.star.jrpc.core;

/**
 * Created by whs on 2017/3/28.
 */
public class RpcException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private int code;

    /**
     * @param message
     */
    public RpcException(int code, String message) {
        this(code, message, null);
    }

    /**
     * @param message
     * @param cause
     */
    public RpcException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    /**
     * the code to get
     *
     * @return the code
     * @see RpcException#code
     */
    public int getCode() {
        return code;
    }
}
