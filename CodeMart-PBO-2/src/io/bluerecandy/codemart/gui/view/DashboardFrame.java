/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package io.bluerecandy.codemart.gui.view;

import io.bluerecandy.codemart.gui.controller.ProductController;
import io.bluerecandy.codemart.gui.model.Product;

import javax.swing.*;
import java.util.List;

/**
 *
 * @author Fathan
 */
public class DashboardFrame extends javax.swing.JFrame {

    /**
     * Creates new form ProductBrowseFrame
     */
    public DashboardFrame() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelDashboardFrameBrowse = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listDashboardFrameBrowseProducts = new javax.swing.JList<>();
        labelDashboardFrameBrowseTitle = new javax.swing.JLabel();
        labelDashboardFrameBrowseDescription = new javax.swing.JLabel();
        labelDashboardFrameBrowsePrice = new javax.swing.JLabel();
        buttonDashboardFrameBrowseDownload = new javax.swing.JButton();
        buttonDashboardFrameBrowsePurchase = new javax.swing.JButton();
        panelDashboardFrameYourProducts = new javax.swing.JPanel();
        panelDashboardFrameUploadProduct = new javax.swing.JPanel();
        panelDashboardFrameAccount = new javax.swing.JPanel();
        labelDashboardFrameAccountName = new javax.swing.JLabel();
        labelDashboardFrameAccountCoin = new javax.swing.JLabel();
        buttonDashboardFrameAccountLogout = new javax.swing.JButton();
        buttonDashboardFrameAccountTopup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        listDashboardFrameBrowseProducts.setModel(new DefaultListModel());
        jScrollPane1.setViewportView(listDashboardFrameBrowseProducts);

        labelDashboardFrameBrowseTitle.setText("Product Title");

        labelDashboardFrameBrowseDescription.setText("Description");

        labelDashboardFrameBrowsePrice.setText("Price:");

        buttonDashboardFrameBrowseDownload.setText("Download");
        buttonDashboardFrameBrowseDownload.setEnabled(false);

        buttonDashboardFrameBrowsePurchase.setText("Purchase");
        buttonDashboardFrameBrowsePurchase.setEnabled(false);

        javax.swing.GroupLayout panelDashboardFrameBrowseLayout = new javax.swing.GroupLayout(panelDashboardFrameBrowse);
        panelDashboardFrameBrowse.setLayout(panelDashboardFrameBrowseLayout);
        panelDashboardFrameBrowseLayout.setHorizontalGroup(
            panelDashboardFrameBrowseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDashboardFrameBrowseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelDashboardFrameBrowseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDashboardFrameBrowseLayout.createSequentialGroup()
                        .addComponent(buttonDashboardFrameBrowseDownload)
                        .addGap(18, 18, 18)
                        .addComponent(buttonDashboardFrameBrowsePurchase)
                        .addGap(0, 227, Short.MAX_VALUE))
                    .addComponent(labelDashboardFrameBrowseTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDashboardFrameBrowseDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDashboardFrameBrowsePrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelDashboardFrameBrowseLayout.setVerticalGroup(
            panelDashboardFrameBrowseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDashboardFrameBrowseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDashboardFrameBrowseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDashboardFrameBrowseLayout.createSequentialGroup()
                        .addComponent(labelDashboardFrameBrowseTitle)
                        .addGap(18, 18, 18)
                        .addComponent(labelDashboardFrameBrowseDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelDashboardFrameBrowsePrice))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(panelDashboardFrameBrowseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDashboardFrameBrowseDownload)
                    .addComponent(buttonDashboardFrameBrowsePurchase))
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Browse", panelDashboardFrameBrowse);

