/**
 * Scoreboard.java
 */
package ninteam_map_b.hymn_to_ninkasi.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta una tabella dei punteggi.
 * Contiene informazioni sull'ID, nome del giocatore, tempo impiegato e data.
 * 
 * @autor francapali-NinTeam
 */
public class Scoreboard implements Serializable {

    int newid;
    String name;
    String timeSpent;
    String date;
    
    /**
     * Costruttore della classe con parametri.
     * 
     * @param newid L'ID del punteggio.
     * @param name Il nome del giocatore.
     * @param timeSpent Il tempo impiegato.
     * @param date La data del punteggio.
     */
    public Scoreboard(int newid, String name, String timeSpent, String date) {
        this.newid = newid;
        this.name = name;
        this.timeSpent = timeSpent;
        this.date = date;
    }
    
    /**
     * Costruttore di default della classe.
     */
    public Scoreboard() {
        
    }

    /**
     * Ottiene l'ID del punteggio.
     * 
     * @return int L'ID del punteggio.
     */
    public int getNewid() {
        return newid;
    }

    /**
     * Imposta l'ID del punteggio.
     * 
     * @param newid L'ID del punteggio.
     */
    public void setNewid(int newid) {
        this.newid = newid;
    }

    /**
     * Ottiene il nome del giocatore.
     * 
     * @return String Il nome del giocatore.
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il nome del giocatore.
     * 
     * @param name Il nome del giocatore.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Ottiene il tempo impiegato.
     * 
     * @return String Il tempo impiegato.
     */
    public String getTimeSpent() {
        return timeSpent;
    }

    /**
     * Imposta il tempo impiegato.
     * 
     * @param timeSpent Il tempo impiegato.
     */
    public void setTimeSpent(String timeSpent) {
        this.timeSpent = timeSpent;
    }

    /**
     * Ottiene la data del punteggio.
     * 
     * @return String La data del punteggio.
     */
    public String getDate() {
        return date;
    }

    /**
     * Imposta la data del punteggio.
     * 
     * @param date La data del punteggio.
     */
    public void setDate(String date) {
        this.date = date;
    }
}
