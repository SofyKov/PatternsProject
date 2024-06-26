/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.prog2.labs;

import java.awt.Color;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author grech
 */
public class LibraryGUIView extends javax.swing.JFrame 
{
    ResourceBundle messages;

    /**
     * Creates new form LibraryGUIView
     */
    public LibraryGUIView() 
    {
        initComponents();
        setVisible(true);
        messages = ResourceBundle.getBundle("messages", Locale.getDefault());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        areyouLabel = new javax.swing.JLabel();
        studentButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        libButton = new javax.swing.JButton();
        welcomeLabel = new javax.swing.JLabel();
        langButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setName("viewBooksLabel"); // NOI18N

        areyouLabel.setFont(new java.awt.Font("sansserif", 2, 18)); // NOI18N
        areyouLabel.setText("Are you a ...");

        studentButton.setBackground(java.awt.Color.cyan);
        studentButton.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        studentButton.setText("Student");
        studentButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                studentButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                studentButtonMouseExited(evt);
            }
        });
        studentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studIcon.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libIcon.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        libButton.setBackground(java.awt.Color.cyan);
        libButton.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        libButton.setText("Librarian");
        libButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        libButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                libButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                libButtonMouseExited(evt);
            }
        });
        libButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libButtonActionPerformed(evt);
            }
        });

        welcomeLabel.setFont(new java.awt.Font("MS UI Gothic", 1, 14)); // NOI18N
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("WELCOME TO SOFYA'S AND GRECHELLE'S LIBRARY");

        langButton.setText("FR");
        langButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(studentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(libButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 86, 86))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(langButton)
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(areyouLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(welcomeLabel)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(areyouLabel)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentButton)
                    .addComponent(libButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(langButton)
                .addGap(45, 45, 45))
        );

        jLabel1.getAccessibleContext().setAccessibleName("studIcon_lbl");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void langButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langButtonActionPerformed
        // TODO add your handling code here:

        if (langButton.isSelected()) {
            //french
            messages = ResourceBundle.getBundle("messages", Locale.FRENCH);
            updateTexts();

        } else {
            //english
            messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);
            updateTexts();
        }
    }//GEN-LAST:event_langButtonActionPerformed

    private void libButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libButtonActionPerformed
        // TODO add your handling code here:
        logInLibrarian logInLib = new logInLibrarian();
        logInLib.show();
        
        this.hide();
    }//GEN-LAST:event_libButtonActionPerformed

    private void studentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentButtonActionPerformed
        // TODO add your handling code here:
        viewStudent vs = new viewStudent();
        vs.show();
        this.dispose();
    }//GEN-LAST:event_studentButtonActionPerformed

    private void libButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_libButtonMouseEntered
        // TODO add your handling code here:
        libButton.setBackground(Color.BLUE);
        libButton.setForeground(Color.white);
    }//GEN-LAST:event_libButtonMouseEntered

    private void libButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_libButtonMouseExited
        // TODO add your handling code here:
        libButton.setBackground(Color.cyan);
        libButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_libButtonMouseExited

    private void studentButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentButtonMouseEntered
        // TODO add your handling code here:
        studentButton.setBackground(Color.BLUE);
        studentButton.setForeground(Color.white);
    }//GEN-LAST:event_studentButtonMouseEntered

    private void studentButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentButtonMouseExited
        // TODO add your handling code here:
        studentButton.setBackground(Color.cyan);
        studentButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_studentButtonMouseExited

    private void updateTexts() {
        areyouLabel.setText(messages.getString("areyouLabel"));
        langButton.setText(messages.getString("langButton"));
        libButton.setText(messages.getString("libButton"));
        studentButton.setText(messages.getString("studentButton"));
        welcomeLabel.setText(messages.getString("welcomeLabel"));
    }

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
            java.util.logging.Logger.getLogger(LibraryGUIView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibraryGUIView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibraryGUIView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibraryGUIView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel areyouLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton langButton;
    private javax.swing.JButton libButton;
    private javax.swing.JButton studentButton;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
