/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expences;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mohammed Isam
 */
@Entity
@Table(name = "CALCULATE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calculate.findAll", query = "SELECT c FROM Calculate c"),
    @NamedQuery(name = "Calculate.findByCaid", query = "SELECT c FROM Calculate c WHERE c.caid = :caid"),
    @NamedQuery(name = "Calculate.findBySumepanse", query = "SELECT c FROM Calculate c WHERE c.sumepanse = :sumepanse"),
    @NamedQuery(name = "Calculate.findByRemainigSalary", query = "SELECT c FROM Calculate c WHERE c.remainigSalary = :remainigSalary"),
    @NamedQuery(name = "Calculate.findByDateCalculate", query = "SELECT c FROM Calculate c WHERE c.dateCalculate = :dateCalculate")})
public class Calculate implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CAID")
    private BigDecimal caid;
    @Column(name = "SUMEPANSE")
    private BigInteger sumepanse;
    @Column(name = "REMAINIG_SALARY")
    private BigInteger remainigSalary;
    @Basic(optional = false)
    @Column(name = "DATE_CALCULATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCalculate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caid")
    private Collection<InCa> inCaCollection;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne
    private Userp userid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caid")
    private Collection<ExCa> exCaCollection;

    public Calculate() {
    }

    public Calculate(BigDecimal caid) {
        this.caid = caid;
    }

    public Calculate(BigDecimal caid, Date dateCalculate) {
        this.caid = caid;
        this.dateCalculate = dateCalculate;
    }

    public BigDecimal getCaid() {
        return caid;
    }

    public void setCaid(BigDecimal caid) {
        this.caid = caid;
    }

    public BigInteger getSumepanse() {
        return sumepanse;
    }

    public void setSumepanse(BigInteger sumepanse) {
        this.sumepanse = sumepanse;
    }

    public BigInteger getRemainigSalary() {
        return remainigSalary;
    }

    public void setRemainigSalary(BigInteger remainigSalary) {
        this.remainigSalary = remainigSalary;
    }

    public Date getDateCalculate() {
        return dateCalculate;
    }

    public void setDateCalculate(Date dateCalculate) {
        this.dateCalculate = dateCalculate;
    }

    @XmlTransient
    public Collection<InCa> getInCaCollection() {
        return inCaCollection;
    }

    public void setInCaCollection(Collection<InCa> inCaCollection) {
        this.inCaCollection = inCaCollection;
    }

    public Userp getUserid() {
        return userid;
    }

    public void setUserid(Userp userid) {
        this.userid = userid;
    }

    @XmlTransient
    public Collection<ExCa> getExCaCollection() {
        return exCaCollection;
    }

    public void setExCaCollection(Collection<ExCa> exCaCollection) {
        this.exCaCollection = exCaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caid != null ? caid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calculate)) {
            return false;
        }
        Calculate other = (Calculate) object;
        if ((this.caid == null && other.caid != null) || (this.caid != null && !this.caid.equals(other.caid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Expences.Calculate[ caid=" + caid + " ]";
    }
    
}
