package ninteam_map_b.hymn_to_ninkasi.impl;

import java.io.Serializable;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameDesc;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameObserver;
import ninteam_map_b.hymn_to_ninkasi.parser.ParserOutput;
import ninteam_map_b.hymn_to_ninkasi.type.CommandType;

/**
 * Questa classe rappresenta un osservatore per l'azione di esaminare degli oggetti nel gioco.
 * Implementa l'interfaccia GameObserver.
 * @author WilliTini.
 */
public class ExamineObserver implements GameObserver, Serializable {

    /**
     * Aggiorna lo stato del gioco in base all'output del parser e restituisce un messaggio di risposta.
     * 
     * @param parserOutput l'output del parser che contiene il comando e l'oggetto da esaminare
     * @param game l'oggetto GameDesc che rappresenta lo stato corrente del gioco
     * @return il messaggio di risposta in base all'azione di esaminare l'oggetto
     */
    @Override
    public String update(ParserOutput parserOutput, GameDesc game) {
        StringBuilder msg = new StringBuilder();
        if (parserOutput.getCommand().getType() == CommandType.EXAMINE) {

            if (parserOutput.getObject() != null) {

                if (game.getCurrentRoom().getObjects().contains(parserOutput.getObject())) {

                    msg.append(parserOutput.getObject().getDescription());    

                    if (parserOutput.getObject() == game.getListObj().get(4)) {
                        if (!game.getRooms().get(4).getCharacters().isEmpty()) {
                            game.getRooms().get(4).getCharacters().remove(0); //trigger per dialogo con gin
                        }
                        if (game.getRooms().get(3).getCharacters().size() == 3) {
                            game.getRooms().get(4).getCharacters().add(game.getRooms().get(3).getCharacters().get(2)); //aggiunge gin 
                        } else {
                            game.getRooms().get(4).getCharacters().add(game.getRooms().get(3).getCharacters().get(1)); //aggiunge gin 
                        }
                    }
                    
                } else if (game.getInventory().getSet().contains(parserOutput.getObject())) {

                    msg.append(parserOutput.getObject().getDescription());
                } else {

                    msg.append("Non possiedi " + parserOutput.getObject().getName() + " e tanto meno e' presente nella stanza. \n Prova a cercalo/a in giro!");

                }

            } else if (parserOutput.getInvObject() != null) {

                if (game.getInventory().getSet().contains(parserOutput.getInvObject())) {

                    msg.append(parserOutput.getObject().getDescription());

                } else if (game.getCurrentRoom().getObjects().contains(parserOutput.getObject())) {

                    if (parserOutput.getObject() == game.getListObj().get(4)) {
                        if (!game.getRooms().get(4).getCharacters().isEmpty()) {
                            game.getRooms().get(4).getCharacters().remove(0); //trigger per dialogo con gin
                        }
                        game.getRooms().get(4).getCharacters().add(game.getRooms().get(3).getCharacters().get(2)); //aggiunge gin 
                    }
                } else {

                    msg.append("Non possiedi " + parserOutput.getObject().getName() + " e tanto meno e' presente nella stanza. \n Prova a cercalo/a in giro!");

                }
            } else {

                msg.append("Non ho capito cosa vuoi esaminare, non possiedi questo oggetto!");

            }

        }

        return msg.toString();
    }
}
