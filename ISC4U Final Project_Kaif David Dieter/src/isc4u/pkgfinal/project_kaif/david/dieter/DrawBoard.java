/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author kaifm
 */
public class DrawBoard extends JFrame {
    
    private Image dirt, grass, water, lightStone, darkStone, sprite;

    public Tile[][] map = new Tile[30][20];
    
    public DrawBoard level1;
    public DrawBoard level2;
    public DrawBoard level3;
    public DrawBoard level4;
    public DrawBoard level5;


    public DrawBoard(int l, Tile[][] t) {
        map = t;
        loadImage();
        initUI(l);
        //testing sound
            

    }

    private void initUI(int l) {
        //set title of the JFrame
        setTitle("Pogger Level " + l);
        //add a custom JPanel to draw on
        add(new DrawingSurface());
        //set the size of the window
        setSize(640, 960);
        setResizable(false);
        pack(); //for the thread
        
        //tell the JFrame what to do when closed
        //this is important if our application has multiple windows
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       
    }

    private void loadImage() {
        //load tile images
        dirt = new ImageIcon(this.getClass().getResource("/isc4u/pkgfinal/project_kaif/david/dieter/Tiles/1.png")).getImage();
        grass = new ImageIcon(this.getClass().getResource("/isc4u/pkgfinal/project_kaif/david/dieter/Tiles/2.png")).getImage();
        water = new ImageIcon(this.getClass().getResource("/isc4u/pkgfinal/project_kaif/david/dieter/Tiles/3.png")).getImage();
        lightStone = new ImageIcon(this.getClass().getResource("/isc4u/pkgfinal/project_kaif/david/dieter/Tiles/4.png")).getImage();
        darkStone = new ImageIcon(this.getClass().getResource("/isc4u/pkgfinal/project_kaif/david/dieter/Tiles/5.png")).getImage();
        //load sprite object image
        sprite = new ImageIcon(this.getClass().getResource("/isc4u/pkgfinal/project_kaif/david/dieter/Tiles/Sprite.png")).getImage();
    }

    public class DrawingSurface extends JPanel implements ActionListener, Runnable{
        private Player player;
        //private Timer timer;
        
        private final int DELAY = 10;
        
        private final int DS_HEIGHT = 960;
        private final int DS_WIDTH = 640;
        
        private final int X_INITIAL = DS_WIDTH / 2;
        private final int Y_INITIAL = DS_HEIGHT - 50;
        
        private Thread animator;        
        
        private boolean moving = false;
       
        public DrawingSurface(){
            initDrawingSurface();
        }
        private void initDrawingSurface() {
            addKeyListener(new TAdapter());
            setFocusable(true);
            setPreferredSize(new Dimension(DS_WIDTH, DS_HEIGHT));
            player = new Player();
            
            //timer = new Timer(DELAY, this);
            //timer.start();

        }
        @Override
        public void addNotify(){
            super.addNotify();
            
            animator = new Thread(this);
            animator.start();
            
        }
        /**
         * Does the actual drawing
         *
         * @param g - the Graphics object to draw with
         */
        private void doDrawing(Graphics g) {
            
            
            
            //the Graphics2D class is the class that handles all the drawing
            //must be casted from older Graphics class in order to have access to some newer methods
            Graphics2D g2d = (Graphics2D) g;
            
            RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);

            rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            g2d.setRenderingHints(rh)
                    ;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j].getTexture() == 1) {
                        g2d.drawImage(dirt, j * 32, i * 32, null);
                    } else if (map[i][j].getTexture() == 2) {
                        g2d.drawImage(grass, j * 32, i * 32, null);
                    } else if (map[i][j].getTexture() == 3) {
                        g2d.drawImage(water, j * 32, i * 32, null);
                    } else if (map[i][j].getTexture() == 4) {
                        g2d.drawImage(lightStone, j * 32, i * 32, null);
                    } else if (map[i][j].getTexture() == 5) {
                        g2d.drawImage(darkStone, j * 32, i * 32, null);
                    }
                }
            }
            g2d.drawImage(sprite, player.getXPos(), player.getYPos(), this);
            
        }

        @Override
        /**
         * Overrides paintComponent in JPanel class so that we can do our own
         * custom painting
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);//does the necessary work to prepare the panel for drawing
            doDrawing(g); //invoke our custom drawing method
            Toolkit.getDefaultToolkit().sync();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            step();
        }

        private void step() {
            player.move();
        }

        @Override
        public void run() {
            long beforeTime, timeDiff, sleep;
            
            beforeTime = System.currentTimeMillis();
            
            while (true){
                step();
                repaint();
                
                timeDiff = System.currentTimeMillis() - beforeTime;
                sleep = DELAY - timeDiff;
                
                if(sleep < 0){
                    sleep = 2;
                }
                
                try{
                    Thread.sleep(sleep);
                } catch(InterruptedException e){
                    String msg = String.format("Thread Interrupted: %'s", e.getMessage());
                    
                    JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                beforeTime = System.currentTimeMillis();
            }
        }
        
        private class TAdapter extends KeyAdapter{
            @Override
            public void keyPressed(KeyEvent e){
                player.keyPressed(e);
            }
            @Override
            public void keyReleased(KeyEvent e){
                player.keyReleased(e);
            }
        }

        
    }
}
