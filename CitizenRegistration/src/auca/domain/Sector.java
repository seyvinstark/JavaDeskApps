
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
 */@Entity
public class Sector {
    @Id
    private String id;
    private String name;
    @ManyToOne
    @JoinColumn(name="dist")
    private District district;
    @OneToMany(mappedBy="sector",fetch = FetchType.EAGER)
    private List<Cell> cell;

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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<Cell> getCell() {
        return cell;
    }

    public void setCell(List<Cell> cell) {
        this.cell = cell;
    }

   
    
    public static void save(Sector s){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(s);
        ss.getTransaction().commit();
        ss.close();
    }
     public static void update(Sector s){
    Session ss = UtilHibernate.getSessionFactory().openSession();
    ss.beginTransaction();
    ss.update(s);
    ss.getTransaction().commit();
    ss.close();
    }
    public static void delete(Sector s){
        Session ss= UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.delete(s);
        ss.getTransaction().commit();
        ss.close();
    }
    public static Sector search(String id){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        Sector s = (Sector) ss.get(Sector.class, id);
        ss.close();
        return s;
    }
    public static List<Sector> getAll(String id){
        Session ss = UtilHibernate.getSessionFactory().openSession();
        Query q = ss.createQuery("from Sector s");
        List<Sector> list = q.list();
        ss.close();
        return list;
    }
    @Override
    public String toString(){
        return name;
    }
}
