package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Entry_Or_Exit extends JFrame implements ActionListener
{
    JButton EntryButton = new JButton("Entry");
    JButton ExitButton = new JButton("Exit");
    JButton BackButton = new JButton("Back");
    JLabel parking_management_system = new JLabel("Parking Guidance System..");
    JLabel welcome_to_our_parking = new JLabel("Welcome To Our Parking..");
    JPanel panel = new JPanel();

    public Entry_Or_Exit()
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


        EntryButton.setBounds(160, 300, 250, 40);
        EntryButton.setBackground(Color.LIGHT_GRAY);
        EntryButton.setFont(new Font("Arial ", Font.BOLD, 18));

        ExitButton.setBounds(550, 300, 250, 40);
        ExitButton.setBackground(Color.LIGHT_GRAY);
        ExitButton.setFont(new Font("Arial ", Font.BOLD, 18));

        BackButton.setBounds(350, 390, 250, 40);
        BackButton.setBackground(Color.LIGHT_GRAY);
        BackButton.setFont(new Font("Arial ", Font.BOLD, 18));

        panel.add(EntryButton);
        panel.add(ExitButton);
        panel.add(BackButton);

        welcome_to_our_parking.setBounds(300, 500, 400, 40);
        welcome_to_our_parking.setForeground(Color.GRAY);
        welcome_to_our_parking.setFont(new Font("Arial", Font.ITALIC, 30));
        panel.add(welcome_to_our_parking);


        EntryButton.addActionListener(this);
        BackButton.addActionListener(this);
        ExitButton.addActionListener (this);
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==BackButton ) {
            this.setVisible(false);
            First_Frame first_framePage = new First_Frame ();
        }
        else if(e.getSource () == EntryButton)
        {
            this.setVisible (false);
            Customer_Entry_Frame EntryFrame = new Customer_Entry_Frame ();

        }
        else if(e.getSource () == ExitButton)
        {
            this.setVisible (false);
            Customer_Exit_Frame EntryFrame = new Customer_Exit_Frame ();
        }

    }
}





