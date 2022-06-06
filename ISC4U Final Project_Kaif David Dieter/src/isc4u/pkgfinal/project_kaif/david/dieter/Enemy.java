/* Enemy class
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

import java.awt.Image;

/**
 *
 * @author Dieter
 */
public class Enemy extends Entity{
    /**
     * primary constructor
     * uses superclass
     */
    public Enemy(){
        super();
    }
    /**
     * secondary constructor
     * @param imageID - image number
     * @param x - x location
     * @param y - y location
     * @param xSpeed - x speed
     * @param ySpeed - y speed
     */
    public Enemy(Image image, int x, int y, int xSpeed, int ySpeed){
        super(image, x, y, xSpeed, ySpeed);
    }
    /**
     * moves the entity
     * updates its x and y position based on its speed
     * if it reaches the edge it respawns on the other side of the map
     */
    public void move(){
        if(x>=0){
            x+=xSpeed;
        }else{
            //move to other side
            x = 19;
        }
        
        if(x<=19){
            x+=xSpeed;
        }else{
            //move to other side
            x = 0;
        }
        
        if(y>=0){
            y+=ySpeed;
        }else{
            //move to other side
            y = 29;
        }
        
        if(y<=29){
            y+=ySpeed;
        }else{
            //move to other side
            y = 0;
        }      
    }
    
    /**
     * equals method checks if two enemies are the same
     * they are the same if their x, y and speeds are the same
     * @param other - entity being checked
     * @return - whether they are the same
     */
    public boolean equals(Entity other){
        return x == (other).getXPos() ||
                y == (other).getYPos() || xSpeed == (other).getXSpeed()
                || ySpeed == (other).getYSpeed();
    }
    /**
     * clone method returns an enemy which is a copy of the object
     * @return - cloned enemy
     */
    public Entity clone(){
        Entity e2;
        e2 = new Enemy(image, x, y, xSpeed, ySpeed);
        return e2;
    }
    /**
     * toString method returns string listing the enemy's attributes
     * @return - the string
     */
    public String toString(){
        return "\nX Position: " + x + "\nY Position: " + y + "\nX Speed: " + 
                xSpeed + "\nY Speed: " + ySpeed;
    }
}
