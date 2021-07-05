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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "RoleTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoleTB.findAll", query = "SELECT r FROM RoleTB r"),
    @NamedQuery(name = "RoleTB.findByRoleID", query = "SELECT r FROM RoleTB r WHERE r.roleID = :roleID"),
    @NamedQuery(name = "RoleTB.findByRoleName", query = "SELECT r FROM RoleTB r WHERE r.roleName = :roleName")})
public class RoleTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RoleID")
    private Integer roleID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "RoleName")
    private String roleName;
    @JoinTable(name = "LoginRoleTB", joinColumns = {
        @JoinColumn(name = "RoleID", referencedColumnName = "RoleID")}, inverseJoinColumns = {
        @JoinColumn(name = "LoginID", referencedColumnName = "LoginID")})
    @ManyToMany
    private Collection<LoginTB> loginTBCollection;

    public RoleTB() {
    }

    public RoleTB(Integer roleID) {
        this.roleID = roleID;
    }

    public RoleTB(String roleName) {
//        this.roleID = roleID;
        this.roleName = roleName;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @XmlTransient
    public Collection<LoginTB> getLoginTBCollection() {
        return loginTBCollection;
    }

    public void setLoginTBCollection(Collection<LoginTB> loginTBCollection) {
        this.loginTBCollection = loginTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleID != null ? roleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleTB)) {
            return false;
        }
        RoleTB other = (RoleTB) object;
        if ((this.roleID == null && other.roleID != null) || (this.roleID != null && !this.roleID.equals(other.roleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.RoleTB[ roleID=" + roleID + " ]";
    }
    
}
