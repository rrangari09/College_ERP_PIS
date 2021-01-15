/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author RohanShweta
 */
public class AddSubjectAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession hs=request.getSession(true);
        System.err.println("Inside Subject Action");
        AddSubjectBean obj =(AddSubjectBean)form;
        AddSubjectDao dao=new AddSubjectDao();
        int result;
        ArrayList Subjectlist=new ArrayList<>();
        Subjectlist.add(obj.getSub_name());
        Subjectlist.add(obj.getSub_cred());
        Subjectlist.add(obj.getSub_branch());
        Subjectlist.add(obj.getSub_level());
        Subjectlist.add(obj.getSub_marks());
        Subjectlist.add(obj.getSub_taught());
        result=dao.addSubject(Subjectlist);
        if(result>0){
        hs.setAttribute("SubjectAdd_status","true");
        }
        else
        {
                hs.setAttribute("SubjectAdd_status","false");   
        } 
        return mapping.findForward(SUCCESS);
    }
}
