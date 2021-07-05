/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;


import Entity.*;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author brinda
 */
@Stateless
public class FreelancerPortalBean implements FreelancerPortalBeanLocal {
    
    @PersistenceContext(unitName = "FreelancerPU")
    EntityManager em;
    
    @Override
    public Collection<FreelancerTB> GetAllFreelancer() {
        Collection<FreelancerTB> freelancers = em.createNamedQuery("FreelancerTB.findAll")
                .getResultList();
        return freelancers;
    }


    @Override
    public void AddFreelancer(String email, String password, String college, String profileImage, String aboutSelf, String weeklyAvailable, Integer categoryID, Integer stateID, Integer cityID, Integer degreeID, Integer englishLevelID, Integer expertizeLevelID, Integer hourlyRateID,Integer isActive) {
       
        CategoryTB cateID = em.find(CategoryTB.class, categoryID);
        DegreeTB did = em.find(DegreeTB.class, degreeID);
        StateTB sid = em.find(StateTB.class, stateID);
        CityTB cid = em.find(CityTB.class, cityID);
        EnglsihLevelTB englishid = em.find(EnglsihLevelTB.class, englishLevelID);
        ExpertizeLevelTB expertid = em.find(ExpertizeLevelTB.class, expertizeLevelID);
        HourlyRateTB hourid = em.find(HourlyRateTB.class, hourlyRateID);

          
        Collection<FreelancerTB> freelancers = cateID.getFreelancerTBCollection();
        //Collection<FreelancerTB> freelancers = did.getFreelancerTBCollection();
        
        
        FreelancerTB freelancer = new FreelancerTB(email, password, college, profileImage, aboutSelf, weeklyAvailable, isActive);
        freelancers.add(freelancer);
        freelancer.setCategoryID(cateID);
        freelancer.setDegreeID(did);
        freelancer.setStateID(sid);
        freelancer.setCityID(cid);
        freelancer.setEnglishLevelID(englishid);
        freelancer.setExpertizeLevelID(expertid);
        freelancer.setHourlyRateID(hourid);
        
        cateID.setFreelancerTBCollection(freelancers);
        did.setFreelancerTBCollection(freelancers);
        sid.setFreelancerTBCollection(freelancers);
        cid.setFreelancerTBCollection(freelancers);
        englishid.setFreelancerTBCollection(freelancers);
        expertid.setFreelancerTBCollection(freelancers);
        hourid.setFreelancerTBCollection(freelancers);
        
        em.persist(freelancer);
        em.merge(cateID);
        em.merge(did);
        em.merge(sid);
        em.merge(cid);
        em.merge(englishid);
        em.merge(expertid);
        em.merge(hourid);
        
        

    }
    
    @Override
    public void DeleteFreelancer(Integer FreelancerID, Integer categoryID, Integer stateID, Integer cityID, Integer degreeID, Integer englishLevelID, Integer expertizeLevelID, Integer hourlyRateID) {

        FreelancerTB freelancer = em.find(FreelancerTB.class, FreelancerID);
        CategoryTB cateID = em.find(CategoryTB.class, categoryID);
        DegreeTB did = em.find(DegreeTB.class, degreeID);
        StateTB sid = em.find(StateTB.class, stateID);
        CityTB cid = em.find(CityTB.class, cityID);
        EnglsihLevelTB englishid = em.find(EnglsihLevelTB.class, englishLevelID);
        ExpertizeLevelTB expertid = em.find(ExpertizeLevelTB.class, expertizeLevelID);
        HourlyRateTB hourid = em.find(HourlyRateTB.class, hourlyRateID);
        
        Collection<FreelancerTB> cateIDf = cateID.getFreelancerTBCollection();
        Collection<FreelancerTB> didf = did.getFreelancerTBCollection();
        Collection<FreelancerTB> sidf = sid.getFreelancerTBCollection();
        Collection<FreelancerTB> cidf = cid.getFreelancerTBCollection();
        Collection<FreelancerTB> englishidf = englishid.getFreelancerTBCollection();
        Collection<FreelancerTB> expertidf = expertid.getFreelancerTBCollection();
        Collection<FreelancerTB> houridf = hourid.getFreelancerTBCollection();
        
        cateIDf.remove(freelancer);
        didf.remove(freelancer);
        sidf.remove(freelancer);
        cidf.remove(freelancer);
        englishidf.remove(freelancer);
        expertidf.remove(freelancer);
        houridf.remove(freelancer);
        
        cateID.setFreelancerTBCollection(cateIDf);
        did.setFreelancerTBCollection(didf);
        sid.setFreelancerTBCollection(sidf);
        cid.setFreelancerTBCollection(cidf);
        englishid.setFreelancerTBCollection(englishidf);
        expertid.setFreelancerTBCollection(expertidf);
        hourid.setFreelancerTBCollection(houridf);
        
        em.remove(freelancer);
        
        em.merge(cateID);
        em.merge(did);
        em.merge(sid);
        em.merge(cid);
        em.merge(englishid);
        em.merge(expertid);
        em.merge(hourid);
    }
    
    @Override
    public void UpdateFreelancer(Integer FreelancerID, String email, String password, String college, String profileImage, String aboutSelf, String weeklyAvailable, Integer categoryID, Integer stateID, Integer cityID, Integer degreeID, Integer englishLevelID, Integer expertizeLevelID, Integer hourlyRateID,Integer isActive) {

        FreelancerTB freelancer = em.find(FreelancerTB.class, FreelancerID);
        CategoryTB cateID = em.find(CategoryTB.class, categoryID);
        DegreeTB did = em.find(DegreeTB.class, degreeID);
        StateTB sid = em.find(StateTB.class, stateID);
        CityTB cid = em.find(CityTB.class, cityID);
        EnglsihLevelTB englishid = em.find(EnglsihLevelTB.class, englishLevelID);
        ExpertizeLevelTB expertid = em.find(ExpertizeLevelTB.class, expertizeLevelID);
        HourlyRateTB hourid = em.find(HourlyRateTB.class, hourlyRateID);
        
        Collection<FreelancerTB> cateIDf = cateID.getFreelancerTBCollection();
        Collection<FreelancerTB> didf = did.getFreelancerTBCollection();
        Collection<FreelancerTB> sidf = sid.getFreelancerTBCollection();
        Collection<FreelancerTB> cidf = cid.getFreelancerTBCollection();
        Collection<FreelancerTB> englishidf = englishid.getFreelancerTBCollection();
        Collection<FreelancerTB> expertidf = expertid.getFreelancerTBCollection();
        Collection<FreelancerTB> houridf = hourid.getFreelancerTBCollection();
        
        freelancer.setCategoryID(cateID);
        freelancer.setDegreeID(did);
        freelancer.setStateID(sid);
        freelancer.setCityID(cid);
        freelancer.setEnglishLevelID(englishid);
        freelancer.setExpertizeLevelID(expertid);
        freelancer.setHourlyRateID(hourid);
        freelancer.setEmail(email);
        freelancer.setPassword(password);
        freelancer.setAboutSelf(aboutSelf);
        freelancer.setCollege(college);
        freelancer.setProfileImage(profileImage);
        freelancer.setWeeklyAvailable(weeklyAvailable);
        
        
        cateID.setFreelancerTBCollection(cateIDf);
        did.setFreelancerTBCollection(didf);
        sid.setFreelancerTBCollection(sidf);
        cid.setFreelancerTBCollection(cidf);
        englishid.setFreelancerTBCollection(englishidf);
        expertid.setFreelancerTBCollection(expertidf);
        hourid.setFreelancerTBCollection(houridf);
        
        em.merge(freelancer);
        

    }

