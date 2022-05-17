package Parking_System;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Operator {
    private double hourCost = 60;
    
    Date exitTime;
    Spots spot = new Spots ();
    Customers customer;


    public Operator () {
    }
    
    public double getHourCost () {
        return hourCost;
    }
    public void setHourCost (double hourCost) {
        this.hourCost = hourCost;
    }
    
    public ArrayList<Spots> getFreeSpots()
    {
        return spot.viewfreeSpots ();
    }

    public boolean setStatue(int platenumber,boolean statue)
    {
        return spot.setStatue (platenumber,statue);
    }

    public char getSpotDescription(ArrayList<Spots> Arr,int id)
    {
        return spot.getSpotDescription (Arr,id);
    }

    public double calculateTotalMoney(int ticketId)
    {
        customer = new Customers ();
        double Price = 0;
        long Difference = 0;
        long DifferenceHours = 0;
        long DifferenceMinutes = 0;
        long DifferenceDays = 0;
        customer.loadFromFile ();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date EntryTime,D1,ExitTime;
        String D2;
        for(int i =0; i < customer.customers.size (); i++)
        {
            if(customer.customers.get (i).getEntryId () == ticketId)
            {
                try {
                    EntryTime = formatter.parse (customer.customers.get (i).getEntryDate ());
                    D1 = new Date ();
                    D2 = formatter.format (D1);
                    ExitTime = formatter.parse (D2);
                    customer.setExitDate (ExitTime);
                    Difference = ExitTime.getTime ()  - EntryTime.getTime () ;

                    DifferenceHours = Difference / (60 * 60 * 1000) % 24;
                    DifferenceMinutes = Difference / (60 * 1000) % 60;
                    DifferenceDays = Difference / (24 * 60 * 60 * 1000);
                    Price = DifferenceHours * (getHourCost ()) + DifferenceMinutes * (getHourCost ()/60) + DifferenceDays*(getHourCost ()*24);
                    return Price;
                } catch (ParseException e) {
                }
            }
        }
        return Price;
    }

}
