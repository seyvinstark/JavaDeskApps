/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auca.domain;

import auca.util.UtilHibernate;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author SEYVIN
 */
@Entity
public class Dasso {
    @Id
    private String nationalid;
    private String names;
    private Date dob;
    private String gender;
    private int salary;
    @ManyToOne
    @JoinColumn(name="dist")
    private District district;
    @ManyToOne
    @JoinColumn(name="prov")
    private Province province;

    public String getNationalid() {
        return nationalid;
    }

    public void setNationalid(String nationalid) {
        this.nationalid = nationalid;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
    
        public static void save(Dasso d){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(d);
        ss.getTransaction().commit();
        ss.close();
    }
     public static void update(Dasso d){
    Session ss = UtilHibernate.getSessionFactory().openSession();
    ss.beginTransaction();
    ss.update(d);
    ss.getTransaction().commit();
    ss.close();
    }
    public static void delete(Dasso d){
        Session ss= UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.delete(d);
        ss.getTransaction().commit();
        ss.close();
    }
    public static Dasso search(String id){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        Dasso d = (Dasso) ss.get(Dasso.class, id);
        ss.close();
        return d;
    }
    public static List<Dasso> getAll(String id){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        Query q = ss.createQuery("from Dasso d");
        List<Dasso> list = q.list();
        ss.close();
        return list;
    }
    
    @Override
    public String toString(){
        return district.toString();
    }
    
}
