/**
 * TriviaService.java
 */
package ninteam_map_b.hymn_to_ninkasi.restful.trivia;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import ninteam_map_b.hymn_to_ninkasi.type.Trivia;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Servizio RESTful per gestire le richieste relative ai trivia.
 * Legge i dati da un file di testo e restituisce i dati in formato JSON.
 * 
 * @autor michelet-NinTeam
 */
@Path("trivia")
public class TriviaService {
    
    String filePath = "src\\trivia.txt";
    
    /**
     * Ottiene un trivia specifico dato il suo ID.
     * 
     * @param triviaid L'ID del trivia da ottenere.
     * @return Response La risposta contenente i dati del trivia in formato JSON.
     */
    @GET
    @Path("/{triviaid}")
    @Produces("application/json")
    public Response trivia(@PathParam("triviaid") String triviaid) {
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean found = false;
            int newid = Integer.parseInt(triviaid);
            Trivia trivia;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("; ");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0].trim());
                    String question = parts[1].trim();
                    String answer1 = parts[2].trim();
                    String answer2 = parts[3].trim();
                    
                    if (id == newid) {
                        found = true;
                        trivia = new Trivia(newid, question, answer1, answer2);
                        
                        Gson gson = new Gson();
                        String jsonString = gson.toJson(trivia);
                        reader.close();
                        return Response.ok(jsonString, MediaType.APPLICATION_JSON).build();
                    }
                }
            }
            
            if (!found) {
                System.out.println("Error");
                return null;
            }
            
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error parsing ID.");
            e.printStackTrace();
        }
        return null;
    }
}