    @Override
    public Collection<CompanyTB> GetAllCompany() {
        Collection<CompanyTB> companys = em.createNamedQuery("CompanyTB.findAll").getResultList();
        return companys;
    }

    @Override
    public Collection<WorkPostTB> GetAllWorkPost() {
        Collection<WorkPostTB> workPosts = em.createNamedQuery("WorkPostTB.findAll").getResultList();
        return workPosts;
    }

   
    
    @Override
    public Collection<StateTB> GetAllState() {
        Collection<StateTB> states = em.createNamedQuery("StateTB.findAll").getResultList();
        return states;
    }

    @Override
    public void AddState(String StateName) {
        StateTB state = new StateTB(StateName);
        em.persist(state);
    }

    @Override
    public void UpdateState(Integer StateID, String StateName) {
        StateTB state = em.find(StateTB.class, StateID);
        state.setStateName(StateName);
        em.merge(state);
    }

    @Override
    public void DeleteState(Integer StateID) {
        StateTB state = em.find(StateTB.class, StateID);
        em.remove(state);
    }

    @Override
    public Collection<CityTB> GetAllStateWiseCity(Integer StateID) {
        StateTB state = em.find(StateTB.class, StateID);
        return state.getCityTBCollection();
    }

    @Override
    public void AddStateWiseCity(String CityName, Integer StateID) {
        StateTB state = em.find(StateTB.class, StateID);
        Collection<CityTB> cities = state.getCityTBCollection();
        CityTB city = new CityTB(CityName);
        cities.add(city);
        city.setStateID(state);
        state.setCityTBCollection(cities);
        em.persist(city);
        em.merge(state);
    }

    @Override
    public void UpdateStateWiseCity(Integer CityID, String CityName, Integer StateID) {
       StateTB state = em.find(StateTB.class, StateID);
       CityTB city = em.find(CityTB.class, CityID);
       
       Collection<CityTB> cities = state.getCityTBCollection();
       
           city.setCityName(CityName);
           city.setStateID(state);
           state.setCityTBCollection(cities);
           em.merge(city);
           em.merge(state);
           
       
    }

    @Override
    public void DeleteStateWiseCity(Integer CityID, Integer StateID) {
        StateTB state = em.find(StateTB.class, StateID);
        CityTB city = em.find(CityTB.class, CityID);
        
        Collection<CityTB> cities = state.getCityTBCollection();
        if(cities.contains(city))
        {
            cities.remove(city);
            state.setCityTBCollection(cities);
            em.remove(city);
            em.merge(state);
        }
    }

    @Override
    public Collection<ProjectScopeTB> GetAllProjectScope() {
        Collection<ProjectScopeTB> projectScopes = em.createNamedQuery("ProjectScopeTB.findAll")
                .getResultList();
        return projectScopes;
    }

    @Override
    public void AddProjectScope(String Scope) {
        ProjectScopeTB projectScope = new ProjectScopeTB(Scope);
        em.persist(projectScope);
    }

    @Override
    public void UpdateProjectScope(Integer ProjectScopeID, String Scope) {
        ProjectScopeTB projectScope = em.find(ProjectScopeTB.class, ProjectScopeID);
        projectScope.setScope(Scope);
        em.merge(projectScope);
    }

    @Override
    public void DeleteProjectScope(Integer ProjectScopeID) {
        ProjectScopeTB projectScope = em.find(ProjectScopeTB.class, ProjectScopeID);
        em.remove(projectScope);
    }

    @Override
    public Collection<ExpertizeLevelTB> GetAllExpertizeLevel() {
        Collection<ExpertizeLevelTB> expertizeLevels = 
                em.createNamedQuery("ExpertizeLevelTB.findAll").getResultList();
        return expertizeLevels;
    }

    @Override
    public void AddExpertizeLevel(String Levels) {
        ExpertizeLevelTB expertizeLevel = new ExpertizeLevelTB(Levels);
        em.persist(expertizeLevel);
    }

    @Override
    public void UpdateExpertizeLevel(Integer ExpertizeLevelID, String Levels) {
        ExpertizeLevelTB expertizeLevel = em.find(ExpertizeLevelTB.class, ExpertizeLevelID);
        expertizeLevel.setLevels(Levels);
        em.merge(expertizeLevel);
    }

    @Override
    public void DeleteExpertizeLevel(Integer ExpertizeLevelID) {
        ExpertizeLevelTB expertizeLevel = em.find(ExpertizeLevelTB.class, ExpertizeLevelID);
        em.remove(expertizeLevel);
    }

    @Override
    public Collection<HourlyRateTB> GetAllHourlyRate() {
        Collection<HourlyRateTB> hourlyRates = em.createNamedQuery("HourlyRateTB.findAll")
                .getResultList();
        return hourlyRates;
    }

    @Override
    public void AddHourlyRate(String rate) {
        HourlyRateTB hourlyRate = new HourlyRateTB(rate);
        em.persist(hourlyRate);
    }

    @Override
    public void UpdateHourlyRate(Integer HourlyRateID, String rate) {
        HourlyRateTB hourlyRates = em.find(HourlyRateTB.class, HourlyRateID);
        hourlyRates.setRate(rate);
        em.merge(hourlyRates);
    }

    @Override
    public void DeleteHourlyRate(Integer HourlyRateID) {
        HourlyRateTB hourlyRate = em.find(HourlyRateTB.class, HourlyRateID);
        em.remove(hourlyRate);
    }

    @Override
    public Collection<EnglsihLevelTB> GetAllEnglishLevel() {
        Collection<EnglsihLevelTB> englsihLevels = 
                em.createNamedQuery("EnglsihLevelTB.findAll").getResultList();
        return englsihLevels;
    }

    @Override
    public void AddEnglsihLevel(String englishLevels) {
        EnglsihLevelTB  englsihLevel = new EnglsihLevelTB(englishLevels);
        em.persist(englsihLevel);
    }

    @Override
    public void UpdateEnglsihLevel(Integer EnglishLevelID, String englishLevels) {
        EnglsihLevelTB  englsihLevel = em.find(EnglsihLevelTB.class, EnglishLevelID);
        englsihLevel.setEnglishLevels(englishLevels);
        em.merge(englsihLevel);
    }

