package ninteam_map_b.hymn_to_ninkasi.impl;

import java.io.Serializable;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameDesc;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameObserver;
import ninteam_map_b.hymn_to_ninkasi.parser.ParserOutput;
import ninteam_map_b.hymn_to_ninkasi.type.CommandType;

/**
 * Questa classe rappresenta un osservatore per stampare i comandi di gioco.
 * Implementa l'interfaccia GameObserver.
 * @author WilliTini.
 */
public class HelpObserver implements GameObserver, Serializable {

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
        if (parserOutput.getCommand().getType() == CommandType.HELP) {
            game.getLastCommand().add(parserOutput.getCommand().getType());
            msg.append("Per eseguire un comando, scrivi il nome del comando. A volte sara' necessario aggiungere anche un oggetto o una direzione.\n");
            msg.append("Ecco i comandi disponibili:\n" +
            "INVENTARIO: per visualizzare l'inventario\n" +
            "NORD: per muoversi verso Nord\n" +
            "SUD: per muoversi verso Sud\n" +
            "EST: per muoversi verso Est\n" +
            "OVEST: per muoversi verso Ovest\n" +
            "APRI + altro: per aprire un oggetto\n" +
            "PRENDI + oggetto: per raccogliere un oggetto\n" +
            "PARLA: per parlare con un personaggio presente nella stanza\n" +
            "HELP: per visualizzare l'elenco dei comandi disponibili\n" +
            "SALVA: per salvare la partita.\n" +
            "OSSERVA: per esaminare l'ambiente circostante\n" +
            "GUARDA + direzione: per avere un'idea di cosa ci sia in una specifica direzione\n" +
            "Scrivere 1 o 2 durante un dialogo per scegliere la risposta.\n");

            
        }
        return msg.toString();
    }   
}
