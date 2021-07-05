/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entity.*;
import ejb.FreelancerPortalBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author brinda
 */
public class ejb extends HttpServlet {

     @EJB FreelancerPortalBeanLocal fp;
     Pbkdf2PasswordHashImpl pb;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ejb</title>");            
            out.println("</head>");
            out.println("<body>");
            
            pb = new Pbkdf2PasswordHashImpl();
            
            //fp.AdminChangePassword(3, "123");
            
            //fp.UpdateStateWiseCity(68, "chs", 9);
            
            //fp.ChangeStatusCompany(1, 0);
            //fp.AddApplyTb("Applied", 2001, 5);
             out.println("<h1>Freelancer</h1>");
                Collection<FreelancerTB> freelancers = fp.SerachByHourlyRate("300", "900");
                for(FreelancerTB f : freelancers)
                {
                    out.println("<div> ID = " + f.getFreelancerID()+ "</div>");
                    out.println("<div> EMAIL = " + f.getEmail()+ "</div>");
                    out.println("<div> PASSWORD = " + f.getPassword()+ "</div>");
                    out.println("<div> COLLEGE =  " + f.getCollege()+ "</div>");
                    out.println("<div> ABOUT SELF =  " + f.getAboutSelf()+ "</div>");
                    out.println("<div> IMAGE =  " + f.getProfileImage()+ "</div>");
                    out.println("<div> WEEKLY AVAILABLE = " + f.getWeeklyAvailable()+ "</div>");
//                    out.println("<div> CATEGORY ID = " + f.getCategoryID()+ "</div>");
//                    out.println("<div> CITY ID =  " + f.getCityID()+ "</div>");
//                    out.println("<div> DEGREE ID =  " + f.getDegreeID()+ "</div>");
//                    out.println("<div> ENGLISH LEVEL ID =  " + f.getEnglishLevelID()+ "</div>");
//                    out.println("<div> EXPERTIXE LEVEL ID =  " + f.getExpertizeLevelID()+ "</div>");
//                    out.println("<div> HOURLY RATE ID =  " + f.getHourlyRateID()+ "</div>");
//                    out.println("<div> SKILL ID =  " + f.getSkillID()+ "</div>");
//                    out.println("<div> STATE ID =  " + f.getStateID()+ "</div>");

//                    Collection<CertificateTB> certificates = fp.GetAllCertificate(f.getFreelancerID());
//                    for(CertificateTB cer : certificates)
//                    {
//                        out.println("<h3> ID = " + cer.getCertificateID()+ " |  Files = " + cer.getCertificateFile()+ "</h3>");
//                        
//                        
//                    }

//                    Collection<PaymentTB> payments = fp.GetAllPayment(f.getFreelancerID());
//                    for(PaymentTB payment : payments)
//                    {
//                        out.println("<h3> ID = " + payment.getPaymentID()+ " |  Amount = " + payment.getTotalAmount()+ "</h3>");
//                        
//                    }

                       
//                    Collection<SkillTB> skills = fp.GetAllSkillFreelancer(f.getFreelancerID());
//                    for(SkillTB sf : skills)
//                    {
//                        out.println("<h3> ID = " + sf.getSkillID()+ " |  Skills = " + sf.getSkills()+ "</h3>");
//                        
//                    }

//                      Collection<ReviewTB> reviews = fp.GetAllReview(f.getFreelancerID());
//                      for(ReviewTB review : reviews)
//                      {
//                          out.println("<h3> ReviewID = " + review.getReviewID() + " |  Reviews = " + review.getReview() + "</h3>");
//                          
//                          Collection<CompanyTB> reviewByCompanyID = fp.GetAllReviewByCompanyID(review.getReviewID());
//                          for(CompanyTB rbc : reviewByCompanyID)
//                          {
//                              out.println("<h3> Name = " + rbc.getCompanyName()+ " |  Email = " + rbc.getCompanyEmail()+ " | OwnerName = "+ rbc.getCompanyOwnerName()+"</h3>");
//                          }
//                      }
                    out.println("<hr>");
                    
                }
                
                
                String Password = pb.generate("admin".toCharArray());
                out.println("<h1>"+Password+"</h1>");
            
