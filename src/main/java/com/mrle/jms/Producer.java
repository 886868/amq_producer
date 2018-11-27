package com.mrle.jms;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMsg(String desNm, String msg) {

        Destination des = new ActiveMQQueue(desNm);
        System.out.println("==========>>>>>> 发送queue消息 " + msg);
        jmsMessagingTemplate.convertAndSend(des, msg);

    }
}
