package engine;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    File file;
    Clip clip;

    public Sound(String path) {
        file = new File(path);
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void playSoundLoop() {
        try{
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(this.file));
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            //Thread.sleep(clip.getMicrosecondLength()/1000);
        }
        catch(Exception e)
        {
            System.err.println("Put the music.wav file in the sound folder if you want to play background music, only optional!");
        }

    }

    public void playOnce(){
        try{
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(this.file));
            clip.start();

            //Thread.sleep(clip.getMicrosecondLength()/1000);
        }
        catch(Exception e) {
            System.err.println("Put the music.wav file in the sound folder if you want to play background music, only optional!");
        }
    }

    public void pause(){
        clip.stop();
        clip.close();
    }

}
