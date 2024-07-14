/*
 * Parser.java
 *
 */

package ninteam_map_b.hymn_to_ninkasi.parser;

import java.io.Serializable;
import ninteam_map_b.hymn_to_ninkasi.type.Utils;
import ninteam_map_b.hymn_to_ninkasi.type.NinObject;
import ninteam_map_b.hymn_to_ninkasi.type.Command;

import java.util.List;
import java.util.Set;
import ninteam_map_b.hymn_to_ninkasi.type.Inventory;
import ninteam_map_b.hymn_to_ninkasi.type.NinRoom;

/**
 * La classe Parser gestisce l'analisi dei comandi dell'utente.
 * Riconosce i comandi e gli oggetti menzionati dal giocatore
 * traducendoli in istruzioni comprensibili dal gioco.
 * 
 * @author francapali-NinTeam
 */
public class Parser implements Serializable {
    
    private final Set<String> stopwords;
    
    /**
     * Costruttore della classe Parser.
     * 
     * @param stopwords insieme di parole da ignorare durante l'analisi
     */
    public Parser(Set<String> stopwords) {
        this.stopwords = stopwords;
    }
    
    /**
     * Verifica se un token corrisponde a un comando nell'elenco dei comandi.
     * 
     * @param token il token da verificare
     * @param commands la lista dei comandi disponibili
     * @return l'indice del comando trovato, altrimenti -1.
     */
    private int checkForCommand(String token, List<Command> commands) {
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).getName().equals(token) || commands.get(i).getAlias().contains(token)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Verifica se un token corrisponde ad un oggetto nell'elenco degli oggetti.
     * 
     * @param token il token da verificare
     * @param objects la lista degli oggetti disponibili
     * @return l'indice dell'oggetto trovato, altrimenti -1
     */
    private int checkForObject(String token, List<NinObject> objects) {
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getName().equals(token) || objects.get(i).getAlias().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Verifica se un token corrisponde ad un oggetto nell'elenco degli oggetti.
     * 
     * @param token il token da verificare
     * @param objects la lista degli oggetti disponibili
     * @return l'indice dell'oggetto trovato, altrimenti -1
     */
    private NinObject checkForObject(String token, Set<NinObject> objects) {
        for (NinObject obj : objects) {
            if (obj.getName().equals(token) || obj.getAlias().contains(token)) {
                return obj;
            }
        }
        return null;
    }
    
    /**
     * Analizza un comando dell'utente e restituisce un oggetto ParserOutput
     * che rappresenta il risultato dell'analisi.
     * 
     * @param command il comando dell'utente
     * @param commands la lista dei comandi disponibili
     * @param objects la lista degli oggetti disponibili
     * @param inventory la lista degli oggetti nell'inventario
     * @return un oggetto ParserOutput che rappresenta il risultato dell'analisi
     */
    public ParserOutput parse(String command, List<Command> commands, List<NinObject> objects, Inventory inventory, List<NinRoom> rooms) {
        List<String> tokens = Utils.parseString(command, stopwords);
        if (tokens.isEmpty()) {
            return null;
        }

        int commandIndex = checkForCommand(tokens.get(0), commands);
        if (commandIndex == -1) {
            return new ParserOutput(null, null);
        }

        // Memorizza l'oggetto trovato nella lista degli oggetti disponibili
        NinObject object = null;
        
        // Memorizza l'oggetto trovato nella lista dell'inventario
        NinObject inventoryItem = null;
        
        String direction = null;
        
        if (tokens.size() > 1) {
            object = findObject(tokens, objects, 1);
            if (object == null) {
                inventoryItem = findObject(tokens, inventory.getSet(), 1);
                if (inventoryItem == null) {
                    int directionIndex = checkForCommand(tokens.get(1), commands);
                    if (directionIndex >= 0 && directionIndex <= 3) {
                        direction = commands.get(directionIndex).getName();
                    }
                }
            }
        }

        return new ParserOutput(commands.get(commandIndex), object, inventoryItem, direction);
    }

    /**
     * Trova un oggetto nella lista degli oggetti a partire da una lista di token.
     * 
     * Questo metodo esamina i token a partire da un indice specificato e cerca 
     * un oggetto corrispondente nella lista degli oggetti disponibili. Se viene 
     * trovato un oggetto che corrisponde a uno dei token, l'oggetto viene restituito.
     * 
     * @param tokens la lista di token derivati dal comando dell'utente
     * @param objects la lista degli oggetti disponibili
     * @param startIndex l'indice di partenza nei token da cui iniziare la ricerca
     * @return l'oggetto trovato nella lista degli oggetti, altrimenti null se nessun oggetto corrisponde ai token
     */
    private NinObject findObject(List<String> tokens, List<NinObject> objects, int startIndex) {
        for (int i = startIndex; i < tokens.size(); i++) {
            int index = checkForObject(tokens.get(i), objects);
            if (index != -1) {
                return objects.get(index);
            }
        }
        return null;
    }
    
    /**
     * Trova un oggetto nella lista degli oggetti a partire da una lista di token.
     * 
     * Questo metodo esamina i token a partire da un indice specificato e cerca 
     * un oggetto corrispondente nella lista degli oggetti disponibili. Se viene 
     * trovato un oggetto che corrisponde a uno dei token, l'oggetto viene restituito.
     * 
     * @param tokens la lista di token derivati dal comando dell'utente
     * @param objects la lista degli oggetti disponibili
     * @param startIndex l'indice di partenza nei token da cui iniziare la ricerca
     * @return l'oggetto trovato nella lista degli oggetti, altrimenti null se nessun oggetto corrisponde ai token
     */
    private NinObject findObject(List<String> tokens, Set<NinObject> objects, int startIndex) {
        for (int i = startIndex; i < tokens.size(); i++) {
            NinObject obj = checkForObject(tokens.get(i), objects);
            if (obj != null) {
                return obj;
            }
        }
        return null;
    }
    
    private int checkForDirection(String token, List<NinRoom> rooms) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getName().equals(token)) {
                return i;
            } else {
            }
        }
        return -1;
    }
}
