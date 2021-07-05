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
@Table(name = "StateTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StateTB.findAll", query = "SELECT s FROM StateTB s"),
    @NamedQuery(name = "StateTB.findByStateID", query = "SELECT s FROM StateTB s WHERE s.stateID = :stateID"),
    @NamedQuery(name = "StateTB.findByStateName", query = "SELECT s FROM StateTB s WHERE s.stateName = :stateName")})
public class StateTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StateID")
    private Integer stateID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "StateName")
    private String stateName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateID")
    private Collection<FreelancerTB> freelancerTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateID")
    private Collection<CityTB> cityTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateID")
    private Collection<CompanyTB> companyTBCollection;

    public StateTB() {
    }

    public StateTB(Integer stateID) {
        this.stateID = stateID;
    }

    public StateTB(String stateName) {
//        this.stateID = stateID;
        this.stateName = stateName;
    }

    public Integer getStateID() {
        return stateID;
    }

    public void setStateID(Integer stateID) {
        this.stateID = stateID;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @XmlTransient
    public Collection<FreelancerTB> getFreelancerTBCollection() {
        return freelancerTBCollection;
    }

    public void setFreelancerTBCollection(Collection<FreelancerTB> freelancerTBCollection) {
        this.freelancerTBCollection = freelancerTBCollection;
    }

    @XmlTransient
    public Collection<CityTB> getCityTBCollection() {
        return cityTBCollection;
    }

    public void setCityTBCollection(Collection<CityTB> cityTBCollection) {
        this.cityTBCollection = cityTBCollection;
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
        hash += (stateID != null ? stateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StateTB)) {
            return false;
        }
        StateTB other = (StateTB) object;
        if ((this.stateID == null && other.stateID != null) || (this.stateID != null && !this.stateID.equals(other.stateID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.StateTB[ stateID=" + stateID + " ]";
    }
    
}
