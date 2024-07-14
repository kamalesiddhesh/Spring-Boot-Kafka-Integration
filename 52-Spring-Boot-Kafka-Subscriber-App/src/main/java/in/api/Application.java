package in.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import in.api.constants.AppConstants;
import in.api.model.Order;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@KafkaListener(topics = AppConstants.TOPIC,groupId = "group_order")
	public void subscribeMsg(String order) {
		System.out.print("*** Msg Received from Kafka *** :: ");
		System.out.println(order);
		//logic
	}

}
