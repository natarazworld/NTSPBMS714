package com.nt.utility;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;

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

}
