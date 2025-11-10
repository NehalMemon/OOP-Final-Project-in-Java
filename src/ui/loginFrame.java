package ui;

import javax.swing.*;
import java.awt.event.*;
import dao.StudentDAO;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        this.setTitle("Smart Student Manager - Login");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btn = new JButton("Connect DB");
        btn.addActionListener(e -> {
            StudentDAO dao = new StudentDAO();
            dao.createTable();
            JOptionPane.showMessageDialog(this, "DB Connected and Student table ready!");
        });

        this.add(btn);
        this.setVisible(true);
    }
}
