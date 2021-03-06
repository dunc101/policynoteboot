
package com.ipacc.services.policy.policynoteservice.v2.generated;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.7
 * 2017-05-02T10:25:11.470-05:00
 * Generated source version: 3.1.7
 */

@WebFault(name = "SaveNotesFaultResponse", targetNamespace = "http://services.ipacc.com/policy/PolicyNoteService/v2")
public class SaveNotesFaultResponseMsg extends Exception {
    
    private com.ipacc.services.policy.policynoteservice.v2.generated.IPACCFaultType saveNotesFaultResponse;

    public SaveNotesFaultResponseMsg() {
        super();
    }
    
    public SaveNotesFaultResponseMsg(String message) {
        super(message);
    }
    
    public SaveNotesFaultResponseMsg(String message, Throwable cause) {
        super(message, cause);
    }

    public SaveNotesFaultResponseMsg(String message, com.ipacc.services.policy.policynoteservice.v2.generated.IPACCFaultType saveNotesFaultResponse) {
        super(message);
        this.saveNotesFaultResponse = saveNotesFaultResponse;
    }

    public SaveNotesFaultResponseMsg(String message, com.ipacc.services.policy.policynoteservice.v2.generated.IPACCFaultType saveNotesFaultResponse, Throwable cause) {
        super(message, cause);
        this.saveNotesFaultResponse = saveNotesFaultResponse;
    }

    public com.ipacc.services.policy.policynoteservice.v2.generated.IPACCFaultType getFaultInfo() {
        return this.saveNotesFaultResponse;
    }
}
