/*
 * TimeSpent.java
 */
package ninteam_map_b.hymn_to_ninkasi.other;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import ninteam_map_b.hymn_to_ninkasi.type.Scoreboard;

/**
 * Classe che gestisce il tempo di gioco dell'utente.
 * Tiene traccia del tempo di gioco e permette di salvarlo.
 * 
 * @autor francapali-NinTeam
 */
public class TimeSpent implements Serializable {
    private static final TimeSpent INSTANCE = new TimeSpent();
    private Instant inizioGioco;
    private long ore;
    private long secondi;
    private long minuti;
    private String stringOre;
    private String stringMinuti;
    private String stringSecondi;
    private String stringTimeSpent;
    private boolean timeOn = false;
    private Scoreboard scoreboard = new Scoreboard();

    /**
     * Costruttore della classe.
     */
    public TimeSpent() { }

    /**
     * Ottiene l'istanza singleton della classe TimeSpent.
     * 
     * @return INSTANCE L'istanza singleton della classe TimeSpent.
     */
    public static TimeSpent getInstance() {
        return INSTANCE;
    }

    /**
     * Inizia a tenere traccia del tempo di gioco.
     */
    public void startTime() {
        if (!timeOn) {
            inizioGioco = Instant.now();
            timeOn = true;
        }
    }

    /**
     * Aggiorna il tempo totale di gioco.
     */
    public void updateFinalTime() {
        Instant now = Instant.now();
        Duration tempoTotale = Duration.between(inizioGioco, now);

        ore = tempoTotale.toHours();
        secondi = tempoTotale.toSecondsPart();
        minuti = tempoTotale.toMinutesPart();

        stringOre = String.format("%02d", ore);
        stringMinuti = String.format("%02d", minuti);
        stringSecondi = String.format("%02d", secondi);
    }

    /**
     * Salva e stampa il tempo di gioco finale.
     * 
     * @return Scoreboard L'oggetto Scoreboard con il tempo di gioco salvato.
     */
    public Scoreboard saveTimeSpent() {
        stringTimeSpent = stringOre + ":" + stringMinuti + ":" + stringSecondi;
        scoreboard.setTimeSpent(stringTimeSpent);
        resetTime();
        return scoreboard;
    }

    /**
     * Resetta il tempo di gioco.
     */
    public void resetTime() {
        timeOn = false;
        ore = 0;
        secondi = 0;
        minuti = 0;

        stringOre = String.format("%02d", ore);
        stringMinuti = String.format("%02d", minuti);
        stringSecondi = String.format("%02d", secondi);
    }
}
