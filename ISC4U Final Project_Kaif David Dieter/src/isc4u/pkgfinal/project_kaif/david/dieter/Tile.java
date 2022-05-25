/* Tile class
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
     * @return 
     */
    public boolean getHitbox(){
        return hitbox;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getTexture(){
        return texture;
    }
    
    public void setHitbox(boolean h){
        hitbox = h;
    }
    
    public void setX(int n){
        x = n;
    }
    
    public void setY(int n){
        y = n;
    }
    
    public void setTexture(Image t){
        texture = t;
    }
}
