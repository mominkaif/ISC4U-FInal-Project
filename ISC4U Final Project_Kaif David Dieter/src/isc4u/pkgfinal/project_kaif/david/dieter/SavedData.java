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
    private String name;
    
    public SavedData(String name){
        this.name = name;
        numDeaths = 0;
    }
    
    public SavedData(int numDeaths, String name){
        this(name);
        this.numDeaths = numDeaths;
    }
    
    public int getScore(){
        return numDeaths;
    }
    
    public void setScore(int score){
        numDeaths = score;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    @Override
    public String toString(){
        return "\nName: " + name + "\tScore: " + numDeaths;
    }
    
    public Boolean equals(SavedData other){
        return numDeaths == other.getScore() && name.equals(other.getName());
    }
    
    @Override
    public SavedData clone(){
        SavedData sD;
        sD = new SavedData(numDeaths, name);
        return sD;
    }
}

