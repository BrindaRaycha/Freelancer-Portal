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
import javax.persistence.Lob;
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
@Table(name = "CertificateTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CertificateTB.findAll", query = "SELECT c FROM CertificateTB c"),
    @NamedQuery(name = "CertificateTB.findByCertificateID", query = "SELECT c FROM CertificateTB c WHERE c.certificateID = :certificateID")})
public class CertificateTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CertificateID")
    private Integer certificateID;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "CertificateFile")
    private String certificateFile;
    @JoinColumn(name = "FreelancerID", referencedColumnName = "FreelancerID")
    @ManyToOne(optional = false)
    private FreelancerTB freelancerID;

    public CertificateTB() {
    }

    public CertificateTB(Integer certificateID) {
        this.certificateID = certificateID;
    }

    public CertificateTB(String certificateFile) {
//        this.certificateID = certificateID;
        this.certificateFile = certificateFile;
    }

    public Integer getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(Integer certificateID) {
        this.certificateID = certificateID;
    }

    public String getCertificateFile() {
        return certificateFile;
    }

    public void setCertificateFile(String certificateFile) {
        this.certificateFile = certificateFile;
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
        hash += (certificateID != null ? certificateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CertificateTB)) {
            return false;
        }
        CertificateTB other = (CertificateTB) object;
        if ((this.certificateID == null && other.certificateID != null) || (this.certificateID != null && !this.certificateID.equals(other.certificateID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CertificateTB[ certificateID=" + certificateID + " ]";
    }
    
}
