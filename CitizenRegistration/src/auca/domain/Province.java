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
import javax.persistence.OneToMany;
import org.hibernate.Query;
import org.hibernate.Session;

@Entity
public class Province {
    @Id
    private String id;
    private String name;
    @OneToMany(mappedBy="province")
    private List<District>district;
    //@manytomany(fetch = fetchtype.EAGER)
   //jointable(name="course registration")
//        joincolumn = {@jojincolumn(name="primarykey from the first table===studid")}
  ///inverse joincolumn={@joincolumn(name="ccode")}
    //private list<course>courses; or private set<course>courses this one doesnt have dupliates
    
    
    /*
    main clas{
    GENERICdao<student> studentdao = new genericdao<>()
    GENERICdao<courset> coursedao = new genericdao<>()
    student s = studdao.findbyid(student.class,"26348");
    course c1 = coursedao.findbyid(ckass,"insy12");
    course c1 = coursedao.findbyid(ckass,"acct2");
    c.getcourses().add(c1);
    c.getcourses().add(c2);
    
    studentdao.update(s);
        
    to get the student 
        for(Course c : c.getcourses()){
            s.o.p(c.getname)
    }
    
    }
    
    */
    //private list<course> courses;
    
    //notes:learn how to use lists and set collection,to implemenet comparable interface
    //homework a student registers for courses and u show him the courses he pickeddo student and courses where a student can registers i the database eg:p
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

    public List<District> getDistrict() {
        return district;
    }

    public void setDistrict(List<District> district) {
        this.district = district;
    }

    
    
    public static void save(Province p){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(p);
        ss.getTransaction().commit();
        ss.close();
    }
     public static void update(Province p){
    Session ss = UtilHibernate.getSessionFactory().openSession();
    ss.beginTransaction();
    ss.update(p);
    ss.getTransaction().commit();
    ss.close();
    }
    public static void delete(Province p){
        Session ss= UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.delete(p);
        ss.getTransaction().commit();
        ss.close();
    }
    public static Province search(String id){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        Province p = (Province) ss.get(Province.class, id);
        ss.close();
        return p;
    }
    public static List<Province> getAll(String id){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        Query q = ss.createQuery("from Province p");
        List<Province> list = q.list();
        ss.close();
        return list;
    }
    @Override
    public String toString(){
        return name;
    }
}
