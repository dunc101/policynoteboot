package com.ipacc.policy.note.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtil {
	public static Date parseStringToDate(String strDate) throws ParseException {
		if (strDate == null) {
			return null;
		}
		strDate = strDate.trim();
		if (strDate.length() == 0) {
			return null;
		}
		SimpleDateFormat sf = new SimpleDateFormat();
		try {
			if (strDate.length() == 10) {
				sf.applyPattern("yyyy-MM-dd");
				return sf.parse(strDate);
			} else if (strDate.length() == 11 && strDate.contains("Z")) {
				sf = new SimpleDateFormat("yyyy-MM-dd'Z'");
				return sf.parse(strDate);
			} else if (strDate.length() == 19 && strDate.contains("T")) {
				sf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
				return sf.parse(strDate);
			} else if (strDate.length() == 20 && strDate.contains("T") && strDate.contains("Z")) {
				sf.applyPattern("yyyy-MM-dd'T'hh:mm:ss'Z'");
				return sf.parse(strDate);
			} else if (strDate.length() >= 21 && strDate.contains("T") && !strDate.contains("Z")) {
				sf.applyPattern("yyyy-MM-dd'T'hh:mm:ss.SSS");
				return sf.parse(strDate);
			} else if (strDate.length() >= 21 && strDate.contains("T") && strDate.contains("Z")) {
				sf.applyPattern("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");
				return sf.parse(strDate);
			} else {
				throw new java.text.ParseException("can't parse change effective date correctly " + strDate, 0);
			}

		} catch (Exception e) {
			throw new java.text.ParseException("can't parse change effective date correctly " + strDate, 0);
		}

	}

	public static String formatDateToStringDateTime(Date origDate) {
		if (origDate == null) {
			return "";
		}
		SimpleDateFormat sf = new SimpleDateFormat();

		sf.applyPattern("yyyy-MM-dd'T'hh:mm:ss");
		return sf.format(origDate);

	}
}
