package com.techrocking.stream.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Configuration;

import com.techrocking.order.message.OrderMessage;
import com.techrocking.payment.service.PaymentService;

@Configuration
@EnableBinding(Sink.class)
public class OrderEventListener {
	
	@Autowired
	private PaymentService paymentService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(OrderEventListener.class);
	
	@StreamListener(Sink.INPUT)
	public void loggerSink(OrderMessage orderChange) {
		logger.info("Received an event for order id: " + orderChange.getOrderId());
		
		if(orderChange.getOrderId()!= null) {
			logger.info("Going to make a paymrnt for order id : " + orderChange.getOrderId());
			paymentService.makePayment(orderChange.getOrderId());
			logger.info("Payment is made successfully");
		}
	}

}