                //fp.AddFreelancer("pinal@gmail.com", Password, "college", "image", "about", "4 hours", 1, 1, 1, 1, 1, 1, 1);
            //fp.AddLoginDetails("pinal@gmail.com", Password, 2001);
            //Collection<Integer> ids = new ArrayList<Integer>();
              //  ids.add(3);
////                ids.add(2);
            //fp.AddLoginRole(3, ids);
                 //Add freelancer
                    //fp.AddFreelancer("abc@gmail.com", "123", "vnsgu", "2.jpg", "i am good person", "4 hour", 1, 1, 1, 1, 1, 1, 1);
                    //Delete
                    //fp.DeleteFreelancer(6, 1, 1, 1, 1, 1, 1, 1);
                    //Update
                   // fp.UpdateFreelancer(2009, "xyz@gmail.com", "xyz", "university", "5.jpg", "uejfjfn", "5 hours", 2, 2, 2, 2, 2, 2, 2,1);
                        
                    
                    //Add Review
                    //fp.AddReview("Please Work Faster", 3, 1);
                    //update
                    //fp.UpdateReview(1, "updated", 3, 1);
                    //delete
                    //fp.DeleteReview(1, 3, 1);
                    
//                Collection<Integer> ids = new ArrayList<Integer>();
//                ids.add(1);
//                ids.add(2);
//                fp.AddSkillFreelancer(3, ids);
                //fp.DeleteSkillFreelancer(3, ids);
                
//                <certificate>
                //Add
                //fp.AddCertificate("C_Cer.pdf", 3);
                //Update
                //fp.UpdateCertificate(2, "C_Certificate.pdf", 3);
                //Delete
                //fp.DeleteCertificate(2, 3);
                
//                <Payment>
                  //Add
                  //fp.AddPayment("Rs.3000/-", 3);
                
                out.println("<hr>");
                out.println("<h1>Company</h1>");
//                Collection<CompanyTB> companys = fp.GetAllCompany();
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
                
                //Add
                //fp.AddCompany("abc", "Mr.Batra", "infosys@gmail.com", "123", 500, "+91 9428213200", 1, 1, 1, 1);
                //update
                //fp.UpdateCompany(4, "Wipro", "Mr.Rahul Patel", "wipro@gmail.com", "123", 250, "+91 9562415236", 1, 1, 3, 6);