    @Override
    public void DeleteEnglsihLevel(Integer EnglishLevelID) {
        EnglsihLevelTB englsihLevel = em.find(EnglsihLevelTB.class, EnglishLevelID);
        em.remove(englsihLevel);
    }

    @Override
    public Collection<DegreeTB> GetAllDegree() {
        Collection<DegreeTB> degrees = em.createNamedQuery("DegreeTB.findAll").getResultList();
        return degrees;
    }

    @Override
    public void AddDegree(String degree) {
         DegreeTB  d = new DegreeTB(degree);
        em.persist(d);
    }

    @Override
    public void UpdateDegree(Integer DegreeID, String degree) {
        DegreeTB d = em.find(DegreeTB.class, DegreeID);
        d.setDegree(degree);
        em.merge(d);
    }

    @Override
    public void DeleteDegree(Integer DegreeID) {
        DegreeTB d = em.find(DegreeTB.class, DegreeID);
        em.remove(d);
    }

    @Override
    public Collection<SkillTB> GetAllSkill() {
        Collection<SkillTB> skills = em.createNamedQuery("SkillTB.findAll").getResultList();
        return skills;
    }

   @Override
    public void AddSkill(String skills, Integer CategoryID) {
        CategoryTB category = em.find(CategoryTB.class, CategoryID);
        Collection<SkillTB> skillTBs = category.getSkillTBCollection();
        SkillTB skill = new SkillTB(skills);
        skillTBs.add(skill);
        skill.setCategoryID(category);
        category.setSkillTBCollection(skillTBs);
        em.persist(skill);
        em.merge(category);
    }


    @Override
    public void UpdateSkill(Integer SkillID, String skills,Integer CategoryID) {
        SkillTB skill = em.find(SkillTB.class, SkillID);
        CategoryTB category = em.find(CategoryTB.class, CategoryID);
        skill.setSkills(skills);
        skill.setCategoryID(category);
        em.merge(skill);
    }

    @Override
    public void DeleteSkill(Integer SkillID) {
        SkillTB skill = em.find(SkillTB.class, SkillID);
        em.remove(skill);
    }

    @Override
    public Collection<CategoryTB> GetAllCategory() {
        Collection<CategoryTB> categorys = em.createNamedQuery("CategoryTB.findAll").getResultList();
        return categorys;
    }

    @Override
    public void AddCategory(String categoryName) {
        CategoryTB category = new CategoryTB(categoryName);
        em.persist(category);
    }

    @Override
    public void UpdateCategory(Integer CategoryID, String categoryName) {
        CategoryTB category = em.find(CategoryTB.class, CategoryID);
        category.setCategoryName(categoryName);
        em.merge(category);
    }

    @Override
    public void DeleteCategory(Integer CategoryID) {
        CategoryTB category = em.find(CategoryTB.class, CategoryID);
        em.remove(category);
    }

    @Override
    public Collection<CertificateTB> GetAllCertificate(Integer FreelancerID) {
        FreelancerTB freelancer = em.find(FreelancerTB.class, FreelancerID);
        return freelancer.getCertificateTBCollection();
    }

    @Override
    public void AddCertificate(String certificateFile, Integer FreelancerID) {
        FreelancerTB freelancer = em.find(FreelancerTB.class, FreelancerID);
        Collection<CertificateTB> certificates = freelancer.getCertificateTBCollection();
        
        CertificateTB certificate = new CertificateTB(certificateFile);
        certificates.add(certificate);
        certificate.setFreelancerID(freelancer);
        freelancer.setCertificateTBCollection(certificates);
        em.persist(certificate);
        em.merge(freelancer);
    }

    @Override
    public void UpdateCertificate(Integer CertificateID, String certificateFile, Integer FreelancerID) {
        FreelancerTB freelancer = em.find(FreelancerTB.class, FreelancerID);
        CertificateTB certificate = em.find(CertificateTB.class, CertificateID);
        
        Collection<CertificateTB> certificates = freelancer.getCertificateTBCollection();
        if(certificates.contains(certificate))
        {
            certificate.setCertificateFile(certificateFile);
            freelancer.setCertificateTBCollection(certificates);
            em.merge(certificate);
            em.merge(freelancer);
        }
    }

    @Override
    public void DeleteCertificate(Integer CertificateID, Integer FreelancerID) {
       FreelancerTB freelancer = em.find(FreelancerTB.class, FreelancerID);
        CertificateTB certificate = em.find(CertificateTB.class, CertificateID);
        
        Collection<CertificateTB> certificates = freelancer.getCertificateTBCollection();
        if(certificates.contains(certificate))
        {
            certificates.remove(certificate);
            freelancer.setCertificateTBCollection(certificates);
            em.remove(certificate);
            em.merge(freelancer);
        }
    }

    @Override
    public Collection<PaymentTB> GetAllPayment(Integer FreelancerID) {
        FreelancerTB freelancer = em.find(FreelancerTB.class, FreelancerID);
        return  freelancer.getPaymentTBCollection();
    }

    
    @Override
    public void AddPayment(String totalAmount, Integer FreelancerID) {
        FreelancerTB freelancer =  em.find(FreelancerTB.class, FreelancerID);
        Collection<PaymentTB> payments = freelancer.getPaymentTBCollection();
        
        PaymentTB payment = new PaymentTB(totalAmount);
        payments.add(payment);
        payment.setFreelancerID(freelancer);
        freelancer.setPaymentTBCollection(payments);
        em.persist(payment);
        em.merge(freelancer);
        
    }

    @Override
    public Collection<SkillTB> GetAllSkillFreelancer(Integer FreelancerID) {
        FreelancerTB freelancer = em.find(FreelancerTB.class, FreelancerID);
        return freelancer.getSkillTBCollection();
    }

    @Override
    public void AddSkillFreelancer(Integer FreelancerID, Collection<Integer> ids) {
        FreelancerTB freelancer = em.find(FreelancerTB.class, FreelancerID);
        Collection<SkillTB> skills = freelancer.getSkillTBCollection();
        for(Integer sid : ids)
        {
            SkillTB s = em.find(SkillTB.class, sid);
            if(!skills.contains(s))
            {
                skills.add(s);
                Collection<FreelancerTB> freelancers = s.getFreelancerTBCollection();
                freelancers.add(freelancer);
                s.setFreelancerTBCollection(freelancers);
                freelancer.setSkillTBCollection(skills);
                em.merge(freelancer);
            }
        }
    }

    @Override
    public void DeleteSkillFreelancer(Integer FreelancerID, Collection<Integer> ids) {
        
        FreelancerTB freelancer = em.find(FreelancerTB.class, FreelancerID);
        Collection<SkillTB> skills = freelancer.getSkillTBCollection();
        for(Integer sid : ids)
        {
            SkillTB s = em.find(SkillTB.class, sid);
            if(skills.contains(s))
            {
                skills.remove(s);
                Collection<FreelancerTB> freelancers = s.getFreelancerTBCollection();
                freelancers.remove(freelancer);
                s.setFreelancerTBCollection(freelancers);
                freelancer.setSkillTBCollection(skills);
                em.merge(freelancer);
            }
        }
    }

