package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class First_Frame extends JFrame implements ActionListener
{
    JButton admin_or_user = new JButton("Admin Or User");
    JButton customer = new JButton("Customer");
    JLabel parking_management_system = new JLabel("Parking Guidance System..");
    JLabel welcome_to_our_parking = new JLabel("Welcome To Our Parking..");
    JPanel panel = new JPanel();

    public First_Frame()
    {
        this.setTitle("Parking Guidance System"); ///jframe
        this.setSize(950, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(230, 10);
        this.setLayout(null);

        panel.setSize(950, 700);
        panel.setLayout(null);
        panel.setBackground(Color.darkGray);
        add(panel);


        parking_management_system.setFont(new Font("Arial ", Font.ITALIC, 40));
        parking_management_system.setBounds(200, 80, 550, 50);
        parking_management_system.setForeground(Color.GRAY);
        panel.add(parking_management_system);


        admin_or_user.setBounds(160, 300, 250, 40);
        admin_or_user.setBackground(Color.LIGHT_GRAY);
        admin_or_user.setFont(new Font("Arial ", Font.BOLD, 18));
        customer.setBounds(550, 300, 250, 40);
        customer.setBackground(Color.LIGHT_GRAY);
        customer.setFont(new Font("Arial ", Font.BOLD, 18));
        panel.add(admin_or_user);
        panel.add(customer);


        welcome_to_our_parking.setBounds(300, 500, 400, 40);
        welcome_to_our_parking.setForeground(Color.GRAY);
        welcome_to_our_parking.setFont(new Font("Arial", Font.ITALIC, 30));
        panel.add(welcome_to_our_parking);

        admin_or_user.addActionListener(this);
        customer.addActionListener (this);
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == admin_or_user) {
            this.setVisible(false);
            Login c = new Login();

            if (e.getSource() == customer) {

            }
        }
        else if(e.getSource () == customer)
        {
            this.setVisible (false);
            Entry_Or_Exit entry_or_exit = new Entry_Or_Exit ();
        }

    }
}





