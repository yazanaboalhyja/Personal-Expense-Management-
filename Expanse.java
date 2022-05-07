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
@Table(name = "EXPANSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expanse.findAll", query = "SELECT e FROM Expanse e"),
    @NamedQuery(name = "Expanse.findByExid", query = "SELECT e FROM Expanse e WHERE e.exid = :exid"),
    @NamedQuery(name = "Expanse.findByName", query = "SELECT e FROM Expanse e WHERE e.name = :name"),
    @NamedQuery(name = "Expanse.findByType", query = "SELECT e FROM Expanse e WHERE e.type = :type"),
    @NamedQuery(name = "Expanse.findByPric", query = "SELECT e FROM Expanse e WHERE e.pric = :pric"),
    @NamedQuery(name = "Expanse.findByDiscriptio", query = "SELECT e FROM Expanse e WHERE e.discriptio = :discriptio"),
    @NamedQuery(name = "Expanse.findByDateex", query = "SELECT e FROM Expanse e WHERE e.dateex = :dateex")})
public class Expanse implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EXID")
    private BigDecimal exid;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @Column(name = "PRIC")
    private BigInteger pric;
    @Basic(optional = false)
    @Column(name = "DISCRIPTIO")
    private String discriptio;
    @Basic(optional = false)
    @Column(name = "DATEEX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateex;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private Userp userid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exid")
    private Collection<ExCa> exCaCollection;

    public Expanse() {
    }

    public Expanse(BigDecimal exid) {
        this.exid = exid;
    }

    public Expanse(BigDecimal exid, String name, String type, BigInteger pric, String discriptio, Date dateex) {
        this.exid = exid;
        this.name = name;
        this.type = type;
        this.pric = pric;
        this.discriptio = discriptio;
        this.dateex = dateex;
    }

    public BigDecimal getExid() {
        return exid;
    }

    public void setExid(BigDecimal exid) {
        this.exid = exid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigInteger getPric() {
        return pric;
    }

    public void setPric(BigInteger pric) {
        this.pric = pric;
    }

    public String getDiscriptio() {
        return discriptio;
    }

    public void setDiscriptio(String discriptio) {
        this.discriptio = discriptio;
    }

    public Date getDateex() {
        return dateex;
    }

    public void setDateex(Date dateex) {
        this.dateex = dateex;
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
        hash += (exid != null ? exid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expanse)) {
            return false;
        }
        Expanse other = (Expanse) object;
        if ((this.exid == null && other.exid != null) || (this.exid != null && !this.exid.equals(other.exid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Expences.Expanse[ exid=" + exid + " ]";
    }
    
}
