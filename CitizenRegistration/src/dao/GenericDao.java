/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import auca.util.UtilHibernate;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author SEYVIN
 */
public class GenericDao <X>{
    public void create(X x) {
        
        Session session = UtilHibernate.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(x);
        session.getTransaction().commit();
        session.close();
        
    }
    
    public void update(X x) {
        
        Session session = UtilHibernate.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(x);
        session.getTransaction().commit();
        session.close();
        
    }
    
    public void delete(X x) {
        
        Session session = UtilHibernate.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(x);
        session.getTransaction().commit();
        session.close();
        
    }
    
    public X findById(Class c, Serializable id){
        Session session = UtilHibernate.getSessionFactory().openSession();
        X x = (X) session.get(c, id);
        session.close();
        return x;
    }
    
    public List<X> findAll(Class c){
        Session session = UtilHibernate.getSessionFactory().openSession();
        Query q = session.createQuery("SELECT s FROM " + c.getName() + " s");
        
        List<X> list = q.list();
        session.close();
        return list;
    }
    
}
