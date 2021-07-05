/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author brinda
 */
@Entity
@Table(name = "AdminTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminTB.findAll", query = "SELECT a FROM AdminTB a"),
    @NamedQuery(name = "AdminTB.findByAdminID", query = "SELECT a FROM AdminTB a WHERE a.adminID = :adminID"),
    @NamedQuery(name = "AdminTB.findByUserName", query = "SELECT a FROM AdminTB a WHERE a.userName = :userName"),
    @NamedQuery(name = "AdminTB.findByPassword", query = "SELECT a FROM AdminTB a WHERE a.password = :password")})
public class AdminTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AdminID")
    private Integer adminID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "UserName")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Password")
    private String password;

    public AdminTB() {
    }

    public AdminTB(Integer adminID) {
        this.adminID = adminID;
    }

    public AdminTB(Integer adminID, String userName, String password) {
        this.adminID = adminID;
        this.userName = userName;
        this.password = password;
    }

    public Integer getAdminID() {
        return adminID;
    }

    public void setAdminID(Integer adminID) {
        this.adminID = adminID;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminID != null ? adminID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminTB)) {
            return false;
        }
        AdminTB other = (AdminTB) object;
        if ((this.adminID == null && other.adminID != null) || (this.adminID != null && !this.adminID.equals(other.adminID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.AdminTB[ adminID=" + adminID + " ]";
    }
    
}
