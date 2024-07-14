/**
 * ScoreClient.java
 */
package ninteam_map_b.hymn_to_ninkasi.restful.scoreboard;

import com.google.gson.Gson;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ninteam_map_b.hymn_to_ninkasi.type.Scoreboard;

/**
 * Classe per la gestione delle operazioni RESTful relative ai punteggi (scoreboard).
 * Utilizza il client JAX-RS per effettuare richieste HTTP al server.
 * 
 * @see com.google.gson.Gson
 * @see javax.ws.rs.client.Client
 * @see javax.ws.rs.client.ClientBuilder
 * @see javax.ws.rs.client.WebTarget
 * @see javax.ws.rs.core.Response
 * @see ninteam_map_b.hymn_to_ninkasi.type.Scoreboard
 * 
 * @author michelet & francapali - NinTeam
 */
public class ScoreClient {
    
    /**
     * Recupera il punteggio (score) con l'ID specificato dal server.
     * 
     * @param id l'ID del punteggio da recuperare.
     * @return l'oggetto Scoreboard contenente le informazioni del punteggio.
     */
    public static Scoreboard getScore(int id) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:1024");
        try {
            System.out.println("IL TUO ID: " + id);
            Response resp = target.path("score/" + id).request(MediaType.APPLICATION_JSON).get();
            System.out.println(resp);

            // Usa Gson per mappare JSON a oggetto Java
            String jsonResponse = resp.readEntity(String.class);
            Gson gson = new Gson();
            Scoreboard score = gson.fromJson(jsonResponse, Scoreboard.class);

            System.out.println("ID: " + score.getNewid());
            System.out.println("Utente: " + score.getName());
            System.out.println("Tempo: " + score.getTimeSpent());
            System.out.println("Data: " + score.getDate());

            return score;
        } catch (Exception e) {
            System.out.println("Avviso: ID esauriti");
            return null;
        } finally {
            System.out.println("");
            System.out.println("Avviso: Il Client è stato chiuso");
            System.out.println("");
            client.close();
        }
    }

    /**
     * Salva il punteggio (score) sul server.
     * 
     * @param score l'oggetto Scoreboard contenente le informazioni del punteggio da salvare.
     */
    public static void setScore(Scoreboard score) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:1024");

        try {
            // Lascia l'ID come 0 se sarà generato automaticamente
            score.setNewid(5);

            Gson gson = new Gson();
            String json = gson.toJson(score);
            System.out.println(json);

            Response resp = target.path("score/new").request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(json, MediaType.APPLICATION_JSON));

            if (resp.getStatus() != Response.Status.OK.getStatusCode()) {
                System.out.println("Errore nel salvataggio del punteggio");
            } else {
                System.out.println("Punteggio salvato correttamente");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore durante il salvataggio del punteggio");
        } finally {
            client.close();
        }
    }
}
