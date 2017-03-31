package org.abc.star.jrpc.core.transport;

import org.abc.star.jrpc.core.SchemaFactoryLoader;

import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by whs on 2017/3/30.
 */
public class ConnectionManager {
    private final ConcurrentMap<InetSocketAddress, ConnectionPool> connectionMap = new ConcurrentHashMap<>();

    private final TransportConfig transportConfig;

    private final ConnectionFactory connectionFactory;

    public ConnectionManager(TransportConfig transportConfig) {
        if (transportConfig == null) {
            throw new IllegalArgumentException("transportConfig is null");
        }
        this.transportConfig = transportConfig;
        SchemaFactoryLoader<ConnectionFactory> cfLoader = SchemaFactoryLoader.getInstance(ConnectionFactory.class);
        this.connectionFactory = cfLoader.getSchemaFactory(transportConfig.getSchema());
    }

    public Connection getConnection(InetSocketAddress socketAddress) {
        ConnectionPool connectionPool = connectionMap.get(socketAddress);
        if (connectionPool == null) {
            connectionMap.putIfAbsent(socketAddress, new ConnectionPool(socketAddress));
            connectionPool = connectionMap.get(socketAddress);
        }
        return connectionPool.getConnection();
    }

    public void destroy() {
        for (ConnectionPool connectionPool : connectionMap.values()) {
            if (connectionPool != null) {
                connectionPool.destroy();
            }
        }
    }

    class ConnectionPool {
        private final InetSocketAddress socketAddress;

        private int count;

        private Connection[] connections;

        public ConnectionPool(InetSocketAddress socketAddress) {
            this.socketAddress = socketAddress;
            this.connections = new Connection[transportConfig.getConnectPoolSize()];
        }

        public synchronized Connection getConnection() {
            int index = count++ % connections.length;
            Connection connection = connections[index];
            if (connection == null || !connection.isAlive()) {
                if (connection != null) {
                    connection.destroy();
                }
                connection = connectionFactory.create(transportConfig, socketAddress);
                connections[index] = connection;
            }
            return connection;
        }

        public void destroy() {
            for (Connection connection : connections) {
                if (connection != null) {
                    connection.destroy();
                }
            }
        }
    }

}
