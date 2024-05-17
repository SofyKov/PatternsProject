/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.prog2.labs;

/**
 *
 * @author Admin
 */
public class viewStudent extends javax.swing.JFrame {

    /**
     * Creates new form viewStudent
     */
    private Student student;

    LibraryController controller = LibraryController.getInstance();

    public viewStudent() {
        initComponents();
        //student = new Student();

        viewAvailableBooks();
    }
    
    public void displayOnLoad()
    {
        //chosenBook_txtF
        String output = "";
        output += "|        SN          |- - -Title- - -|    Author    |\n";
        output += student.viewAvailableBooks();
         displayStud_TxtArea.setText(output);
    }

    private void viewAvailableBooks() {

        displayStud_TxtArea.setText("|       SN        |- - -Title- - -|    Author    |\n"
                + controller.viewAllBooks());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        langTggl_btn = new javax.swing.JToggleButton();
        displayStud_TxtArea = new java.awt.TextArea();
        Borrow_btn = new javax.swing.JButton();
        Title_lbl = new javax.swing.JLabel();
        studID_lbl = new javax.swing.JLabel();
        studID_txtF = new javax.swing.JTextField();
        bookID_lbl = new javax.swing.JLabel();
        book_lbl = new javax.swing.JLabel();
        chosenBook_txtF = new javax.swing.JTextField();
        searchBybookID_txtF = new javax.swing.JTextField();
        title_lbl = new javax.swing.JLabel();
        searchByBookTitle_txtF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        back_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student - Borrow a book");

        langTggl_btn.setText("FR");

        displayStud_TxtArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        displayStud_TxtArea.addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent evt) {
                viewAvilableBooks(evt);
            }
        });

        Borrow_btn.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        Borrow_btn.setText("Borrow book");
        Borrow_btn.setName(""); // NOI18N
        Borrow_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Borrow_btnActionPerformed(evt);
            }
        });

        Title_lbl.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        Title_lbl.setText("Available books:");

        studID_lbl.setText("Student ID:");

        bookID_lbl.setText("Book ID    :");

        book_lbl.setText("Chosen book:");

        chosenBook_txtF.setEditable(false);
        chosenBook_txtF.setFont(new java.awt.Font("sansserif", 2, 10)); // NOI18N
        chosenBook_txtF.setForeground(new java.awt.Color(102, 102, 102));
        chosenBook_txtF.setText("*click here to see*");
        chosenBook_txtF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chosenBook_txtFMouseClicked(evt);
            }
        });
        chosenBook_txtF.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                chosenBook_txtFInputMethodTextChanged(evt);
            }
        });
        chosenBook_txtF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chosenBook_txtFActionPerformed(evt);
            }
        });

        title_lbl.setText("Book title  :");

        jLabel1.setFont(new java.awt.Font("sansserif", 3, 9)); // NOI18N
        jLabel1.setText("*Enter one or both following fields:*");

        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(displayStud_TxtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chosenBook_txtF)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(title_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bookID_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(studID_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(studID_txtF)
                                    .addComponent(searchBybookID_txtF)
                                    .addComponent(searchByBookTitle_txtF)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 52, Short.MAX_VALUE)
                                .addComponent(Borrow_btn)
                                .addGap(65, 65, 65))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(book_lbl)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(langTggl_btn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Title_lbl)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Title_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(studID_lbl)
                            .addComponent(studID_txtF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchBybookID_txtF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookID_lbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(title_lbl)
                            .addComponent(searchByBookTitle_txtF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(book_lbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chosenBook_txtF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Borrow_btn))
                    .addComponent(displayStud_TxtArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(langTggl_btn)
                    .addComponent(back_btn))
                .addContainerGap())
        );

        Borrow_btn.getAccessibleContext().setAccessibleName("Borrow_btn");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewAvilableBooks(java.awt.event.TextEvent evt) {//GEN-FIRST:event_viewAvilableBooks
//        displayStud_TxtArea.setText("|       SN        |- - -Title- - -|    Author    |\n"
//                + student.viewAvailableBooks());
    }//GEN-LAST:event_viewAvilableBooks

    private void chosenBook_txtFInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_chosenBook_txtFInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_chosenBook_txtFInputMethodTextChanged

    private void chosenBook_txtFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chosenBook_txtFMouseClicked
        // TODO add your handling code here:
        String output = "";
        if(!searchByBookTitle_txtF.getText().isEmpty())
        {
            if(student.searchBookByBookTitle(searchByBookTitle_txtF.getText()).equalsIgnoreCase(""))
            {
                chosenBook_txtF.setText("No book with title '" + searchByBookTitle_txtF.getText() + "' exist!");
            }
            
            output = student.searchBookByBookTitle(searchByBookTitle_txtF.getText());
            
            chosenBook_txtF.setText(output);
            System.out.println(student.searchBookByBookID(searchByBookTitle_txtF.getText()));
        }
        else if(!searchBybookID_txtF.getText().isEmpty())
        {
            if(student.searchBookByBookID(searchBybookID_txtF.getText()).equalsIgnoreCase(""))
            {
                chosenBook_txtF.setText("No book with title '" + searchByBookTitle_txtF.getText() + "' exist!");
            }
            
            output = student.searchBookByBookID(searchBybookID_txtF.getText());
            chosenBook_txtF.setText(output.toString());
            System.out.println(student.searchBookByBookID(searchBybookID_txtF.getText()));
        }
        else if(!searchByBookTitle_txtF.getText().isEmpty() && !searchBybookID_txtF.getText().isEmpty())
        {
            if(student.searchBookByBookID(searchBybookID_txtF.getText()).equalsIgnoreCase(student.searchBookByBookTitle(searchByBookTitle_txtF.getText())))
            {
                chosenBook_txtF.setText(student.searchBookByBookID(searchBybookID_txtF.getText()));
            }
            else
            {
                chosenBook_txtF.setText("No book with this title and ID exist!");
            }
        }
    }//GEN-LAST:event_chosenBook_txtFMouseClicked

    private void Borrow_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Borrow_btnActionPerformed
        // TODO add your handling code here:
        Student stud = new Student();
        String studID = studID_txtF.getText();
        
            if(!studID_txtF.getText().isEmpty() && !chosenBook_txtF.getText().isEmpty())
            {
                stud.studentInfoBorrow = stud.findStudent(chosenBook_txtF.getText() ,studID);
                if(stud.studentInfoBorrow != null)
                {
                    BorrowBook bb = new BorrowBook();
                    bb.show();
                }
                else
                {
                    System.out.println("shit #2");
                }
            }
            else
            {
                System.out.println("shit");
            }
    }//GEN-LAST:event_Borrow_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_back_btnActionPerformed

    private void chosenBook_txtFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chosenBook_txtFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chosenBook_txtFActionPerformed

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
            java.util.logging.Logger.getLogger(viewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Borrow_btn;
    private javax.swing.JLabel Title_lbl;
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel bookID_lbl;
    private javax.swing.JLabel book_lbl;
    private javax.swing.JTextField chosenBook_txtF;
    private java.awt.TextArea displayStud_TxtArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton langTggl_btn;
    private javax.swing.JTextField searchByBookTitle_txtF;
    private javax.swing.JTextField searchBybookID_txtF;
    private javax.swing.JLabel studID_lbl;
    private javax.swing.JTextField studID_txtF;
    private javax.swing.JLabel title_lbl;
    // End of variables declaration//GEN-END:variables
}
