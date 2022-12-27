/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import actores.Administrador;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class VentanaInicial extends javax.swing.JFrame {

    /**
     * Creates new form ventanaInicial
     */
    public VentanaInicial() {
        initComponents();
        administrador = new Administrador();
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
        lblLogo = new javax.swing.JLabel();
        jTextFieldAdmin = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion SME Univalle");
        setLocationByPlatform(true);
        setSize(new java.awt.Dimension(640, 360));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user-sign.png"))); // NOI18N

        jTextFieldAdmin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAdmin.setText("Admin");
        jTextFieldAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldAdminMouseClicked(evt);
            }
        });
        jTextFieldAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAdminActionPerformed(evt);
            }
        });
        jTextFieldAdmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAdminKeyPressed(evt);
            }
        });

        jPasswordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField.setText("1234");
        jPasswordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordFieldMouseClicked(evt);
            }
        });
        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });
        jPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogo))
                .addContainerGap(251, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jTextFieldAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAdminActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextFieldAdminActionPerformed

    private void jTextFieldAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldAdminMouseClicked
        // TODO add your handling code here:
        if(conteoClic == 0){
            jTextFieldAdmin.setText("");
            conteoClic++;
        }
        
    }//GEN-LAST:event_jTextFieldAdminMouseClicked

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldActionPerformed

    private void jPasswordFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldMouseClicked
        // TODO add your handling code here:
        jPasswordField.setText("");
    }//GEN-LAST:event_jPasswordFieldMouseClicked

    private void jTextFieldAdminKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAdminKeyPressed
        // TODO add your handling code here:
        System.out.println("tecla numero: " + evt.getKeyCode());
        if(conteoTecla == 0){
            jPasswordField.setText("");
            conteoTecla++;
        }
        
        if(evt.getKeyCode() == 10){
            String usuario = jTextFieldAdmin.getText();
            char[] contrasena = jPasswordField.getPassword();
            compararCredenciales(usuario, contrasena);
        }
        
    }//GEN-LAST:event_jTextFieldAdminKeyPressed

    private void jPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode() == 10){
            String usuario = jTextFieldAdmin.getText();
            char[] contrasena = jPasswordField.getPassword();
            compararCredenciales(usuario, contrasena);
        }
    }//GEN-LAST:event_jPasswordFieldKeyPressed

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
            java.util.logging.Logger.getLogger(VentanaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaInicial().setVisible(true);
            }
        });
    }
    
    /**
     * Metodo mediante el cual se validan los datos ingresados.
     * @param usuario es el valor que ingresa el usuario en el campo jTextFieldAdministrador
     * @param contrasena es el valor que ingresa el usuario en el campo jPasswordField
     */
    private void compararCredenciales(String usuario, char[] contrasena){
        if(usuario.equals(administrador.getNombreUsuario()) && Arrays.equals(contrasena, administrador.getContrasena())){
            for(int i = 0; i < contrasena.length; i++){
                contrasena[i] = '0';
            }
            System.out.println("las credenciales son correctas");
            VentanaGestion ventanaGestion = new VentanaGestion();
            ventanaGestion.setVisible(true);
            this.dispose();
            
        } else {
            JOptionPane.showMessageDialog(null, "Error al validar los datos ingresados", "Contraseña/Usuario incorrecto", 1);
        }
    }
    
    private static Administrador administrador;
    private int conteoClic = 0;
    private int conteoTecla = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldAdmin;
    private javax.swing.JLabel lblLogo;
    // End of variables declaration//GEN-END:variables
}
