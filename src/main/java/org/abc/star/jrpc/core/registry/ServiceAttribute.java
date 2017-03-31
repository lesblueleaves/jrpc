package org.abc.star.jrpc.core.registry;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by whs on 2017/3/30.
 */
public class ServiceAttribute implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<String, Object> attributes = new HashMap<String, Object>();

    public ServiceAttribute() {
        super();
    }

    public ServiceAttribute(Map<String, Object> attributes) {
        setAttributes(attributes);
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public ServiceAttribute addAttribute(String att, Object value) {
        this.attributes.put(att, value);
        return this;
    }

    public ServiceAttribute removeAttribute(String att) {
        this.attributes.remove(att);
        return this;
    }

    @Override
    public String toString() {
        return "[attributes=" + attributes + "]";
    }
}
