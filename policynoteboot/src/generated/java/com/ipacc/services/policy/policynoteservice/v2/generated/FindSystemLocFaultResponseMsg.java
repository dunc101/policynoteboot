
package com.ipacc.services.policy.policynoteservice.v2.generated;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.7
 * 2017-05-02T10:25:11.562-05:00
 * Generated source version: 3.1.7
 */

@WebFault(name = "FindSystemLocFaultResponse", targetNamespace = "http://services.ipacc.com/policy/PolicyNoteService/v2")
public class FindSystemLocFaultResponseMsg extends Exception {
    
    private com.ipacc.services.policy.policynoteservice.v2.generated.IPACCFaultType findSystemLocFaultResponse;

    public FindSystemLocFaultResponseMsg() {
        super();
    }
    
    public FindSystemLocFaultResponseMsg(String message) {
        super(message);
    }
    
    public FindSystemLocFaultResponseMsg(String message, Throwable cause) {
        super(message, cause);
    }

    public FindSystemLocFaultResponseMsg(String message, com.ipacc.services.policy.policynoteservice.v2.generated.IPACCFaultType findSystemLocFaultResponse) {
        super(message);
        this.findSystemLocFaultResponse = findSystemLocFaultResponse;
    }

    public FindSystemLocFaultResponseMsg(String message, com.ipacc.services.policy.policynoteservice.v2.generated.IPACCFaultType findSystemLocFaultResponse, Throwable cause) {
        super(message, cause);
        this.findSystemLocFaultResponse = findSystemLocFaultResponse;
    }

    public com.ipacc.services.policy.policynoteservice.v2.generated.IPACCFaultType getFaultInfo() {
        return this.findSystemLocFaultResponse;
    }
}
