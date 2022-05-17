package GUI;

import Parking_System.Admin;
import Parking_System.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_User extends JFrame implements ActionListener {

    JPanel panel = new JPanel ();

    JLabel namelabel = new JLabel ("Name :");
    JLabel ssnlabel = new JLabel ("SSN :");
    JLabel usernamelabel = new JLabel ("User Name :");
    JLabel passwordlabel = new JLabel ("Password :");
    JLabel telephonelabel = new JLabel ("Telephone :");
    JLabel salarylabel = new JLabel ("Salary :");

    JLabel adduserlabel = new JLabel ("Add User..");

    JTextField nametext = new JTextField ();
    JTextField ssntext = new JTextField ();
    JTextField usernametext = new JTextField ();
    JPasswordField passwordtext = new JPasswordField ();
    JTextField telephonetext = new JTextField ();
    JTextField salarytext = new JTextField ();

    JButton addUserbutton = new JButton ("Add");
    JButton backbutton = new JButton ("back");

    public Add_User()
    {
        addUserFrame ();
    }
    public void addUserFrame()
    {
        this.setSize(950,700);
        this.setTitle("Admin Page..Add User");
        this.setLocation(230,10);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        panel.setLayout(null);
        panel.setBounds(0,0,950,700);
        panel.setBackground(Color.DARK_GRAY);
        this.add(panel);

        adduserlabel.setBounds (370,20,250,40);
        adduserlabel.setForeground (Color.lightGray);
        adduserlabel.setFont (new Font("Arial",Font.ITALIC,40));
        panel.add (adduserlabel);

        namelabel.setBounds (200,100,250,30);
        namelabel.setForeground(Color.LIGHT_GRAY);
        namelabel.setFont(new Font("Arial", Font.ITALIC, 20));
        panel.add (namelabel);

        ssnlabel.setBounds (200,170,250,30);
        ssnlabel.setForeground(Color.LIGHT_GRAY);
        ssnlabel.setFont(new Font("Arial", Font.ITALIC, 20));
        panel.add (ssnlabel);

        usernamelabel.setBounds (200,240,250,30);
        usernamelabel.setForeground(Color.LIGHT_GRAY);
        usernamelabel.setFont(new Font("Arial", Font.ITALIC, 20));
        panel.add (usernamelabel);

        passwordlabel.setBounds (200,310,250,30);
        passwordlabel.setForeground(Color.LIGHT_GRAY);
        passwordlabel.setFont(new Font("Arial", Font.ITALIC, 20));
        panel.add (passwordlabel);

        telephonelabel.setBounds (200,380,250,30);
        telephonelabel.setForeground(Color.LIGHT_GRAY);
        telephonelabel.setFont(new Font("Arial", Font.ITALIC, 20));
        panel.add (telephonelabel);

        salarylabel.setBounds (200,450,250,30);
        salarylabel.setForeground(Color.LIGHT_GRAY);
        salarylabel.setFont(new Font("Arial", Font.ITALIC, 20));
        panel.add (salarylabel);

        nametext.setBounds (350,100,200,25);
        nametext.setBackground (Color.lightGray);
        panel.add (nametext);

        ssntext.setBounds (350,170,200,25);
        ssntext.setBackground (Color.lightGray);
        panel.add (ssntext);

        usernametext.setBounds (350,240,200,25);
        usernametext.setBackground (Color.lightGray);
        panel.add (usernametext);

        passwordtext.setBounds (350,310,200,25);
        passwordtext.setBackground (Color.lightGray);
        panel.add (passwordtext);

        telephonetext.setBounds (350,380,200,25);
        telephonetext.setBackground (Color.lightGray);
        panel.add (telephonetext);

        salarytext.setBounds (350,450,200,25);
        salarytext.setBackground (Color.lightGray);
        panel.add (salarytext);

        addUserbutton.setBounds(200, 550, 250, 40);
        addUserbutton.setBackground(Color.GRAY);
        addUserbutton.setFont(new Font("Arial ", Font.BOLD, 18));

        backbutton.setBounds(520, 550, 250, 40);
        backbutton.setBackground(Color.GRAY);
        backbutton.setFont(new Font("Arial ", Font.BOLD, 18));

        panel.add(addUserbutton);
        panel.add(backbutton);

        addUserbutton.addActionListener (this);
        backbutton.addActionListener (this);


        this.setVisible(true);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if(e.getSource ()  == addUserbutton)
        {
            String name = nametext.getText ();
            String username = usernametext.getText ();
            String password = passwordtext.getText ();
            String telephone = telephonetext.getText ();
            Admin admin = new Admin ();

            if(!name.equals ("") && !username.equals ("") && !password.equals ("") &&
                    !telephone.equals ("") &&telephone.matches ("[0-9]+") &&ssntext.getText ().matches ("[0-9]+")&&!
                    ssntext.getText ().equals ("") && salarytext.getText ().matches ("[0-9]+") && 
                    !salarytext.getText ().equals (""))
            {
                int ssn = Integer.parseInt (ssntext.getText ());
                double salary = Double.parseDouble (salarytext.getText ());
                if( admin.addNewUser (ssn,name,telephone,username,password,salary))
               {
                   JOptionPane.showMessageDialog (null,"User added Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                   nametext.setText ("");
                   usernametext.setText ("");
                   passwordtext.setText ("");
                    telephonetext.setText ("");
                   ssntext.setText ("");
                  salarytext.setText ("");
               }
               else
                   JOptionPane.showMessageDialog (null,"User already exist or invalid input","Failed",JOptionPane.ERROR_MESSAGE);


            }
            else
                JOptionPane.showMessageDialog (null,"Invalid input or Missing required Fields ... ! "
                        + " Please, complete them before submit ...!","Failed",JOptionPane.ERROR_MESSAGE);

        }
        else if(e.getSource () == backbutton)
        {
            this.setVisible (false);
            Admin_Rights adminPage = new Admin_Rights ();
        }
    }
}
