
package com.ipacc.services.policy.policynoteservice.v2.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PolicyNoteType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PolicyNoteType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PolicyNoteSegmentInfo" type="{http://services.ipacc.com/policy/PolicyNoteService/v2}SegmentInfoType" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="NoteNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="CreatedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="CreatedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="SourceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="SystemSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="RedFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="NoteText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="ChangeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="ChangeEffectiveDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="ActivityID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="HandledBy" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="AuthorID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PolicyNoteType", propOrder = {
    "policyNoteSegmentInfo",
    "noteNumber",
    "createdDate",
    "createdBy",
    "sourceCode",
    "systemSource",
    "redFlag",
    "noteText",
    "changeType",
    "changeEffectiveDateTime",
    "activityID",
    "handledBy",
    "authorID"
})
@XmlSeeAlso({
    PolicyNoteExtType.class,
    TGPolicyNoteType.class
})
public class PolicyNoteType {

    @XmlElement(name = "PolicyNoteSegmentInfo")
    protected SegmentInfoType policyNoteSegmentInfo;
    @XmlElement(name = "NoteNumber")
    protected Integer noteNumber;
    @XmlElement(name = "CreatedDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDate;
    @XmlElement(name = "CreatedBy")
    protected String createdBy;
    @XmlElement(name = "SourceCode")
    protected String sourceCode;
    @XmlElement(name = "SystemSource")
    protected String systemSource;
    @XmlElement(name = "RedFlag")
    protected Boolean redFlag;
    @XmlElement(name = "NoteText")
    protected String noteText;
    @XmlElement(name = "ChangeType")
    protected String changeType;
    @XmlElement(name = "ChangeEffectiveDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar changeEffectiveDateTime;
    @XmlElement(name = "ActivityID")
    protected String activityID;
    @XmlElement(name = "HandledBy")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar handledBy;
    @XmlElement(name = "AuthorID")
    protected String authorID;

    /**
     * Gets the value of the policyNoteSegmentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SegmentInfoType }
     *     
     */
    public SegmentInfoType getPolicyNoteSegmentInfo() {
        return policyNoteSegmentInfo;
    }

    /**
     * Sets the value of the policyNoteSegmentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SegmentInfoType }
     *     
     */
    public void setPolicyNoteSegmentInfo(SegmentInfoType value) {
        this.policyNoteSegmentInfo = value;
    }

    /**
     * Gets the value of the noteNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNoteNumber() {
        return noteNumber;
    }

    /**
     * Sets the value of the noteNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNoteNumber(Integer value) {
        this.noteNumber = value;
    }

    /**
     * Gets the value of the createdDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the value of the createdDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedDate(XMLGregorianCalendar value) {
        this.createdDate = value;
    }

    /**
     * Gets the value of the createdBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the value of the createdBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedBy(String value) {
        this.createdBy = value;
    }

    /**
     * Gets the value of the sourceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceCode() {
        return sourceCode;
    }

    /**
     * Sets the value of the sourceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceCode(String value) {
        this.sourceCode = value;
    }

    /**
     * Gets the value of the systemSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemSource() {
        return systemSource;
    }

    /**
     * Sets the value of the systemSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemSource(String value) {
        this.systemSource = value;
    }

    /**
     * Gets the value of the redFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRedFlag() {
        return redFlag;
    }

    /**
     * Sets the value of the redFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRedFlag(Boolean value) {
        this.redFlag = value;
    }

    /**
     * Gets the value of the noteText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoteText() {
        return noteText;
    }

    /**
     * Sets the value of the noteText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoteText(String value) {
        this.noteText = value;
    }

    /**
     * Gets the value of the changeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeType() {
        return changeType;
    }

    /**
     * Sets the value of the changeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeType(String value) {
        this.changeType = value;
    }

    /**
     * Gets the value of the changeEffectiveDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getChangeEffectiveDateTime() {
        return changeEffectiveDateTime;
    }

    /**
     * Sets the value of the changeEffectiveDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setChangeEffectiveDateTime(XMLGregorianCalendar value) {
        this.changeEffectiveDateTime = value;
    }

    /**
     * Gets the value of the activityID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityID() {
        return activityID;
    }

    /**
     * Sets the value of the activityID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityID(String value) {
        this.activityID = value;
    }

    /**
     * Gets the value of the handledBy property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getHandledBy() {
        return handledBy;
    }

    /**
     * Sets the value of the handledBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setHandledBy(XMLGregorianCalendar value) {
        this.handledBy = value;
    }

    /**
     * Gets the value of the authorID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorID() {
        return authorID;
    }

    /**
     * Sets the value of the authorID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorID(String value) {
        this.authorID = value;
    }

}
