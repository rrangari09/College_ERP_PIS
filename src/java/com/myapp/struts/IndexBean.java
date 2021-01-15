/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author RohanShweta
 */
public class IndexBean extends org.apache.struts.action.ActionForm {
    
    private String emailid,password;

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    /**
     *
     */
    public IndexBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getEmailid() == null || getEmailid().length() < 1) {
            errors.add("emailid", new ActionMessage("error.emailid.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        if (getPassword() == null || getPassword().length() < 1) {
            errors.add("password", new ActionMessage("error.password.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
         setEmailid("");
         setPassword("");
         super.reset(mapping, request); //To change body of generated methods, choose Tools | Templates.
    }
    
}
