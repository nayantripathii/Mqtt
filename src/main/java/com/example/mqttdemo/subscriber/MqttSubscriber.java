package com.example.mqttdemo.subscriber;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MqttSubscriber {

    private final MqttClient mqttClient;

    public MqttSubscriber(MqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }

    @PostConstruct
    public void subscribe() throws Exception {

        mqttClient.subscribe("home/light", (topic, msg) -> {
            System.out.println("Message received: " + new String(msg.getPayload()));
        });

        System.out.println("Subscribed to home/light");
    }
}
