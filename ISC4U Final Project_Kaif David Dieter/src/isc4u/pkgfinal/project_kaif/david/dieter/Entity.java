/* abstract entity
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

import java.awt.Image;

/**
 *
 * @author daxu2195
 */
public abstract class Entity {
    protected Image image;
    protected int x;
    protected int y;
    protected int xSpeed;
    protected int ySpeed;
    /**
     * entity constructor
     * no parameters
     */
    public Entity(){
        image = null;
        x = 0;
        y = 0;
        xSpeed = 0;
        ySpeed = 0; 
    }
    /**
     * entity constructor
     * includes all parameters
     * @param imageID - image number
     * @param x - x location
     * @param y - y location
     * @param xSpeed - xspeed
     * @param ySpeed - yspeed
     */
    public Entity(Image image, int x, int y, int xSpeed, int ySpeed){
        this();
        this.image = image;
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.y = ySpeed;
    }
    /**
     * accessor for the image id number
     * @return - image id number
     */
    public Image getImage(){
        return image;
    }
    /**
     * accessor for the x position
     * @return - the x position
     */
    public int getXPos(){
        return x;
    }
    /**
     * accessor for the y position
     * @return - the y position
     */
    public int getYPos(){
        return y;
    }
    /**
     * accessor for the x speed
     * @return - x speed
     */
    public int getXSpeed(){
        return xSpeed;
    }
    /**
     * accessor for the y speed
     * @return - y speed
     */
    public int getYSpeed(){
        return ySpeed;
    }
    /**
     * mutator for the image id
     * @param other - new image id
     */
    public void setImage(Image other){
        image = other;
    }
    /**
     * mutator for the x position
     * @param other - new x position
     */
    public void setXPos(int other){
        x = other;
    }
    /**
     * mutator for the y position
     * @param other - new y position
     */
    public void setYPos(int other){
        y = other;
    }
    /**
     * mutator for the x speed
     * @param other - new x speed
     */
    public void setXSpeed(int other){
        xSpeed = other;
    }
    /**
     * mutator for the y speed
     * @param other - new y speed
     */
    public void setYSpeed(int other){
        ySpeed = other;
    }
    /**
     * abstract method will determine how the entity will move
     */
    public abstract void move();
    /**
     * checks if two entities are equal
     * @param other - entity being checked
     * @return - whether they are equal
     */
    public abstract boolean equals(Entity other);
    /**
     * returns a cloned entity
     * @return - cloned entity
     */
    public abstract Entity clone();
    /**
     * tostring method returns string listing attributes
     * @return - string
     */
    public abstract String toString();
}
