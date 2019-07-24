package askael.kafka.example.service;

import askael.kafka.example.config.KafkaConsumerConfig;
import askael.kafka.example.config.KafkaTopicConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created by Alikin E.A. on 2019-07-24.
 */
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = KafkaTopicConfig.TOPIC1_NAME, groupId = KafkaConsumerConfig.GROUP1)
    public void listenTopic1(String message) {
        System.out.println("Received Message topic1: " + message);
    }

    @KafkaListener(topics = KafkaTopicConfig.TOPIC2_NAME, groupId = KafkaConsumerConfig.GROUP1)
    public void listenTopic2(String message) {
        System.out.println("Received Message topic2: " + message);
    }
}
