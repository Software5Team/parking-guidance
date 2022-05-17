package GUI;

import Parking_System.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class delete_User extends JFrame implements ActionListener {
    JPanel panel = new JPanel ();

    JLabel deleteUserlabel = new JLabel ("Delete User..");
    JLabel ssnlabel = new JLabel ("User SSN :");
    JTextField ssntext = new JTextField ();

    JButton deleteUserbutton = new JButton ("Delete");
    JButton backbutton = new JButton ("Back");

    public delete_User()
    {
        deleteUserFrame ();
    }
    public void deleteUserFrame()
    {
        this.setSize(950,700);
        this.setTitle("Admin Page..Delete User");
        this.setLocation(230,10);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        panel.setLayout(null);
        panel.setBounds(0,0,950,700);
        panel.setBackground(Color.DARK_GRAY);
        this.add(panel);

        deleteUserlabel.setBounds (350,30,250,40);
        deleteUserlabel.setForeground (Color.lightGray);
        deleteUserlabel.setFont (new Font("Arial",Font.ITALIC,40));
        panel.add (deleteUserlabel);

        ssnlabel.setBounds (300,220,250,30);
        ssnlabel.setForeground(Color.LIGHT_GRAY);
        ssnlabel.setFont(new Font("Arial", Font.ITALIC, 20));
        panel.add (ssnlabel);

        ssntext.setBounds (420,222,200,25);
        ssntext.setBackground (Color.lightGray);
        panel.add (ssntext);

        deleteUserbutton.setBounds(180, 350, 250, 40);
        deleteUserbutton.setBackground(Color.GRAY);
        deleteUserbutton.setFont(new Font("Arial ", Font.BOLD, 18));
        panel.add(deleteUserbutton);

        backbutton.setBounds(500, 350, 250, 40);
        backbutton.setBackground(Color.GRAY);
        backbutton.setFont(new Font("Arial ", Font.BOLD, 18));
        panel.add(backbutton);

        deleteUserbutton.addActionListener (this);
        backbutton.addActionListener (this);

        setVisible (true);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if(e.getSource () == deleteUserbutton)
        {
            if(!ssntext.getText ().equals ("") && ssntext.getText ().matches ("[0-9]+"))
            {
                int ssn = Integer.parseInt (ssntext.getText ());
                Admin admin = new Admin ();
                if(admin.deleteUser (ssn))
                {
                    JOptionPane.showMessageDialog (null,"User deleted Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog (null,"User Not Found","Failed",JOptionPane.ERROR_MESSAGE);

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
