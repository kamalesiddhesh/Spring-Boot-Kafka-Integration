package in.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.api.model.Order;
import in.api.service.OrderService;

@RestController
public class OrderRestController {
	
	@Autowired
	private OrderService service;
	
	
	//Published MSG to Kafka Topic
	@PostMapping("/order")
	public String createOrder(@RequestBody Order order) {
		String msg = service.addMsg(order);
		return msg;
	}
}
