
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.ipacc.services.policy.policynoteservice.v2.generated;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.WebServiceContext;

import org.apache.cxf.jaxws.context.WrappedMessageContext;
import org.apache.cxf.jaxws.handler.soap.SOAPMessageContextImpl;
import org.apache.cxf.message.Message;
import org.springframework.stereotype.Component;

import com.ipacc.common.controller.SystemLocController;
import com.ipacc.common.domain.SystemLoc;
import com.ipacc.policy.note.controller.NotesServiceController;
import com.ipacc.policy.note.domain.Note;
import com.ipacc.policy.note.domain.Notes;
import com.ipacc.policy.note.util.FormatUtil;

/**
 * This class was generated by Apache CXF 3.1.11
 * 2017-04-12T12:16:12.078-05:00
 * Generated source version: 3.1.11
 * 
 */

@Component
@javax.jws.WebService(
                      serviceName = "PolicyNoteService",
                      portName = "PolicyNoteSOAPBing1",
                      targetNamespace = "http://services.ipacc.com/policy/PolicyNoteService/v2",
                      //wsdlLocation = "http://inf012prda.ipacc.com:13131/policynoteservice/v2?wsdl",
                      endpointInterface = "com.ipacc.services.policy.policynoteservice.v2.generated.PolicyNoteService")
                      
public class PolicyNoteSOAPBing1Impl implements PolicyNoteService {

    private static final String SYSTEM = "SYSTEM";

	private static final String PDS_DB_1310 = "PDS-DB-1310";

	private static final String POLICY_NOTE_SERVICE = "PolicyNoteService";

	private static final String PDS_SVC_1000 = "PDS-SVC-1000";

	private static final Logger LOG = Logger.getLogger(PolicyNoteSOAPBing1Impl.class.getName());
    
    @Resource 
    WebServiceContext wsContext;

    /* (non-Javadoc)
     * @see com.ipacc.services.policy.policynoteservice.v2.PolicyNoteService#saveNotes(com.ipacc.services.policy.policynoteservice.v2.ServiceInfoType serviceInfo, com.ipacc.services.policy.policynoteservice.v2.SaveNotesRequestType notesParms)*
     */
    public SaveNotesResponse saveNotes(ServiceInfoType serviceInfo, SaveNotesRequestType notesParms) throws SaveNotesFaultResponseMsg   { 
        LOG.info("Executing operation saveNotes");

		String transId = resetTransId(serviceInfo.getTransID());
		String clientId = serviceInfo.getClientID();
		if (clientId == null || clientId.trim().length() < 3) {
			String msg = "Unable to Save Notes to TG database. Please input client ID to call this service";
			IPACCFaultType.IPACCErrors errors = new IPACCFaultType.IPACCErrors();
			IPACCFaultType fault = new IPACCFaultType();
			fault.setIPACCErrors(errors);
	        SaveNotesFaultResponseMsg snfrd = new SaveNotesFaultResponseMsg(msg, fault);
			GeneralErrorType generalError = new GeneralErrorType();
			generalError.setErrorCode(PDS_SVC_1000);
			generalError.setErrorMessage(msg);
			generalError.setErrorNumber(1000);
			generalError.setErrorSource(POLICY_NOTE_SERVICE);
			generalError.setErrorType("APP");
			snfrd.getFaultInfo().setIPACCErrors(errors);
			snfrd.getFaultInfo().setMessage(msg);
			errors.getIPACCError().add(generalError);
			
			//logger.error(transId, clientId, msg);
			throw new SaveNotesFaultResponseMsg(msg, fault);			
		}

		String notesReturnMessage;
		String policyId = notesParms.getPolicyNumber();
		int version = notesParms.getVersionNumber();
		String xmlString = "";
		Notes notes = convertPolicyNoteExtTypeToDomainNotes(notesParms.getNotes().getNote());
		if(notesParms.getNotes().getNote().size() == 1) {
			xmlString = "<Notes>" + "\n" + xmlString + "\n" + "</Notes>";
			//logger.debug(transId, clientId, xmlString);
		}
		//logger.debug(transId, clientId, "Note request xml = " +xmlString);
		try {
			NotesServiceController.save(xmlString, policyId, version, transId, clientId);
			notesReturnMessage = "NotesSaved";
			//logger.performance(transId, clientId, "SaveNotes", System.currentTimeMillis()-startTime, true);
		} catch (Exception e) {
			//logger.performance(transId, clientId, "SaveNotes", System.currentTimeMillis()-startTime, false);
			//snfrd.addNewSaveNotesFaultResponse().addNewIPACCErrors().addNewIPACCError();
			String msg = "Unable to Save Notes to TG database.";
			IPACCFaultType.IPACCErrors errors = new IPACCFaultType.IPACCErrors();
			IPACCFaultType fault = new IPACCFaultType();
			fault.setIPACCErrors(errors);
	        SaveNotesFaultResponseMsg snfrd = new SaveNotesFaultResponseMsg(msg, fault);
			GeneralErrorType generalError = new GeneralErrorType();
			generalError.setErrorCode(PDS_DB_1310);
			generalError.setErrorMessage(e.getMessage());
			generalError.setErrorNumber(1310);
			generalError.setErrorSource(POLICY_NOTE_SERVICE);
			generalError.setErrorType(SYSTEM);
			generalError.setStackTrace(Arrays.toString(e.getStackTrace()));
			snfrd.getFaultInfo().setIPACCErrors(errors);
			snfrd.getFaultInfo().setMessage(msg);
			errors.getIPACCError().add(generalError);
			
			//logger.error(transId, clientId, "Unable to Save Notes to TG database. The input string is " + notesParms.toString(), e);
			throw new SaveNotesFaultResponseMsg(e.getMessage(), fault);
		}
		
		SaveNotesResponse snrd = new SaveNotesResponse();
		snrd.setOut(notesReturnMessage);
		return snrd;
    }

