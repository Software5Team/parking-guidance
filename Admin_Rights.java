package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_Rights extends JFrame implements ActionListener {
    JPanel panel =new JPanel();
    JLabel welcome_label =new JLabel("Welcome Admin..!");
    JButton logOut =new JButton("log out");
    JButton Add_Spot =new JButton("Add Spots");
    JButton Total_Spot =new JButton("Total Spot");
    JButton add_User =new JButton("Add user");
    JButton update_user =new JButton("Update User");
    JButton delete_user =new JButton("Delete User");
    JButton view_parked_cars =new JButton("View Parked Cars");
    JButton view_shift_reports =new JButton("View Shift Reports");
    JButton deleteSpot =new JButton("Delete Spot");
    JButton InParking =new JButton("In Parking");
    JButton userdetailsButton =new JButton("User Details");

    Font newFont =new Font("Arial",Font.BOLD,27);
    public Admin_Rights()
    {
        AdminGui();
    }
    public void AdminGui()
    {
        this.setSize(950,700);
        this.setTitle("Admin Page..");
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

        Add_Spot.setBounds(300,250,150,30);
        Add_Spot.setBackground(Color.lightGray);

        Total_Spot.setBounds(500,250,150,30);
        Total_Spot.setBackground(Color.lightGray);

        deleteSpot.setBounds(400,325,152,30);
        deleteSpot.setBackground(Color.lightGray);

        add_User.setBounds(200,400,150,30);
        add_User.setBackground(Color.lightGray);

        update_user.setBounds(400,400,150,30);
        update_user.setBackground(Color.lightGray);

        delete_user.setBounds(600,400,150,30);
        delete_user.setBackground(Color.lightGray);

        userdetailsButton.setBounds(400,475,150,30);
        userdetailsButton.setBackground(Color.lightGray);

        view_parked_cars.setBounds(300,550,150,30);
        view_parked_cars.setBackground(Color.lightGray);
        
        InParking.setBounds(400,625,150,30);
        InParking.setBackground(Color.lightGray);


        panel.add(logOut);
        panel.add(Add_Spot);
        panel.add(Total_Spot);
        panel.add(add_User);
        panel.add(update_user);
        panel.add(delete_user);
        panel.add (deleteSpot);
        panel.add (InParking);
        panel.add(view_parked_cars);
        panel.add(userdetailsButton);

        logOut.addActionListener(this);
        Add_Spot.addActionListener(this);
        Total_Spot.addActionListener(this);
        add_User.addActionListener(this);
        update_user.addActionListener(this);
        delete_user.addActionListener(this);
        view_parked_cars.addActionListener(this);
        deleteSpot.addActionListener (this);
        InParking.addActionListener (this);
        userdetailsButton.addActionListener (this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==logOut)
        {
            int ret = JOptionPane.showConfirmDialog(null,"Are You Sure..?","LogOut",JOptionPane.YES_NO_OPTION);
            if(ret == JOptionPane.YES_OPTION)
            {
                this.setVisible(false);
                Login login = new Login();
            }
            else
            {

            }
        }
        else if (e.getSource() == Add_Spot)
        {
            this.setVisible(false);
            Spots_Rights view = new Spots_Rights();

        }
        else if (e.getSource() == Total_Spot)
        {
            if(e.getSource()==Total_Spot)
            {
                this.setVisible(false);
                Total_Spots_Admin spot =new Total_Spots_Admin();
            }
        }
        else if (e.getSource() == add_User)
        {
            this.setVisible (false);
            Add_User add_userPage = new Add_User ();

        }
        else if (e.getSource() == update_user)
        {
            this.setVisible (false);
            Update_User delete_userPage = new Update_User ();
        }
        else if (e.getSource() == delete_user)
        {
            this.setVisible (false);
            delete_User delete_userPage = new delete_User ();

        }
        else if(e.getSource () == deleteSpot)
        {
            this.setVisible (false);
            delete_Spot deleSpotPage = new delete_Spot ();

        }
        else if(e.getSource () == InParking)
        {
            this.setVisible (false);
            In_Parking inParkingFrame = new In_Parking ();
        }
        else if (e.getSource() == view_parked_cars)
        {
            this.setVisible (false);
            Parked_Cars_Admin parkedcarspage = new Parked_Cars_Admin ();

        }
        else if(e.getSource () == userdetailsButton)
        {
                this.setVisible (false);
                User_Details_Frame user_details_frame = new User_Details_Frame ();
        }

    }
}

