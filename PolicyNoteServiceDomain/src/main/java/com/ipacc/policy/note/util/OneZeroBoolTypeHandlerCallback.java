package com.ipacc.policy.note.util;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

public class OneZeroBoolTypeHandlerCallback implements TypeHandlerCallback {

	private static final int one = 1;
	private static final int zero = 0;

	public Object getResult(ResultGetter getter) throws SQLException {
		int i = getter.getInt();
		if (one == i) {
			return new Boolean(true);
		} else if (zero == i) {
			return new Boolean(false);
		} else {
			throw new SQLException("Unexpected value" + i + " found where " + one + " or " + zero + " was expected.");
		}
	}

	public void setParameter(ParameterSetter setter, Object parameter) throws SQLException {
		boolean b = ((Boolean) parameter).booleanValue();
		if (b) {
			setter.setInt(one);
		} else {
			setter.setInt(zero);
		}
	}

	public Object valueOf(String s) {
		if (Integer.toString(one).equals(s)) {
			return new Boolean(true);
		} else if (Integer.toString(zero).equals(s)) {
			return new Boolean(false);
		} else {
			return new Boolean(false);
		}
	}

}
