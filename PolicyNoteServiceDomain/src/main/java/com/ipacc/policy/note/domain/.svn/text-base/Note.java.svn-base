package com.ipacc.policy.note.domain;

import java.util.Date;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.ipacc.policy.note.util.FormatUtil;
import com.ipacc.policy.note.util.IPACCCommonLogger;
import com.ipacc.policy.note.util.LogFactory;

@Root(strict = false, name = "Note")
public class Note extends DataObject {

	@Element(required = false, name = "PolicyNoteSegmentInfo")
	protected PolicyNoteSegmentInfo policyNoteSegmentInfo = new PolicyNoteSegmentInfo();

	protected long noteNum;

	protected String sourceCode;

	protected String systemSource;

	protected boolean redFlag;

	protected String noteText;

	protected String changeType;

	protected String changeEffectiveDateTime;

	protected Date handleBy;

	protected String authorID;
	// above are the main fields for TG notes
	// Below are the added fileds for mainframe notes

	protected String companyID;

	protected String requestName;

	protected String processor;

	protected String policyState;

	protected String noteTypeCode = "N";

	protected String originInd = "I";

	protected Date changeEffDate;

	protected Date createDate;

	@Element(required = false, name = "NoteNumber")
	public long getNoteNum() {
		return noteNum;
	}

	@Element(required = false, name = "NoteNumber")
	public void setNoteNum(long noteNum) {
		this.noteNum = noteNum;
	}

	@Element(required = false, name = "ChangeType")
	public String getChangeType() {
		if (changeType != null && changeType.length() > 10) {
			return changeType.substring(0, 10);
		} else {
			return changeType;
		}
	}

	@Element(required = false, name = "ChangeType")
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

	@Element(required = false, name = "SourceCode")
	public String getSourceCode() {
		if (sourceCode != null && sourceCode.length() > 15) {
			return sourceCode.substring(0, 15);
		} else {
			return sourceCode;
		}
	}

	@Element(required = false, name = "SourceCode")
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	@Element(required = false, name = "SystemSource")
	public String getSystemSource() {
		if (systemSource != null && systemSource.length() > 10) {
			return systemSource.substring(0, 10);
		} else {
			return systemSource;
		}
	}

	@Element(required = false, name = "SystemSource")
	public void setSystemSource(String systemSource) {
		this.systemSource = systemSource;
	}

	@Element(required = false, name = "NoteText")
	public String getNoteText() {
		if (noteText != null && noteText.length() > 2000) {
			return noteText.substring(0, 2000);
		} else {
			return noteText;
		}
	}