                out.println("<hr>");
                Collection<BiddingTB> biddingTBs = fp.GetAllBiddingByWorkPostID(5);
                for(BiddingTB b:biddingTBs)
                {
                    out.println("<div>ID = "+b.getFreelancerID().getEmail()+"</div>");
                }
                out.println("<h1>WorkPost</h1>");
                Collection<WorkPostTB> workPosts = fp.SerachByHourlyRateFromWorkPost("300", "800");
                for(WorkPostTB w : workPosts)
                {
                    out.println("<div>ID = "+w.getWorkPostID()+"</div>");
                    out.println("<div>Work Title = "+w.getWorkTitle()+"</div>");
                    out.println("<div>Description = "+w.getWorkDescription()+"</div>");
                    out.println("<div>WorkPostDate = "+w.getHourlyRateID().getRate()+"</div>");
                    out.println("<div>copname = "+w.getCompanyID().getCompanyName()+"</div>");
//                    out.println("<div>EnglishLevel = "+w.getEnglishLevelID()+"</div>");
//                    out.println("<div>ExpertizeLevel = "+w.getExpertizeLevelID()+"</div>");
//                    out.println("<div>HourlyRate = "+w.getHourlyRateID()+"</div>");
//                    out.println("<div>ProjectScope = "+w.getProjectScopeID()+"</div>");
//                    out.println("<div>Skill = "+w.getSkillID()+"</div>");
//                    out.println("<div>Category = "+w.getCategoryID()+"</div>");
//                    out.println("<div>Company = "+w.getCompanyID()+"</div>");

                    out.println("<h6>company-details</h6>");
                    Collection<CompanyTB> companys = fp.GetAllCompanyByID(w.getWorkPostID());
                    for(CompanyTB c : companys)
                    {
                        out.println("<div>ID = "+c.getCompanyID()+" Name  = "+c.getCompanyName()+"</div>");
                    out.println("<div>OwnerName = "+c.getCompanyOwnerName()+"</div>");
                    out.println("<div>Email = "+c.getCompanyEmail()+"</div>");
                    out.println("<div>Contact Number = "+c.getContactNumber()+"</div>");
                    out.println("<div>Company Staff = "+c.getCompanyStaff()+"</div>");
                    out.println("<div>IsActive = "+c.getIsActive()+"</div>");
//                    out.println("<div>IsApprove = "+c.getIsApprove()+"</div>");
                    }
                    out.println("<h6>skill-details</h6>");
                    Collection<SkillTB> WorkPostskills = fp.GetAllWorkPostFreelancerSkill(w.getWorkPostID());
                    for(SkillTB wps : WorkPostskills)
                    {
                        out.println("<div>SkillID = "+wps.getSkillID()+" | Skills = "+ wps.getSkills() + "</div>");
                    }
                      out.println("<hr>");
                }
                Date workPostDate= new Date();
                //Add
                //fp.AddWorkPost("FullStack", "We need MEAN Stack Developer", workPostDate, 1, 1, 1, 1, 1, 3001);
                //Update
                //fp.UpdateWorkPost(2, "MEAN Stack", "Good Developer", workPostDate, 2, 2, 2, 2, 2, 2);
                //Delete
                //fp.DeleteWorkPost(3, 1, 1, 1, 1, 1, 1);
                
                //Add WorkPostSkills
                Collection<Integer> ids = new ArrayList<Integer>();
                ids.add(2);
                //ids.add(4);
                //fp.AddWorkPostFreelancerSkill(2, ids);
                //Delete
                //fp.DeleteWorkPostFreelancerSkill(2, ids);
                
                
                out.println("<hr>");
                out.println("<h1>State</h1>");
//                Collection<StateTB> states = fp.GetAllState();
//                for(StateTB state : states)
//                {
//                    out.println("<div>StateID = "+state.getStateID()+"| StateName = "+state.getStateName()+" </div>");
//                    //out.println("<div>StateName = "+state.getStateName()+"</div>");
//                        Collection<CityTB> cities = fp.GetAllStateWiseCity(state.getStateID());
//                        for(CityTB city : cities)
//                        {
//                            out.println("<div>CityID = "+city.getCityID()+" | CityName = "+city.getCityName()+"</div>");
//                            //out.println("<div>CityName = "+city.getCityName()+"</div>");
//                           // out.println("<div>ID = "+city.getStateID()+"</div>");
//                        }
//                        out.println("<hr>");
//                }
                
                //Add State
                //fp.AddState("abc");
                //Update State
                //fp.UpdateState(20, "xyz");
                //Delete State
                //fp.DeleteState(21);
                
                //Add City
                //fp.AddStateWiseCity("yyy", 20);
                //Update City
                //fp.UpdateStateWiseCity(69, "bbb", 20);
                //Delete City
                //fp.DeleteStateWiseCity(68, 20);
                
//                <ProjectScopeTB>
                  out.println("<hr>");
                  out.println("<h1>projectScope</h1>");
//                  Collection<ProjectScopeTB> projectScopes = fp.GetAllProjectScope();
//                  for(ProjectScopeTB ps : projectScopes)
//                  {
//                      out.println("<div>ProjectScopeID = "+ps.getProjectScopeID()+" |  Scope = "+ ps.getScope() +"</div>");
//                  }
                  
