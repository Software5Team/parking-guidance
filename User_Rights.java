package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User_Rights extends JFrame implements ActionListener {
    JPanel panel =new JPanel();
    JLabel welcome_label =new JLabel("Welcome User..!");
    JButton logOut =new JButton("log out");
    JButton Add_Spot =new JButton("Add Spots");
    JButton Total_Spot =new JButton("Total Spot");
    JButton view_parked_cars =new JButton("View Parked Cars");

    JButton InParking =new JButton("In Parking");
    JButton deleteSpot =new JButton("Delete Spot");

    Font newFont =new Font("Arial",Font.BOLD,27);

    public User_Rights()
    {
        UserFrame ();
    }
    public void UserFrame()
    {
        this.setSize(950,700);
        this.setTitle("User Page..");
        this.setLocation(230,10);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        panel.setLayout(null);
        panel.setBounds(0,0,950,700);
        panel.setBackground(Color.DARK_GRAY);
        this.add(panel);

        welcome_label.setBounds(350,30,700,160);
        welcome_label.setFont(newFont);
        welcome_label.setForeground(Color.lightGray);
        panel.add(welcome_label);

        logOut.setBounds(834,0,100,30);
        logOut.setBackground(Color.lightGray);
        panel.add (logOut);

        Add_Spot.setBounds(300,250,150,30);
        Add_Spot.setBackground(Color.lightGray);
        panel.add (Add_Spot);

        Total_Spot.setBounds(500,250,150,30);
        Total_Spot.setBackground(Color.lightGray);
        panel.add (Total_Spot);

        view_parked_cars.setBounds(300,400,150,30);
        view_parked_cars.setBackground(Color.lightGray);
        panel.add (view_parked_cars);

  

        deleteSpot.setBounds(400,325,152,30);
        deleteSpot.setBackground(Color.lightGray);
        panel.add (deleteSpot);

        InParking.setBounds(400,475,150,30);
        InParking.setBackground(Color.lightGray);
        panel.add (InParking);

        logOut.addActionListener(this);
        Add_Spot.addActionListener(this);
        Total_Spot.addActionListener(this);

  
        view_parked_cars.addActionListener(this);
        deleteSpot.addActionListener(this);

        InParking.addActionListener (this);



        setVisible (true);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if(e.getSource()==logOut)
        {
            int ret = JOptionPane.showConfirmDialog(null,"Are You Sure..?","LogOut",JOptionPane.YES_NO_OPTION);
            if(ret == JOptionPane.YES_OPTION)
            {
                this.setVisible(false);
                Login login = new Login();
            }

        }
        else if (e.getSource() == Add_Spot)
        {
            this.setVisible(false);
            Spots_Rights_User view = new Spots_Rights_User ();

        }
        else if (e.getSource() == Total_Spot)
        {
            this.setVisible (false);
            Total_Spots_User totalspots = new Total_Spots_User ();
        }
        else if (e.getSource() == view_parked_cars)
        {
            this.setVisible (false);
            Parked_Cars_User parkedcarspage = new Parked_Cars_User ();

        }
        else if(e.getSource () == deleteSpot)
        {
            this.setVisible (false);
            delete_Spot_User delete_spot_user = new delete_Spot_User ();
        }
        else if(e.getSource () == InParking)
        {
            this.setVisible (false);
            In_Parking_User in_parking_user = new In_Parking_User ();
        }
    }
}
