package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer(123,"Arjun",22,45678);

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        //Deserialization
        Customer deserCust = null;

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            //Serialization
            fos = new FileOutputStream("Customer.ser");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(customer);
            oos.flush();
            oos.close();

            System.out.println("Serialization done here");

            //Deserialization
            fis = new FileInputStream("Customer.ser");
            ois = new ObjectInputStream(fis);

            deserCust = (Customer) ois.readObject();
            ois.close();

            System.out.println("Deserialization done here");
        }
        catch(FileNotFoundException f){
            f.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException c){
            c.printStackTrace();
        }

        //System.out.println("Customer object is saved to Custome.ser file");
        System.out.println("In result of deserialization custAge and password will so null or 0 bcoz we didn't serialize them -> " + deserCust);
    }
}