package com.example.mqttdemo.publisher;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;

@Service
public class MqttPublisher {
    private final MqttClient mqttClient;

    public MqttPublisher(MqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }

    public void publish(String message) throws Exception {
        mqttClient.publish(
                "home/light",
                new MqttMessage(message.getBytes())
        );
        System.out.println("Message sent: " + message);
    }
}
