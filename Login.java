package GUI;

import Parking_System.Admin;
import Parking_System.User;

import  java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JLabel label_title = new JLabel("Parking Guidance System..");
    JRadioButton RadioButton_Admin = new JRadioButton("Administrator");
    JRadioButton RadioButton_User = new JRadioButton("User");
    ButtonGroup GroupRadioButton = new ButtonGroup();
    JLabel UserLabel = new JLabel("User Name :");
    JLabel PassLabel = new JLabel("Password:");
    JTextField UserTextFiled = new JTextField();
    JPasswordField PassTextFiled = new JPasswordField();
    JButton LoginButton = new JButton("Login");
    JButton BackButton = new JButton("Back");


    public Login() {
        LoginFrame ();

    }
    public void LoginFrame()
    {
        this.setTitle("Parking Guidance System-Login"); ///jframe
        this.setSize(950, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(230, 10);
        this.setLayout(null);


        panel.setSize(950, 700);
        panel.setLayout(null);
        panel.setBackground(Color.darkGray);
        this.add(panel);


        label_title.setFont(new Font("Arial", Font.ITALIC, 40));
        label_title.setBounds(200, 80, 550, 50);
        label_title.setForeground(Color.GRAY);
        panel.add(label_title);


        RadioButton_Admin.setBounds(200, 200, 250, 50);
        RadioButton_Admin.setBackground(Color.darkGray);
        RadioButton_Admin.setForeground(Color.lightGray);
        RadioButton_Admin.setFont(new Font("l2", Font.ITALIC, 20));

        RadioButton_User.setBounds(600, 200, 250, 50);
        RadioButton_User.setBackground(Color.darkGray);
        RadioButton_User.setForeground(Color.lightGray);
        RadioButton_User.setFont(new Font("l2", Font.ITALIC, 20));

        GroupRadioButton.add(RadioButton_Admin);
        GroupRadioButton.add(RadioButton_User);
        panel.add(RadioButton_Admin);
        panel.add(RadioButton_User);


        UserLabel.setBounds(200, 350, 150, 30);
        UserLabel.setForeground(Color.LIGHT_GRAY);
        UserLabel.setFont(new Font("l2", Font.ITALIC, 20));
        UserTextFiled.setBounds(400, 350, 350, 30);
        UserTextFiled.setBackground (Color.lightGray);

        PassLabel.setBounds(200, 400, 150, 30);
        PassLabel.setForeground(Color.LIGHT_GRAY);
        PassLabel.setFont(new Font("l2", Font.ITALIC, 20));
        PassTextFiled.setBounds(400, 400, 350, 30);
        PassTextFiled.setBackground (Color.lightGray);



        panel.add(UserLabel);
        panel.add(UserTextFiled);
        panel.add(PassLabel);
        panel.add(PassTextFiled);

        LoginButton.setBounds(200, 550, 250, 40);
        LoginButton.setBackground(Color.GRAY);
        LoginButton.setFont(new Font("Arial ", Font.BOLD, 18));
        BackButton.setBounds(520, 550, 250, 40);
        BackButton.setBackground(Color.GRAY);
        BackButton.setFont(new Font("Arial ", Font.BOLD, 18));
        panel.add(LoginButton);
        panel.add(BackButton);


        LoginButton.addActionListener(this);

        BackButton.addActionListener(this);
        this.setVisible(true);
    }



        @Override
        public void actionPerformed(ActionEvent e2) {
            Admin admin = new Admin ();
            User user = new User ();
            String s1, s2;
            s1 = UserTextFiled.getText ();
            s2 = PassTextFiled.getText ();

            if (e2.getSource () == LoginButton) {
                if (!s1.equals ("") && !s2.equals ("")) {
                    if (RadioButton_Admin.isSelected ()) {
                        if (admin.login (s1, s2)) {
                            JOptionPane.showMessageDialog (null, "Login successfully..!", "Success", JOptionPane.INFORMATION_MESSAGE);
                            this.setVisible (false);
                            Admin_Rights adminPage = new Admin_Rights ();
                        } else
                            JOptionPane.showMessageDialog (null, "Login not successful..!", "Failed", JOptionPane.ERROR_MESSAGE);
                    }
                   else if (RadioButton_User.isSelected ()) {
                        if (user.login (s1, s2)) {
                            JOptionPane.showMessageDialog (null, "Login successfully..!", "Success", JOptionPane.INFORMATION_MESSAGE);
                            this.setVisible (false);
                            User_Rights adminPage = new User_Rights ();

                        } else {
                            JOptionPane.showMessageDialog (null, "Login not successful..!", "Failed", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                   else
                        JOptionPane.showMessageDialog (null, "Please Choose Login Type..", "Failed", JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog (null,"Invalid input or Missing required Fields ... ! "
                            + " Please, complete them before submit ...!","Failed",JOptionPane.ERROR_MESSAGE);

            }
            if (e2.getSource() == BackButton) {
                this.setVisible(false);
                First_Frame x = new First_Frame();
            }
    }
}