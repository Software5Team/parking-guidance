package GUI;

import Parking_System.Customers;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.text.*;
import java.util.*;
public class Customer_Exit_Frame extends JFrame implements ActionListener {
    Date dNow = new Date( );
    SimpleDateFormat ft =new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
    String reportdate=ft.format(dNow);

    JPanel panel =new JPanel();
    JLabel titlelabel, vehiclenolabel, exitTimeLabel;
    JTextField ticketIDText, exitTimeText;
    JButton ExitButton, BackButton;
    public Customer_Exit_Frame ()
    {
        this.setSize(950, 700);
        this.setResizable(false);
        this.setLocation(230, 10);
        setTitle ("Customer Page..Exit");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);

        panel.setBackground(Color.darkGray);
        panel.setLayout(null);

        titlelabel =new JLabel("Parking Exit Management");
        titlelabel.setBounds(210, 20,500, 50);
        titlelabel.setForeground(Color.LIGHT_GRAY);
        titlelabel.setFont(new Font("Arial", Font.ITALIC, 40));

        vehiclenolabel =new JLabel("Ticket ID : ");
        vehiclenolabel.setBounds(200, 110,130, 50);
        vehiclenolabel.setForeground(Color.LIGHT_GRAY);
        vehiclenolabel.setFont(new Font("Arial", Font.ITALIC, 20));

        exitTimeLabel =new JLabel("Exit Time : ");
        exitTimeLabel.setBounds(200, 200,130, 50);
        exitTimeLabel.setForeground(Color.LIGHT_GRAY);
        exitTimeLabel.setFont(new Font("Arial", Font.ITALIC, 20));


        ticketIDText=new JTextField();
        exitTimeText =new JTextField();
        exitTimeText.setText(reportdate);



        ticketIDText.setBounds(450, 120, 200, 30);
        ticketIDText.setBackground(Color.lightGray);
        exitTimeText.setBounds(450, 210, 200, 30);
        exitTimeText.setBackground(Color.lightGray);

        ExitButton =new JButton("EXIT");
        ExitButton.setBounds(220, 350, 170, 40);
        ExitButton.setBackground(Color.lightGray);
        ExitButton.setFont (new Font("Arial",Font.BOLD,18));

        BackButton =new JButton("Back");
        BackButton.setBounds(450, 350, 170, 40);
        BackButton.setBackground(Color.lightGray);
        BackButton.setFont (new Font("Arial",Font.BOLD,18));

        panel.add(ticketIDText);
        panel.add(exitTimeText);
        panel.add(titlelabel);
        panel.add(vehiclenolabel);
        panel.add(exitTimeLabel);
        panel.add(ExitButton);
        panel.add(BackButton);

        BackButton.addActionListener (this);
        ExitButton.addActionListener (this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource () == BackButton)
        {
            this.setVisible (false);
            Entry_Or_Exit entry_or_exit = new Entry_Or_Exit ();
        }
        else if(e.getSource () == ExitButton)
        {
            if(!ticketIDText.getText ().equals ("") && ticketIDText.getText ().matches ("[0-9]+"))
            {
                int ticket_id = Integer.parseInt (ticketIDText.getText ());

                Customers customer = new Customers () ;
                customer = customer.getCustomerData (ticket_id);
                if(customer != null && customer.searchCustomer (ticket_id)) {
                    double Price = customer.Pay (ticket_id);
                    String EntryTime = customer.getEntryDate ();
                    String ExitTime = customer.getExitDate ();
                    String name = customer.getOwnerName ();
                    String VehicleNo = customer.getCarNumber ();
                    JOptionPane.showMessageDialog (null, "Name : "+name+"\nVehicle No. : "+VehicleNo+"\nEntry Date : " + 
                            EntryTime + "\nExit Date: " + ExitTime + "\nPrice: " + Price + "\nGoodBye..!");
                }
                else
                    JOptionPane.showMessageDialog (null,"NOT EXIST OR Invalid ticket id","Failed",JOptionPane.ERROR_MESSAGE);

            }
            else
                JOptionPane.showMessageDialog (null,"Invalid input or Missing required Fields ... ! "
                        + " Please, complete them before submit ...!","Failed",JOptionPane.ERROR_MESSAGE);

        }
    }
}
