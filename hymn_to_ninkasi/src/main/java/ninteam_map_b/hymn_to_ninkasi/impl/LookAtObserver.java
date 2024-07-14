/**
 * Observer per la gestione della descrizione di un oggetto.
 * Questa classe implementa l'interfaccia GameObserve e viene utilizzata per gestire la descrizione di un oggetto nel gioco.
 * Quando viene chiamato il metodo `update`, controlla se il comando ricevuto dal parser è di tipo `LOOK_AT`.
 * Se il comando è di tipo `LOOK_AT` e la stanza corrente ha una descrizione, restituisce la descrizione della stanza.
 * Altrimenti, restituisce un messaggio di errore.
 *
 * @author WilliTini.
 */
package ninteam_map_b.hymn_to_ninkasi.impl;

import java.io.Serializable;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameDesc;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameObserver;
import ninteam_map_b.hymn_to_ninkasi.parser.ParserOutput;
import ninteam_map_b.hymn_to_ninkasi.type.CommandType;

/**
 * Observer per la gestione della descrizione di un oggetto.
 * @Author WilliTini.
 */

public class LookAtObserver implements GameObserver, Serializable {

    @Override
    public String update(ParserOutput parserOutput, GameDesc game) {
        StringBuilder msg = new StringBuilder();
        if (parserOutput.getCommand().getType() == CommandType.LOOK_AT) {
            if (parserOutput.getDirection() != null) {
                if (parserOutput.getDirection().equals(game.getCommands().get(0).getName())) {
                    msg.append(game.getCurrentRoom().getLookNorth());
                } else if (parserOutput.getDirection().equals(game.getCommands().get(1).getName())) {
                    msg.append(game.getCurrentRoom().getLookSouth());
                } else if (parserOutput.getDirection().equals(game.getCommands().get(2).getName())) {
                    msg.append(game.getCurrentRoom().getLookEast());
                } else if (parserOutput.getDirection().equals(game.getCommands().get(3).getName())) {
                    msg.append(game.getCurrentRoom().getLookWest());
                }
            } else if (game.getCurrentRoom().getDescription() != null) {
                msg.append(game.getCurrentRoom().getDescription());
            } else {
                msg.append("Non c'e' nulla d'interessante da guardare qui, mi spiace!");
            }
        }
        return msg.toString();
    }

}
