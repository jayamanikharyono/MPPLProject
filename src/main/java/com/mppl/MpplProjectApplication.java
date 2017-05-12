package com.mppl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;

@SpringBootApplication
public class MpplProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpplProjectApplication.class, args);
		System.out.println((new LdapShaPasswordEncoder().encodePassword("password", null)).toString());
		
	}
}
