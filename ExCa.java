/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expences;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
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
@Table(name = "EX_CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExCa.findAll", query = "SELECT e FROM ExCa e"),
    @NamedQuery(name = "ExCa.findByExcaid", query = "SELECT e FROM ExCa e WHERE e.excaid = :excaid")})
public class ExCa implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EXCAID")
    private BigDecimal excaid;
    @JoinColumn(name = "CAID", referencedColumnName = "CAID")
    @ManyToOne(optional = false)
    private Calculate caid;
    @JoinColumn(name = "EXID", referencedColumnName = "EXID")
    @ManyToOne(optional = false)
    private Expanse exid;
  
    

  
    ArrayList<String> SR = new ArrayList<String>();
            
    public ExCa() {
    }

    public ExCa(BigDecimal excaid) {
        this.excaid = excaid;
    }

    public BigDecimal getExcaid() {
        return excaid;
    }
    

    public void setExcaid(BigDecimal excaid) {
        this.excaid = excaid;
    }

    public Calculate getCaid() {
        return caid;
    }

    public void setCaid(Calculate caid) {
        this.caid = caid;
    }

    public Expanse getExid() {
        return exid;
    }

    public void setExid(Expanse exid) {
        this.exid = exid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (excaid != null ? excaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExCa)) {
            return false;
        }
        ExCa other = (ExCa) object;
        if ((this.excaid == null && other.excaid != null) || (this.excaid != null && !this.excaid.equals(other.excaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Expences.ExCa[ excaid=" + excaid + " ]";
    }
    
}
