package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.TransferService;

@RestController
public class TransferController {

	public TransferController() {
		System.out.println("controller");
	}

	@Autowired
	private TransferService transferService;

	@PostMapping(value = "/api/txr", consumes = { "application/json" }, produces = { "application/json" })
	public TransferResponse doTransfer(@RequestBody TransferRequest request) {
		transferService.transfer(request.getAmount(), request.getFromAccountNumber(), request.getToAccountNumber());
		TransferResponse response = new TransferResponse();
		response.setStatus(Status.SUCCESS);
		return response;
	}

}
