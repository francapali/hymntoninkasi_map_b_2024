
package ninteam_map_b.hymn_to_ninkasi.hymntoninkasi;
import ninteam_map_b.hymn_to_ninkasi.type.Command;
import ninteam_map_b.hymn_to_ninkasi.type.NinRoom;
import ninteam_map_b.hymn_to_ninkasi.parser.*;
import ninteam_map_b.hymn_to_ninkasi.type.Inventory;
import ninteam_map_b.hymn_to_ninkasi.type.NinObject;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import ninteam_map_b.hymn_to_ninkasi.type.CommandType;

/**
 * Questa classe astratta rappresenta la descrizione di un gioco.
 * Contiene informazioni sulle stanze, i comandi, l'inventario e la stanza corrente.
 * @author WilliTini.
 */
public abstract class GameDesc implements Serializable {

    private final List<NinRoom> rooms = new ArrayList<>();

    private final List<Command> commands = new ArrayList<>();

    private final List<NinObject> listObj = new ArrayList<>();
    
    private Inventory inventory =  Inventory.getInstance();

    private NinRoom currentRoom;

    private List<CommandType> lastCommand = new ArrayList<>();

    private boolean talkTrigger = false;
    
    private boolean triviaStarted = false;
    
    private boolean correctTrivia = false;
    
    private int randomNumber;
    
    private int correctCounter = 0;

    /**
     * Restituisce la lista delle stanze del gioco.
     *
     * @return la lista delle stanze del gioco
     */
    public List<NinRoom> getRooms() {
        return rooms;
    }

    /**
     * Restituisce la lista dei comandi del gioco.
     *
     * @return la lista dei comandi del gioco
     */
    public List<Command> getCommands() {
        return commands;
    }

    /**
     * Restituisce la stanza corrente del gioco.
     *
     * @return la stanza corrente del gioco
     */
    public NinRoom getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Imposta la stanza corrente del gioco.
     *
     * @param currentRoom la stanza corrente del gioco
     */
    public void setCurrentRoom(NinRoom currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * Restituisce l'inventario del gioco.
     *
     * @return l'inventario del gioco
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Inizializza il gioco.
     *
     * @throws Exception se si verifica un errore durante l'inizializzazione del gioco
     */
    public abstract void init() throws Exception;

    /**
     * Esegue la prossima mossa del gioco.
     *
     * @param p l'output del parser
     * @param out lo stream di output
     */
    public abstract void nextMove(ParserOutput p, PrintStream out);
    
    /**
     * Restituisce il messaggio di benvenuto del gioco.
     *
     * @return il messaggio di benvenuto del gioco
     */
    public abstract String getWelcomeMsg();

    public List<NinObject> getListObj() {
        return listObj;
    }

    public List<CommandType> getLastCommand() {
        return lastCommand;
    }

    public void setTalkTrigger(boolean talkTrigger) {
        this.talkTrigger = talkTrigger;
    }

    public boolean getTalkTrigger() {
        return talkTrigger;
    }

    public boolean isTriviaStarted() {
        return triviaStarted;
    }

    public void setTriviaStarted(boolean triviaStarted) {
        this.triviaStarted = triviaStarted;
    }
    
    public void playTrivia(int id) {

    }
    
    public void printMessage(List<String> message) {
        
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public boolean isCorrectTrivia() {
        return correctTrivia;
    }

    public void setCorrectTrivia(boolean isCorrect) {
        this.correctTrivia = isCorrect;
    }

    public int getCorrectCounter() {
        return correctCounter;
    }

    public void setCorrectCounter(int correctCounter) {
        this.correctCounter = correctCounter;
    }
    
    public void incrementCounter() {
        correctCounter++;
    }
}
