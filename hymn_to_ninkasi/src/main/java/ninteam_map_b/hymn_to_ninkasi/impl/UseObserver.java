/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ninteam_map_b.hymn_to_ninkasi.impl;

import java.io.Serializable;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameDesc;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameObserver;
import ninteam_map_b.hymn_to_ninkasi.parser.ParserOutput;
import ninteam_map_b.hymn_to_ninkasi.type.CommandType;
import ninteam_map_b.hymn_to_ninkasi.type.NinObject;

/**
 * Questa classe rappresenta un osservatore per l'azione di usare degli oggetti nel gioco.
 * Implementa l'interfaccia GameObserver.
 * @author Michelet - NinTeam
 */
public class UseObserver implements GameObserver, Serializable {

    private boolean found = false;
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
        if (parserOutput.getCommand().getType() == CommandType.USE) {
            if (parserOutput.getObject() != null) {
                for (NinObject obj :  game.getInventory().getSet()) {
                    if (obj.getName().equals("lip-gloss") && parserOutput.getObject().getName().equals("lip-gloss")) {
                        if (game.getCurrentRoom().getName().equals("Bagno")) {
                            found = true;
                            msg.append("E dunque abbiamo preferito prima rifarci il trucco eh?\n"
                                       + "Sei senza cuore, davanti alla tua amica in lacrime hai preferito dare una seconda passata al tuo lucidalabbra per sentirti"
                                       + " appagata di un riflesso che ormai non ti appartiene più e in cui non ti riconosci. Quando sei diventata così? Come hai fatto"
                                       + " ad ignorare fin'ora i segnali? C'è ancora speranza per una seconda opportunità?\n"
                                       + "Supponendo ci fosse, saresti in grado di ribaltare completamente questa serata?");
                        } else {
                            found = true;
                            msg.append("Non puoi rifarti il trucco senza uno specchio...");
                        }
                    }
                }
                if (!found) {
                    msg.append("Non puoi usare quell'oggetto ora.");
                }
            } else {
                msg.append("Stai davvero cercando di usare...quello?!");
            }
        }
        return msg.toString();
    }
}
