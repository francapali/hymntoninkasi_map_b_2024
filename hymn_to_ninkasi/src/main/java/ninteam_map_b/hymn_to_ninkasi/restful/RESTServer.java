/**
 * RESTServer.java
 */
package ninteam_map_b.hymn_to_ninkasi.restful;

import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.UriBuilder;
import ninteam_map_b.hymn_to_ninkasi.restful.scoreboard.ScoreService;
import ninteam_map_b.hymn_to_ninkasi.restful.trivia.TriviaService;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Classe per la gestione del server RESTful.
 * Avvia e ferma il server RESTful utilizzando Grizzly.
 * 
 * @see org.glassfish.grizzly.http.server.HttpServer
 * @see org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
 * @see org.glassfish.jersey.server.ResourceConfig
 * 
 * @autor tondim-NinTeam
 */
public class RESTServer implements Runnable{
    
    private static final URI BASE_URI = UriBuilder.fromUri("http://localhost/").port(1024).build();
    private static final ResourceConfig CONFIG = new ResourceConfig().register(ScoreService.class).register(TriviaService.class);
    private static volatile HttpServer server;
    private static final CountDownLatch LATCH = new CountDownLatch(1);
        
    public RESTServer() {
    }
    
    /**
     * Avvia il server RESTful.
     */
    public static void startServer() {
        try {
            server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, CONFIG);
            server.start();
            System.out.println(String.format("JERSEY APP AVVIATA CON WADL DISPONIBILE A " 
                + "%sapplication.wadl", BASE_URI));
            LATCH.await(); // Attende che il server venga fermato
        } catch (Exception ex) {
            Logger.getLogger(RESTServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (server != null) {
                server.shutdown();
            }
        }
    }
    
    /**
     * Ferma il server RESTful.
     */
    public static void stopServer() {
        if (server != null) {
            server.shutdownNow();
            LATCH.countDown(); // Rilascia il latch per fermare il blocco del thread
        }
    }

    @Override
    public void run() {
        startServer();
    }
}
