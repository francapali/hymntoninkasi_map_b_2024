/*
 * HTN_Printer.java
 */
package ninteam_map_b.hymn_to_ninkasi.ui;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.text.StyledDocument;

/**
 * Classe che gestisce la stampa animata di testo all'interno di un JTextPane.
 * Utilizza un ExecutorService per eseguire il compito di stampa in un thread separato.
 * 
 * @author francapali-NinTeam
 */
public class HTN_Printer {
    private final JTextPane textPane;
    private final ExecutorService executor;
    private final DefaultCaret caret;

    /**
     * Costruttore che inizializza il JTextPane e l'ExecutorService.
     * 
     * @param textPane il JTextPane su cui verrà stampato il testo.
     */
    public HTN_Printer(JTextPane textPane) {
        this.textPane = textPane;
        this.executor = Executors.newSingleThreadExecutor();
        this.caret = (DefaultCaret) textPane.getCaret();
    }

    /**
     * Stampa il testo nel JTextPane con un effetto di digitazione.
     * Ogni carattere viene aggiunto con un ritardo di 33 millisecondi.
     * 
     * @param text il testo da stampare.
     */
    public void print(String text) {
        executor.submit(() -> {
            try {
                // Disabilita l'aggiornamento automatico del caret
                caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

                // Ottiene il documento del JTextPane
                StyledDocument doc = textPane.getStyledDocument();

                for (char c : text.toCharArray()) {
                    // Aggiungi il testo direttamente al documento
                    SwingUtilities.invokeLater(() -> {
                        try {
                            doc.insertString(doc.getLength(), String.valueOf(c), null);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                    Thread.sleep(33); // Ritardo di 33ms tra i caratteri
                }

                // Riabilita l'aggiornamento automatico del caret e imposta la posizione alla fine del documento
                SwingUtilities.invokeLater(() -> {
                    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
                    textPane.setCaretPosition(doc.getLength());
                });
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    /**
     * Arresta immediatamente l'ExecutorService e tutti i compiti in esecuzione.
     */
    public void shutdown() {
        executor.shutdownNow();
    }
}
