package ninteam_map_b.hymn_to_ninkasi.impl;

import java.io.Serializable;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameDesc;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameObserver;
import ninteam_map_b.hymn_to_ninkasi.parser.ParserOutput;
import ninteam_map_b.hymn_to_ninkasi.type.CommandType;
import ninteam_map_b.hymn_to_ninkasi.type.NinObject;

/**
 * Observer per la gestione dell'inventario del giocatore.
 * @author WilliTini.
 */
public class InventoryObserver implements GameObserver, Serializable {

    @Override
    public String update(ParserOutput parserOutput, GameDesc game) {
        StringBuilder msg = new StringBuilder();
         if (parserOutput.getCommand().getType() == CommandType.INVENTORY) {
            if (game.getInventory().getSet().isEmpty()) {
                msg.append("Il tuo inventario e' vuoto");
            } else {
                msg.append("Nel tuo inventario ci sono:\n");
                for (NinObject o : game.getInventory().getSet()) {
                    msg.append(o.getName()).append("\n");
                }
            }
        }
        return msg.toString();
    }

}