                  //Add
                  //fp.AddProjectScope("abc");
                  //Update
                  //fp.UpdateProjectScope(4, "xyz");
                  //Delete
                  //fp.DeleteProjectScope(4);
                  
//                  <ExpertizeLevelTB>
                  out.println("<hr>");
                  out.println("<h1>ExpertizeLevel</h1>");
//                  Collection<ExpertizeLevelTB> expertizeLevels = fp.GetAllExpertizeLevel();
//                  for(ExpertizeLevelTB el : expertizeLevels)
//                  {
//                      out.println("<div>ExpertizeLevelID = "+el.getExpertizeLevelID()+" |  Level = "+ el.getLevels()+"</div>");
//                  }
//                  
                  //Add
                  //fp.AddExpertizeLevel("abc");
                  //Update
                  //fp.UpdateExpertizeLevel(4, "xyz");
                  //Delete
                  //fp.DeleteExpertizeLevel(4);
               
//                  <ExpertizeLevelTB>
                  out.println("<hr>");
                  out.println("<h1>HourlyRate</h1>");
//                  Collection<HourlyRateTB> hourlyRates = fp.GetAllHourlyRate();
//                  for(HourlyRateTB hr : hourlyRates)
//                  {
//                      out.println("<div>HourlyRateID = "+hr.getHourlyRateID()+" |  Rate = "+ hr.getRate()+"</div>");
//                  }
                  
                  //Add
                  //fp.AddHourlyRate("Rs.250/hr");
                  //Update
                  //fp.UpdateHourlyRate(3, "Rs.100/hr");
                  //Delete
                  //fp.DeleteHourlyRate(3);
               
//                    <EnglsihLevelTB>
                  out.println("<hr>");
                  out.println("<h1>EnglsihLevel</h1>");
//                  Collection<EnglsihLevelTB> englsihLevels = fp.GetAllEnglishLevel();
//                  for(EnglsihLevelTB eng : englsihLevels)
//                  {
//                      out.println("<div>EnglishLevelID = "+eng.getEnglishLevelID()+" |  EnglishLevel = "+ eng.getEnglishLevels()+"</div>");
//                  }
                  
                  //Add
                  //fp.AddEnglsihLevel("good");
                  //Update
                  //fp.UpdateEnglsihLevel(5, "very good");
                  //Delete
                  //fp.DeleteEnglsihLevel(5);
                  
               
//                    <DegreeTB>
                  out.println("<hr>");
                  out.println("<h1>Degree</h1>");
//                  Collection<DegreeTB> degrees = fp.GetAllDegree();
//                  for(DegreeTB degree : degrees)
//                  {
//                      out.println("<div>DegreeID = "+degree.getDegreeID()+" |  Degree = "+ degree.getDegree()+"</div>");
//                  }
                  
                  //Add
                  //fp.AddDegree("BE");
                  //Update
                  //fp.UpdateDegree(6, "ME");
                  //Delete
                  //fp.DeleteDegree(6);
                  
                  
//                   <SkillTB>
                  out.println("<hr>");
                  out.println("<h1>Skill</h1>");
//                  Collection<SkillTB> skills = fp.GetAllSkill();
//                  for(SkillTB skill : skills)
//                  {
//                      out.println("<div>SkillID = "+skill.getSkillID()+" |  Skills = "+ skill.getSkills()+"</div>");
//                  }
                  
                  //Add
                  //fp.AddSkill("abc",1);
                  //Update
                  //fp.UpdateSkill(13, "TypeScript");
                  //Delete
                  //fp.DeleteSkill(14);
                  
                  
                   
//                   <CategoryTB>
                  out.println("<hr>");
                  out.println("<h1>Category</h1>");
//                  Collection<CategoryTB> categorys = fp.GetAllCategory();
//                  for(CategoryTB cat : categorys)
//                  {
//                      out.println("<div>CategoryID = "+cat.getCategoryID()+" |  CategoryName = "+ cat.getCategoryName() +"</div>");
//                  }
//                  
                  //Add
                  //fp.AddCategory("SoftSkill");
                  //Update
                  //fp.UpdateCategory(16, "Developer");
                  //Delete
                  //fp.DeleteCategory(16);
               
            
            out.println("<h1>Servlet ejbServlet at " + request.getContextPath() + "</h1>");
            
            out.println("<h1>Servlet ejb at " + request.getContextPath() + "</h1>");
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
