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
@Table(name = "DegreeTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DegreeTB.findAll", query = "SELECT d FROM DegreeTB d"),
    @NamedQuery(name = "DegreeTB.findByDegreeID", query = "SELECT d FROM DegreeTB d WHERE d.degreeID = :degreeID"),
    @NamedQuery(name = "DegreeTB.findByDegree", query = "SELECT d FROM DegreeTB d WHERE d.degree = :degree")})
public class DegreeTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DegreeID")
    private Integer degreeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Degree")
    private String degree;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "degreeID")
    private Collection<FreelancerTB> freelancerTBCollection;

    public DegreeTB() {
    }

    public DegreeTB(Integer degreeID) {
        this.degreeID = degreeID;
    }

    public DegreeTB(String degree) {
//        this.degreeID = degreeID;
        this.degree = degree;
    }

    public Integer getDegreeID() {
        return degreeID;
    }

    public void setDegreeID(Integer degreeID) {
        this.degreeID = degreeID;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @XmlTransient
    public Collection<FreelancerTB> getFreelancerTBCollection() {
        return freelancerTBCollection;
    }

    public void setFreelancerTBCollection(Collection<FreelancerTB> freelancerTBCollection) {
        this.freelancerTBCollection = freelancerTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (degreeID != null ? degreeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DegreeTB)) {
            return false;
        }
        DegreeTB other = (DegreeTB) object;
        if ((this.degreeID == null && other.degreeID != null) || (this.degreeID != null && !this.degreeID.equals(other.degreeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DegreeTB[ degreeID=" + degreeID + " ]";
    }
    
}
