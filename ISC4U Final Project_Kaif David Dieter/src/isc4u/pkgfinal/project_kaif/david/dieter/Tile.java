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
    private boolean hitbox;
    private int x, y;
    private Image texture;
    
    public Tile(){
        hitbox = false;
        x = 0;
        y = 0;
        texture = null;
    }
    
    public Tile(boolean hitbox, int x, int y, Image texture){
        this.hitbox = hitbox;
        this.x = x;
        this.y = y;
        this.texture = texture;
    }
    
}
