/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:FreelancerResource
 * [Freelancer]<br>
 * USAGE:
 * <pre>
 *        FreelancerClient client = new FreelancerClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author brinda
 */
public class FreelancerClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "https://localhost:8181/ProjectWebApp/webresources";

    public FreelancerClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
         client.register(new MyRestFilter(token));
        webTarget = client.target(BASE_URI).path("Freelancer");
    }
    
    static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier() {

            public boolean verify(String hostname,
                    javax.net.ssl.SSLSession sslSession) {
                if (hostname.equals("localhost")) {
                    return true;
                }
                return false;
            }
        });
    }
    
    public FreelancerClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("Freelancer");
    }

    public void DeleteCategory(String cateid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteCategory/{0}", new Object[]{cateid})).request().delete();
    }

    public void AdminChangePassword_XML(Object requestEntity, String aid, String Password) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AdminChangePassword/{0}/{1}", new Object[]{aid, Password})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void AdminChangePassword_JSON(Object requestEntity, String aid, String Password) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AdminChangePassword/{0}/{1}", new Object[]{aid, Password})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T GetAllCompany_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllCompany");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllCompany_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllCompany");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllCompanyStatusIsZero_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllCompanyStatusIsZero");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllCompanyStatusIsZero_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllCompanyStatusIsZero");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllState_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllState");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllState_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllState");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void DeleteProjectScope(String psid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteProjectScope/{0}", new Object[]{psid})).request().delete();
    }

    public void AddState(String statename) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddState/{0}", new Object[]{statename})).request().post(null);
    }

    public <T> T GetAllPayment_XML(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllPayment/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllPayment_JSON(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllPayment/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateCategory_XML(Object requestEntity, String cid, String catename) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateCategory/{0}/{1}", new Object[]{cid, catename})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void UpdateCategory_JSON(Object requestEntity, String cid, String catename) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateCategory/{0}/{1}", new Object[]{cid, catename})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T SerachByHourlyRate_XML(Class<T> responseType, String start, String end) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SerachByHourlyRate/{0}/{1}", new Object[]{start, end}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T SerachByHourlyRate_JSON(Class<T> responseType, String start, String end) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SerachByHourlyRate/{0}/{1}", new Object[]{start, end}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllWorkPostByCompany_XML(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllWorkPostByCompany/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllWorkPostByCompany_JSON(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllWorkPostByCompany/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllDegree_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllDegree");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllDegree_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllDegree");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllFreelancer_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllFreelancer_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetCompanyWiseConfirmedFreelancer_XML(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetCompanyWiseConfirmedFreelancer/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetCompanyWiseConfirmedFreelancer_JSON(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetCompanyWiseConfirmedFreelancer/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetCompanyWiseCompletedFreelancer_XML(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetCompanyWiseCompletedFreelancer/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetCompanyWiseCompletedFreelancer_JSON(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetCompanyWiseCompletedFreelancer/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetWorkPostWiseAppliedFreelancer_XML(Class<T> responseType, String wid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetWorkPostWiseAppliedFreelancer/{0}", new Object[]{wid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetWorkPostWiseAppliedFreelancer_JSON(Class<T> responseType, String wid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetWorkPostWiseAppliedFreelancer/{0}", new Object[]{wid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateFreelancer_XML(Object requestEntity, String fid, String email, String password, String college, String profileImage, String aboutself, String weeklyavilable, String categoryid, String stateid, String cityid, String degreeid, String englishid, String expertizeid, String hourlyrateid, String isactive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateFreelancer/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}", new Object[]{fid, email, password, college, profileImage, aboutself, weeklyavilable, categoryid, stateid, cityid, degreeid, englishid, expertizeid, hourlyrateid, isactive})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void UpdateFreelancer_JSON(Object requestEntity, String fid, String email, String password, String college, String profileImage, String aboutself, String weeklyavilable, String categoryid, String stateid, String cityid, String degreeid, String englishid, String expertizeid, String hourlyrateid, String isactive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateFreelancer/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}", new Object[]{fid, email, password, college, profileImage, aboutself, weeklyavilable, categoryid, stateid, cityid, degreeid, englishid, expertizeid, hourlyrateid, isactive})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void AddBidding(String WorkPostID, String FreelancerID, String BiddingRate) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddBidding/{0}/{1}/{2}", new Object[]{WorkPostID, FreelancerID, BiddingRate})).request().post(null);
    }

    public void DeleteCertificate(String cid, String fid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteCertificate/{0}/{1}", new Object[]{cid, fid})).request().delete();
    }

    public <T> T FreelancerByID_XML(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("FreelancerByID/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T FreelancerByID_JSON(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("FreelancerByID/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void DeleteHourlyRate(String hid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteHourlyRate/{0}", new Object[]{hid})).request().delete();
    }

    public <T> T GetAllReview_XML(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllReview/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllReview_JSON(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllReview/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllExpertizeLevel_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllExpertizeLevel");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllExpertizeLevel_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllExpertizeLevel");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllSkill_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllSkill");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllSkill_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllSkill");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllBiddingByWorkPostID_XML(Class<T> responseType, String WorkPostID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllBiddingByWorkPostID/{0}", new Object[]{WorkPostID}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllBiddingByWorkPostID_JSON(Class<T> responseType, String WorkPostID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllBiddingByWorkPostID/{0}", new Object[]{WorkPostID}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateCompany_XML(Object requestEntity, String companyid, String cname, String oname, String email, String password, String staff, String cnumber, String isactive, String sid, String cid, String logo) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateCompany/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}", new Object[]{companyid, cname, oname, email, password, staff, cnumber, isactive, sid, cid, logo})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void UpdateCompany_JSON(Object requestEntity, String companyid, String cname, String oname, String email, String password, String staff, String cnumber, String isactive, String sid, String cid, String logo) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateCompany/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}", new Object[]{companyid, cname, oname, email, password, staff, cnumber, isactive, sid, cid, logo})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T GetAllConfirmedByFreelancerID_XML(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllConfirmedByFreelancerID/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllConfirmedByFreelancerID_JSON(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllConfirmedByFreelancerID/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetWorkPostWiseOngoingFreelancer_XML(Class<T> responseType, String wid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetWorkPostWiseOngoingFreelancer/{0}", new Object[]{wid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetWorkPostWiseOngoingFreelancer_JSON(Class<T> responseType, String wid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetWorkPostWiseOngoingFreelancer/{0}", new Object[]{wid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllEnglishLevel_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllEnglishLevel");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllEnglishLevel_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllEnglishLevel");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetProjectScopeByID_XML(Class<T> responseType, String pid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetProjectScopeByID/{0}", new Object[]{pid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetProjectScopeByID_JSON(Class<T> responseType, String pid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetProjectScopeByID/{0}", new Object[]{pid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllFreelancerById_XML(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllFreelancerById/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllFreelancerById_JSON(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllFreelancerById/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllCompanyByCompanyID_XML(Class<T> responseType, String compid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllCompanyByCompanyID/{0}", new Object[]{compid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllCompanyByCompanyID_JSON(Class<T> responseType, String compid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllCompanyByCompanyID/{0}", new Object[]{compid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetWorkPostWiseConfirmFreelancer_XML(Class<T> responseType, String wid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetWorkPostWiseConfirmFreelancer/{0}", new Object[]{wid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetWorkPostWiseConfirmFreelancer_JSON(Class<T> responseType, String wid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetWorkPostWiseConfirmFreelancer/{0}", new Object[]{wid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetCompanyWiseOngoingFreelancer_XML(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetCompanyWiseOngoingFreelancer/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetCompanyWiseOngoingFreelancer_JSON(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetCompanyWiseOngoingFreelancer/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateDegree_XML(Object requestEntity, String did, String degree) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateDegree/{0}/{1}", new Object[]{did, degree})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void UpdateDegree_JSON(Object requestEntity, String did, String degree) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateDegree/{0}/{1}", new Object[]{did, degree})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T GetAllSkillFreelancer_XML(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllSkillFreelancer/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllSkillFreelancer_JSON(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllSkillFreelancer/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllApprovedByFreelancerID_XML(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllApprovedByFreelancerID/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllApprovedByFreelancerID_JSON(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllApprovedByFreelancerID/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void AddLoginDetails(String uname, String pass, String uid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddLoginDetails/{0}/{1}/{2}", new Object[]{uname, pass, uid})).request().post(null);
    }

    public void DeleteState(String sid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteState/{0}", new Object[]{sid})).request().delete();
    }

    public void UpdateSkill_XML(Object requestEntity, String skillid, String skills, String cateid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateSkill/{0}/{1}/{2}", new Object[]{skillid, skills, cateid})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void UpdateSkill_JSON(Object requestEntity, String skillid, String skills, String cateid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateSkill/{0}/{1}/{2}", new Object[]{skillid, skills, cateid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void DeleteStateWiseCity(String cid, String sid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteStateWiseCity/{0}/{1}", new Object[]{cid, sid})).request().delete();
    }

    public <T> T GetAllCertificate_XML(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllCertificate/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllCertificate_JSON(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllCertificate/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllReviewByCompanyID_XML(Class<T> responseType, String rid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllReviewByCompanyID/{0}", new Object[]{rid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllReviewByCompanyID_JSON(Class<T> responseType, String rid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllReviewByCompanyID/{0}", new Object[]{rid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateWorkPost_XML(Object requestEntity, String wpid, String title, String desc, String date, String pid, String expertizeid, String hid, String englishid, String cateid, String compid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateWorkPost/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}", new Object[]{wpid, title, desc, date, pid, expertizeid, hid, englishid, cateid, compid})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void UpdateWorkPost_JSON(Object requestEntity, String wpid, String title, String desc, String date, String pid, String expertizeid, String hid, String englishid, String cateid, String compid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateWorkPost/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}", new Object[]{wpid, title, desc, date, pid, expertizeid, hid, englishid, cateid, compid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void UpdateProjectScope_XML(Object requestEntity, String psid, String scope) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateProjectScope/{0}/{1}", new Object[]{psid, scope})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void UpdateProjectScope_JSON(Object requestEntity, String psid, String scope) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateProjectScope/{0}/{1}", new Object[]{psid, scope})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void DeleteExpertizeLevel(String eid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteExpertizeLevel/{0}", new Object[]{eid})).request().delete();
    }

    public <T> T GetAllWorkPost_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllWorkPost");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllWorkPost_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllWorkPost");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllWorkPostFreelancerSkill_XML(Class<T> responseType, String wpid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllWorkPostFreelancerSkill/{0}", new Object[]{wpid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllWorkPostFreelancerSkill_JSON(Class<T> responseType, String wpid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllWorkPostFreelancerSkill/{0}", new Object[]{wpid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void DeleteDegree(String did) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteDegree/{0}", new Object[]{did})).request().delete();
    }

    public void ChangeStatusFreelancer_XML(Object requestEntity, String fid, String isactive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("ChangeStatusFreelancer/{0}/{1}", new Object[]{fid, isactive})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void ChangeStatusFreelancer_JSON(Object requestEntity, String fid, String isactive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("ChangeStatusFreelancer/{0}/{1}", new Object[]{fid, isactive})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T GetAllOngoingByFreelancerID_XML(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllOngoingByFreelancerID/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllOngoingByFreelancerID_JSON(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllOngoingByFreelancerID/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void AddProjectScope(String scope) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddProjectScope/{0}", new Object[]{scope})).request().post(null);
    }

    public void AddSkillFreelancer_XML(Object requestEntity, String fid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddSkillFreelancer/{0}", new Object[]{fid})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void AddSkillFreelancer_JSON(Object requestEntity, String fid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddSkillFreelancer/{0}", new Object[]{fid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T SerachByHourlyRateFromWorkPost_XML(Class<T> responseType, String start, String end) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SerachByHourlyRateFromWorkPost/{0}/{1}", new Object[]{start, end}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T SerachByHourlyRateFromWorkPost_JSON(Class<T> responseType, String start, String end) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SerachByHourlyRateFromWorkPost/{0}/{1}", new Object[]{start, end}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void DeleteEnglsihLevel(String eid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteEnglsihLevel/{0}", new Object[]{eid})).request().delete();
    }

    public void AddCompany(String cname, String oname, String email, String password, String staff, String cnumber, String isactive, String sid, String cid, String logo) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddCompany/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}", new Object[]{cname, oname, email, password, staff, cnumber, isactive, sid, cid, logo})).request().post(null);
    }

    public void AddHourlyRate(String rate) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddHourlyRate/{0}", new Object[]{rate})).request().post(null);
    }

    public <T> T GetAllBiddingByFreelancerID_XML(Class<T> responseType, String FreelancerID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllBiddingByFreelancerID/{0}", new Object[]{FreelancerID}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllBiddingByFreelancerID_JSON(Class<T> responseType, String FreelancerID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllBiddingByFreelancerID/{0}", new Object[]{FreelancerID}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T SerachByFreelancerName_XML(Class<T> responseType, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SerachByFreelancerName/{0}", new Object[]{email}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T SerachByFreelancerName_JSON(Class<T> responseType, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SerachByFreelancerName/{0}", new Object[]{email}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetWorkPostWiseCompletedFreelancer_XML(Class<T> responseType, String wid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetWorkPostWiseCompletedFreelancer/{0}", new Object[]{wid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetWorkPostWiseCompletedFreelancer_JSON(Class<T> responseType, String wid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetWorkPostWiseCompletedFreelancer/{0}", new Object[]{wid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void DeleteSkill(String skillid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteSkill/{0}", new Object[]{skillid})).request().delete();
    }

    public void UpdateReview_XML(Object requestEntity, String rid, String review, String fid, String compid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateReview/{0}/{1}/{2}/{3}", new Object[]{rid, review, fid, compid})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void UpdateReview_JSON(Object requestEntity, String rid, String review, String fid, String compid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateReview/{0}/{1}/{2}/{3}", new Object[]{rid, review, fid, compid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void AddWorkPost(String title, String desc, String date, String pid, String expertizeid, String hid, String englishid, String cateid, String compid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddWorkPost/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{title, desc, date, pid, expertizeid, hid, englishid, cateid, compid})).request().post(null);
    }

    public void AddDegree(String degree) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddDegree/{0}", new Object[]{degree})).request().post(null);
    }

    public void AddWorkPostFreelancerSkill_XML(Object requestEntity, String wpid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddWorkPostFreelancerSkill/{0}", new Object[]{wpid})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void AddWorkPostFreelancerSkill_JSON(Object requestEntity, String wpid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddWorkPostFreelancerSkill/{0}", new Object[]{wpid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T GetApplyID_XML(Class<T> responseType, String s, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetApplyID/{0}/{1}", new Object[]{s, id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetApplyID_JSON(Class<T> responseType, String s, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetApplyID/{0}/{1}", new Object[]{s, id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllWorkPostWithCompanyDetails_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllWorkPostWithCompanyDetails");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllWorkPostWithCompanyDetails_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllWorkPostWithCompanyDetails");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateEnglsihLevel_XML(Object requestEntity, String eid, String levels) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateEnglsihLevel/{0}/{1}", new Object[]{eid, levels})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void UpdateEnglsihLevel_JSON(Object requestEntity, String eid, String levels) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateEnglsihLevel/{0}/{1}", new Object[]{eid, levels})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T GetAllStateWiseCity_XML(Class<T> responseType, String sid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllStateWiseCity/{0}", new Object[]{sid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllStateWiseCity_JSON(Class<T> responseType, String sid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllStateWiseCity/{0}", new Object[]{sid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T SerachByCompanyName_XML(Class<T> responseType, String cname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SerachByCompanyName/{0}", new Object[]{cname}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T SerachByCompanyName_JSON(Class<T> responseType, String cname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SerachByCompanyName/{0}", new Object[]{cname}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void DeleteWorkPostFreelancerSkill_XML(Object requestEntity, String wpid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteWorkPostFreelancerSkill/{0}", new Object[]{wpid})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void DeleteWorkPostFreelancerSkill_JSON(Object requestEntity, String wpid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteWorkPostFreelancerSkill/{0}", new Object[]{wpid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void ChangeStatusOfWork_XML(Object requestEntity, String aid, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("ChangeStatusOfWork/{0}/{1}", new Object[]{aid, status})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void ChangeStatusOfWork_JSON(Object requestEntity, String aid, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("ChangeStatusOfWork/{0}/{1}", new Object[]{aid, status})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T GetAllCity_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllCity");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllCity_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllCity");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllApplyByFreelancerID_XML(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllApplyByFreelancerID/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllApplyByFreelancerID_JSON(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllApplyByFreelancerID/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllBidding_XML(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllBidding/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllBidding_JSON(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllBidding/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateState_XML(Object requestEntity, String sid, String name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateState/{0}/{1}", new Object[]{sid, name})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void UpdateState_JSON(Object requestEntity, String sid, String name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateState/{0}/{1}", new Object[]{sid, name})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T GetAllCompletedByFreelancerID_XML(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllCompletedByFreelancerID/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllCompletedByFreelancerID_JSON(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllCompletedByFreelancerID/{0}", new Object[]{fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetCompanyWiseAppliedFreelancer_XML(Class<T> responseType, String cmpid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetCompanyWiseAppliedFreelancer/{0}", new Object[]{cmpid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetCompanyWiseAppliedFreelancer_JSON(Class<T> responseType, String cmpid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetCompanyWiseAppliedFreelancer/{0}", new Object[]{cmpid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void AddReview(String review, String fid, String compid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddReview/{0}/{1}/{2}", new Object[]{review, fid, compid})).request().post(null);
    }

    public void AddEnglsihLevel(String englishlevel) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddEnglsihLevel/{0}", new Object[]{englishlevel})).request().post(null);
    }

    public void AddCategory(String catename) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddCategory/{0}", new Object[]{catename})).request().post(null);
    }

    public void DeleteWorkPost(String wpid, String psid, String elid, String hrid, String englishid, String cateid, String compid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteWorkPost/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{wpid, psid, elid, hrid, englishid, cateid, compid})).request().delete();
    }

    public <T> T GetAllHourlyRate_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllHourlyRate");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllHourlyRate_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllHourlyRate");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetApplyIDFreelancer_XML(Class<T> responseType, String Status, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetApplyIDFreelancer/{0}/{1}", new Object[]{Status, fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetApplyIDFreelancer_JSON(Class<T> responseType, String Status, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetApplyIDFreelancer/{0}/{1}", new Object[]{Status, fid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateStateWiseCity_XML(Object requestEntity, String cid, String cityname, String sid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateStateWiseCity/{0}/{1}/{2}", new Object[]{cid, cityname, sid})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void UpdateStateWiseCity_JSON(Object requestEntity, String cid, String cityname, String sid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateStateWiseCity/{0}/{1}/{2}", new Object[]{cid, cityname, sid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void AddSkill(String skills, String cateid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddSkill/{0}/{1}", new Object[]{skills, cateid})).request().post(null);
    }

    public <T> T GetAllFreelancerStatusIsZero_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllFreelancerStatusIsZero");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllFreelancerStatusIsZero_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllFreelancerStatusIsZero");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllCategory_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllCategory");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllCategory_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllCategory");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllLogins_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllLogins");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllLogins_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllLogins");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateCertificate_XML(Object requestEntity, String cid, String file, String fid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateCertificate/{0}/{1}/{2}", new Object[]{cid, file, fid})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void UpdateCertificate_JSON(Object requestEntity, String cid, String file, String fid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateCertificate/{0}/{1}/{2}", new Object[]{cid, file, fid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T GetAllFreelancerStatusIsOne_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllFreelancerStatusIsOne");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllFreelancerStatusIsOne_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllFreelancerStatusIsOne");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllProjectScope_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllProjectScope");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllProjectScope_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllProjectScope");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T GetAllCompanyStatusIsOne_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllCompanyStatusIsOne");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllCompanyStatusIsOne_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllCompanyStatusIsOne");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void ChangeStatusCompany_XML(Object requestEntity, String cid, String isactive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("ChangeStatusCompany/{0}/{1}", new Object[]{cid, isactive})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void ChangeStatusCompany_JSON(Object requestEntity, String cid, String isactive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("ChangeStatusCompany/{0}/{1}", new Object[]{cid, isactive})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void AddExpertizeLevel(String level) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddExpertizeLevel/{0}", new Object[]{level})).request().post(null);
    }

    public void AddLoginRole_XML(Object requestEntity, String fid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddLoginRole/{0}", new Object[]{fid})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void AddLoginRole_JSON(Object requestEntity, String fid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddLoginRole/{0}", new Object[]{fid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void DeleteSkillFreelancer(String fid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteSkillFreelancer/{0}", new Object[]{fid})).request().post(null);
    }

    public void AddFreelancer(String email, String password, String college, String profileImage, String aboutself, String weeklyavilable, String categoryid, String stateid, String cityid, String degreeid, String englishid, String expertizeid, String hourlyrateid, String isactive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddFreelancer/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}", new Object[]{email, password, college, profileImage, aboutself, weeklyavilable, categoryid, stateid, cityid, degreeid, englishid, expertizeid, hourlyrateid, isactive})).request().post(null);
    }

    public void AddPayment(String amount, String fid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddPayment/{0}/{1}", new Object[]{amount, fid})).request().post(null);
    }

    public <T> T GetCompanyWiseApproveFreelancer_XML(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetCompanyWiseApproveFreelancer/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetCompanyWiseApproveFreelancer_JSON(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetCompanyWiseApproveFreelancer/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void DeleteFreelancer(String fid, String cateid, String sid, String cid, String did, String englishid, String expertizeid, String hourlyrate) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteFreelancer/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{fid, cateid, sid, cid, did, englishid, expertizeid, hourlyrate})).request().delete();
    }

    public void UpdateExpertizeLevel_XML(Object requestEntity, String eid, String level) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateExpertizeLevel/{0}/{1}", new Object[]{eid, level})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void UpdateExpertizeLevel_JSON(Object requestEntity, String eid, String level) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateExpertizeLevel/{0}/{1}", new Object[]{eid, level})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void AddStateWiseCity(String cityname, String stateid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddStateWiseCity/{0}/{1}", new Object[]{cityname, stateid})).request().post(null);
    }

    public void DeleteReview(String rid, String fid, String compid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeleteReview/{0}/{1}/{2}", new Object[]{rid, fid, compid})).request().delete();
    }

    public void DeletePost(String wpid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("DeletePost/{0}", new Object[]{wpid})).request().delete();
    }

    public <T> T GetAllCompanyByID_XML(Class<T> responseType, String wpid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllCompanyByID/{0}", new Object[]{wpid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllCompanyByID_JSON(Class<T> responseType, String wpid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetAllCompanyByID/{0}", new Object[]{wpid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void UpdateHourlyRate_XML(Object requestEntity, String hid, String rate) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateHourlyRate/{0}/{1}", new Object[]{hid, rate})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void UpdateHourlyRate_JSON(Object requestEntity, String hid, String rate) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("UpdateHourlyRate/{0}/{1}", new Object[]{hid, rate})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void AddCertificate(String file, String fid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddCertificate/{0}/{1}", new Object[]{file, fid})).request().post(null);
    }

    public <T> T GetWorkPostWiseApproveFreelancer_XML(Class<T> responseType, String wid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetWorkPostWiseApproveFreelancer/{0}", new Object[]{wid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetWorkPostWiseApproveFreelancer_JSON(Class<T> responseType, String wid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("GetWorkPostWiseApproveFreelancer/{0}", new Object[]{wid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void AddApplyTb(String status, String fid, String wid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("AddApplyTb/{0}/{1}/{2}", new Object[]{status, fid, wid})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
