package com.techVariable.FoodIndia.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.techVariable.FoodIndia.util.JdbcConnectionUtil;
import com.techVariable.FoodIndia.vo.VendorVO;

@Service
public class VendorService implements IVendorService {

	public String createVendor(VendorVO vendor) {
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
		System.out.println(date);
		String sql = "INSERT INTO mobgrocerydb.vendor(VENDOR_NAME,VENDOR_PHONE_NUMBER,JOINING_DATE,ZIP_CODE,STATE ,COUNTRY,ADDRESS_LINE1, ADDRESS_LINE2) VALUES('"
				+ vendor.getName() + "','" + vendor.getPhoneNumber() + "','" + date + "'," + vendor.getZipCode() + ",'"
				+ vendor.getState() + "','" + vendor.getCountry() + "','" + vendor.getAddressLine1() + "','"
				+ vendor.getAddressLine2() + "')";

		try {
			JdbcConnectionUtil.executeMySqlQuery(sql);
			return "saved successfully";
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "save failed";
		}
	}

	public List<VendorVO> getVendorDetails() throws SQLException, ClassNotFoundException {
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
		String sql = "SELECT * FROM mobgrocerydb.vendor";

		try {
			ResultSet result = JdbcConnectionUtil.getMySqlData(sql);
			List<VendorVO> vendorList = new ArrayList<>();
			while (result.next()) {
				int id = result.getInt("VENDOR_ID");
				String name = result.getString("VENDOR_NAME");
				String phoneNumber = result.getString("VENDOR_PHONE_NUMBER");
				Date d= result.getDate("JOINING_DATE");
				int zipCode = result.getInt("ZIP_CODE");
				String state = result.getString("STATE");
				String country = result.getString("COUNTRY");
				String addressLine1 = result.getString("ADDRESS_LINE1");
				String addressLine2 = result.getString("ADDRESS_LINE2");

				VendorVO vendor = new VendorVO();
				vendor.setId(id);
				vendor.setName(name);
				vendor.setPhoneNumber(phoneNumber);
				//DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
				//String strDate = dateFormat.format(d);
				vendor.setJoiningDate(d);
				vendor.setZipCode(zipCode);
				vendor.setState(state);
				vendor.setCountry(country);
				vendor.setAddressLine1(addressLine1);
				vendor.setAddressLine2(addressLine2);

				vendorList.add(vendor);

			}
			return vendorList;

		} catch (SQLException e) {
			throw e;
		} finally {
			JdbcConnectionUtil.closeConnection();

		}
	}

	public String editVendor(VendorVO vendor, int id) {
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
		String sql = "UPDATE  mobgrocerydb.vendor SET VENDOR_NAME='" + vendor.getName() + "',VENDOR_PHONE_NUMBER='"
				+ vendor.getPhoneNumber() + "',JOINING_DATE='" + date + "',ZIP_CODE="
				+ vendor.getZipCode() + ",STATE='" + vendor.getState() + "',COUNTRY='" + vendor.getCountry()
				+ "',ADDRESS_LINE1 ='" + vendor.getAddressLine1() + "',ADDRESS_LINE2='" + vendor.getAddressLine2()
				+ "' WHERE VENDOR_ID=" + id;

		try {
			JdbcConnectionUtil.executeMySqlQuery(sql);
			return "update successfully";
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "update failed";
		}

	}

	@Override
	public String deleteVendor(int id) {
		
		return "use the hibernate API's ";
	}
}
