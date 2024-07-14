package ninteam_map_b.hymn_to_ninkasi.impl;

import java.io.Serializable;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameDesc;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameObserver;
import ninteam_map_b.hymn_to_ninkasi.parser.ParserOutput;
import ninteam_map_b.hymn_to_ninkasi.type.CommandType;
import ninteam_map_b.hymn_to_ninkasi.type.NinObject;

/**
 * Questa classe rappresenta un osservatore per l'azione di leggere degli oggetti nel gioco.
 * Implementa l'interfaccia GameObserver.
 * @author Michelet - NinTeam
 */
public class ReadObserver implements GameObserver, Serializable {

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
        if (parserOutput.getCommand().getType() == CommandType.READ) {
            if (parserOutput.getObject() != null) {
                for (NinObject obj :  game.getInventory().getSet()) {
                    if (obj.getName().equals("lettera") && parserOutput.getObject().getName().equals("lettera")) {
                        found = true;
                        msg.append("Quella che hai tra le mani e' una lettera scritta con una penna nera a gel nera su un foglio a righe. E' la tua grafia. La rileggi:  \n"
                                + "\"Io non vorrei farlo ma penso che sia arrivato il momento. Ho custodito i vostri segreti per anni, sono stanca, stanca di voi. "
                                + "Guardatevi, la vostra falsita' vi ha consumate anche nel volto: siete irriconoscibili.  Martini, è arrivato il momento di dire a Gin che"
                                + " quella sera di giugno nella sua villa di famiglia era suo padre che avevi raggiunto nella cantina dei vini.  "
                                + "Gin quando avrai intenzione di dire a Margarita che hai strappato la sua lettera di ammissione alla Masterclass in Giappone pur di non allontanarla da te?  "
                                + "Margarita, non c'è mai stata una reale occasione per chiarire gli anni di silenzio che hanno sovrastato le nostre vite. "
                                + "Non eravamo e non siamo mai state sulla stessa lunghezza d'onda ed io non sono mai stata disposta a farmi travolgere, figuriamoci da te. "
                                + "Sono al capolinea, insoddisfatta, delusa e umiliata, come donna, amica e confidente. Vi ho voluto bene, ma forse quelle persone non esistono più.\" ");
                    }
                }
                if (!found) {
                    msg.append("Non puoi leggere quell'oggetto!");
                }
            } else {
                msg.append("Non possiedi " + parserOutput.getObject().getName() + " e tanto meno e' presente nella stanza. \n Prova a cercalo/a in giro!");
            }
        }
        return msg.toString();    
    }
}
