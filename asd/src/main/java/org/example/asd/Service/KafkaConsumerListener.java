package org.example.asd.Service;

import org.example.asd.Repository.UserRepository;
import org.example.asd.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerListener {

    private final UserRepository userRepository;

    @Autowired
    public KafkaConsumerListener(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = "my_topic", groupId = "your_group_id")
    public void listen(User user) {
        System.out.println("Received message: " + user);
        try {
            userRepository.save(user);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
