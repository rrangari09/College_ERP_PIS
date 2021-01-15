/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

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
public class LogoutAction extends org.apache.struts.action.Action {

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
        hs.removeAttribute("EmailID");
        hs.removeAttribute("UserID");
        hs.removeAttribute("RoleID");
        hs.removeAttribute("UpdatedMarksCount");
        hs.removeAttribute("studentids");
        hs.removeAttribute("SubjectAdd_status");
        hs.removeAttribute("Enrolled_Sub_Count");
        hs.removeAttribute("generate_notice_status");
        hs.removeAttribute("Subject_id_for_grading");
        hs.removeAttribute("Deleted_Sub_Count");
        hs.invalidate();
        
        return mapping.findForward(SUCCESS);
    }
}
