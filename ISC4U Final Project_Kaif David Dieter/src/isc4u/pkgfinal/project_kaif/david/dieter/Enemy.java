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
        if(x>=0){
            x+=xSpeed;
        }else{
            //move to other side
            x = 608;
        }
        
        if(x<=608){
            x+=xSpeed;
        }else{
            //move to other side
            x = 0;
        }
        
        if(y>=0){
            y+=ySpeed;
        }else{
            //move to other side
            y = 928;
        }
        
        if(y<=928){
            y+=ySpeed;
        }else{
            //move to other side
            y = 0;
        }
        
    }
    
    public boolean equals(Entity e){
        return false;
    }
    
    public Entity clone(){
        return null;
    }
    
    public String toString(){
        return null;
    }
}
