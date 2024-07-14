/**
 * MoveObserver.java
 **/
package ninteam_map_b.hymn_to_ninkasi.impl;

import java.io.Serializable;
import ninteam_map_b.hymn_to_ninkasi.type.CommandType;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameDesc;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameObserver;
import ninteam_map_b.hymn_to_ninkasi.parser.ParserOutput;
import ninteam_map_b.hymn_to_ninkasi.type.Characters;

/**
 * Questa classe implementa l'interfaccia GameObserve e rappresenta un osservatore per il movimento del giocatore nel gioco.
 * Viene utilizzata per aggiornare il messaggio di risposta in base al comando di movimento inserito dal giocatore.
 * @author WilliTini.
 */
public class MoveObserver implements GameObserver, Serializable {
    private boolean exit = false;
    
    /**
     * Aggiorna il messaggio di risposta in base al comando di movimento inserito dal giocatore.
     * Restituisce il messaggio di risposta aggiornato.
     *
     * @param parserOutput l'output del parser che contiene il comando inserito dal giocatore
     * @param game         l'oggetto GameDesc che rappresenta lo stato corrente del gioco
     * @return il messaggio di risposta aggiornato
     */
    @Override
    public String update(ParserOutput parserOutput, GameDesc game) {
        StringBuilder msg = new StringBuilder();
        if (parserOutput.getCommand().getType() == CommandType.NORTH) {
            if (game.getCurrentRoom().getNorth() != null) {
                game.setCurrentRoom(game.getCurrentRoom().getNorth());
                msg.append("Ti trovi in " + game.getCurrentRoom().getName() + ".\n" + game.getCurrentRoom().getDescription());
            } else {
                msg.append("Non puoi andare li'." + game.getCurrentRoom().getLookNorth());
            }
        } else if (parserOutput.getCommand().getType() == CommandType.EAST) {
            if ("Ingresso".equals(game.getCurrentRoom().getName())){
                if (exit) {
                    game.setCurrentRoom(null);
                } else {
                    msg.append("Vuoi davvero andartene?");
                    exit = true;
                }
            } else if (game.getCurrentRoom().getEast() != null) {
                if ("Salotto".equals(game.getCurrentRoom().getName())){ //controllo se la stanza è il salotto, se si, controllo se la porta del bagno è aperta
                    if (game.getCurrentRoom().getObjects().get(0).isOpen()) {
                        game.setCurrentRoom(game.getCurrentRoom().getEast());
                        msg.append("Ti trovi in " + game.getCurrentRoom().getName() + ".\n" + game.getCurrentRoom().getDescription());
                    } else {
                        msg.append("La porta e' chiusa, non puoi andare li'.\n" + game.getCurrentRoom().getLookEast());
                    }
                } else {
                    game.setCurrentRoom(game.getCurrentRoom().getEast());
                    msg.append("Ti trovi in " + game.getCurrentRoom().getName() + ".\n" + game.getCurrentRoom().getDescription());
                }
            } else {
                msg.append("Non puoi andare li'." + game.getCurrentRoom().getLookEast());
            } 
        } else if (parserOutput.getCommand().getType() == CommandType.SOUTH) {
            if (game.getCurrentRoom().getSouth() != null) {
                game.setCurrentRoom(game.getCurrentRoom().getSouth());
                msg.append("Ti trovi in " + game.getCurrentRoom().getName() + ".\n" + game.getCurrentRoom().getDescription());
            } else {
                msg.append("Non puoi andare li'." + game.getCurrentRoom().getLookSouth());
            }
        } else if (parserOutput.getCommand().getType() == CommandType.WEST) {
            if (game.getCurrentRoom().getWest() != null) {
                game.setCurrentRoom(game.getCurrentRoom().getWest());
                msg.append("Ti trovi in " + game.getCurrentRoom().getName() + ".\n" + game.getCurrentRoom().getDescription());
            } else {
                msg.append("Non puoi andare li'." + game.getCurrentRoom().getLookWest());
            }
        }
        return msg.toString();
    }
}
