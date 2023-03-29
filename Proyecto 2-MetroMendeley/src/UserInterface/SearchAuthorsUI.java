/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UserInterface;

import MetroMendeley.Author;
import MetroMendeley.LinkedList;
import static UserInterface.MainUI.authorsList;
import static UserInterface.MainUI.summarysList;
import javax.swing.JOptionPane;



/**
 *
 * @author Rolando
 */
public class SearchAuthorsUI extends javax.swing.JFrame {
   
    
    public static SearchSummaryUI v1;
    
    /**
     * Creates new form JFileChooser
     * @param v1 (Ventana principal)
     */
    public SearchAuthorsUI(SearchSummaryUI v1) {
        initComponents();
        this.v1 = v1;
        v1.setVisible(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        String[] shownAuthors = new String[authorsList.getSize()];
        for (int i = 0; i < authorsList.getSize(); i++) {
            shownAuthors[i] = authorsList.getElement(i).getName();
        }
        
        authorNames.setModel(new javax.swing.DefaultComboBoxModel(shownAuthors));
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
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        authorNames = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setBackground(new java.awt.Color(204, 255, 255));
        back.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        back.setForeground(new java.awt.Color(51, 51, 51));
        back.setText("Volver");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 80, 30));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 153));
        jLabel1.setText("BUSCAR AUTORES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 350, 50));

        search.setBackground(new java.awt.Color(255, 255, 153));
        search.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        search.setForeground(new java.awt.Color(51, 51, 51));
        search.setText("Buscar");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 100, 30));

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 153));
        jLabel3.setText("Seleccione el Autor");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 250, 30));

        authorNames.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(authorNames, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 250, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.setVisible(false);
        v1.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        if (authorsList.searchAuthor((String) authorNames.getSelectedItem()) != null) {
            Author author = authorsList.searchAuthor((String) authorNames.getSelectedItem());
            
            String articles = author.getArticles().printList();
            
            JOptionPane.showMessageDialog(null, articles);
        }
    }//GEN-LAST:event_searchActionPerformed

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
            java.util.logging.Logger.getLogger(SearchAuthorsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchAuthorsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchAuthorsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchAuthorsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchAuthorsUI(v1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> authorNames;
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
