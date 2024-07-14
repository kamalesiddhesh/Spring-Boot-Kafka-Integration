package in.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import in.api.constants.AppConstants;
import in.api.model.Order;

@Service
public class OrderService {
	
	@Autowired
	private KafkaTemplate<String,Order> kafkaTemplate;
	
	public String addMsg(Order order) {
		
		kafkaTemplate.send(AppConstants.TOPIC,order);
		return "MSG Published To Kafka Topic";
	}

}
