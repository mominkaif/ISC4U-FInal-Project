/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

/**
 *
 * @author kaifm
 */
public class Intro extends javax.swing.JFrame {

    public boolean play = true;

    public Board board1;
    public Board board2;
    public Board board3;
    public Board board4;
    public Board board5;
    
    public File s = new File("src\\isc4u\\pkgfinal\\project_kaif\\david\\dieter\\Sounds\\menu.wav");
    public Sound menuSound = new Sound(s, false);

    public Tile[][] map = new Tile[30][20];

    public Tile[][][] allLevels = new Tile[5][30][20];

    /**
     * Creates new form Intro
     */
    public Intro() {
        //createBoardArray method is called
        
        createBoardArray();
        initComponents();
        background.setIcon(new ImageIcon("src\\isc4u\\pkgfinal\\project_kaif\\david\\dieter\\Tiles\\introBack.png"));
        
        menuSound.play();

//        File s = new File("src\\isc4u\\pkgfinal\\project_kaif\\david\\dieter\\Sounds\\menu.wav");
//        Sound sound = new Sound(s, false);
//        sound.play();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        start = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Ravie", 2, 48)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        title.setText(" Pogger.");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 100));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("WASD/Arrow keys to move.");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 230, 50));

        start.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 48)); // NOI18N
        start.setText("PLAY.");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });
        getContentPane().add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 767, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Enemies will kill you...");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, 850));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Get to the top.");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 130, 40));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        
        menuSound.stop();
        this.setVisible(false);

        File s = new File("src\\isc4u\\pkgfinal\\project_kaif\\david\\dieter\\Sounds\\beach-trap-beat.wav");
        Sound sound1 = new Sound(s, false);

        board1 = new Board(allLevels[0], sound1, null);
        board2 = new Board(allLevels[1], null, null);
        board3 = new Board(allLevels[2], null, null);
        board4 = new Board(allLevels[3], null, null);
        board5 = new Board(allLevels[4], null, null);

        playGame();
    }//GEN-LAST:event_startActionPerformed

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
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Intro().setVisible(true);
            }
        });

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //instantiate the main window
                DrawBoard windowFrame = new DrawBoard(0, null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton start;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

    /**
     * This method creates 5 2D arrays (one for each level) and places them into
     * the allLevels array
     */
    private void createBoardArray() {
        int tileType = 0;
        String fileName = "";
        File f;

        //run five times for the five levels
        for (int k = 0; k < 5; k++) {
            //change file name based on the level its reading
            fileName = "src\\isc4u\\pkgfinal\\project_kaif\\david\\dieter\\Layout" + (k + 1) + ".txt";
            System.out.println(fileName); //to check if the string is creates correctly

            try {
                f = new File(fileName);
                Scanner scan = new Scanner(f);

                for (int y = 0; y < allLevels[0].length; y++) {
                    for (int x = 0; x < allLevels[0][0].length; x++) {
                        tileType = scan.nextInt();
                        if (tileType == 3) {
                            allLevels[k][y][x] = new Tile(false, x * 32, y * 32, tileType);
                        } else {
                            allLevels[k][y][x] = new Tile(true, x * 32, y * 32, tileType);
                        }
                        // System.out.println(tileType);
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println("ERROR");
            }
        }

        for (int y = 0; y < 5; y++) {
            for (int i = 0; i < allLevels[y].length; ++i) {
                for (int j = 0; j < allLevels[y][0].length; j++) {
                    System.out.print(allLevels[y][i][j].getTexture() + " ");
                }
                System.out.println("");
            }
        }

    }

    private void playGame() {
        int currentLevel = 1;
        switch (currentLevel) {
            case 1:
                board1.doDrawing(1);
                board1.playSound();
                break;
            case 2:
                board2.doDrawing(2);
                board2.playSound();
                break;
            case 3:
                board3.doDrawing(3);
                board3.playSound();
                break;
            case 4:
                board4.doDrawing(4);
                board4.playSound();
                break;
            case 5:
                board5.doDrawing(5);
                board5.playSound();
                break;
            default:
                break;
        }
    }

}
