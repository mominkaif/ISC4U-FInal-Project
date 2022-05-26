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
    private int texture;
    /**
     * primary constructor
     * no parameters
     * attributes set to default
     */
    public Tile(){
        hitbox = false;
        x = 0;
        y = 0;
        texture = 0;
    } 
    /**
     * Secondary constructor
     * @param hitbox - boolean for whether the player will die
     * @param x - x position of the tile
     * @param y - y position of the tile
     * @param texture - image texture of the tile
     */
    public Tile(boolean hitbox, int x, int y, int texture){
        this();
        this.hitbox = hitbox;
        this.x = x;
        this.y = y;
        this.texture = texture;
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
    public int getTexture(){
        return texture;
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
    public void setTexture(int t){
        texture = t;
    }
}
