package com.techVariable.FoodIndia.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techVariable.FoodIndia.response.ApiResponse;
import com.techVariable.FoodIndia.service.IVendorService;
import com.techVariable.FoodIndia.vo.VendorVO;

@RestController
@RequestMapping("/h/")


public class VendorHController 
{
	@Qualifier("hib")
	@Autowired
	private IVendorService vendorService;

	@PostMapping(path = "vendor/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<String> createVendor(@RequestBody VendorVO vendor) {
		String message = vendorService.createVendor(vendor);
		ApiResponse<String> response= new ApiResponse<>(true,message, 200, "");
		return response;

	}

	@GetMapping(path = "vendor/details", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<List<VendorVO>> getVendorDetails() throws SQLException, ClassNotFoundException {
		List<VendorVO> vendorDetailsList = vendorService.getVendorDetails();
		ApiResponse<List<VendorVO>> response= new ApiResponse<>(true,"Details", HttpStatus.OK.value(), vendorDetailsList);
		return response;
	}

	@PutMapping(path = "vendor/edit", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<String> editVendor(@RequestBody VendorVO vendor, @RequestParam int id) {
		String message = vendorService.editVendor(vendor, id);
		ApiResponse<String> response= new ApiResponse<>(true,message, 200, "");
		return response;
	}

	@DeleteMapping(path = "vendor/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<String> deleteVendor(@RequestParam int id) {
		String message = vendorService.deleteVendor(id);
		ApiResponse<String> response= new ApiResponse<>(true,message ,200, "");
		return response;

	}

}
