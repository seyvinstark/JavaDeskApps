/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auca.domain;

import auca.util.UtilHibernate;
import java.util.List;
import javax.persistence.Entity;
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
public class Village {
    @Id
    private String id;
    private String name;
    @ManyToOne
    @JoinColumn(name="vill")
    private Cell cell;
   

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

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

  
    
    public static void save(Village v){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(v);
        ss.getTransaction().commit();
        ss.close();
    }
     public static void update(Village v){
    Session ss = UtilHibernate.getSessionFactory().openSession();
    ss.beginTransaction();
    ss.update(v);
    ss.getTransaction().commit();
    ss.close();
    }
    public static void delete(Village v){
        Session ss= UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.delete(v);
        ss.getTransaction().commit();
        ss.close();
    }
    public static Village search(String id){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        Village v = (Village) ss.get(Village.class, id);
        ss.close();
        return v;
    }
    public static List<Village> getAll(String id){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        Query q = ss.createQuery("from Village c");
        List<Village> list = q.list();
        ss.close();
        return list;
    }
    @Override
    public String toString(){
        return name;
    }
}
