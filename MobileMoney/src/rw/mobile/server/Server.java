/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.mobile.server;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import rw.mobile.dao.MobileAccountDao;
import rw.mobile.domain.MobileAccount;


public class Server {
   public static void main(String[] args) {
        // TODO code application logic here
       
        // TODO code application logic here
        try {
            ServerSocket serverSocket = new ServerSocket(7654);
            MobileAccountDao<MobileAccount> mobileAccountDao = new MobileAccountDao<>();
            Scanner reader;
            PrintWriter writer;
            while (true) {
                Socket socket = serverSocket.accept();
                reader = new Scanner(socket.getInputStream());
                String msgFromClient = reader.nextLine();

                String[] strings = msgFromClient.split("#");
                String sender = strings[0];
                String receiver = strings[1];
                String amount = strings[2];

                MobileAccount accountSender = mobileAccountDao.findbyid(MobileAccount.class, sender);
                MobileAccount accountReceiver = mobileAccountDao.findbyid(MobileAccount.class, receiver);

                if (accountSender != null) {
                    if (accountReceiver != null) {
                        Double senderBalance = accountSender.getAccountBalance() - Double.parseDouble(amount);
                        if (senderBalance >= 0) {
                            Double oldReceiverBalance = accountReceiver.getAccountBalance();
                            Double newReceiverBalance = oldReceiverBalance + Double.parseDouble(amount);

                            accountSender.setAccountBalance(senderBalance);
                            accountReceiver.setAccountBalance(newReceiverBalance);

                            writer = new PrintWriter(socket.getOutputStream());
                            writer.println("Successful transfer of "
                                     + amount  
                                    + "from account of "
                                     + accountSender 
                                    + "to account of "
                                     + accountReceiver + " the current balance is " + accountSender.getAccountBalance());
                            writer.flush();
                            mobileAccountDao.update(accountSender);
                            mobileAccountDao.update(accountReceiver);
                        } else {
                            writer = new PrintWriter(socket.getOutputStream());
                            writer.println("Insufficient account balance on the account of "
                                    + "[ " + accountSender + " ] "
                                    + "the current balance is "
                                    + "[ " + accountSender.getAccountBalance() + " ]");
                            writer.flush();
                        }
                    } else {
                        writer = new PrintWriter(socket.getOutputStream());
                        writer.println(receiver + " doesn't exists");
                        writer.flush();
                    }
                } else {
                    writer = new PrintWriter(socket.getOutputStream());
                    writer.println(sender + " doesn't exists");
                    writer.flush();
                }
                writer.close();
                reader.close();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
