/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author kaifm
 */
public class DrawBoard extends JFrame {

    public Tile[][] map1;
    public Tile[][] map2;
    public Tile[][] map3;
    public Tile[][] map4;
    public Tile[][] map5;

//    public Board board1;
//    public Board board2;
//    public Board board3;
//    public Board board4;
//    public Board board5;
    public DrawBoard(String levelNum) {
        initUI(levelNum);

        map1 = new Tile[30][20];
        int tileType = 0;
        int LN = Integer.parseInt(levelNum);

        if (LN == 1) {

            try {
                File f = new File("src\\isc4u\\pkgfinal\\project_kaif\\david\\dieter\\FirstLevelLayout.txt");
                Scanner scan = new Scanner(f);

                while (scan.hasNextLine()) {
                    while (scan.hasNextInt()) {
                        //System.out.println(tileType);
                        for (int i = 0; i < map1.length; i++) {
                            for (int j = 0; j < map1[i].length; j++) {

                                tileType = scan.nextInt();
//                                  System.out.println(tileType);
                                map1[i][j] = new Tile(false, i * 32, j * 32, tileType);
                            }
                        }
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println("ERROR");
            }

        } else if (LN == 2) {

        } else if (LN == 3) {

        } else if (LN == 4) {

        } else if (LN == 5) {

        }

    }

    private void initUI(String LN) {
        //set title of the JFrame
        setTitle("Level " + LN);
        //add a custom JPanel to draw on
        add(new DrawingSurface());
        //set the size of the window
        setSize(640, 960);
        //tell the JFrame what to do when closed
        //this is important if our application has multiple windows
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public class DrawingSurface extends JPanel {

        /**
         * Does the actual drawing
         *
         * @param g - the Graphics object to draw with
         */
        private void doDrawing(Graphics g) {
            //the Graphics2D class is the class that handles all the drawing
            //must be casted from older Graphics class in order to have access to some newer methods
            Graphics2D g2d = (Graphics2D) g;

            Image dirt = new ImageIcon(this.getClass().getResource("/isc4u/pkgfinal/project_kaif/david/dieter/Tiles/1.png")).getImage();
            Image grass = new ImageIcon(this.getClass().getResource("/isc4u/pkgfinal/project_kaif/david/dieter/Tiles/2.png")).getImage();
            Image water = new ImageIcon(this.getClass().getResource("/isc4u/pkgfinal/project_kaif/david/dieter/Tiles/3.png")).getImage();
            Image lightStone = new ImageIcon(this.getClass().getResource("/isc4u/pkgfinal/project_kaif/david/dieter/Tiles/4.png")).getImage();
            Image darkStone = new ImageIcon(this.getClass().getResource("/isc4u/pkgfinal/project_kaif/david/dieter/Tiles/5.png")).getImage();

            for (int i = 0; i < map1.length; ++i) {
                for (int j = 0; j < map1[0].length; j++) {
                    System.out.print(map1[i][j].getTexture() + " ");
                }
                System.out.println("");
            }
            
            for (int i = 0; i < map1.length; i++) {
                for (int j = 0; j < map1[i].length; j++) {
                    if (map1[i][j].getTexture() == 1) {
                        g2d.drawImage(dirt, j * 32, i * 32, null);
                    } else if (map1[i][j].getTexture() == 2) {
                        g2d.drawImage(grass, j * 32, i * 32, null);
                    } else if (map1[i][j].getTexture() == 3) {
                        g2d.drawImage(water, j * 32, i * 32, null);
                    } else if (map1[i][j].getTexture() == 4) {
                        g2d.drawImage(lightStone, j * 32, i * 32, null);
                    } else if (map1[i][j].getTexture() == 5) {
                        g2d.drawImage(darkStone, j * 32, i * 32, null);
                    }
                }
            }
        }

        @Override
        /**
         * Overrides paintComponent in JPanel class so that we can do our own
         * custom painting
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);//does the necessary work to prepare the panel for drawing
            doDrawing(g); //invoke our custom drawing method
        }
    }
}
