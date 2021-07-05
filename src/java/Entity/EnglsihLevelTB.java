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
@Table(name = "EnglsihLevelTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnglsihLevelTB.findAll", query = "SELECT e FROM EnglsihLevelTB e"),
    @NamedQuery(name = "EnglsihLevelTB.findByEnglishLevelID", query = "SELECT e FROM EnglsihLevelTB e WHERE e.englishLevelID = :englishLevelID"),
    @NamedQuery(name = "EnglsihLevelTB.findByEnglishLevels", query = "SELECT e FROM EnglsihLevelTB e WHERE e.englishLevels = :englishLevels")})
public class EnglsihLevelTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EnglishLevelID")
    private Integer englishLevelID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EnglishLevels")
    private String englishLevels;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "englishLevelID")
    private Collection<FreelancerTB> freelancerTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "englishLevelID")
    private Collection<WorkPostTB> workPostTBCollection;

    public EnglsihLevelTB() {
    }

    public EnglsihLevelTB(Integer englishLevelID) {
        this.englishLevelID = englishLevelID;
    }

    public EnglsihLevelTB(String englishLevels) {
//        this.englishLevelID = englishLevelID;
        this.englishLevels = englishLevels;
    }

    public Integer getEnglishLevelID() {
        return englishLevelID;
    }

    public void setEnglishLevelID(Integer englishLevelID) {
        this.englishLevelID = englishLevelID;
    }

    public String getEnglishLevels() {
        return englishLevels;
    }

    public void setEnglishLevels(String englishLevels) {
        this.englishLevels = englishLevels;
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
        hash += (englishLevelID != null ? englishLevelID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnglsihLevelTB)) {
            return false;
        }
        EnglsihLevelTB other = (EnglsihLevelTB) object;
        if ((this.englishLevelID == null && other.englishLevelID != null) || (this.englishLevelID != null && !this.englishLevelID.equals(other.englishLevelID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.EnglsihLevelTB[ englishLevelID=" + englishLevelID + " ]";
    }
    
}
