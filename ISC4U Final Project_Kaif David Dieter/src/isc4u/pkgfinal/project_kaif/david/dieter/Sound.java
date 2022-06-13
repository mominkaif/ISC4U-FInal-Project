/* 
 * Sound class - creates sound object
 * Attributes: file for the sound and boolean loop
 * June 13, 2022
 * David, Dieter, Kaif
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
    /**
     * sound constructor
     * no parameters
     */
    public Sound() {
        file = null;
        loop = false;
    }
    /**
     * secondary constructor
     * @param file - sound file being played (.wav)
     * @param loop - boolean whether or not to loop
     */
    public Sound(File file, boolean loop) {
        this.file = file;
        this.loop = loop;
    }
    /**
     * accessor for the file
     * @return - sound file
     */
    public File getFile() {
        return file;
    }
    /**
     * accessor for the loop status
     * @return - boolean loop
     */
    public boolean getLoop() {
        return loop;
    }
    /**
     * mutator for the file
     * @param f - new file
     */
    public void setFile(File f) {
        file = f;
    }
    /**
     * mutator for the loop boolean
     * @param l - new loop
     */
    public void setLoop(boolean l) {
        loop = l;
    }
    /**
     * play method
     * plays the sound
     * if looping, it will loop
     */
    public void play() {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
            System.out.println("playing clip "+file);
            if (loop) {
                clip.loop(clip.LOOP_CONTINUOUSLY);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**
     * stop method
     * stops playing the sound
     */
    public void stop() {
        clip.stop();
    }
}
