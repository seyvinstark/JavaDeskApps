/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.mobile.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import rw.mobile.util.HibernateUtil;


public class MobileAccountDao <X>{
   public  void register(X x){
        Session ses = HibernateUtil.getSessionFactory().openSession();
        ses.beginTransaction();
        ses.save(x);
        ses.getTransaction().commit();
        ses.close();
}
   public void delete(X x){
       Session ses = HibernateUtil.getSessionFactory().openSession();
        ses.beginTransaction();
        ses.save(x);
        ses.getTransaction().commit();
        ses.close();
   }
   public void update(X x){
       Session ses = HibernateUtil.getSessionFactory().openSession();
       ses.beginTransaction();
       ses.update(x);
       ses.getTransaction().commit();
       ses.close();
   }
public X findbyid(Class c, Serializable id){
      Session session = HibernateUtil.getSessionFactory().openSession();
      X s = (X)session.get(c,id);

     session.close();
    return s;
}

public  List<X> getall(Class c){
        Session ses = HibernateUtil.getSessionFactory().openSession();
        Query q =ses.createQuery("from "+c.getName()+" s");
        List<X> list = q.list();
        
        ses.close();
        return list;
    
}
}
    
    
    
    