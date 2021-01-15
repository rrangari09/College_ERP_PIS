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
public class AddSubjectBean extends org.apache.struts.action.ActionForm {
    
    private String sub_name,sub_branch,sub_level;
    private int sub_cred,sub_taught;

    public int getSub_taught() {
        return sub_taught;
    }

    public void setSub_taught(int sub_taught) {
        this.sub_taught = sub_taught;
    }

    public float getSub_marks() {
        return sub_marks;
    }

    public void setSub_marks(float sub_marks) {
        this.sub_marks = sub_marks;
    }
    private float sub_marks;
    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public String getSub_branch() {
        return sub_branch;
    }

    public void setSub_branch(String sub_branch) {
        this.sub_branch = sub_branch;
    }

    public String getSub_level() {
        return sub_level;
    }

    public void setSub_level(String sub_level) {
        this.sub_level = sub_level;
    }

    public int getSub_cred() {
        return sub_cred;
    }

    public void setSub_cred(int sub_cred) {
        this.sub_cred = sub_cred;
    }

    /**
     * @return
     */
    
    /**
     *
     */
    public AddSubjectBean() {
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
    /*public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        //if (getName() == null || getName().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }*/
}
