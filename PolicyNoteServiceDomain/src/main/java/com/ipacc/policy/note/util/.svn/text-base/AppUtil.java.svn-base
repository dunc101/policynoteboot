/**
 * 
 */
package com.ipacc.policy.note.util;

/**
 * @author SankurP
 * 
 */
public class AppUtil {
	public static String getTableName(String category) {
		String tableName = "BATCHMSG";
		if (category != null && category.trim().length() > 0) {
			if (category.equalsIgnoreCase("Message")) {
				tableName = "BATCHMSG";
			}
			if (category.equalsIgnoreCase("MessagePending")) {
				tableName = "BATCHMSGPENDING";
			}
		}
		return tableName;
	}

	public static String getCategoryFromTableName(String tableName) {
		String category = "Message";
		if (tableName != null && tableName.trim().length() > 0) {
			if (tableName.equalsIgnoreCase("BATCHMSG")) {
				tableName = "Message";
			}
			if (tableName.equalsIgnoreCase("BATCHMSGPENDING")) {
				tableName = "MessagePending";
			}
		}
		return category;
	}

	public static String getDataSourceServerPrefix(String serverName) {
		String dsNamePrefix = "TGDBSERVER";
		String dsNumber = "1";
		String ds = dsNamePrefix + dsNumber;
		if (serverName != null && serverName.length() > 0) {
			if (serverName.endsWith("1")) {
				ds = dsNamePrefix + "1";
			} else if (serverName.endsWith("2")) {
				ds = dsNamePrefix + "2";
			} else if (serverName.endsWith("3")) {
				ds = dsNamePrefix + "3";
			} else {
				ds = dsNamePrefix + "1";
			}
		}
		return ds;
	}
}
