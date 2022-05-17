package GUI;

import Parking_System.Admin;
import Parking_System.Customers;
import Parking_System.Operator;
import Parking_System.Spots;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Customer_Entry_Frame extends JFrame implements ActionListener {
    Date dNow = new Date( );
    SimpleDateFormat ft =  new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
    String reportdate=ft.format(dNow);

    JPanel panel =new JPanel();

    JLabel titlelabel =new JLabel("Parking Entry Management");
    JLabel freeSpotsLabel =new JLabel("Free Spots in Parking..choose one..!");
    JLabel namelabel =new JLabel("Name : ");
    JLabel mobilelabel = new JLabel("Mobile No : ");
    JLabel plateNOlabel = new JLabel("Plate Number : ");
    JLabel  vehicleNOlabel = new JLabel("Vehicle No : ");
    JLabel EntryTimelabel = new JLabel("Entry Time : ");

    JTextField nametext = new JTextField ();
    JTextField  mobiletext = new JTextField ();
    JTextField  plateNoText = new JTextField ();
    JTextField vehicletext = new JTextField ();
    JTextField  entrydatetext = new JTextField ();
    JButton EntryButton = new JButton ("Entry");
    JButton BackButton = new JButton ("Back");

    public Customer_Entry_Frame() {

        CustomerEntryFrame();
    }
    public void CustomerEntryFrame()
    {
        this.setSize(950, 700);
        this.setTitle("Customer Page..Entry");
        this.setResizable(false);
        this.setLocation(230, 10);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);

        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(null);

        titlelabel.setBounds(220, 20,500, 50);
        titlelabel.setForeground (Color.lightGray);
        titlelabel.setFont (new Font("Arial",Font.ITALIC,40));

        freeSpotsLabel.setBounds(550, 100,500, 50);
        freeSpotsLabel.setForeground (Color.lightGray);
        freeSpotsLabel.setFont (new Font("Arial",Font.ITALIC,20));

        namelabel.setBounds(100, 100,100, 50);
        namelabel.setForeground(Color.LIGHT_GRAY);
        namelabel.setFont(new Font("Arial", Font.ITALIC, 20));

        mobilelabel.setBounds(100, 180,130, 50);
        mobilelabel.setForeground(Color.LIGHT_GRAY);
        mobilelabel.setFont(new Font("Arial", Font.ITALIC, 20));

        vehicleNOlabel.setBounds(100, 260,130, 50);
        vehicleNOlabel.setForeground(Color.LIGHT_GRAY);
        vehicleNOlabel.setFont(new Font("Arial", Font.ITALIC, 20));

        plateNOlabel.setBounds(100, 340,130, 50);
        plateNOlabel.setForeground(Color.LIGHT_GRAY);
        plateNOlabel.setFont(new Font("Arial", Font.ITALIC, 20));

        EntryTimelabel.setBounds(100, 420,130, 50);
        EntryTimelabel.setForeground(Color.LIGHT_GRAY);
        EntryTimelabel.setFont(new Font("Arial", Font.ITALIC, 20));

        entrydatetext.setText(reportdate);

        nametext.setBounds(250, 110, 200, 30);
        nametext.setBackground (Color.lightGray);

        mobiletext.setBounds(250, 190, 200, 30);
        mobiletext.setBackground (Color.lightGray);

        vehicletext.setBounds(250, 270, 200, 30);
        vehicletext.setBackground (Color.lightGray);

        plateNoText.setBounds(250, 350, 200, 30);
        plateNoText.setBackground (Color.lightGray);

        entrydatetext.setBounds(250, 430, 200, 30);
        entrydatetext.setBackground (Color.lightGray);

        EntryButton.setBounds(70, 560, 170, 40);
        EntryButton.setBackground (Color.GRAY);
        EntryButton.setFont (new Font("Arial",Font.BOLD,18));

        BackButton.setBounds(320, 560, 170, 40);
        BackButton.setBackground (Color.GRAY);
        BackButton.setFont (new Font("Arial",Font.BOLD,18));


        panel.add(titlelabel);
        panel.add(freeSpotsLabel);
        panel.add(namelabel);
        panel.add(mobilelabel);
        panel.add(plateNOlabel);
        panel.add(vehicleNOlabel);
        panel.add(EntryTimelabel);
        panel.add(nametext);
        panel.add(mobiletext);
        panel.add(vehicletext);
        panel.add(plateNoText);
        panel.add(entrydatetext);
        panel.add(EntryButton);
        panel.add(BackButton);

        BackButton.addActionListener (this);
        EntryButton.addActionListener (this);
        {
            ArrayList<Spots> data;
             Operator operator = new Operator ();

            data = operator.getFreeSpots ();

            String[] column = {"Plate Number","Describation"};

            JTable tabel = new JTable ();

            DefaultTableModel tableModel = new DefaultTableModel (column,0);
            Object [] rowData = new Object[2];
            {
                rowData[0] = "\t\t\t                   ID";
                rowData[1] = "\t\t\t             Describation";
                tableModel.addRow (rowData);
            }
            for(int i = 0; i < data.size (); i++)
            {
                rowData[0] = data.get (i).getSpotId();
                rowData[1] = data.get (i).getDescription();
                tableModel.addRow (rowData);
            }
            tabel.setModel (tableModel);
            tabel.setBackground (Color.LIGHT_GRAY);
            this.setLocationRelativeTo (null);
            tabel.setBounds (550,150,300,450);

            panel.add (tabel);

        }
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==BackButton)
        {
            this.setVisible (false);
            Entry_Or_Exit entry_or_exit = new Entry_Or_Exit ();

        }
        else if(e.getSource () == EntryButton)
        {
            String name = nametext.getText ();
            String mobileNumber = mobiletext.getText ();
            String carNumber = vehicletext.getText ();

            if(!name.equals ("") &&name.matches ("[a-zA-Z]+")  && !mobileNumber.equals ("") &&
                    mobileNumber.matches ("[0-9]+") &&
                    !carNumber.equals ("") &&!plateNoText.getText ().equals ("")&&
                    plateNoText.getText ().matches ("[0-9]+") )
            {

                int plateNumber =Integer.parseInt (plateNoText.getText ());
                Customers customer = new Customers (carNumber,name,plateNumber,mobileNumber);

                String ticket = customer.printTicket ();
                JOptionPane.showMessageDialog (null,ticket,"Information",JOptionPane.INFORMATION_MESSAGE);

            }
            else
                JOptionPane.showMessageDialog (null,"Invalid input or Missing required Fields ... ! "
                        + " Please, complete them before submit ...!","Failed",JOptionPane.ERROR_MESSAGE);

        }
    }
}
