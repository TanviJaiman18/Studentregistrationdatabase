import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class StudentRegistrationdatabase extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t4;
    JRadioButton male, female;
    JButton save, clear;

    Connection con;
    PreparedStatement pst;

    StudentRegistrationdatabase() {

        setTitle("Student Registration");
        setSize(450, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Student ID:");
        l1.setBounds(50, 50, 100, 30);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(160, 50, 200, 30);
        add(t1);

        l2 = new JLabel("Name:");
        l2.setBounds(50, 100, 100, 30);
        add(l2);

        t2 = new JTextField();
        t2.setBounds(160, 100, 200, 30);
        add(t2);

        l3 = new JLabel("Gender:");
        l3.setBounds(50, 150, 100, 30);
        add(l3);

        male = new JRadioButton("Male");
        male.setBounds(160, 150, 80, 30);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(250, 150, 90, 30);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        l4 = new JLabel("Branch:");
        l4.setBounds(50, 200, 100, 30);
        add(l4);

        t4 = new JTextField();
        t4.setBounds(160, 200, 200, 30);
        add(t4);

        save = new JButton("Save");
        save.setBounds(100, 270, 100, 35);
        save.addActionListener(this);
        add(save);

        clear = new JButton("Clear");
        clear.setBounds(230, 270, 100, 35);
        clear.addActionListener(this);
        add(clear);

        connectDB();

        setVisible(true);
    }

    // Database Connection
   void connectDB() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/studentregistration",
            "root",
            "your password"
        );

        System.out.println("Database Connected!");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
            this,
            "Database Error: " + e.getMessage()
        );
    }
}

    // Button Actions
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == save) {

            try {

                int sid = Integer.parseInt(t1.getText());
                String name = t2.getText();

                String gender = "";

                if (male.isSelected()) {
                    gender = "Male";
                } else if (female.isSelected()) {
                    gender = "Female";
                }

                String branch = t4.getText();

                String sql =
                    "INSERT INTO student (sid, name, gender, Branch) VALUES (?, ?, ?, ?)";

                pst = con.prepareStatement(sql);

                pst.setInt(1, sid);
                pst.setString(2, name);
                pst.setString(3, gender);
                pst.setString(4, branch);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(
                    this,
                    "Student Registered Successfully!"
                );

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                    this,
                    "Error: " + ex.getMessage()
                );
            }
        }

        if (e.getSource() == clear) {

            t1.setText("");
            t2.setText("");
            t4.setText("");

            male.setSelected(false);
            female.setSelected(false);
        }
    }

    public static void main(String[] args) {
        new StudentRegistrationdatabase();
    }
}

    