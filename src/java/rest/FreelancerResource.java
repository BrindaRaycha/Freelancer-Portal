/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import Entity.*;
import ejb.FreelancerPortalBeanLocal;
import java.util.Collection;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author brinda
 */
@DeclareRoles({"Admin","Company","Freelancer"})
@Path("Freelancer")
@RequestScoped
public class FreelancerResource {

    @EJB FreelancerPortalBeanLocal fp;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FreelancerResource
     */
    public FreelancerResource() {
    }
    
    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetApplyIDFreelancer/{Status}/{fid}")
    public Collection<ApplyTB> GetApplyIDFreelancer(@PathParam("Status") String Status,@PathParam("fid") Integer FreelancerID) {
        Collection<ApplyTB> applyTBs = fp.GetApplyIDFreelancer(Status, FreelancerID);
                
        return applyTBs;
    }
    
    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllBidding/{fid}")
    public Collection<BiddingTB> GetAllBidding(@PathParam("fid") Integer FreelancerID) {
        Collection<BiddingTB> bidding = fp.GetAllBidding(FreelancerID);
        return bidding;
    }

    @RolesAllowed("Freelancer")
    @POST
    @Path("AddBidding/{WorkPostID}/{FreelancerID}/{BiddingRate}")
    public void AddBidding(@PathParam("WorkPostID") Integer WorkPostID,@PathParam("FreelancerID") Integer FreelancerID,@PathParam("BiddingRate") String BiddingRate) {
           fp.AddBidding(WorkPostID, FreelancerID, BiddingRate);
        
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllBiddingByWorkPostID/{WorkPostID}")
    public Collection<BiddingTB> GetAllBiddingByWorkPostID(@PathParam("WorkPostID") Integer WorkPostID) {
        
        Collection<BiddingTB> ReviewByComp = fp.GetAllBiddingByWorkPostID(WorkPostID);
        return ReviewByComp;
    }
    
    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllBiddingByFreelancerID/{FreelancerID}")
    public Collection<BiddingTB> GetAllBiddingByFreelancerID(@PathParam("FreelancerID") Integer FreelancerID) {
        Collection<BiddingTB> ReviewByFree = fp.GetAllBiddingByFreelancerID(FreelancerID);
        return ReviewByFree;
    }
    
    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetApplyID/{s}/{id}")
    public Collection<ApplyTB> GetApplyID(@PathParam("s") String Status,@PathParam("id") Integer CompanyID) {
        Collection<ApplyTB> applyTBs = fp.GetApplyID(Status, CompanyID);
        return applyTBs;
    }
    
    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("SerachByFreelancerName/{email}")
    public Collection<FreelancerTB> SerachByFreelancerName(@PathParam("email") String email) {
        Collection<FreelancerTB> freelancerTBs = fp.SerachByFreelancerName(email);
        return freelancerTBs;
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("SerachByHourlyRate/{start}/{end}")
    public Collection<FreelancerTB> SerachByHourlyRate(@PathParam("start") String Start_hourlyRateID,@PathParam("end") String End_hourlyRateID) {
        Collection<FreelancerTB> freelancerTBs = fp.SerachByHourlyRate(Start_hourlyRateID, End_hourlyRateID);
        return freelancerTBs;
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("SerachByHourlyRateFromWorkPost/{start}/{end}")
    public Collection<WorkPostTB> SerachByHourlyRateFromWorkPost(@PathParam("start") String Start_hourlyRateID,@PathParam("end") String End_hourlyRateID) {
        Collection<WorkPostTB> workPostTBs = fp.SerachByHourlyRateFromWorkPost(Start_hourlyRateID, End_hourlyRateID);
        return workPostTBs;
    }
    
    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllApplyByFreelancerID/{fid}")
    public Collection<WorkPostTB> GetAllApplyByFreelancerID(@PathParam("fid") Integer FreelancerID) {
        Collection<WorkPostTB> workPostTBs = fp.GetAllApplyByFreelancerID(FreelancerID);
        return workPostTBs;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllApprovedByFreelancerID/{fid}")
    public Collection<WorkPostTB> GetAllApprovedByFreelancerID(@PathParam("fid") Integer FreelancerID) {
        Collection<WorkPostTB> workPostTBs = fp.GetAllApprovedByFreelancerID(FreelancerID);
        return workPostTBs;
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllConfirmedByFreelancerID/{fid}")
    public Collection<WorkPostTB> GetAllConfirmedByFreelancerID(@PathParam("fid") Integer FreelancerID) {
        Collection<WorkPostTB> workPostTBs = fp.GetAllConfirmedByFreelancerID(FreelancerID);
        return workPostTBs;
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllOngoingByFreelancerID/{fid}")
    public Collection<WorkPostTB> GetAllOngoingByFreelancerID(@PathParam("fid") Integer FreelancerID) {
        Collection<WorkPostTB> workPostTBs = fp.GetAllOngoingByFreelancerID(FreelancerID);
        return workPostTBs;
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllCompletedByFreelancerID/{fid}")
    public Collection<WorkPostTB> GetAllCompletedByFreelancerID(@PathParam("fid") Integer FreelancerID) {
        Collection<WorkPostTB> workPostTBs = fp.GetAllCompletedByFreelancerID(FreelancerID);
        return workPostTBs;
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetCompanyWiseApproveFreelancer/{cid}")
    public Collection<FreelancerTB> GetCompanyWiseApproveFreelancer(@PathParam("cid") Integer CompanyID) {
        Collection<FreelancerTB> freelancerTBs = fp.GetCompanyWiseApproveFreelancer(CompanyID);
        return freelancerTBs;
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetCompanyWiseConfirmedFreelancer/{cid}")
    public Collection<FreelancerTB> GetCompanyWiseConfirmedFreelancer(@PathParam("cid") Integer CompanyID) {
        Collection<FreelancerTB> freelancerTBs = fp.GetCompanyWiseConfirmedFreelancer(CompanyID);
        return freelancerTBs;
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetCompanyWiseOngoingFreelancer/{cid}")
    public Collection<FreelancerTB> GetCompanyWiseOngoingFreelancer(@PathParam("cid") Integer CompanyID) {
        Collection<FreelancerTB> freelancerTBs = fp.GetCompanyWiseOngoingFreelancer(CompanyID);
        return freelancerTBs;
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetCompanyWiseCompletedFreelancer/{cid}")
    public Collection<FreelancerTB> GetCompanyWiseCompletedFreelancer(@PathParam("cid") Integer CompanyID) {
        Collection<FreelancerTB> freelancerTBs = fp.GetCompanyWiseCompletedFreelancer(CompanyID);
        return freelancerTBs;
    }
    
    
    
    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllFreelancerStatusIsZero")
    public Collection<FreelancerTB> GetAllFreelancerStatusIsZero() {
        Collection<FreelancerTB> freelancerTBs = fp.GetAllFreelancerStatusIsZero();
        return freelancerTBs;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllCompanyStatusIsZero")
    public Collection<CompanyTB> GetAllCompanyStatusIsZero() {
        Collection<CompanyTB> companyTBs = fp.GetAllCompanyStatusIsZero();
        return companyTBs;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllFreelancerStatusIsOne")
    public Collection<FreelancerTB> GetAllFreelancerStatusIsOne() {
        Collection<FreelancerTB> freelancerTBs = fp.GetAllFreelancerStatusIsOne();
        return freelancerTBs;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllCompanyStatusIsOne")
    public Collection<CompanyTB> GetAllCompanyStatusIsOne() {
        Collection<CompanyTB> companyTBs = fp.GetAllCompanyStatusIsOne();
        return companyTBs;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("SerachByCompanyName/{cname}")
    public Collection<WorkPostTB> SerachByCompanyName(@PathParam("cname") String companyName) {
        Collection<WorkPostTB> workPosts = fp.SerachByCompanyName(companyName);
        return workPosts;

    }
    
    @RolesAllowed("Freelancer")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllWorkPostWithCompanyDetails")
    public Collection<WorkPostTB> GetAllWorkPostWithCompanyDetails() {
        Collection<WorkPostTB> workPosts = fp.GetAllWorkPostWithCompanyDetails();
        return workPosts;
    }
    
    @RolesAllowed("Company")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetWorkPostWiseAppliedFreelancer/{wid}")
    public Collection<FreelancerTB> GetWorkPostWiseAppliedFreelancer(@PathParam("wid") Integer workPostID) {
        Collection<FreelancerTB> freelancerTBs = fp.GetWorkPostWiseAppliedFreelancer(workPostID);
        return freelancerTBs;
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetWorkPostWiseOngoingFreelancer/{wid}")
    public Collection<FreelancerTB> GetWorkPostWiseOngoingFreelancer(@PathParam("wid") Integer workPostID) {
        Collection<FreelancerTB> freelancerTBs = fp.GetWorkPostWiseOngoingFreelancer(workPostID);
        return freelancerTBs;
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetWorkPostWiseApproveFreelancer/{wid}")
    public Collection<FreelancerTB> GetWorkPostWiseApproveFreelancer(@PathParam("wid") Integer workPostID) {
        Collection<FreelancerTB> freelancerTBs = fp.GetWorkPostWiseApproveFreelancer(workPostID);
        return freelancerTBs;
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetWorkPostWiseConfirmFreelancer/{wid}")
    public Collection<FreelancerTB> GetWorkPostWiseConfirmFreelancer(@PathParam("wid") Integer workPostID) {
        Collection<FreelancerTB> freelancerTBs = fp.GetWorkPostWiseConfirmFreelancer(workPostID);
        return freelancerTBs;
    }

   @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetWorkPostWiseCompletedFreelancer/{wid}")
    public Collection<FreelancerTB> GetWorkPostWiseCompletedFreelancer(@PathParam("wid") Integer workPostID) {
        Collection<FreelancerTB> freelancerTBs = fp.GetWorkPostWiseCompletedFreelancer(workPostID);
        return freelancerTBs;
    }

   @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetCompanyWiseAppliedFreelancer/{cmpid}")
    public Collection<FreelancerTB> GetCompanyWiseAppliedFreelancer(@PathParam("cmpid") Integer CompanyID) {
        Collection<FreelancerTB> freelancerTBs = fp.GetCompanyWiseAppliedFreelancer(CompanyID);
        return freelancerTBs;
    }
    
    @RolesAllowed("Freelancer")
    @POST
    @Path("AddApplyTb/{status}/{fid}/{wid}")
    public void AddApplyTb(@PathParam("status") String workStatus,@PathParam("fid") Integer freelancerID,@PathParam("wid") Integer workPostID) {
       fp.AddApplyTb(workStatus, freelancerID, workPostID);
    }
    
    @PUT
    @RolesAllowed({"Admin","Company","Freelancer"})
    @Path("ChangeStatusOfWork/{aid}/{status}")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public void ChangeStatusOfWork(@PathParam("aid") Integer ApplyID,@PathParam("status") String WorkStatus) {
        fp.ChangeStatusOfWork(ApplyID, WorkStatus);
    }
    
    @RolesAllowed("Company")    
    @DELETE
    @Path("DeletePost/{wpid}")
    public void DeletePost(@PathParam("wpid") Integer workPostID) {
    fp.DeletePost(workPostID);
    }
    
    @POST
    @Path("AddLoginDetails/{uname}/{pass}/{uid}")
    public void AddLoginDetails(@PathParam("uname") String userName,@PathParam("pass") String password,@PathParam("uid") String userID) {
        fp.AddLoginDetails(userName, password, userID);
    }

    
    @POST
    @Path("AddLoginRole/{fid}")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public void AddLoginRole(@PathParam("fid") Integer RoleID, Collection<Integer> ids) {
        fp.AddLoginRole(RoleID, ids);
    }
    
    @RolesAllowed("Admin")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("AdminChangePassword/{aid}/{Password}")    
    public void AdminChangePassword(@PathParam("aid") Integer LoginID, @PathParam("Password") String Password)
    {
        fp.AdminChangePassword(LoginID, Password);
    }
    
    @RolesAllowed("Admin")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllLogins")
    public Collection<LoginTB> GetAllLogins() {
       Collection<LoginTB> logins = fp.GetAllLogins();
        return logins;
    }
    
    @GET
   @RolesAllowed({"Admin","Company"})
   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("FreelancerByID/{fid}")
    public FreelancerTB FreelancerByID(@PathParam("fid") Integer FreelancerID) {
       FreelancerTB freelancer = fp.FreelancerByID(FreelancerID);
       return freelancer;
        
    }
    
    @PUT
    @RolesAllowed("Admin")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("ChangeStatusFreelancer/{fid}/{isactive}")
    public void ChangeStatusFreelancer(@PathParam("fid") Integer id,@PathParam("isactive") Integer isActive) {
        fp.ChangeStatusFreelancer(id, isActive);
    }
    
    @PUT
    @RolesAllowed("Admin")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("ChangeStatusCompany/{cid}/{isactive}")
    public void ChangeStatusCompany(@PathParam("cid") Integer CompanyID,@PathParam("isactive") Integer isActive) {
        fp.ChangeStatusCompany(CompanyID, isActive);
    }
    
    

   @GET
   @RolesAllowed({"Admin","Company"})
   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Collection<FreelancerTB> GetAllFreelancer() {
        Collection<FreelancerTB> freelancers = fp.GetAllFreelancer();
        return freelancers;
    }


    
    @POST
    @Path("AddFreelancer/{email}/{password}/{college}/{profileImage}/"
            + "{aboutself}/{weeklyavilable}/{categoryid}/{stateid}/"
            + "{cityid}/{degreeid}/{englishid}/{expertizeid}/{hourlyrateid}/{isactive}")
    public void AddFreelancer
        (@PathParam("email") String email,@PathParam("password") String password,
        @PathParam("college") String college,@PathParam("profileImage") String profileImage,
        @PathParam("aboutself") String aboutSelf,@PathParam("weeklyavilable") String weeklyAvailable,
        @PathParam("categoryid") Integer categoryID,@PathParam("stateid") Integer stateID,
        @PathParam("cityid") Integer cityID,@PathParam("degreeid") Integer degreeID,
        @PathParam("englishid") Integer englishLevelID,@PathParam("expertizeid") Integer expertizeLevelID,
        @PathParam("hourlyrateid") Integer hourlyRateID,@PathParam("isactive") Integer isActive) {
       fp.AddFreelancer(email, password, college, profileImage, aboutSelf, weeklyAvailable, categoryID, stateID, cityID, degreeID, englishLevelID, expertizeLevelID, hourlyRateID, isActive);
        
    }
    
    @RolesAllowed("Freelancer")    
    @DELETE
    @Path("DeleteFreelancer/{fid}/{cateid}/{sid}/{cid}/{did}/{englishid}/{expertizeid}/{hourlyrate}")
    public void DeleteFreelancer(@PathParam("fid") Integer FreelancerID,@PathParam("cateid") Integer categoryID,
            @PathParam("sid") Integer stateID,@PathParam("cid") Integer cityID,@PathParam("did") Integer degreeID,
           @PathParam("englishid") Integer englishLevelID,@PathParam("expertizeid") Integer expertizeLevelID,
           @PathParam("hourlyrate") Integer hourlyRateID) {
        fp.DeleteFreelancer(FreelancerID, categoryID, stateID, cityID, degreeID, englishLevelID, expertizeLevelID, hourlyRateID);
    }
    
    @RolesAllowed("Freelancer")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("UpdateFreelancer/{fid}/{email}/{password}/{college}/{profileImage}/"
            + "{aboutself}/{weeklyavilable}/{categoryid}/{stateid}/"
            + "{cityid}/{degreeid}/{englishid}/{expertizeid}/{hourlyrateid}/{isactive}")
    public void UpdateFreelancer(@PathParam("fid") Integer FreelancerID, @PathParam("email") String email,@PathParam("password") String password,
        @PathParam("college") String college,@PathParam("profileImage") String profileImage,
        @PathParam("aboutself") String aboutSelf,@PathParam("weeklyavilable") String weeklyAvailable,
        @PathParam("categoryid") Integer categoryID,@PathParam("stateid") Integer stateID,
        @PathParam("cityid") Integer cityID,@PathParam("degreeid") Integer degreeID,
        @PathParam("englishid") Integer englishLevelID,@PathParam("expertizeid") Integer expertizeLevelID,
        @PathParam("hourlyrateid") Integer hourlyRateID,@PathParam("isactive") Integer isActive) {
        fp.UpdateFreelancer(FreelancerID, email, password, college, profileImage, aboutSelf, weeklyAvailable, categoryID, stateID, cityID, degreeID, englishLevelID, expertizeLevelID, hourlyRateID, isActive);
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllCompany")
    public Collection<CompanyTB> GetAllCompany() {
       Collection<CompanyTB> companys = fp.GetAllCompany();
        return companys;
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllWorkPost")
    public Collection<WorkPostTB> GetAllWorkPost() {
        Collection<WorkPostTB> workPosts = fp.GetAllWorkPost();
        return workPosts;
    }
    
    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllWorkPostByCompany/{cid}")
     public Collection<WorkPostTB> GetAllWorkPostByCompany(@PathParam("cid") Integer CompanyID) {
        Collection<WorkPostTB> workPosts = fp.GetAllWorkPostByCompany(CompanyID);
        return workPosts;
    }

    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllState")
    public Collection<StateTB> GetAllState() {
       Collection<StateTB> states = fp.GetAllState();
        return states;
    }

    @RolesAllowed("Admin")
    @POST
    @Path("AddState/{statename}")
    public void AddState(@PathParam("statename") String StateName) {
        fp.AddState(StateName);
    }

    @RolesAllowed("Admin")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("UpdateState/{sid}/{name}")
    public void UpdateState(@PathParam("sid") Integer StateID,@PathParam("name") String StateName) {
        fp.UpdateState(StateID, StateName);
    }

    @RolesAllowed("Admin")
    @DELETE
    @Path("DeleteState/{sid}")
    public void DeleteState(@PathParam("sid") Integer StateID) {
        fp.DeleteState(StateID);
    }
    
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllCity")
    public Collection<CityTB> GetAllCity() {
        Collection<CityTB> citys = fp.GetAllCity();
        return citys;
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllStateWiseCity/{sid}")
    public Collection<CityTB> GetAllStateWiseCity(@PathParam("sid") Integer StateID) {
        Collection<CityTB> cities = fp.GetAllStateWiseCity(StateID);
        return cities;
    }

    @RolesAllowed("Admin")
    @POST
    @Path("AddStateWiseCity/{cityname}/{stateid}")
    public void AddStateWiseCity(@PathParam("cityname") String CityName,@PathParam("stateid") Integer StateID) {
        fp.AddStateWiseCity(CityName, StateID);
    }

    @RolesAllowed("Admin")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("UpdateStateWiseCity/{cid}/{cityname}/{sid}")
    public void UpdateStateWiseCity(@PathParam("cid") Integer CityID,@PathParam("cityname") String CityName,@PathParam("sid") Integer StateID) {
       fp.UpdateStateWiseCity(CityID, CityName, StateID);
    }

    @RolesAllowed("Admin")
    @DELETE
    @Path("DeleteStateWiseCity/{cid}/{sid}")
    public void DeleteStateWiseCity(@PathParam("cid") Integer CityID,@PathParam("sid") Integer StateID) {
       fp.DeleteStateWiseCity(CityID, StateID);
    }

    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllProjectScope")
    public Collection<ProjectScopeTB> GetAllProjectScope() {
       Collection<ProjectScopeTB> projectScopes = fp.GetAllProjectScope();
        return projectScopes;
    }
    
    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetProjectScopeByID/{pid}")
    public Collection<ProjectScopeTB> GetProjectScopeByID(@PathParam("pid") Integer ProjectScopeID) {
        Collection<ProjectScopeTB> projectScopeTBs = fp.GetProjectScopeByID(ProjectScopeID);
        return projectScopeTBs;
    }

    @RolesAllowed("Admin")
    @POST
    @Path("AddProjectScope/{scope}")
    public void AddProjectScope(@PathParam("scope") String Scope) {
        fp.AddProjectScope(Scope);
    }

    @RolesAllowed("Admin")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("UpdateProjectScope/{psid}/{scope}")
    public void UpdateProjectScope(@PathParam("psid") Integer ProjectScopeID,@PathParam("scope") String Scope) {
        fp.UpdateProjectScope(ProjectScopeID, Scope);
    }

    @RolesAllowed("Admin")
    @DELETE
    @Path("DeleteProjectScope/{psid}")
    public void DeleteProjectScope(@PathParam("psid") Integer ProjectScopeID) {
       fp.DeleteProjectScope(ProjectScopeID);
    }

   
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllExpertizeLevel")
    public Collection<ExpertizeLevelTB> GetAllExpertizeLevel() {
        Collection<ExpertizeLevelTB> expertizeLevels = fp.GetAllExpertizeLevel();
        return expertizeLevels;
    }

    @RolesAllowed("Admin")
    @POST
    @Path("AddExpertizeLevel/{level}")
    public void AddExpertizeLevel(@PathParam("level") String Levels) {
       fp.AddExpertizeLevel(Levels);
    }

    @RolesAllowed("Admin")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("UpdateExpertizeLevel/{eid}/{level}")
    public void UpdateExpertizeLevel(@PathParam("eid") Integer ExpertizeLevelID,@PathParam("level") String Levels) {
       fp.UpdateExpertizeLevel(ExpertizeLevelID, Levels);
    }

    @RolesAllowed("Admin")
    @DELETE
    @Path("DeleteExpertizeLevel/{eid}")
    public void DeleteExpertizeLevel(@PathParam("eid") Integer ExpertizeLevelID) {
       fp.DeleteExpertizeLevel(ExpertizeLevelID);
    }

    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllHourlyRate")
    public Collection<HourlyRateTB> GetAllHourlyRate() {
       Collection<HourlyRateTB> hourlyRates = fp.GetAllHourlyRate();
        return hourlyRates;
    }

    @RolesAllowed("Admin")
    @POST
    @Path("AddHourlyRate/{rate}")
    public void AddHourlyRate(@PathParam("rate") String rate) {
        fp.AddHourlyRate(rate);
    }

    @RolesAllowed("Admin")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("UpdateHourlyRate/{hid}/{rate}")
    public void UpdateHourlyRate(@PathParam("hid") Integer HourlyRateID,@PathParam("rate") String rate) {
       fp.UpdateHourlyRate(HourlyRateID, rate);
    }

    @RolesAllowed("Admin")
    @DELETE
    @Path("DeleteHourlyRate/{hid}")
    public void DeleteHourlyRate(@PathParam("hid") Integer HourlyRateID) {
       fp.DeleteHourlyRate(HourlyRateID);
    }

    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllEnglishLevel")
    public Collection<EnglsihLevelTB> GetAllEnglishLevel() {
        Collection<EnglsihLevelTB> englsihLevels = fp.GetAllEnglishLevel();
        return englsihLevels;
    }

    @RolesAllowed("Admin")
    @POST
    @Path("AddEnglsihLevel/{englishlevel}")
    public void AddEnglsihLevel(@PathParam("englishlevel") String englishLevels) {
       fp.AddEnglsihLevel(englishLevels);
    }
    
    
    @RolesAllowed("Admin")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("UpdateEnglsihLevel/{eid}/{levels}")
    public void UpdateEnglsihLevel(@PathParam("eid") Integer EnglishLevelID,@PathParam("levels") String englishLevels) {
      fp.UpdateEnglsihLevel(EnglishLevelID, englishLevels);
    }

    @RolesAllowed("Admin")
    @DELETE
    @Path("DeleteEnglsihLevel/{eid}")
    public void DeleteEnglsihLevel(@PathParam("eid") Integer EnglishLevelID) {
        fp.DeleteEnglsihLevel(EnglishLevelID);
    }

    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllDegree")
    public Collection<DegreeTB> GetAllDegree() {
        Collection<DegreeTB> degrees  = fp.GetAllDegree();
        return degrees;
    }

    @RolesAllowed("Admin")
    @POST
    @Path("AddDegree/{degree}")
    public void AddDegree(@PathParam("degree") String degree) {
       fp.AddDegree(degree);
    }

    @RolesAllowed("Admin")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("UpdateDegree/{did}/{degree}")
    public void UpdateDegree(@PathParam("did") Integer DegreeID,@PathParam("degree") String degree) {
       fp.UpdateDegree(DegreeID, degree);
    }

    @RolesAllowed("Admin")
    @DELETE
    @Path("DeleteDegree/{did}")
    public void DeleteDegree(@PathParam("did") Integer DegreeID) {
        fp.DeleteDegree(DegreeID);
    }

   
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllSkill")
    public Collection<SkillTB> GetAllSkill() {
        Collection<SkillTB> skills = fp.GetAllSkill();
        return skills;
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @POST
    @Path("AddSkill/{skills}/{cateid}")
    public void AddSkill(@PathParam("skills") String skills,@PathParam("cateid") Integer CategoryID) {
       fp.AddSkill(skills, CategoryID);
    }


    @RolesAllowed({"Admin","Company","Freelancer"})
    @PUT
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("UpdateSkill/{skillid}/{skills}/{cateid}")
    public void UpdateSkill(@PathParam("skillid") Integer SkillID,@PathParam("skills") String skills,@PathParam("cateid") Integer CategoryID) {
       fp.UpdateSkill(SkillID, skills, CategoryID);
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @DELETE
    @Path("DeleteSkill/{skillid}")
    public void DeleteSkill(@PathParam("skillid") Integer SkillID) {
        fp.DeleteSkill(SkillID);
    }

    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllCategory")
    public Collection<CategoryTB> GetAllCategory() {
       Collection<CategoryTB> categorys = fp.GetAllCategory();
        return categorys;
    }

    @RolesAllowed("Admin")
    @POST
    @Path("AddCategory/{catename}")
    public void AddCategory(@PathParam("catename") String categoryName) {
        fp.AddCategory(categoryName);
    }

    @RolesAllowed("Admin")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("UpdateCategory/{cid}/{catename}")
    public void UpdateCategory(@PathParam("cid") Integer CategoryID,@PathParam("catename") String categoryName) {
        fp.UpdateCategory(CategoryID, categoryName);
    }

    @RolesAllowed("Admin")
    @DELETE
    @Path("DeleteCategory/{cateid}")
    public void DeleteCategory(@PathParam("cateid") Integer CategoryID) {
        fp.DeleteCategory(CategoryID);
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllCertificate/{fid}")
    public Collection<CertificateTB> GetAllCertificate(@PathParam("fid") Integer FreelancerID) {
        Collection<CertificateTB> certificates = fp.GetAllCertificate(FreelancerID);
        return certificates;
    }

    @RolesAllowed("Freelancer")
    @POST
    @Path("AddCertificate/{file}/{fid}")
    public void AddCertificate(@PathParam("file") String certificateFile,@PathParam("fid") Integer FreelancerID) {
        fp.AddCertificate(certificateFile, FreelancerID);
    }

    @RolesAllowed("Freelancer")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("UpdateCertificate/{cid}/{file}/{fid}")
    public void UpdateCertificate(@PathParam("cid") Integer CertificateID,
           @PathParam("file") String certificateFile,@PathParam("fid") Integer FreelancerID) {
        fp.UpdateCertificate(CertificateID, certificateFile, FreelancerID);
    }

    @RolesAllowed("Freelancer")
    @DELETE
    @Path("DeleteCertificate/{cid}/{fid}")
    public void DeleteCertificate(@PathParam("cid") Integer CertificateID,@PathParam("fid") Integer FreelancerID) {
      fp.DeleteCertificate(CertificateID, FreelancerID);
    }

    @RolesAllowed("Freelancer")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllPayment/{fid}")
    public Collection<PaymentTB> GetAllPayment(@PathParam("fid") Integer FreelancerID) {
       Collection<PaymentTB> payments = fp.GetAllPayment(FreelancerID);
        return payments;
    }

    @RolesAllowed("Company")
    @POST
    @Path("AddPayment/{amount}/{fid}")
    public void AddPayment(@PathParam("amount") String totalAmount,@PathParam("fid") Integer FreelancerID) {
       fp.AddPayment(totalAmount, FreelancerID);
        
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllSkillFreelancer/{fid}")
    public Collection<SkillTB> GetAllSkillFreelancer(@PathParam("fid") Integer FreelancerID) {
       Collection<SkillTB> Freelancerskills = fp.GetAllSkillFreelancer(FreelancerID);
        return Freelancerskills;
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @POST
    @Path("AddSkillFreelancer/{fid}")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public void AddSkillFreelancer(@PathParam("fid") Integer FreelancerID, Collection<Integer> ids) {
        fp.AddSkillFreelancer(FreelancerID, ids);
    }

    @RolesAllowed("Freelancer")
    @POST
    @Path("DeleteSkillFreelancer/{fid}")
    public void DeleteSkillFreelancer(@PathParam("fid") Integer FreelancerID, Collection<Integer> ids) {
        fp.DeleteSkillFreelancer(FreelancerID, ids);
       
    }

    
    @POST
    @Path("AddCompany/{cname}/{oname}/{email}/{password}/{staff}/{cnumber}/{isactive}/{sid}/{cid}/{logo}")
    public void AddCompany(@PathParam("cname") String companyName,@PathParam("oname") String companyOwnerName,
           @PathParam("email") String companyEmail,@PathParam("password") String companyOwnerPassword,
           @PathParam("staff") Integer companyStaff,@PathParam("cnumber") String contactNumber,
           @PathParam("isactive") Integer isActive,
           @PathParam("sid") Integer StateID,@PathParam("cid") Integer CityID,@PathParam("logo") String companyLogo) {
        fp.AddCompany(companyName, companyOwnerName, companyEmail, companyOwnerPassword, companyStaff, contactNumber, isActive, StateID, CityID, companyLogo);
        
    }

    @RolesAllowed("Company")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("UpdateCompany/{companyid}/{cname}/{oname}/{email}/{password}/{staff}/{cnumber}/{isactive}/{sid}/{cid}/{logo}")
    public void UpdateCompany(@PathParam("companyid") Integer CompanyID,@PathParam("cname") String companyName,@PathParam("oname") String companyOwnerName,
           @PathParam("email") String companyEmail,@PathParam("password") String companyOwnerPassword,
           @PathParam("staff") Integer companyStaff,@PathParam("cnumber") String contactNumber,
           @PathParam("isactive") Integer isActive,
           @PathParam("sid") Integer StateID,@PathParam("cid") Integer CityID,@PathParam("logo") String companyLogo) {

       fp.UpdateCompany(CompanyID, companyName, companyOwnerName, companyEmail, companyOwnerPassword, companyStaff, contactNumber, isActive, StateID, CityID, companyLogo);
        
    }

    
    @POST
    @Path("AddWorkPost/{title}/{desc}/{date}/{pid}/{expertizeid}/{hid}/{englishid}/{cateid}/{compid}")
    public void AddWorkPost(@PathParam("title") String workTitle,@PathParam("desc") String workDescription, 
           @PathParam("date") String workPostDate,@PathParam("pid") Integer projectScopeID,
           @PathParam("expertizeid") Integer expertizeLevelID,@PathParam("hid") Integer hourlyRateID,
           @PathParam("englishid") Integer englishLevelID,@PathParam("cateid") Integer categoryID,@PathParam("compid") Integer companyID) {

       fp.AddWorkPost(workTitle, workDescription, workPostDate, projectScopeID, expertizeLevelID, hourlyRateID, englishLevelID, categoryID, companyID);
    }

    @RolesAllowed("Company")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("UpdateWorkPost/{wpid}/{title}/{desc}/{date}/{pid}/{expertizeid}/{hid}/{englishid}/{cateid}/{compid}")
    public void UpdateWorkPost(@PathParam("wpid") Integer workPostID,@PathParam("title") String workTitle,@PathParam("desc") String workDescription, 
           @PathParam("date") String workPostDate,@PathParam("pid") Integer projectScopeID,
           @PathParam("expertizeid") Integer expertizeLevelID,@PathParam("hid") Integer hourlyRateID,
           @PathParam("englishid") Integer englishLevelID,@PathParam("cateid") Integer categoryID,@PathParam("compid") Integer companyID) {

        fp.UpdateWorkPost(workPostID, workTitle, workDescription, workPostDate, projectScopeID, expertizeLevelID, hourlyRateID, englishLevelID, categoryID, companyID);
    }

    @RolesAllowed("Company")
    @DELETE
    @Path("DeleteWorkPost/{wpid}/{psid}/{elid}/{hrid}/{englishid}/{cateid}/{compid}")
    public void DeleteWorkPost(@PathParam("wpid") Integer workPostID,@PathParam("psid") Integer projectScopeID,
           @PathParam("elid") Integer expertizeLevelID,@PathParam("hrid") Integer hourlyRateID,
           @PathParam("englishid") Integer englishLevelID,@PathParam("cateid") Integer categoryID,@PathParam("compid") Integer companyID) {
           fp.DeleteWorkPost(workPostID, projectScopeID, expertizeLevelID, hourlyRateID, englishLevelID, categoryID, companyID);
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllWorkPostFreelancerSkill/{wpid}")
    public Collection<SkillTB> GetAllWorkPostFreelancerSkill(@PathParam("wpid") Integer workPostID) {
        Collection<SkillTB> WorkPostSkills = fp.GetAllWorkPostFreelancerSkill(workPostID);
        return WorkPostSkills;
    }

    @RolesAllowed("Company")
    @POST
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("AddWorkPostFreelancerSkill/{wpid}")
    public void AddWorkPostFreelancerSkill(@PathParam("wpid") Integer workPostID, Collection<Integer> ids) {

        fp.AddWorkPostFreelancerSkill(workPostID, ids);
    }

    @RolesAllowed("Company")
    @POST
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("DeleteWorkPostFreelancerSkill/{wpid}")
    public void DeleteWorkPostFreelancerSkill(@PathParam("wpid") Integer workPostID, Collection<Integer> ids) {
        fp.DeleteWorkPostFreelancerSkill(workPostID, ids);
    }


    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllReview/{fid}")
    public Collection<ReviewTB> GetAllReview(@PathParam("fid") Integer FreelancerID) {
        Collection<ReviewTB> reviews = fp.GetAllReview(FreelancerID);
        return reviews;
    }

    @RolesAllowed("Company")
    @POST
    @Path("AddReview/{review}/{fid}/{compid}")
    public void AddReview(@PathParam("review") String review,@PathParam("fid") Integer FreelancerID,@PathParam("compid") Integer CompanyID) {
           fp.AddReview(review, FreelancerID, CompanyID);
        
    }

    @RolesAllowed("Company")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("UpdateReview/{rid}/{review}/{fid}/{compid}")
    public void UpdateReview(@PathParam("rid") Integer ReviewID,@PathParam("review") String review,@PathParam("fid") Integer FreelancerID,@PathParam("compid") Integer CompanyID) {

        fp.UpdateReview(ReviewID, review, FreelancerID, CompanyID);
    }

    @RolesAllowed("Company")
    @DELETE
    @Path("DeleteReview/{rid}/{fid}/{compid}")
    public void DeleteReview(@PathParam("rid") Integer ReviewID,@PathParam("fid") Integer FreelancerID,
           @PathParam("compid") Integer CompanyID) {
        fp.DeleteReview(ReviewID, FreelancerID, CompanyID);
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllReviewByCompanyID/{rid}")
    public Collection<CompanyTB> GetAllReviewByCompanyID(@PathParam("rid") Integer ReviewID) {
        
        Collection<CompanyTB> ReviewByComp = fp.GetAllReviewByCompanyID(ReviewID);
        return ReviewByComp;
    }
    
    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllCompanyByID/{wpid}") 
   public Collection<CompanyTB> GetAllCompanyByID(@PathParam("wpid") Integer workPostID) {
        Collection<CompanyTB> company = fp.GetAllCompanyByID(workPostID);
        return company;
    }
   
   @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllFreelancerById/{fid}") 
   public Collection<FreelancerTB> GetAllFreelancerById(@PathParam("fid") Integer FreelancerID) {
        Collection<FreelancerTB> freelancers = fp.GetAllFreelancerById(FreelancerID);
        return freelancers;
    }

    @RolesAllowed({"Admin","Company","Freelancer"})
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("GetAllCompanyByCompanyID/{compid}") 
    public Collection<CompanyTB> GetAllCompanyByCompanyID(@PathParam("compid") Integer CompanyID) {
        Collection<CompanyTB> companys = fp.GetAllCompanyByCompanyID(CompanyID);
        return companys;
    }

}
