/**
 * ScoreService.java
 */
package ninteam_map_b.hymn_to_ninkasi.restful.scoreboard;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ninteam_map_b.hymn_to_ninkasi.type.Scoreboard;

/**
 * Classe che rappresenta il servizio RESTful per la gestione dei punteggi.
 * Fornisce metodi per ottenere e salvare i punteggi.
 * 
 * @see com.google.gson.Gson
 * @see java.io.RandomAccessFile
 * @see javax.ws.rs.Consumes
 * @see javax.ws.rs.GET
 * @see javax.ws.rs.PUT
 * @see javax.ws.rs.Path
 * @see javax.ws.rs.Produces
 * @see javax.ws.rs.core.MediaType
 * @see javax.ws.rs.core.Response
 * @see ninteam_map_b.hymn_to_ninkasi.type.Scoreboard
 * 
 * @author francapali-NinTeam
 */
@Path("score")
public class ScoreService {
    
    String filePath = "src\\scoreboard.dat";
    File file = new File(filePath);
    
    /**
     * Crea il file iniziale della scoreboard con un punteggio di esempio.
     */
    private void createFile() {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            System.out.println("Entries iniziali create con successo.");
        } catch (IOException e) {
            System.err.println("Errore nella creazione delle entry: " + e.getMessage());
        }
    }
    
    /**
     * Restituisce il punteggio corrispondente all'ID specificato.
     * 
     * @param scoreid l'ID del punteggio da recuperare.
     * @return una risposta HTTP contenente il punteggio in formato JSON.
     */
    @GET
    @Path("/{scoreid}")
    @Produces("application/json")
    public Response score(@PathParam("scoreid") String scoreid) {
        
        if (!file.exists()) {
            createFile();
        }
        
        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
            boolean found = false;
            int newid = Integer.parseInt(scoreid);
            Scoreboard score;
            
            while (file.getFilePointer() < file.length()) {
                int id = file.readInt();
                String name = file.readUTF();
                String timeSpent = file.readUTF();
                String date = file.readUTF();
                
                if (id == newid) {
                    found = true;
                    score = new Scoreboard(newid, name, timeSpent, date);
                        
                    Gson gson = new Gson();
                        
                    String jsonString = gson.toJson(score);
                    return Response.ok(jsonString, MediaType.APPLICATION_JSON).build();
                }
            }
            if (!found) {
                return Response.status(Response.Status.NOT_FOUND).entity("Score not found").build();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } catch (NumberFormatException e) {
            System.out.println("Errore nel parsing dell'ID.");
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid score ID").build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    
    /**
     * Salva un nuovo punteggio sul server.
     * 
     * @param json il punteggio da salvare in formato JSON.
     * @return una risposta HTTP contenente il punteggio salvato in formato JSON.
     */
    @PUT
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putScore(String json) {
        
        if (!file.exists()) {
            createFile();
        }
        
        Gson gson = new Gson();
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            Scoreboard score = gson.fromJson(json, Scoreboard.class);
            score.setDate(java.time.LocalDate.now().toString());
            
            System.out.println("");
            System.out.println(score.getName() + score.getDate() + score.getTimeSpent());
            System.out.println("");

            int id = 0;

            while (file.getFilePointer() < file.length()) {
                id = file.readInt();
                file.readUTF();
                file.readUTF();
                file.readUTF();
            }
            file.seek(file.length());
            file.writeInt(id + 1);
            file.writeUTF(score.getName());
            file.writeUTF(score.getTimeSpent());
            file.writeUTF(score.getDate());
            String jsonString = gson.toJson(score);
            return Response.ok(jsonString, MediaType.APPLICATION_JSON).build();
            
        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error writing to file").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid data").build();
        }
    }
}

