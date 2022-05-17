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

class Parked_Cars_User extends JFrame implements ActionListener {
    JButton BackButton  =  new JButton("Back");
    JPanel panel = new JPanel();
    JLabel headerLabel = new JLabel ("Parked Car..");

    public Parked_Cars_User () {

        Show_Table();
    }
    //getting data from
    public void Show_Table (){
        ArrayList<Customers> data;
        User user = new User ();

        data = user.viewParkedCar();

        String[] column = {"Entry ID","Customer Name","Plate Number","Car Id","Entry Date","Exit Date","Money"};

        JTable tabel = new JTable ();

        DefaultTableModel tableModel = new DefaultTableModel (column,0);
        setSize(950,700);

        setLocation(230,10);
        setTitle ("Admin Page-View Parked Car");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(0,0,950,700);
        add(panel);

        headerLabel.setBounds (320,20,250,40);
        headerLabel.setForeground (Color.lightGray);
        headerLabel.setFont (new Font("Arial",Font.ITALIC,40));
        panel.add (headerLabel);

        BackButton.setBounds(50, 600, 150, 40);
        BackButton.setBackground(Color.GRAY);
        BackButton.setFont(new Font("Arial ", Font.BOLD, 18));
        panel.add (BackButton);

        Object [] rowData = new Object[8];
        {
            rowData[0] = "Entry ID";
            rowData[1] = "Customer Name";
            rowData[2] = "Plate Number";
            rowData[3] = "Car Id";
            rowData[4] = "Entry Date";
            rowData[5] = "Exit Date";
            rowData[6] = "Money";
            tableModel.addRow (rowData);
        }
        for(int i = 0; i < data.size (); i++)
        {
            rowData[0] = data.get (i).getEntryId ();
            rowData[1] = data.get (i).getOwnerName ();
            rowData[2] = data.get (i).getPlateNumber ();
            rowData[3] = data.get (i).getCarNumber ();
            rowData[4] = data.get (i).getEntryDate ();
            rowData[5] = data.get (i).getExitDate ();
            rowData[6] = data.get (i).getPrice ();
            tableModel.addRow (rowData);
        }
        tabel.setModel (tableModel);
        tabel.setBackground (Color.LIGHT_GRAY);
        this.setLocationRelativeTo (null);
        tabel.setBounds (0,80,940,500);

        panel.add (tabel);
        BackButton.addActionListener (this);
        setVisible (true);
    }
    @Override
    public void actionPerformed (ActionEvent e) {
        if(e.getSource () == BackButton)
        {
            this.setVisible (false);
            User_Rights userPage = new User_Rights ();
        }
    }
}