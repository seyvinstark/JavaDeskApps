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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Seyvin
 */
@Entity
public class Citizen {
    @Id
   private String id;
   private String firstname;
   private String lastname;
   private String gender;
   @Temporal(value=TemporalType.DATE)
   private Date dob;
   
   @OneToOne
   @JoinColumn(name="villid")
   
   
   private Village village;
   @OneToOne
   @JoinColumn(name="provid")
   private Province province;
   @OneToOne
   @JoinColumn(name="sectid")
   private Sector sector;
   @OneToOne
   @JoinColumn(name="cellid")
   private Cell cell;
   @OneToOne
   @JoinColumn(name="distid")
   private District district;

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
         this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
         this.lastname = lastname;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob){
        this.dob = dob;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
   
   public static void save(Citizen c){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(c);
        ss.getTransaction().commit();
        ss.close();
    }
     public static void update(Citizen c){
    Session ss = UtilHibernate.getSessionFactory().openSession();
    ss.beginTransaction();
    ss.update(c);
    ss.getTransaction().commit();
    ss.close();
    }
    public static void delete(Citizen c){
        Session ss= UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.delete(c);
        ss.getTransaction().commit();
        ss.close();
    }
    public static Citizen search(String id){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        Citizen c = (Citizen) ss.get(Citizen.class, id);
        ss.close();
        return c;
    }
    public static List<Citizen> getAll(String id){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        Query q = ss.createQuery("from Citizen c");
        List<Citizen> list = q.list();
        ss.close();
        return list;
    }
    
    @Override
    public String toString(){
        return village.toString();
    }

}