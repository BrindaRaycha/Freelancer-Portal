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
@Table(name = "PaymentTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentTB.findAll", query = "SELECT p FROM PaymentTB p"),
    @NamedQuery(name = "PaymentTB.findByPaymentID", query = "SELECT p FROM PaymentTB p WHERE p.paymentID = :paymentID"),
    @NamedQuery(name = "PaymentTB.findByTotalAmount", query = "SELECT p FROM PaymentTB p WHERE p.totalAmount = :totalAmount")})
public class PaymentTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PaymentID")
    private Integer paymentID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "TotalAmount")
    private String totalAmount;
    @JoinColumn(name = "FreelancerID", referencedColumnName = "FreelancerID")
    @ManyToOne(optional = false)
    private FreelancerTB freelancerID;

    public PaymentTB() {
    }

    public PaymentTB(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public PaymentTB(String totalAmount) {
//        this.paymentID = paymentID;
        this.totalAmount = totalAmount;
    }

    public Integer getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
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
        hash += (paymentID != null ? paymentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentTB)) {
            return false;
        }
        PaymentTB other = (PaymentTB) object;
        if ((this.paymentID == null && other.paymentID != null) || (this.paymentID != null && !this.paymentID.equals(other.paymentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PaymentTB[ paymentID=" + paymentID + " ]";
    }
    
}
