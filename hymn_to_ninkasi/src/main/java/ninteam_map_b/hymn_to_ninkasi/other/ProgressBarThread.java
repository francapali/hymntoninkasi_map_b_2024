/**
 * ProgressBarThread.java
 */
package ninteam_map_b.hymn_to_ninkasi.other;

import javax.swing.JProgressBar;
import ninteam_map_b.hymn_to_ninkasi.ui.HTN_InterfacciaInizio;

/**
 * Thread che gestisce l'aggiornamento di una barra di progresso (JProgressBar).
 * Incrementa il valore della barra di progresso a intervalli regolari fino a completamento.
 * 
 * @autor michelet & francapali-NinTeam
 */
public class ProgressBarThread implements Runnable {
    private JProgressBar progressBar;
    private int progressValue;

    /**
     * Costruttore della classe.
     * 
     * @param progressBar La barra di progresso da aggiornare.
     */
    public ProgressBarThread(JProgressBar progressBar) {
        this.progressBar = progressBar;
        this.progressValue = 0;
    }

    /**
     * Metodo eseguito dal thread per aggiornare la barra di progresso.
     */
    @Override
    public void run() {
        while (progressValue < 100) {
            progressValue += 1.5;
            progressBar.setValue(progressValue);
            try {
                Thread.sleep(118); // Aggiorna la progress bar ogni 50 millisecondi
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
