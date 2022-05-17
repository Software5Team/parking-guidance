package Parking_System;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Customers implements FileProcessing{
    
    private String carNumber,ownerName,mobilenumber;
    private int plateNumber,EntryId;
    private double Price;
    static int StaticEntryId = 100;
    
    private Date entryDate = new Date ();
    private Date exitDate = new Date ();
    
    final private String customersFileName = "customers.txt";
    final private String ParkedCarFileName = "ParkedCar.txt";
    
    ArrayList<Customers> customers = new ArrayList<Customers> ();
    ArrayList<Customers> ParkedCustomers = new ArrayList<Customers> ();

    Operator Op = new Operator ();
    FileManger fManger = new FileManger ();

    public Customers () {
    }
    public Customers (String carNumber, String ownerName, int plateNumber,String mobilenumber) {
        this.carNumber = carNumber;
        this.ownerName = ownerName;
        this.plateNumber = plateNumber;
        this.mobilenumber = mobilenumber;
    }

    public int getEntryId () {
        return EntryId;
    }
    public void setEntryId (int entryId) {
        EntryId = entryId;
    }
    public void setEntryId () {
        loadFromFile ();
        if(customers.size () != 0)
        {
            EntryId =  customers.get (customers.size ()-1).getEntryId () + 1;
        }
        else
        {
            EntryId = StaticEntryId;
        }
    }

    public String getMobilenumber () {
        return mobilenumber;
    }
    public void setMobilenumber (String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public double getPrice () {
        return Price;
    }
    public void setPrice (double price) {
        Price = price;
    }

    public String getCarNumber () {
        return carNumber;
    }
    public void setCarNumber (String carNumber) {
        this.carNumber = carNumber;
    }

    public String getOwnerName () {
        return ownerName;
    }
    public void setOwnerName (String ownerName) {
        this.ownerName = ownerName;
    }

    public int getPlateNumber () {
        return plateNumber;
    }
    public void setPlateNumber (int plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getEntryDate ()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate = formatter.format(entryDate);
        return strDate;
    }
    public void setEntryDate (Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getExitDate () {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate = formatter.format(exitDate);
        return strDate;
    }
    public void setExitDate (Date exitDate) {
        this.exitDate = exitDate;
    }

    public String getCustomersFileName () {
        return customersFileName;
    }
    
    public String getParkedCarFileName () {
        return ParkedCarFileName;
    }

    public ArrayList<Customers> getCustomers () {
        return customers;
    }

    public ArrayList<Customers> getParkedCustomers () {
        return ParkedCustomers;
    }

    @Override
    public String toString () {
        return "Customers{" +
                "EntryId = "+ EntryId + " , " +
                "carNumber='" + carNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", plateNumber=" + plateNumber +
                ", Price=" + Price +
                ", entryDate=" + entryDate +
                ", exitDate=" + exitDate +
                '}';
    }

    @Override
    public void loadFromFile ()  {
        customers = (ArrayList<Customers>) (Object) fManger.read(customersFileName);
    }

    public void loadFromParkedCarFile ()  {
        ParkedCustomers = (ArrayList<Customers>) (Object) fManger.read(ParkedCarFileName);
    }

    @Override
    public void commitToFile () {
        if(customers.size () != 0)
        {
            fManger.write (customers.get (0).getData (), customersFileName, false);
            for (int i = 1; i < customers.size (); i++) {
                fManger.write (customers.get (i).getData (), customersFileName, true);
            }
        }
        else
            fManger.write ("", customersFileName, false);
    }

    public void commitToParkedCarFile () {
        if(ParkedCustomers.size () != 0) {
            fManger.write (ParkedCustomers.get (0).getData (), ParkedCarFileName, false);
            for (int i = 1; i < ParkedCustomers.size (); i++) {
                fManger.write (ParkedCustomers.get (i).getData (), ParkedCarFileName, true);
            }
        }
        else
            fManger.write ("", ParkedCarFileName, false);
    }
    
    public boolean searchCustomer(int ticketID)
    {
        loadFromFile();
        for (int i = 0; i < customers.size (); i++)
            if (customers.get (i).getEntryId () == ticketID)
                return true;
        return false;

    }
    
    public Customers getCustomerData(int ticketid)
    {
        loadFromFile ();
        for(int i = 0; i < customers.size (); i++)
        {
            if(customers.get (i).getEntryId () == ticketid)
                return customers.get (i);
        }
        return null;
    }
    
    public String printTicket()
    {
        String S = "Error..!\nInvalid Plate Number";
        for(int i = 0; i < Op.getFreeSpots ().size (); i++) {
            if (this.getPlateNumber () == Op.getFreeSpots ().get (i).getSpotId ())
            {
                setEntryId ();
                S = "Entry Id is : " + getEntryId () + "\n" +
                        "Plate Number is : " + this.getPlateNumber () +
                        "-" + Op.getSpotDescription (Op.getFreeSpots (), this.getPlateNumber ()) +
                        "\n" + "Car Owner : "+ this.getOwnerName () + "\n" + "Car Number is : " + 
                        this.getCarNumber () + "\n" + "Entry Date is : " + this.getEntryDate () + "\n";
                writeCustomer ();
                Op.setStatue (this.getPlateNumber (),false);
                StaticEntryId++;
            }
        }
        return S;
    }
    
     public double Pay(int EntryId)
    {
        Price = Op.calculateTotalMoney (EntryId);
        leaveCustomer (EntryId);
        return Price;
    }
     
     private String getData() {
        return getEntryId () + "~"
                + this.getCarNumber () +
                "~" + this.getOwnerName () +
                "~"+this.getMobilenumber ()+
                "~" + this.getPlateNumber () +
                "~" + this.getEntryDate ();
    }
     
    private void writeCustomer()
    {
        loadFromFile ();
        if(customers.size () != 0) {
            fManger.write (this.getData (),customersFileName,true);
        }
        else
        {
            fManger.write (this.getData (),customersFileName,false);
        }

    }
    
    private void leaveCustomer(int entryId)
    {
        loadFromFile ();
        loadFromParkedCarFile ();
        for(int i =0; i < customers.size ();i++ )
        {
            if(customers.get (i).getEntryId () == entryId)
            {
                System.out.println ("Ya Rab");
                Op.setStatue (customers.get (i).getPlateNumber (),true);
                String S = customers.get(i).getData () + "~" + getExitDate () + "~" + getPrice ();
                writeParkedCustomers (S);
                customers.remove (i);
                commitToFile ();
                return;
            }
        }
    }
    
    private void writeParkedCustomers(String S)
    {
        loadFromParkedCarFile ();
        if(ParkedCustomers.size () != 0) {
            fManger.write (S,ParkedCarFileName,true);
        }
        else
        {
            fManger.write (S,ParkedCarFileName,false);
        }
    }
}
