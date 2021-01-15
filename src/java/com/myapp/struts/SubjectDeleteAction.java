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
public class SubjectDeleteAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    int count=0;
    DeleteSubDao dao=new DeleteSubDao();
    ViewSubjectDao dao1=new ViewSubjectDao();
    ViewUserDao  users_dao=new ViewUserDao();
    ArrayList sub_list=null;

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
        System.err.println("Inside Delete Action");
        HttpSession hs=request.getSession(true);
        String[] selections = request.getParameterValues("subjects");
        if(selections != null)
        {
        System.out.println("Selected subject are"+selections);
        ArrayList subject_to_delete=new ArrayList<String>();
        Collections.addAll(subject_to_delete,selections);
        count=dao.deletesubject(subject_to_delete);
        sub_list=dao1.viewSubject();
        request.setAttribute("Subject_List",sub_list);
        hs.setAttribute("Deleted_Sub_Count",count);
       }
        else{
        sub_list=dao1.viewSubject();
        request.setAttribute("Subject_List",sub_list);
        System.err.println("Inside Else of Delete Subject");    
        hs.setAttribute("Deleted_Sub_Count",0);
        }
        return mapping.findForward(SUCCESS);
    }
}