    @Override
    public void AddCompany(String companyName, String companyOwnerName, String companyEmail, String companyOwnerPassword, Integer companyStaff, String contactNumber, Integer isActive,Integer StateID, Integer CityID,String companyLogo) {
        
        StateTB state = em.find(StateTB.class, StateID);
        CityTB city = em.find(CityTB.class, CityID);
        
        Collection<CompanyTB> companysState = state.getCompanyTBCollection();
        Collection<CompanyTB> companysCity = city.getCompanyTBCollection();
        
        CompanyTB company = new CompanyTB(companyName, companyOwnerName, companyEmail, companyOwnerPassword, companyStaff, contactNumber, isActive, companyLogo);
        
        companysState.add(company);
        companysCity.add(company);
        
        company.setStateID(state);
        company.setCityID(city);
        
        state.setCompanyTBCollection(companysState);
        city.setCompanyTBCollection(companysCity);
        
        em.persist(company);
        em.merge(state);
        em.merge(city);
        
    }

    @Override
    public void UpdateCompany(Integer CompanyID, String companyName, String companyOwnerName, String companyEmail, String companyOwnerPassword, Integer companyStaff, String contactNumber, Integer isActive, Integer StateID, Integer CityID,String companyLogo) {

        StateTB state = em.find(StateTB.class, StateID);
        CityTB city = em.find(CityTB.class, CityID);
        CompanyTB company = em.find(CompanyTB.class, CompanyID);
        
        Collection<CompanyTB> companysState = state.getCompanyTBCollection();
        Collection<CompanyTB> companysCity = city.getCompanyTBCollection();
        
        company.setCompanyEmail(companyEmail);
        company.setCompanyName(companyName);
        company.setCompanyOwnerName(companyOwnerName);
        company.setCompanyOwnerPassword(companyOwnerPassword);
        company.setCompanyStaff(companyStaff);
        company.setContactNumber(contactNumber);
        company.setCompanyLogo(companyLogo);
        //company.setIsActive(isActive);
        //company.setIsApprove(isApprove);
        company.setStateID(state);
        company.setCityID(city);
        
        state.setCompanyTBCollection(companysState);
        city.setCompanyTBCollection(companysCity);
        
        em.merge(company);

        
    }

    @Override
    public void AddWorkPost(String workTitle, String workDescription, String workPostDate, Integer projectScopeID, Integer expertizeLevelID, Integer hourlyRateID, Integer englishLevelID, Integer categoryID, Integer companyID) {

           ProjectScopeTB projectScope = em.find(ProjectScopeTB.class, projectScopeID);
           ExpertizeLevelTB expertizeLevel = em.find(ExpertizeLevelTB.class, expertizeLevelID);
           HourlyRateTB hourlyRate = em.find(HourlyRateTB.class, hourlyRateID);
           EnglsihLevelTB englsihLevel = em.find(EnglsihLevelTB.class, englishLevelID);
           CategoryTB category = em.find(CategoryTB.class, categoryID);
           CompanyTB company = em.find(CompanyTB.class, companyID);
           
           Collection<WorkPostTB> ProjectworkPosts = projectScope.getWorkPostTBCollection();
           Collection<WorkPostTB> ExpertizeWorkPosts = expertizeLevel.getWorkPostTBCollection();
           Collection<WorkPostTB> hourlyworkPosts = hourlyRate.getWorkPostTBCollection();
           Collection<WorkPostTB> englishWorkPosts = englsihLevel.getWorkPostTBCollection();
           Collection<WorkPostTB> cateWorkPosts = category.getWorkPostTBCollection();
           Collection<WorkPostTB> companyWorkPosts = company.getWorkPostTBCollection();
           
           WorkPostTB workPost = new WorkPostTB(workTitle, workDescription, workPostDate);
           
           ProjectworkPosts.add(workPost);
           ExpertizeWorkPosts.add(workPost);
           hourlyworkPosts.add(workPost);
           englishWorkPosts.add(workPost);
           cateWorkPosts.add(workPost);
           companyWorkPosts.add(workPost);
           
           workPost.setProjectScopeID(projectScope);
           workPost.setExpertizeLevelID(expertizeLevel);
           workPost.setHourlyRateID(hourlyRate);
           workPost.setEnglishLevelID(englsihLevel);
           workPost.setCategoryID(category);
           workPost.setCompanyID(company);
           
           projectScope.setWorkPostTBCollection(ProjectworkPosts);
           expertizeLevel.setWorkPostTBCollection(ExpertizeWorkPosts);
           hourlyRate.setWorkPostTBCollection(hourlyworkPosts);
           englsihLevel.setWorkPostTBCollection(englishWorkPosts);
           category.setWorkPostTBCollection(cateWorkPosts);
           company.setWorkPostTBCollection(companyWorkPosts);
           
           em.persist(workPost);
           
           em.merge(projectScope);
           em.merge(expertizeLevel);
           em.merge(hourlyRate);
           em.merge(englsihLevel);
           em.merge(category);
           em.merge(company);
    }

    @Override
    public void UpdateWorkPost(Integer workPostID, String workTitle, String workDescription, String workPostDate, Integer projectScopeID, Integer expertizeLevelID, Integer hourlyRateID, Integer englishLevelID, Integer categoryID, Integer companyID) {

           ProjectScopeTB projectScope = em.find(ProjectScopeTB.class, projectScopeID);
           ExpertizeLevelTB expertizeLevel = em.find(ExpertizeLevelTB.class, expertizeLevelID);
           HourlyRateTB hourlyRate = em.find(HourlyRateTB.class, hourlyRateID);
           EnglsihLevelTB englsihLevel = em.find(EnglsihLevelTB.class, englishLevelID);
           CategoryTB category = em.find(CategoryTB.class, categoryID);
           CompanyTB company = em.find(CompanyTB.class, companyID);
           WorkPostTB workPost = em.find(WorkPostTB.class, workPostID);
           
           Collection<WorkPostTB> ProjectworkPosts = projectScope.getWorkPostTBCollection();
           Collection<WorkPostTB> ExpertizeWorkPosts = expertizeLevel.getWorkPostTBCollection();
           Collection<WorkPostTB> hourlyworkPosts = hourlyRate.getWorkPostTBCollection();
           Collection<WorkPostTB> englishWorkPosts = englsihLevel.getWorkPostTBCollection();
           Collection<WorkPostTB> cateWorkPosts = category.getWorkPostTBCollection();
           Collection<WorkPostTB> companyWorkPosts = company.getWorkPostTBCollection();
           
           workPost.setCategoryID(category);
           //workPost.setCompanyID(company);
           workPost.setEnglishLevelID(englsihLevel);
           workPost.setExpertizeLevelID(expertizeLevel);
           workPost.setHourlyRateID(hourlyRate);
           workPost.setProjectScopeID(projectScope);
           workPost.setWorkDescription(workDescription);
           workPost.setWorkTitle(workTitle);
          // workPost.setWorkPostDate(workPostDate);
           
           projectScope.setWorkPostTBCollection(ProjectworkPosts);
           expertizeLevel.setWorkPostTBCollection(ExpertizeWorkPosts);
           hourlyRate.setWorkPostTBCollection(hourlyworkPosts);
           englsihLevel.setWorkPostTBCollection(englishWorkPosts);
           category.setWorkPostTBCollection(cateWorkPosts);
           company.setWorkPostTBCollection(companyWorkPosts);
           
           em.merge(workPost);
           
           em.merge(projectScope);
           em.merge(expertizeLevel);
           em.merge(hourlyRate);
           em.merge(englsihLevel);
           em.merge(category);
           em.merge(company);
        
    }

