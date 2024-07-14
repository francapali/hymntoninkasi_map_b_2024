/**
 * StartGameThread.java
 */
package ninteam_map_b.hymn_to_ninkasi.other;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import ninteam_map_b.hymn_to_ninkasi.ui.HTN_InterfacciaGioco;
import ninteam_map_b.hymn_to_ninkasi.ui.HTN_InterfacciaInizio;

/**
 * Thread che gestisce l'avvio del gioco.
 * Ferma la musica del menu, avvia una progress bar e visualizza l'interfaccia del gioco.
 * 
 * @autor michelet-NinTeam
 */
public class StartGameThread implements Runnable {

    private MusicHandler musicHTN;
    private HTN_InterfacciaGioco gioco;
    private HTN_InterfacciaInizio inizio;
    private JProgressBar progressBar;
    private ProgressBarThread progressBarThread;

    /**
     * Costruttore della classe.
     * 
     * @param progressBar La barra di progresso da aggiornare.
     * @param musicHTN Il gestore della musica.
     * @param inizio L'interfaccia di inizio del gioco.
     */
    public StartGameThread(JProgressBar progressBar, MusicHandler musicHTN, HTN_InterfacciaInizio inizio) {
        this.musicHTN = musicHTN;
        this.inizio = inizio;
        this.progressBarThread = new ProgressBarThread(progressBar);
    }

    /**
     * Metodo eseguito dal thread per avviare il gioco.
     */
    @Override
    public void run() {
        start();
    }

    /**
     * Metodo che avvia il gioco.
     * Ferma la musica del menu, avvia la progress bar e visualizza l'interfaccia del gioco.
     */
    public void start() {
        musicHTN.stopMusica(); // Ferma la musica del menu prima dell'inizio della musica del gioco
        try {
            Thread progressThread = new Thread(progressBarThread);
            progressThread.start();
            
            gioco = new HTN_InterfacciaGioco(inizio);
            progressThread.join();
            gioco.setVisible(true);
            inizio.setVisible(false);
        } catch (Exception ex) {
            musicHTN.playMusic("src\\music\\HTN_mainmenu.wav");
            JOptionPane.showMessageDialog(inizio, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
}
