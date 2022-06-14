/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

import static isc4u.pkgfinal.project_kaif.david.dieter.DrawBoard.intro;
/**
 *
 * @author David
 */
public class Credits extends javax.swing.JFrame {

    /**
     * Creates new form Credits
     * @param i - Intro class object
     */
    public Credits(Intro i) {
        intro = i;
        initComponents();
        setSize(960, 640); //same size as others
        setLocationRelativeTo(intro); //same location on screen
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSystemsAnalyst = new javax.swing.JLabel();
        lblLeadProgrammers1 = new javax.swing.JLabel();
        lblLeadProgrammers2 = new javax.swing.JLabel();
        lblProjectManager1 = new javax.swing.JLabel();
        lblProjectManager = new javax.swing.JLabel();
        lblTechnicalWriter1 = new javax.swing.JLabel();
        lblSoundsDesign = new javax.swing.JLabel();
        lblSystemsAnalyst3 = new javax.swing.JLabel();
        lblTechnicalWriter2 = new javax.swing.JLabel();
        lblTechnicalWriter3 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSystemsAnalyst.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        lblSystemsAnalyst.setText("Systems Analyst:");
        lblSystemsAnalyst.setToolTipText("");

        lblLeadProgrammers1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        lblLeadProgrammers1.setText("Dieter Whittingham");
        lblLeadProgrammers1.setToolTipText("");

        lblLeadProgrammers2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        lblLeadProgrammers2.setText("Lead Programmer");
        lblLeadProgrammers2.setToolTipText("");

        lblProjectManager1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        lblProjectManager1.setText("Kaif Momin");

        lblProjectManager.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        lblProjectManager.setText("Project Manager");
        lblProjectManager.setToolTipText("");

        lblTechnicalWriter1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        lblTechnicalWriter1.setText("Dieter Whittingham");

        lblSoundsDesign.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        lblSoundsDesign.setText("Sounds Design");
        lblSoundsDesign.setToolTipText("");

        lblSystemsAnalyst3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        lblSystemsAnalyst3.setText("David Xu");

        lblTechnicalWriter2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        lblTechnicalWriter2.setText("Technical Writer");
        lblTechnicalWriter2.setToolTipText("");

        lblTechnicalWriter3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        lblTechnicalWriter3.setText("Kaif Momin");
        lblTechnicalWriter3.setToolTipText("");

        btnBack.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        btnBack.setText("BACK.");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTechnicalWriter3)
                    .addComponent(lblSoundsDesign, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTechnicalWriter2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSystemsAnalyst3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLeadProgrammers2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLeadProgrammers1)
                    .addComponent(lblSystemsAnalyst, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProjectManager)
                    .addComponent(lblProjectManager1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTechnicalWriter1))
                .addGap(0, 219, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLeadProgrammers2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLeadProgrammers1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lblProjectManager, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblProjectManager1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lblSystemsAnalyst, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSystemsAnalyst3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lblTechnicalWriter2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTechnicalWriter3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lblSoundsDesign, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTechnicalWriter1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        intro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel lblLeadProgrammers1;
    private javax.swing.JLabel lblLeadProgrammers2;
    private javax.swing.JLabel lblProjectManager;
    private javax.swing.JLabel lblProjectManager1;
    private javax.swing.JLabel lblSoundsDesign;
    private javax.swing.JLabel lblSystemsAnalyst;
    private javax.swing.JLabel lblSystemsAnalyst3;
    private javax.swing.JLabel lblTechnicalWriter1;
    private javax.swing.JLabel lblTechnicalWriter2;
    private javax.swing.JLabel lblTechnicalWriter3;
    // End of variables declaration//GEN-END:variables
}
