/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expences;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mohammed Isam
 */
@Entity
@Table(name = "USERP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userp.findAll", query = "SELECT u FROM Userp u"),
    @NamedQuery(name = "Userp.findByUserid", query = "SELECT u FROM Userp u WHERE u.userid = :userid"),
    @NamedQuery(name = "Userp.findByUsername", query = "SELECT u FROM Userp u WHERE u.username = :username"),
    @NamedQuery(name = "Userp.findByPassword", query = "SELECT u FROM Userp u WHERE u.password = :password"),
    @NamedQuery(name = "Userp.findByOld", query = "SELECT u FROM Userp u WHERE u.old = :old"),
    @NamedQuery(name = "Userp.findByJop", query = "SELECT u FROM Userp u WHERE u.jop = :jop"),
    @NamedQuery(name = "Userp.findByEmail", query = "SELECT u FROM Userp u WHERE u.email = :email"),
    @NamedQuery(name = "Userp.findByPhonenumber", query = "SELECT u FROM Userp u WHERE u.phonenumber = :phonenumber")})
public class Userp implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "USERID")
    private BigDecimal userid;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "OLD")
    private short old;
    @Basic(optional = false)
    @Column(name = "JOP")
    private String jop;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "PHONENUMBER")
    private long phonenumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Expanse> expanseCollection;
    @OneToMany(mappedBy = "userid")
    private Collection<Calculate> calculateCollection;
    @OneToMany(mappedBy = "userid")
    private Collection<Income> incomeCollection;

    public Userp() {
    }

    public Userp(BigDecimal userid) {
        this.userid = userid;
    }

    public Userp(BigDecimal userid, String username, String password, short old, String jop, String email, long phonenumber) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.old = old;
        this.jop = jop;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    public BigDecimal getUserid() {
        return userid;
    }

    public void setUserid(BigDecimal userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getOld() {
        return old;
    }

    public void setOld(short old) {
        this.old = old;
    }

    public String getJop() {
        return jop;
    }

    public void setJop(String jop) {
        this.jop = jop;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    @XmlTransient
    public Collection<Expanse> getExpanseCollection() {
        return expanseCollection;
    }

    public void setExpanseCollection(Collection<Expanse> expanseCollection) {
        this.expanseCollection = expanseCollection;
    }

    @XmlTransient
    public Collection<Calculate> getCalculateCollection() {
        return calculateCollection;
    }

    public void setCalculateCollection(Collection<Calculate> calculateCollection) {
        this.calculateCollection = calculateCollection;
    }

    @XmlTransient
    public Collection<Income> getIncomeCollection() {
        return incomeCollection;
    }

    public void setIncomeCollection(Collection<Income> incomeCollection) {
        this.incomeCollection = incomeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userp)) {
            return false;
        }
        Userp other = (Userp) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Expences.Userp[ userid=" + userid + " ]";
    }
    
}
