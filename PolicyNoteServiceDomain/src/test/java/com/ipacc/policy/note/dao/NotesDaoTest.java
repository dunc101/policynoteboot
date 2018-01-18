package com.ipacc.policy.note.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.ipacc.policy.note.domain.Note;
import com.ipacc.policy.note.util.ContextFactory;
import com.ipacc.util.TestSetup;

public class NotesDaoTest {

	ApplicationContext context;

	@Before
	public void setup() throws Exception {
		TestSetup.setup();
		context = ContextFactory.getContext();
	}

	@Test
	public void testSaveTGPANote() throws Exception {
		System.out.println("Getting NoteDao PA Bean");
		NoteDao noteDao2 = (NoteDao) context.getBean("noteDaoDB2");
		Note note = new Note();
		long startMillis;
		long runInterval;

		/*
		 * Inserting note test
		 */
		note.setPolicyID("141000008038730");

		note.setNoteNum(1884455);
		note.setOwnerName("NSA_TN.");
		note.setNoteText("Testing");
		note.setVersion(1);
		note.setSourceCode("dunno");
		note.setSystemSource("stilldunno");
		note.setRedFlag(true);
		note.setAuthorID("12345678");
		note.setUserID("FZ");
		note.setCompanyID("05");
		note.setPolicyState("TN");
		note.setRequestName("Agent-FZ");
		note.setProcessor("FZ");
		note.setNoteTypeCode("E");
		note.setOriginInd("M");
		try {
			note.setChangeEffectiveDateTime("2013-09-27T15:06:20.717Z");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Inserting Note for PA Policy: " + note.getPolicyID());

		startMillis = System.currentTimeMillis();
		noteDao2.save(note);
		runInterval = System.currentTimeMillis() - startMillis;
		System.out.println("Save PA took " + runInterval + " ms");
	}

	@Test
	public void testSaveTGCCNote() throws Exception {
		System.out.println("Getting NoteDao CC Bean");
		NoteDao noteDao = (NoteDao) context.getBean("noteDaoDB1");
		Note note = new Note();
		long startMillis;
		long runInterval;

		/*
		 * Inserting note test
		 */
		note.setPolicyID("604610000000012");

		note.setNoteNum(1884455);
		note.setOwnerName("CCA_CA.");
		note.setNoteText("Testing");
		note.setVersion(1);
		note.setSourceCode("dunno");
		note.setSystemSource("stilldunno");
		note.setRedFlag(true);
		note.setAuthorID("12345678");
		note.setUserID("FZ");
		note.setCompanyID("05");
		note.setPolicyState("CA");
		note.setRequestName("Agent-FZ");
		note.setProcessor("FZ");
		note.setNoteTypeCode("E");
		note.setOriginInd("M");
		try {
			note.setChangeEffectiveDateTime("2002-05-30T09:30:10.09Z");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Inserting Note for CC Policy: " + note.getPolicyID());

		startMillis = System.currentTimeMillis();
		noteDao.save(note);
		runInterval = System.currentTimeMillis() - startMillis;
		System.out.println("Save CC took " + runInterval + " ms");
	}

	@Test
	public void testSaveTGCVNote() throws Exception {
		System.out.println("Getting NoteDao CV Bean");
		NoteDao noteDao = (NoteDao) context.getBean("noteDaoDB2");
		Note note = new Note();
		long startMillis;
		long runInterval;

		/*
		 * Inserting note test
		 */
		note.setPolicyID("509000669245001");

		note.setNoteNum(1884455);
		note.setOwnerName("NSC_FL.");
		note.setNoteText("Testing");
		note.setVersion(1);
		note.setSourceCode("dunno");
		note.setSystemSource("stilldunno");
		note.setRedFlag(true);
		note.setAuthorID("12345678");
		note.setUserID("FZ");
		note.setCompanyID("05");
		note.setPolicyState("FL");
		note.setRequestName("Agent-FZ");
		note.setProcessor("FZ");
		note.setNoteTypeCode("E");
		note.setOriginInd("M");
		try {
			note.setChangeEffectiveDateTime("2002-05-30T09:30:10.09Z");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Inserting Note for CV Policy: " + note.getPolicyID());

		startMillis = System.currentTimeMillis();
		noteDao.save(note);
		runInterval = System.currentTimeMillis() - startMillis;
		System.out.println("Save CV took " + runInterval + " ms");
	}

	@Test
	public void testSaveClearpathNote() throws Exception {
		System.out.println("Getting NoteDao clearpath Bean");
		NoteDao noteDao = (NoteDao) context.getBean("noteDaoDB4");
		Note note = new Note();
		long startMillis;
		long runInterval;

		/*
		 * Inserting note test
		 */
		note.setPolicyID("01386077400");

		note.setNoteNum(1000);
		// note.setNoteNum(1884455);
		note.setNoteText("Testing");
		note.setVersion(1);
		note.setSourceCode("dunno");
		note.setSystemSource("stilldunno");
		note.setRedFlag(true);
		note.setAuthorID("12345678");
		note.setUserID("FZ");
		note.setCompanyID("05");
		note.setPolicyState("FL");
		note.setRequestName("Agent-FZ");
		note.setProcessor("FZ");
		note.setNoteTypeCode("E");
		note.setOriginInd("M");
		try {
			note.setChangeEffectiveDateTime("2002-05-30T09:30:10.09Z");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// note.setChangeEffDate(new java.util.Date());

		System.out.println("Inserting Note for clearpath Policy: " + note.getPolicyID());

		startMillis = System.currentTimeMillis();
		noteDao.save(note);
		runInterval = System.currentTimeMillis() - startMillis;
		System.out.println("Save clearpath took " + runInterval + " ms");
	}

	@Test
	public void testTGPAUpdateNote() throws Exception {
		System.out.println("Getting NoteDao update PA Bean");
		NoteDao noteDao2 = (NoteDao) context.getBean("noteDaoDB2");

		Note note = new Note();
		long startMillis;
		long runInterval;

		/*
		 * Inserting note test
		 */
		note.setPolicyID("141000008038730");
		// commercial
		// note.setPolicyID("509000669245001");

		note.setNoteNum(1000);
		// note.setNoteNum(1900471);
		note.setOwnerName("NSA_TN.");
		// note.setOwnerName("NSC_FL.");
		note.setVersion(1);
		note.setSourceCode("RedFlag");
		note.setRedFlag(true);

		System.out.println("update note for Policy: " + note.getPolicyID());

		startMillis = System.currentTimeMillis();
		noteDao2.update(note);

		runInterval = System.currentTimeMillis() - startMillis;
		System.out.println("Update PA took " + runInterval + " ms");

	}

	@Test
	public void testTGCCUpdateNote() throws Exception {
		System.out.println("Getting NoteDao CC update Bean");
		NoteDao noteDao = (NoteDao) context.getBean("noteDaoDB1");

		Note note = new Note();
		long startMillis;
		long runInterval;

		/*
		 * Inserting note test
		 */
		note.setPolicyID("604610000000012");
		// commercial
		// note.setPolicyID("509000669245001");

		note.setNoteNum(2868);
		note.setOwnerName("CCA_CA.");
		note.setVersion(1);
		note.setSourceCode("RedFlag");
		note.setRedFlag(true);
		startMillis = System.currentTimeMillis();
		noteDao.update(note);

		System.out.println("update note for CC Policy: " + note.getPolicyID());
		runInterval = System.currentTimeMillis() - startMillis;
		System.out.println("Update CC took " + runInterval + " ms");

	}

	@Test
	public void testSelectnotes() throws Exception {
		System.out.println("Select FL notes");
		NoteDao noteDao1 = (NoteDao) context.getBean("noteDaoDB1");

		NoteDao noteDao2 = (NoteDao) context.getBean("noteDaoDB2");

		long startMillis;
		long runInterval;

		startMillis = System.currentTimeMillis();
		Note note = new Note();
		/*
		 * Inserting note test
		 */
		note.setPolicyID("109557283627001");
		// commercial
		// note.setPolicyID("509000669245001");

		// note.setNoteNum(1900471);
		// note.setOwnerName("NSA_TN.");
		note.setOwnerName("NSA_FL.");
		// note.setVersion(1);

		List<Note> results = noteDao1.getByPolicy(note);

		runInterval = System.currentTimeMillis() - startMillis;
		System.out.println("FL notes took " + runInterval + " ms");
		System.out.println("Return notes " + results);

		startMillis = System.currentTimeMillis();
		note = new Note();
		/*
		 * Inserting note test
		 */
		note.setPolicyID("142000112364001");

		note.setOwnerName("NSA_TX.");
		// note.setVersion(1);

		results = noteDao2.getByPolicy(note);
		System.out.println("version = " + note.getVersion());
		runInterval = System.currentTimeMillis() - startMillis;
		System.out.println("TX notes took " + runInterval + " ms");
		System.out.println("Return notes " + results);

	}
}
