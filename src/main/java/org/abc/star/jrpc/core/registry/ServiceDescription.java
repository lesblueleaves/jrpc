package org.abc.star.jrpc.core.registry;

import java.io.Serializable;
import java.net.InetSocketAddress;

/**
 * Created by whs on 2017/3/30.
 */
public class ServiceDescription implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String serviceName;

    private String group;

    private String host;

    private int port;

    private String uri;

    private long registryTime;

    private ServiceAttribute serviceAttribute;

    private volatile InetSocketAddress address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public long getRegistryTime() {
        return registryTime;
    }

    public void setRegistryTime(long registryTime) {
        this.registryTime = registryTime;
    }

    public ServiceAttribute getServiceAttribute() {
        return serviceAttribute;
    }

    public void setServiceAttribute(ServiceAttribute serviceAttribute) {
        this.serviceAttribute = serviceAttribute;
    }

    public InetSocketAddress getAddress() {
        if (address == null) {
            address = new InetSocketAddress(host, port);
        }
        return address;
    }

    @Override
    public String toString() {
        return "ServiceDescription{" +
                "id='" + id + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", group='" + group + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", uri='" + uri + '\'' +
                ", registryTime=" + registryTime +
                ", serviceAttribute=" + serviceAttribute +
                ", address=" + address +
                '}';
    }
}
