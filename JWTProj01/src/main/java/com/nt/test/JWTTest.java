package com.nt.test;

import com.nt.utility.JWTUtil;

public class JWTTest {

	public static void main(String[] args) {
		String token=JWTUtil.generateToken("5435AA", "RAJA", "RANI");
		System.out.println(token);
	}
}
