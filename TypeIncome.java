/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expences;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mohammed Isam
 */
@Entity
@Table(name = "TYPE_INCOME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeIncome.findAll", query = "SELECT t FROM TypeIncome t"),
    @NamedQuery(name = "TypeIncome.findByTypeid", query = "SELECT t FROM TypeIncome t WHERE t.typeid = :typeid"),
    @NamedQuery(name = "TypeIncome.findByTypeIncomer", query = "SELECT t FROM TypeIncome t WHERE t.typeIncomer = :typeIncomer")})
public class TypeIncome implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TYPEID")
    private BigDecimal typeid;
    @Column(name = "TYPE_INCOMER")
    private String typeIncomer;
    @JoinColumn(name = "INCOMEID", referencedColumnName = "INCOMID")
    @ManyToOne
    private Income incomeid;

    public TypeIncome() {
    }

    public TypeIncome(BigDecimal typeid) {
        this.typeid = typeid;
    }

    public BigDecimal getTypeid() {
        return typeid;
    }

    public void setTypeid(BigDecimal typeid) {
        this.typeid = typeid;
    }

    public String getTypeIncomer() {
        return typeIncomer;
    }

    public void setTypeIncomer(String typeIncomer) {
        this.typeIncomer = typeIncomer;
    }

    public Income getIncomeid() {
        return incomeid;
    }

    public void setIncomeid(Income incomeid) {
        this.incomeid = incomeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeid != null ? typeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeIncome)) {
            return false;
        }
        TypeIncome other = (TypeIncome) object;
        if ((this.typeid == null && other.typeid != null) || (this.typeid != null && !this.typeid.equals(other.typeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Expences.TypeIncome[ typeid=" + typeid + " ]";
    }
    
}
