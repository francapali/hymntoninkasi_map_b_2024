package ninteam_map_b.hymn_to_ninkasi.impl;

import java.io.Serializable;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameDesc;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameObserver;
import ninteam_map_b.hymn_to_ninkasi.parser.ParserOutput;
import ninteam_map_b.hymn_to_ninkasi.type.CommandType;

/**
 * Questa classe rappresenta un'implementazione dell'interfaccia GameObserver.
 * Viene utilizzata per gestire l'azione di parlare con un personaggio nel gioco.
 * @author WilliTini.
 */
public class TalkToObserver implements GameObserver, Serializable {
    
    /**
     * Aggiorna lo stato del gioco in base all'output del parser e restituisce un messaggio di aggiornamento.
     * 
     * @param parserOutput l'output del parser che contiene il comando inserito dall'utente
     * @param game l'oggetto GameDesc che rappresenta lo stato corrente del gioco
     * @return il messaggio di aggiornamento del gioco
     */
    @Override
    public String update(ParserOutput parserOutput, GameDesc game) {
        StringBuilder msg = new StringBuilder();
        if (parserOutput.getCommand().getType() == CommandType.TALK_TO) {
            game.getLastCommand().add(parserOutput.getCommand().getType());
            if (!game.getCurrentRoom().getCharacters().isEmpty()) {
                if (game.getCurrentRoom().getCharacters().get(0).getName().equals("mojito")) {
                    msg.append("Mojito:-'Ciao, piacere, sono Mojito! Quando sei pronta a metterti alla prova con il mio quiz dimmi 'gioca'");
                } else if (!game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(1).isMarked()) {
                    msg.append(game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(1).getNpcDialogue() + "\n\n");
                    msg.append("1." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(1).getC1() + "\n");
                    msg.append("2." + game.getCurrentRoom().getCharacters().get(0).getDialogue().get(0).getNode(1).getC2());
                    game.setTalkTrigger(true);
                }
            } else {
                msg.append("Non c'è nessuno con cui parlare.");
            }
        }
        return msg.toString();
    }
}
