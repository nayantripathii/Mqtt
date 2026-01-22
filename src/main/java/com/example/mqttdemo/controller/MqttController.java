package com.example.mqttdemo.controller;

import com.example.mqttdemo.publisher.MqttPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MqttController {

    private final MqttPublisher publisher;

    public MqttController(MqttPublisher publisher) {
        this.publisher = publisher;
    }

    @GetMapping("/publish")
    public String publish() throws Exception {
        publisher.publish("ON");
        return "MQTT message sent";
    }
}
