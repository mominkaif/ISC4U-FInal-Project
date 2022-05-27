/* Sound class
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

import java.io.File;

/**
 *
 * @author Dieter
 */
public class Sound {
    private File file;
    private boolean loop;
    
    public Sound(){
        file = null;
        loop = false;
    }
    
    public Sound(File file, boolean loop){
        this.file = file;
        this.loop = loop;
    }
    
    public File getFile(){
        return file;
    }
    
    public boolean getLoop(){
        return loop;
    }
    
    public void setFile(File f){
        file = f;
    }
    
    public void setLoop(boolean l){
        loop = l;
    }
    
    public void play(){
        
    }
    
    public void stop(){
        
    }
}