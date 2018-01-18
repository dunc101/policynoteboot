package com.ipacc.common.service.impl;

import com.ipacc.common.dao.SystemLocDao;
import com.ipacc.common.domain.SystemLoc;
import com.ipacc.common.service.SystemLocFindService;

public class SystemLocFindServiceImpl implements SystemLocFindService {

	public SystemLoc find(String env, int stateCode, int productCode) {
		SystemLoc systemLoc = new SystemLoc();
		systemLoc.setEnvironment(env);
		systemLoc.setState(stateCode);
		systemLoc.setProduct(productCode);
		return getByEnvStateProd(systemLoc);
	}

	public SystemLoc getByEnvStateProd(SystemLoc systemLoc) {
		return this.systemLocDao.getByEnvStateProd(systemLoc);
	}

	public void setSystemLocDao(SystemLocDao systemLocDao) {
		this.systemLocDao = systemLocDao;
	}

	private SystemLocDao systemLocDao;
}
