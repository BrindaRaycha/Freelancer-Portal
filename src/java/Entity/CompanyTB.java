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
@Table(name = "CompanyTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompanyTB.findAll", query = "SELECT c FROM CompanyTB c"),
    @NamedQuery(name = "CompanyTB.findByCompanyID", query = "SELECT c FROM CompanyTB c WHERE c.companyID = :companyID"),
    @NamedQuery(name = "CompanyTB.findByCompanyName", query = "SELECT c FROM CompanyTB c WHERE c.companyName = :companyName"),
    @NamedQuery(name = "CompanyTB.findByCompanyOwnerName", query = "SELECT c FROM CompanyTB c WHERE c.companyOwnerName = :companyOwnerName"),
    @NamedQuery(name = "CompanyTB.findByCompanyEmail", query = "SELECT c FROM CompanyTB c WHERE c.companyEmail = :companyEmail"),
    @NamedQuery(name = "CompanyTB.findByCompanyStaff", query = "SELECT c FROM CompanyTB c WHERE c.companyStaff = :companyStaff"),
    @NamedQuery(name = "CompanyTB.findByContactNumber", query = "SELECT c FROM CompanyTB c WHERE c.contactNumber = :contactNumber"),
    @NamedQuery(name = "CompanyTB.findByIsActive", query = "SELECT c FROM CompanyTB c WHERE c.isActive = :isActive")})
public class CompanyTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CompanyID")
    private Integer companyID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CompanyName")
    private String companyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CompanyOwnerName")
    private String companyOwnerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CompanyEmail")
    private String companyEmail;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "CompanyOwnerPassword")
    private String companyOwnerPassword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CompanyStaff")
    private int companyStaff;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5000)
    @Column(name = "ContactNumber")
    private String contactNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsActive")
    private int isActive;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "CompanyLogo")
    private String companyLogo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyID")
    private Collection<WorkPostTB> workPostTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyID")
    private Collection<ReviewTB> reviewTBCollection;
    @JoinColumn(name = "StateID", referencedColumnName = "StateID")
    @ManyToOne(optional = false)
    private StateTB stateID;
    @JoinColumn(name = "CityID", referencedColumnName = "CityID")
    @ManyToOne(optional = false)
    private CityTB cityID;

    public CompanyTB() {
    }

    public CompanyTB(Integer companyID) {
        this.companyID = companyID;
    }

    public CompanyTB(String companyName, String companyOwnerName, String companyEmail, String companyOwnerPassword, int companyStaff, String contactNumber, int isActive, String companyLogo) {
//        this.companyID = companyID;
        this.companyName = companyName;
        this.companyOwnerName = companyOwnerName;
        this.companyEmail = companyEmail;
        this.companyOwnerPassword = companyOwnerPassword;
        this.companyStaff = companyStaff;
        this.contactNumber = contactNumber;
        this.isActive = isActive;
        this.companyLogo = companyLogo;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyOwnerName() {
        return companyOwnerName;
    }

    public void setCompanyOwnerName(String companyOwnerName) {
        this.companyOwnerName = companyOwnerName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyOwnerPassword() {
        return companyOwnerPassword;
    }

    public void setCompanyOwnerPassword(String companyOwnerPassword) {
        this.companyOwnerPassword = companyOwnerPassword;
    }

    public int getCompanyStaff() {
        return companyStaff;
    }

    public void setCompanyStaff(int companyStaff) {
        this.companyStaff = companyStaff;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    @XmlTransient
    public Collection<WorkPostTB> getWorkPostTBCollection() {
        return workPostTBCollection;
    }

    public void setWorkPostTBCollection(Collection<WorkPostTB> workPostTBCollection) {
        this.workPostTBCollection = workPostTBCollection;
    }

    @XmlTransient
    public Collection<ReviewTB> getReviewTBCollection() {
        return reviewTBCollection;
    }

    public void setReviewTBCollection(Collection<ReviewTB> reviewTBCollection) {
        this.reviewTBCollection = reviewTBCollection;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyID != null ? companyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyTB)) {
            return false;
        }
        CompanyTB other = (CompanyTB) object;
        if ((this.companyID == null && other.companyID != null) || (this.companyID != null && !this.companyID.equals(other.companyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CompanyTB[ companyID=" + companyID + " ]";
    }
    
}
