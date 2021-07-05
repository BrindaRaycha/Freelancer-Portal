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
import javax.persistence.JoinTable;
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
@Table(name = "FreelancerTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FreelancerTB.findAll", query = "SELECT f FROM FreelancerTB f"),
    @NamedQuery(name = "FreelancerTB.findByFreelancerID", query = "SELECT f FROM FreelancerTB f WHERE f.freelancerID = :freelancerID"),
    @NamedQuery(name = "FreelancerTB.findByEmail", query = "SELECT f FROM FreelancerTB f WHERE f.email = :email"),
    @NamedQuery(name = "FreelancerTB.findByWeeklyAvailable", query = "SELECT f FROM FreelancerTB f WHERE f.weeklyAvailable = :weeklyAvailable"),
    @NamedQuery(name = "FreelancerTB.findByIsActive", query = "SELECT f FROM FreelancerTB f WHERE f.isActive = :isActive")})
public class FreelancerTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FreelancerID")
    private Integer freelancerID;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "College")
    private String college;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "ProfileImage")
    private String profileImage;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "AboutSelf")
    private String aboutSelf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "WeeklyAvailable")
    private String weeklyAvailable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsActive")
    private int isActive;
    @JoinTable(name = "SkillFreelancerTB", joinColumns = {
        @JoinColumn(name = "FreelancerID", referencedColumnName = "FreelancerID")}, inverseJoinColumns = {
        @JoinColumn(name = "SkillID", referencedColumnName = "SkillID")})
    @ManyToMany
    private Collection<SkillTB> skillTBCollection;
    @JoinColumn(name = "DegreeID", referencedColumnName = "DegreeID")
    @ManyToOne(optional = false)
    private DegreeTB degreeID;
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    @ManyToOne(optional = false)
    private CategoryTB categoryID;
    @JoinColumn(name = "ExpertizeLevelID", referencedColumnName = "ExpertizeLevelID")
    @ManyToOne(optional = false)
    private ExpertizeLevelTB expertizeLevelID;
    @JoinColumn(name = "HourlyRateID", referencedColumnName = "HourlyRateID")
    @ManyToOne(optional = false)
    private HourlyRateTB hourlyRateID;
    @JoinColumn(name = "StateID", referencedColumnName = "StateID")
    @ManyToOne(optional = false)
    private StateTB stateID;
    @JoinColumn(name = "CityID", referencedColumnName = "CityID")
    @ManyToOne(optional = false)
    private CityTB cityID;
    @JoinColumn(name = "EnglishLevelID", referencedColumnName = "EnglishLevelID")
    @ManyToOne(optional = false)
    private EnglsihLevelTB englishLevelID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "freelancerID")
    private Collection<BiddingTB> biddingTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "freelancerID")
    private Collection<ApplyTB> applyTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "freelancerID")
    private Collection<ReviewTB> reviewTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "freelancerID")
    private Collection<CertificateTB> certificateTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "freelancerID")
    private Collection<PaymentTB> paymentTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "freelancerID")
    private Collection<WorkingFreelancerTB> workingFreelancerTBCollection;

    public FreelancerTB() {
    }

    public FreelancerTB(Integer freelancerID) {
        this.freelancerID = freelancerID;
    }

    public FreelancerTB(String email, String password, String college, String profileImage, String aboutSelf, String weeklyAvailable, int isActive) {
//        this.freelancerID = freelancerID;
        this.email = email;
        this.password = password;
        this.college = college;
        this.profileImage = profileImage;
        this.aboutSelf = aboutSelf;
        this.weeklyAvailable = weeklyAvailable;
        this.isActive = isActive;
    }

    public Integer getFreelancerID() {
        return freelancerID;
    }

    public void setFreelancerID(Integer freelancerID) {
        this.freelancerID = freelancerID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getAboutSelf() {
        return aboutSelf;
    }

    public void setAboutSelf(String aboutSelf) {
        this.aboutSelf = aboutSelf;
    }

    public String getWeeklyAvailable() {
        return weeklyAvailable;
    }

    public void setWeeklyAvailable(String weeklyAvailable) {
        this.weeklyAvailable = weeklyAvailable;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<SkillTB> getSkillTBCollection() {
        return skillTBCollection;
    }

    public void setSkillTBCollection(Collection<SkillTB> skillTBCollection) {
        this.skillTBCollection = skillTBCollection;
    }

    public DegreeTB getDegreeID() {
        return degreeID;
    }

    public void setDegreeID(DegreeTB degreeID) {
        this.degreeID = degreeID;
    }

    public CategoryTB getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(CategoryTB categoryID) {
        this.categoryID = categoryID;
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

    public StateTB getStateID() {
        return stateID;
    }

    public void setStateID(StateTB stateID) {
        this.stateID = stateID;
    }

    public CityTB getCityID() {
        return cityID;
    }

    public void setCityID(CityTB cityID) {
        this.cityID = cityID;
    }

    public EnglsihLevelTB getEnglishLevelID() {
        return englishLevelID;
    }

    public void setEnglishLevelID(EnglsihLevelTB englishLevelID) {
        this.englishLevelID = englishLevelID;
    }

    @XmlTransient
    public Collection<BiddingTB> getBiddingTBCollection() {
        return biddingTBCollection;
    }

    public void setBiddingTBCollection(Collection<BiddingTB> biddingTBCollection) {
        this.biddingTBCollection = biddingTBCollection;
    }

    @XmlTransient
    public Collection<ApplyTB> getApplyTBCollection() {
        return applyTBCollection;
    }

    public void setApplyTBCollection(Collection<ApplyTB> applyTBCollection) {
        this.applyTBCollection = applyTBCollection;
    }

    @XmlTransient
    public Collection<ReviewTB> getReviewTBCollection() {
        return reviewTBCollection;
    }

    public void setReviewTBCollection(Collection<ReviewTB> reviewTBCollection) {
        this.reviewTBCollection = reviewTBCollection;
    }

    @XmlTransient
    public Collection<CertificateTB> getCertificateTBCollection() {
        return certificateTBCollection;
    }

    public void setCertificateTBCollection(Collection<CertificateTB> certificateTBCollection) {
        this.certificateTBCollection = certificateTBCollection;
    }

    @XmlTransient
    public Collection<PaymentTB> getPaymentTBCollection() {
        return paymentTBCollection;
    }

    public void setPaymentTBCollection(Collection<PaymentTB> paymentTBCollection) {
        this.paymentTBCollection = paymentTBCollection;
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
        hash += (freelancerID != null ? freelancerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FreelancerTB)) {
            return false;
        }
        FreelancerTB other = (FreelancerTB) object;
        if ((this.freelancerID == null && other.freelancerID != null) || (this.freelancerID != null && !this.freelancerID.equals(other.freelancerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.FreelancerTB[ freelancerID=" + freelancerID + " ]";
    }
    
}
