package frames;

import model.Customer;
import javax.swing.JOptionPane;

public class Register extends javax.swing.JFrame {

    public Register() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        phoneno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        add = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Customer");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("First Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 30, -1, 30));
        getContentPane().add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 31, 170, 29));
        getContentPane().add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 72, 170, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Last Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 72, 97, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Email");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 109, 65, 30));
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 109, 170, 30));
        getContentPane().add(phoneno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 170, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Phone No.");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 97, 30));

        home.setText("Back to Home");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        getContentPane().add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, 30));

        add.setText("Register");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 90, 33));

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 65, 33));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 192, 100, 30));
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 191, 170, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
  
        if (fname.getText().trim().isEmpty() || lname.getText().trim().isEmpty()
                || email.getText().trim().isEmpty() || phoneno.getText().trim().isEmpty()
                || password.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            String em = email.getText().trim();
            boolean flag = false;
            for (Customer cus : Database.customers) {
                if (cus.getEmail().equals(em)) {
                    flag = true;

                }
            }
            if (!flag) {
                Customer customer = new Customer(fname.getText().trim(),
                        lname.getText().trim(), email.getText().trim(),
                        phoneno.getText().trim(), password.getText().trim());
                JOptionPane.showMessageDialog(null, "Successfull", "Success!", JOptionPane.INFORMATION_MESSAGE);
                Database.addCustomer(customer);
                Database.customers.add(customer);
                clear();
                loginPage();
            } else {
                JOptionPane.showMessageDialog(null, "email alreadye exist!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }//GEN-LAST:event_addActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        // TODO add your handling code here:
        loginPage();
    }//GEN-LAST:event_homeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton clear;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField password;
    private javax.swing.JTextField phoneno;
    // End of variables declaration//GEN-END:variables

    private void clear() {

        fname.setText("");
        lname.setText("");
        email.setText("");
        phoneno.setText("");

    }

    private void loginPage() {
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }
}
