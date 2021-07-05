/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author brinda
 */
@Entity
@Table(name = "LoginTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginTB.findAll", query = "SELECT l FROM LoginTB l"),
    @NamedQuery(name = "LoginTB.findByLoginID", query = "SELECT l FROM LoginTB l WHERE l.loginID = :loginID"),
    @NamedQuery(name = "LoginTB.findByUserName", query = "SELECT l FROM LoginTB l WHERE l.userName = :userName"),
    @NamedQuery(name = "LoginTB.findByUserID", query = "SELECT l FROM LoginTB l WHERE l.userID = :userID")})
public class LoginTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LoginID")
    private Integer loginID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "UserName")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "UserID")
    private String userID;
    @ManyToMany(mappedBy = "loginTBCollection")
    private Collection<RoleTB> roleTBCollection;

    public LoginTB() {
    }

    public LoginTB(Integer loginID) {
        this.loginID = loginID;
    }

    public LoginTB(String userName, String password, String userID) {
//        this.loginID = loginID;
        this.userName = userName;
        this.password = password;
        this.userID = userID;
    }

    public Integer getLoginID() {
        return loginID;
    }

    public void setLoginID(Integer loginID) {
        this.loginID = loginID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @XmlTransient
    public Collection<RoleTB> getRoleTBCollection() {
        return roleTBCollection;
    }

    public void setRoleTBCollection(Collection<RoleTB> roleTBCollection) {
        this.roleTBCollection = roleTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loginID != null ? loginID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginTB)) {
            return false;
        }
        LoginTB other = (LoginTB) object;
        if ((this.loginID == null && other.loginID != null) || (this.loginID != null && !this.loginID.equals(other.loginID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.LoginTB[ loginID=" + loginID + " ]";
    }
    
}
