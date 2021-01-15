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
public class SelectStudentForGradingAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    
    SelectStudentForGradingDao dao=new SelectStudentForGradingDao();

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
        String[] selection = request.getParameterValues("subjects_for_grades");
        System.out.println("Inside grading Action");
        System.out.println("Selections are "+selection[0]);
        ArrayList userslist=new ArrayList();
        userslist=dao.getStudentslistForGarding(Integer.valueOf(selection[0]));
        hs.setAttribute("Subject_id_for_grading",selection[0]);
        System.out.println("Userslist "+userslist);
        request.setAttribute("StudentsForGrading",userslist);
        return mapping.findForward(SUCCESS);
    }
}
