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
public class AddGradesAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    AddGradesDao dao=new AddGradesDao();
    SelectStudentForGradingDao dao1=new SelectStudentForGradingDao();
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
        System.out.println("Inside Add grades action");
        HttpSession hs=request.getSession(true);
        ArrayList std_list=(ArrayList)hs.getAttribute("studentids");
        String[] selection = request.getParameterValues("marks");
        for(int i=0;i<selection.length;i++)
        System.out.println("Selections are "+selection[i]);
         
        String sub_id=String.valueOf(hs.getAttribute("Subject_id_for_grading"));
        System.out.println("Subjects id is "+sub_id);
        System.out.println("ID list"+std_list);
        
        if(sub_id!=null && selection!=null)
        {
            count=dao.addgrades(sub_id,std_list,selection);
        }
        hs.setAttribute("UpdatedMarksCount",count);
        ArrayList userslist=dao1.getStudentslistForGarding(Integer.valueOf(sub_id));
        request.setAttribute("StudentsForGrading",userslist);
        hs.setAttribute("studentids",null);


        return mapping.findForward(SUCCESS);
    }
}