    /* (non-Javadoc)
     * @see com.ipacc.services.policy.policynoteservice.v2.PolicyNoteService#getNotes(com.ipacc.services.policy.policynoteservice.v2.ServiceInfoType serviceInfo, com.ipacc.services.policy.policynoteservice.v2.GetNotesRequestType getNotesParams)*
     */
    public GetNotesResponse getNotes(ServiceInfoType serviceInfo, GetNotesRequestType getNotesParams) throws GetNotesFaultResponseMsg   { 
        LOG.info("Executing operation getNotes");
		// Add the business logic here
		
		String transId = resetTransId(serviceInfo.getTransID());
		String clientId = serviceInfo.getClientID();
		if (clientId == null || clientId.trim().length() < 3) {
			String msg = "Unable to Get Notes to TG database. Please input client ID to call this service";

			IPACCFaultType.IPACCErrors errors = new IPACCFaultType.IPACCErrors();
			IPACCFaultType fault = new IPACCFaultType();
			fault.setIPACCErrors(errors);
	        SaveNotesFaultResponseMsg faultDoc = new SaveNotesFaultResponseMsg(msg, fault);
			GeneralErrorType generalError = new GeneralErrorType();
			generalError.setErrorCode(PDS_SVC_1000);
			generalError.setErrorMessage(msg);
			generalError.setErrorNumber(1000);
			generalError.setErrorSource(POLICY_NOTE_SERVICE);
			generalError.setErrorType("APP");
			generalError.setStackTrace(msg);
			faultDoc.getFaultInfo().setIPACCErrors(errors);
			faultDoc.getFaultInfo().setMessage(msg);
			errors.getIPACCError().add(generalError);
			//logger.error(transId, clientId, msg);
			throw new GetNotesFaultResponseMsg(msg, fault);
		}
			
		TGPolicyNoteType note;

		GetNotesResponse.Notes notes = new GetNotesResponse.Notes();
		List<TGPolicyNoteType> noteList = new ArrayList<>();
		notes.getNote().addAll(noteList);
		SegmentInfoType segInfoType;
		List<Note> list = null; //domain Note

		String policyId = getNotesParams.getPolicyNumber();
		int version = 0;
		if (getNotesParams.getVersionNumber() != null) {	
			version = getNotesParams.getVersionNumber();
		}

		GetNotesResponse resDoc = new GetNotesResponse();

		try {
			list = NotesServiceController.select(policyId, version, transId, clientId);
            for (Note indexNote : list)  {
            	note = new TGPolicyNoteType();
				note.setAuthorID(indexNote.getAuthorID());
				Date changeEffDate = FormatUtil.parseStringToDate(indexNote.getChangeEffectiveDateTime()); 
				if (changeEffDate != null) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(changeEffDate);
					note.setChangeEffectiveDateTime(convertCalendarToXMLGregorianCalendar(cal));
				}
				String changeType =indexNote.getChangeType();
				if (changeType != null) {
					note.setChangeType(changeType);					
				}

				Calendar cal2 = Calendar.getInstance();				
				cal2.setTime((Date)indexNote.getCreateDate());
				note.setCreatedDate(convertCalendarToXMLGregorianCalendar(cal2));
				Calendar cal3 = Calendar.getInstance();
				Date handleBy = indexNote.getHandleBy();
				if (handleBy != null) {
					cal3.setTime(handleBy);
					note.setHandledBy(convertCalendarToXMLGregorianCalendar(cal3));
				}
				note.setNoteNumber((int)indexNote.getNoteNum());
				note.setNoteText(indexNote.getNoteText());
				note.setPolicyNumber(policyId);
				note.setRedFlag(indexNote.getRedFlag());
				note.setSourceCode(indexNote.getSourceCode());
				note.setSystemSource(indexNote.getSystemSource());
				note.setVersionNumber(indexNote.getVersion());
				segInfoType = new SegmentInfoType();
				segInfoType.setChangeNumber(indexNote.getChangeNum());
				segInfoType.setUserId(indexNote.getUserID()); 
				note.setPolicyNoteSegmentInfo(segInfoType);
            	notes.getNote().add(note);
            }
			//logger.performance(transId, clientId, "GetNotes", System.currentTimeMillis()-startTime, true);
		} catch (Exception e) {
			
			String msg = "Unable to Get Notes from TG database.";
			IPACCFaultType.IPACCErrors errors = new IPACCFaultType.IPACCErrors();
			IPACCFaultType fault = new IPACCFaultType();
			fault.setIPACCErrors(errors);
	        SaveNotesFaultResponseMsg faultDoc = new SaveNotesFaultResponseMsg(msg, fault);
			GeneralErrorType generalError = new GeneralErrorType();
			generalError.setErrorCode(PDS_DB_1310);
			generalError.setErrorMessage(e.getMessage());
			generalError.setErrorNumber(1310);
			generalError.setErrorSource(POLICY_NOTE_SERVICE);
			generalError.setErrorType(SYSTEM);
			generalError.setStackTrace(Arrays.toString(e.getStackTrace()));
			faultDoc.getFaultInfo().setIPACCErrors(errors);
			faultDoc.getFaultInfo().setMessage(msg);
			errors.getIPACCError().add(generalError);

			//logger.error(transId, clientId, "Unable to Get Notes from TG database. The input string is " + getNotesParams.toString(), e);
			throw new GetNotesFaultResponseMsg(msg, fault);
		}
		
