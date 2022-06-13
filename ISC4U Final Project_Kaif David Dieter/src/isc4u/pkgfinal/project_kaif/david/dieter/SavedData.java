/* 
 * SavedData class - creates savedData object
 * Attributes: name, number of deaths
 * June 13, 2022
 * David, Dieter, Kaif
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

/**
 *
 * @author David
 */
public class SavedData {
    //number of deaths
    private int numDeaths;
    //name of user
    private String name;
    
    /**
     * primary constructor
     * @param name - name of the user
     */
    public SavedData(String name){
        this.name = name;
        numDeaths = 0;
    }
    
    /**
     * secondary constructor
     * @param numDeaths - number of deaths
     * @param name - name of the user
     */
    public SavedData(int numDeaths, String name){
        this(name);
        this.numDeaths = numDeaths;
    }
    
    /**
     * accessor method for the score
     * @return - number of deaths 
     */
    public int getScore(){
        return numDeaths;
    }
    
    /**
     * mutator method for the score
     * @param score - number of deaths
     */
    public void setScore(int score){
        numDeaths = score;
    }
    
    /**
     * accessor method for the name
     * @return - name of the user
     */
    public String getName(){
        return name;
    }
    
    /**
     * mutator method for the name
     * @param name - user's name
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * toString method
     * @return - string representation of the object
     */
    @Override
    public String toString(){
        return "\nName: " + name + "\tScore: " + numDeaths;
    }
    
    /**
     * equals method
     * @param other - another user's data
     * @return - true if its the same, otherwise false
     */
    public Boolean equals(SavedData other){
        return numDeaths == other.getScore() && name.equals(other.getName());
    }
    
    /**
     * clone method
     * @return - cloned object
     */
    @Override
    public SavedData clone(){
        SavedData sD;
        sD = new SavedData(numDeaths, name);
        return sD;
    }
}

