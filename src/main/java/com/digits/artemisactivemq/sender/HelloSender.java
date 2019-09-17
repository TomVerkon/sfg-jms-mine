package com.digits.artemisactivemq.sender;

import java.util.UUID;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.digits.artemisactivemq.config.JMSConfig;
import com.digits.artemisactivemq.model.HelloWorldMessage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class HelloSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage() {
	System.out.println("I'm sending a message");
	HelloWorldMessage message = HelloWorldMessage.builder().id(UUID.randomUUID()).message("Hello World!").build();

	jmsTemplate.convertAndSend(JMSConfig.MY_QUEUE, message);

	System.out.println("Message Sent!");
    }
}
