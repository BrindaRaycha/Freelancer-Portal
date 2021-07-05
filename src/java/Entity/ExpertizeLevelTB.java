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
@Table(name = "ExpertizeLevelTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExpertizeLevelTB.findAll", query = "SELECT e FROM ExpertizeLevelTB e"),
    @NamedQuery(name = "ExpertizeLevelTB.findByExpertizeLevelID", query = "SELECT e FROM ExpertizeLevelTB e WHERE e.expertizeLevelID = :expertizeLevelID"),
    @NamedQuery(name = "ExpertizeLevelTB.findByLevels", query = "SELECT e FROM ExpertizeLevelTB e WHERE e.levels = :levels")})
public class ExpertizeLevelTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ExpertizeLevelID")
    private Integer expertizeLevelID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Levels")
    private String levels;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expertizeLevelID")
    private Collection<FreelancerTB> freelancerTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expertizeLevelID")
    private Collection<WorkPostTB> workPostTBCollection;

    public ExpertizeLevelTB() {
    }

    public ExpertizeLevelTB(Integer expertizeLevelID) {
        this.expertizeLevelID = expertizeLevelID;
    }

    public ExpertizeLevelTB(String levels) {
//        this.expertizeLevelID = expertizeLevelID;
        this.levels = levels;
    }

    public Integer getExpertizeLevelID() {
        return expertizeLevelID;
    }

    public void setExpertizeLevelID(Integer expertizeLevelID) {
        this.expertizeLevelID = expertizeLevelID;
    }

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }

    @XmlTransient
    public Collection<FreelancerTB> getFreelancerTBCollection() {
        return freelancerTBCollection;
    }

    public void setFreelancerTBCollection(Collection<FreelancerTB> freelancerTBCollection) {
        this.freelancerTBCollection = freelancerTBCollection;
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
        hash += (expertizeLevelID != null ? expertizeLevelID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExpertizeLevelTB)) {
            return false;
        }
        ExpertizeLevelTB other = (ExpertizeLevelTB) object;
        if ((this.expertizeLevelID == null && other.expertizeLevelID != null) || (this.expertizeLevelID != null && !this.expertizeLevelID.equals(other.expertizeLevelID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ExpertizeLevelTB[ expertizeLevelID=" + expertizeLevelID + " ]";
    }
    
}
