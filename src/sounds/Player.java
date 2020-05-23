
package sounds;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Player {
    
    Clip clip;
    long clipTimePosition = 0;
    
    public void setFile(String musicLocation){
        try{
            File musicPath = new File(musicLocation);
            
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
            }else{
                System.out.println("Cannot find the file");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void playSound(){
        clip.setFramePosition(0);
        clip.start();
    }
    
    public void stopSound(){
        clip.stop();
    }
    
    public void pauseSound(){
        clipTimePosition = clip.getMicrosecondPosition();
        clip.stop();
    }
    
    public void resumeSound(){
        clip.setMicrosecondPosition(clipTimePosition);
        clip.start();
    }
    
    public void loopSound(){
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
