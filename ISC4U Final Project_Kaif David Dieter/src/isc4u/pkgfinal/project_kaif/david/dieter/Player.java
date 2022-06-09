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
    
    //private boolean attributes for various moving directions, all initially
    //false since instance variables
    private boolean movingLeft, movingRight, movingUp, movingDown, 
            movingW, movingS, movingD, movingA;
    /**
     * Primary Player Constructor, chain with super to initialize values
     */
    public Player(){
        super();
    }
    /**
     * Secondary Player Constructor, chains with super (Entities) to initialize 
     * and assign values. Set all boolean attributes to false.
     * @param image - image of sprite (player)
     * @param x - xPosition 
     * @param y - yPosition
     * @param xSpeed - x Speed
     * @param ySpeed - y Speed
     */
    public Player (Image image, int x, int y, int xSpeed, int ySpeed){
        super(image, x, y, xSpeed, ySpeed);
    }
    /**
     * Accessor for movingLeft boolean
     * @return - true or false
     */
    public boolean getMovingLeft(){
        return movingLeft;
    }
    /**
     * Accessor for movingRight boolean
     * @return - true or false
     */
    public boolean getMovingRight(){
        return movingRight;
    }
    /**
     * Accessor for movingUp boolean
     * @return - true or false
     */
    public boolean getMovingUp(){
        return movingUp;
    }
    /**
     * Accessor for movingDown boolean
     * @return - true or false
     */
    public boolean getMovingDown(){
        return movingDown;
    }
    /**
     * Mutator fo moving left boolean
     * @param trueFalse 
     */
    public void setMovingLeft(boolean trueFalse){
        movingLeft = trueFalse;
    }
    /**
     * Mutator fo movingRight boolean
     * @param trueFalse 
     */
    public void setMovingRight(boolean trueFalse){
        movingRight = trueFalse;
    }
    /**
     * Mutator fo movingUp boolean
     * @param trueFalse 
     */
    public void setMovingUp(boolean trueFalse){
        movingUp = trueFalse;
    }
    /**
     * Mutator fo movingDown boolean
     * @param trueFalse 
     */
    public void setMovingDown(boolean trueFalse){
        movingDown = trueFalse;
    }
    
    
    @Override
    /**
     * Compares all attributes (moveDistance, imageID, x, y, xSpeed, ySpeed)
     * of current Player to other Player
     * @param - other Entity
     * return - true or false 
     */
    public boolean equals(Entity other) {
        return x == (other).getXPos() ||
                y == (other).getYPos() || xSpeed == (other).getXSpeed()
                || ySpeed == (other).getYSpeed();
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
        if (movingUp == true) {
            y -= ySpeed;
            movingUp = false;
        } else if (movingDown == true) {
            y += ySpeed;
            movingDown = false;
        } else if (movingLeft == true) {
            x -= xSpeed;
            movingLeft = false;
        } else if (movingRight == true) {
            x += xSpeed;
            movingRight = false;
        } 

        
        
       /** 
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
        */
        
        
            
        
    }
    
    /**
     *
     * @param e
     */
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
       
        if (key == KeyEvent.VK_LEFT && movingLeft == false) {
            movingLeft = true;
        }

        if (key == KeyEvent.VK_RIGHT && movingRight == false) {
            movingRight = true;
        }

        if (key == KeyEvent.VK_DOWN && movingDown == false) {
            movingDown = true;
        }

        if (key == KeyEvent.VK_UP && movingUp == false) {
            movingUp = true;
        }

        if (key == KeyEvent.VK_A && movingA == false) {
            movingA = true;
        }

        if (key == KeyEvent.VK_D && movingD == false) {
            movingA = true;
        }

        if (key == KeyEvent.VK_W && movingW == false) {
            movingW = true;
        }

        if (key == KeyEvent.VK_S && movingS == false) {
            movingS = true;
        }
        
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT && movingLeft == true){
            movingLeft = false;
        }
        
        if(key == KeyEvent.VK_RIGHT && movingRight == true){
            movingRight = false;
        }
        
        if(key == KeyEvent.VK_DOWN && movingDown == true){
            movingDown = false;
        }
        
        if(key == KeyEvent.VK_UP && movingUp == true){
            movingUp = false;
        }
        
        if(key == KeyEvent.VK_A && movingA == true){
            movingA = false;
        }
        
        if(key == KeyEvent.VK_D && movingD == true){
            movingD = false;
        }
        
        if(key == KeyEvent.VK_W && movingW == true){
            movingW = false;
        }
        
        if(key == KeyEvent.VK_S && movingS == true){
            movingS = false;
        }
        
    }
    
}
