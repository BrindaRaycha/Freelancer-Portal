/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author brinda
 */
@Entity
@Table(name = "BiddingTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BiddingTB.findAll", query = "SELECT b FROM BiddingTB b"),
    @NamedQuery(name = "BiddingTB.findByBiddingID", query = "SELECT b FROM BiddingTB b WHERE b.biddingID = :biddingID"),
    @NamedQuery(name = "BiddingTB.findByBiddingRate", query = "SELECT b FROM BiddingTB b WHERE b.biddingRate = :biddingRate")})
public class BiddingTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BiddingID")
    private Integer biddingID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "BiddingRate")
    private String biddingRate;
    @JoinColumn(name = "FreelancerID", referencedColumnName = "FreelancerID")
    @ManyToOne(optional = false)
    private FreelancerTB freelancerID;
    @JoinColumn(name = "WorkPostID", referencedColumnName = "WorkPostID")
    @ManyToOne(optional = false)
    private WorkPostTB workPostID;

    public BiddingTB() {
    }

    public BiddingTB(Integer biddingID) {
        this.biddingID = biddingID;
    }

    public BiddingTB(String biddingRate) {
//        this.biddingID = biddingID;
        this.biddingRate = biddingRate;
    }

    public Integer getBiddingID() {
        return biddingID;
    }

    public void setBiddingID(Integer biddingID) {
        this.biddingID = biddingID;
    }

    public String getBiddingRate() {
        return biddingRate;
    }

    public void setBiddingRate(String biddingRate) {
        this.biddingRate = biddingRate;
    }

    public FreelancerTB getFreelancerID() {
        return freelancerID;
    }

    public void setFreelancerID(FreelancerTB freelancerID) {
        this.freelancerID = freelancerID;
    }

    public WorkPostTB getWorkPostID() {
        return workPostID;
    }

    public void setWorkPostID(WorkPostTB workPostID) {
        this.workPostID = workPostID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (biddingID != null ? biddingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BiddingTB)) {
            return false;
        }
        BiddingTB other = (BiddingTB) object;
        if ((this.biddingID == null && other.biddingID != null) || (this.biddingID != null && !this.biddingID.equals(other.biddingID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.BiddingTB[ biddingID=" + biddingID + " ]";
    }
    
}
