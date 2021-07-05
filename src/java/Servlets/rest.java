/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Client.FreelancerClient;
import Entity.CityTB;
import Entity.CompanyTB;
import Entity.FreelancerTB;
import Entity.HourlyRateTB;
import Entity.ProjectScopeTB;
import Entity.ReviewTB;
import Entity.SkillTB;
import Entity.WorkPostTB;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author brinda
 */
@DeclareRoles({"Admin","Company","Freelancer"})
@WebServlet(name = "rest", urlPatterns = {"/rest"})
public class rest extends HttpServlet {

    FreelancerClient client;
    Response res;

    Collection<FreelancerTB> freelancers;
    GenericType<Collection<FreelancerTB>> gfreelancers;
    
    Collection<CompanyTB> companys;
    GenericType<Collection<CompanyTB>> gcompanys;
    
    Collection<WorkPostTB> workPosts;
    GenericType<Collection<WorkPostTB>> gworkPosts;
    
    Collection<SkillTB> skills;
    GenericType<Collection<SkillTB>> gskills;
    
    Collection<ReviewTB> reviews;
    GenericType<Collection<ReviewTB>> greviews;
    
    Collection<ProjectScopeTB> projectScopes;
    GenericType<Collection<ProjectScopeTB>> gprojectScopes;
    
     Collection<CityTB> cities;
    GenericType<Collection<CityTB>> gcities;
    
    Collection<HourlyRateTB> hourlyRates;
    GenericType<Collection<HourlyRateTB>> ghourlyRates;
    
     Pbkdf2PasswordHashImpl pb;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet rest</title>");            
            out.println("</head>");
            out.println("<body>");
            
