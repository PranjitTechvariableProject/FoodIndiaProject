package com.techVariable.FoodIndia.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techVariable.FoodIndia.service.IPaymentService;
import com.techVariable.FoodIndia.vo.PaymentVO;

@RestController
@RequestMapping("/")
public class PayemntController {
	@Autowired
	private IPaymentService paymentService;

	@PostMapping(path = "paymentType/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createPayment(@RequestBody PaymentVO payment) {
		String type = paymentService.createPayment(payment);
		return type;

	}

	@GetMapping(path = "payment/types", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PaymentVO> getPaymentType() throws SQLException, ClassNotFoundException {
		List<PaymentVO> paymentTypeList = paymentService.getPaymentType();
		return paymentTypeList;
	}
	@PutMapping(path = "payment/edit", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String editPayment(@RequestBody PaymentVO payment,@RequestParam int id)
	{
		String type = paymentService.editPayment(payment,id);
		return type;
	}
	@DeleteMapping(path = "payment/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deletePayment(@RequestParam int id)
	{
		String type = paymentService.deletePayment(id);
		return type;

		
	}
	
}
