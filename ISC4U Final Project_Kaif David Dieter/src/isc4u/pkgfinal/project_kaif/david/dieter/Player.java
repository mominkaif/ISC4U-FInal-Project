/* Player Class
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

import java.awt.event.KeyEvent;

/**
 *
 * @author dieter
 */
public class Player extends Entity{
    /**
     * Primary Player Constructor, chain with super to initialize values
     */
    public Player(){
        super();
    }
    /**
     * 
     * @param moveDistance
     * @param imageID
     * @param x
     * @param y
     * @param xSpeed
     * @param ySpeed 
     */
    public Player (int imageID, int x, int y, int xSpeed, int ySpeed){
        super(imageID, x, y, xSpeed, ySpeed);
    }
    /**
     * Accessor for moveDistance of player
     * @return - moveDistance
     */
    
   // @Override
    /**public void move() {
        switch (keyPressed){
            case UP
        }
    }
*/
    @Override
    /**
     * Compares all attributes (moveDistance, imageID, x, y, xSpeed, ySpeed)
     * of current Player to other Player
     * @param - other Entity
     * return - true or false 
     */
    public boolean equals(Entity other) {
        return imageID == ((Player)other).getImageID() || x == ((Player)other).getXPos() ||
                y == ((Player)other).getYPos() || xSpeed == ((Player)other).getXSpeed()
                || ySpeed == ((Player)other).getYSpeed();
    }

    @Override
    /**
     * 
     */
    public Entity clone() {
        Entity p2;
        p2 = new Player(imageID, x, y, xSpeed, ySpeed);
        return p2;
    }

    @Override
    public String toString() {
        return "Image ID: " + imageID + 
               "\nX Position: " + x + "\nY Position: " + y + "\nX Speed: " + 
                xSpeed + "\nY Speed: " + ySpeed;
    }

   
    public void move() {
        x += xSpeed;
        y += ySpeed;
    }
    
    /**
     *
     * @param e
     */
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        switch(key){
            case KeyEvent.VK_LEFT -> xSpeed = -32;
            
            case KeyEvent.VK_RIGHT -> xSpeed = +32;
            
            case KeyEvent.VK_DOWN -> ySpeed = +32;
            
            case KeyEvent.VK_UP -> xSpeed = -32;
            
            case KeyEvent.VK_A -> xSpeed = -32;
            
            case KeyEvent.VK_D -> xSpeed = +32;
            
            case KeyEvent.VK_S -> ySpeed = +32;
            
            case KeyEvent.VK_W -> xSpeed = -32;
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        switch(key){
            case KeyEvent.VK_LEFT -> xSpeed = 0;
            
            case KeyEvent.VK_RIGHT -> xSpeed = 0;
            
            case KeyEvent.VK_DOWN -> ySpeed = 0;
            
            case KeyEvent.VK_UP -> xSpeed = 0;
            
            case KeyEvent.VK_A -> xSpeed = 0;
            
            case KeyEvent.VK_D -> xSpeed = 0;
            
            case KeyEvent.VK_S -> ySpeed = 0;
            
            case KeyEvent.VK_W -> xSpeed = 0;
        }
    }
    
}
