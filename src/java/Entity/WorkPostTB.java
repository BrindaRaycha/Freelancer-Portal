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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "WorkPostTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkPostTB.findAll", query = "SELECT w FROM WorkPostTB w"),
    @NamedQuery(name = "WorkPostTB.findByWorkPostID", query = "SELECT w FROM WorkPostTB w WHERE w.workPostID = :workPostID"),
    @NamedQuery(name = "WorkPostTB.findByWorkTitle", query = "SELECT w FROM WorkPostTB w WHERE w.workTitle = :workTitle"),
    @NamedQuery(name = "WorkPostTB.findByWorkPostDate", query = "SELECT w FROM WorkPostTB w WHERE w.workPostDate = :workPostDate")})
public class WorkPostTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WorkPostID")
    private Integer workPostID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "WorkTitle")
    private String workTitle;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "WorkDescription")
    private String workDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "WorkPostDate")
    private String workPostDate;
    @ManyToMany(mappedBy = "workPostTBCollection")
    private Collection<SkillTB> skillTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workPostID")
    private Collection<BiddingTB> biddingTBCollection;
    @JoinColumn(name = "ProjectScopeID", referencedColumnName = "ProjectScopeID")
    @ManyToOne(optional = false)
    private ProjectScopeTB projectScopeID;
    @JoinColumn(name = "ExpertizeLevelID", referencedColumnName = "ExpertizeLevelID")
    @ManyToOne(optional = false)
    private ExpertizeLevelTB expertizeLevelID;
    @JoinColumn(name = "HourlyRateID", referencedColumnName = "HourlyRateID")
    @ManyToOne(optional = false)
    private HourlyRateTB hourlyRateID;
    @JoinColumn(name = "EnglishLevelID", referencedColumnName = "EnglishLevelID")
    @ManyToOne(optional = false)
    private EnglsihLevelTB englishLevelID;
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    @ManyToOne(optional = false)
    private CategoryTB categoryID;
    @JoinColumn(name = "CompanyID", referencedColumnName = "CompanyID")
    @ManyToOne(optional = false)
    private CompanyTB companyID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workPostID")
    private Collection<ApplyTB> applyTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workPostID")
    private Collection<WorkingFreelancerTB> workingFreelancerTBCollection;

    public WorkPostTB() {
    }

    public WorkPostTB(Integer workPostID) {
        this.workPostID = workPostID;
    }

    public WorkPostTB(String workTitle, String workDescription, String workPostDate) {
//        this.workPostID = workPostID;
        this.workTitle = workTitle;
        this.workDescription = workDescription;
        this.workPostDate = workPostDate;
    }

    public Integer getWorkPostID() {
        return workPostID;
    }

    public void setWorkPostID(Integer workPostID) {
        this.workPostID = workPostID;
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public String getWorkPostDate() {
        return workPostDate;
    }

    public void setWorkPostDate(String workPostDate) {
        this.workPostDate = workPostDate;
    }

    @XmlTransient
    public Collection<SkillTB> getSkillTBCollection() {
        return skillTBCollection;
    }

    public void setSkillTBCollection(Collection<SkillTB> skillTBCollection) {
        this.skillTBCollection = skillTBCollection;
    }

    @XmlTransient
    public Collection<BiddingTB> getBiddingTBCollection() {
        return biddingTBCollection;
    }

    public void setBiddingTBCollection(Collection<BiddingTB> biddingTBCollection) {
        this.biddingTBCollection = biddingTBCollection;
    }

    public ProjectScopeTB getProjectScopeID() {
        return projectScopeID;
    }

    public void setProjectScopeID(ProjectScopeTB projectScopeID) {
        this.projectScopeID = projectScopeID;
    }

    public ExpertizeLevelTB getExpertizeLevelID() {
        return expertizeLevelID;
    }

    public void setExpertizeLevelID(ExpertizeLevelTB expertizeLevelID) {
        this.expertizeLevelID = expertizeLevelID;
    }

    public HourlyRateTB getHourlyRateID() {
        return hourlyRateID;
    }

    public void setHourlyRateID(HourlyRateTB hourlyRateID) {
        this.hourlyRateID = hourlyRateID;
    }

    public EnglsihLevelTB getEnglishLevelID() {
        return englishLevelID;
    }

    public void setEnglishLevelID(EnglsihLevelTB englishLevelID) {
        this.englishLevelID = englishLevelID;
    }

    public CategoryTB getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(CategoryTB categoryID) {
        this.categoryID = categoryID;
    }

    public CompanyTB getCompanyID() {
        return companyID;
    }

    public void setCompanyID(CompanyTB companyID) {
        this.companyID = companyID;
    }

    @XmlTransient
    public Collection<ApplyTB> getApplyTBCollection() {
        return applyTBCollection;
    }

    public void setApplyTBCollection(Collection<ApplyTB> applyTBCollection) {
        this.applyTBCollection = applyTBCollection;
    }

    @XmlTransient
    public Collection<WorkingFreelancerTB> getWorkingFreelancerTBCollection() {
        return workingFreelancerTBCollection;
    }

    public void setWorkingFreelancerTBCollection(Collection<WorkingFreelancerTB> workingFreelancerTBCollection) {
        this.workingFreelancerTBCollection = workingFreelancerTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workPostID != null ? workPostID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkPostTB)) {
            return false;
        }
        WorkPostTB other = (WorkPostTB) object;
        if ((this.workPostID == null && other.workPostID != null) || (this.workPostID != null && !this.workPostID.equals(other.workPostID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.WorkPostTB[ workPostID=" + workPostID + " ]";
    }
    
}
