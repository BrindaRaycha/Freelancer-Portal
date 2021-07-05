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
@Table(name = "ApplyTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApplyTB.findAll", query = "SELECT a FROM ApplyTB a"),
    @NamedQuery(name = "ApplyTB.findByApplyID", query = "SELECT a FROM ApplyTB a WHERE a.applyID = :applyID"),
    @NamedQuery(name = "ApplyTB.findByWorkStatus", query = "SELECT a FROM ApplyTB a WHERE a.workStatus = :workStatus")})
public class ApplyTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ApplyID")
    private Integer applyID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "WorkStatus")
    private String workStatus;
    @JoinColumn(name = "FreelancerID", referencedColumnName = "FreelancerID")
    @ManyToOne(optional = false)
    private FreelancerTB freelancerID;
    @JoinColumn(name = "WorkPostID", referencedColumnName = "WorkPostID")
    @ManyToOne(optional = false)
    private WorkPostTB workPostID;

    public ApplyTB() {
    }

    public ApplyTB(Integer applyID) {
        this.applyID = applyID;
    }

    public ApplyTB(String workStatus) {
//        this.applyID = applyID;
        this.workStatus = workStatus;
    }

    public Integer getApplyID() {
        return applyID;
    }

    public void setApplyID(Integer applyID) {
        this.applyID = applyID;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
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
        hash += (applyID != null ? applyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApplyTB)) {
            return false;
        }
        ApplyTB other = (ApplyTB) object;
        if ((this.applyID == null && other.applyID != null) || (this.applyID != null && !this.applyID.equals(other.applyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ApplyTB[ applyID=" + applyID + " ]";
    }
    
}
