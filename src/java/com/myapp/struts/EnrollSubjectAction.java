/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import java.util.ArrayList;
import java.util.Collections;
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
public class EnrollSubjectAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    EnrollSubjectsDao dao=new EnrollSubjectsDao();
    ArrayList available_sub=null;

    int count=0;

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
        int userid=Integer.valueOf(String.valueOf(hs.getAttribute("UserID")));
        String[] selections = request.getParameterValues("subjects_to_enroll");
        if(selections !=null){
        System.out.println("Selected subject are"+selections);
        ArrayList subject_enroll=new ArrayList<Integer>();
        Collections.addAll(subject_enroll,selections);
        count=dao.enroll_subjects(subject_enroll, userid);
        hs.setAttribute("Enrolled_Sub_Count",count);
        available_sub=dao.subjects_available(String.valueOf(userid));
        System.out.println("Availble Subject list"+available_sub);
        request.setAttribute("AvailableSubList",available_sub);
        }
        else{
        hs.setAttribute("Enrolled_Sub_Count",count);
        available_sub=dao.subjects_available(String.valueOf(userid));
        System.out.println("Availble Subject list"+available_sub);
        request.setAttribute("AvailableSubList",available_sub); 
        }

       
  
        return mapping.findForward(SUCCESS);
    }
}
