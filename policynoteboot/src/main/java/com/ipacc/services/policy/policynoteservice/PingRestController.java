package com.ipacc.services.policy.policynoteservice;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ping Rest Controller class with a ping method that returns back pong to indicate the application is alive.
 * 
 * @author DuncanDA
 *
 */
@Component
@RestController
public class PingRestController {
	private static final String PONG = "pong";
	
	/**
	 * Simple ping method that returns pong to verify the application is listening
	 * 
	 * @return - String pong
	 */
	@RequestMapping("/ping")
	public String ping() {
		// adding a comment
		return PONG;
	}
}
