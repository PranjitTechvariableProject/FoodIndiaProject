package com.techVariable.FoodIndia.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techVariable.FoodIndia.service.IVendorService;
import com.techVariable.FoodIndia.vo.VendorVO;

@RestController
@RequestMapping("/")
public class VendorController {
	@Autowired
	private IVendorService vendorService;

	@PostMapping(path = "vendor/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createVendor(@RequestBody VendorVO vendor) {
		String message = vendorService.createVendor(vendor);
		return message;

	}
	@GetMapping(path = "vendor/details", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VendorVO> getVendorDetails() throws SQLException, ClassNotFoundException {
		List<VendorVO> vendorDetailsList = vendorService.getVendorDetails();
		return vendorDetailsList;
	}
	@PutMapping(path = "vendor/edit", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String editVendor(@RequestBody VendorVO vendor,@RequestParam int id)
	{
		String message = vendorService.editVendor(vendor,id);
		return message;

		
	}




}
