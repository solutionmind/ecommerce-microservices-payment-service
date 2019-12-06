package com.techrocking.payment.service;

import org.springframework.stereotype.Service;

import com.techrocking.payment.payload.CreatePaymentResponse;

@Service
public class PaymentService {

	public CreatePaymentResponse makePayment(Long orderId) {
		CreatePaymentResponse response = new CreatePaymentResponse();
		response.setMessage("payment is successful");
		response.setPaymentId(orderId);
		return response;

	}

}
