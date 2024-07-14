package ninteam_map_b.hymn_to_ninkasi.impl;

import java.io.Serializable;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameDesc;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameObserver;
import ninteam_map_b.hymn_to_ninkasi.parser.ParserOutput;
import ninteam_map_b.hymn_to_ninkasi.type.CommandType;

/**
 * Questa classe rappresenta un osservatore per l'azione di raccogliere oggetti nel gioco.
 * Implementa l'interfaccia GameObserve e fornisce un metodo per aggiornare lo stato del gioco
 * dopo l'azione di raccogliere un oggetto.
 * @author WilliTini.
 */
public class PickUpObserver implements GameObserver, Serializable {
    

    /**
     * Aggiorna lo stato del gioco dopo l'azione di raccogliere un oggetto.
     * Se l'azione è stata eseguita correttamente, l'oggetto viene aggiunto all'inventario del gioco
     * e rimosso dalla stanza corrente. Viene restituito un messaggio di conferma.
     * Se l'oggetto non è raccoglibile, viene restituito un messaggio di errore.
     * Se non ci sono oggetti da raccogliere nella stanza corrente, viene restituito un messaggio di avviso.
     * 
     * @param parserOutput l'output del parser che contiene le informazioni sull'azione eseguita
     * @param game l'oggetto GameDesc che rappresenta lo stato del gioco
     * @return il messaggio di conferma, errore o avviso
     */

     @Override
     public String update(ParserOutput parserOutput, GameDesc game) {
         StringBuilder msg = new StringBuilder();
         if (parserOutput.getCommand().getType() == CommandType.PICK_UP) {
            game.getLastCommand().add(parserOutput.getCommand().getType());
            if (game.getListObj().contains(parserOutput.getObject())) {                
                if (parserOutput.getObject() == null) {
                    // Gestisci il caso in cui l'oggetto specificato è null
                    msg.append("Specifica cosa vuoi raccogliere! Sempre se c'e' qualcosa da raccogliere...");
                } else {
                    // Procedi con il controllo se l'oggetto è presente nella stanza
                    if (!game.getCurrentRoom().getObjects().contains(parserOutput.getObject())) {
                        // Gestisci il caso in cui l'oggetto non è presente nella stanza
                        msg.append("Okay, ma questo oggetto non c'e' qui! Forse hai sbagliato stanza...");
                    } else {
                        // L'oggetto è presente, procedi con i controlli esistenti
                        if (parserOutput.getObject().isPickupable()) {
                            game.getInventory().add(parserOutput.getObject());
                            game.getCurrentRoom().getObjects().remove(parserOutput.getObject());
                            if (parserOutput.getObject().getName().equals("polaroid")) {
                                msg.append(".\n " + "Sono tanti i ricordi che riaffiorano alla vista di questa istantanea datata 28 Maggio 1990. \n" +
                                    "Era il Memorial Day, quasi dieci anni fa, tutte e quattro sorridenti, ingenue e pronte all''avventura. \n " +
                                    "Forse quello del college è stato l''unico periodo in cui siete state realmente felici insieme.\n" +
                                    "Eravate in pausa dalle lezioni, i problemi più grandi erano i capelli in un''umida giornata estiva e gli\n" +
                                    "inviti che non arrivavano dalle congregazioni più in voga del campus, eravate spensierate e non lo credevate.\n" +
                                    "Provi un senso di nostalgia, dove sono finiti quei giorni? Quelle ragazze dove si sono perse?\n" +
                                    "Non ricordi di avere rullini ancora da sviluppare eppure non hai neanche una foto a casa che vi ritragga al\n" +
                                    "completo come in questo caso. Sei sempre stata il collante delle ragazze e ne sei consapevole.\n");
                                    game.getRooms().get(3).getCharacters().remove(0); //rimuove il pg di Martini Senza Polaroid dal bagno
                                    game.getCurrentRoom().setLookNorth("Davanti a te sempre il solito frigorifero, ma spoglio della polaroid che ti sei messa in tasca.");

                            }
                            msg.append("Hai raccolto: ").append(parserOutput.getObject().getName()).append(".\n Ora e' al sicuro nel tuo inventario! O almeno si spera...");
                        } else {
                            msg.append("Non puoi raccogliere questo oggetto! Forse non ti appartiene o non esiste, chissa'...");
                        }
                    }
                }
            } else {
                msg.append("Cosa?? Non ci credo che vuoi provare a raccogliere...quello! Prova con un oggetto serio!");
            }          
        }
        return msg.toString();
    }
}

 
/**
 * Da completare perche una volta raccolto un oggetto va cambiata anche la descrizione della stanza contentente l'oggetto.
 * Ci sarebbe, FORSE, da invertire il secondo e il terzo if. Ma forse. Chissa, poi vediamo dai.
 */
