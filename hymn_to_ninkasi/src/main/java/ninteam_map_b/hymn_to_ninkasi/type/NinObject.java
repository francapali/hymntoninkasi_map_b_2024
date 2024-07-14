/**
 * NinObject.java
 * 
 */
package ninteam_map_b.hymn_to_ninkasi.type;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Questa classe rappresenta un oggetto nel gioco Hymn To Ninkasi.
 * Ogni oggetto ha un identificatore univoco, un nome e una sua descrizione.
 * Gli oggetti possono avere alias (sinonimi), essere raccolti, buttati, letti,
 * usati, aperti, chiusi e possono interagire con altri oggetti.
 * 
 * @author francapali-NinTeam
 */
public class NinObject implements Serializable {

    private final int id;               // Identificatore univoco dell'oggetto
    private String name;                // Nome dell'oggetto
    private String description;         // Descrizione dell'oggetto
    private Set<String> alias;          // Alias dell'oggetto (sinonimi)

    private boolean openable = false;   // Indica se l'oggetto può essere aperto
    private boolean pickupable = false;  // Indica se l'oggetto può essere raccolto
    private boolean throwable = false;   // Indica se l'oggetto può essere buttato
    private boolean readable = false;   // Indica se l'oggetto può essere letto
    private boolean usable = false;     // Indica se l'oggetto può essere usato
    private boolean lockable = false;   // Indica se l'oggetto può essere chiuso

    private boolean open = false;       // Indica se l'oggetto è aperto
    private boolean read = false;       // Indica se l'oggetto è stato letto
    private int relatedObject = 0;    // Oggetti con cui questo oggetto può interagire

    /**
     * Costruttore per inizializzare un oggetto disponendo solo di un id specifico.
     * 
     * @param id Identificatore univoco dell'oggetto
     */
    public NinObject(int id) {
        this.id = id;
    }

    /**
     * Costruttore per inizializzare un oggetto disponendo di id e nome.
     * 
     * @param id Identificatore univoco dell'oggetto
     * @param name Nome dell'oggetto
     */
    public NinObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Costruttore per inizializzare un oggetto disponendo di id, nome e descrizione.
     * 
     * @param id Identificatore univoco dell'oggetto
     * @param name Nome dell'oggetto
     * @param description Descrizione dell'oggetto
     */
    public NinObject(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * Costruttore per inizializzare un oggetto disponendo di id, nome, descrizione e alias.
     * 
     * @param id Identificatore univoco dell'oggetto
     * @param name Nome dell'oggetto
     * @param description Descrizione dell'oggetto
     * @param alias Alias dell'oggetto
     */
    public NinObject(int id, String name, String description, Set<String> alias) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.alias = alias;
    }

    /**
     * Restituisce il nome dell'oggetto.
     * 
     * @return Nome dell'oggetto
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il nome dell'oggetto.
     * 
     * @param name Nome dell'oggetto
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Restituisce la descrizione dell'oggetto.
     * 
     * @return Descrizione dell'oggetto
     */
    public String getDescription() {
        return description;
    }

    /**
     * Imposta la descrizione dell'oggetto.
     * 
     * @param description Descrizione dell'oggetto
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Restituisce gli alias dell'oggetto.
     * 
     * @return Alias dell'oggetto
     */
    public Set<String> getAlias() {
        return alias;
    }

    /**
     * Imposta gli alias dell'oggetto.
     * 
     * @param alias Alias dell'oggetto
     */
    public void setAlias(Set<String> alias) {
        this.alias = alias;
    }

    /**
     * Imposta gli alias dell'oggetto a partire da un array di stringhe.
     * 
     * @param alias Array di alias dell'oggetto
     */
    public void setAlias(String[] alias) {
        this.alias = new HashSet<>(Arrays.asList(alias));
    }

    /**
     * Restituisce l'identificatore univoco dell'oggetto.
     * 
     * @return Identificatore univoco dell'oggetto
     */
    public int getId() {
        return id;
    }

    /**
     * Restituisce se l'oggetto può essere aperto.
     * 
     * @return true se l'oggetto può essere aperto, false altrimenti
     */
    public boolean isOpenable() {
        return openable;
    }

