package Parking_System;

import java.util.ArrayList;
public class User extends Admin{
    
    private final String UserFileName = "Users.txt";
    
    public ArrayList<User> user = new ArrayList<User>();
    
    public User () {
    }
    public User (int SSN, String name, String telephone, String userName, String password, double salary) {
        super (SSN, name, telephone, userName, password, salary);
    }
    
    public String getUserFileName() {
        return UserFileName;
    }
    
    public ArrayList<User> getUser() {
        return user;
    }
    
    public void loadFromFile(){
        user = (ArrayList<User>) (Object) fManger.read(UserFileName);//just read all data from the file
    }
    public void commitToFile(){
         
        if(user.size () != 0) {
            fManger.write (user.get (0).getData (), UserFileName, false);
            for (int i = 1; i < user.size (); i++) {
                fManger.write (user.get (i).getData (), UserFileName, true);
            }
        }
        else
            fManger.write ("" ,UserFileName, false);
    }
    
    @Override
    public boolean login (String userName, String password)
    {
        loadFromFile();
        for (int i = 0; i < user.size (); i++) {
            if (user.get (i).getUserName ().equals (userName) && user.get (i).getPassword ().equals (password)) {
                return true;
            }
        }
        return false;
    }
    
    public String displayAllUser(){
        loadFromFile();
        String s = "All Users Data\n";
        for(Admin x: user){
            s = s + x.toString () + "\n";
        }
        return s;
    }

    @Override
    public String toString() {
        return "User{" +
                "SSN=" + SSN +
                ", name='" + name + '\'' +
                ", Telephone='" + Telephone + '\'' +
                ", userName='" + userName + '\'' +
                ", Password='" + Password + '\'' +
                ", Salary=" + Salary +
                '}';
    }
}