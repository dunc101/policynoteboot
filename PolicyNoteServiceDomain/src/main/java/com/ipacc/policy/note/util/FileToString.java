package com.ipacc.policy.note.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileToString {

	public static String fileToString(File file) throws Exception {
		StringBuffer fileData = new StringBuffer(1000);
		BufferedReader reader = null;
		char[] buf = new char[1024];
		int numRead = 0;
		try {
			reader = new BufferedReader(new FileReader(file));
			while ((numRead = reader.read(buf)) != -1) {
				String readData = String.valueOf(buf, 0, numRead);
				fileData.append(readData);
				buf = new char[1024];
			}
		} catch (IOException e) {
			throw new Exception("Unable to read input File");
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				throw new Exception("Unable to close StringBuffer");
			}
		}
		return fileData.toString();
	}

	public static String inputStreamToString(InputStream is) throws Exception {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(is));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			return sb.toString();
		} catch (IOException e) {
			throw new Exception("Unable to read input File");
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				throw new Exception("Unable to close StringBuffer");
			}
		}
	}
}
