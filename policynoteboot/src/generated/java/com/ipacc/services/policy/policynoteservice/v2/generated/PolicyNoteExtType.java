
package com.ipacc.services.policy.policynoteservice.v2.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PolicyNoteExtType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PolicyNoteExtType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://services.ipacc.com/policy/PolicyNoteService/v2}PolicyNoteType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CompanyID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="RequestName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="Processor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="PolicyState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="NoteTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="OriginInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PolicyNoteExtType", propOrder = {
    "companyID",
    "requestName",
    "processor",
    "policyState",
    "noteTypeCode",
    "originInd"
})
public class PolicyNoteExtType
    extends PolicyNoteType
{

    @XmlElement(name = "CompanyID")
    protected String companyID;
    @XmlElement(name = "RequestName")
    protected String requestName;
    @XmlElement(name = "Processor")
    protected String processor;
    @XmlElement(name = "PolicyState")
    protected String policyState;
    @XmlElement(name = "NoteTypeCode")
    protected String noteTypeCode;
    @XmlElement(name = "OriginInd")
    protected String originInd;

    /**
     * Gets the value of the companyID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyID() {
        return companyID;
    }

    /**
     * Sets the value of the companyID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyID(String value) {
        this.companyID = value;
    }

    /**
     * Gets the value of the requestName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestName() {
        return requestName;
    }

    /**
     * Sets the value of the requestName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestName(String value) {
        this.requestName = value;
    }

    /**
     * Gets the value of the processor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessor() {
        return processor;
    }

    /**
     * Sets the value of the processor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessor(String value) {
        this.processor = value;
    }

    /**
     * Gets the value of the policyState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyState() {
        return policyState;
    }

    /**
     * Sets the value of the policyState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyState(String value) {
        this.policyState = value;
    }

    /**
     * Gets the value of the noteTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoteTypeCode() {
        return noteTypeCode;
    }

    /**
     * Sets the value of the noteTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoteTypeCode(String value) {
        this.noteTypeCode = value;
    }

    /**
     * Gets the value of the originInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginInd() {
        return originInd;
    }

    /**
     * Sets the value of the originInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginInd(String value) {
        this.originInd = value;
    }

}
