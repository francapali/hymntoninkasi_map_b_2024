package ninteam_map_b.hymn_to_ninkasi.hymntoninkasi;
import ninteam_map_b.hymn_to_ninkasi.parser.ParserOutput;
/**
 * Interfaccia per la gestione degli observer del gioco.
 * @author WilliTini.
 */
public interface GameObserver {

    public String update(ParserOutput output, GameDesc game);
}
