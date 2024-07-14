/**
 * MusicHandler.java
 */
package ninteam_map_b.hymn_to_ninkasi.other;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Classe Music volta al controllo dell'OST di sottofondo di Hymn To Ninkasi.
 * Fornisce metodi per avviare, mettere in pausa, riprendere, fermare e regolare il volume della traccia audio,
 * nonché per riprodurre brevi clip audio.
 * 
 * Implementa Runnable per permettere la riproduzione della musica in un thread separato.
 * 
 */
public class MusicHandler implements Runnable, Serializable {

    private Clip musicHTN;
    private String filePath;

    /**
     * Avvia la riproduzione della traccia audio specificata.
     * La traccia viene riprodotta in loop continuo fino a quando non viene fermata.
     * 
     * @param filePath il percorso del file audio da riprodurre
     */
    public void playMusic(String filePath) {
        this.filePath = filePath;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            File musicFile = new File(filePath);
            musicHTN = AudioSystem.getClip();
            musicHTN.open(AudioSystem.getAudioInputStream(musicFile));
            musicHTN.loop(Clip.LOOP_CONTINUOUSLY);
            musicHTN.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            Logger.getLogger(MusicHandler.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Ferma la riproduzione della traccia audio e chiude la risorsa audio.
     */
    public void stopMusica() {
        if (musicHTN != null && musicHTN.isRunning()) {
            musicHTN.stop();
            musicHTN.close();
        }
    }

    /**
     * Mette in pausa la riproduzione della traccia audio.
     */
    public void pausaMusica() {
        if (musicHTN != null && musicHTN.isRunning()) {
            musicHTN.stop();
        }
    }

    /**
     * Riprende la riproduzione della traccia audio se è stata messa in pausa.
     */
    public void riprendiMusica() {
        if (musicHTN != null) {
            musicHTN.start();
        }
    }

    /**
     * Verifica se la traccia audio è attualmente in riproduzione.
     * 
     * @return true se la traccia audio è in riproduzione, false altrimenti
     */
    public boolean isPlaying() {
        return musicHTN != null && musicHTN.isRunning();
    }

    /**
     * Imposta il volume della traccia audio.
     * 
     * @param volume il livello del volume da impostare, in decibel (dB)
     */
    public void setVolume(float volume) {
        if (musicHTN != null) {
            FloatControl gainControl = (FloatControl) musicHTN.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(volume);
        }
    }

    /**
     * Ottiene il volume corrente della traccia audio.
     * 
     * @return il livello del volume corrente, in decibel (dB)
     */
    public float getVolume() {
        if (musicHTN != null) {
            FloatControl gainControl = (FloatControl) musicHTN.getControl(FloatControl.Type.MASTER_GAIN);
            return gainControl.getValue();
        }
        return 0.0f;
    }

    /**
     * Riproduce una breve clip audio una volta.
     * 
     * @param filePath il percorso del file audio da riprodurre
     */
    public void riproduciClip(String filePath) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(filePath)));
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            Logger.getLogger(MusicHandler.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
