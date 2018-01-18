package com.ipacc.common.dao.impl;

import java.util.List;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ipacc.common.dao.SystemLocDao;
import com.ipacc.common.domain.SystemLoc;

public class SqlMapClientSystemLocDao extends SqlMapClientDaoSupport implements SystemLocDao {

	public List<SystemLoc> getAll() {
		return getSqlMapClientTemplate().queryForList("selectAllSystemLocs", null);
	}

	public SystemLoc getByEnvStateProd(SystemLoc systemLoc) {
		SystemLoc rtnSystemLoc = (SystemLoc) getSqlMapClientTemplate().queryForObject("selectSystemLoc", systemLoc);
		if (rtnSystemLoc == null) {
			throw new ObjectRetrievalFailureException(SystemLoc.class, systemLoc.getState());
		}
		return rtnSystemLoc;
	}
}
