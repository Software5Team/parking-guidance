package Parking_System;

import java.util.ArrayList;

public class Spots implements FileProcessing{
    private int spotId;
    private char Description;
    private boolean statue;

    private final String spotFileName = "Spots.txt";
    FileManger fManger = new FileManger();
    ArrayList<Spots> spot = new ArrayList<Spots>();
    
    public Spots() {
    }
    public Spots(int spotId, char description, boolean statue) {
        this.spotId = spotId;
        this.Description = description;
        this.statue = statue;
    }

    public int getSpotId () {
        return spotId;
    }
    public void setSpotId (int spotId) {
        this.spotId = spotId;
    }

    public char getDescription () {
        return Description;
    }
    public void setDescription (char description) {
        Description = description;
    }

    public boolean isStatue () {
        return statue;
    }

    public void setStatue (boolean statue) {
        this.statue = statue;
    }
    
    @Override
    public String toString () {
        return "Spot{" +
                "spotId=" + spotId +
                ", Description=" + Description +
                ", statue=" + statue +
                '}';
    }

    @Override
    public void loadFromFile(){
        spot = (ArrayList<Spots>) (Object) fManger.read(spotFileName);
    }
    
    @Override
    public void commitToFile(){
        if(!spot.isEmpty())
        {
            fManger.write (spot.get (0).getData (), spotFileName, false);
            for (int i = 1; i < spot.size (); i++) {
                fManger.write (spot.get (i).getData (), spotFileName, true);
            }
        }
        else
            fManger.write ("", spotFileName, false);
    }

    public String getData(){
        return this.getSpotId () + "~" + this.getDescription () + "~" + this.isStatue () ;
    }

    public boolean addSpot(Spots S){
        if(!searchSpot (this.getSpotId ())) 
        {
            return fManger.write (S.getData (), spotFileName, true);
        }
        return false;
    }
    public boolean addSpot(int spotId,char Des)
    {
        Spots S = new Spots (spotId,Des,true);
        if(!searchSpot (spotId))
        {
            return fManger.write (S.getData (),spotFileName,true);
        }
        return false;
    }

    public int getSpotIndex(int spotId){
        loadFromFile();
        for (int i = 0; i < spot.size (); i++)
            if (spot.get (i).getSpotId () == spotId)
                return i;
        return -1;
    }

    public char getSpotDescription(ArrayList<Spots> Arr,int id) {
        char C;
        for (int i = 0; i < Arr.size (); i++) {
            if (Arr.get (i).getSpotId () == id){
                return Arr.get (i).getDescription ();
            }
        }
        return 'Z';
        }

    public boolean searchSpot(int spotId){
        int index = getSpotIndex (spotId);
        return index != -1;
    }

    public boolean updateSpot(int spotId,Spots X)
    {
        loadFromFile();
        if(searchSpot (spotId)) {
            int index = getSpotIndex (spotId);
            spot.set(index, X);
            commitToFile();
            return true;
        }
        return false;
    }

    public boolean deleteSpot(int spotId){
        loadFromFile();
        if(searchSpot (spotId)) {
            int index = getSpotIndex (spotId);
            spot.remove(index);
            commitToFile();
            return true;
        }
        return false;
    }

    public boolean setStatue(int spotId,boolean statue)
    {
        loadFromFile();
        if(searchSpot (spotId)) {
            int index = getSpotIndex (spotId);
            spot.get (index).setStatue (statue);
            commitToFile();
            return true;
        }
        return false;
    }

    public ArrayList<Spots> viewfreeSpots()
    {
        ArrayList<Spots>freeSpots = new ArrayList<Spots> ();
        loadFromFile ();
        for(int i=0; i < spot.size (); i++)
        {
            if(spot.get (i).isStatue ())
            {
                freeSpots.add (spot.get (i));
            }
        }
        return freeSpots;
    }
    
    public String retFreeSpots()
    {
        ArrayList<Spots> retSpots = viewfreeSpots ();
        String ret = "No Free Spots\n";
        for(int i = 0; i < retSpots.size (); i++)
        {
            ret = " Free Spots\n";
            ret = ret + retSpots.get (i).toString () + "\n";
        }
        return ret;
    }

    public ArrayList<Spots> viewbusySpot()
    {
        ArrayList<Spots> busySpot = new ArrayList<Spots> ();
        loadFromFile();
        for(int i=0; i < spot.size (); i++)
        {
            if(!spot.get (i).isStatue ())
            {
                busySpot.add (spot.get (i));
            }
        }
        return busySpot;
    }
    
    public String retBusySpots()
    {
        ArrayList<Spots> retSpots = viewbusySpot ();
        String ret = "No Busy Spot\n";
        for(int i = 0; i < retSpots.size (); i++)
        {
            ret = "Busy Spot\n";
            ret = ret + retSpots.get (i).toString () + "\n";
        }
        return ret;
    }
    
    public String retTotalSpots()
    {
        ArrayList<Spots> retTotalSpots = viewTotalSpots ();
        String ret = "All Spots\n";
        for(int i = 0; i < retTotalSpots.size (); i++)
        {
            ret = ret + retTotalSpots.get (i).toString () + "\n";
        }
        return ret;
    }
    
    public int countTotalSpots() {
        loadFromFile();
        return spot.size();
    }
    
    public ArrayList<Spots> viewTotalSpots() {
        loadFromFile();
        return spot;
    }
    
    public String displayAllSpots(){
        loadFromFile();
        String s = "All Spots Data\n";
        for(Spots x: spot){
            s = s + x.toString () + "\n";
        }
        return s;
    }

}