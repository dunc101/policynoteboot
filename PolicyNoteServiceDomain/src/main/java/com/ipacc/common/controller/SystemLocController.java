package com.ipacc.common.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.springframework.context.ApplicationContext;

//import com.ipacc.log4j.logger.IPACCCommonLogger;
import com.ipacc.common.domain.SystemLoc;
import com.ipacc.common.exception.IPACCApplicationException;
import com.ipacc.common.exception.IPACCBaseException;
import com.ipacc.common.service.SystemLocFindService;
import com.ipacc.policy.note.util.ContextFactory;
import com.ipacc.policy.note.util.IPACCCommonLogger;
import com.ipacc.policy.note.util.LogFactory;

public class SystemLocController {

	public static SystemLoc find(int stateCode, int productCode) throws IPACCBaseException {
		return find(stateCode, productCode, null, null);
	}

	public static SystemLoc find(int stateCode, int productCode, String transId, String clientId)
			throws IPACCBaseException {
		ApplicationContext context = ContextFactory.getContext();
		IPACCCommonLogger logger = LogFactory.getLogger();
		Properties props = (Properties) context.getBean("appProperties");
		String env = props.getProperty("env").toUpperCase();

		long startMillis = System.currentTimeMillis();
		if (transId == null || transId.compareTo("") == 0) {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			Date date = new Date();
			transId = "PDS" + dateFormat.format(date);
		}
		boolean rtnSuccess = false;
		logger.audit(transId, clientId, "Find System Loc");

		SystemLoc rtnSystemLoc = new SystemLoc();

		try {
			SystemLocFindService systemLocFindService = (SystemLocFindService) context.getBean("SystemLocFindSrv");
			rtnSystemLoc = systemLocFindService.find(env, stateCode, productCode);
			rtnSuccess = true;
			//logger.performance(transId, "findSystemLoc", clientId, System.currentTimeMillis() - startMillis, rtnSuccess);
		} catch (Exception e) {
			logger.error(transId, clientId, e.getMessage(), e);
			//logger.performance(transId, "findSystemLoc", clientId, System.currentTimeMillis() - startMillis, rtnSuccess);
			throw new IPACCApplicationException(9000, "PDS", "Unable to complete SystemLocFinder", e);
		}

		return rtnSystemLoc;
	}

}
