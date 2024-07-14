/**
 * NinRoom.java
 * 
 */
package ninteam_map_b.hymn_to_ninkasi.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe astratta rappresenta una stanza nel gioco Hymn To Ninkasi.
 * Ogni stanza ha un identificatore univoco, un nome e una sua descrizione.
 * Inoltre ogni stanza ha delle variabili che indicano le stanze adiacenti
 * nelle direzioni cardinali, una variabile che indica lo stato della luce
 * (accesa o spenta), e una lista di oggetti presenti all'interno.
 * 
 * @author michelet-NinTeam.
 */
public class NinRoom implements Serializable {

    private final int id;

    private String name;

    private String description;

    private String lookNorth;
    
    private String lookSouth;
    
    private String lookEast;

    private String lookWest;
    
    //private String look; //non viene usato

    private boolean visible = true; //da capire se serve dato che al momento no

    private NinRoom south = null;

    private NinRoom north = null;

    private NinRoom east = null;

    private NinRoom west = null;

    private List<Characters> characters = new ArrayList<>();

    private final List<NinObject> objects = new ArrayList<>();


    /**
     * Costruttore per inizializzare una stanza disponendo di id, nome e descrizione.
     * 
     * @param id Identificatore univoco della stanza.
     * @param name Nome della stanza.
     * @param description Descrizione della stanza.
     */
    public NinRoom(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * Restituisce il nome della stanza.
     * 
     * @return Nome della stanza.
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il nome della stanza.
     * 
     * @param name Nome della stanza.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Restituisce la descrizione della stanza.
     * 
     * @return Descrizione della stanza.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Imposta la descrizione della stanza.
     * 
     * @param description Descrizione della stanza.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Restituisce la visibilità della stanza.
     * 
     * @return Visibilità della stanza.
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Imposta la visibilità della stanza.
     * 
     * @param visible Visibilità della stanza.
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Restituisce la stanza a Sud.
     * 
     * @return Stanza a Sud.
     */
    public NinRoom getSouth() {
        return south;
    }

    /**
     * Imposta la stanza a Sud.
     * 
     * @param south Stanza a sud.
     */
    public void setSouth(NinRoom south) {
        this.south = south;
    }

    /**
     * Restituisce la stanza a Nord.
     * 
     * @return Stanza a Nord.
     */
    public NinRoom getNorth() {
        return north;
    }

    /**
     * Imposta la stanza a Nord.
     * 
     * @param north Stanza a Nord.
     */
    public void setNorth(NinRoom north) {
        this.north = north;
    }

    /**
     * Restituisce la stanza a Est.
     * 
     * @return Stanza a Est.
     */
    public NinRoom getEast() {
        return east;
    }

    /**
     * Imposta la stanza a Est.
     * 
     * @param east Stanza a Est.
     */
    public void setEast(NinRoom east) {
        this.east = east;
    }

    /**
     * Restituisce la stanza a Ovest.
     * 
     * @return Stanza a Ovest.
     */
    public NinRoom getWest() {
        return west;
    }

    /**
     * Imposta la stanza a Ovest.
     * 
     * @param west Stanza a Ovest.
     */
    public void setWest(NinRoom west) {
        this.west = west;
    }

    /**
     * Restituisce la lista di oggetti nella stanza
     * @return Lista di oggetti.
     */
    public List<NinObject> getObjects() {
        return objects;
    }

    /**
     * Restituisce la lista di personaggi nella stanza.
     * 
     * @return Lista di personaggi.
     */
    public List<Characters> getCharacters() {
        return characters;
    }

    /**
     * Restituisce l'Id della stanza.
     * 
     * @return Id della stanza.
     */
    public int getId() {
        return id;
    }

    /**
     * Genera un hash code per la stanza basato sul suo identificatore.
     * 
     * @return L'hash code della stanza.
     */


    /**
     * Verifica l'uguaglianza tra due oggetti NinRoom.
     * 
     * @param obj L'oggetto da confrontare.
     * @return True se gli oggetti sono uguali; False altrimenti.
     */
  



    /**
     * Restituisce la descrizione approfondita della stanza.
     * 
     * @return Descrizione approfondita della stanza.
     */
    /*
    public String getLook() {
        return look;
    }*/ //non serve

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NinRoom other = (NinRoom) obj;
        if (id != other.id)
            return false;
        return true;
    }

    /**
     * Imposta la descrizione approfondita della stanza.
     * 
     * @param look Descrizione approfondita della stanza.
     */
    /*
    public void setLook(String look) {
        this.look = look;
    }*/ //non serve
   
     /**
     * Restituisce la descrizione della visuale a Nord dalla stanza.
     * 
     * @return.
     */
    public String getLookNorth() {
        return lookNorth;
    }

    /**
     * Imposta la descrizione di ciò che vedi a Nord della stanza.
     * 
     * @param lookNorth Descrizione visuale a Nord della stanza.
     */
    public void setLookNorth(String lookNorth) {
        this.lookNorth = lookNorth;
    }

    /**
     * Restituisce la descrizione della visuale a Sud dalla stanza.
     * 
     * @return.
     */
    public String getLookSouth() {
        return lookSouth;
    }

    /**
     * Imposta la descrizione di ciò che vedi a Sud della stanza.
     * 
     * @param lookSouth Descrizione visuale a Sud della stanza.
     */
    public void setLookSouth(String lookSouth) {
        this.lookSouth = lookSouth;
    }

     /**
     * Restituisce la descrizione della visuale ad Est dalla stanza.
     * 
     * @return.
     */
    public String getLookEast() {
        return lookEast;
    }

    /**
     * Imposta la descrizione di ciò che vedi ad Est della stanza.
     * @param lookEast Descrizione visuale ad Ovest della stanza.
     */
    public void setLookEast(String lookEast) {
        this.lookEast = lookEast;
    }

     /**
     * Restituisce la descrizione della visuale ad Ovest dalla stanza.
     * 
     * @return.
     */
    public String getLookWest() {
        return lookWest;
    }

    /**
     * Imposta la descrizione di ciò che vedi ad Ovest della stanza.
     * 
     * @param lookWest Descrizione visuale ad Ovest della stanza.
     */
    public void setLookWest(String lookWest) {
        this.lookWest = lookWest;
    }

    /**
     * Restituisce un oggetto se il suo Id è presente nella lista di oggetti della stanza.
     * 
     * @param id Id dell'oggetto cercato.
     * @return L'oggetto se l'Id è presente; Null altrimenti.
     */
    public NinObject getObject(int id) {
        for (NinObject o : objects) {
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }

}
