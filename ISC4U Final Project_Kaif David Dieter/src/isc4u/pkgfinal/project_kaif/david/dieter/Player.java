/* Player Class
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

import java.awt.Image;
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
     * @param image
     * @param x
     * @param y
     * @param xSpeed
     * @param ySpeed 
     */
    public Player (Image image, int x, int y, int xSpeed, int ySpeed){
        super(image, x, y, xSpeed, ySpeed);
    }

    @Override
    /**
     * Compares all attributes (moveDistance, imageID, x, y, xSpeed, ySpeed)
     * of current Player to other Player
     * @param - other Entity
     * return - true or false 
     */
    public boolean equals(Entity other) {
        return x == ((Player)other).getXPos() ||
                y == ((Player)other).getYPos() || xSpeed == ((Player)other).getXSpeed()
                || ySpeed == ((Player)other).getYSpeed();
    }

    @Override
    /**
     * 
     */
    public Entity clone() {
        Entity p2;
        p2 = new Player(image, x, y, xSpeed, ySpeed);
        return p2;
    }

    @Override
    public String toString() {
        return "\nX Position: " + x + "\nY Position: " + y + "\nX Speed: " + 
                xSpeed + "\nY Speed: " + ySpeed;
    }

   
    public void move() {
        if(x>=0){
            x+=xSpeed;
        }else{
            x = 0;
        }
        
        if(x<=19){
            x+=xSpeed;
        }else{
            x = 19;
        }
        
        if(y>=0){
            y+=ySpeed;
        }else{
            y = 0;
        }
        
        if(y<=29){
            y+=ySpeed;
        }else{
            y = 29;
        }
            
            
        
    }
    
    /**
     *
     * @param e
     */
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        switch(key){
            case KeyEvent.VK_LEFT -> xSpeed = -1;
            
            case KeyEvent.VK_RIGHT -> xSpeed = +1;
            
            case KeyEvent.VK_DOWN -> ySpeed = +1;
            
            case KeyEvent.VK_UP -> ySpeed = -1;
            
            case KeyEvent.VK_A -> xSpeed = -1;
            
            case KeyEvent.VK_D -> xSpeed = +1;
            
            case KeyEvent.VK_S -> ySpeed = +1;
            
            case KeyEvent.VK_W -> ySpeed = -1;
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        switch(key){
            case KeyEvent.VK_LEFT -> xSpeed = 0;
            
            case KeyEvent.VK_RIGHT -> xSpeed = 0;
            
            case KeyEvent.VK_DOWN -> ySpeed = 0;
            
            case KeyEvent.VK_UP -> ySpeed = 0;
            
            case KeyEvent.VK_A -> xSpeed = 0;
            
            case KeyEvent.VK_D -> xSpeed = 0;
            
            case KeyEvent.VK_S -> ySpeed = 0;
            
            case KeyEvent.VK_W -> ySpeed = 0;
        }
    }
    
}
