package com.example.UserProfile.kafka.consumer;

import com.example.UserProfile.domain.Challenge;
import com.example.UserProfile.domain.UserProfile;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.BytesDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfiguration {

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {

        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, UserProfile> userConsumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id6");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),new JsonDeserializer<>(User.class));
        // added new code
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, BytesDeserializer.class);
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        return new DefaultKafkaConsumerFactory<>(config);

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserProfile> userKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, UserProfile> factory = new ConcurrentKafkaListenerContainerFactory<String,UserProfile>();
        factory.setConsumerFactory(userConsumerFactory());
        // added new code
        factory.setMessageConverter(new StringJsonMessageConverter());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, Challenge> challengeConsumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id7");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),new JsonDeserializer<>(User.class));
        // added new code
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, BytesDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config);

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Challenge> challengeKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Challenge> factory = new ConcurrentKafkaListenerContainerFactory<String,Challenge>();
        factory.setConsumerFactory(challengeConsumerFactory());
        // added new code
        factory.setMessageConverter(new StringJsonMessageConverter());
        return factory;
    }

    //To fetch data from Reg Service
    @Bean
    public ConsumerFactory<String, UserProfile> registerationConsumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id7");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),new JsonDeserializer<>(User.class));
        // added new code
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, BytesDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config);

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserProfile> registrationKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, UserProfile> factory = new ConcurrentKafkaListenerContainerFactory<String,UserProfile>();
        factory.setConsumerFactory(registerationConsumerFactory());
        // added new code
        factory.setMessageConverter(new StringJsonMessageConverter());
        return factory;
    }



    @Bean
    public ConsumerFactory<String, Challenge> scoringConsumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id9");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),new JsonDeserializer<>(User.class));
        // added new code
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, BytesDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config);

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Challenge> scoringKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Challenge> factory = new ConcurrentKafkaListenerContainerFactory<String,Challenge>();
        factory.setConsumerFactory(challengeConsumerFactory());
        // added new code
        factory.setMessageConverter(new StringJsonMessageConverter());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, Challenge> votingConsumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id10");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),new JsonDeserializer<>(User.class));
        // added new code
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, BytesDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config);

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Challenge> votingKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Challenge> factory = new ConcurrentKafkaListenerContainerFactory<String,Challenge>();
        factory.setConsumerFactory(challengeConsumerFactory());
        // added new code
        factory.setMessageConverter(new StringJsonMessageConverter());
        return factory;
    }


}
