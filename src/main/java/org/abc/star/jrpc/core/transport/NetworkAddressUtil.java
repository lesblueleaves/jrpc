package org.abc.star.jrpc.core.transport;

import java.net.*;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by whs on 2017/3/30.
 */
public class NetworkAddressUtil {
    public static List<InetAddress> getPrivateInetAddress() throws SocketException {
        List<InetAddress> inetAddresses = new LinkedList<>();
        for (Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces(); e.hasMoreElements(); ) {
            NetworkInterface networkInterface = e.nextElement();
            if (networkInterface.isLoopback() || networkInterface.isVirtual() || !networkInterface.isUp()) {
                continue;
            }
            for (InterfaceAddress address : networkInterface.getInterfaceAddresses()) {
                InetAddress inetAddress = address.getAddress();
                if (inetAddress.isSiteLocalAddress() && !inetAddress.isLoopbackAddress()
                        && (inetAddress instanceof Inet4Address)) {
                    inetAddresses.add(inetAddress);
                }
            }
        }
        return inetAddresses;
    }

    public static final List<InetAddress> getPublicInetAddress() throws SocketException {
        List<InetAddress> inetAddresses = new LinkedList<>();
        for (Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces(); e.hasMoreElements(); ) {
            NetworkInterface networkInterface = e.nextElement();
            if (networkInterface.isLoopback() || networkInterface.isVirtual() || !networkInterface.isUp()) {
                continue;
            }
            for (InterfaceAddress address : networkInterface.getInterfaceAddresses()) {
                InetAddress inetAddress = address.getAddress();
                if (!inetAddress.isLinkLocalAddress() && !inetAddress.isLoopbackAddress()
                        && !inetAddress.isSiteLocalAddress() && (inetAddress instanceof Inet4Address)) {
                    inetAddresses.add(inetAddress);
                }
            }
        }
        return inetAddresses;
    }

    public static String addressLabel(SocketAddress localAddress, SocketAddress remoteAddress) {
        InetSocketAddress local = (InetSocketAddress) localAddress;
        InetSocketAddress remote = (InetSocketAddress) remoteAddress;

        String key = "";
        if (local == null || local.getAddress() == null) {
            key += "local-";
        } else {
            key += local.getAddress().getHostAddress() + ":" + local.getPort() + "-";
        }
        if (remote == null || remote.getAddress() == null) {
            key += "remote";
        } else {
            key += remote.getAddress().getHostAddress() + ":" + remote.getPort();
        }

        return key;
    }
}
