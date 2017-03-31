package org.abc.star.jrpc.core.protocol;

import java.io.Serializable;

/**
 * Created by whs on 2017/3/29.
 */
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;

    private String message;

    private Object data;

    public Result() {
        super();
    }

    public Result(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public Result(int code, Object data) {
        super();
        this.code = code;
        this.data = data;
    }

    public Result(int code, String message, Object data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
