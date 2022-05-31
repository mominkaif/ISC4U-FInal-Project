/* Sound class
 */
package isc4u.pkgfinal.project_kaif.david.dieter;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Dieter
 */
public class Sound {

    private File file;
    private boolean loop;
    private Clip clip;
    
    public Sound() {
        file = null;
        loop = false;
    }
    
    public Sound(File file, boolean loop) {
        this.file = file;
        this.loop = loop;
    }
    
    public File getFile() {
        return file;
    }
    
    public boolean getLoop() {
        return loop;
    }
    
    public void setFile(File f) {
        file = f;
    }
    
    public void setLoop(boolean l) {
        loop = l;
    }
    
    public void play() {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
            if (loop) {
                clip.loop(clip.LOOP_CONTINUOUSLY);
            }
        } catch (Exception e) {
            
        }
    }
    
    public void stop() {
        clip.stop();
    }
}
