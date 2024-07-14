/**
 * ParserOutput.java
 * 
 */

package ninteam_map_b.hymn_to_ninkasi.parser;

import java.io.Serializable;
import ninteam_map_b.hymn_to_ninkasi.type.NinObject;
import ninteam_map_b.hymn_to_ninkasi.type.Command;

/**
 * Questa classe rappresenta l'output del parser del gioco Hymn To Ninkasi.
 * Contiene informazioni sul comando e sugli oggetti coinvolti nel comando.
 * 
 * @author francapali-NinTeam
 */
public class ParserOutput implements Serializable {

    private Command command;       // Il comando identificato dal parser
    private NinObject object;       // L'oggetto specifico associato al comando
    private NinObject invObject;    // L'oggetto nell'inventario associato al comando
    private String direction;       // La direzione in cui guardare con gli appositi comandi

    /**
     * Costruttore per inizializzare ParserOutput con solo l'oggetto specifico.
     *
     * @param command Il comando identificato
     * @param object L'oggetto specifico associato al comando
     */
    public ParserOutput(Command command, NinObject object) {
        this.command = command;
        this.object = object;
    }

    /**
     * Costruttore per inizializzare ParserOutput con l'oggetto specifico e l'oggetto nell'inventario.
     *
     * @param command Il comando identificato
     * @param object L'oggetto specifico associato al comando
     * @param invObject L'oggetto nell'inventario associato al comando
     */
    public ParserOutput(Command command, NinObject object, NinObject invObject, String direction) {
        this.command = command;
        this.object = object;
        this.invObject = invObject;
        this.direction = direction;
    }

    /**
     * Restituisce il comando identificato dal parser.
     *
     * @return Il comando identificato
     */
    public Command getCommand() {
        return command;
    }

    /**
     * Imposta il comando identificato dal parser.
     *
     * @param command Il comando da impostare
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * Restituisce l'oggetto specifico associato al comando.
     *
     * @return L'oggetto specifico associato al comando
     */
    public NinObject getObject() {
        return object;
    }

    /**
     * Imposta l'oggetto specifico associato al comando.
     *
     * @param object L'oggetto specifico da impostare
     */
    public void setObject(NinObject object) {
        this.object = object;
    }

    /**
     * Restituisce l'oggetto nell'inventario associato al comando.
     *
     * @return L'oggetto nell'inventario associato al comando
     */
    public NinObject getInvObject() {
        return invObject;
    }

    /**
     * Imposta l'oggetto nell'inventario associato al comando.
     *
     * @param invObject L'oggetto nell'inventario da impostare
     */
    public void setInvObject(NinObject invObject) {
        this.invObject = invObject;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }   
}
