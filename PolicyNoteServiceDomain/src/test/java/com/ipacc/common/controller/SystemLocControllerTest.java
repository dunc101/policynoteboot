package com.ipacc.common.controller;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.ipacc.common.controller.SystemLocController;
import com.ipacc.common.domain.SystemLoc;
import com.ipacc.util.TestSetup;

public class SystemLocControllerTest {

	@Before
	public void setup() throws Exception {
		TestSetup.setup();
	}

	@Test
	public void testFind() {
		try {
			SystemLoc systemLoc = SystemLocController.find(41, 1);
			System.out.println("System loc owner = " + systemLoc.getOwnerName());
			Assert.assertEquals(systemLoc.getOwnerName().trim(), "NSA_TN.");
			Assert.assertTrue(systemLoc.getServerName().trim().endsWith("2"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

		try {
			SystemLoc systemLoc = SystemLocController.find(04, 6);
			System.out.println("System loc owner = " + systemLoc.getOwnerName());
			Assert.assertEquals(systemLoc.getOwnerName().trim(), "CCA_CA.");
			Assert.assertTrue(systemLoc.getServerName().trim().endsWith("1"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
