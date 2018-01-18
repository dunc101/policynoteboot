package com.ipacc.policy.note.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.context.ApplicationContext;

import com.ipacc.common.domain.SystemLoc;
import com.ipacc.common.exception.IPACCApplicationException;
import com.ipacc.common.exception.IPACCBaseException;
import com.ipacc.common.service.SystemLocFindService;
import com.ipacc.policy.note.domain.Note;
import com.ipacc.policy.note.domain.Notes;
import com.ipacc.policy.note.service.NotesService;
import com.ipacc.policy.note.util.ContextFactory;
import com.ipacc.policy.note.util.IPACCCommonLogger;
import com.ipacc.policy.note.util.LogFactory;

public class NotesServiceController {

	public static boolean save(String xmlString, String policyID, int version) throws IPACCBaseException {
		return save(xmlString, policyID, version, null, null);
	}

	public static boolean save(String xmlString, String policyID, int version, String transId, String clientId)
			throws IPACCBaseException {
		ApplicationContext context = ContextFactory.getContext();
		IPACCCommonLogger logger = LogFactory.getLogger();
		Properties props = (Properties) context.getBean("appProperties");
		String env = props.getProperty("env").toUpperCase();
		
		
		long startMillis = System.currentTimeMillis();
		if (transId == null || transId.compareTo("") == 0) {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			Date date = new Date();
			transId = "PNS" + dateFormat.format(date);
		}
		boolean rtnSuccess = false;
		logger.audit(transId, clientId, "Domain Save Note " + policyID);
		try {
			/*
			 * Deserialize Notes
			 */
			Notes notes = new Notes();
			Serializer serializer = new Persister();
			notes = serializer.read(notes, xmlString);
			notes.setPolicyID(policyID);
			notes.setVersion(version);

			NotesService notesService = null;
			/*
			 * Get Database environment info
			 */
			if (policyID.length() > 14) {
				SystemLocFindService systemLocFindService = (SystemLocFindService) context.getBean("SystemLocFindSrv");
				SystemLoc systemLoc = systemLocFindService.find(env, Integer.parseInt(policyID.substring(1, 3)),
						Integer.parseInt(policyID.substring(0, 1)));
				systemLoc.setDb(systemLoc.getServerName(), env);
				if (systemLoc.getDb() == null) {
					String errorMessage = "Unable to identify database from serverName: "
							+ systemLoc.getServerName().trim() + " and environment: " + env;
					IPACCApplicationException ae = new IPACCApplicationException(9000, "PDS", errorMessage);
					logger.error(transId, clientId, errorMessage, ae);
					throw ae;
				}
				notes.setOwnerName(systemLoc.getOwnerName());

				/*
				 * Insert all Note records
				 */
				notesService = (NotesService) context.getBean("notesUpload" + systemLoc.getDb());
			} else {
				notesService = (NotesService) context.getBean("notesUploadDB4");
			}
			notesService.save(notes);
			rtnSuccess = true;
			logger.performance(transId, "save", clientId, System.currentTimeMillis() - startMillis, rtnSuccess);

		} catch (Exception e) {
			logger.error(transId, clientId, e.getMessage(), e);
			logger.performance(transId, "save", clientId, System.currentTimeMillis() - startMillis, rtnSuccess);
			throw new IPACCApplicationException(9000, "PDS", "Unable to complete NotesUploader.save", e);
		}

		return rtnSuccess;
	}

	public static boolean update(String xmlString, String policyID, int version) throws IPACCBaseException {
		return update(xmlString, policyID, version, null, null);
	}

