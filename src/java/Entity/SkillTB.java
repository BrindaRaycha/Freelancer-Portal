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
import javax.persistence.ManyToOne;
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
@Table(name = "SkillTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SkillTB.findAll", query = "SELECT s FROM SkillTB s"),
    @NamedQuery(name = "SkillTB.findBySkillID", query = "SELECT s FROM SkillTB s WHERE s.skillID = :skillID"),
    @NamedQuery(name = "SkillTB.findBySkills", query = "SELECT s FROM SkillTB s WHERE s.skills = :skills")})
public class SkillTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SkillID")
    private Integer skillID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Skills")
    private String skills;
    @JoinTable(name = "WorkPostFreelancerSkillTB", joinColumns = {
        @JoinColumn(name = "SkillID", referencedColumnName = "SkillID")}, inverseJoinColumns = {
        @JoinColumn(name = "WorkPostID", referencedColumnName = "WorkPostID")})
    @ManyToMany
    private Collection<WorkPostTB> workPostTBCollection;
    @ManyToMany(mappedBy = "skillTBCollection")
    private Collection<FreelancerTB> freelancerTBCollection;
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    @ManyToOne(optional = false)
    private CategoryTB categoryID;

    public SkillTB() {
    }

    public SkillTB(Integer skillID) {
        this.skillID = skillID;
    }

    public SkillTB(String skills) {
//        this.skillID = skillID;
        this.skills = skills;
    }

    public Integer getSkillID() {
        return skillID;
    }

    public void setSkillID(Integer skillID) {
        this.skillID = skillID;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @XmlTransient
    public Collection<WorkPostTB> getWorkPostTBCollection() {
        return workPostTBCollection;
    }

    public void setWorkPostTBCollection(Collection<WorkPostTB> workPostTBCollection) {
        this.workPostTBCollection = workPostTBCollection;
    }

    @XmlTransient
    public Collection<FreelancerTB> getFreelancerTBCollection() {
        return freelancerTBCollection;
    }

    public void setFreelancerTBCollection(Collection<FreelancerTB> freelancerTBCollection) {
        this.freelancerTBCollection = freelancerTBCollection;
    }

    public CategoryTB getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(CategoryTB categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skillID != null ? skillID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkillTB)) {
            return false;
        }
        SkillTB other = (SkillTB) object;
        if ((this.skillID == null && other.skillID != null) || (this.skillID != null && !this.skillID.equals(other.skillID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.SkillTB[ skillID=" + skillID + " ]";
    }
    
}
