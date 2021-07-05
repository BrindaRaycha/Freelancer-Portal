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
@Table(name = "CityTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CityTB.findAll", query = "SELECT c FROM CityTB c"),
    @NamedQuery(name = "CityTB.findByCityID", query = "SELECT c FROM CityTB c WHERE c.cityID = :cityID"),
    @NamedQuery(name = "CityTB.findByCityName", query = "SELECT c FROM CityTB c WHERE c.cityName = :cityName")})
public class CityTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CityID")
    private Integer cityID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CityName")
    private String cityName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityID")
    private Collection<FreelancerTB> freelancerTBCollection;
    @JoinColumn(name = "StateID", referencedColumnName = "StateID")
    @ManyToOne(optional = false)
    private StateTB stateID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityID")
    private Collection<CompanyTB> companyTBCollection;

    public CityTB() {
    }

    public CityTB(Integer cityID) {
        this.cityID = cityID;
    }

    public CityTB(String cityName) {
//        this.cityID = cityID;
        this.cityName = cityName;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @XmlTransient
    public Collection<FreelancerTB> getFreelancerTBCollection() {
        return freelancerTBCollection;
    }

    public void setFreelancerTBCollection(Collection<FreelancerTB> freelancerTBCollection) {
        this.freelancerTBCollection = freelancerTBCollection;
    }

    public StateTB getStateID() {
        return stateID;
    }

    public void setStateID(StateTB stateID) {
        this.stateID = stateID;
    }

    @XmlTransient
    public Collection<CompanyTB> getCompanyTBCollection() {
        return companyTBCollection;
    }

    public void setCompanyTBCollection(Collection<CompanyTB> companyTBCollection) {
        this.companyTBCollection = companyTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityID != null ? cityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CityTB)) {
            return false;
        }
        CityTB other = (CityTB) object;
        if ((this.cityID == null && other.cityID != null) || (this.cityID != null && !this.cityID.equals(other.cityID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CityTB[ cityID=" + cityID + " ]";
    }
    
}