	@Element(required = false, name = "NoteText")
	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}

	@Element(required = false, name = "RedFlag")
	public boolean getRedFlag() {
		return redFlag;
	}

	@Element(required = false, name = "RedFlag")
	public void setRedFlag(boolean redFlag) {
		this.redFlag = redFlag;
	}

	@Element(required = false, name = "HandledBy")
	public Date getHandleBy() {
		return handleBy;
	}

	@Element(required = false, name = "HandledBy")
	public void setHandleBy(Date handleBy) {
		this.handleBy = handleBy;
	}

	public Date getChangeEffDate() {
		return changeEffDate;
	}

	public void setChangeEffDate(Date changeEffDate) {
		IPACCCommonLogger logger = LogFactory.getLogger();
		this.changeEffDate = changeEffDate;
		this.changeEffectiveDateTime = FormatUtil.formatDateToStringDateTime(changeEffDate);
		logger.debug("Setting to ChangeEffDate in setChangeEffDate = " + changeEffDate);
		logger.debug("Setting to changeEffectiveDateTime in setChangeEffDate = " + changeEffectiveDateTime);
	}

	@Element(required = false, name = "ChangeEffectiveDateTime")
	public String getChangeEffectiveDateTime() {
		return changeEffectiveDateTime;
	}

	@Element(required = false, name = "ChangeEffectiveDateTime")
	public void setChangeEffectiveDateTime(String changeEffectiveDateTime) throws java.text.ParseException {
		this.changeEffectiveDateTime = changeEffectiveDateTime;
		IPACCCommonLogger logger = LogFactory.getLogger();
		try {
			logger.debug(changeEffectiveDateTime + "setting to ChangeEffDate in setChangeEffectiveDateTime");
			this.setChangeEffDate(FormatUtil.parseStringToDate(changeEffectiveDateTime));
		} catch (Exception e) {
			throw new java.text.ParseException(
					"can't parse change effective date correctly " + changeEffectiveDateTime, 0);
		}
	}

	@Element(required = false, name = "AuthorID")
	public String getAuthorID() {
		if (authorID != null && authorID.length() > 8) {
			return authorID.substring(0, 8);
		} else {
			return authorID;
		}
	}

	@Element(required = false, name = "AuthorID")
	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}

	public int getChangeNum() {
		return policyNoteSegmentInfo.changeNum;
	}

	public void setChangeNum(int changeNumber) {
		this.policyNoteSegmentInfo.changeNum = changeNumber;
	}

	public String getUserID() {
		if (this.policyNoteSegmentInfo.userID != null && this.policyNoteSegmentInfo.userID.length() > 6) {
			return this.policyNoteSegmentInfo.userID.substring(0, 6);
		} else {
			return this.policyNoteSegmentInfo.userID;
		}
	}

	public void setUserID(String userID) {
		this.policyNoteSegmentInfo.userID = userID;
	}

	@Element(required = false, name = "CompanyID")
	public String getCompanyID() {
		return this.companyID;
	}

	@Element(required = false, name = "CompanyID")
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	@Element(required = false, name = "RequestName")
	public String getRequestName() {
		if (requestName != null && requestName.length() > 50) {
			return requestName.substring(0, 50);
		} else {
			return requestName;
		}
	}

	@Element(required = false, name = "RequestName")
	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}

	@Element(required = false, name = "Processor")
	public String getProcessor() {
		if (processor != null && processor.length() > 50) {
			return processor.substring(0, 50);
		} else {
			return processor;
		}
	}

	@Element(required = false, name = "Processor")
	public void setProcessor(String requestName) {
		this.processor = requestName;
	}

	@Element(required = false, name = "PolicyState")
	public String getPolicyState() {
		if (policyState != null && policyState.length() > 2) {
			return policyState.substring(0, 50);
		} else {
			return policyState;
		}
	}

	@Element(required = false, name = "PolicyState")
	public void setPolicyState(String policyState) {
		this.policyState = policyState;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Element(required = false, name = "NoteTypeCode")
	public String getNoteTypeCode() {
		if (noteTypeCode != null && noteTypeCode.length() > 1) {
			return noteTypeCode.substring(0, 1);
		} else {
			return noteTypeCode;
		}
	}

	@Element(required = false, name = "NoteTypeCode")
	public void setNoteTypeCode(String noteTypeCode) {
		if (noteTypeCode != null) {
			this.noteTypeCode = noteTypeCode;
		}
	}

	@Element(required = false, name = "OriginInd")
	public String getOriginInd() {
		if (originInd != null && originInd.length() > 1) {
			return originInd.substring(0, 1);
		} else {
			return originInd;
		}
	}

	@Element(required = false, name = "OriginInd")
	public void setOriginInd(String originInd) {
		if (originInd != null) {
			this.originInd = originInd;
		}
	}

	protected PolicyNoteSegmentInfo getPolicyNoteSegmentInfo() {
		return policyNoteSegmentInfo;
	}

	protected void setPolicyNoteSegmentInfo(PolicyNoteSegmentInfo policyNoteSegmentInfo) {
		this.policyNoteSegmentInfo = policyNoteSegmentInfo;
	}

	public String toString() {
		return "Note PolicyId = " + super.policyID + " version = " + super.version + " Note [policyNoteSegmentInfo="
				+ policyNoteSegmentInfo.toString() + "NoteNum=" + noteNum + ", sourceCode=" + sourceCode
				+ ", systemSource=" + systemSource + ", redFlag=" + redFlag + ", noteText=" + noteText
				+ ", changeType=" + changeType + ", changeEffectiveDateTime=" + changeEffectiveDateTime + ", handleBy="
				+ handleBy + ", authorID=" + authorID + ", changeEffDate=" + changeEffDate + ", createDate="
				+ createDate + "]\n\n";
	}

	@Root(strict = false)
	protected static class PolicyNoteSegmentInfo {

		@Element(required = false, name = "ChangeNumber")
		protected int changeNum = 0;

		protected String userID;

		@Element(required = false, name = "SegmentEffectiveDate")
		protected Date segmentEffectiveDate = new Date();

		@Element(required = false, name = "SegmentStatus")
		protected String segmentStatus = "1";

		protected int getChangeNum() {
			return changeNum;
		}

		protected void setChangeNum(int changeNum) {
			this.changeNum = changeNum;
		}

		protected Date getSegmentEffectiveDate() {
			return segmentEffectiveDate;
		}

		protected void setSegmentEffectiveDate(Date segmentEffectiveDate) {
			this.segmentEffectiveDate = segmentEffectiveDate;
		}

		protected String getSegmentStatus() {
			return segmentStatus;
		}

		protected void setSegmentStatus(String segmentStatus) {
			this.segmentStatus = segmentStatus;
		}

		@Element(required = false, name = "UserId")
		protected String getUserID() {
			return userID;
		}

		@Element(required = false, name = "UserId")
		protected void setUserID(String userID) {
			if (userID == null) {
				this.userID = "";
			} else if (userID.length() > 6) {
				this.userID = userID.substring(0, 6);
			} else {
				this.userID = userID;
			}
		}

		public String toString() {
			return "\nPolicyNoteSegmentInfo [changeNum=" + changeNum + ", userID=" + userID + ", segmentEffectiveDate="
					+ segmentEffectiveDate + ", segmentStatus=" + segmentStatus + "]\n";
		}

	}

}