        javax.swing.GroupLayout panelDashboardFrameYourProductsLayout = new javax.swing.GroupLayout(panelDashboardFrameYourProducts);
        panelDashboardFrameYourProducts.setLayout(panelDashboardFrameYourProductsLayout);
        panelDashboardFrameYourProductsLayout.setHorizontalGroup(
            panelDashboardFrameYourProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        panelDashboardFrameYourProductsLayout.setVerticalGroup(
            panelDashboardFrameYourProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Your Products", panelDashboardFrameYourProducts);

        javax.swing.GroupLayout panelDashboardFrameUploadProductLayout = new javax.swing.GroupLayout(panelDashboardFrameUploadProduct);
        panelDashboardFrameUploadProduct.setLayout(panelDashboardFrameUploadProductLayout);
        panelDashboardFrameUploadProductLayout.setHorizontalGroup(
            panelDashboardFrameUploadProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        panelDashboardFrameUploadProductLayout.setVerticalGroup(
            panelDashboardFrameUploadProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Upload Product", panelDashboardFrameUploadProduct);

        labelDashboardFrameAccountName.setText("Name: ");

        labelDashboardFrameAccountCoin.setText("Coin:");

        buttonDashboardFrameAccountLogout.setText("Logout");
        buttonDashboardFrameAccountLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDashboardFrameAccountLogoutActionPerformed(evt);
            }
        });

        buttonDashboardFrameAccountTopup.setText("Top Up");

        javax.swing.GroupLayout panelDashboardFrameAccountLayout = new javax.swing.GroupLayout(panelDashboardFrameAccount);
        panelDashboardFrameAccount.setLayout(panelDashboardFrameAccountLayout);
        panelDashboardFrameAccountLayout.setHorizontalGroup(
            panelDashboardFrameAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDashboardFrameAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDashboardFrameAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDashboardFrameAccountLayout.createSequentialGroup()
                        .addGroup(panelDashboardFrameAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelDashboardFrameAccountName, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(labelDashboardFrameAccountCoin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDashboardFrameAccountLayout.createSequentialGroup()
                        .addComponent(buttonDashboardFrameAccountTopup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 454, Short.MAX_VALUE)
                        .addComponent(buttonDashboardFrameAccountLogout)))
                .addContainerGap())
        );
        panelDashboardFrameAccountLayout.setVerticalGroup(
            panelDashboardFrameAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDashboardFrameAccountLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(labelDashboardFrameAccountName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDashboardFrameAccountCoin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addGroup(panelDashboardFrameAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDashboardFrameAccountLogout)
                    .addComponent(buttonDashboardFrameAccountTopup))
                .addGap(35, 35, 35))
        );

        jTabbedPane1.addTab("Account", panelDashboardFrameAccount);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Browse");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        List<Product> products = ProductController.getInstance().getAllProducts();

        DefaultListModel<Product> model = (DefaultListModel<Product>) listDashboardFrameBrowseProducts.getModel();
        model.addAll(products);
    }//GEN-LAST:event_formWindowOpened

    private void buttonDashboardFrameAccountLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDashboardFrameAccountLogoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new LoginFrame().setVisible(true);
    }//GEN-LAST:event_buttonDashboardFrameAccountLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDashboardFrameAccountLogout;
    private javax.swing.JButton buttonDashboardFrameAccountTopup;
    private javax.swing.JButton buttonDashboardFrameBrowseDownload;
    private javax.swing.JButton buttonDashboardFrameBrowsePurchase;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelDashboardFrameAccountCoin;
    private javax.swing.JLabel labelDashboardFrameAccountName;
    private javax.swing.JLabel labelDashboardFrameBrowseDescription;
    private javax.swing.JLabel labelDashboardFrameBrowsePrice;
    private javax.swing.JLabel labelDashboardFrameBrowseTitle;
    private javax.swing.JList<Product> listDashboardFrameBrowseProducts;
    private javax.swing.JPanel panelDashboardFrameAccount;
    private javax.swing.JPanel panelDashboardFrameBrowse;
    private javax.swing.JPanel panelDashboardFrameUploadProduct;
    private javax.swing.JPanel panelDashboardFrameYourProducts;
    // End of variables declaration//GEN-END:variables
}
