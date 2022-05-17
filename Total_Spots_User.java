package GUI;

import Parking_System.Admin;
import Parking_System.Spots;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Total_Spots_User extends JFrame implements ActionListener {
    JButton BackButton  =  new JButton("Back");
    JPanel panel = new JPanel();
    JLabel headerLabel = new JLabel ("Total Spots..");

    public Total_Spots_User () {

        Show_Table();
    }

    public void Show_Table (){
        ArrayList<Spots> data;
        Admin admin = new Admin ();

        data = admin.viewTotalSpots();

        String[] column = {" ID","Describation","Statue"};

        JTable tabel = new JTable ();

        DefaultTableModel tableModel = new DefaultTableModel (column,0);
        setSize(950,700);

        setLocation(530,40);
        setTitle ("Total Spots");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(0,0,950,700);
        add(panel);

        headerLabel.setBounds (320,20,250,40);
        headerLabel.setForeground (Color.lightGray);
        headerLabel.setFont (new Font("Arial",Font.ITALIC,40));
        panel.add (headerLabel);

        BackButton.setBounds(50, 600, 150, 40);
        BackButton.setBackground(Color.GRAY);
        BackButton.setFont(new Font("Arial ", Font.BOLD, 18));
        panel.add (BackButton);

        Object [] rowData = new Object[3];
        {
            rowData[0] = "\t\t\t                                    ID";
            rowData[1] = "\t\t\t                                    Describation";
            rowData[2] = "\t\t\t                                     Statue";
            tableModel.addRow (rowData);
        }
        for(int i = 0; i < data.size (); i++)
        {
            rowData[0] = data.get (i).getSpotId();
            rowData[1] = data.get (i).getDescription();
            if(data.get (i).isStatue())
                rowData[2] = "Free";
            else
                rowData[2] = "Busy";
            tableModel.addRow (rowData);
        }
        tabel.setModel (tableModel);
        tabel.setBackground (Color.LIGHT_GRAY);
        this.setLocationRelativeTo (null);
        tabel.setBounds (0,80,940,500);

        panel.add (tabel);
        BackButton.addActionListener (this);
        setVisible (true);
    }
    @Override
    public void actionPerformed (ActionEvent e) {
        if(e.getSource () == BackButton)
        {
            this.setVisible (false);
            User_Rights admin=new User_Rights ();
        }
    }
}