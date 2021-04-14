package springboot.apachekafka1.config;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import springboot.apachekafka1.dto.Mail;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Value("${kafka.topic.server}")
    private String server;
    @Value("${kafka.topic.group_id}")
    private String groupId;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Mail> listenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Mail> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumer());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, Mail> consumer() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, Mail.class);
//        configs.put(StringDeserializer.VALUE_DEFAULT_TYPE, Mail.class);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        return new DefaultKafkaConsumerFactory<>(configs);
    }
}
