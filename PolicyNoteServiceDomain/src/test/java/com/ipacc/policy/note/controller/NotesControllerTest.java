package com.ipacc.policy.note.controller;

import static org.junit.Assert.*;

import java.io.File;
import org.junit.Test;
import org.junit.Before;

import com.ipacc.policy.note.controller.NotesServiceController;
import com.ipacc.policy.note.util.FileToString;
import com.ipacc.util.TestSetup;

import java.io.InputStream;

public class NotesControllerTest {

	protected String xmlStringTG;
	protected String xmlStringMF;
	protected String xmlStringTGUpdate;
	protected String xmlStringTGUpdateCC;
	protected File file;

	@Before
	public void setup() throws Exception {
		InputStream is = getClass().getResourceAsStream("/NotesTest.xml");
		xmlStringTG = FileToString.inputStreamToString(is);

		is = getClass().getResourceAsStream("/NotesTest2.xml");
		xmlStringMF = FileToString.inputStreamToString(is);

		is = getClass().getResourceAsStream("/NotesTest3-update.xml");
		xmlStringTGUpdate = FileToString.inputStreamToString(is);

		is = getClass().getResourceAsStream("/NotesTestCC-update.xml");
		xmlStringTGUpdateCC = FileToString.inputStreamToString(is);

		TestSetup.setup();
	}

	@Test
	public void testSave() throws Exception {
		// Fl policy
		assertTrue(NotesServiceController.save(xmlStringTG, "109557283627001", 1));
		// Classic Collector
		assertTrue(NotesServiceController.save(xmlStringTG, "604610000000012", 1));
		// TN
		assertTrue(NotesServiceController.save(xmlStringTG, "141000008038730", 1));
		// Clearpath
		assertTrue(NotesServiceController.save(xmlStringMF, "01386077400", 1));
	}

	@Test
	public void testUpdate() throws Exception {
		assertTrue(NotesServiceController.update(xmlStringTGUpdate, "141000008038730", 1));
		assertTrue(NotesServiceController.update(xmlStringTGUpdate, "604610000000012", 1));
	}

	@Test
	public void testSelect() throws Exception {
	    //Test null change num
		NotesServiceController.select("141000008038730", 1);
		NotesServiceController.select("109557283627001", 1);
		NotesServiceController.select("604610000000012", 0);
		
	}

}
