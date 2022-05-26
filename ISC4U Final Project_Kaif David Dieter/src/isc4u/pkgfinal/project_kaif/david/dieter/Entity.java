/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

/**
 *
 * @author daxu2195
 */
public abstract class Entity {
    private int imageID;
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;
    
    public Entity(){
        imageID = 0;
        x = 0;
        y = 0;
        xSpeed = 0;
        ySpeed = 0; 
    }
    public Entity(int imageID, int x, int y, int xSpeed, int ySpeed){
        this();
        this.imageID = imageID;
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.y = ySpeed;
    }
    
    public int getImageID(){
        return imageID;
    }
    
    public int getXPos(){
        return x;
    }
    
    public int getYPos(){
        return y;
    }
    
    public int getXSpeed(){
        return xSpeed;
    }
    
    public int getYSpeed(){
        return ySpeed;
    }
    
    public void setImageID(int other){
        imageID = other;
    }
    
    public void setXPos(int other){
        x = other;
    }
    
    public void setYPos(int other){
        y = other;
    }
    
    public void setXSpeed(int other){
        xSpeed = other;
    }
    
    public void setYSpeed(int other){
        ySpeed = other;
    }
    
    public abstract void move();
    
    public abstract boolean equals(Entity other);
    
    public abstract Entity clone();
    
    public abstract String toString();
}
