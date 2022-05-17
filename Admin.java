package Parking_System;

import java.util.ArrayList;

public  class Admin implements FileProcessing {
  
    protected int SSN;
    protected String name,Telephone;
    protected String userName,Password;
    protected double Salary;
    
    private final String adminFileName = "Admins.txt";
    private ArrayList<Admin> Adm = new ArrayList<Admin>();

    FileManger fManger = new FileManger();
    Customers customer = new Customers ();
    User user;


    public Admin(){}
    public Admin (int SSN, String name, String telephone, String userName, String password, double salary) {
        this.SSN = SSN;
        this.name = name;
        Telephone = telephone;
        this.userName = userName;
        Password = password;
        Salary = salary;
    }

    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return Telephone;
    }
    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public int getSSN() {
        return SSN;
    }
    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }

    public double getSalary() {
        return Salary;
    }
    public void setSalary(double salary) {
        Salary = salary;
    }
    
    @Override
    public void loadFromFile(){
        Adm = (ArrayList<Admin>) (Object) fManger.read(adminFileName);
    }
    @Override
    public void commitToFile(){
        if(!Adm.isEmpty()) {
            fManger.write (Adm.get (0).getData (), adminFileName, false);
            for (int i = 1; i < Adm.size (); i++) {
                fManger.write (Adm.get (i).getData (), adminFileName, true);
            }
        }
        else
            fManger.write ("", adminFileName, false);
    }

    @Override
    public String toString () {
        return "Admin{" +
                "SSN=" + SSN +
                ", name='" + name + '\'' +
                ", Telephone='" + Telephone + '\'' +
                ", userName='" + userName + '\'' +
                ", Password='" + Password + '\'' +
                ", Salary=" + Salary +
                '}';
    }

    public  boolean login(String userName,String password)
    {
        loadFromFile();

        for(int i =0; i<Adm.size();i++) {
            if(Adm.get(i).getUserName().equals(userName) && Adm.get(i).getPassword().equals(password))
            {
                return  true;
            }
        }
        return false;
    }
    
    protected String getData(){
        return this.getSSN () + "~" + this.getname () + "~" + this.getUserName () + "~" + this.getPassword () +"~" + this.getTelephone () + "~" + this.getSalary ();
    }
    
    public boolean addAdmin(Admin A){
        loadFromFile ();
        if(!searchAdmin(A.getSSN())) {
            Adm.add (A);
            commitToFile ();
            return true;
        }
        return false;
    }
    
    private int getAdminIndex(int SSN){
        loadFromFile();
        for (int i = 0; i < Adm.size (); i++)
            if (Adm.get (i).getSSN () == SSN)
                return i;
        return -1;
    }
    
    public boolean searchAdmin(int SSN){
        int index = getAdminIndex(SSN);
        return index != -1;
    }
    
    public String displayAllAdmins(){
        loadFromFile();
        String s = "All Admins Data\n";
        for(Admin x: Adm)
        {
            s = s + x.toString () + "\n";
        }
        return s;
    }
    
    public boolean updateAdmin(int SSN,Admin x){
        loadFromFile();
        System.out.println ("Founddddddddddddd");

        if(searchAdmin(SSN)) {
            System.out.println ("Founddddddddddddd");

            int index = getAdminIndex(SSN);
            Adm.set(index, x);
            commitToFile();
            return true;
        }
        return false;
    }
    
    public boolean deleteAdmin(int SSN){
        loadFromFile();
        if(searchAdmin(SSN)) {
            int index = getAdminIndex(SSN);
            Adm.remove(index);
            commitToFile();
            return true;
        }
        return false;
    }
    
    public int getUserIndex(int SSN){

        user =new User();
        user. loadFromFile();
        for(int i=0; i < user.getUser().size(); i++)
            if(user.getUser().get(i).getSSN()==SSN)
                return i;
        return -1;
    }
    
    public boolean searchUser(int SSN){
        user =new User();
        user.loadFromFile();
        int index = getUserIndex(SSN);
        return index != -1;
    }
    
    public boolean addNewUser(User newUser)
    {
        newUser.loadFromFile ();
        if(!searchUser(newUser.getSSN())) 
        {
            newUser.getUser ().add (newUser);
            newUser.commitToFile ();
            return true;
        }
        return false;
    }
    public boolean addNewUser(int SSN,String name, String telephone, String userName, String password, double salary)
    {
        User U = new User (SSN,name, telephone, userName, password, salary);
        return addNewUser(U);
    }
    
    public boolean updateUser(int SSN,User x){
        x.loadFromFile ();
        if(searchUser(SSN)){
            int index = getUserIndex(SSN);
            x.getUser().set(index, x);
            x.commitToFile();
            return true;
        }
        return false;

    }
    
    public boolean deleteUser(int SSN){
        loadFromFile();
        if(searchUser(SSN)) {
            int index = getUserIndex(SSN);
            user.getUser().remove(index);
            user.commitToFile();
            return true;
        }
        return false;
    }

    public User getUserdata(int ssn)
    {
        user = new User ();
        user.loadFromFile ();
        if(searchUser (ssn))
        {
            int index = getUserIndex (ssn);
            return user.getUser ().get (index);
        }
        return null;
    }
    
    public ArrayList<User> Users_Details()
    {
        user = new User ();
        user.loadFromFile ();
        return user.getUser ();
    }

    public boolean addSpots(int id, char Desc)
    {
        Spots newOne = new Spots();
        return newOne.addSpot (id,Desc);
    }
    public boolean deleteSpot(int id)
    {
        Spots newOne = new Spots();
        return newOne.deleteSpot (id);
    }
    public ArrayList viewTotalSpots()
    {
        Spots spot = new Spots ();
        return spot.viewTotalSpots();
    }

    public  ArrayList<Customers> viewParkedCar()
    {
        customer.loadFromParkedCarFile ();
        return  customer.getParkedCustomers ();
    }
    
    public  ArrayList<Customers> viewInParking()
    {
        customer.loadFromFile ();
        return  customer.getCustomers ();
    }

}
