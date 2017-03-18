/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

/**
 *
 * @author l0011
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
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

        createProjectBtn = new javax.swing.JButton();
        viewProjectBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        createCustomerBtn = new javax.swing.JButton();
        viewCustomerBtn = new javax.swing.JButton();
        createReportBtn = new javax.swing.JButton();
        reportBtn = new javax.swing.JButton();

        setTitle("Main Menu");
        setBackground(new java.awt.Color(255, 255, 255));

        createProjectBtn.setBackground(new java.awt.Color(255, 255, 255));
        createProjectBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        createProjectBtn.setText("Create Project");
        createProjectBtn.setToolTipText("Create a new Project");
        createProjectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProjectBtnActionPerformed(evt);
            }
        });

        viewProjectBtn.setBackground(new java.awt.Color(255, 255, 255));
        viewProjectBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        viewProjectBtn.setText("View Projects");
        viewProjectBtn.setToolTipText("View All Projects");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/main-menu.jpg"))); // NOI18N

        createCustomerBtn.setBackground(new java.awt.Color(255, 255, 255));
        createCustomerBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        createCustomerBtn.setText("Create Customer");
        createCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCustomerBtnActionPerformed(evt);
            }
        });

        viewCustomerBtn.setBackground(new java.awt.Color(255, 255, 255));
        viewCustomerBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        viewCustomerBtn.setText("View Customers");

        createReportBtn.setBackground(new java.awt.Color(255, 255, 255));
        createReportBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        createReportBtn.setText("Create Report");
        createReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createReportBtnActionPerformed(evt);
            }
        });

        reportBtn.setBackground(new java.awt.Color(255, 255, 255));
        reportBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        reportBtn.setText("View Reports");
        reportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(viewProjectBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(createProjectBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(createReportBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(viewCustomerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(createCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(createProjectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(createReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(viewProjectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(createCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(viewCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCustomerBtnActionPerformed
        this.setVisible(false);
        AddCustomerScreen screen = new AddCustomerScreen(this);
        screen.setVisible(true);
    }//GEN-LAST:event_createCustomerBtnActionPerformed

    private void createProjectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProjectBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        CreateProjectScreen screen = new CreateProjectScreen(this);
        screen.setVisible(true);
    }//GEN-LAST:event_createProjectBtnActionPerformed

    private void createReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createReportBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createReportBtnActionPerformed

    private void reportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createCustomerBtn;
    private javax.swing.JButton createProjectBtn;
    private javax.swing.JButton createReportBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton reportBtn;
    private javax.swing.JButton viewCustomerBtn;
    private javax.swing.JButton viewProjectBtn;
    // End of variables declaration//GEN-END:variables
}
