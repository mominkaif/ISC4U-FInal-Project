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
    
    boolean isMoving, movingLeft, movingRight, movingUp, movingDown, movingW, movingS,
            movingD, movingA;
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
        isMoving = false;
        movingLeft = false;
        movingRight = false;
        movingUp = false;
        movingDown = false;
        movingW = false;
        movingS = false;
        movingD = false;
        movingA = false;
    }
   public boolean getIsMoving(){
       return isMoving;
   }
   
   public void setIsMoving(boolean other){
       isMoving = other;
   }
    
    public boolean getMovingLeft(){
        return movingLeft;
    }
    
    public boolean getMovingRight(){
        return movingRight;
    }
    
    public boolean getMovingUp(){
        return movingUp;
    }
    
    public boolean getMovingDown(){
        return movingDown;
    }
    
    public void setMovingLeft(boolean trueFalse){
        movingLeft = trueFalse;
    }
    
    public void setMovingRight(boolean trueFalse){
        movingRight = trueFalse;
    }
    
    public void setMovingUp(boolean trueFalse){
        movingUp = trueFalse;
    }
    
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
        
       if (movingUp == true){
           y+=ySpeed;
           //xSpeed = 0;
           movingUp = false;
       }else{
           ySpeed = 0;
       }
       
       if (movingDown == true){
           y+=ySpeed;
           //xSpeed = 0;
           movingDown = false;
       } else{
           ySpeed = 0;
       }
       
       if (movingLeft == true){
           x+=xSpeed;
           //ySpeed = 0;
           movingLeft = false;
       }else{
           xSpeed = 0;
       }
       
       if (movingRight == true){
           x+=xSpeed;
           //ySpeed = 0;
           movingRight = false;
       }else{
           xSpeed = 0;
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
            xSpeed = -1;
            movingLeft = true;
            isMoving = true;
        }

        if (key == KeyEvent.VK_RIGHT && movingRight == false) {
            xSpeed = +1;
            movingRight = true;
            isMoving = true;
        }

        if (key == KeyEvent.VK_DOWN && movingDown == false) {
            ySpeed = +1;
            movingDown = true;
            isMoving = true;
        }

        if (key == KeyEvent.VK_UP && movingUp == false) {
            movingUp = true;
            ySpeed = -1;
            isMoving = true;
        }

        if (key == KeyEvent.VK_A && movingA == false) {
            movingA = true;
            xSpeed = -1;
            isMoving = true;
        }

        if (key == KeyEvent.VK_D && movingD == false) {
            movingA = true;
            xSpeed = +1;
            isMoving = true;
        }

        if (key == KeyEvent.VK_W && movingW == false) {
            movingW = true;
            ySpeed = -1;
            isMoving = true;
        }

        if (key == KeyEvent.VK_S && movingS == false) {
            movingS = true;
            ySpeed = +1;
            isMoving = true;
        }
        
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT && movingLeft == true){
            movingLeft = false;
            xSpeed = 0;
            isMoving = false;
        }
        
        if(key == KeyEvent.VK_RIGHT && movingRight == true){
            movingRight = false;
            xSpeed = 0;
            isMoving = false;
        }
        
        if(key == KeyEvent.VK_DOWN && movingDown == true){
            movingDown = false;
            ySpeed = 0;
            isMoving = false;
        }
        
        if(key == KeyEvent.VK_UP && movingUp == true){
            movingUp = false;
            ySpeed = 0;
            isMoving = false;
        }
        
        if(key == KeyEvent.VK_A && movingA == true){
            movingA = false;
            xSpeed = 0;
            isMoving = false;
        }
        
        if(key == KeyEvent.VK_D && movingD == true){
            movingD = false;
            xSpeed = 0;
            isMoving = false;
        }
        
        if(key == KeyEvent.VK_W && movingW == true){
            movingW = false;
            ySpeed = 0;
            isMoving = false;
        }
        
        if(key == KeyEvent.VK_S && movingS == true){
            movingS = false;
            ySpeed = 0;
            isMoving = false;
        }
        
    }
    
}
