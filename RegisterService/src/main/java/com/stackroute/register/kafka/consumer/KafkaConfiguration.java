// package com.stackroute.register.kafka.consumer;

// import com.mongodb.util.JSONSerializers;
// import com.stackroute.register.domain.User;
// import org.apache.kafka.clients.consumer.ConsumerConfig;
// import org.apache.kafka.common.serialization.BytesDeserializer;
// import org.apache.kafka.common.serialization.BytesSerializer;
// import org.apache.kafka.common.serialization.StringDeserializer;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.kafka.annotation.EnableKafka;
// import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
// import org.springframework.kafka.core.ConsumerFactory;
// import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
// import org.springframework.kafka.support.converter.StringJsonMessageConverter;

// import java.util.HashMap;
// import java.util.Map;

// @EnableKafka
// @Configuration
// public class KafkaConfiguration {

//     @Bean
//     public ConsumerFactory<String, String> consumerFactory() {

//         Map<String, Object> config = new HashMap<>();
//         config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "35.154.116.88:9092");
//         config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
//         config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//         config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//         return new DefaultKafkaConsumerFactory<>(config);
//     }

//     @Bean
//     public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
//         ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory();
//         factory.setConsumerFactory(consumerFactory());
//         return factory;
//     }

//     @Bean
//     public ConsumerFactory<String, User> userConsumerFactory() {
//         Map<String, Object> config = new HashMap<>();

//         config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "35.154.116.88:9092");
//         config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id6");
//         config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
// //        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
// //        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),new JsonDeserializer<>(User.class));
//         // added new code
//         config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, BytesDeserializer.class);
//         return new DefaultKafkaConsumerFactory<>(config);

//     }

//     @Bean
//     public ConcurrentKafkaListenerContainerFactory<String, User> userKafkaListenerFactory() {
//         ConcurrentKafkaListenerContainerFactory<String, User> factory = new ConcurrentKafkaListenerContainerFactory<String,User>();
//         factory.setConsumerFactory(userConsumerFactory());
//         // added new code
//         factory.setMessageConverter(new StringJsonMessageConverter());
//         return factory;
//     }

// }
