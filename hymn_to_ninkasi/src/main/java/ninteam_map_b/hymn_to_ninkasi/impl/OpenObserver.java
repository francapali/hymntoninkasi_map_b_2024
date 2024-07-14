package ninteam_map_b.hymn_to_ninkasi.impl;

import java.io.Serializable;
import ninteam_map_b.hymn_to_ninkasi.type.CommandType;
import ninteam_map_b.hymn_to_ninkasi.type.NinObject;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameDesc;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameObserver;
import ninteam_map_b.hymn_to_ninkasi.parser.ParserOutput;

/**
 * Questa classe rappresenta un osservatore per il comando di apertura nel gioco.
 * Implementa l'interfaccia GameObserver.
 * @author WilliTini.
 */
public class OpenObserver implements GameObserver, Serializable {

    /**
     * Aggiorna lo stato del gioco in base all'output del parser e restituisce un messaggio di feedback.
     * 
     * @param parserOutput l'output del parser contenente il comando e l'oggetto associato
     * @param game l'oggetto GameDesc che rappresenta lo stato del gioco
     * @return il messaggio di feedback sull'azione di apertura
     */
    @Override
    public String update(ParserOutput parserOutput, GameDesc game) {
        StringBuilder msg = new StringBuilder();
        boolean found = false;
        if (parserOutput.getCommand().getType() == CommandType.OPEN) {
            game.getLastCommand().add(parserOutput.getCommand().getType());
            if (parserOutput.getObject() !=null) {
                if (game.getInventory().getSet().contains(parserOutput.getObject())) {
                    if (parserOutput.getObject().isOpenable()) {
                        if (parserOutput.getObject().isOpen()) {
                            msg.append("L'oggetto e' già aperto!");
                        } else {
                            parserOutput.getObject().setOpen(true);
                            msg.append("Hai aperto l'oggetto!");
                        }
                    } else {
                        msg.append("L'oggetto non e' apribile!");
                    }
                } else if (game.getCurrentRoom().getObjects().contains(parserOutput.getObject())) {
                    if (parserOutput.getObject().isOpen()) {
                        msg.append("L'oggetto e' già aperto!");
                    } else if (parserOutput.getObject().getName().equals("porta del bagno")){
                        for (NinObject obj : game.getInventory().getSet()) {
                            if (obj.getName().equals("chiave del bagno")) { //AGGIUNGERE SE CI SONO ALTRI OGGETTI DA APRIRE
                                parserOutput.getObject().setOpen(true);
                                found = true;
                                msg.append("Hai aperto ").append(parserOutput.getObject().getName());
                                game.getCurrentRoom().setLookEast("Sulla tua destra vedi l'imponente porta bianca del bagno aperta, forse dovresti entrarci e scoprire cosa c'e' dentro...");
                                game.getCurrentRoom().getObjects().get(0).setDescription("La porta adesso e' aperta.");
                            }
                        }
                        if (!found){
                            msg.append("Non possiedi la chiave del bagno, forse dovresti cercala in giro per la casa!");
                        }
                    } else {
                        parserOutput.getObject().setOpen(true);
                        msg.append("Hai aperto ").append(parserOutput.getObject().getName());
                    }
                } else {
                    msg.append("Non c'e' niente da aprire qui!");
                }
            } else {
                msg.append("Devi specificare un oggetto da aprire!");
            }
        }
        return msg.toString();
    }
}
