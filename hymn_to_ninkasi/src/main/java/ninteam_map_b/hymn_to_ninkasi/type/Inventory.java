/**
 * Inventory.java
 *
 */
package ninteam_map_b.hymn_to_ninkasi.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.LinkedHashSet;
import javax.ws.rs.core.Link;

/**
 * Questa classe rappresenta l'inventario di gioco. 
 * L'inventario è costruito come una lista di oggetti (NinObject) che possono essere
 * aggiunti, rimossi o visualizzati.
 * 
 * @author michelet-NinTeam.
 */

public class Inventory implements Serializable {

    private static final Inventory instance = new Inventory();
    private Set<NinObject> set = new LinkedHashSet<>();

    /**
     * Il costruttore vuoto e privato per la classe Singleton.
     */
    private Inventory() {

    }

    /**
     * Restituisce l'istanza unica di Inventory.
     * 
     * @return L'istanza di Inventory.
     */
    public static Inventory getInstance() {
        return instance;
    }

    /**
     * Comando getter per ottenere la lista completa degli oggetti nell'inventario.
     * 
     * @return la lista degli oggetti.
     */
    public Set<NinObject> getSet() {
        return set;
    }

    /**
     * Comando setter per impostare l'inventario ad una lista di NinObject.
     * 
     * @param list la lista di oggetti.
     */
    public void setSet(Set<NinObject> set) {
        this.set = set;
    }

    /**
     * Comando per aggiungere un singolo oggetto all'inventario.
     * 
     * @param o l'oggetto da aggiungere all'inventario.
     */
    public void add(NinObject o) {
        set.add(o);
    }

    /**
     * Comando per rimuovere un singolo oggetto dall'inventario.
     * 
     * @param o l'oggetto da rimuovere dall'inventario.
     */
    public void remove(NinObject o) {
        set.remove(o);
    }
}
