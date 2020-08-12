package com.techVariable.FoodIndia.service;

import java.sql.SQLException;
import java.util.List;

import com.techVariable.FoodIndia.vo.VendorVO;

public interface IVendorService {
	String createVendor(VendorVO vendor);
	public List<VendorVO> getVendorDetails() throws SQLException, ClassNotFoundException;
	String editVendor(VendorVO vendor,int id);
	String deleteVendor(int id);


}
	