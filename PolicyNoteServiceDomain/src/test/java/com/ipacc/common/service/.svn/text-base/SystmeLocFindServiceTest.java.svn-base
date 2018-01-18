package com.ipacc.common.service;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.ipacc.common.dao.SystemLocDao;
import com.ipacc.common.domain.SystemLoc;
import com.ipacc.policy.note.util.ContextFactory;
import com.ipacc.util.TestSetup;

import junit.framework.Assert;

//@ContextConfiguration(locations={"/com/ipacc/policy/note/AppContext.xml"})
//@RunWith(SpringJUnit4ClassRunner.class)
public class SystmeLocFindServiceTest {

	ApplicationContext context;

	@Before
	public void setup() throws Exception {
		TestSetup.setup();
		context = ContextFactory.getContext();
	}

	@Test
	public void testAll() {
		SystemLocDao systemLocDao = null;
		try {
			systemLocDao = (SystemLocDao) context.getBean("SystemLocDAO");
			System.out.println("System loc size  = " + systemLocDao.getAll().size());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testFindDao() {
		SystemLocDao systemLocDao = null;
		SystemLoc systemLoc = new SystemLoc();
		systemLoc.setState(41);
		systemLoc.setEnvironment("TEST");
		systemLoc.setProduct(1);

		try {
			systemLocDao = (SystemLocDao) context.getBean("SystemLocDAO");
			systemLoc = systemLocDao.getByEnvStateProd(systemLoc);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		System.out
				.println("getOwnerName = " + systemLoc.getOwnerName() + " Server name = " + systemLoc.getServerName());
		Assert.assertEquals(systemLoc.getOwnerName().trim(), "NSA_TN.");
		Assert.assertTrue(systemLoc.getServerName().trim().endsWith("2"));

	}

	@Test
	public void testFind() {
		SystemLocFindService systemLocFindService = null;
		String env = "TEST";
		int stateCode = 41;
		int productCode = 1;
		SystemLoc systemLoc = null;

		try {
			systemLocFindService = (SystemLocFindService) context.getBean("SystemLocFindSrv");
			systemLoc = systemLocFindService.find(env, stateCode, productCode);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		System.out
				.println("getOwnerName = " + systemLoc.getOwnerName() + " Server name = " + systemLoc.getServerName());
		Assert.assertEquals(systemLoc.getOwnerName().trim(), "NSA_TN.");
		Assert.assertTrue(systemLoc.getServerName().trim().endsWith("2"));

	}
}
