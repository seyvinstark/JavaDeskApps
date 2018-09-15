/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auca.domain;

import java.io.File;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SEYVIN
 */
@XmlRootElement
@Entity
public class Employees {
    @Id
    private String id;
    private String name;
    private int salary;

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    public static void main(String[] args){
        try{
            Employees e = new Employees();
            e.setId("1");
            e.setName("sam");
            e.setSalary(45000000);
            
            JAXBContext cx= JAXBContext.newInstance(Employees.class);
            Marshaller mac = cx.createMarshaller();
            mac.marshal(e, new File("D:/Employee.xml"));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
