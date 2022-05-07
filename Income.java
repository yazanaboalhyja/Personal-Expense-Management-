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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mohammed Isam
 */
@Entity
@Table(name = "INCOME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Income.findAll", query = "SELECT i FROM Income i"),
    @NamedQuery(name = "Income.findByIncomid", query = "SELECT i FROM Income i WHERE i.incomid = :incomid"),
    @NamedQuery(name = "Income.findByTypeTime", query = "SELECT i FROM Income i WHERE i.typeTime = :typeTime"),
    @NamedQuery(name = "Income.findByIncomeAmount", query = "SELECT i FROM Income i WHERE i.incomeAmount = :incomeAmount"),
    @NamedQuery(name = "Income.findByCurrency", query = "SELECT i FROM Income i WHERE i.currency = :currency")})
public class Income implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "INCOMID")
    private BigDecimal incomid;
    @Column(name = "TYPE_TIME")
    private String typeTime;
    @Column(name = "INCOME_AMOUNT")
    private BigInteger incomeAmount;
    @Column(name = "CURRENCY")
    private String currency;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "income")
    private InCa inCa;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne
    private Userp userid;
    @OneToMany(mappedBy = "incomeid")
    private Collection<TypeIncome> typeIncomeCollection;

    public Income() {
    }

    public Income(BigDecimal incomid) {
        this.incomid = incomid;
    }

    public BigDecimal getIncomid() {
        return incomid;
    }

    public void setIncomid(BigDecimal incomid) {
        this.incomid = incomid;
    }

    public String getTypeTime() {
        return typeTime;
    }

    public void setTypeTime(String typeTime) {
        this.typeTime = typeTime;
    }

    public BigInteger getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(BigInteger incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public InCa getInCa() {
        return inCa;
    }

    public void setInCa(InCa inCa) {
        this.inCa = inCa;
    }

    public Userp getUserid() {
        return userid;
    }

    public void setUserid(Userp userid) {
        this.userid = userid;
    }

    @XmlTransient
    public Collection<TypeIncome> getTypeIncomeCollection() {
        return typeIncomeCollection;
    }

    public void setTypeIncomeCollection(Collection<TypeIncome> typeIncomeCollection) {
        this.typeIncomeCollection = typeIncomeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (incomid != null ? incomid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Income)) {
            return false;
        }
        Income other = (Income) object;
        if ((this.incomid == null && other.incomid != null) || (this.incomid != null && !this.incomid.equals(other.incomid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Expences.Income[ incomid=" + incomid + " ]";
    }
    
}
