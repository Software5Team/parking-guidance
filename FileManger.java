package Parking_System;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileManger {

    public boolean write(String Query,String FilePath,boolean appendType)
    {
        PrintWriter writer = null;
        try
        {
            writer = new PrintWriter(new FileWriter(new File(FilePath), appendType));
            writer.println(Query); 
            return true;
        }catch (IOException e)
        {
            System.err.println("An IOException was caught!");
            e.printStackTrace();
        }
        finally {
            writer.close();
        }
        return false;
    }

    public ArrayList<Object> read(String filePath) {
        Scanner reader;
        try {
            reader = new Scanner(new File(filePath));
        }catch (FileNotFoundException e)
        {
            System.err.println("An IOException was caught!");
            e.printStackTrace();
            return null;
        }
        if(filePath.equals("Admins.txt"))
        {
            ArrayList <Admin> Adm = new ArrayList<Admin> ();
            Admin X;
            while (reader.hasNext ())
            {
                String Line = reader.nextLine ();
                if(Line != "") 
                {
                    X = new Admin ();
                    String[] separated = Line.split ("~");
                    X.setSSN (Integer.parseInt (separated[0]));
                    X.setname (separated[1]);
                    X.setUserName (separated[2]);
                    X.setPassword (separated[3]);
                    X.setTelephone (separated[4]);
                    X.setSalary (Double.parseDouble (separated[5]));
                    Adm.add (X);
                }
            }
            return (ArrayList<Object>) (Object) Adm;
        }
        else if(filePath.equals("Users.txt"))
        {
            ArrayList<User> users = new ArrayList<User> ();
            User X;
            while (reader.hasNext ())
            {
                String Line = reader.nextLine ();
                if(!Line.equals (""))
                {
                    X = new User ();
                    String[] separated = Line.split ("~");
                    X.setSSN (Integer.parseInt (separated[0]));
                    X.setname (separated[1]);
                    X.setUserName (separated[2]);
                    X.setPassword (separated[3]);
                    X.setTelephone (separated[4]);
                    X.setSalary (Double.parseDouble (separated[5]));
                    users.add (X);
                }
            }
            return  (ArrayList<Object>) (Object) users;
        }
        else if(filePath.equals("Spots.txt"))
        {
            ArrayList<Spots> users = new ArrayList<Spots> ();
            Spots X;
            while (reader.hasNext ())
            {
                String Line = reader.nextLine ();
                if(!Line.equals (""))
                {
                    X = new Spots ();
                    String[] separated = Line.split ("~");
                    X.setSpotId (Integer.parseInt (separated[0]));
                    X.setDescription (separated[1].charAt (0));
                    X.setStatue (Boolean.parseBoolean (separated[2]));
                    users.add (X);
                }
            }
            return  (ArrayList<Object>) (Object) users;
        }
        else if(filePath.equals("customers.txt"))
        {
            ArrayList<Customers> Cust = new ArrayList<Customers> ();
            Customers C;
            while (reader.hasNext ())
            {
                String Line = reader.nextLine ();
                if(!Line.equals (""))
                {


                    C = new Customers ();
                    String[] separated = Line.split ("~");
                    C.setEntryId (Integer.parseInt (separated[0]));
                    C.setCarNumber (separated[1]);
                    C.setOwnerName (separated[2]);
                    C.setMobilenumber (separated[3]);
                    C.setPlateNumber (Integer.parseInt (separated[4]));
                    try {
                        Date date = new SimpleDateFormat ("dd-M-yyyy hh:mm:ss").parse (separated[5]);
                        C.setEntryDate (date);
                    } catch (ParseException e) {
                        e.printStackTrace ();
                    }

                    Cust.add (C);
                }
            }
            return(ArrayList<Object>) (Object) Cust;
        }
        else if(filePath.equals("ParkedCar.txt"))
        {
            ArrayList<Customers> ParkedCustomer = new ArrayList<Customers> ();
            Customers C;
            while (reader.hasNext ())
            {
                String Line = reader.nextLine ();
                if(!Line.equals (""))
                {
                    C = new Customers ();
                    String[] separated = Line.split ("~");
                    C.setEntryId (Integer.parseInt (separated[0]));
                    C.setCarNumber (separated[1]);
                    C.setOwnerName (separated[2]);
                    C.setMobilenumber (separated[3]);
                    C.setPlateNumber (Integer.parseInt (separated[4]));
                    try {
                        Date date = new SimpleDateFormat ("dd-M-yyyy hh:mm:ss").parse (separated[5]);
                        C.setEntryDate (date);
                    } catch (ParseException e) {
                        e.printStackTrace ();
                    }
                    try {
                        Date date = new SimpleDateFormat ("dd-M-yyyy hh:mm:ss").parse (separated[6]);
                        C.setExitDate (date);
                    } catch (ParseException e) {
                        e.printStackTrace ();
                    }

                    C.setPrice (Double.parseDouble (separated[7]));
                    ParkedCustomer.add (C);
                }
            }
            return(ArrayList<Object>) (Object) ParkedCustomer;
        }
        return null;
    }

}