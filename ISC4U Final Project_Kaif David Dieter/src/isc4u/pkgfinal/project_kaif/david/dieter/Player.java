/* Player Class
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

/**
 *
 * @author dieter
 */
public class Player extends Entity{
    static final int MOVE_DISTANCE = 5;
    /**
     * Primary Player Constructor, chain with super to initialize values
     */
    public Player(){
        super();
    }
    /**
     * 
     * @param moveDistance
     * @param imageID
     * @param x
     * @param y
     * @param xSpeed
     * @param ySpeed 
     */
    public Player (int imageID, int x, int y, int xSpeed, int ySpeed){
        super(imageID, x, y, xSpeed, ySpeed);
    }
    /**
     * Accessor for moveDistance of player
     * @return - moveDistance
     */
    public int getMoveDistance(){
        return MOVE_DISTANCE;
    }
    
    @Override
    public void move() {
        switch (keyPressed){
            case UP
        }
    }

    @Override
    /**
     * Compares all attributes (moveDistance, imageID, x, y, xSpeed, ySpeed)
     * of current Player to other Player
     * @param - other Entity
     * return - true or false 
     */
    public boolean equals(Entity other) {
        return imageID == ((Player)other).getImageID() || x == ((Player)other).getXPos() ||
                y == ((Player)other).getYPos() || xSpeed == ((Player)other).getXSpeed()
                || ySpeed == ((Player)other).getYSpeed();
    }

    @Override
    /**
     * 
     */
    public Entity clone() {
        Entity p2;
        p2 = new Player(imageID, x, y, xSpeed, ySpeed);
        return p2;
    }

    @Override
    public String toString() {
        return "Move Distance: " + MOVE_DISTANCE + "\nImage ID: " + imageID + 
               "\nX Position: " + x + "\nY Position: " + y + "\nX Speed: " + 
                xSpeed + "\nY Speed: " + ySpeed;
    }
    
}
