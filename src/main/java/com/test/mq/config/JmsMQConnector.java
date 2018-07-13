package com.test.mq.config;

import com.ibm.mq.jms.MQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class JmsMQConnector {
    @Value("${mq.host}")
    private String host;
    @Value("${mq.port}")
    private Integer port;
    @Value("${mq.channel}")
    private String channel;
    @Value("${mq.transport-type}")
    private Integer transportType;
    @Value("${mq.queue-manager}")
    private String queueManager;

    @Bean
    public MQConnectionFactory wmq() throws JMSException {

        MQConnectionFactory factory = new MQConnectionFactory();
        factory.setTransportType(transportType);
        factory.setHostName(host);
        factory.setPort(port);
        factory.setQueueManager(queueManager);
        factory.setChannel(channel);

        return factory;
    }
}
