/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Client.FreelancerClient;
import Entity.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;
import org.primefaces.model.*;
import org.primefaces.model.StreamedContent;
import sun.misc.IOUtils;

/**
 *
 * @author root
 */
@Named(value = "CDI")
@ApplicationScoped
public class CDIBean {
    //@EJB DataSessionBeanLocal dbl;
    Response res;
    String username;
    String password;
    String scope;
    String EditPID;
    String id;
    
    String cityID;
    String CityName;
    String state;
    String stateID;
    
    String category;
    String categoryID;
    
    String degree;
    String degreeID;
    
    String level;
    String EditEngID;
    String englishLevelID;
    
    String expertize;
    String ExpertizeLevelID;
    
    String Hour;
    String EditHourID;
    String hourlyRateID;
    
    String projectScopeID;
    
    String isActive;
    
    String SkillID;
    String skill;
   // public String[] data;
    //String cateID;
    String[] SkillidArray;
    String[] WorkSkillArray;
    
    String CompanyID;
    String companyName;
    String companyOwnerName;
    String companyEmail;
    String companyPassword;
    String companyStaff;
    String companyContact;
    String companyIsActive;
    String passwordConfirm;
    String CompanyLogo;
    
    String FreelancerID;
    String Email;
    String FreelancerPassword;
    String College;
    String ProfileImage;
    String AboutSelf;
    String WeeklyAvailable;
    String FreelancerLogo;
    
    
    String WorkPostID;
    String WorkTitle;
    String WorkDescription;
    String WorkPostDate;
    
    String WorkStatus;
    
    String CertificateFile;
    
    String cmpReviewMsg;
    String freeReviewMsg;
    
    String BiddingRate;
    
    
    private StateTB selectedState;
    
    private FreelancerTB selectedfreelancer;
    private FreelancerTB freelancerTB = new FreelancerTB();
    
    private CompanyTB selectedcompany;
    private CompanyTB companyTB = new CompanyTB();
    
    private WorkPostTB selectedWorkPost;
    private WorkPostTB workPostTB = new WorkPostTB();
    
    FreelancerClient client;
    Pbkdf2PasswordHashImpl pb;
   // private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    //private Pbkdf2PasswordHashImpl pbkdf2PasswordHashImpl = new Pbkdf2PasswordHashImpl();
    
    Collection<WorkPostTB> CompWorkPost;
    GenericType<Collection<WorkPostTB>> gCompWorkPost;
    
    Collection<FreelancerTB> activefree;
    GenericType<Collection<FreelancerTB>> gactivefree;
    
    Collection<CompanyTB> activecomp;
    GenericType<Collection<CompanyTB>> gactivecomp;
    
    Collection<FreelancerTB> blockfree;
    GenericType<Collection<FreelancerTB>> gblockfree;
    
    Collection<CompanyTB> blockcomp;
    GenericType<Collection<CompanyTB>> gblockcomp;
    
    Collection<FreelancerTB> freelancers;
    GenericType<Collection<FreelancerTB>> gfreelancers;
    
    Collection<FreelancerTB> appliedworkfreelancer;
    GenericType<Collection<FreelancerTB>> gappliedworkfreelancer;
    
    Collection<FreelancerTB> Ongoingfreelancer;
    GenericType<Collection<FreelancerTB>> gOngoingfreelancer;

    Collection<FreelancerTB> CompanyWiseAppliedFreelancer;
    GenericType<Collection<FreelancerTB>> gCompanyWiseAppliedFreelancer;
    
    Collection<ProjectScopeTB> projectScopes;
    GenericType<Collection<ProjectScopeTB>> gprojectScopes;
    
    Collection<StateTB> states;
    GenericType<Collection<StateTB>> gstates;
    
    Collection<HourlyRateTB> hourlyRates;
    GenericType<Collection<HourlyRateTB>> ghourlyRates;
    
    Collection<CityTB> cities;
    GenericType<Collection<CityTB>> gcities;
    
    Collection<CategoryTB> categories;
    GenericType<Collection<CategoryTB>> gcategories;
    
    Collection<DegreeTB> degrees;
    GenericType<Collection<DegreeTB>> gdegrees;
    
    Collection<EnglsihLevelTB> englishlevels;
    GenericType<Collection<EnglsihLevelTB>> genglishlevels;
    
    Collection<ExpertizeLevelTB> expertizelevels;
    GenericType<Collection<ExpertizeLevelTB>> gexpertizelevels;
    
    Collection<SkillTB> skills;
    GenericType<Collection<SkillTB>> gskills;
    
    Collection<CompanyTB> companys;
    GenericType<Collection<CompanyTB>> gcompanys;
    
    Collection<WorkPostTB> workposts;
    GenericType<Collection<WorkPostTB>> gworkposts;
    
    Collection<WorkPostTB> workpostwithcmpdetails;
    GenericType<Collection<WorkPostTB>> gworkpostwithcmpdetails;
    
    Collection<SkillTB> freeskills;
    GenericType<Collection<SkillTB>> gfreeskills;
    
    Collection<SkillTB> workskills;
    GenericType<Collection<SkillTB>> gworkskills;
    
    Collection<ApplyTB> applys;
    GenericType<Collection<ApplyTB>> gapplys;
    
    Collection<CertificateTB> certificates;
    GenericType<Collection<CertificateTB>> gcertificates;
    
//    Collection<CompanyReviewTB> cmpreviews;
//    GenericType<Collection<CompanyReviewTB>> gcmpreviews;
    
    Collection<ReviewTB> reviewTBs;
    GenericType<Collection<ReviewTB>> greviewTBs;
    
    Collection<ReviewTB> reviewTBss;
    GenericType<Collection<ReviewTB>> greviewTBss;
    
    Collection<WorkPostTB> workpostcmp;
    GenericType<Collection<WorkPostTB>> gworkpostcmp;
    
    Collection<WorkPostTB> SearchByCname;
    GenericType<Collection<WorkPostTB>> gSearchByCname;
    
    Collection<WorkPostTB> SearchByCnameInCompList;
    GenericType<Collection<WorkPostTB>> gSearchByCnameInCompList;
    
    Collection<WorkPostTB> applybyfid;
    GenericType<Collection<WorkPostTB>> gapplybyfid;
    
    Collection<WorkPostTB> approvedbyfid;
    GenericType<Collection<WorkPostTB>> gapprovedbyfid;
    
    Collection<WorkPostTB> Ongoingbyfid;
    GenericType<Collection<WorkPostTB>> gOngoingbyfid;
    
    Collection<WorkPostTB> completedbyfid;
    GenericType<Collection<WorkPostTB>> gcompletedbyfid;
     
    Collection<FreelancerTB> companyWiseOngoingFreelancer;
    GenericType<Collection<FreelancerTB>> gcompanyWiseOngoingFreelancer;
    
    Collection<FreelancerTB> companyWiseCompletedFreelancer;
    GenericType<Collection<FreelancerTB>> gcompanyWiseCompletedFreelancer;
    
    Collection<WorkPostTB> workpostcmpp;
    GenericType<Collection<WorkPostTB>> gworkpostcmpp;
    
    Collection<FreelancerTB> approvedworkfreelancer;
    GenericType<Collection<FreelancerTB>> gapprovedworkfreelancer;
    
    Collection<FreelancerTB> confirmedworkfreelancer;
    GenericType<Collection<FreelancerTB>> gconfirmedworkfreelancer;
    
    Collection<FreelancerTB> completedworkfreelancer;
    GenericType<Collection<FreelancerTB>> gcompletedworkfreelancer;
    
    Collection<FreelancerTB> SearchByFreeName;
    GenericType<Collection<FreelancerTB>> gSearchByFreeName;
    
    Collection<FreelancerTB> SearchByFreeHourRate;
    GenericType<Collection<FreelancerTB>> gSearchByFreeHourRate;
    
    Collection<WorkPostTB> SearchByWorkPostHourRate;
    GenericType<Collection<WorkPostTB>> gSearchByWorkPostHourRate;
    
    Collection<ApplyTB> Applydata;
    GenericType<Collection<ApplyTB>> gApplydata;
    
    Collection<ApplyTB> ApproveApplyData;
    GenericType<Collection<ApplyTB>> gApproveApplyData;
    
    Collection<ApplyTB> OngoingData;
    GenericType<Collection<ApplyTB>> gOngoingData;
    
    Collection<ApplyTB> ConfirmData;
    GenericType<Collection<ApplyTB>> gConfirmData;
    
    Collection<SkillTB> freeskillbyfid;
    GenericType<Collection<SkillTB>> gfreeskillbyfid;
    
    Collection<CertificateTB> certificatebyfid;
    GenericType<Collection<CertificateTB>> gcertificatebyfid;
    
    Collection<BiddingTB> biddingbyworkpost;
    GenericType<Collection<BiddingTB>> gbiddingbyworkpost;
    
    
    
    private Part uploadedFile;
	private String folder = "/home/brinda/SEM_8/JAVA_EJB/ProjectFolder/ProjectWebApp/web/resources/images";

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

//        
//    
//        public void saveFile(){
//		
//		try (InputStream input = uploadedFile.getInputStream()) {
//			String fileName = uploadedFile.getSubmittedFileName();
//	        Files.copy(input, new File(folder, fileName).toPath());
//	    }
//	    catch (IOException e) {
//	        e.printStackTrace();
//	    }
//	}
    
    
    //company

