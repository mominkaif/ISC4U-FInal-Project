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
import java.io.FileInputStream;
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
    //intro class variable, is needed for when we call victoryFrame
    public static Intro intro;
    //arrayList of saves for the scores
    private static ArrayList <SavedData> saves = new ArrayList<>();
    //input stream for reading file
    private static FileInputStream in;
    //private class variable for score, nested class can still access
    private static int score = 0;


    /**
     * Primary Constructor
     *
     * @param l - level number
     */
    public DrawBoard() {
        //playing
        initUI();
    }
    /**
     * initializes the ui
     * uses drawing surface class
     */
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
    /**
     * plays the game from a specific stage
     * @throws IOException 
     */
    public static void playGame() throws IOException {
        if (level <= 5) {
            //checks if the current level is 1-5
            //creates a new drawboard object
            DrawBoard board = new DrawBoard();
            board.setVisible(true);
            //plays the soundtrack
            allBoards[level - 1].getSoundtrack().play();
        }else{
            //if level is not 1-5 it will start victory sequence
            startVictory();
        }
        //allBoards[1].playSound();
    }
    /**
     * uses victory frame class to start victory sequence
     * @throws IOException 
     */
    private static void startVictory() throws IOException{
        readDataFile(); //invoke readDataFile() method so arrayList is updated
        VictoryFrame v = new VictoryFrame(intro,saves,score);
    }
    /**
     * readDataFile() method, tries to reference file from user directory called "saves.txt"
     * reads every score and the user name, creates savedData object and adds to arrayList
     * @throws IOException - in/out error
     */
    private static void readDataFile() throws IOException {
        //declare variables 
        int gameScore;
        String userName;
        SavedData save;
        //try to reference file and read the attributes of SavedData objs into objects
        //that get stored in arrayList
        try {
            in = new FileInputStream(System.getProperty("user.dir") + "/save/saves.txt");
            Scanner scanner = new Scanner(in);
            while (scanner.hasNextLine()) {
                gameScore = Integer.parseInt(scanner.nextLine());
                userName = scanner.nextLine();
                save = new SavedData(gameScore, userName);
                saves.add(save);
            }
        //otherwise print error
        } catch (IOException e) {
            System.out.println("error " + e);
        }

    }
    
    /**
     * gets an instance of the intro from the intro class
     * @param i - intro
     */
    public static void getIntroInstance(Intro i){
        intro = i;
    }
    /**
     * DrawingSurface class, where the actual drawing is done, implements the actionListener
     * and runnable interfaces to help with repainting every frame, has doDrawing method
     * where we draw entities and the player after they have both moved
     * uses thread to help with animating game
     * contains checkHitbox() and checkWin() method that will determine how the 
     * game proceeds
     */
    public class DrawingSurface extends JPanel implements ActionListener, Runnable {
        //encapsulate attributes and class variables
        private Player player;

        //num of ms between each frame
        private final int DELAY = 10;
        //dimensions of drawingSurface
        public final int DS_HEIGHT = 960;
        public final int DS_WIDTH = 640;
        //Thread for animating
        private Thread animator;
        
        
        
        

        
        /**
         * DrawingSUrface constructor calls initDrawingSurface() for jpanel init
         */
        public DrawingSurface() {
            initDrawingSurface();
        }
        /**
         * initializes the drawing surface
         * creates player object
         */
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
        /**
         * addNotify() method
         * helps connect awt with native windowing world
         */
        public void addNotify() {
            super.addNotify(); //calls super

            animator = new Thread(this); //instantiates Thread
            animator.start(); //starts animating

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
            //nested for loops draw each tile on the map
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
        /**
         * run method that gets called once with while loop inside that calls
         * repaint and player.move()
         */
        public void run() {
            //declare as long
            long beforeTime, timeDiff, sleep;
            //start time
            beforeTime = System.currentTimeMillis();

            while (true) {
                //needs multiple try and catch for IO exceptions 
                try {
                    //moves the player and entities
                    player.move();
                    moveEntities();
                    //checks the player's hitbox for death or win
                    checkHitbox();
                    checkWin();
                    //redraws the map
                    repaint();
                    //so our game runs at a constant pace
                    timeDiff = System.currentTimeMillis() - beforeTime;
                    sleep = DELAY - timeDiff;
                    //if the time difference is less than 0 set to 2
                    if (sleep < 0) {
                        sleep = 2;
                    }
                    //try so thread stops working for "sleep" ms
                    try {
                        Thread.sleep(sleep);
                    //if thread is interrupted by other threads or other complications
                    } catch (InterruptedException e) {
                        String msg = String.format("Thread Interrupted: %'s", e.getMessage());
                        
                        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    beforeTime = System.currentTimeMillis();
                //catch IO exception
                } catch (IOException ex) {
                    Logger.getLogger(DrawBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        /**
         * checks if the player dies
         * if they die it starts the game over at level 1
         * @throws IOException 
         */
        private void checkHitbox() throws IOException {
            //player is currently standing on a tile with hitbox false
            if (!allBoards[level - 1].getTileMap()[player.getYPos()][player.getXPos()].getHitbox()) {
                //player died
                System.out.println("player died");
                //gets rid of old player object
                player = null;
                //gets rid of the frame
                this.setVisible(false);
                remove(this);
                dispose();
                //stops the music
                allBoards[level - 1].getSoundtrack().stop();
                //sets level back to 1
                level = 1;
                score++;
                //starts the game over
                playGame();
                
            }
        }
        /**
         * checks if the player has beaten a level
         * @throws IOException 
         */
        private void checkWin() throws IOException {
            if (player.getYPos() == 0) {
                //player reached the top of the map
                System.out.println("won stage " + level);
                //gets rid of player object
                player = null;
                //gets rid of frame
                this.setVisible(false);
                remove(this);
                dispose();
                //stops music
                allBoards[level - 1].getSoundtrack().stop();
                //advances to the next level
                level += 1;
                
                //plays the game
                playGame();
            }
        }

        /**
         * TAdapter class extends KeyAdapter super class, keypressed and released methods
         * depending on what event user completes
         */
        private class TAdapter extends KeyAdapter {

            @Override
            /**
             * keyPressed method
             * invokes player.move() method and sends keycode
             */
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);

            }

            @Override
            /**
             * keyReleased method
             * invokes player.released() method that sends keycode
             */
            public void keyReleased(KeyEvent e) {
                player.keyReleased(e);
            }
        }

    }
}
