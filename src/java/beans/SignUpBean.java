/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Client.FreelancerClient;
import Entity.CategoryTB;
import Entity.CityTB;
import Entity.CompanyTB;
import Entity.DegreeTB;
import Entity.EnglsihLevelTB;
import Entity.ExpertizeLevelTB;
import Entity.FreelancerTB;
import Entity.HourlyRateTB;
import Entity.ProjectScopeTB;
import Entity.StateTB;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javafx.geometry.Side;
import javax.enterprise.context.*;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author brinda
 */
@Named(value = "SignUpBean")
@ApplicationScoped
public class SignUpBean {
    
    FreelancerClient client;
    Pbkdf2PasswordHashImpl pb;
    Response res;
    
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
    
    Collection<CompanyTB> companys;
    GenericType<Collection<CompanyTB>> gcompanys;
    
    Collection<StateTB> states;
    GenericType<Collection<StateTB>> gstates;
    
    Collection<CityTB> cities;
    GenericType<Collection<CityTB>> gcities;
    
    Collection<FreelancerTB> freelancers;
    GenericType<Collection<FreelancerTB>> gfreelancers;
    
    Collection<HourlyRateTB> hourlyRates;
    GenericType<Collection<HourlyRateTB>> ghourlyRates;
    
    Collection<ProjectScopeTB> projectScopes;
    GenericType<Collection<ProjectScopeTB>> gprojectScopes;
    
    Collection<CategoryTB> categories;
    GenericType<Collection<CategoryTB>> gcategories;
    
    Collection<DegreeTB> degrees;
    GenericType<Collection<DegreeTB>> gdegrees;
    
    Collection<EnglsihLevelTB> englishlevels;
    GenericType<Collection<EnglsihLevelTB>> genglishlevels;
    
    Collection<ExpertizeLevelTB> expertizelevels;
    GenericType<Collection<ExpertizeLevelTB>> gexpertizelevels;
    
    private Part uploadedFile;
	private String folder = "/home/brinda/SEM_8/JAVA_EJB/ProjectFolder/ProjectWebApp/web/resources/images";

    public FreelancerClient getClient() {
        return client;
    }

    public void setClient(FreelancerClient client) {
        this.client = client;
    }

    public Pbkdf2PasswordHashImpl getPb() {
        return pb;
    }

    public void setPb(Pbkdf2PasswordHashImpl pb) {
        this.pb = pb;
    }

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

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateID() {
        return stateID;
    }

    public void setStateID(String stateID) {
        this.stateID = stateID;
    }

    public Collection<StateTB> getStates() {
        res = client.GetAllState_XML(Response.class);
        System.out.println(res);
        states = res.readEntity(gstates);
        
        return states;
    }

    public void setStates(Collection<StateTB> states) {
        this.states = states;
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

    public String getFreelancerPassword() {
        return FreelancerPassword;
    }

    public void setFreelancerPassword(String FreelancerPassword) {
        this.FreelancerPassword = FreelancerPassword;
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

    
        
        
        
        public String AddCompany(SignUpBean bean)
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
        
         public String AddFreelancer(SignUpBean bean)
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
        return "login.jsf?faces-redirect=true";
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
        
        public SignUpBean(){
            System.out.println("Hello SignUpBean Bean ");
          HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       
        
        client = new FreelancerClient();
        pb = new Pbkdf2PasswordHashImpl();
        
        companys = new ArrayList<CompanyTB>();
        gcompanys = new GenericType<Collection<CompanyTB>>(){};
        
        states = new ArrayList<StateTB>();
        gstates =  new GenericType<Collection<StateTB>>(){};
        
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
        
        projectScopes = new ArrayList<ProjectScopeTB>();
        gprojectScopes = new GenericType<Collection<ProjectScopeTB>>(){};
        
        hourlyRates =  new ArrayList<HourlyRateTB>();
        ghourlyRates = new GenericType<Collection<HourlyRateTB>>(){};
        
        }
}
