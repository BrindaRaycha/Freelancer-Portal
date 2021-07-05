/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import Entity.*;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author brinda
 */
@Local
public interface FreelancerPortalBeanLocal {
    
    
    public Collection<LoginTB> GetAllLogins();
    public void AdminChangePassword(Integer LoginID,String Password);
    //Freelancer
    Collection<FreelancerTB> GetAllFreelancer();
    Collection<FreelancerTB> GetAllFreelancerById(Integer FreelancerID);
    Collection<FreelancerTB> GetAllFreelancerStatusIsZero();
    Collection<FreelancerTB> GetAllFreelancerStatusIsOne();
    FreelancerTB FreelancerByID(Integer FreelancerID);
    void AddFreelancer(String email, String password, String college, String profileImage, String aboutSelf, String weeklyAvailable,Integer categoryID,Integer stateID, Integer cityID,Integer degreeID, Integer englishLevelID,Integer expertizeLevelID,Integer hourlyRateID,Integer isActive);
    void DeleteFreelancer(Integer FreelancerID,Integer categoryID,Integer stateID, Integer cityID,Integer degreeID, Integer englishLevelID,Integer expertizeLevelID,Integer hourlyRateID);
    void UpdateFreelancer(Integer FreelancerID,String email, String password, String college, String profileImage, String aboutSelf, String weeklyAvailable,Integer categoryID,Integer stateID, Integer cityID,Integer degreeID, Integer englishLevelID,Integer expertizeLevelID,Integer hourlyRateID,Integer isActive);
//    void ChangePasswordFreelancer(Integer FreelancerID,String password);
    void ChangeStatusFreelancer(Integer id,Integer isActive);

    
    //Company
    Collection<CompanyTB> GetAllCompanyStatusIsZero();
    Collection<CompanyTB> GetAllCompanyStatusIsOne();
    Collection<CompanyTB> GetAllCompany();
    Collection<CompanyTB> GetAllCompanyByCompanyID(Integer CompanyID);
    //Collection<CompanyTB> CompanyByID(Integer FreelancerID);
    void AddCompany(String companyName, String companyOwnerName, String companyEmail, String companyOwnerPassword, Integer companyStaff, String contactNumber, Integer isActive,Integer StateID,Integer CityID, String companyLogo);
    void UpdateCompany(Integer CompanyID,String companyName, String companyOwnerName, String companyEmail, String companyOwnerPassword, Integer companyStaff, String contactNumber, Integer isActive,Integer StateID,Integer CityID, String companyLogo);
    void ChangeStatusCompany(Integer CompanyID,Integer isActive);
    
    //WorkPost
    
    Collection<FreelancerTB> GetCompanyWiseAppliedFreelancer(Integer CompanyID);
    Collection<FreelancerTB>GetCompanyWiseApproveFreelancer(Integer CompanyID);
    Collection<FreelancerTB>GetCompanyWiseConfirmedFreelancer(Integer CompanyID);
    Collection<FreelancerTB>GetCompanyWiseOngoingFreelancer(Integer CompanyID);
    Collection<FreelancerTB>GetCompanyWiseCompletedFreelancer(Integer CompanyID);
    
    
    Collection<FreelancerTB> GetWorkPostWiseAppliedFreelancer(Integer workPostID);
    Collection<FreelancerTB> GetWorkPostWiseOngoingFreelancer(Integer workPostID);
    Collection<FreelancerTB> GetWorkPostWiseApproveFreelancer(Integer workPostID);
    Collection<FreelancerTB> GetWorkPostWiseConfirmFreelancer(Integer workPostID);
    Collection<FreelancerTB> GetWorkPostWiseCompletedFreelancer(Integer workPostID);
    
    Collection<WorkPostTB> GetAllWorkPostByCompany(Integer CompanyID);
    Collection<CompanyTB> GetAllCompanyByID(Integer workPostID);
    Collection<WorkPostTB> GetAllWorkPost();
    Collection<WorkPostTB> GetAllWorkPostWithCompanyDetails();
    void DeletePost(Integer workPostID);
    void AddWorkPost(String workTitle, String workDescription, String workPostDate,Integer projectScopeID,Integer expertizeLevelID,Integer hourlyRateID,Integer englishLevelID,Integer categoryID,Integer companyID);
    void UpdateWorkPost(Integer workPostID,String workTitle, String workDescription, String workPostDate,Integer projectScopeID,Integer expertizeLevelID,Integer hourlyRateID,Integer englishLevelID,Integer categoryID,Integer companyID);
    void DeleteWorkPost(Integer workPostID,Integer projectScopeID,Integer expertizeLevelID,Integer hourlyRateID,Integer englishLevelID,Integer categoryID,Integer companyID);
    
    //State
    Collection<StateTB> GetAllState();
    void AddState(String StateName);
    void UpdateState(Integer StateID,String StateName);
    void DeleteState(Integer StateID);
    
    //City
    Collection<CityTB> GetAllCity();
    Collection<CityTB> GetAllStateWiseCity(Integer StateID);
    void AddStateWiseCity(String CityName,Integer StateID);
    void UpdateStateWiseCity(Integer CityID, String CityName,Integer StateID);
    void DeleteStateWiseCity(Integer CityID,Integer StateID);
    
    //ProjectScope
    Collection<ProjectScopeTB> GetAllProjectScope();
    Collection<ProjectScopeTB> GetProjectScopeByID(Integer ProjectScopeID);
    void AddProjectScope(String Scope);
    void UpdateProjectScope(Integer ProjectScopeID,String Scope);
    void DeleteProjectScope(Integer ProjectScopeID);
    
