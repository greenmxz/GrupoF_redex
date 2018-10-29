package Vista;

public class frmMenuProvisional extends javax.swing.JFrame {
    public frmMenuProvisional() {
        initComponents();
        this.setTitle("Sistema de distribución de paquetes para RedEx");
        //new CambiarPanel(panelPrincipal, new frmReporteAeropuerto());
        new CambiarPanel(panelPrincipal, new frmAdministrarCuenta(this));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        panelInfoUsuario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        btnPaq = new javax.swing.JButton();
        btnAe = new javax.swing.JButton();
        btnVue = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelInfoUsuario.setBackground(new java.awt.Color(255, 153, 51));
        panelInfoUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("¡Bienvenido(a)!");
        panelInfoUsuario.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, -1, -1));

        panelFondo.add(panelInfoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 800, 100));

        panelMenu.setBackground(new java.awt.Color(0, 0, 204));
        panelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPaq.setText("Paquetes");
        btnPaq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaqActionPerformed(evt);
            }
        });
        panelMenu.add(btnPaq, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 120, -1));

        btnAe.setText("Aeropuertos");
        btnAe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAeActionPerformed(evt);
            }
        });
        panelMenu.add(btnAe, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 120, -1));

        btnVue.setText("Vuelos");
        btnVue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVueActionPerformed(evt);
            }
        });
        panelMenu.add(btnVue, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 120, -1));

        panelFondo.add(panelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 600));

        panelPrincipal.setLayout(new javax.swing.BoxLayout(panelPrincipal, javax.swing.BoxLayout.LINE_AXIS));
        panelFondo.add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 800, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAeActionPerformed
        new CambiarPanel(panelPrincipal, new frmReporteAeropuerto());
    }//GEN-LAST:event_btnAeActionPerformed

    private void btnVueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVueActionPerformed
        new CambiarPanel(panelPrincipal, new frmReporteVuelo());
    }//GEN-LAST:event_btnVueActionPerformed

    private void btnPaqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaqActionPerformed
        new CambiarPanel(panelPrincipal, new frmReportePaquete());
    }//GEN-LAST:event_btnPaqActionPerformed

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
            java.util.logging.Logger.getLogger(frmMenuProvisional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenuProvisional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenuProvisional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenuProvisional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenuProvisional().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAe;
    private javax.swing.JButton btnPaq;
    private javax.swing.JButton btnVue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelInfoUsuario;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