    @Override
    public void DeleteWorkPost(Integer workPostID, Integer projectScopeID, Integer expertizeLevelID, Integer hourlyRateID, Integer englishLevelID, Integer categoryID, Integer companyID) {


           ProjectScopeTB projectScope = em.find(ProjectScopeTB.class, projectScopeID);
           ExpertizeLevelTB expertizeLevel = em.find(ExpertizeLevelTB.class, expertizeLevelID);
           HourlyRateTB hourlyRate = em.find(HourlyRateTB.class, hourlyRateID);
           EnglsihLevelTB englsihLevel = em.find(EnglsihLevelTB.class, englishLevelID);
           CategoryTB category = em.find(CategoryTB.class, categoryID);
           CompanyTB company = em.find(CompanyTB.class, companyID);
           WorkPostTB workPost = em.find(WorkPostTB.class, workPostID);
           
           Collection<WorkPostTB> ProjectworkPosts = projectScope.getWorkPostTBCollection();
           Collection<WorkPostTB> ExpertizeWorkPosts = expertizeLevel.getWorkPostTBCollection();
           Collection<WorkPostTB> hourlyworkPosts = hourlyRate.getWorkPostTBCollection();
           Collection<WorkPostTB> englishWorkPosts = englsihLevel.getWorkPostTBCollection();
           Collection<WorkPostTB> cateWorkPosts = category.getWorkPostTBCollection();
           Collection<WorkPostTB> companyWorkPosts = company.getWorkPostTBCollection();
           
           ProjectworkPosts.remove(workPost);
           ExpertizeWorkPosts.remove(workPost);
           hourlyworkPosts.remove(workPost);
           englishWorkPosts.remove(workPost);
           cateWorkPosts.remove(workPost);
           companyWorkPosts.remove(workPost);
           
           projectScope.setWorkPostTBCollection(ProjectworkPosts);
           expertizeLevel.setWorkPostTBCollection(ExpertizeWorkPosts);
           hourlyRate.setWorkPostTBCollection(hourlyworkPosts);
           englsihLevel.setWorkPostTBCollection(englishWorkPosts);
           category.setWorkPostTBCollection(cateWorkPosts);
           company.setWorkPostTBCollection(companyWorkPosts);
           
           em.remove(workPost);
           
    }

    @Override
    public Collection<SkillTB> GetAllWorkPostFreelancerSkill(Integer workPostID) {
        WorkPostTB workPost = em.find(WorkPostTB.class, workPostID);
        return workPost.getSkillTBCollection();
    }

    @Override
    public void AddWorkPostFreelancerSkill(Integer workPostID, Collection<Integer> ids) {

           WorkPostTB workPost = em.find(WorkPostTB.class, workPostID);
           Collection<SkillTB> skills = workPost.getSkillTBCollection();
           for(Integer sid: ids)
           {
               SkillTB s = em.find(SkillTB.class, sid);
               if(!skills.contains(s))
               {
                   skills.add(s);
                   Collection<WorkPostTB> workPosts = s.getWorkPostTBCollection();
                   workPosts.add(workPost);
                   s.setWorkPostTBCollection(workPosts);
                   workPost.setSkillTBCollection(skills);
                   em.merge(workPost);
               }
           }
    }

    @Override
    public void DeleteWorkPostFreelancerSkill(Integer workPostID, Collection<Integer> ids) {
        WorkPostTB workPost = em.find(WorkPostTB.class, workPostID);
        Collection<SkillTB> skills = workPost.getSkillTBCollection();
        for(Integer sid : ids)
        {
            SkillTB s = em.find(SkillTB.class, sid);
            if(skills.contains(s))
            {
                skills.remove(s);
                Collection<WorkPostTB> workPosts = s.getWorkPostTBCollection();
                workPosts.remove(workPost);
                s.setWorkPostTBCollection(workPosts);
                workPost.setSkillTBCollection(skills);
                em.merge(workPost);
            }
        }
    }

    @Override
    public Collection<ReviewTB> GetAllReview(Integer FreelancerID) {
        FreelancerTB freelancer = em.find(FreelancerTB.class, FreelancerID);
        return freelancer.getReviewTBCollection();
    }

    @Override
    public void AddReview(String review, Integer FreelancerID, Integer CompanyID) {
           
            FreelancerTB freelancer = em.find(FreelancerTB.class, FreelancerID);
            CompanyTB company = em.find(CompanyTB.class,CompanyID);
            
            Collection<ReviewTB> freelancerReviews = freelancer.getReviewTBCollection();
            Collection<ReviewTB> companyReviews = company.getReviewTBCollection();
            
            ReviewTB r = new ReviewTB(review);
            freelancerReviews.add(r);
            companyReviews.add(r);
            
            r.setCompanyID(company);
            r.setFreelancerID(freelancer);
            
            freelancer.setReviewTBCollection(freelancerReviews);
            company.setReviewTBCollection(companyReviews);
            
            em.persist(r);
            
            em.merge(freelancer);
            em.merge(company);
    }

    @Override
    public void UpdateReview(Integer ReviewID, String review, Integer FreelancerID, Integer CompanyID) {

            ReviewTB r = em.find(ReviewTB.class, ReviewID);
            FreelancerTB freelancer = em.find(FreelancerTB.class, FreelancerID);
            CompanyTB company = em.find(CompanyTB.class,CompanyID);
            
            Collection<ReviewTB> freelancerReviews = freelancer.getReviewTBCollection();
            Collection<ReviewTB> companyReviews = company.getReviewTBCollection();
            
            r.setCompanyID(company);
            r.setFreelancerID(freelancer);
            r.setReview(review);
            
            freelancer.setReviewTBCollection(freelancerReviews);
            company.setReviewTBCollection(companyReviews);
            
            em.merge(r);
    }

