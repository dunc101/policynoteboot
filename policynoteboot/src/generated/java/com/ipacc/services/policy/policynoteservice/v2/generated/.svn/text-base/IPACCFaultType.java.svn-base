
package com.ipacc.services.policy.policynoteservice.v2.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IPACCFaultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IPACCFaultType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IPACCErrors" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="IPACCError" type="{http://services.ipacc.com/policy/PolicyNoteService/v2}GeneralErrorType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IPACCFaultType", propOrder = {
    "message",
    "ipaccErrors"
})
public class IPACCFaultType {

    @XmlElement(name = "Message", namespace = "http://services.ipacc.com/policy/PolicyNoteService/v2")
    protected String message;
    @XmlElement(name = "IPACCErrors", namespace = "http://services.ipacc.com/policy/PolicyNoteService/v2")
    protected IPACCFaultType.IPACCErrors ipaccErrors;

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the ipaccErrors property.
     * 
     * @return
     *     possible object is
     *     {@link IPACCFaultType.IPACCErrors }
     *     
     */
    public IPACCFaultType.IPACCErrors getIPACCErrors() {
        return ipaccErrors;
    }

    /**
     * Sets the value of the ipaccErrors property.
     * 
     * @param value
     *     allowed object is
     *     {@link IPACCFaultType.IPACCErrors }
     *     
     */
    public void setIPACCErrors(IPACCFaultType.IPACCErrors value) {
        this.ipaccErrors = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="IPACCError" type="{http://services.ipacc.com/policy/PolicyNoteService/v2}GeneralErrorType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ipaccError"
    })
    public static class IPACCErrors {

        @XmlElement(name = "IPACCError", namespace = "http://services.ipacc.com/policy/PolicyNoteService/v2")
        protected List<GeneralErrorType> ipaccError;

        /**
         * Gets the value of the ipaccError property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ipaccError property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIPACCError().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GeneralErrorType }
         * 
         * 
         */
        public List<GeneralErrorType> getIPACCError() {
            if (ipaccError == null) {
                ipaccError = new ArrayList<GeneralErrorType>();
            }
            return this.ipaccError;
        }

    }

}
