/* Enemy class
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

import java.awt.Image;

/**
 *
 * @author Dieter
 */
public class Enemy extends Entity{
    
    public Enemy(){
        super();
    }
    
    public Enemy(Image image, int x, int y, int xSpeed, int ySpeed){
        super(image, x, y, xSpeed, ySpeed);
    }
    
    public void move(){
        
    }
    
    public boolean equals(){
        return false;
    }
    
    public Entity clone(){
        return null;
    }
    
    public String toString(){
        return null;
    }
}