    @Override
    public void DeleteReview(Integer ReviewID, Integer FreelancerID, Integer CompanyID) {
            ReviewTB r = em.find(ReviewTB.class, ReviewID);
            FreelancerTB freelancer = em.find(FreelancerTB.class, FreelancerID);
            CompanyTB company = em.find(CompanyTB.class,CompanyID);
            
            Collection<ReviewTB> freelancerReviews = freelancer.getReviewTBCollection();
            Collection<ReviewTB> companyReviews = company.getReviewTBCollection();
            
            freelancerReviews.remove(r);
            companyReviews.remove(r);
            
            freelancer.setReviewTBCollection(freelancerReviews);
            company.setReviewTBCollection(companyReviews);
            
            em.remove(r);
            em.merge(freelancer);
            em.merge(company);
            
    }

    @Override
    public Collection<CompanyTB> GetAllReviewByCompanyID(Integer ReviewID) {
            Collection<CompanyTB> companyTBs = em.createQuery("SELECT c FROM ReviewTB r, CompanyTB c WHERE c = r.companyID AND r.reviewID=:reviewID")
               .setParameter("reviewID", ReviewID).getResultList();
       return companyTBs;
        
    }

    @Override
    public Collection<WorkPostTB> GetAllWorkPostByCompany(Integer CompanyID) {
        CompanyTB company = em.find(CompanyTB.class, CompanyID);
        return company.getWorkPostTBCollection();
    }

    @Override
    public Collection<CompanyTB> GetAllCompanyByID(Integer workPostID) {
        Collection<CompanyTB> company = em.createQuery("SELECT c FROM CompanyTB c,WorkPostTB w WHERE c=w.companyID AND w.workPostID=:workPostID").setParameter("workPostID", workPostID).getResultList();
        return company;
    }

    @Override
    public void AddLoginDetails(String userName, String password, String userID) {
         LoginTB login = new LoginTB(userName, password, userID);
        em.persist(login);
    }

    @Override
    public void AddLoginRole(Integer RoleID, Collection<Integer> ids) {
        RoleTB role = em.find(RoleTB.class, RoleID);
           Collection<LoginTB> loginTBs = role.getLoginTBCollection();
           for(Integer sid: ids)
           {
               LoginTB l = em.find(LoginTB.class, sid);
               if(!loginTBs.contains(l))
               {
                   loginTBs.add(l);
                   Collection<RoleTB> roleTBs = l.getRoleTBCollection();
                   roleTBs.add(role);
                   l.setRoleTBCollection(roleTBs);
                   role.setLoginTBCollection(loginTBs);
                   em.merge(role);
               }
           }
    }

    @Override
    public Collection<ProjectScopeTB> GetProjectScopeByID(Integer ProjectScopeID) {
        Collection<ProjectScopeTB> projectScopeTBs = em.createNamedQuery("ProjectScopeTB.findByProjectScopeID").getResultList();
        return projectScopeTBs;
    }

    @Override
    public Collection<CityTB> GetAllCity() {
        Collection<CityTB> citys = em.createNamedQuery("CityTB.findAll").getResultList();
        return citys;
    }

    @Override
    public Collection<FreelancerTB> GetAllFreelancerById(Integer FreelancerID) {
        Collection<FreelancerTB> freelancers = em.createNamedQuery("FreelancerTB.findByFreelancerID")
                .getResultList();
        return freelancers;
    }

    @Override
    public Collection<CompanyTB> GetAllCompanyByCompanyID(Integer CompanyID) {
        Collection<CompanyTB> companys = em.createNamedQuery("CompanyTB.findByCompanyID")
                .getResultList();
        return companys;
    }

    @Override
    public FreelancerTB FreelancerByID(Integer FreelancerID) {
       FreelancerTB freelancer = em.find(FreelancerTB.class,FreelancerID);
       return freelancer;
        
    }

    @Override
    public void ChangeStatusFreelancer(Integer id, Integer isActive) {
        FreelancerTB freelancer = em.find(FreelancerTB.class, id);
        freelancer.setIsActive(isActive);
        em.merge(freelancer);
    }

    @Override
    public void ChangeStatusCompany(Integer CompanyID,Integer isActive) {
        CompanyTB company = em.find(CompanyTB.class, CompanyID);
        company.setIsActive(isActive);
        em.merge(company);
    }
    
    @Override
    public Collection<LoginTB> GetAllLogins() {
        Collection<LoginTB> logins = em.createNamedQuery("LoginTB.findAll")
                .getResultList();
        return logins;
    }
    @Override
    public void AdminChangePassword(Integer LoginID,String Password) {
        LoginTB login = em.find(LoginTB.class, LoginID);
       // login.setUserName(UserName);
        login.setPassword(Password);
        //login.setUserID(UserID);
        em.merge(login);
        
    }

    

