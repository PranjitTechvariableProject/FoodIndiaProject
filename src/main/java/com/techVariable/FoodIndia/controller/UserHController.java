package com.techVariable.FoodIndia.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.techVariable.FoodIndia.service.IUserService;
import com.techVariable.FoodIndia.vo.UserVO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/h/")
public class UserHController {
	@Qualifier("hib")
	@Autowired
	private IUserService userService;
	private String username = "pranjit";
	private String pass = "abcd";
	private final String secret = "mySecret";

	@PostMapping(path = "user/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<String> createUser(@RequestBody UserVO user) {
		String message = userService.createUser(user);
		ApiResponse<String> response = new ApiResponse<>(true, message, 200, "");
		return response;
	}

	@GetMapping(path = "user/details", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<List<UserVO>> getUserDetails() throws SQLException, ClassNotFoundException {
		List<UserVO> userDetailsList = userService.getUserDetails();
		ApiResponse<List<UserVO>> response = new ApiResponse<>(true, "Details", HttpStatus.OK.value(), userDetailsList);
		return response;
	}

	@PutMapping(path = "user/edit", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<String> editUser(@RequestBody UserVO user, @RequestParam int id) {
		String message = userService.editUser(user, id);
		ApiResponse<String> response = new ApiResponse<>(true, message, 200, "");
		return response;

	}

	@DeleteMapping(path = "user/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<String> deleteUser(@RequestParam int id) {
		String message = userService.deleteUser(id);
		ApiResponse<String> response = new ApiResponse<>(true, message, 200, "");
		return response;

	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
		long JWT_TOKEN_VALIDITY = 6 * 60 * 60;

		String jwt = Jwts.builder() // building the token
				.setClaims(claims) // permissions
				.setSubject(subject) // kar krone token to generate hoise
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret) // generate sign
				.compact();// complete the sign and create the token
		return jwt;
	}

	@PostMapping(path = "user/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<String> loginUser(@RequestBody Map<String, String> payload, HttpServletResponse response) {

//			// in real world we should perform this operation with DB
		if (payload.get("user").equals(username) && payload.get("password").equals(pass)) {
			// generate jwt
			Map<String, Object> claims = new HashMap<>();// claim t eku set kora nai
			claims.put("username", username);
			String genJWT = doGenerateToken(claims, username); //
			// assign the jwt to the response header
			response.setHeader("jwt", genJWT);
			System.out.println("jwt " + genJWT);

			// return the api response
			ApiResponse<String> apiResponse = new ApiResponse<>(true, "Token Generated", 200, genJWT);
			return apiResponse;

		} else {
			// api response failure
			ApiResponse<String> apiResponse = new ApiResponse<>(false, "Token not Generated", 400, "");
			return apiResponse;

		}

	}

	@GetMapping(path = "user/validate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<String> validateUser(HttpServletRequest request, HttpServletResponse response) {
		String jwt = request.getHeader("jwt");
		if(jwt==null || jwt.isEmpty())
		{
			ApiResponse<String> apiResponse = new ApiResponse<>(false, "Invalid Token", 401, "requested token is invalid");
			response.setStatus(401);
			return apiResponse;
		}
		try{
			Claims claims = getAllClaimsFromToken(jwt);
		Date expiryDate = claims.getExpiration();
		String subject = claims.getSubject();
		System.out.println("user="+subject+" and expiryDate="+expiryDate);
		Date currentDate = new Date(System.currentTimeMillis());
		if(username.equals(subject) && expiryDate.compareTo(currentDate) >= 0) {
			ApiResponse<String> apiResponse = new ApiResponse<>(true, "Valid token", 200, "requested token is valid.");
			response.setHeader("jwt", jwt);
			return apiResponse;
		} else {
			ApiResponse<String> apiResponse = new ApiResponse<>(false, "Invalid Token", 401, "requested token is invalid");
			response.setStatus(401);
			return apiResponse;
		}
		}catch(Exception e) {
			ApiResponse<String> apiResponse = new ApiResponse<>(false, "Invalid Token", 401, "requested token is invalid");
			response.setStatus(401);
			return apiResponse;
		
		}
	}

	// for retrieving any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		Claims claim= Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return claim;
	}
//new api
//gettoken
//validate the token
//return 401 if not valid
//else success message 
//		

}
