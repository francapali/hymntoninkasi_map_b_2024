/*
 * Engine.java
 */
package ninteam_map_b.hymn_to_ninkasi;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import ninteam_map_b.hymn_to_ninkasi.Hymn_To_Ninkasi;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameDesc;
import ninteam_map_b.hymn_to_ninkasi.parser.Parser;
import ninteam_map_b.hymn_to_ninkasi.parser.ParserOutput;
import ninteam_map_b.hymn_to_ninkasi.type.CommandType;
import ninteam_map_b.hymn_to_ninkasi.type.Utils;

/**
 * Engine di gioco. Prende una classe che implementa GameDesc e riproduce il gioco.
 * 
 * @author michelet-NinTeam
 */
public class Engine {

    private final GameDesc game;
    
    private Parser parser;
    
    /**
     * Costruttore per l'engine di gioco.
     * 
     * @param game il gioco.
     */
    public Engine(GameDesc game) {
        this.game = game;
        try {
            this.game.init();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {
            Set<String> stopwords = Utils.loadFileListInSet(new File("./resources/stopwords.txt"));
            parser = new Parser(stopwords);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    /**
     * Costruttore per l'engine di gioco.
     * 
     * @param game il gioco.
     */
    public Engine(GameDesc game, boolean load) {
        this.game = game;
        if (!load) {
            try {
                this.game.init();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        try {
            Set<String> stopwords = Utils.loadFileListInSet(new File("./resources/stopwords.txt"));
            parser = new Parser(stopwords);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    /**
     * Restituisce l'istanza di GameDesc.
     * 
     * @return il gioco.
     */
    public GameDesc getGame() {
        return game;
    }
    
    /**
     * Gestisce l'avvio del gioco, l'input dei comandi, e la fine del gioco.
     */
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            ParserOutput p = parser.parse(command, game.getCommands(), game.getListObj(), game.getInventory(), game.getRooms());
            if (p == null || p.getCommand() == null) {
                System.out.println("Non capisco cosa vuoi...parla potabile");
            } else if (p.getCommand() != null && p.getCommand().getType() == CommandType.END) {
                System.out.println("La festa finisce qui, meglio tornare a casa.");
                break;
            } else {
                game.nextMove(p, System.out);
                if (game.getCurrentRoom() == null) {
                    System.out.println("La festa finisce qui, meglio tornare a casa.");
                    System.exit(0);
                }
            }
            System.out.println("-> ");
        }
    }
    
    /**
     * Classe main dell'applicazione.
     * 
     * @param args 
     */
    public static void main (String[] args) {
        Engine engine = new Engine(new Hymn_To_Ninkasi());
        engine.execute();
    }
}
