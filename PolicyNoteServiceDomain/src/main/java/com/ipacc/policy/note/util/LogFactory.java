package com.ipacc.policy.note.util;

public class LogFactory {

	private LogFactory() {}
	
	public static IPACCCommonLogger getLogger() {

		return new IPACCCommonLogger();
	}
}