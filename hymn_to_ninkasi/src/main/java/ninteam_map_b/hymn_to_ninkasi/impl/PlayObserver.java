/**
 * PlayObserver.java
 */
package ninteam_map_b.hymn_to_ninkasi.impl;

import java.io.Serializable;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameDesc;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameObserver;
import ninteam_map_b.hymn_to_ninkasi.parser.ParserOutput;
import ninteam_map_b.hymn_to_ninkasi.type.CommandType;

/**
 * Questa classe rappresenta un osservatore per l'azione di giocare al minigioco trivia.
 * 
 * @author michelet
 */
public class PlayObserver implements GameObserver, Serializable {

    @Override
    public String update(ParserOutput parserOutput, GameDesc game) {
        StringBuilder msg = new StringBuilder();

        if (parserOutput.getCommand().getType() == CommandType.PLAY) {

            if (game.getCurrentRoom().getName().equals("Salotto")) {
                //chiama metodo per chiedere cinque domande
                game.playTrivia(1);
            } else {
                msg.append("Non c'è nessuno con cui giocare qui...");
            }
        }
        return msg.toString();
    }

}