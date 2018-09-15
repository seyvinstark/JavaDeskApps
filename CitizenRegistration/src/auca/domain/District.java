/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auca.domain;

import auca.util.UtilHibernate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author SEYVIN
 */
    @Entity
public class District {
        @Id
    private String id;
    private String name;
    @ManyToOne
    @JoinColumn(name="prov")
    private Province province;
    @OneToMany(mappedBy="district",fetch = FetchType.EAGER)
    private List<Sector> sector;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public List<Sector> getSector() {
        return sector;
    }

    public void setSector(List<Sector> sector) {
        this.sector = sector;
    }

   
    
    public static void save(District d){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(d);
        ss.getTransaction().commit();
        ss.close();
    }
     public static void update(District d){
    Session ss = UtilHibernate.getSessionFactory().openSession();
    ss.beginTransaction();
    ss.update(d);
    ss.getTransaction().commit();
    ss.close();
    }
    public static void delete(District d){
        Session ss= UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.delete(d);
        ss.getTransaction().commit();
        ss.close();
    }
    public static District search(String id){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        District d = (District) ss.get(District.class, id);
        ss.close();
        return d;
    }
    public static List<District> getAll(String id){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        Query q = ss.createQuery("from District d");
        List<District> list = q.list();
        ss.close();
        return list;
    }
    @Override
    public String toString(){
        return name;
    }
}
