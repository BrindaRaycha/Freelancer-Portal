/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Client.FreelancerClient;
import Entity.CompanyTB;
import Entity.LoginTB;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import static javax.security.enterprise.AuthenticationStatus.SEND_CONTINUE;
import javax.security.enterprise.SecurityContext;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author root
 */
@Named(value = "loginBean")
@RequestScoped
 public class LoginBean {
    
    @Inject private SecurityContext securityContext;

    private String username;
    private String password;
    private String message;
    private AuthenticationStatus status;
   private Set<String> roles;
   
   FreelancerClient client;
   String id;
    Response res;
    String LoginID;
    
    private LoginTB selectedLoginID;
    private LoginTB loginTB = new LoginTB();
   
    Collection<LoginTB> logins;
    GenericType<Collection<LoginTB>> glogins;

    public LoginTB getSelectedLoginID() {
        return selectedLoginID;
    }

    public void setSelectedLoginID(LoginTB selectedLoginID) {
        this.selectedLoginID = selectedLoginID;
    }

    public String getLoginID() {
        return LoginID;
    }

    public void setLoginID(String LoginID) {
        this.LoginID = LoginID;
    }
    
    

    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public void setSecurityContext(SecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }
    
    /** AuthenticationStatus status= securityContext.authenticate(request, response, 
//                                   withParams().credential(creden
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        logins = new ArrayList<LoginTB>();
        glogins = new GenericType<Collection<LoginTB>>(){};
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    

    public Collection<LoginTB> getLogins() {
        res = client.GetAllLogins_XML(Response.class);
        System.out.println(res);
        logins = res.readEntity(glogins);
        return logins;
    }

    public void setLogins(Collection<LoginTB> logins) {
        this.logins = logins;
    }
    
    
    
    
   public String login()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        try{
        
          HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
      
        request.getSession().setAttribute("logged-group", ""); 
        request.getSession().setAttribute("username", "");
        request.getSession().setAttribute("LoginID", "");
        
        Credential credential = new UsernamePasswordCredential(username, new Password(password));
        AuthenticationStatus status= securityContext.authenticate(request, response, withParams().credential(credential));
                                           
     
       if (status.equals(SEND_CONTINUE)) {
            // Authentication mechanism has send a redirect, should not
            // send anything to response from JSF now. The control will now go into HttpAuthenticationMechanism
            context.responseComplete();
       } 
       
        System.out.println("credential:"+credential);
         System.out.println("In bean");
         if(roles.contains("Admin"))
           {
               System.out.println("In admin");
               request.getSession().setAttribute("logged-group", "Admin");
               request.getSession().setAttribute("username", username);
               //request.getSession().setAttribute("LoginID", LoginID);
              return "admin/index.jsf?faces-redirect=true";
           }
        //   else if(securityContext.isCallerInRole("Supervisor"))
       else if(roles.contains("Freelancer"))
           {
               System.out.println("In freelancer");
               request.getSession().setAttribute("logged-group", "Freelancer");
               request.getSession().setAttribute("username", username);
               System.out.println("beans.LoginBean.login()" + username);
               return "freelancer/index.jsf?faces-redirect=true";
           }
         else if(roles.contains("Company"))
           {
               System.out.println("In Company");
               request.getSession().setAttribute("logged-group", "Company");
               request.getSession().setAttribute("username", username);
               return "company/cmp_dashboard.jsf?faces-redirect=true";
           }
        
       //} 
       
       
        }
        catch (Exception e)
        {
             message = "Something is Wrong !!!";
             e.printStackTrace();
        }
//        
      return "login.jsf";
    }
   
   public String pass_confirm()
   {
        FacesContext context = FacesContext.getCurrentInstance();

        try
        {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            
            request.getSession().setAttribute("logged-group", ""); 
        
            Credential credential = new UsernamePasswordCredential(username, new Password(password));
            AuthenticationStatus status= securityContext.authenticate(request, response, withParams().credential(credential));
                                           
     
            if (status.equals(SEND_CONTINUE))
            {
                context.responseComplete();
            } 
            System.out.println("In password confirm");
            
            if(roles.contains("Admin"))
            {
                System.out.println("In adminnn");
                request.getSession().setAttribute("logged-group", "Admin");
                //return "/templates/admins/password_change.jsf";
               return EditAdminPassByID();
            }
       }
       catch(Exception e)
       {
           message = "Username and password is not match";
       }
       return "/templates/admins/login.jsf";
   }
   
    public String EditAdminPassByID()
    {
       id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
       // id = "4";
        return "change_password.jsf";
    }

    public String EditAdminPass(LoginBean bean)
    {
      client.AdminChangePassword_JSON(logins, bean.getId(), bean.getPassword());
       // client.AdminChangePassword_JSON(logins, "4","vidhi@gmail.com" ,"vidhi","1002");
        
        return "password_change_sucsess.jsf";
    }
   
   private static void addError(FacesContext context, String message) {
        context = FacesContext.getCurrentInstance();
        context
                .addMessage(
                        null,
                        new FacesMessage(SEVERITY_ERROR, message, null));
    }
   public String logout() throws ServletException
   {
       System.out.println("In Log out");
          HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
          request.getSession().setAttribute("logged-group", "");
           request.logout();
          request.getSession().invalidate();
         
          
          return "/templates/login.jsf?faces-redirect=true";
             
             }
    
}
