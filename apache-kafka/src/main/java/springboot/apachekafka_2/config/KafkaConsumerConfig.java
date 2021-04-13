package springboot.apachekafka_2.config;


import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import springboot.apachekafka_2.dto.Message;

import java.util.HashMap;
import java.util.Map;

@PropertySource("classpath:kafka.yml")
@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value("${tutorial1.kafka.address}")
    private String bootstrapServer;

    @Value("${tutorial1.kafka.topic.group_id}")
    private String groupId;

    @Bean
    public ConsumerFactory<String, Message> consumerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(configProps);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Message> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Message> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }


}
