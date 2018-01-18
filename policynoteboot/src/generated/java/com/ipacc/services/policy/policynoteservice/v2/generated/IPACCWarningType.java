
package com.ipacc.services.policy.policynoteservice.v2.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IPACCWarningType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IPACCWarningType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IPACCWarnings" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="IPACCWarning" type="{http://services.ipacc.com/policy/PolicyNoteService/v2}GeneralWarningType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "IPACCWarningType", propOrder = {
    "message",
    "ipaccWarnings"
})
public class IPACCWarningType {

    @XmlElement(name = "Message", namespace = "http://services.ipacc.com/policy/PolicyNoteService/v2")
    protected String message;
    @XmlElement(name = "IPACCWarnings", namespace = "http://services.ipacc.com/policy/PolicyNoteService/v2")
    protected IPACCWarningType.IPACCWarnings ipaccWarnings;

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
     * Gets the value of the ipaccWarnings property.
     * 
     * @return
     *     possible object is
     *     {@link IPACCWarningType.IPACCWarnings }
     *     
     */
    public IPACCWarningType.IPACCWarnings getIPACCWarnings() {
        return ipaccWarnings;
    }

    /**
     * Sets the value of the ipaccWarnings property.
     * 
     * @param value
     *     allowed object is
     *     {@link IPACCWarningType.IPACCWarnings }
     *     
     */
    public void setIPACCWarnings(IPACCWarningType.IPACCWarnings value) {
        this.ipaccWarnings = value;
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
     *         &lt;element name="IPACCWarning" type="{http://services.ipacc.com/policy/PolicyNoteService/v2}GeneralWarningType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "ipaccWarning"
    })
    public static class IPACCWarnings {

        @XmlElement(name = "IPACCWarning", namespace = "http://services.ipacc.com/policy/PolicyNoteService/v2")
        protected List<GeneralWarningType> ipaccWarning;

        /**
         * Gets the value of the ipaccWarning property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ipaccWarning property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIPACCWarning().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GeneralWarningType }
         * 
         * 
         */
        public List<GeneralWarningType> getIPACCWarning() {
            if (ipaccWarning == null) {
                ipaccWarning = new ArrayList<GeneralWarningType>();
            }
            return this.ipaccWarning;
        }

    }

}
