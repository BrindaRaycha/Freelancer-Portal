/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "ProjectScopeTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectScopeTB.findAll", query = "SELECT p FROM ProjectScopeTB p"),
    @NamedQuery(name = "ProjectScopeTB.findByProjectScopeID", query = "SELECT p FROM ProjectScopeTB p WHERE p.projectScopeID = :projectScopeID"),
    @NamedQuery(name = "ProjectScopeTB.findByScope", query = "SELECT p FROM ProjectScopeTB p WHERE p.scope = :scope")})
public class ProjectScopeTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProjectScopeID")
    private Integer projectScopeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Scope")
    private String scope;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectScopeID")
    private Collection<WorkPostTB> workPostTBCollection;

    public ProjectScopeTB() {
    }

    public ProjectScopeTB(Integer projectScopeID) {
        this.projectScopeID = projectScopeID;
    }

    public ProjectScopeTB(String scope) {
//        this.projectScopeID = projectScopeID;
        this.scope = scope;
    }

    public Integer getProjectScopeID() {
        return projectScopeID;
    }

    public void setProjectScopeID(Integer projectScopeID) {
        this.projectScopeID = projectScopeID;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @XmlTransient
    public Collection<WorkPostTB> getWorkPostTBCollection() {
        return workPostTBCollection;
    }

    public void setWorkPostTBCollection(Collection<WorkPostTB> workPostTBCollection) {
        this.workPostTBCollection = workPostTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectScopeID != null ? projectScopeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectScopeTB)) {
            return false;
        }
        ProjectScopeTB other = (ProjectScopeTB) object;
        if ((this.projectScopeID == null && other.projectScopeID != null) || (this.projectScopeID != null && !this.projectScopeID.equals(other.projectScopeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ProjectScopeTB[ projectScopeID=" + projectScopeID + " ]";
    }
    
}