    //ExpertizeLevel
    Collection<ExpertizeLevelTB> GetAllExpertizeLevel();
    void AddExpertizeLevel(String Levels);
    void UpdateExpertizeLevel(Integer ExpertizeLevelID,String Levels);
    void DeleteExpertizeLevel(Integer ExpertizeLevelID);
    
    //HourlyRate
    Collection<HourlyRateTB> GetAllHourlyRate();
    void AddHourlyRate(String rate);
    void UpdateHourlyRate(Integer HourlyRateID,String rate);
    void DeleteHourlyRate(Integer HourlyRateID);
    
    //EnglishLevel
    Collection<EnglsihLevelTB> GetAllEnglishLevel();
    void AddEnglsihLevel(String englishLevels);
    void UpdateEnglsihLevel(Integer EnglishLevelID,String englishLevels);
    void DeleteEnglsihLevel(Integer EnglishLevelID);
    
    //Degree
    Collection<DegreeTB> GetAllDegree();
    void AddDegree(String degree);
    void UpdateDegree(Integer DegreeID,String degree);
    void DeleteDegree(Integer DegreeID);
    
    //Skill
    Collection<SkillTB> GetAllSkill();
    void AddSkill(String skills,Integer CategoryID);
    void UpdateSkill(Integer SkillID,String skills,Integer CategoryID);
    void DeleteSkill(Integer SkillID);
    
    //Category
    Collection<CategoryTB> GetAllCategory();
    void AddCategory(String categoryName);
    void UpdateCategory(Integer CategoryID,String categoryName);
    void DeleteCategory(Integer CategoryID);
    
    //Certificate
    Collection<CertificateTB> GetAllCertificate(Integer FreelancerID);
    void AddCertificate(String certificateFile,Integer FreelancerID);
    void UpdateCertificate(Integer CertificateID,String certificateFile,Integer FreelancerID);
    void DeleteCertificate(Integer CertificateID,Integer FreelancerID);
    
    //Payment
    Collection<PaymentTB> GetAllPayment(Integer FreelancerID);
    void AddPayment(String totalAmount,Integer FreelancerID);
//    void UpdatePayment(Integer PaymentID,Integer totalAmount,Integer FreelancerID);
//    void DeletePayment(Integer PaymentID,Integer FreelancerID);
    
    //SkillFreelancer
    Collection<SkillTB> GetAllSkillFreelancer(Integer FreelancerID);
    void AddSkillFreelancer(Integer FreelancerID,Collection<Integer> ids);
    void DeleteSkillFreelancer(Integer FreelancerID,Collection<Integer> ids);
    
    //WorkPostFreelancerSkill
    Collection<SkillTB> GetAllWorkPostFreelancerSkill(Integer workPostID);
    void AddWorkPostFreelancerSkill(Integer workPostID,Collection<Integer> ids);
    void DeleteWorkPostFreelancerSkill(Integer workPostID,Collection<Integer> ids);
    
    //Review
    Collection<ReviewTB> GetAllReview(Integer CompanyID);
    Collection<CompanyTB> GetAllReviewByCompanyID(Integer ReviewID);
    void AddReview(String review,Integer FreelancerID,Integer CompanyID);
    void UpdateReview(Integer ReviewID,String review,Integer FreelancerID,Integer CompanyID);
    void DeleteReview(Integer ReviewID,Integer FreelancerID,Integer CompanyID);
    
    
    //LoginTB
    void AddLoginDetails(String userName, String password, String userID);
    
    void AddLoginRole(Integer RoleID,Collection<Integer> ids);
    
    //ApplyTB
    void AddApplyTb(String workStatus,Integer freelancerID,Integer workPostID);
    void ChangeStatusOfWork(Integer ApplyID,String WorkStatus);
    
    Collection<FreelancerTB> SerachByFreelancerName(String email);
    Collection<WorkPostTB> SerachByHourlyRateFromWorkPost(String Start_hourlyRateID,String End_hourlyRateID);
    Collection<FreelancerTB> SerachByHourlyRate(String Start_hourlyRateID,String End_hourlyRateID);
    Collection<WorkPostTB> SerachByCompanyName(String companyName);
    Collection<WorkPostTB> SerachBy();
    
    
    Collection<WorkPostTB> GetAllApplyByFreelancerID(Integer FreelancerID);
    Collection<WorkPostTB> GetAllApprovedByFreelancerID(Integer FreelancerID);
    Collection<WorkPostTB> GetAllConfirmedByFreelancerID(Integer FreelancerID);
    Collection<WorkPostTB> GetAllOngoingByFreelancerID(Integer FreelancerID);
    Collection<WorkPostTB> GetAllCompletedByFreelancerID(Integer FreelancerID);
    
    Collection<ApplyTB> GetApplyID(String Status,Integer CompanyID);
    Collection<ApplyTB> GetApplyIDFreelancer(String Status,Integer FreelancerID);
    
    public Collection<BiddingTB> GetAllBidding(Integer FreelancerID);
    public void AddBidding( Integer WorkPostID ,Integer FreelancerID, String BiddingRate);
    public Collection<BiddingTB> GetAllBiddingByWorkPostID(Integer WorkPostID);
    public Collection<BiddingTB> GetAllBiddingByFreelancerID(Integer FreelancerID);
   
    
}