	public static boolean update(String xmlString, String policyID, int version, String transId, String clientId)
			throws IPACCBaseException {
		ApplicationContext context = ContextFactory.getContext();
		IPACCCommonLogger logger = LogFactory.getLogger();
		Properties props = (Properties) context.getBean("appProperties");
		String env = props.getProperty("env").toUpperCase();

		long startMillis = System.currentTimeMillis();
		if (transId == null || transId.compareTo("") == 0) {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			Date date = new Date();
			transId = "PDS" + dateFormat.format(date);
		}
		boolean rtnSuccess = false;
		logger.audit(transId, clientId, "Domain Update Note " + policyID);
		try {
			/*
			 * Deserialize Notes
			 */
			Note note = new Note();
			Serializer serializer = new Persister();
			note = serializer.read(note, xmlString);
			note.setPolicyID(policyID);
			note.setVersion(version);

			NotesService notesService = null;
			/*
			 * Get Database environment info
			 */
			if (policyID.length() > 14) {
				SystemLocFindService systemLocFindService = (SystemLocFindService) context.getBean("SystemLocFindSrv");
				SystemLoc systemLoc = systemLocFindService.find(env, Integer.parseInt(policyID.substring(1, 3)),
						Integer.parseInt(policyID.substring(0, 1)));
				systemLoc.setDb(systemLoc.getServerName(), env);
				if (systemLoc.getDb() == null) {
					String errorMessage = "Unable to identify database from serverName: "
							+ systemLoc.getServerName().trim() + " and environment: " + env;
					IPACCApplicationException ae = new IPACCApplicationException(9000, "PDS", errorMessage);
					logger.error(transId, clientId, errorMessage, ae);
					throw ae;
				}
				note.setOwnerName(systemLoc.getOwnerName().trim());

				/*
				 * Insert all Note records
				 */
				notesService = (NotesService) context.getBean("notesUpload" + systemLoc.getDb());
			} else {
				String errorMessage = "Invalid policy number: " + policyID;
				IPACCApplicationException ae = new IPACCApplicationException(9000, "PDS", errorMessage);
				logger.error(transId, clientId, errorMessage, ae);
				throw ae;

			}
			notesService.update(note);
			rtnSuccess = true;
			logger.performance(transId, "updateNote", clientId, System.currentTimeMillis() - startMillis, rtnSuccess);

		} catch (Exception e) {
			logger.error(transId, clientId, e.getMessage(), e);
			logger.performance(transId, "updateNote", clientId, System.currentTimeMillis() - startMillis, rtnSuccess);
			throw new IPACCApplicationException(9000, "PDS", "Unable to complete NotesUploader.updateRedFlag", e);
		}

		return rtnSuccess;
	}

	public static List<Note> select(String policyID, int version) throws IPACCBaseException {
		return select(policyID, version, null, null);
	}

	public static List<Note> select(String policyID, int version, String transId, String clientId)
			throws IPACCBaseException {
		ApplicationContext context = ContextFactory.getContext();
		IPACCCommonLogger logger = LogFactory.getLogger();
		
		String env = System.getProperty("env");

		long startMillis = System.currentTimeMillis();
		if (transId == null || transId.compareTo("") == 0) {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			Date date = new Date();
			transId = "PDS" + dateFormat.format(date);
		}
		boolean rtnSuccess = false;
		logger.audit(transId, clientId, "select Note PolicyID = " + policyID + " version = " + version);
		try {
			Note note = new Note();
			note.setPolicyID(policyID);
			note.setVersion(version);

			NotesService notesService = null;
			/*
			 * Get Database environment info
			 */
			if (policyID.length() > 14) {
				SystemLocFindService systemLocFindService = (SystemLocFindService) context.getBean("SystemLocFindSrv");
				SystemLoc systemLoc = systemLocFindService.find(env, Integer.parseInt(policyID.substring(1, 3)),
						Integer.parseInt(policyID.substring(0, 1)));
				systemLoc.setDb(systemLoc.getServerName(), env);
				if (systemLoc.getDb() == null) {
					String errorMessage = "Unable to identify database from serverName: "
							+ systemLoc.getServerName().trim() + " and environment: " + env;
					IPACCApplicationException ae = new IPACCApplicationException(9000, "PDS", errorMessage);
					logger.error(transId, clientId, errorMessage, ae);
					throw ae;
				}
				note.setOwnerName(systemLoc.getOwnerName().trim());

				notesService = (NotesService) context.getBean("notesUpload" + systemLoc.getDb());
			} else {
				String errorMessage = "Invalid policy number: " + policyID;
				IPACCApplicationException ae = new IPACCApplicationException(9000, "PDS", errorMessage);
				logger.error(transId, clientId, errorMessage, ae);
				throw ae;

			}

			logger.performance(transId, "SelectNote", clientId, System.currentTimeMillis() - startMillis, rtnSuccess);
			rtnSuccess = true;
			List<Note> results = notesService.select(note);
			logger.debug(results.toString());
			return results;

		} catch (Exception e) {
			logger.error(transId, clientId, e.getMessage(), e);
			logger.performance(transId, "updateNote", clientId, System.currentTimeMillis() - startMillis, rtnSuccess);
			throw new IPACCApplicationException(9000, "PDS", "Unable to select notes", e);
		}
	}

}
