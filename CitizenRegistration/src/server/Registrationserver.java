/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import auca.domain.Citizen;
import dao.GenericDao;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author SEYVIN
 */
public class Registrationserver {
    public static void main(String[] args){
        try{
            ServerSocket ss = new ServerSocket(444);
            System.out.println("server running..");
            while(true){
                Socket client = ss.accept();
                Scanner in = new Scanner(client.getInputStream());
                PrintWriter out = new PrintWriter(client.getOutputStream());
                String request = in.nextLine();
                String[] reqvalue = request.split("#");
                String response = "";
                if(reqvalue[0].equals("1")){
                try{
                    Citizen c = new Citizen();
                    c.setId(reqvalue[1]);
                    c.setFirstname(reqvalue[2]);
                    GenericDao<Citizen> citdao = new GenericDao<>();
                    citdao.create(c);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                }else if(reqvalue[2].equals("2")){
                
                }else{
                    
                }
                
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
