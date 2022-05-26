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
    private ArrayList<entity> entityList;
    private static final int width = 10;
    private static final int height = 15;
    
    public Board(){
        tilemap = new Tile[width][height];
        sountrack = null;
        entityList = new ArrayList();
    }
    
    public Board(Sound soundtrack, ArrayList entityList){
        this();
        this.soundtrack = soundtrack; 
        this.entityList = entityList;
    }
    
    
}
