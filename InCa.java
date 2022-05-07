/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expences;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mohammed Isam
 */
@Entity
@Table(name = "IN_CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InCa.findAll", query = "SELECT i FROM InCa i"),
    @NamedQuery(name = "InCa.findByIncaid", query = "SELECT i FROM InCa i WHERE i.incaid = :incaid"),
    @NamedQuery(name = "InCa.findByIncomedid", query = "SELECT i FROM InCa i WHERE i.incomedid = :incomedid")})
public class InCa implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "INCAID")
    private BigDecimal incaid;
    @Basic(optional = false)
    @Column(name = "INCOMEDID")
    private BigInteger incomedid;
    @JoinColumn(name = "CAID", referencedColumnName = "CAID")
    @ManyToOne(optional = false)
    private Calculate caid;
    @JoinColumn(name = "INCAID", referencedColumnName = "INCOMID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Income income;

    public InCa() {
    }

    public InCa(BigDecimal incaid) {
        this.incaid = incaid;
    }

    public InCa(BigDecimal incaid, BigInteger incomedid) {
        this.incaid = incaid;
        this.incomedid = incomedid;
    }

    public BigDecimal getIncaid() {
        return incaid;
    }

    public void setIncaid(BigDecimal incaid) {
        this.incaid = incaid;
    }

    public BigInteger getIncomedid() {
        return incomedid;
    }

    public void setIncomedid(BigInteger incomedid) {
        this.incomedid = incomedid;
    }

    public Calculate getCaid() {
        return caid;
    }

    public void setCaid(Calculate caid) {
        this.caid = caid;
    }

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (incaid != null ? incaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InCa)) {
            return false;
        }
        InCa other = (InCa) object;
        if ((this.incaid == null && other.incaid != null) || (this.incaid != null && !this.incaid.equals(other.incaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Expences.InCa[ incaid=" + incaid + " ]";
    }
    
}
