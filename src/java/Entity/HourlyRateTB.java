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
import javax.persistence.Lob;
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
@Table(name = "HourlyRateTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HourlyRateTB.findAll", query = "SELECT h FROM HourlyRateTB h"),
    @NamedQuery(name = "HourlyRateTB.findByHourlyRateID", query = "SELECT h FROM HourlyRateTB h WHERE h.hourlyRateID = :hourlyRateID")})
public class HourlyRateTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "HourlyRateID")
    private Integer hourlyRateID;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Rate")
    private String rate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hourlyRateID")
    private Collection<FreelancerTB> freelancerTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hourlyRateID")
    private Collection<WorkPostTB> workPostTBCollection;

    public HourlyRateTB() {
    }

    public HourlyRateTB(Integer hourlyRateID) {
        this.hourlyRateID = hourlyRateID;
    }

    public HourlyRateTB(String rate) {
//        this.hourlyRateID = hourlyRateID;
        this.rate = rate;
    }

    public Integer getHourlyRateID() {
        return hourlyRateID;
    }

    public void setHourlyRateID(Integer hourlyRateID) {
        this.hourlyRateID = hourlyRateID;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
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
        hash += (hourlyRateID != null ? hourlyRateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HourlyRateTB)) {
            return false;
        }
        HourlyRateTB other = (HourlyRateTB) object;
        if ((this.hourlyRateID == null && other.hourlyRateID != null) || (this.hourlyRateID != null && !this.hourlyRateID.equals(other.hourlyRateID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.HourlyRateTB[ hourlyRateID=" + hourlyRateID + " ]";
    }
    
}
