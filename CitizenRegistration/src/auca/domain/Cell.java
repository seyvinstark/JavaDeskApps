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
 * @author Seyvin
 */
@Entity
public class Cell {
    @Id
    private String id;
    private String name;
    @ManyToOne
    @JoinColumn(name="cellid")
    private Sector sector;
    @OneToMany(mappedBy="cell")
    private List<Village> village;

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

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public List<Village> getVillage() {
        return village;
    }

    public void setVillage(List<Village> village) {
        this.village = village;
    }

  
    
    public static void save(Cell c){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(c);
        ss.getTransaction().commit();
        ss.close();
    }
     public static void update(Cell c){
    Session ss = UtilHibernate.getSessionFactory().openSession();
    ss.beginTransaction();
    ss.update(c);
    ss.getTransaction().commit();
    ss.close();
    }
    public static void delete(Cell c){
        Session ss= UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.delete(c);
        ss.getTransaction().commit();
        ss.close();
    }
    public static Cell search(String id){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        Cell c = (Cell) ss.get(Cell.class, id);
        ss.close();
        return c;
    }
    public static List<Cell> getAll(String id){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        Query q = ss.createQuery("from Cell c");
        List<Cell> list = q.list();
        ss.close();
        return list;
    }
    @Override
    public String toString(){
        return name;
    }
}
