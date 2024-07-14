/**
 * GetScoreboardException.java
 */
package ninteam_map_b.hymn_to_ninkasi.exceptions;

/**
 * 
 * @author francapali-NinTeam
 */
public class GetScoreboardException extends Exception {

    @Override
    public String getMessage() {
        return "Errore: Richiesta della Scoreboard al Server non andata a buon fine\no Server momentaneamente non disponibile";
    }

}
