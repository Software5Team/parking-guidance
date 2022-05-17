package GUI;

import Parking_System.Admin;
import Parking_System.Spots;
import Parking_System.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spots_Rights_User extends JFrame implements ActionListener {

    JPanel panel =new JPanel();
    JLabel welcome_label =new JLabel("Welcome User..!");
    Font newFont =new Font("Arial",Font.BOLD,27);
    JLabel SpotId_label=new JLabel("Spot Id:");
    JLabel SpotDescription_label=new JLabel("Spot Description:");
    JTextField SpotId_text=new JTextField();
    JTextField SpotDescription_text=new JTextField();
    JButton addSpot =new JButton("Add Spots");
    JButton back =new JButton("Back");

    public Spots_Rights_User()
    {
        addSpot();
    }


    public void addSpot()
    {
        this.setSize(950,700);
        this.setTitle("Admin Page..Add Spot");
        this.setLocation(230,10);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        panel.setLayout(null);
        panel.setBounds(0,0,950,700);
        panel.setBackground(Color.DARK_GRAY);
        this.add(panel);

        welcome_label.setBounds(300,30,700,160);
        welcome_label.setFont(newFont);
        welcome_label.setForeground(Color.lightGray);
        panel.add(welcome_label);

        SpotId_label.setBounds(200,250,150,60);
        SpotId_label.setForeground(Color.lightGray);
        SpotId_label.setFont(newFont);
        panel.add(SpotId_label);

        SpotId_text.setBackground(Color.lightGray);
        SpotId_text.setBounds(450,266,170,25);
        panel.add(SpotId_text);

        SpotDescription_label.setBounds(200,330,280,60);
        SpotDescription_label.setForeground(Color.lightGray);
        SpotDescription_label.setFont(newFont);
        panel.add(SpotDescription_label);

        SpotDescription_text.setBackground(Color.lightGray);
        SpotDescription_text.setBounds(450,350,170,25);
        panel.add(SpotDescription_text);

        addSpot.setBounds(220,450,140,35);
        addSpot.setBackground(Color.lightGray);
        addSpot.setFont(new Font("Arial",Font.BOLD,18));
        panel.add(addSpot);

        back.setBounds(450,450,140,35);
        back.setBackground(Color.lightGray);
        back.setFont(new Font("Arial",Font.BOLD,18));
        panel.add(back);

        addSpot.addActionListener(this);
        back.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==addSpot)
        {
            if(!SpotId_text.getText ().equals ("") && SpotId_text.getText ().matches ("[0-9]+")&&
                    !SpotDescription_text.getText ().equals ("") &&
                    SpotDescription_text.getText ().matches ("[A-Z]+")) {
                int id = Integer.parseInt(SpotId_text.getText());
                char desc =SpotDescription_text.getText().charAt(0);
                User user = new User ();
                boolean statue = user.addSpots (id, desc);
                if (statue) {
                    JOptionPane.showMessageDialog (null, "Spot added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog (null, "Adding Spot failed", "Failed", JOptionPane.ERROR_MESSAGE);

                }
            }
            else
            {
                JOptionPane.showMessageDialog (null,"Invalid input or Missing required Fields ... ! "
                        + " Please, complete them before submit ...!","Failed",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.getSource() == back)
        {
            this.setVisible(false);

            User_Rights view = new User_Rights ();
        }
    }
}
