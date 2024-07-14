/**
 * TriviaClient.java
 */
package ninteam_map_b.hymn_to_ninkasi.restful.trivia;

import com.google.gson.Gson;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ninteam_map_b.hymn_to_ninkasi.type.Trivia;

/**
 * Classe che rappresenta il client per il servizio trivia.
 * Permette di ottenere i dati di un trivia specifico dato il suo ID.
 * Utilizza la libreria Gson per la conversione JSON-Object.
 * 
 * @autor michelet-NinTeam
 */
public class TriviaClient {

    /**
     * Metodo statico che ottiene un oggetto Trivia dal servizio RESTful.
     * 
     * @param id L'ID del trivia da ottenere.
     * @return Trivia L'oggetto Trivia ottenuto dalla risposta del servizio.
     */
    public static Trivia getTrivia(int id) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:1024");

        try {
            Response resp = target.path("trivia/" + id).request(MediaType.APPLICATION_JSON).get();
            System.out.println(resp);

            String jsonResponse = resp.readEntity(String.class);
            Gson gson = new Gson();
            Trivia trivia = gson.fromJson(jsonResponse, Trivia.class);

            System.out.println("");
            System.out.println("ID: " + trivia.getId());
            System.out.println("Question: " + trivia.getQuestion());
            System.out.println("Answer1: " + trivia.getAnswer1());
            System.out.println("Answer2: " + trivia.getAnswer2());
            System.out.println("");

            return trivia;
        } catch (Exception e) {
            System.out.println("Avviso: ID esauriti");
            return null;
        } finally {
            System.out.println("");
            System.out.println("Avviso: Client chiuso con successo!");
            System.out.println("");
            client.close();
        }
    }
}