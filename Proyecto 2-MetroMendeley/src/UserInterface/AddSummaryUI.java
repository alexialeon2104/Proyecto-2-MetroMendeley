/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UserInterface;


import MetroMendeley.ReadFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author alexi
 */
public class AddSummaryUI extends javax.swing.JFrame {
    private void guardarArchivo() {
        try {
        
        String nombre="";
        javax.swing.JFileChooser file=new javax.swing.JFileChooser();
        file.showSaveDialog(this);
        File guarda =file.getSelectedFile();

        if(guarda !=null) {
         /*guardamos el archivo y le damos el formato directamente,
          * si queremos que se guarde en formato doc lo definimos como .doc*/
          PrintWriter pw = new PrintWriter(guarda);
          pw.print(txtArea.getText());
          pw.close();
          JOptionPane.showMessageDialog(null,
               "El archivo se ha guardado Exitosamente",
                   "Información",JOptionPane.INFORMATION_MESSAGE);
          }
       } catch(IOException ex) {
         JOptionPane.showMessageDialog(null,
              "Su archivo no se ha guardado",
                 "Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static MainUI v1;
    /**
     * Creates new form JFileChooser
     * @param v1 (Ventana principal)
     */
    public AddSummaryUI(MainUI v1) {
        initComponents();
        this.v1 = v1;
        v1.setVisible(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        showUpdates = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        open = new javax.swing.JButton();
        save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setBackground(new java.awt.Color(102, 102, 102));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText("Instrucciones:\n -  Seleccione el boton Abrir para buscar un archivo de texto y \ncargarlo\n\n- Si desea guardar la información en su archivo de texto. \nPrimero presione \"Mostrar actualizaciones\"  para mostrar \ntoda la información y posteriormente presione \"Guardar\", \nal escoger el archivo en el que quiere guardar se actualizará \nel mismo");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 380, -1));

        txtArea.setBackground(new java.awt.Color(102, 102, 102));
        txtArea.setColumns(20);
        txtArea.setForeground(new java.awt.Color(255, 255, 255));
        txtArea.setRows(5);
        jScrollPane2.setViewportView(txtArea);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 380, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 153));
        jLabel2.setText("Texto cargado: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 120, -1));

        showUpdates.setBackground(new java.awt.Color(255, 255, 153));
        showUpdates.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        showUpdates.setForeground(new java.awt.Color(51, 51, 51));
        showUpdates.setText("Mostrar actualizaciones");
        showUpdates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUpdatesActionPerformed(evt);
            }
        });
        jPanel1.add(showUpdates, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 180, 30));

        back.setBackground(new java.awt.Color(204, 255, 255));
        back.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        back.setForeground(new java.awt.Color(51, 51, 51));
        back.setText("Volver");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 80, 30));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 153));
        jLabel1.setText("AGREGAR UN RESUMEN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 320, 50));

        open.setBackground(new java.awt.Color(255, 255, 153));
        open.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        open.setForeground(new java.awt.Color(51, 51, 51));
        open.setText("Abrir");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        jPanel1.add(open, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 80, 30));

        save.setBackground(new java.awt.Color(255, 255, 153));
        save.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        save.setForeground(new java.awt.Color(51, 51, 51));
        save.setText("Guardar");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 80, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.setVisible(false);
        v1.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void showUpdatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUpdatesActionPerformed
        try {
            String total = "";
//            ReadFile nfile = new ReadFile();

            txtArea.setText(total);
           
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error: " + e);
        }
    }//GEN-LAST:event_showUpdatesActionPerformed

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        try {
            javax.swing.JFileChooser jfc = new javax.swing.JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            jfc.setDialogTitle("Selecciona un archivo de texto (.txt)");
            jfc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
            jfc.addChoosableFileFilter(filter);

            int returnValue = jfc.showOpenDialog(null);

            if (returnValue == javax.swing.JFileChooser.APPROVE_OPTION) {

               String auxpath = jfc.getSelectedFile().getPath();
                System.out.println(jfc.getSelectedFile().getPath());

                ReadFile nfile = new ReadFile();

                String txt = nfile.readTxt(auxpath);

                String[] split = txt.split("~");
                
                String[] txtSplitWarehouses = split[1].split("\n");
                String[] txtSplitRoutes = split[2].split("\n");
                String normal = "";
                
                for (int i = 0; i < txtSplitWarehouses.length; i++) {
                    if(txtSplitWarehouses[i].equals("")) {
                       normal += "Almacenes;" + "\n"; 
                    }  else {
                       normal += txtSplitWarehouses[i] + "\n"; 
                    }
                }
                
                for (int i = 0; i < txtSplitRoutes.length; i++) {
                    if(txtSplitRoutes[i].equals("")) {
                       normal += "Rutas;" + "\n";
                    }  else {
                       normal += txtSplitRoutes[i] + "\n"; 
                    }
                    
                }
                txtArea.setText(normal);
                nfile.appendTxt(normal);
                JOptionPane.showMessageDialog(null, "Cargado exitoso"); 
            }
        } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error en el cargado del archivo: " + e);
            }  
    }//GEN-LAST:event_openActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        this.guardarArchivo();
    }//GEN-LAST:event_saveActionPerformed

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
            java.util.logging.Logger.getLogger(AddSummaryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSummaryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSummaryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSummaryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSummaryUI(v1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton open;
    private javax.swing.JButton save;
    private javax.swing.JButton showUpdates;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
