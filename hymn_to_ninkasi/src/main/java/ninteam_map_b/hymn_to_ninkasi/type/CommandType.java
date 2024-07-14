/**
 * CommandType.java
 * 
 */
package ninteam_map_b.hymn_to_ninkasi.type;

/**
 * Enum che rappresenta i vari tipi di comando utilizzabili in Hymn To Ninkasi.
 * Ogni comando corrisponde ad un'azione che il giocatore pu� eseguire.
 * 
 * @author francapali-NinTeam
 */
public enum CommandType {
    
    /**
     * Comando per terminare il gioco.
     */
    END,
    
    /**
     * Comando per visualizzare l'inventario.
     */
    INVENTORY,
    
    /**
     * Comando per muoversi verso Nord.
     */
    NORTH,
    
    /**
     * Comando per muoversi verso Sud.
     */
    SOUTH,
    
    /**
     * Comamndo per muoversi verso Est.
     */
    EAST,
    
    /**
     * Comando per muoversi verso Ovest.
     */
    WEST,
    
    /**
     * Comando per aprire un oggetto.
     */
    OPEN,
    
    /**
     * Comando per chiudere un oggetto.
     */
    CLOSE,
    
    /**
     * Comando per camminare verso una destinazione.
     */
    WALK_TO,
    
    /**
     * Comando per raccogliere un oggetto.
     */
    PICK_UP,
    
    /**
     * Comando per parlare con un personaggio.
     */
    TALK_TO,
    
    /**
     * Comando per dare un oggetto a un personaggio.
     */
    GIVE,
    
    /**
     * Comando per osservare un oggetto.
     */
    LOOK_AT,
    
    /**
     * Comando per accendere un oggetto.
     */
    TURN_ON,
    
    /**
     * Comando per spegnere un oggetto.
     */
    TURN_OFF,
    
    /**
     * Comando per leggere un oggetto.
     */
    READ,
    
    /**
     * Comando per usare un oggetto.
     */
    USE,
    
    /**
     * Comando per esaminare un oggetto.
     */
    EXAMINE,
    
    /**
     * Comando per salvare la partita.
     */
    SAVE,
    
    /**
     * Comando per selezionare prima scelta di dialogo.
     */
    UNO,

    /**
     * Comando per selezionare seconda scelta di dialogo.
     */
    DUE,
    /**
     * Comando per caricare una partita salvata.
     */
    LOAD,

    /** 
     * Comando per selezionare prima scelta di dialogo.
     */
    HELP,

    /**
     * Comando per giocare a diversi minigiochi
     */
    PLAY
    
}