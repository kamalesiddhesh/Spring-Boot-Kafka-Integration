package in.api.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import in.api.constants.AppConstants;
import in.api.model.Order;

@Configuration
public class KafkaProduceConfig {
	
	@Bean
	public ProducerFactory<String,Order> producerFactory(){
		
		Map<String,Object> configProps =new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,AppConstants.HOST);   // Setting Kafka Server Host 
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class); // Setting What is Key for Kafka Messages
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class); // Setting What is Value type for Kafka Messages
		
		return new DefaultKafkaProducerFactory<>(configProps);
	}
	@Bean
	public KafkaTemplate<String,Order> kafkaTemplate(){
		
		return new KafkaTemplate<>(producerFactory());
	}

}
