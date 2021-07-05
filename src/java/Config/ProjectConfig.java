/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author brinda
 */

//@FormAuthenticationMechanismDefinition(
//        loginToContinue = @LoginToContinue(
//                loginPage = "/index.jsp"
//                ,errorPage = "/loginError.jsp"
//              
//        )
//)

//@CustomFormAuthenticationMechanismDefinition(
//        loginToContinue = @LoginToContinue(
//                loginPage = "/index.jsp"
//                //,errorPage = "/loginError.jsp"
//              
//        )
//)

// Identity Store
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/FreelancerJNDI",
        callerQuery = "SELECT Password FROM LoginTB WHERE UserName = ?",
        groupsQuery = "SELECT RoleName FROM RoleTB,LoginTB,LoginRoleTB WHERE LoginRoleTB.RoleID=RoleTB.RoleID and LoginRoleTB.LoginID=LoginTB.LoginID and LoginTB.UserName = ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30)

@ApplicationScoped
@Named
public class ProjectConfig {
    
}
