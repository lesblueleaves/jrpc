package org.abc.star.dubbo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by whs on 2017/3/28.
 */
@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) throws InterruptedException {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        ConfigurableApplicationContext s = SpringApplication.run(ServerApplication.class, args);
    }
}