    /**
     * Imposta se l'oggetto può essere aperto.
     * 
     * @param openable true se l'oggetto può essere aperto, false altrimenti
     */
    public void setOpenable(boolean openable) {
        this.openable = openable;
    }

    /**
     * Restituisce se l'oggetto può essere chiuso.
     * 
     * @return true se l'oggetto può essere chiuso, false altrimenti
     */
    public boolean isLockable() {
        return lockable;
    }

    /**
     * Imposta se l'oggetto può essere chiuso.
     * 
     * @param lockable true se l'oggetto può essere chiuso, false altrimenti
     */
    public void setLockable(boolean lockable) {
        this.lockable = lockable;
    }

    /**
     * Restituisce se l'oggetto può essere raccolto.
     * 
     * @return true se l'oggetto può essere raccolto, false altrimenti
     */
    public boolean isPickupable() {
        return pickupable;
    }

    /**
     * Imposta se l'oggetto può essere raccolto.
     * 
     * @param pickupable true se l'oggetto può essere raccolto, false altrimenti
     */
    public void setPickupable(boolean pickupable) {
        this.pickupable = pickupable;
    }

    /**
     * Restituisce se l'oggetto può essere buttato.
     * 
     * @return true se l'oggetto può essere buttato, false altrimenti
     */
    public boolean isThrowable() {
        return throwable;
    }

    /**
     * Imposta se l'oggetto può essere buttato.
     * 
     * @param throwable true se l'oggetto può essere buttato, false altrimenti
     */
    public void setThrowable(boolean throwable) {
        this.throwable = throwable;
    }

    /**
     * Restituisce se l'oggetto può essere letto.
     * 
     * @return true se l'oggetto può essere letto, false altrimenti
     */
    public boolean isReadable() {
        return readable;
    }

    /**
     * Imposta se l'oggetto può essere letto.
     * 
     * @param readable true se l'oggetto può essere letto, false altrimenti
     */
    public void setReadable(boolean readable) {
        this.readable = readable;
    }

    /**
     * Restituisce se l'oggetto può essere usato.
     * 
     * @return true se l'oggetto può essere usato, false altrimenti
     */
    public boolean isUsable() {
        return usable;
    }

    /**
     * Imposta se l'oggetto può essere usato.
     * 
     * @param usable true se l'oggetto può essere usato, false altrimenti
     */
    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    /**
     * Restituisce se l'oggetto è aperto.
     * 
     * @return true se l'oggetto è aperto, false altrimenti
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * Imposta se l'oggetto è aperto.
     * 
     * @param open true se l'oggetto è aperto, false altrimenti
     */
    public void setOpen(boolean open) {
        this.open = open;
    }

    /**
     * Restituisce se l'oggetto è stato letto.
     * 
     * @return true se l'oggetto è stato letto, false altrimenti
     */
    public boolean isRead() {
        return read;
    }

    /**
     * Imposta se l'oggetto è stato letto.
     * 
     * @param read true se l'oggetto è stato letto, false altrimenti
     */
    public void setRead(boolean read) {
        this.read = read;
    }

    /**
     * Restituisce il set di oggetti con cui quest'oggetto può interagire.
     * 
     * @return Il set di oggetti con cui quest'oggetto può interagire
     */
    public int getRelatedObject() {
        return relatedObject;
    }

    /**
     * Imposta il set di oggetti con cui quest'oggetto può interagire.
     * 
     * @param relatedObjects Il nuovo set di oggetti con cui quest'oggetto può interagire
     */
    public void setRelatedObject(int relatedObject) {
        this.relatedObject = relatedObject;
    }

    /**
     * Calcola l'hash code di questo oggetto.
     * 
     * @return L'hash code di questo oggetto
     */ 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    /**
     * Confronta questo oggetto con un altro per verificarne l'uguaglianza.
     * 
     * @param obj L'oggetto da confrontare
     * @return true se gli oggetti sono uguali, false altrimenti
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NinObject other = (NinObject) obj;
        return this.id == other.id;
    }
}
