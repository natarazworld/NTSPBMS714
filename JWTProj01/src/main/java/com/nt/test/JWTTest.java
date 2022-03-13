package com.nt.test;

import com.nt.utility.JWTUtil;

import io.jsonwebtoken.Claims;

public class JWTTest {

	public static void main(String[] args) {
		String token=JWTUtil.generateToken("5435AA", "RAJA", "RANI");
		System.out.println(token);
		//String token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI1NDM1QUEiLCJzdWIiOiJSQUpBIiwiaXNzIjoiTklUIiwiaWF0IjoxNjQ3MTQzMjQ2LCJleHAiOjE2NDcxNDMzMDZ9.T0ycy47h5D_idoDob2XBggeLJfqzp_DvBXph_gSFROw";
		System.out.println("==============================");
		Claims claims=JWTUtil.getClaims("RANI", token);
		/*System.out.println("subject/username ::"+claims.getSubject());
		System.out.println(" client id ::"+claims.getId());
		System.out.println("expirty  date ,time ::"+claims.getExpiration());
		System.out.println("issued date ,time"+claims.getIssuedAt());*/
		
		System.out.println("========================");
		System.out.println("is this  token valid ::"+JWTUtil.isTokenValid("RANI", token));
		System.out.println(" Expiry Date and time ::"+JWTUtil.getExpiryDate("RANI", token));
		System.out.println(" user/subject name ::"+JWTUtil.getSubject("RANI", token));
		
	}
}