		resDoc.setNotes(notes);
		return resDoc;
    }

    /* (non-Javadoc)
     * @see com.ipacc.services.policy.policynoteservice.v2.PolicyNoteService#findSystemLoc(com.ipacc.services.policy.policynoteservice.v2.ServiceInfoType serviceInfo, com.ipacc.services.policy.policynoteservice.v2.FindSystemLocRequestType sysLocParms)*
     */
    public FindSystemLocResponse findSystemLoc(ServiceInfoType serviceInfo, FindSystemLocRequestType sysLocParms) throws FindSystemLocFaultResponseMsg   { 
        LOG.info("Executing operation findSystemLoc");
		String clientId = serviceInfo.getClientID();
		if (clientId == null || clientId.trim().length() < 3) {
			String msg = "Unable to perform findSystemLoc. Please input client ID to call this service";
			
			IPACCFaultType.IPACCErrors errors = new IPACCFaultType.IPACCErrors();
			IPACCFaultType fault = new IPACCFaultType();
			fault.setIPACCErrors(errors);
			FindSystemLocFaultResponseMsg faultDoc = new FindSystemLocFaultResponseMsg(msg, fault);
			GeneralErrorType generalError = new GeneralErrorType();
			generalError.setErrorCode(PDS_SVC_1000);
			generalError.setErrorMessage(msg);
			generalError.setErrorNumber(1000);
			generalError.setErrorSource(POLICY_NOTE_SERVICE);
			generalError.setErrorType("APP");
			generalError.setStackTrace(msg);
			faultDoc.getFaultInfo().setIPACCErrors(errors);
			faultDoc.getFaultInfo().setMessage(msg);
			errors.getIPACCError().add(generalError);
			//logger.error(transId, clientId, msg);
			throw new FindSystemLocFaultResponseMsg(msg, fault);
		}

		String systemLocReturnMessage = "";
		try {
			SystemLoc systemLoc = SystemLocController.find(sysLocParms.getStateCode(), 
					sysLocParms.getProductCode(), serviceInfo.getTransID(),
					serviceInfo.getClientID());
			systemLocReturnMessage = systemLoc.getOwnerName().trim() + ":" + systemLoc.getServerName().trim();
			//logger.performance(transId, clientId, "findSystemLoc", System.currentTimeMillis()-startTime, true);
		} catch (Exception e) {
			String msg = "Unable to Find SystemLoc from TG Database based on input State: " 
													+ sysLocParms.getStateCode() + " and ProductCode: "
													+ sysLocParms.getProductCode();
			
			IPACCFaultType.IPACCErrors errors = new IPACCFaultType.IPACCErrors();
			IPACCFaultType fault = new IPACCFaultType();
			fault.setIPACCErrors(errors);
			FindSystemLocFaultResponseMsg faultDoc = new FindSystemLocFaultResponseMsg(msg, fault);
			GeneralErrorType generalError = new GeneralErrorType();
			generalError.setErrorCode("PDS-APP-8100");
			generalError.setErrorMessage(msg);
			generalError.setErrorNumber(8100);
			generalError.setErrorSource(POLICY_NOTE_SERVICE);
			generalError.setErrorType("APP");
			generalError.setStackTrace(Arrays.toString(e.getStackTrace()));
			faultDoc.getFaultInfo().setIPACCErrors(errors);
			faultDoc.getFaultInfo().setMessage(msg);
			errors.getIPACCError().add(generalError);
			
			throw new FindSystemLocFaultResponseMsg(msg, fault);
		}
		

		FindSystemLocResponse fslrd = new FindSystemLocResponse();
		fslrd.setOut(systemLocReturnMessage);
		return fslrd;
    }

    /* (non-Javadoc)
     * @see com.ipacc.services.policy.policynoteservice.v2.PolicyNoteService#ping(com.ipacc.services.policy.policynoteservice.v2.PingRequest status, com.ipacc.services.policy.policynoteservice.v2.ServiceInfoType serviceInfo)*
     */
    public PingResponse ping(PingRequest status, ServiceInfoType serviceInfo) { 
        LOG.info("Executing operation ping");
		PingResponse prd = new PingResponse();
		
		String pingReturnMessage = "Alive";
		prd.setOut(pingReturnMessage + ": " + status.getIn() + " TransID: " + serviceInfo.getTransID());
		return prd;
    }

    /* (non-Javadoc)
     * @see com.ipacc.services.policy.policynoteservice.v2.PolicyNoteService#updateNote(com.ipacc.services.policy.policynoteservice.v2.ServiceInfoType serviceInfo, com.ipacc.services.policy.policynoteservice.v2.UpdateNoteRequestType updatNoteParams)*
     */
    public UpdateNoteResponse updateNote(ServiceInfoType serviceInfo, UpdateNoteRequestType updatNoteParams) throws UpdateNoteFaultMsg   { 
        LOG.info("Executing operation updateNote");
		// Add the business logic here
		String transId = resetTransId(serviceInfo.getTransID());
		String clientId = serviceInfo.getClientID();
		if (clientId == null || clientId.trim().length() < 3) {
			String msg = "Unable to Save Notes to TG database. Please input client ID to call this service";
			IPACCFaultType.IPACCErrors errors = new IPACCFaultType.IPACCErrors();
			IPACCFaultType fault = new IPACCFaultType();
			fault.setIPACCErrors(errors);
			UpdateNoteFaultMsg faultDoc = new UpdateNoteFaultMsg(msg, fault);
			GeneralErrorType generalError = new GeneralErrorType();
			generalError.setErrorCode(PDS_SVC_1000);
			generalError.setErrorMessage(msg);
			generalError.setErrorNumber(1000);
			generalError.setErrorSource(POLICY_NOTE_SERVICE);
			generalError.setErrorType("APP");
			faultDoc.getFaultInfo().setIPACCErrors(errors);
			faultDoc.getFaultInfo().setMessage(msg);
			errors.getIPACCError().add(generalError);
	        
			//logger.error(transId, clientId, msg);
			throw new UpdateNoteFaultMsg(msg, fault);			
		}

		String returnMessage = "";
		String policyId = updatNoteParams.getPolicyNumber();
		int version = updatNoteParams.getVersionNumber();
		com.ipacc.policy.note.domain.Note note = convertPolicyNoteExtTypeToDomainNote(updatNoteParams.getNote());
		String xmlString = note.toString();
		//logger.debug(transId, clientId, "update Note request xml = " +xmlString);
		try {
			NotesServiceController.update(xmlString, policyId, version, transId, clientId);
			returnMessage = "NoteUpdated";
			//logger.performance(transId, clientId, "UpdateNotes", System.currentTimeMillis()-startTime, true);
		} catch (Exception e) {
			//logger.performance(transId, clientId, "UpdateNotes", System.currentTimeMillis()-startTime, false);
			String msg = "Unable to Update Notes to TG database.";
			IPACCFaultType.IPACCErrors errors = new IPACCFaultType.IPACCErrors();
			IPACCFaultType fault = new IPACCFaultType();
			fault.setIPACCErrors(errors);
			UpdateNoteFaultMsg faultDoc = new UpdateNoteFaultMsg(msg, fault);
			GeneralErrorType generalError = new GeneralErrorType();
			generalError.setErrorCode(PDS_DB_1310);
			generalError.setErrorMessage(e.getMessage());
			generalError.setErrorNumber(1310);
			generalError.setErrorSource(POLICY_NOTE_SERVICE);
			generalError.setErrorType(SYSTEM);
			generalError.setStackTrace(Arrays.toString(e.getStackTrace()));
			faultDoc.getFaultInfo().setIPACCErrors(errors);
			faultDoc.getFaultInfo().setMessage(msg);
			errors.getIPACCError().add(generalError);
			//logger.error(transId, clientId, "Unable to Update Notes to TG database. The input string is " + updatNoteParams.toString(), e);
			throw new UpdateNoteFaultMsg(msg, fault);
		}
		
		
		UpdateNoteResponse resDoc = new UpdateNoteResponse();
		resDoc.setOut(returnMessage);
		return resDoc;
    }
    
	private String resetTransId (String transId) {
		if (transId != null && transId.trim().length() > 0) {
			return transId;
		} else {
			Date now = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyymmddHH:mm:sss");
			return "PNS"+ sf.format(now);
		}		
	}
	
	final private static ThreadLocal<DatatypeFactory> datatypeFactoryHolder = new ThreadLocal<DatatypeFactory>()
    {
        @Override
        protected DatatypeFactory initialValue()
        {
            try
            {
                return DatatypeFactory.newInstance();
            } catch (DatatypeConfigurationException e)
            {
                throw new IllegalStateException("failed to create " + DatatypeFactory.class.getSimpleName(), e);
            }
        }
    };
	
	private XMLGregorianCalendar convertCalendarToXMLGregorianCalendar(Calendar cal) throws DatatypeConfigurationException {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(cal.getTime());
		return datatypeFactoryHolder.get().newXMLGregorianCalendar(c);
	}
	
	private com.ipacc.policy.note.domain.Notes convertPolicyNoteExtTypeToDomainNotes(List<PolicyNoteExtType> notes) {
		com.ipacc.policy.note.domain.Notes newNotes = new com.ipacc.policy.note.domain.Notes();
		List<Note> no = new ArrayList<>();
		newNotes.setNotes(no);
		for (PolicyNoteExtType n : notes) {
			newNotes.getNotes().add(convertPolicyNoteExtTypeToDomainNote(n));
		}
		return newNotes;
	}
	
	private com.ipacc.policy.note.domain.Note convertPolicyNoteExtTypeToDomainNote(PolicyNoteExtType origNote) {
		com.ipacc.policy.note.domain.Note newNote = new com.ipacc.policy.note.domain.Note();
		newNote.setAuthorID(origNote.getAuthorID());
		newNote.setChangeEffDate(origNote.getChangeEffectiveDateTime().toGregorianCalendar().getTime());
		newNote.setChangeType(origNote.getChangeType());
		newNote.setCompanyID(origNote.getCompanyID());
		newNote.setCreateDate(origNote.getCreatedDate().toGregorianCalendar().getTime());
		newNote.setHandleBy(origNote.getHandledBy().toGregorianCalendar().getTime());
		newNote.setNoteNum(origNote.getNoteNumber());
		newNote.setNoteText(origNote.getNoteText());
		newNote.setNoteTypeCode(origNote.getNoteTypeCode());
		newNote.setOriginInd(origNote.getOriginInd());
		newNote.setPolicyState(origNote.getPolicyState());
		newNote.setProcessor(origNote.getProcessor());
		newNote.setRequestName(origNote.getRequestName());
		newNote.setSourceCode(origNote.getSourceCode());
		newNote.setSystemSource(origNote.getSystemSource());
		
		return newNote;
	}

}