    public String getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(String CompanyID) {
        this.CompanyID = CompanyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyOwnerName() {
        return companyOwnerName;
    }

    public void setCompanyOwnerName(String companyOwnerName) {
        this.companyOwnerName = companyOwnerName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyPassword() {
        return companyPassword;
    }

    public void setCompanyPassword(String companyPassword) {
        this.companyPassword = companyPassword;
    }

    public String getCompanyStaff() {
        return companyStaff;
    }

    public void setCompanyStaff(String companyStaff) {
        this.companyStaff = companyStaff;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    public String getCompanyIsActive() {
        return companyIsActive;
    }

    public void setCompanyIsActive(String companyIsActive) {
        this.companyIsActive = companyIsActive;
    }

    public Pbkdf2PasswordHashImpl getPb() {
        return pb;
    }

    public void setPb(Pbkdf2PasswordHashImpl pb) {
        this.pb = pb;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getCompanyLogo() {
        return CompanyLogo;
    }

    public void setCompanyLogo(String CompanyLogo) {
        this.CompanyLogo = CompanyLogo;
    }

    
    
    
        
        

    public Collection<CompanyTB> getCompanys() {
        System.out.println("In get Company");
        
        res = client.GetAllCompany_XML(Response.class);
        System.out.println(res);
        companys = res.readEntity(gcompanys);
        System.out.println(companys);
        return companys;
    }

    public void setCompanys(Collection<CompanyTB> companys) {
        this.companys = companys;
    }

    public CompanyTB getSelectedcompany() {
        return selectedcompany;
    }
    
//    public String showPassword(CDIBean bean)
//    {
//        String Password = pb.generate(bean.getPassword().toCharArray());
//        return "file_upload.jsf";
//    }
    
    
    public String AddCompany(CDIBean bean)
    {
        //client.AddCompany(companyName, companyOwnerName, companyEmail, companyPassword, companyStaff, companyContact, isActive, id, id, Hour);
//        this.uploadedFile = bean.getCompanyLogo();
//        uploadedFile  =  new Part(bean.getCompanyLogo());
        
        try (InputStream input = uploadedFile.getInputStream()) {
			String fileName = uploadedFile.getSubmittedFileName();
                       // pb.generate(bean.getCompanyPassword().toCharArray());
                       String Compassword = pb.generate(bean.getCompanyPassword().toCharArray());
                        client.AddCompany(bean.getCompanyName(),bean.getCompanyOwnerName(),bean.getCompanyEmail(),Compassword,bean.getCompanyStaff(),bean.getCompanyContact(),"1",bean.getStateID(),bean.getCityID(),fileName);
//                        String cid = "9";
//                        String compid = cid + 1;
//                        client.AddLoginDetails(bean.companyEmail, Compassword, compid);
                        //client.AddLoginRole_JSON("2", id);
                        Files.copy(input, new File(folder, fileName).toPath());
                
                
	    }
	    catch (Exception e) {
                System.out.println("Error : " + e);
	    }
        return "login.jsf?faces-redirect=true";
    }
    
    
    
    public String onStateChangeID(String Stateid)
    {
        
//            res = client.GetAllStateWiseCity_XML(Response.class,Stateid);
//            cities = res.readEntity(gcities);
            return Stateid;
    }
    
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Freelancer_Portal", "root", "brinda");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return con;
    }
    
    
    public List<CityTB> onStateChange(String id)
    {
        List<CityTB> cityTBs = new ArrayList<CityTB>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from CityTB where StateID=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CityTB c = new CityTB();
                c.setCityID(rs.getInt("cityID"));
                c.setCityName(rs.getString("cityName"));
                //c.setStateID(rs.getInt("stateID"));
               cityTBs.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return cityTBs;
    }
    
//    public void validatePasswordError(FacesContext context, UIComponent component,
//            Object value) {
//
//        if (!companyPassword.equals(passwordConfirm)) {
//            String message = context.getApplication().evaluateExpressionGet(context, "#{msgs['nomatch']}", String.class);
//            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
//            throw new ValidatorException(msg);
//        }
//    }

    public String EditCompanyByID()
    {
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "company_edit.jsf";
    }
    public String EditCompany(CDIBean bean)
    {
        try (InputStream input = uploadedFile.getInputStream()) {
			String fileName = uploadedFile.getSubmittedFileName();
                       // pb.generate(bean.getCompanyPassword().toCharArray());
                       String Compassword = pb.generate(bean.getCompanyPassword().toCharArray());
                       client.UpdateCompany_JSON(companys, bean.getCompanyID(), bean.getCompanyName(), bean.getCompanyOwnerName(), bean.getCompanyEmail(), Compassword, bean.getCompanyStaff(), bean.getCompanyContact(), "1",bean.getStateID(),bean.getCityID(), fileName);
//                        client.AddCompany(bean.getCompanyName(),bean.getCompanyOwnerName(),bean.getCompanyEmail(),Compassword,bean.getCompanyStaff(),bean.getCompanyContact(),"1",bean.getStateID(),bean.getCityID(),fileName);
//                        String cid = "9";
//                        String compid = cid + 1;
//                        client.AddLoginDetails(bean.companyEmail, Compassword, compid);
                        //client.AddLoginRole_JSON("2", id);
                        Files.copy(input, new File(folder, fileName).toPath());
                
                
	    }
	    catch (Exception e) {
                System.out.println("Error : " + e);
	    }
        
        return "cmp_dashboard.jsf?faces-redirect=true";
    } 

    public void setSelectedcompany(CompanyTB selectedcompany) {
        this.selectedcompany = selectedcompany;
    }
    
    public String ViewCompanyProfile()
    {
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "company_profile.jsf?faces-redirect=false";
    }
    //Company profile workpost display in admin side

    public Collection<WorkPostTB> getCompWorkPost() {
        res = client.GetAllWorkPostByCompany_XML(Response.class, id);
        System.out.println(res);
        CompWorkPost = res.readEntity(gCompWorkPost);
        System.out.println(CompWorkPost);
        return CompWorkPost;
    }
    
    public void setCompWorkPost(Collection<WorkPostTB> CompWorkPost) {
        this.CompWorkPost = CompWorkPost;
    }
    
    public String ViewCompanyDetails()
    {
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "freelancer_company_details.jsf?faces-redirect=false";
    }
    
    //WorkPost

    public WorkPostTB getSelectedWorkPost() {
        return selectedWorkPost;
    }

    public void setSelectedWorkPost(WorkPostTB selectedWorkPost) {
        this.selectedWorkPost = selectedWorkPost;
    }

//    public WorkPostTB getWorkPostTB() {
//        return workPostTB;
//    }
//
//    public void setWorkPostTB(WorkPostTB workPostTB) {
//        this.workPostTB = workPostTB;
//    }

    
    
    public String getWorkPostID() {
        return WorkPostID;
    }

    public void setWorkPostID(String WorkPostID) {
        this.WorkPostID = WorkPostID;
    }

    public String getWorkTitle() {
        return WorkTitle;
    }

    public void setWorkTitle(String WorkTitle) {
        this.WorkTitle = WorkTitle;
    }

    public String getWorkDescription() {
        return WorkDescription;
    }

    public void setWorkDescription(String WorkDescription) {
        this.WorkDescription = WorkDescription;
    }

    public String getWorkPostDate() {
        return WorkPostDate;
    }

    public void setWorkPostDate(String WorkPostDate) {
        this.WorkPostDate = WorkPostDate;
    }

    public Collection<WorkPostTB> getWorkposts() {
        System.out.println("IN work posts");
        res = client.GetAllWorkPost_XML(Response.class);
        System.out.println(res);
        workposts = res.readEntity(gworkposts);
        System.out.print(workposts);
        return workposts;
    }

    public void setWorkposts(Collection<WorkPostTB> workposts) {
        this.workposts = workposts;
    }
    
//    public String AddWorkPosts(CDIBean bean)
//    {
//        Date Today= new Date();
//        //client.AddWorkPost(bean.getWorkTitle(), bean.getWorkDescription(), Today, bean.getProjectScopeID(),bean.getExpertizeLevelID(),bean.getHourlyRateID(), bean.getEnglishLevelID(),bean.getCategoryID(),"3001");
//        return "cmp_workpost_list.jsf?faces-redirect=true";
//    }
    
    public String AddWorkPosts(CDIBean w) {
        //int status = 0;
        try {
            
            Date Today= new Date();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                //out.println("date : " + df.format(Today));
                String datefor = df.format(Today);
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement
        ("insert into WorkPostTB(WorkTitle,WorkDescription,WorkPostDate,ProjectScopeID,ExpertizeLevelID,HourlyRateID,EnglishLevelID,CategoryID,CompanyID) values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, w.getWorkTitle());
            ps.setString(2, w.getWorkDescription());
            ps.setString(3, datefor);
            ps.setString(4, w.getProjectScopeID());
            ps.setString(5, w.getExpertizeLevelID());
            ps.setString(6, w.getHourlyRateID());
            ps.setString(7, w.getEnglishLevelID());
            ps.setString(8, w.getCategoryID());
            ps.setString(9, w.GetLoginID().getUserID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return "cmp_workpost_list.jsf?faces-redirect=true";
    }
    
//    public String RemoveWorkPosts(String workPostID,String projectScopeID,String expertizeLevelID,String hourlyRateID,String englishLevelID,String categoryID,String companyID)
//    {
//        client.DeleteWorkPost(workPostID, projectScopeID, expertizeLevelID, hourlyRateID, englishLevelID, categoryID, companyID);
//        return "cmp_workpost_list.jsf?faces-redirect=true";
//    }
    
    public String RemoveWorkPosts(String wpid)
    {
        client.DeletePost(wpid);
        return "cmp_workpost_list.jsf?faces-redirect=true";
    }
    
    
    public String EditWorkPostByID()
    {
        //this.workPostTB = postTB;
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        //System.out.println("id : " + WorkPostID);
        return "cmp_workpost_edit.jsf?faces-redirect=false";
    }
    
    public WorkPostTB WorkPostData() {
        WorkPostTB w = null;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from WorkPostTB where workPostID=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                w = new WorkPostTB();
                w.setWorkPostID(rs.getInt("workPostID"));
                w.setWorkTitle(rs.getString("workTitle"));
                w.setWorkDescription(rs.getString("workDescription"));
                w.setWorkPostDate(rs.getString("workPostDate"));
               // sessionMap.put("editUser", w);  
                //w.(rs.getInt("categoryID"));
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return w;
    }
    
    public String EditWorkPost(CDIBean bean)
    {
        Date Today= new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      
        String datefor = df.format(Today);
        String cmpid = bean.GetLoginID().getUserID();
        client.UpdateWorkPost_JSON(workposts, bean.getId(),bean.getWorkTitle(), bean.getWorkDescription(), datefor, bean.getProjectScopeID(),bean.getExpertizeLevelID(),bean.getHourlyRateID(), bean.getEnglishLevelID(),bean.getCategoryID(),cmpid);
        return "cmp_workpost_list.jsf?faces-redirect=true";
    } 
    
    public String updateWorkPost(CDIBean w) {
        //int status = 0;
        try {
            Date Today= new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      
        String datefor = df.format(Today);
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement
        ("update WorkPostTB set WorkTitle=?,WorkDescription=?,WorkPostDate=?,ProjectScopeID=?,ExpertizeLevelID=?,HourlyRateID=?,EnglishLevelID=?,CategoryID=?,CompanyID=? where WorkPostID=?");
            ps.setString(1, w.getWorkTitle());
            ps.setString(2, w.getWorkDescription());
            ps.setString(3, datefor);
            ps.setString(4, w.getProjectScopeID());
            ps.setString(5, w.getExpertizeLevelID());
            ps.setString(6, w.getHourlyRateID());
            ps.setString(7, w.getEnglishLevelID());
            ps.setString(8, w.getCategoryID());
           
            ps.setString(9, w.GetLoginID().getUserID());
            ps.setString(10, w.getId());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return "cmp_workpost_list.jsf?faces-redirect=true";
    }
    
    
    
    
    //Skill

    public String getSkillID() {
        return SkillID;
    }

    public void setSkillID(String SkillID) {
        this.SkillID = SkillID;
    }

//    public String getCateID() {
//        return cateID;
//    }
//
//    public void setCateID(String cateID) {
//        this.cateID = cateID;
//    }

//    public String[] getData() {
//        return data;
//    }
//
//    public void setData(String[] data) {
//        this.data = data;
//    }

    public String[] getSkillidArray() {
        return SkillidArray;
    }

    public void setSkillidArray(String[] SkillidArray) {
        this.SkillidArray = SkillidArray;
    }

    
    

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Collection<SkillTB> getSkills() {
        System.out.println("In get Skills");
        
        res = client.GetAllSkill_XML(Response.class);
        System.out.println(res);
        skills = res.readEntity(gskills);
        System.out.println(skills);
           
        return skills;
    }

    public void setSkills(Collection<SkillTB> skills) {
        this.skills = skills;
    }

    public String AddSkill(CDIBean bean)
    {
        client.AddSkill(bean.skill, bean.categoryID);
        return "skill_list.jsf?faces-redirect=true"; 
    }

    public String AddSkillFreelancer(CDIBean bean){
        try{

            client.AddSkillFreelancer_JSON(bean.getSkillidArray(), bean.getFreelancerID());
            
        }catch(Exception e){
            System.out.println("Error : "+e);
            
        }
        
        return "freelancer_dashboard.jsf?faces-redirect=true";
    }

    //AddWork Post SKill 
    public String[] getWorkSkillArray() {
        return WorkSkillArray;
    }

    public void setWorkSkillArray(String[] WorkSkillArray) {
        this.WorkSkillArray = WorkSkillArray;
    }
    
    public String gotoWorkSkill(){
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "add_workpost_skill.jsf";
    }
    
    public String AddWorkPostSkill(CDIBean bean){
        try{

            client.AddWorkPostFreelancerSkill_JSON(bean.getWorkSkillArray(), bean.getId());
            
        }catch(Exception e){
            System.out.println("Error : "+e);
            
        }
        
        return "cmp_dashboard.jsf?faces-redirect=true";
    }
    
    public String RemoveSkill(String sid)
    {
        client.DeleteSkill(sid);
        return "skill_list.jsf?faces-redirect=true"; 
    }
    
    public String EditSkillByID(SkillTB s)
   {
       this.skill = s.getSkills();
       this.categoryID = s.getCategoryID().getCategoryID().toString();
       id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
       //stateID = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("stateId");
       return "skill_edit.jsf";
   }


   public String EditSkill(CDIBean bean)
   {
       client.UpdateSkill_JSON(skills, bean.getId(), bean.skill, bean.categoryID);
       return "skill_list.jsf?faces-redirect=false";
   }
    
    
    
    

    //City
    public String getCityID() {    
        return cityID;
    }
    
    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public Collection<CityTB> getCities() {
        System.out.println("In get Cities");

        res = client.GetAllCity_XML(Response.class);
        System.out.println(res);
        cities = res.readEntity(gcities);
        System.out.println(cities);
           
        return cities;
    }
    

    public void setCities(Collection<CityTB> cities) {
        this.cities = cities;
    }
    
    public String AddCity(CDIBean bean)
    {
        client.AddStateWiseCity(bean.CityName, bean.stateID);
        return "city_list.jsf?faces-redirect=true"; 
    }

    public String RemoveCity(String cid,String sid)
    {
        client.DeleteStateWiseCity(cid,sid);
        return "city_list.jsf?faces-redirect=true"; 
    }
    
    public String EditCityByID(CityTB c)
   {
       this.CityName = c.getCityName();
       this.stateID =  c.getStateID().getStateID().toString();
       id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
       //stateID = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("stateId");
       return "city_edit.jsf";
   }


   public String EditCity(CDIBean bean)
   {
       client.UpdateStateWiseCity_JSON(cities, bean.getId(), bean.getCityName(), bean.getStateID());
       return "city_list.jsf?faces-redirect=true";
   }
   
    
    //State

    public String getStateID() {
        return stateID;
    }

    public void setStateID(String stateID) {
        this.stateID = stateID;
    }
   
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
    
    public Collection<StateTB> getStates() {
        res = client.GetAllState_XML(Response.class);
        System.out.println(res);
        states = res.readEntity(gstates);
        return states;
    }

    public StateTB getSelectedState() {
        return selectedState;
    }

    public void setSelectedState(StateTB selectedState) {
        this.selectedState = selectedState;
    }

    public void setStates(Collection<StateTB> states) {
        this.states = states;
    }

    public String AddState(CDIBean bean)
   {
       client.AddState(bean.getState());
       return "state_list.jsf?faces-redirect=true"; 
   }
   
   public String RemoveState(String stateID)
   {
       client.DeleteState(stateID);
       return "state_list.jsf?faces-redirect=true"; 
   }
    
   public String EditStateByID(StateTB s)
   {
       this.state = s.getStateName();
       id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
       
       return "state_edit.jsf";
   }


   public String EditState(CDIBean bean)
   {
       client.UpdateState_JSON(states,bean.getId(), bean.getState());
       return "state_list.jsf?faces-redirect=true";
   }
    

    //ProjectScope
   
    public Collection<ProjectScopeTB> getProjectScopes() {
        res = client.GetAllProjectScope_XML(Response.class);
        System.out.println(res);
        //res.
        projectScopes = res.readEntity(gprojectScopes);
        return projectScopes;
    }

    public void setProjectScopes(Collection<ProjectScopeTB> projectScopes) {
        this.projectScopes = projectScopes;
    }
    
    //freelancer

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getFreelancerPassword() {
        return FreelancerPassword;
    }

    public void setFreelancerPassword(String FreelancerPassword) {
        this.FreelancerPassword = FreelancerPassword;
    }
    
    

    public String getFreelancerID() {
        return FreelancerID;
    }

    public void setFreelancerID(String FreelancerID) {
        this.FreelancerID = FreelancerID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCollege() {
        return College;
    }

    public void setCollege(String College) {
        this.College = College;
    }

    public String getProfileImage() {
        return ProfileImage;
    }

    public void setProfileImage(String ProfileImage) {
        this.ProfileImage = ProfileImage;
    }

    public String getAboutSelf() {
        return AboutSelf;
    }

    public void setAboutSelf(String AboutSelf) {
        this.AboutSelf = AboutSelf;
    }

    public String getWeeklyAvailable() {
        return WeeklyAvailable;
    }

    public void setWeeklyAvailable(String WeeklyAvailable) {
        this.WeeklyAvailable = WeeklyAvailable;
    }

    public String getFreelancerLogo() {
        return FreelancerLogo;
    }

    public void setFreelancerLogo(String FreelancerLogo) {
        this.FreelancerLogo = FreelancerLogo;
    }

    
    
    public String AddFreelancer(CDIBean bean)
    {
        
        
        try (InputStream input = uploadedFile.getInputStream()) {
			String fileName = uploadedFile.getSubmittedFileName();
                       // pb.generate(bean.getCompanyPassword().toCharArray());
                       String FreePass = pb.generate(bean.getFreelancerPassword().toCharArray());
                        client.AddFreelancer(bean.getEmail(), FreePass, bean.getCollege(), fileName, bean.getAboutSelf(), bean.getWeeklyAvailable(), bean.getCategoryID(), bean.getStateID(), bean.getCityID(), bean.getDegreeID(), bean.getEnglishLevelID(), bean.getExpertizeLevelID(), bean.getHourlyRateID(), "1");
//                        String cid = "9";
//                        String compid = cid + 1;
//                        client.AddLoginDetails(bean.companyEmail, Compassword, compid);
                        //client.AddLoginRole_JSON("2", id);
                        Files.copy(input, new File(folder, fileName).toPath());
                
                
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
        return "index.jsf?faces-redirect=true";
    }
    
    public String EditFreelancer(CDIBean bean)
    {
        try (InputStream input = uploadedFile.getInputStream()) {
			String fileName = uploadedFile.getSubmittedFileName();
                       // pb.generate(bean.getCompanyPassword().toCharArray());
                       String FreePass = pb.generate(bean.getFreelancerPassword().toCharArray());
                       client.UpdateFreelancer_JSON(freelancers, bean.getFreelancerID(), bean.getEmail(),FreePass, bean.getCollege(), fileName, bean.getAboutSelf(), bean.getWeeklyAvailable(), bean.getCategoryID(), bean.getStateID(), bean.getCityID(), bean.getDegreeID(), bean.getEnglishLevelID(),bean.getExpertizeLevelID(), bean.getHourlyRateID(), "1");
//                        client.AddCompany(bean.getCompanyName(),bean.getCompanyOwnerName(),bean.getCompanyEmail(),Compassword,bean.getCompanyStaff(),bean.getCompanyContact(),"1",bean.getStateID(),bean.getCityID(),fileName);
//                        String cid = "9";
//                        String compid = cid + 1;
//                        client.AddLoginDetails(bean.companyEmail, Compassword, compid);
                        //client.AddLoginRole_JSON("2", id);
                        Files.copy(input, new File(folder, fileName).toPath());
                
                
	    }
	    catch (Exception e) {
                System.out.println("Error : " + e);
	    }
        
        return "index.jsf?faces-redirect=true";
    } 
    
    public Collection<FreelancerTB> getFreelancers() {
         System.out.println("In get books");
        res = client.GetAllFreelancer_XML(Response.class);
        System.out.println(res);
        //res.
        freelancers = res.readEntity(gfreelancers);
        //books = dbl.getAllBooks();
        System.out.println(freelancers);
        return freelancers;
        //return freelancers;
    }

    public void setFreelancers(Collection<FreelancerTB> freelancers) {
        this.freelancers = freelancers;
    }
    
    public String ViewFreelancerProfile()
    {
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");

        return "freelancer_profile.jsf?faces-redirect=false";
    }
    
    public String ViewFreelancerDetails()
    {
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "freelancer_details.jsf?faces-redirect=false";
    }
    
    public String ChangeStatusFreelancer(String fid,String isActive)
    {
        client.ChangeStatusFreelancer_JSON(freelancers, fid,isActive);
        return "freelancer_list.jsf?faces-redirect=false";
    }
    
    public String ChangeStatusCompany(String cid,String isActive)
    {
        client.ChangeStatusCompany_JSON(companys, cid, isActive);
        return "company_list.jsf?faces-redirect=false";
    }

    public FreelancerTB getSelectedfreelancer() {
        return selectedfreelancer;
    }

    public void setSelectedfreelancer(FreelancerTB selectedfreelancer) {
        this.selectedfreelancer = selectedfreelancer;
    }
    
    
   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public FreelancerClient getClient() {
        return client;
    }

    public void setClient(FreelancerClient client) {
        this.client = client;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getProjectScopeID() {
        return projectScopeID;
    }

    public void setProjectScopeID(String projectScopeID) {
        this.projectScopeID = projectScopeID;
    }

    

    public String getEditPID() {
        return EditPID;
    }

    public void setEditPID(String EditPID) {
        this.EditPID = EditPID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    
   public String AddProjectScope(CDIBean bean)
   {
       client.AddProjectScope(bean.getScope());
       return "project_scope.jsf?faces-redirect=true"; 
   }
   
   public String RemoveProjectScope(String projectScopeID)
   {
       client.DeleteProjectScope(projectScopeID);
       return "project_scope.jsf?faces-redirect=true"; 
   }
    
   public String EditProjectScopeByID(ProjectScopeTB p)
   {
       this.scope = p.getScope();
       id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
       
       return "edit_project_scope.jsf";
   }


   public String EditProjectScope(CDIBean bean)
   {
       client.UpdateProjectScope_JSON(projectScopes,bean.getId(), bean.getScope());
       return "project_scope.jsf?faces-redirect=false";
   }

   
   //HourlyRate

    public String getHour() {
        return Hour;
    }

    public void setHour(String Hour) {
        this.Hour = Hour;
    }

    public String getEditHourID() {
        return EditHourID;
    }

    public void setEditHourID(String EditHourID) {
        this.EditHourID = EditHourID;
    }

    public String getHourlyRateID() {
        return hourlyRateID;
    }

    public void setHourlyRateID(String hourlyRateID) {
        this.hourlyRateID = hourlyRateID;
    }

    
   
    public Collection<HourlyRateTB> getHourlyRates() {
        System.out.println("In get hourlyrate");
        res = client.GetAllHourlyRate_XML(Response.class);
        System.out.println(res);
        hourlyRates = res.readEntity(ghourlyRates);
        System.out.println(hourlyRates);
        
        return hourlyRates;
    }

    public void setHourlyRates(Collection<HourlyRateTB> hourlyRates) {
        this.hourlyRates = hourlyRates;
    }

    public String AddHourlyRate(CDIBean bean)
    {
        client.AddHourlyRate(bean.getHour());
        return "hourly_rate_list.jsf";
    }
    public String RemoveHourlyRate(String hourlyRateID)
    {
       client.DeleteHourlyRate(hourlyRateID);
       return "hourly_rate_list.jsf"; 
    }
    public String EditHourlyRateByID(HourlyRateTB h)
    {
        this.Hour = h.getRate();
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "hourly_rate_edit.jsf";
    }
    public String EditHourlyRate(CDIBean bean)
    {
        client.UpdateHourlyRate_JSON(hourlyRates,bean.getId(),bean.getHour());
        return "hourly_rate_list.jsf";
    }
    
    //Category

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    
    
    
    public Collection<CategoryTB> getCategories() {
        System.out.println("In get Categories");
        res = client.GetAllCategory_XML(Response.class);
        System.out.println(res);
        categories = res.readEntity(gcategories);
        System.out.println(categories);
        return categories;
    }

    public void setCategories(Collection<CategoryTB> categories) {
        this.categories = categories;
    }
   
     public String AddCategories(CDIBean bean)
    {
        client.AddCategory(bean.getCategory());
        return "category_list.jsf";
    }
    public String RemoveCategories(String categoryID)
    {
       client.DeleteCategory(categoryID);
       return "category_list.jsf"; 
    }
    public String EditCategoryByID(CategoryTB cate)
    {
        this.category = cate.getCategoryName();
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "category_edit.jsf";
    }
    public String EditCategory(CDIBean bean)
    {
        client.UpdateCategory_JSON(categories, bean.getId(), bean.getCategory());
        return "category_list.jsf?faces-redirect=true";
    }
   
   //Degree

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDegreeID() {
        return degreeID;
    }

    public void setDegreeID(String degreeID) {
        this.degreeID = degreeID;
    }

    

    public Collection<DegreeTB> getDegrees() {
        System.out.println("In get Degrees");
        res = client.GetAllDegree_XML(Response.class);
        System.out.println(res);
        degrees = res.readEntity(gdegrees);
        System.out.println(degrees);
        return degrees;
    }

    public void setDegrees(Collection<DegreeTB> degrees) {
        this.degrees = degrees;
    }
    
     public String AddDegrees(CDIBean bean)
    {
        client.AddDegree(bean.getDegree());
        return "degree_list.jsf";
    }
    public String RemoveDegrees(String degreeID)
    {
       client.DeleteDegree(degreeID);
       return "degree_list.jsf"; 
    }
    public String EditDegreeByID(DegreeTB d)
    {
        this.degree = d.getDegree();
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "degree_edit.jsf";
    }
    public String EditDegree(CDIBean bean)
    {
        client.UpdateDegree_JSON(degrees, bean.getId(), bean.getDegree());
        return "degree_list.jsf?faces-redirect=true";
    }    
    
    
    //EnglishLevel

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
    public String getEditEngID() {
        return EditEngID;
    }

    public void setEditEngID(String EditEngID) {
        this.EditEngID = EditEngID;
    }

    public String getEnglishLevelID() {
        return englishLevelID;
    }

    public void setEnglishLevelID(String englishLevelID) {
        this.englishLevelID = englishLevelID;
    }

    

    public Collection<EnglsihLevelTB> getEnglishlevels() {
        System.out.println("In get English Levels");
        res = client.GetAllEnglishLevel_XML(Response.class);
        System.out.println(res);
        englishlevels = res.readEntity(genglishlevels);
        System.out.println(englishlevels);
        return englishlevels;
    }

    public void setEnglishlevels(Collection<EnglsihLevelTB> englishlevels) {
        this.englishlevels = englishlevels;
    }
    
     public String AddEnglishLevel(CDIBean bean)
    {
        client.AddEnglsihLevel(bean.getLevel());
        return "english_level_list.jsf";
    }
    public String RemoveEnglishLevel(String englishLevelID)
    {
       client.DeleteEnglsihLevel(englishLevelID);
       return "english_level_list.jsf"; 
    }
    public String EditEnglishLevelByID(EnglsihLevelTB english)
    {
        this.level = english.getEnglishLevels();
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "english_level_edit.jsf";
    }
    public String EditEnglishLevel(CDIBean bean)
    {
        client.UpdateEnglsihLevel_JSON(englishlevels,bean.getId(), bean.getLevel());
        return "english_level_list.jsf?faces-redirect=true";
    }
    
    //ExpertizedLevel

    public String getExpertize() {
        return expertize;
    }

    public void setExpertize(String expertize) {
        this.expertize = expertize;
    }

    public String getExpertizeLevelID() {
        return ExpertizeLevelID;
    }

    public void setExpertizeLevelID(String ExpertizeLevelID) {
        this.ExpertizeLevelID = ExpertizeLevelID;
    }

    

    public Collection<ExpertizeLevelTB> getExpertizelevels() {
        System.out.println("In get Expertize Level");
        res = client.GetAllExpertizeLevel_XML(Response.class);
        System.out.println(res);
        expertizelevels = res.readEntity(gexpertizelevels);
        System.out.println(expertizelevels);
        return expertizelevels;
    }

    public void setExpertizelevels(Collection<ExpertizeLevelTB> expertizelevels) {
        this.expertizelevels = expertizelevels;
    }
    
     public String AddExpertizeLevels(CDIBean bean)
    {
        client.AddExpertizeLevel(bean.getExpertize());
        return "expertize_level_list.jsf";
    }
    public String RemoveExpertizeLevels(String ExpertizeLevelID)
    {
       client.DeleteExpertizeLevel(ExpertizeLevelID);
       return "expertize_level_list.jsf"; 
    }
    public String EditExpertizeLevelByID(ExpertizeLevelTB e)
    {
        this.expertize = e.getLevels();
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "expertize_level_edit.jsf";
    }
    public String EditExpertizeLevel(CDIBean bean)
    {
        client.UpdateExpertizeLevel_JSON(expertizelevels, bean.getId(), bean.getExpertize());
        return "expertize_level_list.jsf?faces-redirect=true";
    } 
    
    public String fetchid()
    {
//        this.companyName = cname;
        //id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "expertize_level_list.jsf?faces-redirect=true";
    }
    
     public LoginTB GetLoginID() {
        LoginTB l = null;
        try {
            Connection con = getConnection();
            //String Email = request.getSession().getAttribute("username").toString();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from LoginTB where UserName=?");
            //ps.setInt(1, id);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                l = new LoginTB();
                l.setLoginID(rs.getInt("loginID"));
                l.setUserName(rs.getString("userName"));
                l.setPassword(rs.getString("password"));
                l.setUserID(rs.getString("userID"));
                
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return l;
    }
     
     public CompanyTB GetCompanyData() {
        CompanyTB c = null;
        try {
            Connection con = getConnection();
            //String Email = request.getSession().getAttribute("username").toString();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from CompanyTB where CompanyEmail=?");
            //ps.setInt(1, id);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c = new CompanyTB();
                this.CompanyID = rs.getString("CompanyID");
                this.companyName = rs.getString("CompanyName");
                this.companyOwnerName = rs.getString("CompanyOwnerName");
                this.companyContact = rs.getString("ContactNumber");
                this.companyEmail = rs.getString("CompanyEmail");
                this.companyStaff = rs.getString("CompanyStaff");
                this.stateID = rs.getString("StateID");
                this.cityID = rs.getString("CityID");
                CompanyLogo = String.valueOf(uploadedFile);
                this.CompanyLogo = rs.getString("CompanyLogo");
                this.companyPassword = rs.getString("CompanyOwnerPassword");
                c.setCompanyID(rs.getInt("CompanyID"));
                c.setCompanyName(rs.getString("CompanyName"));
                c.setCompanyOwnerName(rs.getString("CompanyOwnerName"));
                c.setCompanyEmail(rs.getString("CompanyEmail"));
                c.setCompanyOwnerPassword(rs.getString("CompanyOwnerPassword"));
                c.setCompanyStaff(rs.getInt("CompanyStaff"));
                c.setContactNumber(rs.getString("ContactNumber"));
                c.setCompanyLogo(rs.getString("CompanyLogo"));
               // c.setStateID(rs.getInt("StateID"));
                
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return c;
    }
     
    public FreelancerTB GetFreelancerData() {
        FreelancerTB f = null;
        try {
            Connection con = getConnection();
            //String Email = request.getSession().getAttribute("username").toString();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from FreelancerTB where Email=?");
            //ps.setInt(1, id);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                f = new FreelancerTB();
                this.FreelancerID = rs.getString("FreelancerID");
                this.AboutSelf = rs.getString("AboutSelf");
                this.Email = rs.getString("Email");
                this.College = rs.getString("College");
                this.FreelancerPassword = rs.getString("Password");
                FreelancerLogo = String.valueOf(uploadedFile);
                this.FreelancerLogo = rs.getString("ProfileImage");
                this.WeeklyAvailable = rs.getString("WeeklyAvailable");
//                this.isActive = rs.getString("IsActive");
                this.degreeID = rs.getString("DegreeID");
                this.categoryID = rs.getString("CategoryID");
                this.ExpertizeLevelID = rs.getString("ExpertizeLevelID");
                this.englishLevelID = rs.getString("EnglishLevelID");
                this.hourlyRateID = rs.getString("HourlyRateID");
                this.stateID = rs.getString("StateID");
                this.cityID = rs.getString("CityID");
                //this.CityName = rs.getString("CityName");
                f.setFreelancerID(rs.getInt("FreelancerID"));
                f.setAboutSelf(rs.getString("AboutSelf"));
                f.setCollege(rs.getString("College"));
                f.setEmail(rs.getString("Email"));
                f.setPassword(rs.getString("Password"));
                f.setWeeklyAvailable(rs.getString("WeeklyAvailable"));
                f.setProfileImage(rs.getString("ProfileImage"));
                //f.setCityID(rs.getObject("CityID",CityTB.class));
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return f;
    }
    
    public String ShowOnWorkingFreelancer()
    {
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "applied_freelancer.jsf";
    }

    public Collection<FreelancerTB> getOngoingfreelancer() {
        System.out.println("In get Ongoingfreelancer");
        res = client.GetWorkPostWiseOngoingFreelancer_XML(Response.class, id);
        System.out.println(res);
        Ongoingfreelancer = res.readEntity(gOngoingfreelancer);
        System.out.println(Ongoingfreelancer);
        return Ongoingfreelancer;
    }

    public void setOngoingfreelancer(Collection<FreelancerTB> Ongoingfreelancer) {
        this.Ongoingfreelancer = Ongoingfreelancer;
    }
    
    public Integer getCountAppliedonWorkPost() 
    {
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from WorkPostTB w,ApplyTB a,CompanyTB c where a.WorkPostID=w.WorkPostID and a.WorkStatus=? and c.CompanyID=? group by a.WorkPostID");
            ps.setString(1,"Applied");
            ps.setString(2,CompanyID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Total work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }

    public Collection<FreelancerTB> getAppliedworkfreelancer() {
        System.out.println("In get Appliedworkfreelancer");
        res = client.GetWorkPostWiseAppliedFreelancer_XML(Response.class, id);
        System.out.println(res);
        appliedworkfreelancer = res.readEntity(gappliedworkfreelancer);
        System.out.println(appliedworkfreelancer);
        return appliedworkfreelancer;
    }

    public void setAppliedworkfreelancer(Collection<FreelancerTB> appliedworkfreelancer) {
        
        this.appliedworkfreelancer = appliedworkfreelancer;
    }

    //manage bidder
    public Collection<FreelancerTB> getCompanyWiseAppliedFreelancer() {
        System.out.println("In get getCompanyWiseAppliedFreelancer");
        res = client.GetCompanyWiseAppliedFreelancer_XML(Response.class, CompanyID);
        System.out.println(res);
        CompanyWiseAppliedFreelancer = res.readEntity(gCompanyWiseAppliedFreelancer);
        System.out.println(CompanyWiseAppliedFreelancer);
        return CompanyWiseAppliedFreelancer;
    }

    public void setCompanyWiseAppliedFreelancer(Collection<FreelancerTB> CompanyWiseAppliedFreelancer) {
        this.CompanyWiseAppliedFreelancer = CompanyWiseAppliedFreelancer;
    }

    //WorkPostInFreelancer Side

    public Collection<WorkPostTB> getWorkpostwithcmpdetails() {
        System.out.println("In get getWorkpostwithcmpdetails");
        res = client.GetAllWorkPostWithCompanyDetails_XML(Response.class);
        System.out.println(res);
        workpostwithcmpdetails = res.readEntity(gworkpostwithcmpdetails);
        System.out.println(workpostwithcmpdetails);
        return workpostwithcmpdetails;
    }

    public void setWorkpostwithcmpdetails(Collection<WorkPostTB> workpostwithcmpdetails) {
        this.workpostwithcmpdetails = workpostwithcmpdetails;
    }
    
    
    
    //add apply table
    public String AddApplyTable(WorkPostTB w)
    {
        try{
            System.out.println("id-------------" + w.getWorkPostID());
            client.AddApplyTb("Applied",FreelancerID,w.getWorkPostID().toString());
            //client.AddBidding(bean.getId(), bean.GetLoginID().getUserID(), bean.getBiddingRate());
        }catch(Exception e){System.out.println("Error : "+e);}
        
        return "freelancer_dashboard.jsf?faces-redirect=true"; 
    }
    
    public String AddApplyTableTB(CDIBean bean)
    {
        try{
            System.out.println("id-------------" + bean.getId());
            client.AddApplyTb("Applied",bean.GetLoginID().getUserID(),bean.getId());
            client.AddBidding(bean.getId(), bean.GetLoginID().getUserID(), bean.getBiddingRate());
        }catch(Exception e){System.out.println("Error : "+e);}
        
        return "freelancer_dashboard.jsf?faces-redirect=true"; 
    }
    
    public String ChangeApplyToApprove(String aid)
    {
        client.ChangeStatusOfWork_JSON(applys, aid, "Approve");
        return "cmp_workpost_list.jsf";
    }
    public String ChangeApproveToConfirm(String aid)
    {
        client.ChangeStatusOfWork_JSON(applys, aid, "Confirm");
        return "freelancer_dashboard.jsf?faces-redirect=true";
    }
    public String ChangeComfirmToOngoing(String aid)
    {
        client.ChangeStatusOfWork_JSON(applys, aid, "Ongoing");
        return "cmp_workpost_list.jsf";
    }
    public String ChangeOngoingToCompleted(String aid)
    {
        client.ChangeStatusOfWork_JSON(applys, aid, "Completed");
        return "cmp_workpost_list.jsf";
    }

    public Collection<ApplyTB> getApplydata() {
        res = client.GetApplyID_XML(Response.class,"Applied", CompanyID);
        System.out.println(res);
        Applydata = res.readEntity(gApplydata);
        System.out.println(Applydata);
        return Applydata;
    }

    public void setApplydata(Collection<ApplyTB> Applydata) {
        this.Applydata = Applydata;
    }

    public Collection<ApplyTB> getApproveApplyData() {
        res = client.GetApplyIDFreelancer_XML(Response.class, "Approve", FreelancerID);
        System.out.println(res);
        ApproveApplyData = res.readEntity(gApproveApplyData);
        System.out.println(ApproveApplyData);
        return ApproveApplyData;
    }

    public void setApproveApplyData(Collection<ApplyTB> ApproveApplyData) {
        this.ApproveApplyData = ApproveApplyData;
    }

    public Collection<ApplyTB> getOngoingData() {
        res = client.GetApplyID_XML(Response.class,"Ongoing", CompanyID);
        System.out.println(res);
        OngoingData = res.readEntity(gOngoingData);
        System.out.println(OngoingData);
        return OngoingData;
    }

    public void setOngoingData(Collection<ApplyTB> OngoingData) {
        this.OngoingData = OngoingData;
    }

    public Collection<ApplyTB> getConfirmData() {
        res = client.GetApplyID_XML(Response.class,"Confirm", CompanyID);
        System.out.println(res);
        ConfirmData = res.readEntity(gConfirmData);
        System.out.println(ConfirmData);
        return ConfirmData;
    }

    public void setConfirmData(Collection<ApplyTB> ConfirmData) {
        this.ConfirmData = ConfirmData;
    }
    
    
    
    
    public List<ApplyTB> applyid() {
        List<ApplyTB> applyTBs = new ArrayList<ApplyTB>();
           // WorkPostTB a = null;
        try {
            Connection con = getConnection();
            //String Email = request.getSession().getAttribute("username").toString();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from ApplyTB a,FreelancerTB f,WorkPostTB w,CompanyTB c where a.WorkStatus='Applied' and a.FreelancerID=f.FreelancerID and w.WorkPostID=a.WorkPostID and w.CompanyID=? and f.freelancerID=?");
            
            ps.setString(1, CompanyID);
            ps.setString(2, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ApplyTB a = new ApplyTB();
               // a.setWorkPostID(rs.getInt("WorkPostID"));
               a.setApplyID(rs.getInt("ApplyID"));
                
                
                a.setWorkStatus(rs.getString("WorkStatus"));
                 applyTBs.add(a);

//                f.setFreelancerID(rs.getInt("FreelancerID"));
//                f.setAboutSelf(rs.getString("AboutSelf"));
//                f.setCollege(rs.getString("College"));
//                f.setEmail(rs.getString("Email"));
//                f.setPassword(rs.getString("Password"));
//                f.setWeeklyAvailable(rs.getString("WeeklyAvailable"));
//                f.setProfileImage(rs.getString("ProfileImage"));
//                this.hourlyRateID = rs.getString("HourlyRateID");
//                
//                f.setHourlyRateID(rs.getObject("HourlyRateID", Class<HourlyRateTB>));
                //f.setStateID(rs.getObject("StateTB"));
                
                
                
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return applyTBs;
    }
    
    public Collection<SkillTB> getFreeskills() {
        res = client.GetAllSkillFreelancer_XML(Response.class, id);
        System.out.println(res);
        freeskills = res.readEntity(gfreeskills);
        System.out.print(freeskills);
        return freeskills;
    }

    public void setFreeskills(Collection<SkillTB> freeskills) {
        this.freeskills = freeskills;
    }

    public Collection<SkillTB> getWorkskills() {
        res = client.GetAllWorkPostFreelancerSkill_XML(Response.class, id);
        System.out.println(res);
        workskills = res.readEntity(gworkskills);
        System.out.println(workskills);
        return workskills;
    }

    public void setWorkskills(Collection<SkillTB> workskills) {
        this.workskills = workskills;
    }

    public Collection<WorkPostTB> getWorkpostcmp() {
        System.out.println("IN work post cmp");
        res = client.GetAllWorkPostByCompany_XML(Response.class, CompanyID);
        System.out.println(res);
        workpostcmp = res.readEntity(gworkpostcmp);
        System.out.print(workpostcmp);
        return workpostcmp;
    }

    public void setWorkpostcmp(Collection<WorkPostTB> workpostcmp) {
        this.workpostcmp = workpostcmp;
    }
    
    

    //Apply 

    public String getWorkStatus() {
        return WorkStatus;
    }

    public void setWorkStatus(String WorkStatus) {
        this.WorkStatus = WorkStatus;
    }
    
    
    public ApplyTB GetWorkCompleted() {
        ApplyTB a = null;
        try {
            Connection con = getConnection();
            //String Email = request.getSession().getAttribute("username").toString();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from ApplyTB where WorkStatus='Completed' and FreelancerID=?");
            //ps.setInt(1, id);
            
            ps.setString(1, FreelancerID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a = new ApplyTB();
                a.setApplyID(rs.getInt("ApplyID"));
                a.setWorkStatus(rs.getString("workStatus"));
                
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return a;
    }
    
    public Collection<ApplyTB> getApplys() {
//        WorkStatus = "Completed";
//        res = client.GetAllApplyDataByStatus_XML(Response.class, WorkStatus);
//        System.out.println(res);
//        applys = res.readEntity(gapplys);
//        System.out.println(applys); 
        return applys;
    }

    public void setApplys(Collection<ApplyTB> applys) {
        this.applys = applys;
    }

    //Certificate
    
    public String getCertificateFile() {
        return CertificateFile;
    }

    public void setCertificateFile(String CertificateFile) {
        this.CertificateFile = CertificateFile;
    }
    
    private String filepath = "/home/brinda/SEM_8/JAVA_EJB/ProjectFolder/ProjectWebApp/web/resources/file";
    public String AddCertificates(CDIBean bean)
    {
        
        try (InputStream input = uploadedFile.getInputStream()) {
                        
			String fileName = FreelancerID+"_"+uploadedFile.getSubmittedFileName();
                        client.AddCertificate(fileName, bean.getFreelancerID());
	        Files.copy(input, new File(folder, fileName).toPath());
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
        
        return "freelancer_dashboard.jsf?faces-redirect=true";
    }

    
    public void download(String cfile) throws IOException {
    
    FacesContext fc = FacesContext.getCurrentInstance();

        ExternalContext ec = fc.getExternalContext();

        ec.responseReset();

        File file = new File("/home/brinda/SEM_8/JAVA_EJB/ProjectFolder/ProjectWebApp/web/resources/images/"+cfile);

        String fileName = file.getName();

        String contentType = ec.getMimeType(fileName);

        int contentLength = (int) file.length();

        ec.setResponseContentType(contentType);

        ec.setResponseHeader("Content-Disposition","attachment; filename=\"" + fileName +"\"");

        ec.setResponseContentLength(contentLength);

        OutputStream output = ec.getResponseOutputStream();

        Files.copy(file.toPath(), output);

        output.flush();

        output.close();

        fc.responseComplete();
  }
    
    public Collection<CertificateTB> getCertificates() {
        res = client.GetAllCertificate_XML(Response.class, id);
        System.out.println(res);
        certificates = res.readEntity(gcertificates);
        System.out.println(certificates);
        return certificates;
    }

    public void setCertificates(Collection<CertificateTB> certificates) {
        this.certificates = certificates;
    }

    //Company Review
    public String getCmpReviewMsg() {
        return cmpReviewMsg;
    }

    public void setCmpReviewMsg(String cmpReviewMsg) {
        this.cmpReviewMsg = cmpReviewMsg;
    }

    
//    public Collection<CompanyReviewTB> getCmpreviews() {
//        return cmpreviews;
//    }
//
//    public void setCmpreviews(Collection<CompanyReviewTB> cmpreviews) {
//        this.cmpreviews = cmpreviews;
//    }
    
     public ReviewTB GetFreelancerReviews() {
        ReviewTB c = null;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from ReviewTB where FreelancerID=?");
            ps.setString(1, FreelancerID);
            //ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c = new ReviewTB();
                c.setReviewID(rs.getInt("ReviewID"));
                c.setReview(rs.getString("Review"));
                
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return c;
    }
     
     
     
      //count for Freelancer
    public Integer GetAppliedWork() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from ApplyTB where WorkStatus='Applied' and FreelancerID=?");
            
            ps.setString(1, FreelancerID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Applied work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    public Integer GetOngoingWork() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from ApplyTB where WorkStatus='Ongoing' and FreelancerID=?");
            
            ps.setString(1, FreelancerID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Ongoing work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    public Integer GetCompletedWork() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from ApplyTB where WorkStatus='Completed' and FreelancerID=?");
           
            ps.setString(1, FreelancerID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Completed work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    public Integer GetApprovedWork() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from ApplyTB where WorkStatus='Approve' and FreelancerID=?");
           
            ps.setString(1, FreelancerID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Completed work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    
    public Integer GetFreelancerAppliedWork() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from ApplyTB where WorkStatus='Applied' and FreelancerID=?");
            
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Applied work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    public Integer GetFreelancerOngoingWork() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from ApplyTB where WorkStatus='Ongoing' and FreelancerID=?");
            
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Ongoing work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    public Integer GetFreelancerCompletedWork() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from ApplyTB where WorkStatus='Completed' and FreelancerID=?");
           
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Completed work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    
    //count for company
    public Integer GetOngoingWorkCmp() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from ApplyTB a,WorkPostTB w where a.WorkPostID=w.WorkPostID and a.WorkStatus='Ongoing' and w.CompanyID=?");
            
            ps.setString(1,CompanyID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Ongoing work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    public Integer GetCompletedWorkCmp() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from ApplyTB a,WorkPostTB w where a.WorkPostID=w.WorkPostID and a.WorkStatus='Completed' and w.CompanyID=?");
            
            ps.setString(1, CompanyID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Completed work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }

    public Integer GetCurrentWorkCmp() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from WorkPostTB where CompanyID=?");
            ps.setString(1, CompanyID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Completed work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    
    public Integer GetOngoingWorkCmpFromWorkDetails() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from ApplyTB a,WorkPostTB w where a.WorkPostID=w.WorkPostID and a.WorkStatus='Ongoing' and w.CompanyID=?");
            
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Ongoing work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    public Integer GetCompletedWorkCmpFromWorkDetails() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from ApplyTB a,WorkPostTB w where a.WorkPostID=w.WorkPostID and a.WorkStatus='Completed' and w.CompanyID=?");
            
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Completed work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }

    public Integer GetCurrentWorkCmpFromWorkDetails() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from WorkPostTB where CompanyID=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Completed work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    
    
    //count for Company Index
    public Integer GetWorkPosted() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from WorkPostTB where CompanyID=?");
            ps.setString(1, CompanyID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Total work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    public Integer GetAppliedFreelancers(){
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from ApplyTB,WorkPostTB where ApplyTB.WorkStatus='Applied' and ApplyTB.WorkPostID=WorkPostTB.WorkPostID and   WorkPostTB.CompanyID=? ");
            //ps.setString(1, "Applied");
            ps.setString(1, CompanyID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Total freelaners = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    
    //count for Freelancer Index
    public Integer GetWorkPostedFree() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from WorkPostTB");
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Total work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    public Integer GetTotalFreelancers(){
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from FreelancerTB");
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Total freelaners = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    
    public Integer GetTotalCompanys(){
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from CompanyTB");
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Total freelaners = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    
    //Freelancer Review

    public String getFreeReviewMsg() {
        return freeReviewMsg;
    }

    public void setFreeReviewMsg(String freeReviewMsg) {
        this.freeReviewMsg = freeReviewMsg;
    }

    public Collection<ReviewTB> getReviewTBs() {
        res = client.GetAllReview_XML(Response.class, id);
        System.out.println(res);
        reviewTBs = res.readEntity(greviewTBs);
        System.out.println(reviewTBs);
        return reviewTBs;
    }

    public void setReviewTBs(Collection<ReviewTB> reviewTBs) {
        this.reviewTBs = reviewTBs;
    }
    
    
    
    public String AddFreelancerReview(CDIBean bean)
    {
       client.AddReview(bean.getFreeReviewMsg(), bean.getId(), bean.GetLoginID().getUserID());
       return "cmp_workpost_list.jsf?faces-redirect=true"; 
    }
    
    //search 

    public Collection<WorkPostTB> getSearchByCname() {
        res = client.SerachByCompanyName_XML(Response.class, id);
        System.out.println(res);
        SearchByCname = res.readEntity(gSearchByCname);
        System.out.println(SearchByCname);
        return SearchByCname;
    }

    public void setSearchByCname(Collection<WorkPostTB> SearchByCname) {
        this.SearchByCname = SearchByCname;
    }
    
    public String gotoSearch(CDIBean bean)
    {
        id = bean.getCompanyName();
        //id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "freelancer_workpost_list.jsf";
    }

    public Collection<WorkPostTB> getSearchByCnameInCompList() {
        res = client.SerachByCompanyName_XML(Response.class, id);
        System.out.println(res);
        SearchByCnameInCompList = res.readEntity(gSearchByCnameInCompList);
        System.out.println(SearchByCnameInCompList);
        return SearchByCnameInCompList;
    }

    public void setSearchByCnameInCompList(Collection<WorkPostTB> SearchByCnameInCompList) {
        this.SearchByCnameInCompList = SearchByCnameInCompList;
    }
    
    
    
    public String gotoSearchInCompList(CDIBean bean)
    {
        id = bean.getCompanyName();
        //id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "freelancer_company_list.jsf";
    }

    public Collection<FreelancerTB> getSearchByFreeName() {
        res = client.SerachByFreelancerName_XML(Response.class, id);
        System.out.println(res);
        SearchByFreeName = res.readEntity(gSearchByFreeName);
        System.out.println(SearchByFreeName);
        return SearchByFreeName;
    }

    public void setSearchByFreeName(Collection<FreelancerTB> SearchByFreeName) {
        this.SearchByFreeName = SearchByFreeName;
    }

    public Collection<FreelancerTB> getSearchByFreeHourRate() {
        res = client.SerachByHourlyRate_XML(Response.class, Hour, id);
        System.out.println(res);
        SearchByFreeHourRate = res.readEntity(gSearchByFreeHourRate);
        System.out.println(SearchByFreeHourRate);
        return SearchByFreeHourRate;
    }

    public void setSearchByFreeHourRate(Collection<FreelancerTB> SearchByFreeHourRate) {
        this.SearchByFreeHourRate = SearchByFreeHourRate;
    }

    public Collection<WorkPostTB> getSearchByWorkPostHourRate() {
        res = client.SerachByHourlyRateFromWorkPost_XML(Response.class, Hour, id);
        System.out.println(res);
        SearchByWorkPostHourRate = res.readEntity(gSearchByWorkPostHourRate);
        System.out.println(SearchByWorkPostHourRate);
        return SearchByWorkPostHourRate;
    }

    public void setSearchByWorkPostHourRate(Collection<WorkPostTB> SearchByWorkPostHourRate) {
        this.SearchByWorkPostHourRate = SearchByWorkPostHourRate;
    }
    
    
    
    public String SearchByFreeEmail(CDIBean bean)
    {
        id = bean.getEmail();
        //id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "freelancer_list.jsf";
    }
    
    public String SearchByFreeHourRate(CDIBean bean)
    {
        id = bean.getHour();
        Hour = bean.getHour();
        //id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "freelancer_list.jsf";
    }
    
    //ADMIN SIDE Active-Block Freelancer

    public Collection<FreelancerTB> getActivefree() {
        res = client.GetAllFreelancerStatusIsOne_XML(Response.class);
        System.out.println(res);
        activefree = res.readEntity(gactivefree);
        System.out.println(activefree);
        return activefree;
    }

    public void setActivefree(Collection<FreelancerTB> activefree) {
        this.activefree = activefree;
    }

    public Collection<FreelancerTB> getBlockfree() {
        res = client.GetAllFreelancerStatusIsZero_XML(Response.class);
        System.out.println(res);
        blockfree = res.readEntity(gblockfree);
        System.out.println(blockfree);
        return blockfree;
    }

    public void setBlockfree(Collection<FreelancerTB> blockfree) {
        this.blockfree = blockfree;
    }
    
    //ADMIN SIDE Active-Block Company
    
    public Collection<CompanyTB> getActivecomp() {
        res = client.GetAllCompanyStatusIsOne_XML(Response.class);
        System.out.println(res);
        activecomp = res.readEntity(gactivecomp);
        System.out.println(activecomp);
        return activecomp;
    }

    public void setActivecomp(Collection<CompanyTB> activecomp) {
        this.activecomp = activecomp;
    }

    public Collection<CompanyTB> getBlockcomp() {
        res = client.GetAllCompanyStatusIsZero_XML(Response.class);
        System.out.println(res);
        blockcomp = res.readEntity(gblockcomp);
        System.out.println(blockcomp);
        return blockcomp;
    }

    
    public void setBlockcomp(Collection<CompanyTB> blockcomp) {
        this.blockcomp = blockcomp;
    }

    public Collection<ReviewTB> getReviewTBss() {
         res = client.GetAllReview_XML(Response.class, FreelancerID);
        System.out.println(res);
        reviewTBss = res.readEntity(greviewTBss);
        System.out.println(reviewTBss);
        return reviewTBss;
    }

    public void setReviewTBss(Collection<ReviewTB> reviewTBss) {
        this.reviewTBss = reviewTBss;
    }

     //freelancer side
    public String ShowOnAppliedFreelancerr()
    {
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "free_applied.jsf";
    }
    public String ShowOnApprovedFreelancerr()
    {
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "free_approved.jsf?faces-redirect=true";
    }
    public String ShowOnCompletedFreelancerr()
    {
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "free_completed.jsf";
    }
    public String ShowOngoingFreelancerr()
    {
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "free_ongoing.jsf";
    }
    
    //count for freelancer dashboard
    public Integer GetAppliedWorkFree() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from ApplyTB where WorkStatus=? and FreelancerID=?");
            ps.setString(1, "Applied");
            ps.setString(2, FreelancerID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Applied work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    public Integer GetOngoingWorkFree() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from ApplyTB where WorkStatus=? and FreelancerID=?");
            ps.setString(1, "Ongoing");
            ps.setString(2, FreelancerID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Ongoing work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    public Integer GetCompletedWorkFree() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from ApplyTB where WorkStatus=? and FreelancerID=?");
            ps.setString(1, "Completed");
            ps.setString(2, FreelancerID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Completed work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }

    public Collection<WorkPostTB> getApplybyfid() {
        res = client.GetAllApplyByFreelancerID_XML(Response.class, FreelancerID);
        System.out.println(res);
        applybyfid = res.readEntity(gapplybyfid);
        System.out.println(applybyfid); 
        return applybyfid;
    }

    public void setApplybyfid(Collection<WorkPostTB> applybyfid) {
        this.applybyfid = applybyfid;
    }

    public Collection<WorkPostTB> getApprovedbyfid() {
        res = client.GetAllApprovedByFreelancerID_XML(Response.class, FreelancerID);
        System.out.println(res);
        approvedbyfid = res.readEntity(gapprovedbyfid);
        System.out.println(approvedbyfid); 
        return approvedbyfid;
    }

    public void setApprovedbyfid(Collection<WorkPostTB> approvedbyfid) {
        this.approvedbyfid = approvedbyfid;
    }

    public Collection<WorkPostTB> getCompletedbyfid() {
        res = client.GetAllCompletedByFreelancerID_XML(Response.class, FreelancerID);
        System.out.println(res);
        completedbyfid = res.readEntity(gcompletedbyfid);
        System.out.println(completedbyfid); 
        return completedbyfid;
    }

    public void setCompletedbyfid(Collection<WorkPostTB> completedbyfid) {
        this.completedbyfid = completedbyfid;
    }

    public Collection<WorkPostTB> getOngoingbyfid() {
        res = client.GetAllOngoingByFreelancerID_XML(Response.class, FreelancerID);
        System.out.println(res);
        Ongoingbyfid = res.readEntity(gOngoingbyfid);
        System.out.println(Ongoingbyfid);
        return Ongoingbyfid;
    }

    public void setOngoingbyfid(Collection<WorkPostTB> Ongoingbyfid) {
        this.Ongoingbyfid = Ongoingbyfid;
    }
    
    
    //company side

    public Collection<FreelancerTB> getCompanyWiseOngoingFreelancer() {
        System.out.println("In get getCompanyWiseOngoingFreelancer");
        res = client.GetCompanyWiseOngoingFreelancer_XML(Response.class, id);
        System.out.println(res);
        companyWiseOngoingFreelancer = res.readEntity(gcompanyWiseOngoingFreelancer);
        System.out.println(companyWiseOngoingFreelancer);
        return companyWiseOngoingFreelancer;
    }

    public void setCompanyWiseOngoingFreelancer(Collection<FreelancerTB> companyWiseOngoingFreelancer) {
        this.companyWiseOngoingFreelancer = companyWiseOngoingFreelancer;
    }

    public Collection<FreelancerTB> getCompanyWiseCompletedFreelancer() {
        System.out.println("In get getCompanyWiseAppliedFreelancer");
        res = client.GetCompanyWiseCompletedFreelancer_XML(Response.class, id);
        System.out.println(res);
        companyWiseCompletedFreelancer = res.readEntity(gcompanyWiseCompletedFreelancer);
        System.out.println(companyWiseCompletedFreelancer);
        return companyWiseCompletedFreelancer;
    }

    public void setCompanyWiseCompletedFreelancer(Collection<FreelancerTB> companyWiseCompletedFreelancer) {
        this.companyWiseCompletedFreelancer = companyWiseCompletedFreelancer;
    }

    public Collection<WorkPostTB> getWorkpostcmpp() {
        System.out.println("IN work post cmp");
        res = client.GetAllWorkPostByCompany_XML(Response.class, id);
        System.out.println(res);
        workpostcmpp = res.readEntity(gworkpostcmpp);
        System.out.print(workpostcmpp);
        return workpostcmpp;
    }

    public void setWorkpostcmpp(Collection<WorkPostTB> workpostcmpp) {
        this.workpostcmpp = workpostcmpp;
    }
    
    public String ViewWorkPostDetails()
    {
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "workpost_details.jsf?faces-redirect=false";
    }

    public Collection<FreelancerTB> getApprovedworkfreelancer() {
        System.out.println("In get Approvedworkfreelancer");
        res = client.GetWorkPostWiseApproveFreelancer_XML(Response.class, id);
        System.out.println(res);
        approvedworkfreelancer = res.readEntity(gapprovedworkfreelancer);
        System.out.println(approvedworkfreelancer);
        return approvedworkfreelancer;
    }

    public void setApprovedworkfreelancer(Collection<FreelancerTB> approvedworkfreelancer) {
        this.approvedworkfreelancer = approvedworkfreelancer;
    }

    public Collection<FreelancerTB> getConfirmedworkfreelancer() {
        System.out.println("In get confirmedworkfreelancer");
        res = client.GetWorkPostWiseConfirmFreelancer_XML(Response.class, id);
        System.out.println(res);
        confirmedworkfreelancer = res.readEntity(gconfirmedworkfreelancer);
        System.out.println(confirmedworkfreelancer);
        return confirmedworkfreelancer;
    }

    public void setConfirmedworkfreelancer(Collection<FreelancerTB> confirmedworkfreelancer) {
        this.confirmedworkfreelancer = confirmedworkfreelancer;
    }

    public Collection<FreelancerTB> getCompletedworkfreelancer() {
        System.out.println("In get completedworkfreelancer");
        res = client.GetWorkPostWiseCompletedFreelancer_XML(Response.class, id);
        System.out.println(res);
        completedworkfreelancer = res.readEntity(gcompletedworkfreelancer);
        System.out.println(completedworkfreelancer);
        return completedworkfreelancer;
    }

    public void setCompletedworkfreelancer(Collection<FreelancerTB> completedworkfreelancer) {
        this.completedworkfreelancer = completedworkfreelancer;
    }
    
    public Integer OngoingPostFromFree() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from ApplyTB a,WorkPostTB w where a.WorkPostID=w.WorkPostID and a.WorkStatus='Ongoing' and w.CompanyID=?");
            
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Ongoing work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    public Integer CompeletedPostFromFree() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from ApplyTB a,WorkPostTB w where a.WorkPostID=w.WorkPostID and a.WorkStatus='Completed' and w.CompanyID=?");
            
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Completed work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }

    public Integer CurrentPostFromFree() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from WorkPostTB where CompanyID=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Completed work post = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }
    
    //company side manage freelancer
    
    //company side
    
    public String ShowOnApprovedFreelancer()
    {
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "approved_freelancer.jsf";
    }
    public String ShowOnConfirmFreelancer()
    {
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "confirmed_freelancer.jsf";
    }
    public String ShowOngoingFreelancer()
    {
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "working_freelancer.jsf";
    }
    public String ShowCompletedFreelancer()
    {
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
        return "compeleted_project.jsf";
    }

    public Collection<SkillTB> getFreeskillbyfid() {
         res = client.GetAllSkillFreelancer_XML(Response.class, FreelancerID);
        System.out.println(res);
        freeskillbyfid = res.readEntity(gfreeskillbyfid);
        System.out.print(freeskillbyfid);
        return freeskillbyfid;
    }

    public void setFreeskillbyfid(Collection<SkillTB> freeskillbyfid) {
        this.freeskillbyfid = freeskillbyfid;
    }

    public Collection<CertificateTB> getCertificatebyfid() {
        res = client.GetAllCertificate_XML(Response.class, FreelancerID);
        System.out.println(res);
        certificatebyfid = res.readEntity(gcertificatebyfid);
        System.out.println(certificatebyfid);
        return certificatebyfid;
    }

    public void setCertificatebyfid(Collection<CertificateTB> certificatebyfid) {
        this.certificatebyfid = certificatebyfid;
    }

    public String getBiddingRate() {
        return BiddingRate;
    }

    public void setBiddingRate(String BiddingRate) {
        this.BiddingRate = BiddingRate;
    }
    
    
    
    public String AddApplyTable(CDIBean bean)
    {
        try{
            client.AddApplyTb("Applied",bean.GetLoginID().getUserID(),bean.getId());
            //client.AddBidding(bean.getId(), bean.GetLoginID().getUserID(), bean.getBiddingRate());
        }catch(Exception e){System.out.println("Error : "+e);}
        
        return "workpost_list.jsf?faces-redirect=true"; 
    }

    public Collection<BiddingTB> getBiddingbyworkpost() {
        res = client.GetAllBiddingByWorkPostID_XML( Response.class, id);
        System.out.println(res);
        biddingbyworkpost = res.readEntity(gbiddingbyworkpost);
        System.out.println(biddingbyworkpost);
        return biddingbyworkpost;
    }

    public void setBiddingbyworkpost(Collection<BiddingTB> biddingbyworkpost) {
        this.biddingbyworkpost = biddingbyworkpost;
    }

    
    
    
    
    public CDIBean() {
        System.out.println("Hello BookCDI Bean ");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        String token="";
        //String UserName = "";

        token = request.getSession().getAttribute("token").toString();
        username = request.getSession().getAttribute("username").toString();
        //String LoginID = request.getSession().getAttribute("LoginID").toString();
        System.out.println("==================Token="+token);
        System.out.println("*****************User Name ="+username);
        //System.out.println("Login ID ="+LoginID);
        
        //String token1 = request.getHeader("Authorization").substring("Bearer ".length());
        // System.out.println("Token="+token);
        client = new FreelancerClient(token);
        pb = new Pbkdf2PasswordHashImpl();
        
        // brc = new BookRestClient(username, password);
        freelancers = new ArrayList<FreelancerTB>();
        gfreelancers = new GenericType<Collection<FreelancerTB>>(){};
        
        appliedworkfreelancer = new ArrayList<FreelancerTB>();
        gappliedworkfreelancer = new GenericType<Collection<FreelancerTB>>(){};
        
        Ongoingfreelancer = new ArrayList<FreelancerTB>();
        gOngoingfreelancer = new GenericType<Collection<FreelancerTB>>(){};
        
        CompanyWiseAppliedFreelancer = new ArrayList<FreelancerTB>();
        gCompanyWiseAppliedFreelancer = new GenericType<Collection<FreelancerTB>>(){};
        
        projectScopes = new ArrayList<ProjectScopeTB>();
        gprojectScopes = new GenericType<Collection<ProjectScopeTB>>(){};
        
        states = new ArrayList<StateTB>();
        gstates =  new GenericType<Collection<StateTB>>(){};
        
        hourlyRates =  new ArrayList<HourlyRateTB>();
        ghourlyRates = new GenericType<Collection<HourlyRateTB>>(){};
        
        cities = new ArrayList<CityTB>();
        gcities = new GenericType<Collection<CityTB>>(){};
        
        categories = new ArrayList<CategoryTB>();
        gcategories = new GenericType<Collection<CategoryTB>>(){};
        
        degrees = new ArrayList<DegreeTB>();
        gdegrees = new GenericType<Collection<DegreeTB>>(){};
        
        englishlevels = new ArrayList<EnglsihLevelTB>();
        genglishlevels = new GenericType<Collection<EnglsihLevelTB>>(){};
        
        expertizelevels = new ArrayList<ExpertizeLevelTB>();
        gexpertizelevels = new GenericType<Collection<ExpertizeLevelTB>>(){};
        
        skills = new ArrayList<SkillTB>();
        gskills = new GenericType<Collection<SkillTB>>(){};
        
        companys = new ArrayList<CompanyTB>();
        gcompanys = new GenericType<Collection<CompanyTB>>(){};
        
        workposts = new ArrayList<WorkPostTB>();
        gworkposts = new GenericType<Collection<WorkPostTB>>(){};
        
        freeskills = new ArrayList<SkillTB>(); 
        gfreeskills = new GenericType<Collection<SkillTB>>(){};
        
        workskills = new ArrayList<SkillTB>(); 
        gworkskills = new GenericType<Collection<SkillTB>>(){};
        
        applys = new ArrayList<ApplyTB>(); 
        gapplys = new GenericType<Collection<ApplyTB>>(){};
        
        certificates = new ArrayList<CertificateTB>();
        gcertificates = new GenericType<Collection<CertificateTB>>(){};
        
//        cmpreviews = new ArrayList<CompanyReviewTB>();
//        gcmpreviews = new GenericType<Collection<CompanyReviewTB>>(){};
        
        reviewTBs = new ArrayList<ReviewTB>();
        greviewTBs = new GenericType<Collection<ReviewTB>>(){};
        
        

        workpostcmp = new ArrayList<WorkPostTB>();
        gworkpostcmp = new GenericType<Collection<WorkPostTB>>(){};
        
        workpostwithcmpdetails = new ArrayList<WorkPostTB>();
        gworkpostwithcmpdetails = new GenericType<Collection<WorkPostTB>>(){};
        
        SearchByCname = new ArrayList<WorkPostTB>();
        gSearchByCname = new GenericType<Collection<WorkPostTB>>(){};
        
        SearchByCnameInCompList = new ArrayList<WorkPostTB>();
        gSearchByCnameInCompList = new GenericType<Collection<WorkPostTB>>(){};
        
        activecomp = new ArrayList<CompanyTB>();
        gactivecomp = new GenericType<Collection<CompanyTB>>(){};
        
        blockcomp = new ArrayList<CompanyTB>();
        gblockcomp = new GenericType<Collection<CompanyTB>>(){};
        
        activefree = new ArrayList<FreelancerTB>();
        gactivefree = new GenericType<Collection<FreelancerTB>>(){};
        
        blockfree = new ArrayList<FreelancerTB>();
        gblockfree = new GenericType<Collection<FreelancerTB>>(){};
        
        CompWorkPost = new ArrayList<WorkPostTB>();
        gCompWorkPost = new GenericType<Collection<WorkPostTB>>(){};
        
        reviewTBss = new ArrayList<ReviewTB>();
        greviewTBss = new GenericType<Collection<ReviewTB>>(){};
        
        applybyfid = new ArrayList<WorkPostTB>(); 
        gapplybyfid = new GenericType<Collection<WorkPostTB>>(){};
        
        approvedbyfid = new ArrayList<WorkPostTB>(); 
        gapprovedbyfid = new GenericType<Collection<WorkPostTB>>(){};
        
        completedbyfid = new ArrayList<WorkPostTB>(); 
        gcompletedbyfid = new GenericType<Collection<WorkPostTB>>(){};
        
        Ongoingbyfid = new ArrayList<WorkPostTB>(); 
        gOngoingbyfid = new GenericType<Collection<WorkPostTB>>(){};
        
        companyWiseOngoingFreelancer = new ArrayList<FreelancerTB>();
        gcompanyWiseOngoingFreelancer = new GenericType<Collection<FreelancerTB>>(){};
        
        companyWiseCompletedFreelancer = new ArrayList<FreelancerTB>();
        gcompanyWiseCompletedFreelancer = new GenericType<Collection<FreelancerTB>>(){};
        
        workpostcmpp = new ArrayList<WorkPostTB>();
        gworkpostcmpp = new GenericType<Collection<WorkPostTB>>(){};
        
        approvedworkfreelancer = new ArrayList<FreelancerTB>();
        gapprovedworkfreelancer = new GenericType<Collection<FreelancerTB>>(){};
        
        confirmedworkfreelancer = new ArrayList<FreelancerTB>();
        gconfirmedworkfreelancer = new GenericType<Collection<FreelancerTB>>(){}; 
        
        completedworkfreelancer = new ArrayList<FreelancerTB>();
        gcompletedworkfreelancer = new GenericType<Collection<FreelancerTB>>(){};
        
        SearchByFreeName = new ArrayList<FreelancerTB>();
        gSearchByFreeName = new GenericType<Collection<FreelancerTB>>(){};
        
        SearchByFreeHourRate = new ArrayList<FreelancerTB>();
        gSearchByFreeHourRate = new GenericType<Collection<FreelancerTB>>(){};
        
        SearchByWorkPostHourRate = new ArrayList<WorkPostTB>();
        gSearchByWorkPostHourRate = new GenericType<Collection<WorkPostTB>>(){};
        
        Applydata = new ArrayList<ApplyTB>();
        gApplydata = new GenericType<Collection<ApplyTB>>(){};
        
        ApproveApplyData = new ArrayList<ApplyTB>();
        gApproveApplyData = new GenericType<Collection<ApplyTB>>(){};
        
        OngoingData = new ArrayList<ApplyTB>();
        gOngoingData = new GenericType<Collection<ApplyTB>>(){};
        
        ConfirmData = new ArrayList<ApplyTB>();
        gConfirmData = new GenericType<Collection<ApplyTB>>(){};
        
        certificatebyfid = new ArrayList<CertificateTB>();
        gcertificatebyfid = new GenericType<Collection<CertificateTB>>(){};
        
        freeskillbyfid = new ArrayList<SkillTB>(); 
        gfreeskillbyfid = new GenericType<Collection<SkillTB>>(){};
        
        biddingbyworkpost = new ArrayList<BiddingTB>(); 
        gbiddingbyworkpost = new GenericType<Collection<BiddingTB>>(){};
    }
   
    
}
