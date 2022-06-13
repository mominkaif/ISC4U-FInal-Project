/* 
 * Platform class - creates platform objects
 * Attributes: image, location, x and y speed
 * June 13, 2022
 * David, Dieter, Kaif
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

import java.awt.Image;

/**
 *
 * @author Dieter and David
 */
public class Platform extends Entity{
    
    /**
     * Primary Constructor, no parameters
     */
    public Platform(){
        super();
    }
    
    /**
     * Secondary Constructor
     * @param image - image of the platform
     * @param x - x location
     * @param y - y location
     * @param xSpeed - x speed
     * @param ySpeed - y speed
     */
    public Platform(Image image, int x, int y, int xSpeed, int ySpeed){
        super(image, x, y, xSpeed, ySpeed);
    }

    /**
     * Move method, changes the x position by the xSpeed
     */
    @Override
    public void move() {
        //allBoards[level].getTileMap()[Platform.getYPos()][Platform.getXPos].setHitbox(false);
        if(xSpeed > 0){
            x+=1;
        } else if(xSpeed == 0){
            x = x;
        } else {
            x-=1;
        }
        //allBoards[level].getTileMap()[Platform.getYPos()][Platform.getXPos].setHitbox(true);
    }

    /**
     * Equals method
     * @param other - an entity
     * @return - return true if the same, otherwise false
     */
    @Override
    public boolean equals(Entity other) {
        return x == (other).getXPos() ||
                y == (other).getYPos() || xSpeed == (other).getXSpeed()
                || ySpeed == (other).getYSpeed();
    }

    /**
     * Clone method
     * @return - the cloned platform
     */
    @Override
    public Entity clone() {
        Entity p2;
        p2 = new Platform(image, x, y, xSpeed, ySpeed);
        return p2;
    }

    /**
     * toString Method
     * @return - a string representation of the object
     */
    @Override
    public String toString() {
        return "Platform X Position: " + x + "\nPlatform Y Position: " + y + "\nPlatform X Speed: " + 
                xSpeed + "\nPlatform Y Speed: " + ySpeed;
    }
    
}
