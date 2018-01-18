
package com.ipacc.services.policy.policynoteservice.v2.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GeneralErrorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeneralErrorType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ErrorSource" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ErrorNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ErrorType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="StackTrace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeneralErrorType", propOrder = {
    "errorSource",
    "errorNumber",
    "errorCode",
    "errorMessage",
    "errorType",
    "stackTrace"
})
public class GeneralErrorType {

    @XmlElement(name = "ErrorSource", namespace = "http://services.ipacc.com/policy/PolicyNoteService/v2", required = true)
    protected String errorSource;
    @XmlElement(name = "ErrorNumber", namespace = "http://services.ipacc.com/policy/PolicyNoteService/v2")
    protected int errorNumber;
    @XmlElement(name = "ErrorCode", namespace = "http://services.ipacc.com/policy/PolicyNoteService/v2", required = true)
    protected String errorCode;
    @XmlElement(name = "ErrorMessage", namespace = "http://services.ipacc.com/policy/PolicyNoteService/v2", required = true)
    protected String errorMessage;
    @XmlElement(name = "ErrorType", namespace = "http://services.ipacc.com/policy/PolicyNoteService/v2", required = true)
    protected String errorType;
    @XmlElement(name = "StackTrace", namespace = "http://services.ipacc.com/policy/PolicyNoteService/v2")
    protected String stackTrace;

    /**
     * Gets the value of the errorSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorSource() {
        return errorSource;
    }

    /**
     * Sets the value of the errorSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorSource(String value) {
        this.errorSource = value;
    }

    /**
     * Gets the value of the errorNumber property.
     * 
     */
    public int getErrorNumber() {
        return errorNumber;
    }

    /**
     * Sets the value of the errorNumber property.
     * 
     */
    public void setErrorNumber(int value) {
        this.errorNumber = value;
    }

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the errorType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorType() {
        return errorType;
    }

    /**
     * Sets the value of the errorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorType(String value) {
        this.errorType = value;
    }

    /**
     * Gets the value of the stackTrace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStackTrace() {
        return stackTrace;
    }

    /**
     * Sets the value of the stackTrace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStackTrace(String value) {
        this.stackTrace = value;
    }

}
