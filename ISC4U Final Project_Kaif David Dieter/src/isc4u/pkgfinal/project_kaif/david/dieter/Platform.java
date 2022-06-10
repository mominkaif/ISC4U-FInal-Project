/* Platform class
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

import java.awt.Image;

/**
 *
 * @author Dieter and David
 */
public class Platform extends Entity{
    
    public Platform(){
        super();
    }
    
    public Platform(Image image, int x, int y, int xSpeed, int ySpeed){
        super(image, x, y, xSpeed, ySpeed);
    }

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

    @Override
    public boolean equals(Entity other) {
        return x == (other).getXPos() ||
                y == (other).getYPos() || xSpeed == (other).getXSpeed()
                || ySpeed == (other).getYSpeed();
    }

    @Override
    public Entity clone() {
        Entity p2;
        p2 = new Platform(image, x, y, xSpeed, ySpeed);
        return p2;
    }

    @Override
    public String toString() {
        return "Platform X Position: " + x + "\nPlatform Y Position: " + y + "\nPlatform X Speed: " + 
                xSpeed + "\nPlatform Y Speed: " + ySpeed;
    }
    
}
