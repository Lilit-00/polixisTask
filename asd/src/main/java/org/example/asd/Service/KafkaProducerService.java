package org.example.asd.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.example.asd.User.User;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, User user) {
        kafkaTemplate.send(topic, user);
    }
}
