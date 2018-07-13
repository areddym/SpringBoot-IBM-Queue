package com.test.mq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.mq.config.JmsMQConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;

@RestController
public class QueueController {

    @Autowired
    JmsTemplate jmsTemplate;
    @Value("${mq.userid}")
    private String userid;
    @Value("${mq.password}")
    private String password;

    @Autowired
    JmsMQConnector jmsMQConnector;

    @RequestMapping(value = "/queue", method = RequestMethod.POST)
    public void postMessage(String mensagem) throws JsonProcessingException, JMSException {
        String queueName = "QUEUE.IN";
        String tradeString = new ObjectMapper().writeValueAsString(mensagem);
        jmsTemplate.setConnectionFactory(jmsMQConnector.wmq());
//        jmsTemplate.getConnectionFactory().createConnection(userid, password);
        jmsTemplate.getConnectionFactory().createConnection();
        jmsTemplate.convertAndSend(queueName, tradeString);

    }
}
