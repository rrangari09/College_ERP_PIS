/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author RohanShweta
 */
public class ViewSubjectAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS_SUB_LIST = "success_sub_list";
    ViewSubjectDao dao=new ViewSubjectDao();
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
        System.out.println("Inside view Subject action");
        sub_list=dao.viewSubject();
        System.out.println("Subject list"+sub_list);
       // users_list=users_dao.ViewUsersData();
       // System.out.println(users_list);
        request.setAttribute("Subject_List",sub_list);
        
        return mapping.findForward(SUCCESS_SUB_LIST);
    }
}
