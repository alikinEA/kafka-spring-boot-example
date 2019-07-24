package askael.kafka.example.controller;

import askael.kafka.example.config.KafkaTopicConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Alikin E.A. on 2019-07-17.
 */
@RestController
@RequestMapping(value = "/")
public class SendMessageController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping(value = "/send/topic1", method = RequestMethod.GET)
    public void sendTopic1() {
        kafkaTemplate.send(KafkaTopicConfig.TOPIC1_NAME, "topic 1 message");
    }

    @RequestMapping(value = "/send/topic2", method = RequestMethod.GET)
    public void sendTopic2() {
        kafkaTemplate.send(KafkaTopicConfig.TOPIC2_NAME, "topic 2 message");
    }
}
