package org.abc.star.jrpc.core.binding;

import org.abc.star.jrpc.core.endpoint.EndpointConfig;
import org.abc.star.jrpc.core.proxy.ServiceProxy;
import org.abc.star.jrpc.core.registry.ServiceAttribute;
import org.abc.star.jrpc.core.registry.ServiceDescription;
import org.abc.star.jrpc.core.registry.ServiceRegistry;

import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by whs on 2017/3/31.
 */
public class AbstractImplementBinding implements ImplementBinding {

    protected Map<String, ServiceProxy<?>> serviceProxyMap = new ConcurrentHashMap<>();

    protected InetSocketAddress providerAddress;

    protected ServiceRegistry serviceRegistry;

    @Override
    public <T> void bind(ServiceProxy<T> serviceWrapper, EndpointConfig endpointConfig) {
        String serviceId = serviceWrapper.getService().getName() + "-" + serviceWrapper.getGroup();
        if (serviceProxyMap.get(serviceId) != null) {
            throw new RuntimeException("multiple object registed with the service interface " + serviceId);
        }
        serviceProxyMap.put(serviceId, serviceWrapper);

        if (serviceRegistry != null) {
            publish(serviceWrapper, endpointConfig);
        }
    }

    protected void publish(ServiceProxy<?> wrapper, EndpointConfig endpointConfig) {
        String host = providerAddress.getAddress().getHostAddress();
        int port = providerAddress.getPort();
        String group = wrapper.getGroup();

        StringBuilder id = new StringBuilder();
        id.append(host).append(":").append(port).append("@");
        id.append(endpointConfig.getEndpointName()).append("#").append(endpointConfig.getEndpointId()).append("@");
        id.append("group=").append(group == null ? "" : group);

        ServiceDescription description = new ServiceDescription();
        description.setId(id.toString());
        description.setHost(host);
        description.setPort(port);
        description.setServiceName(wrapper.getService().getName());
        description.setGroup(group);
        description.setRegistryTime(System.currentTimeMillis());

        ServiceAttribute serviceAttribute = new ServiceAttribute();
        List<String> methodDescList = new ArrayList<>();
        for (Method method : wrapper.getService().getDeclaredMethods()) {
            methodDescList.add(description(method));
        }
        serviceAttribute.addAttribute("timeout", wrapper.getTimeout());
        serviceAttribute.addAttribute("methods", methodDescList);

        serviceAttribute.addAttribute("endpointId", endpointConfig.getEndpointId());
        serviceAttribute.addAttribute("endpointName", endpointConfig.getEndpointName());
        description.setServiceAttribute(serviceAttribute);

        try {
            serviceRegistry.register(description);
        } catch (Exception e) {
            throw new RuntimeException("can't publish service", e);
        }
    }

    @Override
    public ServiceProxy<?> find(String service, String group) {
        String serviceId = service + "-" + group;
        return serviceProxyMap.get(serviceId);
    }

    @Override
    public InetSocketAddress getServiceAddress() {
        return providerAddress;
    }

    @Override
    public void destroy() {
        if (serviceRegistry != null) {
            serviceRegistry.destroy();
        }
    }

    private String description(Method method) {
        StringBuilder desc = new StringBuilder();
        desc.append(getTypeName(method.getReturnType()) + " ");
        desc.append(getTypeName(method.getDeclaringClass()) + ".");
        desc.append(method.getName() + "(");
        Class<?>[] params = method.getParameterTypes();
        for (int j = 0; j < params.length; j++) {
            desc.append(getTypeName(params[j]));
            if (j < (params.length - 1)) {
                desc.append(",");
            }
        }
        desc.append(")");
        return desc.toString();
    }

    private static String getTypeName(Class<?> type) {
        if (type.isArray()) {
            Class<?> cl = type;
            int dimensions = 0;
            while (cl.isArray()) {
                dimensions++;
                cl = cl.getComponentType();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(cl.getName());
            for (int i = 0; i < dimensions; i++) {
                sb.append("[]");
            }
            return sb.toString();
        }
        return type.getName();
    }
}
