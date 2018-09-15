/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auca.domain;

import auca.util.UtilHibernate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author SEYVIN
 */
public class Child {
    private String motherId;
    private Double weight;
    private String names;
    private Date Dob;
    @ManyToOne
    @JoinColumn(name="provid")
    private Province provlist ;
    @ManyToOne
    @JoinColumn(name="distid")
    private District distlist;
    @ManyToOne
    @JoinColumn(name="sectid")
    private Sector sectlist;
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.motherId);
        return hash;
    }

    //setters and getters
    @Override    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Child other = (Child) obj;
        if (!Objects.equals(this.motherId, other.motherId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Child{" + "names=" + names + '}';
    }

    public String getMotherId() {
        return motherId;
    }

    public void setMotherId(String motherId) {
        this.motherId = motherId;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Date getDob() {
        return Dob;
    }

    public void setDob(Date Dob) {
        this.Dob = Dob;
    }

    public Province getProvlist() {
        return provlist;
    }

    public void setProvlist(Province provlist) {
        this.provlist = provlist;
    }

    public District getDistlist() {
        return distlist;
    }

    public void setDistlist(District distlist) {
        this.distlist = distlist;
    }

    public Sector getSectlist() {
        return sectlist;
    }

    public void setSectlist(Sector sectlist) {
        this.sectlist = sectlist;
    }

    
    
    public static void save(Child c){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(c);
        ss.getTransaction().commit();
        ss.close();
    }
     public static void update(Child c){
    Session ss = UtilHibernate.getSessionFactory().openSession();
    ss.beginTransaction();
    ss.update(c);
    ss.getTransaction().commit();
    ss.close();
    }
    public static void delete(Child c){
        Session ss= UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.delete(c);
        ss.getTransaction().commit();
        ss.close();
    }
    public static Child search(String id){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        Child c = (Child) ss.get(Child.class, id);
        ss.close();
        return c;
    }
//    public static List<Child> getAll(String id){
//        Session ss = UtilHibernate.getSessionFactory().openSession();
//        Query q = ss.createQuery("from Child c");
//        List<Child> list = q.list();
//        ss.close();
//        return list;
//    }
    
}
