/*
 * Class for Saving data, in our game it is the score (number of deaths)
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

/**
 *
 * @author David
 */
public class SavedData {
    private int numDeaths;
    
    public SavedData(){
        numDeaths = 0;
    }
    
    public SavedData(int numDeaths){
        this();
        this.numDeaths = numDeaths;
    }
    
    public int getScore(){
        return numDeaths;
    }
    
    public void setScore(int score){
        numDeaths = score;
    }
    
    @Override
    public String toString(){
        return "Score: " + numDeaths;
    }
    
    public Boolean equals(SavedData other){
        return numDeaths == other.getScore();
    }
    
    @Override
    public SavedData clone(){
        SavedData sD;
        sD = new SavedData(numDeaths);
        return sD;
    }
}

