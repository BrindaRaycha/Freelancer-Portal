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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author brinda
 */
@Entity
@Table(name = "WorkingFreelancerTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkingFreelancerTB.findAll", query = "SELECT w FROM WorkingFreelancerTB w"),
    @NamedQuery(name = "WorkingFreelancerTB.findByWorkingFreelancerID", query = "SELECT w FROM WorkingFreelancerTB w WHERE w.workingFreelancerID = :workingFreelancerID")})
public class WorkingFreelancerTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "workingFreelancerID")
    private Integer workingFreelancerID;
    @JoinColumn(name = "WorkPostID", referencedColumnName = "WorkPostID")
    @ManyToOne(optional = false)
    private WorkPostTB workPostID;
    @JoinColumn(name = "FreelancerID", referencedColumnName = "FreelancerID")
    @ManyToOne(optional = false)
    private FreelancerTB freelancerID;

    public WorkingFreelancerTB() {
    }

    public WorkingFreelancerTB(Integer workingFreelancerID) {
        this.workingFreelancerID = workingFreelancerID;
    }

    public Integer getWorkingFreelancerID() {
        return workingFreelancerID;
    }

    public void setWorkingFreelancerID(Integer workingFreelancerID) {
        this.workingFreelancerID = workingFreelancerID;
    }

    public WorkPostTB getWorkPostID() {
        return workPostID;
    }

    public void setWorkPostID(WorkPostTB workPostID) {
        this.workPostID = workPostID;
    }

    public FreelancerTB getFreelancerID() {
        return freelancerID;
    }

    public void setFreelancerID(FreelancerTB freelancerID) {
        this.freelancerID = freelancerID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workingFreelancerID != null ? workingFreelancerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkingFreelancerTB)) {
            return false;
        }
        WorkingFreelancerTB other = (WorkingFreelancerTB) object;
        if ((this.workingFreelancerID == null && other.workingFreelancerID != null) || (this.workingFreelancerID != null && !this.workingFreelancerID.equals(other.workingFreelancerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.WorkingFreelancerTB[ workingFreelancerID=" + workingFreelancerID + " ]";
    }
    
}
