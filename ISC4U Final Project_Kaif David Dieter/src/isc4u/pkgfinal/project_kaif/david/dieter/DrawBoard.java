/* 
 * DrawBoard class - Draws the boards
 * Attributes: null
 * June 13, 2022
 * David, Dieter, Kaif
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//test change

/**
 *
 * @author kaifm
 */
public class DrawBoard extends JFrame {

    //we should be using board.getTile() instead
    //array of five boards
    public static Board[] allBoards = new Board[5];
    public static int level = 4;

    public static Intro intro;

    /**
     * Primary Constructor
     *
     * @param l - level number
     */
    public DrawBoard() {
        //playing
        initUI();
    }

    private void initUI() {
        //set title of the JFrame
        setTitle("Pogger Level " + level);
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

    public static void playGame() throws IOException {
        if (level <= 5) {
            DrawBoard board = new DrawBoard();
            board.setVisible(true);

            allBoards[level - 1].getSoundtrack().play();
        }else{
            startVictory();
        }
        //allBoards[1].playSound();
    }
    
    private static void startVictory() throws IOException{
        VictoryFrame v = new VictoryFrame(intro,null,0);
    }
    
    public static void getIntroInstance(Intro i){
        intro = i;
    }

    public class DrawingSurface extends JPanel implements ActionListener, Runnable {

        private Player player;

        //private Timer timer;
        private final int DELAY = 10;

        public final int DS_HEIGHT = 960;
        public final int DS_WIDTH = 640;

        private final int X_INITIAL = DS_WIDTH / 2;
        private final int Y_INITIAL = DS_HEIGHT - 50;

        private Thread animator;

        private boolean moving = false;

        public DrawingSurface() {
            initDrawingSurface();
        }

        private void initDrawingSurface() {
            addKeyListener(new TAdapter());
            setFocusable(true);
            setPreferredSize(new Dimension(DS_WIDTH, DS_HEIGHT));
            //gets image for the player
            Image sprite = new ImageIcon(this.getClass().getResource("/isc4u/pkgfinal/project_kaif/david/dieter/Tiles/Sprite.png")).getImage();
            //creates player object
            player = new Player();
            player.setImage(sprite);
        }

        @Override
        public void addNotify() {
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

            g2d.setRenderingHints(rh);
            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < 20; j++) {
                    //new: changed it to draw straight form the tile's image attriute
                    g2d.drawImage(allBoards[level - 1].getTileMap()[i][j].getImage(), j * 32, i * 32, null);

                }
            }
            //drawing the player
            g2d.drawImage(player.getImage(), player.getXPos() * 32, player.getYPos() * 32, this);
            //drawing all entities
            
            ArrayList<Entity> entityList = allBoards[level-1].getEntityList();
            for(Entity entity: entityList){
                g2d.drawImage(entity.getImage(), entity.getXPos() * 32, entity.getYPos() * 32, this);
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
            Toolkit.getDefaultToolkit().sync();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            player.move();
        }
        /**
         * moves all entities and updates the hitboxes of the map
         * uses the entity list array
         */
        public void moveEntities(){
            ArrayList<Entity> entityList = allBoards[level-1].getEntityList();
            for(Entity entity: entityList){
                //sets previous hitbox true
                //allBoards[level-1].getTileMap()[entity.getXPos()][entity.getYPos()].setHitbox(true);
                entity.move();
                //sets new hitbox false
                //allBoards[level-1].getTileMap()[entity.getXPos()][entity.getYPos()].setHitbox(false);
            }

        }


        @Override
        public void run() {
            long beforeTime, timeDiff, sleep;

            beforeTime = System.currentTimeMillis();

            while (true) {
                
                try {
                    
                    player.move();
                    moveEntities();
                    
                    checkHitbox();
                    checkWin();
                    
                    repaint();
                    
                    timeDiff = System.currentTimeMillis() - beforeTime;
                    sleep = DELAY - timeDiff;
                    
                    if (sleep < 0) {
                        sleep = 2;
                    }
                    
                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException e) {
                        String msg = String.format("Thread Interrupted: %'s", e.getMessage());
                        
                        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    beforeTime = System.currentTimeMillis();
                } catch (IOException ex) {
                    Logger.getLogger(DrawBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        private void checkHitbox() throws IOException {
            if (!allBoards[level - 1].getTileMap()[player.getYPos()][player.getXPos()].getHitbox()) {
                //player died
                System.out.println("player died");
                player = null;
                this.setVisible(false);
                remove(this);
                dispose();
                allBoards[level - 1].getSoundtrack().stop();
                level = 1;
                playGame();
            }
        }

        private void checkWin() throws IOException {
            if (player.getYPos() == 0) {
                System.out.println("won stage " + level);
                player = null;
                this.setVisible(false);
                remove(this);
                dispose();
                allBoards[level - 1].getSoundtrack().stop();
                level += 1;
                playGame();
            }
        }

        private class TAdapter extends KeyAdapter {

            @Override
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);

            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.keyReleased(e);
            }
        }

    }
}
