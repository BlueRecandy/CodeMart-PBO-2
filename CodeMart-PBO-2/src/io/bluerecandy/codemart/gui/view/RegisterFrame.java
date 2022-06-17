/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.bluerecandy.codemart.gui.view;

import io.bluerecandy.codemart.gui.controller.AccountController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lutfi
 */
public class RegisterFrame extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    
    /**
     * Creates new form RegisterFrame
     */
    public RegisterFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelRegisterFrameTitle = new javax.swing.JLabel();
        labelRegisterFrameName = new javax.swing.JLabel();
        textFieldRegisterFrameName = new javax.swing.JTextField();
        labelRegisterFrameEmail = new javax.swing.JLabel();
        labelRegisterFramePassword = new javax.swing.JLabel();
        labelRegisterFrameRetypePassword = new javax.swing.JLabel();
        textFieldRegisterFrameEmail = new javax.swing.JTextField();
        buttonRegisterFrameRegister = new javax.swing.JButton();
        labelRegisterFrameParagraf = new javax.swing.JLabel();
        passwordFieldRegisterFramePassword = new javax.swing.JPasswordField();
        passwordFieldRegisterFrameRetypePassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelRegisterFrameTitle.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        labelRegisterFrameTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRegisterFrameTitle.setText("Register");
        labelRegisterFrameTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelRegisterFrameName.setText("Name");

        labelRegisterFrameEmail.setText("Email");

        labelRegisterFramePassword.setText("Password");

        labelRegisterFrameRetypePassword.setText("Re-type Password");

        buttonRegisterFrameRegister.setText("Register");
        buttonRegisterFrameRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterFrameRegisterActionPerformed(evt);
            }
        });

        labelRegisterFrameParagraf.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        labelRegisterFrameParagraf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRegisterFrameParagraf.setText("Please insert your data:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelRegisterFrameTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelRegisterFrameParagraf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonRegisterFrameRegister)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRegisterFrameName)
                            .addComponent(labelRegisterFrameEmail)
                            .addComponent(labelRegisterFrameRetypePassword)
                            .addComponent(labelRegisterFramePassword))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordFieldRegisterFramePassword, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textFieldRegisterFrameEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textFieldRegisterFrameName, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(passwordFieldRegisterFrameRetypePassword))))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labelRegisterFrameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelRegisterFrameParagraf, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldRegisterFrameName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRegisterFrameName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldRegisterFrameEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRegisterFrameEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordFieldRegisterFramePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRegisterFramePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordFieldRegisterFrameRetypePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRegisterFrameRetypePassword))
                .addGap(65, 65, 65)
                .addComponent(buttonRegisterFrameRegister)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRegisterFrameRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterFrameRegisterActionPerformed
        String name = textFieldRegisterFrameName.getText();
        String email = textFieldRegisterFrameEmail.getText();
        char[] password = passwordFieldRegisterFramePassword.getPassword();
        String retypePassword = String.valueOf(passwordFieldRegisterFrameRetypePassword.getPassword());
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Add A Name");
        } else if(password.equals("")){
            JOptionPane.showMessageDialog(null, "Add A Password");
        } else if(!password.equals(retypePassword)){
            JOptionPane.showMessageDialog(null, "Retype The Password Again");
        }
        
        try{
            boolean register = AccountController.getInstance().register(email, name, password);
            if (register){
                JOptionPane.showMessageDialog(null, "Register Successfully");
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_buttonRegisterFrameRegisterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRegisterFrameRegister;
    private javax.swing.JLabel labelRegisterFrameEmail;
    private javax.swing.JLabel labelRegisterFrameName;
    private javax.swing.JLabel labelRegisterFrameParagraf;
    private javax.swing.JLabel labelRegisterFramePassword;
    private javax.swing.JLabel labelRegisterFrameRetypePassword;
    private javax.swing.JLabel labelRegisterFrameTitle;
    private javax.swing.JPasswordField passwordFieldRegisterFramePassword;
    private javax.swing.JPasswordField passwordFieldRegisterFrameRetypePassword;
    private javax.swing.JTextField textFieldRegisterFrameEmail;
    private javax.swing.JTextField textFieldRegisterFrameName;
    // End of variables declaration//GEN-END:variables
}