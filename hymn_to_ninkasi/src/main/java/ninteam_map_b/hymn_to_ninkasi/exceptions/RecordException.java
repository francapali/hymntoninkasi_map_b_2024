/**
 * RecordException.java
 */
package ninteam_map_b.hymn_to_ninkasi.exceptions;

/**
 * 
 * @author francapali-NinTeam
 */
public class RecordException extends Exception {

    @Override
    public String getMessage() {
        return "Errore: Invio del record al Server non avvenuto con successo\no Server momentaneamente non disponibile";
    }
}

