/* Board class
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

import java.util.ArrayList;

/**
 *
 * @author Dieter
 */
public class Board {
    private Tile[][] tilemap;
    private Sound soundtrack;
    private ArrayList <Entity> entityList;
    private static final int width = 20;
    private static final int height = 30;
    
    /**
     * primary board constructor
     * no parameters
     */
    public Board(){
        tilemap = new Tile[width][height];
        soundtrack = null;
        entityList = new ArrayList();
    }
    /**
     * secondary board constructor
     * includes all attributes
     * @param tM - 2d tile array for the map
     * @param soundtrack - sound object for the soundtrack
     * @param entityList - array list of entities
     */
    public Board(Tile[][] tM, Sound soundtrack, ArrayList entityList){
        this();
        this.tilemap = tM;
        this.soundtrack = soundtrack; 
        this.entityList = entityList;
    }
    /**
     * accessor for the tilemap
     * @return - 2d tile array
     */
    public Tile[][] getTile(){
        return tilemap;
    }
    /**
     * accessor for the soundtrack
     * @return - soundtrack
     */
    public Sound getSoundtrack(){
        return soundtrack;
    }
    /**
     * accessor for the entity list
     * @return - array list of entities
     */
    public ArrayList getEntityList(){
        return entityList;
    }
    /**
     * tile mutator
     * single so that you don't have to make a new array to change 1 tile
     * @param t - new tile object
     * @param x - x location
     * @param y - y location
     */
    public void setTile(Tile t, int x, int y){
        tilemap[x][y] = t;
    }
    /**
     * mutator for the soundtrack
     * @param s - new soundtrack
     */
    public void setSoundtrack(Sound s){
        soundtrack = s;
    }
    /**
     * mutator for entities
     * @param e - entity
     * @param i - index in the entitylist
     */
    public void setEntity(Entity e, int i){
        entityList.set(i,e);
    }
    
    
    public void drawBoard(){
        
    }
    
    
    /**
     * equals method checks if two boards are the same
     * @param b - board being checked
     * @return - whether or not they are the same
     */
    public boolean equals(Board b){
        return b.getTile().equals(tilemap) && b.getSoundtrack().equals(soundtrack) && b.getEntityList().equals(entityList);
    }
    /**
     * clone method returns a cloned board
     * @return - cloned board 
     */
    public Board clone(){
        Board b = new Board(tilemap, soundtrack, entityList);
        return b;
    }
    /**
     * toString method returns a string listing the board's attributes
     * @return - the string
     */
    public String toString(){
        String message = "";
        String tiles = "\n\nTiles";
        String entities = "\n\nEntities";
        message += "Board\n+Soundtrack: \n" + soundtrack.toString();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                tiles += "\nTile "+i+" "+j+"\n"+tilemap[i][j].toString();
            }
        }
        message += tiles;
        for (Entity entity: entityList) {
            entities += "\n"+entity.toString();
        }
        message += entities;
        return message;
    }
}
