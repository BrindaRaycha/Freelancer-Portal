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
@Table(name = "ReviewTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReviewTB.findAll", query = "SELECT r FROM ReviewTB r"),
    @NamedQuery(name = "ReviewTB.findByReviewID", query = "SELECT r FROM ReviewTB r WHERE r.reviewID = :reviewID"),
    @NamedQuery(name = "ReviewTB.findByReview", query = "SELECT r FROM ReviewTB r WHERE r.review = :review")})
public class ReviewTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ReviewID")
    private Integer reviewID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Review")
    private String review;
    @JoinColumn(name = "FreelancerID", referencedColumnName = "FreelancerID")
    @ManyToOne(optional = false)
    private FreelancerTB freelancerID;
    @JoinColumn(name = "CompanyID", referencedColumnName = "CompanyID")
    @ManyToOne(optional = false)
    private CompanyTB companyID;

    public ReviewTB() {
    }

    public ReviewTB(Integer reviewID) {
        this.reviewID = reviewID;
    }

    public ReviewTB(String review) {
//        this.reviewID = reviewID;
        this.review = review;
    }

    public Integer getReviewID() {
        return reviewID;
    }

    public void setReviewID(Integer reviewID) {
        this.reviewID = reviewID;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public FreelancerTB getFreelancerID() {
        return freelancerID;
    }

    public void setFreelancerID(FreelancerTB freelancerID) {
        this.freelancerID = freelancerID;
    }

    public CompanyTB getCompanyID() {
        return companyID;
    }

    public void setCompanyID(CompanyTB companyID) {
        this.companyID = companyID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewID != null ? reviewID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReviewTB)) {
            return false;
        }
        ReviewTB other = (ReviewTB) object;
        if ((this.reviewID == null && other.reviewID != null) || (this.reviewID != null && !this.reviewID.equals(other.reviewID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ReviewTB[ reviewID=" + reviewID + " ]";
    }
    
}
