package GUI;

import Parking_System.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class delete_Spot extends JFrame implements ActionListener {
    JPanel panel = new JPanel ();

    JLabel deleteSpotLabel = new JLabel ("Delete Spot..");
    JLabel spotID = new JLabel ("Spot ID :");
    JTextField spotId = new JTextField ();

    JButton deleteSpotButton = new JButton ("Delete");
    JButton backbutton = new JButton ("Back");

    public delete_Spot()
    {
        delete_SpotFrame ();
    }
    public void delete_SpotFrame()
    {
        this.setSize(950,700);
        this.setTitle("Admin Page..Delete Spot");
        this.setLocation(230,10);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        panel.setLayout(null);
        panel.setBounds(0,0,950,700);
        panel.setBackground(Color.DARK_GRAY);
        this.add(panel);

        deleteSpotLabel.setBounds (350,30,250,40);
        deleteSpotLabel.setForeground (Color.lightGray);
        deleteSpotLabel.setFont (new Font("Arial",Font.ITALIC,40));
        panel.add (deleteSpotLabel);

        spotID.setBounds (300,220,250,30);
        spotID.setForeground(Color.LIGHT_GRAY);
        spotID.setFont(new Font("Arial", Font.ITALIC, 20));
        panel.add (spotID);

        spotId.setBounds (420,222,200,25);
        spotId.setBackground (Color.lightGray);
        panel.add (spotId);

        deleteSpotButton.setBounds(180, 350, 250, 40);
        deleteSpotButton.setBackground(Color.GRAY);
        deleteSpotButton.setFont(new Font("Arial ", Font.BOLD, 18));
        panel.add(deleteSpotButton);

        backbutton.setBounds(500, 350, 250, 40);
        backbutton.setBackground(Color.GRAY);
        backbutton.setFont(new Font("Arial ", Font.BOLD, 18));
        panel.add(backbutton);

        deleteSpotButton.addActionListener (this);
        backbutton.addActionListener (this);

        setVisible (true);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if(e.getSource () == deleteSpotButton)
        {
            if(!spotId.getText ().equals ("") && spotId.getText ().matches ("[0-9]+"))
            {
                int spotID = Integer.parseInt (spotId.getText ());
                Admin admin = new Admin ();
                if(admin.deleteSpot (spotID))
                {
                    JOptionPane.showMessageDialog (null,"Spot deleted Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog (null,"Spot Not Found","Failed",JOptionPane.ERROR_MESSAGE);

            }
            else
                JOptionPane.showMessageDialog (null,"Invalid input or Missing required Fields ... ! "
                        + " Please, complete them before submit ...!","Failed",JOptionPane.ERROR_MESSAGE);

        }
        else if(e.getSource () == backbutton)
        {
            setVisible (false);
            Admin_Rights AdminPage = new Admin_Rights ();

        }
    }
}
