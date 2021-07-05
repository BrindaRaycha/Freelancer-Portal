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
@Table(name = "CategoryTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoryTB.findAll", query = "SELECT c FROM CategoryTB c"),
    @NamedQuery(name = "CategoryTB.findByCategoryID", query = "SELECT c FROM CategoryTB c WHERE c.categoryID = :categoryID"),
    @NamedQuery(name = "CategoryTB.findByCategoryName", query = "SELECT c FROM CategoryTB c WHERE c.categoryName = :categoryName")})
public class CategoryTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CategoryID")
    private Integer categoryID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CategoryName")
    private String categoryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryID")
    private Collection<FreelancerTB> freelancerTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryID")
    private Collection<WorkPostTB> workPostTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryID")
    private Collection<SkillTB> skillTBCollection;

    public CategoryTB() {
    }

    public CategoryTB(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public CategoryTB(String categoryName) {
//        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    @XmlTransient
    public Collection<SkillTB> getSkillTBCollection() {
        return skillTBCollection;
    }

    public void setSkillTBCollection(Collection<SkillTB> skillTBCollection) {
        this.skillTBCollection = skillTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryID != null ? categoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoryTB)) {
            return false;
        }
        CategoryTB other = (CategoryTB) object;
        if ((this.categoryID == null && other.categoryID != null) || (this.categoryID != null && !this.categoryID.equals(other.categoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CategoryTB[ categoryID=" + categoryID + " ]";
    }
    
}
