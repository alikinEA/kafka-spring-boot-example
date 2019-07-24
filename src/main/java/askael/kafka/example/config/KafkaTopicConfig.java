package askael.kafka.example.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alikin E.A. on 2019-07-24.
 */
@Configuration
public class KafkaTopicConfig {

    private static final int PARTITIONS_NUM = 3;
    private static final short REPLICATION_FACTOR = 1;

    public static final String TOPIC1_NAME = "topic1";
    public static final String TOPIC2_NAME = "topic2";

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1() {
        return new NewTopic(TOPIC1_NAME, PARTITIONS_NUM, REPLICATION_FACTOR);
    }

    @Bean
    public NewTopic topic2() {
        return new NewTopic(TOPIC2_NAME, PARTITIONS_NUM, REPLICATION_FACTOR);
    }
}