    @Override
    public void DeletePost(Integer workPostID) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       WorkPostTB workPostTB = em.find(WorkPostTB.class, workPostID);
        em.remove(workPostTB);
    }

    @Override
    public Collection<FreelancerTB> GetWorkPostWiseAppliedFreelancer(Integer workPostID) {
        Collection<FreelancerTB> freelancerTBs = 
                em.createQuery("SELECT f FROM FreelancerTB f,ApplyTB a,WorkPostTB w,CompanyTB c WHERE f=a.freelancerID AND w=a.workPostID AND c = w.companyID AND a.workStatus='Applied' AND w.workPostID=:workPostID")
               .setParameter("workPostID", workPostID).getResultList();
        return freelancerTBs;
    }

    @Override
    public Collection<FreelancerTB> GetWorkPostWiseOngoingFreelancer(Integer workPostID) {
        Collection<FreelancerTB> freelancerTBs = 
                em.createQuery("SELECT f FROM FreelancerTB f,ApplyTB a,WorkPostTB w,CompanyTB c WHERE f=a.freelancerID AND w=a.workPostID AND c = w.companyID AND a.workStatus='Ongoing' AND w.workPostID=:workPostID")
               .setParameter("workPostID", workPostID).getResultList();
        return freelancerTBs;
    }

    @Override
    public Collection<FreelancerTB> GetWorkPostWiseApproveFreelancer(Integer workPostID) {
        Collection<FreelancerTB> freelancerTBs = 
                em.createQuery("SELECT f FROM FreelancerTB f,ApplyTB a,WorkPostTB w,CompanyTB c WHERE f=a.freelancerID AND w=a.workPostID AND c = w.companyID AND a.workStatus='Approve' AND w.workPostID=:workPostID")
               .setParameter("workPostID", workPostID).getResultList();
        return freelancerTBs;
    }

    @Override
    public Collection<FreelancerTB> GetWorkPostWiseConfirmFreelancer(Integer workPostID) {
        Collection<FreelancerTB> freelancerTBs = 
                em.createQuery("SELECT f FROM FreelancerTB f,ApplyTB a,WorkPostTB w,CompanyTB c WHERE f=a.freelancerID AND w=a.workPostID AND c = w.companyID AND a.workStatus='Confirm' AND w.workPostID=:workPostID")
               .setParameter("workPostID", workPostID).getResultList();
        return freelancerTBs;
    }

    @Override
    public Collection<FreelancerTB> GetWorkPostWiseCompletedFreelancer(Integer workPostID) {
        Collection<FreelancerTB> freelancerTBs = 
                em.createQuery("SELECT f FROM FreelancerTB f,ApplyTB a,WorkPostTB w,CompanyTB c WHERE f=a.freelancerID AND w=a.workPostID AND c = w.companyID AND a.workStatus='Completed' AND w.workPostID=:workPostID")
               .setParameter("workPostID", workPostID).getResultList();
        return freelancerTBs;
    }

    @Override
    public Collection<FreelancerTB> GetCompanyWiseAppliedFreelancer(Integer CompanyID) {
        Collection<FreelancerTB> freelancerTBs = 
                em.createQuery("SELECT f FROM FreelancerTB f,ApplyTB a,WorkPostTB w,CompanyTB c WHERE f=a.freelancerID AND w=a.workPostID AND c = w.companyID AND a.workStatus='Applied' AND c.companyID=:companyID")
               .setParameter("companyID", CompanyID).getResultList();
        return freelancerTBs;
    }

    @Override
    public void AddApplyTb(String workStatus, Integer freelancerID, Integer workPostID) {
        FreelancerTB f = em.find(FreelancerTB.class, freelancerID);
        WorkPostTB w = em.find(WorkPostTB.class, workPostID);
        Collection<ApplyTB> af = f.getApplyTBCollection();
        Collection<ApplyTB> aw = w.getApplyTBCollection();
        ApplyTB applyTB = new ApplyTB(workStatus);
        af.add(applyTB);
        aw.add(applyTB);
        applyTB.setFreelancerID(f);
        applyTB.setWorkPostID(w);
        f.setApplyTBCollection(af);
        w.setApplyTBCollection(aw);
        em.persist(applyTB);
        em.merge(f);
        em.merge(w);
        
    }

    @Override
    public void ChangeStatusOfWork(Integer ApplyID, String WorkStatus) {
        ApplyTB apply = em.find(ApplyTB.class, ApplyID);
        apply.setWorkStatus(WorkStatus);
        em.merge(apply);
    }

    @Override
    public Collection<WorkPostTB> GetAllWorkPostWithCompanyDetails() {
        Collection<WorkPostTB> workPosts = em.createQuery("SELECT w FROM CompanyTB c,WorkPostTB w WHERE c=w.companyID").getResultList();
        return workPosts;
    }

    @Override
    public Collection<WorkPostTB> SerachByCompanyName(String companyName) {
        Collection<WorkPostTB> workPosts = em.createQuery("SELECT w FROM CompanyTB c,WorkPostTB w WHERE c=w.companyID AND c.companyName LIKE :companyName").setParameter("companyName", companyName).getResultList();
        return workPosts;

    }

    @Override
    public Collection<WorkPostTB> SerachBy() {
        Collection<WorkPostTB> workPosts = em.createQuery("SELECT w FROM CompanyTB c,WorkPostTB w WHERE c=w.companyID AND c.companyName LIKE 'w%'").getResultList();
        return workPosts;
    }

    @Override
    public Collection<FreelancerTB> GetAllFreelancerStatusIsZero() {
        Collection<FreelancerTB> freelancerTBs = em.createQuery("SELECT f FROM FreelancerTB f WHERE f.isActive='0'").getResultList();
        return freelancerTBs;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<CompanyTB> GetAllCompanyStatusIsZero() {
        Collection<CompanyTB> companyTBs = em.createQuery("SELECT c FROM CompanyTB c WHERE c.isActive='0'").getResultList();
        return companyTBs;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<FreelancerTB> GetAllFreelancerStatusIsOne() {
        Collection<FreelancerTB> freelancerTBs = em.createQuery("SELECT f FROM FreelancerTB f WHERE f.isActive='1'").getResultList();
        return freelancerTBs;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<CompanyTB> GetAllCompanyStatusIsOne() {
        Collection<CompanyTB> companyTBs = em.createQuery("SELECT c FROM CompanyTB c WHERE c.isActive='1'").getResultList();
        return companyTBs;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<WorkPostTB> GetAllApplyByFreelancerID(Integer FreelancerID) {
        Collection<WorkPostTB> workPostTBs = em.createQuery("SELECT w FROM FreelancerTB f,ApplyTB a,WorkPostTB w,CompanyTB c WHERE f=a.freelancerID AND w=a.workPostID AND c = w.companyID AND a.workStatus='Applied' AND f.freelancerID=:freelancerID")
                .setParameter("freelancerID", FreelancerID).getResultList();
        return workPostTBs;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<WorkPostTB> GetAllApprovedByFreelancerID(Integer FreelancerID) {
        Collection<WorkPostTB> workPostTBs = em.createQuery("SELECT w FROM FreelancerTB f,ApplyTB a,WorkPostTB w,CompanyTB c WHERE f=a.freelancerID AND w=a.workPostID AND c = w.companyID AND a.workStatus='Approve' AND f.freelancerID=:freelancerID")
                .setParameter("freelancerID", FreelancerID).getResultList();
        return workPostTBs;
    }

    @Override
    public Collection<WorkPostTB> GetAllConfirmedByFreelancerID(Integer FreelancerID) {
        Collection<WorkPostTB> workPostTBs = em.createQuery("SELECT w FROM FreelancerTB f,ApplyTB a,WorkPostTB w,CompanyTB c WHERE f=a.freelancerID AND w=a.workPostID AND c = w.companyID AND a.workStatus='Confirmed' AND f.freelancerID=:freelancerID")
                .setParameter("freelancerID", FreelancerID).getResultList();
        return workPostTBs;
    }

    @Override
    public Collection<WorkPostTB> GetAllOngoingByFreelancerID(Integer FreelancerID) {
        Collection<WorkPostTB> workPostTBs = em.createQuery("SELECT w FROM FreelancerTB f,ApplyTB a,WorkPostTB w,CompanyTB c WHERE f=a.freelancerID AND w=a.workPostID AND c = w.companyID AND a.workStatus='Ongoing' AND f.freelancerID=:freelancerID")
                .setParameter("freelancerID", FreelancerID).getResultList();
        return workPostTBs;
    }

    @Override
    public Collection<WorkPostTB> GetAllCompletedByFreelancerID(Integer FreelancerID) {
        Collection<WorkPostTB> workPostTBs = em.createQuery("SELECT w FROM FreelancerTB f,ApplyTB a,WorkPostTB w,CompanyTB c WHERE f=a.freelancerID AND w=a.workPostID AND c = w.companyID AND a.workStatus='Completed' AND f.freelancerID=:freelancerID")
                .setParameter("freelancerID", FreelancerID).getResultList();
        return workPostTBs;
    }

    @Override
    public Collection<FreelancerTB> GetCompanyWiseApproveFreelancer(Integer CompanyID) {
        Collection<FreelancerTB> freelancerTBs = 
                em.createQuery("SELECT f FROM FreelancerTB f,ApplyTB a,WorkPostTB w,CompanyTB c WHERE f=a.freelancerID AND w=a.workPostID AND c = w.companyID AND a.workStatus='Approve' AND c.companyID=:companyID")
               .setParameter("companyID", CompanyID).getResultList();
        return freelancerTBs;
    }

    @Override
    public Collection<FreelancerTB> GetCompanyWiseConfirmedFreelancer(Integer CompanyID) {
        Collection<FreelancerTB> freelancerTBs = 
                em.createQuery("SELECT f FROM FreelancerTB f,ApplyTB a,WorkPostTB w,CompanyTB c WHERE f=a.freelancerID AND w=a.workPostID AND c = w.companyID AND a.workStatus='Confirmed' AND c.companyID=:companyID")
               .setParameter("companyID", CompanyID).getResultList();
        return freelancerTBs;
    }

    @Override
    public Collection<FreelancerTB> GetCompanyWiseOngoingFreelancer(Integer CompanyID) {
        Collection<FreelancerTB> freelancerTBs = 
                em.createQuery("SELECT f FROM FreelancerTB f,ApplyTB a,WorkPostTB w,CompanyTB c WHERE f=a.freelancerID AND w=a.workPostID AND c = w.companyID AND a.workStatus='Ongoing' AND c.companyID=:companyID")
               .setParameter("companyID", CompanyID).getResultList();
        return freelancerTBs;
    }

    @Override
    public Collection<FreelancerTB> GetCompanyWiseCompletedFreelancer(Integer CompanyID) {
        Collection<FreelancerTB> freelancerTBs = 
                em.createQuery("SELECT f FROM FreelancerTB f,ApplyTB a,WorkPostTB w,CompanyTB c WHERE f=a.freelancerID AND w=a.workPostID AND c = w.companyID AND a.workStatus='Completed' AND c.companyID=:companyID")
               .setParameter("companyID", CompanyID).getResultList();
        return freelancerTBs;
    }

    @Override
    public Collection<FreelancerTB> SerachByFreelancerName(String email) {
        Collection<FreelancerTB> freelancerTBs = em.createQuery("SELECT f FROM FreelancerTB f WHERE f.email LIKE :email").setParameter("email", email).getResultList();
        return freelancerTBs;
    }

    @Override
    public Collection<FreelancerTB> SerachByHourlyRate(String Start_hourlyRateID, String End_hourlyRateID) {
        Collection<FreelancerTB> freelancerTBs = em.createQuery("SELECT f FROM FreelancerTB f,HourlyRateTB h WHERE h=f.hourlyRateID AND h.rate BETWEEN :Start_hourlyRateID AND :End_hourlyRateID").setParameter("Start_hourlyRateID", Start_hourlyRateID).setParameter("End_hourlyRateID", End_hourlyRateID).getResultList();
        return freelancerTBs;
    }

    @Override
    public Collection<WorkPostTB> SerachByHourlyRateFromWorkPost(String Start_hourlyRateID, String End_hourlyRateID) {
        Collection<WorkPostTB> workPostTBs = em.createQuery("SELECT w FROM CompanyTB c,WorkPostTB w,HourlyRateTB h WHERE c=w.companyID AND h=w.hourlyRateID AND h.rate BETWEEN :Start_hourlyRateID AND :End_hourlyRateID").setParameter("Start_hourlyRateID", Start_hourlyRateID).setParameter("End_hourlyRateID", End_hourlyRateID).getResultList();
        return workPostTBs;
    }

    @Override
    public Collection<ApplyTB> GetApplyID(String Status,Integer CompanyID) {
        Collection<ApplyTB> applyTBs = 
                em.createQuery("SELECT a FROM FreelancerTB f,ApplyTB a,WorkPostTB w,CompanyTB c WHERE f=a.freelancerID AND w=a.workPostID AND c = w.companyID  AND a.workStatus=:Status AND c.companyID=:CompanyID")
               .setParameter("Status", Status).setParameter("CompanyID", CompanyID).getResultList();
        return applyTBs;
    }
    
    @Override
    public Collection<BiddingTB> GetAllBidding(Integer FreelancerID) {
        FreelancerTB freelancer = em.find(FreelancerTB.class, FreelancerID);
        return freelancer.getBiddingTBCollection();
    }

    @Override
    public void AddBidding( Integer WorkPostID ,Integer FreelancerID, String BiddingRate) {
           
            FreelancerTB freelancer = em.find(FreelancerTB.class, FreelancerID);
            WorkPostTB workpost = em.find(WorkPostTB.class,WorkPostID);
            
            Collection<BiddingTB> freelancerBidding = freelancer.getBiddingTBCollection();
            Collection<BiddingTB> workpostBidding = workpost.getBiddingTBCollection();
            
            BiddingTB r = new BiddingTB(BiddingRate);
            freelancerBidding.add(r);
            workpostBidding.add(r);
            
            r.setWorkPostID(workpost);
            r.setFreelancerID(freelancer);
            
            freelancer.setBiddingTBCollection(freelancerBidding);
            workpost.setBiddingTBCollection(workpostBidding);
            
            em.persist(r);
            
            em.merge(freelancer);
            em.merge(workpost);
    }

    

    

    @Override
    public Collection<ApplyTB> GetApplyIDFreelancer(String Status, Integer FreelancerID) {
        Collection<ApplyTB> applyTBs = 
                em.createQuery("SELECT a FROM FreelancerTB f,ApplyTB a,WorkPostTB w,CompanyTB c WHERE f=a.freelancerID AND w=a.workPostID AND c = w.companyID  AND a.workStatus=:Status AND f.freelancerID=:FreelancerID")
               .setParameter("Status", Status).setParameter("FreelancerID", FreelancerID).getResultList();
        return applyTBs;
    }
    
    @Override
    public Collection<BiddingTB> GetAllBiddingByWorkPostID(Integer workPostID) {
            Collection<BiddingTB> workpostTbs = em.createQuery("SELECT b FROM BiddingTB b, WorkPostTB w,FreelancerTB f,CompanyTB c WHERE f=b.freelancerID AND c=w.companyID AND w=b.workPostID  AND w.workPostID=:workPostID")
               .setParameter("workPostID", workPostID).getResultList();
       return workpostTbs;
        
    }
    @Override
    public Collection<BiddingTB> GetAllBiddingByFreelancerID(Integer freelancerID) {
            Collection<BiddingTB> frees = em.createQuery("SELECT b FROM BiddingTB b, WorkPostTB w,FreelancerTB f,CompanyTB c WHERE f=b.freelancerID AND c=w.companyID AND w=b.workPostID  AND f.freelancerID=:freelancerID")
               .setParameter("freelancerID", freelancerID).getResultList();
       return frees;
        
    }
    

    
    

    
    
   
}
