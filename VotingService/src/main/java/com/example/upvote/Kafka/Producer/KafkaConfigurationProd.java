package com.example.upvote.Kafka.Producer;

import com.example.upvote.domain.Voting;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfigurationProd {

   @Autowired
    private Environment env;
    @Bean
    public ProducerFactory<String, Voting> producerFactory() {
        Map<String, Object> config = new HashMap<>();



       String localhost=env.getProperty("localhost");
        System.out.println("bootstrap :"+ localhost);
        config.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, localhost);
       // config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.23.239.131:9092");

        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }


    @Bean
    public KafkaTemplate<String, Voting> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
