package com.techrocking.payment.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techrocking.payment.payload.CreatePaymentResponse;
import com.techrocking.payment.service.PaymentService;

@RestController
public class PaymentController {
	
	private PaymentService paymentService;
	
	@PostMapping
	public CreatePaymentResponse makePayment(@RequestBody Long orderId) {
		return paymentService.makePayment(orderId);
	}

}
