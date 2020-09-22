package com.techVariable.FoodIndia.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.techVariable.FoodIndia.dao.VendorDao;
import com.techVariable.FoodIndia.vo.VendorVO;
@Service
@Qualifier(value = "hib")


public class VendorHService implements IVendorService {
	@Autowired
	VendorDao vendorDao;

	
	public String createVendor(VendorVO vendor) {
		
		vendorDao.createVendor(vendor);
		String message="saved successfully";
		return message;
	}

	public List<VendorVO> getVendorDetails() throws SQLException, ClassNotFoundException
	{
		return vendorDao.getVendorDetails();
		
	}

	public String editVendor(VendorVO vendor, int id) 
	{
		vendorDao.editVendor(vendor, id);
		return "updated successfully";
		}
	public String deleteVendor(int id) {
		vendorDao.deleteVendor(id);
		return "deleted successfully";

	}

}
