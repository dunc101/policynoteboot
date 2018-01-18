package com.ipacc.util;

import org.junit.Ignore;

import oracle.jdbc.pool.OracleDataSource;

import com.ipacc.policy.note.util.ExternalBeanRegistrar;

@Ignore
public class TestSetup {

	private static boolean isSetup = false;

	public static void setup() throws Exception {
		if (!isSetup) {
			OracleDataSource ods;
			ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@xtst-scan/tst1");
			ods.setUser("polnote_service");
			ods.setPassword("p0ln0t3t3st");
			ExternalBeanRegistrar.setTGDBSERVER1DataSource(ods);
			ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@xtst-scan/tst2");
			ods.setUser("polnote_service");
			ods.setPassword("p0ln0t3t3st");
			ExternalBeanRegistrar.setTGDBSERVER2DataSource(ods);
			ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@xtst-scan/tst3");
			ods.setUser("polnote_service");
			ods.setPassword("p0ln0t3t3st");
			ExternalBeanRegistrar.setTGDBSERVER3DataSource(ods);
			ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@10.99.1.60:1521/ORICTST.WORLD");
			ods.setUser("inquiry");
			ods.setPassword("inquiry1");
			ExternalBeanRegistrar.setDB4(ods);
		}
		isSetup = true;
	}

}
