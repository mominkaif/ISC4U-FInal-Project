/* Tile class
Attributes: hitbox, x, y, and texture
hitbox: false = die
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

import java.awt.Image;

/**
 *
 * @author dieter
 */
public class Tile {
    //attributes
    //Hitbox: false = die
    private boolean hitbox;
    private int x, y;
    private Image image;
    /**
     * primary constructor
     * no parameters
     * attributes set to default
     */
    public Tile(){
        hitbox = false;
        x = 0;
        y = 0;
        image = null;
    } 
    /**
     * Secondary constructor
     * @param hitbox - boolean for whether the player will die
     * @param x - x position of the tile
     * @param y - y position of the tile
     * @param texture - image texture of the tile
     */
    public Tile(boolean hitbox, int x, int y, Image texture){
        this();
        this.hitbox = hitbox;
        this.x = x;
        this.y = y;
        this.image = texture;
    }
    /**
     * accessor for hitbox status
     * @return - hitbox status (false = die)
     */
    public boolean getHitbox(){
        return hitbox;
    }
    /**
     * accessor for the x position
     * @return - x value
     */
    public int getX(){
        return x;
    }
    /**
     * accessor for y position
     * @return - y value
     */
    public int getY(){
        return y;
    }
    /**
     * accessor for the texture number
     * @return - texture number
     */
    public Image getImage(){
        return image;
    }
    /**
     * mutator for the hitbox status
     * @param h - hitbox status: false = die
     */
    public void setHitbox(boolean h){
        hitbox = h;
    }
    /**
     * mutator for the x position
     * @param n - the new x position
     */
    public void setX(int n){
        x = n;
    }
    /**
     * mutator for the y position
     * @param n - the new y position
     */
    public void setY(int n){
        y = n;
    }
    /**
     * mutator for the texture number
     * @param t - new texture number
     */
    public void setImage(Image i){
        image = i;
    }
    /**
     * equals method checks if two tiles are the same
     * they are the same if all attributes are the same
     * @param t - tile being checked
     * @return - whether or not they are the same
     */
    public boolean equals(Tile t){
        return hitbox == t.getHitbox() && x == t.getX() && y == t.getY() && image == t.getImage();
    }
    /**
     * clone method returns an identical tile
     * @return - an identical tile
     */
    public Tile clone(){
        Tile t = new Tile(hitbox, x, y, image);
        return t;
    }
    /**
     * toString method returns a string listing the tile's attributes
     * @return - the string
     */
    public String toString(){
        String message = "Hitbox: " + hitbox +"\nX: " + x + "\nY: " + y + "\nTexture: " + image;
        return message;
    }
}
