package GUI;

import Parking_System.Admin;
import Parking_System.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Update_User extends JFrame implements ActionListener {

    JPanel panel = new JPanel ();

    JLabel updateuserlabel = new JLabel ("Update User..");
    JLabel oldInfolabel = new JLabel ("Old Information..");
    JLabel newInfolabel = new JLabel ("New Information..");

    JLabel user_SSNlabel = new JLabel ("User SSN : ");
    JTextField userSSntext = new JTextField ();

    JLabel oldnamelabel = new JLabel ("Name :");
    JLabel oldusernamelabel = new JLabel ("User Name :");
    JLabel oldpasswordlabel = new JLabel ("Password :");
    JLabel oldtelephonelabel = new JLabel ("Telephone :");
    JLabel oldsalarylabel = new JLabel ("Salary :");


    JTextField oldnametext = new JTextField ();
    JTextField oldusernametext = new JTextField ();
    JTextField oldpasswordtext = new JTextField ();
    JTextField oldtelephonetext = new JTextField ();
    JTextField oldsalarytext = new JTextField ();

    //new
    JLabel newnamelabel = new JLabel ("Name :");
    JLabel newusernamelabel = new JLabel ("User Name :");
    JLabel newpasswordlabel = new JLabel ("Password :");
    JLabel newtelephonelabel = new JLabel ("Telephone :");
    JLabel newsalarylabel = new JLabel ("Salary :");


    JTextField newnametext = new JTextField ();
    JTextField newusernametext = new JTextField ();
    JTextField newpasswordtext = new JTextField ();
    JTextField newtelephonetext = new JTextField ();
    JTextField newsalarytext = new JTextField ();

    JButton getdataButton = new JButton ("Get Data");
    JButton updatebutton = new JButton ("Update ");
    JButton backbutton = new JButton ("back");

    public Update_User () {
        updateUSerFrame ();
    }

    public void updateUSerFrame () {
        this.setSize (950, 700);
        this.setTitle ("Admin Page..Update User");
        this.setLocation (230, 10);
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.setResizable (false);

        panel.setLayout (null);
        panel.setBounds (0, 0, 950, 700);
        panel.setBackground (Color.DARK_GRAY);
        this.add (panel);

        updateuserlabel.setBounds (330, 20, 250, 40);
        updateuserlabel.setForeground (Color.lightGray);
        updateuserlabel.setFont (new Font ("Arial", Font.ITALIC, 40));
        panel.add (updateuserlabel);

        user_SSNlabel.setBounds (170, 80, 250, 30);
        user_SSNlabel.setForeground (Color.lightGray);
        user_SSNlabel.setFont (new Font ("Arial", Font.ITALIC, 20));
        panel.add (user_SSNlabel);

        userSSntext.setBounds (320, 80, 200, 25);
        userSSntext.setBackground (Color.lightGray);
        panel.add (userSSntext);

        getdataButton.setBounds (570, 80, 200, 25);
        getdataButton.setBackground (Color.GRAY);
        getdataButton.setFont (new Font ("Arial ", Font.BOLD, 15));
        panel.add (getdataButton);

        oldInfolabel.setBounds (130, 130, 250, 40);
        oldInfolabel.setForeground (Color.pink);
        oldInfolabel.setFont (new Font ("Arial", Font.ITALIC, 25));
        panel.add (oldInfolabel);

        newInfolabel.setBounds (580, 130, 250, 40);
        newInfolabel.setForeground (Color.PINK);
        newInfolabel.setFont (new Font ("Arial", Font.ITALIC, 25));
        panel.add (newInfolabel);



        oldnamelabel.setBounds (60, 200, 250, 30);
        oldnamelabel.setForeground (Color.LIGHT_GRAY);
        oldnamelabel.setFont (new Font ("Arial", Font.ITALIC, 20));
        panel.add (oldnamelabel);

        oldusernamelabel.setBounds (60, 270, 250, 30);
        oldusernamelabel.setForeground (Color.LIGHT_GRAY);
        oldusernamelabel.setFont (new Font ("Arial", Font.ITALIC, 20));
        panel.add (oldusernamelabel);

        oldpasswordlabel.setBounds (60, 340, 250, 30);
        oldpasswordlabel.setForeground (Color.LIGHT_GRAY);
        oldpasswordlabel.setFont (new Font ("Arial", Font.ITALIC, 20));
        panel.add (oldpasswordlabel);

        oldtelephonelabel.setBounds (60, 410, 250, 30);
        oldtelephonelabel.setForeground (Color.LIGHT_GRAY);
        oldtelephonelabel.setFont (new Font ("Arial", Font.ITALIC, 20));
        panel.add (oldtelephonelabel);

        oldsalarylabel.setBounds (60, 480, 250, 30);
        oldsalarylabel.setForeground (Color.LIGHT_GRAY);
        oldsalarylabel.setFont (new Font ("Arial", Font.ITALIC, 20));
        panel.add (oldsalarylabel);

        oldnametext.setBounds (210, 200, 200, 25);
        oldnametext.setBackground (Color.lightGray);
        panel.add (oldnametext);

        oldusernametext.setBounds (210, 270, 200, 25);
        oldusernametext.setBackground (Color.lightGray);
        panel.add (oldusernametext);

        oldpasswordtext.setBounds (210, 340, 200, 25);
        oldpasswordtext.setBackground (Color.lightGray);
        panel.add (oldpasswordtext);

        oldtelephonetext.setBounds (210, 410, 200, 25);
        oldtelephonetext.setBackground (Color.lightGray);
        panel.add (oldtelephonetext);

        oldsalarytext.setBounds (210, 480, 200, 25);
        oldsalarytext.setBackground (Color.lightGray);
        panel.add (oldsalarytext);



        newnamelabel.setBounds (500, 200, 250, 30);
        newnamelabel.setForeground (Color.LIGHT_GRAY);
        newnamelabel.setFont (new Font ("Arial", Font.ITALIC, 20));
        panel.add (newnamelabel);

        newusernamelabel.setBounds (500, 270, 250, 30);
        newusernamelabel.setForeground (Color.LIGHT_GRAY);
        newusernamelabel.setFont (new Font ("Arial", Font.ITALIC, 20));
        panel.add (newusernamelabel);

        newpasswordlabel.setBounds (500, 340, 250, 30);
        newpasswordlabel.setForeground (Color.LIGHT_GRAY);
        newpasswordlabel.setFont (new Font ("Arial", Font.ITALIC, 20));
        panel.add (newpasswordlabel);

        newtelephonelabel.setBounds (500, 410, 250, 30);
        newtelephonelabel.setForeground (Color.LIGHT_GRAY);
        newtelephonelabel.setFont (new Font ("Arial", Font.ITALIC, 20));
        panel.add (newtelephonelabel);

        newsalarylabel.setBounds (500, 480, 250, 30);
        newsalarylabel.setForeground (Color.LIGHT_GRAY);
        newsalarylabel.setFont (new Font ("Arial", Font.ITALIC, 20));
        panel.add (newsalarylabel);

        newnametext.setBounds (650, 200, 200, 25);
        newnametext.setBackground (Color.lightGray);
        panel.add (newnametext);

        newusernametext.setBounds (650, 270, 200, 25);
        newusernametext.setBackground (Color.lightGray);
        panel.add (newusernametext);

        newpasswordtext.setBounds (650, 340, 200, 25);
        newpasswordtext.setBackground (Color.lightGray);
        panel.add (newpasswordtext);

        newtelephonetext.setBounds (650, 410, 200, 25);
        newtelephonetext.setBackground (Color.lightGray);
        panel.add (newtelephonetext);

        newsalarytext.setBounds (650, 480, 200, 25);
        newsalarytext.setBackground (Color.lightGray);
        panel.add (newsalarytext);


        updatebutton.setBounds (180, 580, 250, 40);
        updatebutton.setBackground (Color.GRAY);
        updatebutton.setFont (new Font ("Arial ", Font.BOLD, 18));

        backbutton.setBounds (520, 580, 250, 40);
        backbutton.setBackground (Color.GRAY);
        backbutton.setFont (new Font ("Arial ", Font.BOLD, 18));
        panel.add (updatebutton);
        panel.add (backbutton);

        getdataButton.addActionListener (this);
        updatebutton.addActionListener (this);
        backbutton.addActionListener (this);


        setVisible (true);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource () == getdataButton) {
            if (!userSSntext.getText ().equals ("") && userSSntext.getText ().matches ("[0-9]+")) {
                int ssn = Integer.parseInt (userSSntext.getText ());
                Admin admin = new Admin ();
                User user = new User ();
                user = admin.getUserdata (ssn);
                if (user != null) {
                    oldnametext.setText (user.getname ());
                    oldusernametext.setText (user.getUserName ());
                    oldpasswordtext.setText (user.getPassword ());
                    oldtelephonetext.setText (user.getTelephone ());
                    oldsalarytext.setText (String.valueOf (user.getSalary ()));

                } else
                    JOptionPane.showMessageDialog (null, "User Not Found", "Faild", JOptionPane.ERROR_MESSAGE);
            } else
                JOptionPane.showMessageDialog (null, "Invalid input or Missing required Fields ... ! "
                        + " Please, complete them before submit ...!", "Failed", JOptionPane.ERROR_MESSAGE);

        } else if (e.getSource () == updatebutton) {
            String name = newnametext.getText ();
            String username = newusernametext.getText ();
            String password = newpasswordtext.getText ();
            String telephone = newtelephonetext.getText ();
            int ssn = Integer.parseInt (userSSntext.getText ());
            if (!name.equals ("") && !username.equals ("") && !password.equals ("") && !telephone.equals ("") && telephone.matches ("[0-9]+") && newtelephonetext.getText ().matches ("[0-9]+") && !newsalarytext.getText ().equals ("")) {
                Admin admin = new Admin ();
                double salary = Double.parseDouble (newsalarytext.getText ());
                User user = new User (ssn, name, telephone, username, password, salary);
                if (admin.updateUser (ssn, user)) {
                    JOptionPane.showMessageDialog (null, "User Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else
                    JOptionPane.showMessageDialog (null, "Error..!", "Failed", JOptionPane.ERROR_MESSAGE);

            } else
                JOptionPane.showMessageDialog (null, "Invalid input or Missing required Fields ... !  "
                        + "Please, complete them before submit ...!", "Failed", JOptionPane.ERROR_MESSAGE);

        }
        else if(e.getSource () == backbutton)
        {
            setVisible (false);
            Admin_Rights adminPage = new Admin_Rights ();
        }
    }
}