            try
            {
//                String username = request.getSession().getAttribute("username").toString();
//                String password = request.getSession().getAttribute("password").toString();
//                
                String token="";
           
                token = request.getSession().getAttribute("token").toString();
                System.out.println("Servlet token "+token);
        
                client = new FreelancerClient(token);
                
                 pb = new Pbkdf2PasswordHashImpl();
                
                freelancers = new ArrayList<FreelancerTB>();
                gfreelancers = new GenericType<Collection<FreelancerTB>>(){};
                
                companys = new ArrayList<CompanyTB>();
                gcompanys = new GenericType<Collection<CompanyTB>>(){};
                
                workPosts = new ArrayList<WorkPostTB>();
                gworkPosts = new GenericType<Collection<WorkPostTB>>(){};
                
                skills = new ArrayList<SkillTB>();
                gskills = new GenericType<Collection<SkillTB>>(){};
                
                reviews = new ArrayList<ReviewTB>();
                greviews = new GenericType<Collection<ReviewTB>>(){};
                
                projectScopes = new ArrayList<ProjectScopeTB>();
                gprojectScopes = new GenericType<Collection<ProjectScopeTB>>(){};
                
                cities = new ArrayList<CityTB>();
                gcities = new GenericType<Collection<CityTB>>(){};
                
                //Freelancer
                res = client.GetAllFreelancer_XML(Response.class);
                freelancers = res.readEntity(gfreelancers);
                
                hourlyRates =  new ArrayList<HourlyRateTB>();
                ghourlyRates = new GenericType<Collection<HourlyRateTB>>(){};
                
                Date Today= new Date();
                
                Collection<Integer> ids = new ArrayList<Integer>();
                ids.add(4);
                ids.add(3);
                
                
                
                //client.AddSkillFreelancer_JSON(ids, "2001");
                
                //client.UpdateStateWiseCity_JSON(cities, "71", "change", "19");
                //client.AddReview("nbnb", "2002", "3001");
                out.println("<h1>========Freelancer========</h1>");
//                for(FreelancerTB f : freelancers)
//                {
//                    out.println("<div> ID = " + f.getFreelancerID()+ "</div>");
//                    out.println("<div> EMAIL = " + f.getEmail()+ "</div>");
//                    out.println("<div> PASSWORD = " + f.getPassword()+ "</div>");
//                    out.println("<div> COLLEGE =  " + f.getCollege()+ "</div>");
//                    out.println("<div> ABOUT SELF =  " + f.getAboutSelf()+ "</div>");
//                    out.println("<div> IMAGE =  " + f.getProfileImage()+ "</div>");
//                    out.println("<div> WEEKLY AVAILABLE = " + f.getWeeklyAvailable()+ "</div>");
//                    
//                    out.println("<hr>");
//                }
                String Password = pb.generate("abc@123".toCharArray());
                out.println(Password);
                
                //client.AddApplyTb("s", "2001", "4");
                //client.UpdateFreelancer_JSON(freelancers, "2001", "abbbbbb", "abc", "clg", "img.jpg", "self", "3", "1", "1", "1", "1", "1", "1", "1", "0");
                //client.UpdateFreelancer_JSON(freelancers, "2009", "mine@gmail.com", "abc", "clg", "img.jpg", "self", "2 hours", "2", "2", "2", "2", "2", "2", "2","1");
                //client.UpdateCompany_JSON(companys, "", token, token, token, Password, token, token, token, token, token, token);
//                client.UpdateHourlyRate_JSON(hourlyRates, "5", "rs.250/hr");
//                client.AddCompany("name", "oname", "email", Password, "20", "+919428213200", "1", "1", "1", "1.jpg");
               //client.AddFreelancer("email", "pass", "clg", "1.jpg", "self", "6", "2", "2", "2", "2", "2", "2", "0");
              // client.AddFreelancer("d@gmail.com", Password, "abc", "3.jpg", "hhhhh", "5 hours", "3", "2", "4", "2", "3", "3", "2","1");
                //client.UpdateFreelancer_JSON(freelancers, "2009", "mine@gmail.com", Password, "clg", "img.jpg", "self", "2 hours", "2", "2", "2", "2", "2", "2", "2","1");
                
                //client.AddFreelancer("pinal@gmail.com", token, token, token, token, token, token, token, token, token, token, token, token);
                //Company
//                res = client.GetAllCompany_XML(Response.class);
//                companys = res.readEntity(gcompanys);
//                
                out.println("<h1>========Company=========</h1>");
                
//                for(CompanyTB c : companys)
//                {
//                    out.println("<div>ID = "+c.getCompanyID()+" Name  = "+c.getCompanyName()+"</div>");
//                    out.println("<div>OwnerName = "+c.getCompanyOwnerName()+"</div>");
//                    out.println("<div>Email = "+c.getCompanyEmail()+"</div>");
//                    out.println("<div>Contact Number = "+c.getContactNumber()+"</div>");
//                    out.println("<div>Company Staff = "+c.getCompanyStaff()+"</div>");
//                    out.println("<div>IsActive = "+c.getIsActive()+"</div>");
//                    out.println("<div>IsApprove = "+c.getIsApprove()+"</div>");
//                    out.println("<hr>");
//                }


                out.println("<h1>========WorkPostDisplayWithSkills&CompanyDetails=========</h1>");
                   //WorkPost
//                    res = client.GetAllWorkPost_XML(Response.class);
//                    workPosts = res.readEntity(gworkPosts);
//                    
//                    out.println("<h6>========workpost=========</h6>");
//                    for(WorkPostTB w : workPosts)
//                    {
//                        out.println("<div>ID = "+w.getWorkPostID()+"</div>");
//                        out.println("<div>Work Title = "+w.getWorkTitle()+"</div>");
//                        out.println("<div>Description = "+w.getWorkDescription()+"</div>");
//                        out.println("<div>WorkPostDate = "+w.getWorkPostDate()+"</div>");
//                        
//                        out.println("<h6>========skills=========</h6>");
//                        res = client.GetAllWorkPostFreelancerSkill_XML(Response.class, w.getWorkPostID().toString());
//                        skills = res.readEntity(gskills);
//                        for(SkillTB wps : skills)
//                        {
//                            out.println("<div>SkillID = "+wps.getSkillID()+" | Skills = "+ wps.getSkills() + "</div>");
//                        }
//                        
//                        out.println("<h6>========company=========</h6>");
//                        res = client.GetAllCompanyByID_XML(Response.class, w.getWorkPostID().toString());
//                        companys = res.readEntity(gcompanys);
//                        for(CompanyTB c : companys)
//                        {
//                            out.println("<div>ID = "+c.getCompanyID()+" Name  = "+c.getCompanyName()+"</div>");
//                            out.println("<div>OwnerName = "+c.getCompanyOwnerName()+"</div>");
//                            out.println("<div>Email = "+c.getCompanyEmail()+"</div>");
//                            out.println("<div>Contact Number = "+c.getContactNumber()+"</div>");
//                            out.println("<div>Company Staff = "+c.getCompanyStaff()+"</div>");
//                            out.println("<div>IsActive = "+c.getIsActive()+"</div>");
//                            out.println("<div>IsApprove = "+c.getIsApprove()+"</div>");
//                            out.println("<hr>");
//                        }
//                    }
                    
//                out.println("<h1>========FreelancerReview=========</h1>");
//                for(FreelancerTB f : freelancers)
//                {
//                    out.println("<div> ID = " + f.getFreelancerID()+ "</div>");
//                    out.println("<div> EMAIL = " + f.getEmail()+ "</div>");
//                    
//                    
//                    res = client.GetAllReview_XML(Response.class, f.getFreelancerID().toString());
//                    reviews = res.readEntity(greviews);
//                    out.println("<h6>========reviews=========</h6>");
//                    for(ReviewTB review : reviews)
//                    {
//                        out.println("<div> ReviewID = " + review.getReviewID() + " |  Reviews = " + review.getReview() + "</div>");
//                        
//                        
//                        out.println("<h6>========company=========</h6>");
//                        res = client.GetAllReviewByCompanyID_XML(Response.class,review.getReviewID().toString());
//                        companys = res.readEntity(gcompanys);
//                
//                        for(CompanyTB rbc : companys)
//                        {
//                            out.println("<div> Name = " + rbc.getCompanyName()+ " |  Email = " + rbc.getCompanyEmail()+ " | OwnerName = "+ rbc.getCompanyOwnerName()+"</div>");
//                        }
//                    }
//                     out.println("<hr>");  
//                }
                
                   //projectScope
                res = client.GetAllProjectScope_XML(Response.class);
                projectScopes = res.readEntity(gprojectScopes);
                
                out.println("<h1>========ProjectScope========</h1>");
//                for(ProjectScopeTB ps:projectScopes)
//                {
//                    out.println("<div>ProjectScopeID = "+ps.getProjectScopeID()+" |  Scope = "+ ps.getScope() +"</div>");
//                }
                
                //client.AddProjectScope("abc");
                //client.UpdateProjectScope_JSON(projectScopes, "5", "bbb");
                //client.DeleteProjectScope("4");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                out.println("date : " + df.format(Today));
                String datefor = df.format(Today);
                //client.DeleteWorkPost("3", "1", "1", "1", "1", "1", "3001");
                //client.UpdateWorkPost_JSON(workPosts, "3","title", "desc", datefor, "1", "1", "1", "1", "1", "3001");
               //client.AddWorkPost("title", "desc", datefor, "1", "1", "1", "1", "1", "3001");
            }catch(Exception e)
            {
                out.println("<h1>Error : "+e.getMessage()+"</h1>");
            }
            
            out.println("<h1>Servlet rest at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
