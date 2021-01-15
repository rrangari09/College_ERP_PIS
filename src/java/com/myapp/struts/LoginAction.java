/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import java.util.ArrayList;
import java.util.HashMap;
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
public class LoginAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String ADMIN = "admin";
    private static final String STUDENT = "student";
    private static final String FACULTY = "faculty";

    private static final String FAILURE = "failure";

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
        IndexBean obj =(IndexBean)form;
        System.out.println(obj.getEmailid());
        System.out.println(obj.getPassword());
        hs.setAttribute("EmailID",obj.getEmailid());   
        HashMap<String,String> loginMap;
        LoginDao dao=new LoginDao();
        loginMap=dao.getLoginDetails(obj.getEmailid());
        if(loginMap.isEmpty()){
          return mapping.findForward(FAILURE);
        }
        hs.setAttribute("UserID",loginMap.get("User_ID"));
        hs.setAttribute("RoleID",loginMap.get("role"));
        
         ViewNoticeDao dao1=new ViewNoticeDao();
        ArrayList noticeList=dao1.getNoticeDetails(Integer.valueOf(loginMap.get("role")));
        
        request.setAttribute("Notices",noticeList);

        if((loginMap.get("email").equals(obj.getEmailid())) && (loginMap.get("password").equals(obj.getPassword())) && (loginMap.get("role").equals("1")))
           return mapping.findForward(ADMIN);
        else  if((loginMap.get("email").equals(obj.getEmailid())) && (loginMap.get("password").equals(obj.getPassword())) && (loginMap.get("role").equals("2")))
           return mapping.findForward(FACULTY);
        else  if((loginMap.get("email").equals(obj.getEmailid())) && (loginMap.get("password").equals(obj.getPassword())) && (loginMap.get("role").equals("3")))
           return mapping.findForward(STUDENT);
            
            return mapping.findForward(FAILURE);
    }
}
