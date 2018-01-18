package com.ipacc.common.service;

import com.ipacc.common.domain.SystemLoc;

public interface SystemLocFindService {

	SystemLoc find(String env, int stateCode, int productCode) throws Exception;

	SystemLoc getByEnvStateProd(SystemLoc systemLoc) throws Exception;
}
