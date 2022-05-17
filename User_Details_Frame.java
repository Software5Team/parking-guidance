package GUI;

import Parking_System.Admin;
import Parking_System.Customers;
import Parking_System.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class User_Details_Frame extends JFrame implements ActionListener {
    JButton BackButton  =  new JButton("Back");
    JPanel panel = new JPanel();
    JLabel headerLabel = new JLabel ("User Details..");

    public User_Details_Frame () {

        Show_Table();
    }

    public void Show_Table (){
        ArrayList<User> data;
        Admin admin = new Admin();

        data = admin.Users_Details ();

        String[] column = {"User SSN","Name","User Name","Password","Salary","Contact"};
        JTable table = new JTable ();

        DefaultTableModel tableModel = new DefaultTableModel (column,0);
        setSize(950,700);

        setLocation(230,10);
        setTitle ("Admin Page-View User Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(0,0,950,700);
        add(panel);

        headerLabel.setBounds (320,20,350,35);
        headerLabel.setForeground (Color.lightGray);
        headerLabel.setFont (new Font("Arial",Font.ITALIC,35));
        panel.add (headerLabel);

        BackButton.setBounds(50, 600, 150, 40);
        BackButton.setBackground(Color.GRAY);
        BackButton.setFont(new Font("Arial ", Font.BOLD, 18));
        panel.add (BackButton);

        Object [] rowData = new Object[6];
        {
            rowData[0] = "User SSN";
            rowData[1] = "Name";
            rowData[2] = "User Name";
            rowData[3] = "Password";
            rowData[4] = "Salary";
            rowData[5] = "Contact";
            tableModel.addRow (rowData);
        }
        for(int i = 0; i < data.size (); i++)
        {
            rowData[0] = data.get (i).getSSN ();
            rowData[1] = data.get (i).getname ();
            rowData[2] = data.get (i).getUserName ();
            rowData[3] = data.get (i).getPassword ();
            rowData[4] = data.get (i).getSalary ();
            rowData[5] = data.get (i).getTelephone ();
            tableModel.addRow (rowData);
        }
        table.setModel (tableModel);
        table.setBackground (Color.LIGHT_GRAY);
        this.setLocationRelativeTo (null);
        table.setBounds (0,80,940,500);

        panel.add (table);
        BackButton.addActionListener (this);
        setVisible (true);
    }
    @Override
    public void actionPerformed (ActionEvent e) {
        if(e.getSource () == BackButton)
        {
            this.setVisible (false);
            Admin_Rights adminPAge = new Admin_Rights ();
        }
    }
}