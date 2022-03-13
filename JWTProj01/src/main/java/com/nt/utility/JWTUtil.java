package com.nt.utility;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {
	
	public static  String generateToken(String id,String subject, String skey) {
		return  Jwts.builder()
				     .setId(id)
				     .setSubject(subject)
				     .setIssuer("NIT")
				     .setIssuedAt(new Date(System.currentTimeMillis()))
				     .setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(1)))
				     .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(skey.getBytes()))
				     .compact();
	}
	
	public  static  Claims getClaims(String skey , String token) {
		return  Jwts.parser().setSigningKey(Base64.getEncoder().encode(skey.getBytes()))
				      .parseClaimsJws(token)
				      .getBody();
		
	}
	
	public  static  boolean  isTokenValid(String skey, String token) {
		Date tokenExpiryDate=getClaims(skey, token).getExpiration();
		Date  sysDate=new Date();
		return  sysDate.before(tokenExpiryDate);
	}
	
	public  static   String  getSubject(String skey,String token) {
		 return  getClaims(skey, token).getSubject();
	}
	
	public static Date  getExpiryDate(String skey ,String token) {
		 return  getClaims(skey, token).getExpiration();
	}
	

}
