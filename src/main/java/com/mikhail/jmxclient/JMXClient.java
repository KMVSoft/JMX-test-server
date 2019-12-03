package com.mikhail.jmxclient;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.util.Scanner;

@Service
@Slf4j
public class JMXClient {

    private static  ObjectName airplaneMBean;
    static {
        try {
            airplaneMBean = new ObjectName("com.mikhail.Application:type=Airplane");
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }
    }

    public AirplaneMBean test() {

        try {
            ObjectName mbeanName = airplaneMBean;

            AirplaneMBean mbeanProxy =
                    (AirplaneMBean) MBeanServerInvocationHandler.newProxyInstance(
                            createConnection(), mbeanName, AirplaneMBean.class, true);
            return mbeanProxy;
        } catch (Exception e) {
            log.error("JMX Error", e);
        }
        return null;
    }

    private MBeanServerConnection createConnection() {
        try {
            JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9010/jmxrmi");
            JMXConnector jmxConnector = JMXConnectorFactory.connect(url);
            MBeanServerConnection mbeanServerConnection = jmxConnector.getMBeanServerConnection();
            return mbeanServerConnection;
        } catch (Exception e) {
            log.error("Error on create connection to JMX", e);
        }
        return null;
    }
}
