/**
 * Characters.java
 */

package ninteam_map_b.hymn_to_ninkasi.type;

import java.io.Serializable;
import ninteam_map_b.hymn_to_ninkasi.dialogue.DialogGraph;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 * Questa classe rappresenta un personaggio nel gioco.
 * @author WilliTini.
 */
public class Characters implements Serializable {

    private String name;

    private int id;

    private String info;

    private List<Trivia> trivia = new ArrayList<>();
    
    private List<DialogGraph> dialogue = new ArrayList<DialogGraph>();

    /**
     * Costruttore della classe Characters.
     * 
     * @param name Il nome del personaggio.
     * @param id L'ID del personaggio.
     * @param info Le informazioni sul personaggio.
     */
    public Characters(int id, String name, String info) {
        this.name = name;
        this.id = id;
        this.info = info;
    }

    /**
     * Restituisce il nome del personaggio.
     * 
     * @return Il nome del personaggio.
     */
    public String getName() {
        return name;
    }   

    /**
     * Restituisce l'ID del personaggio.
     * 
     * @return L'ID del personaggio.
     */
    public int getId() {
        return id;
    }   

    /**
     * Restituisce le informazioni sul personaggio.
     * 
     * @return Le informazioni sul personaggio.
     */
    public String getInfo() {
        return info;
    } 

    public List<Trivia> getTrivia() {
        return trivia;
    }
    
    /**
     * Imposta il nome del personaggio.
     * 
     * @param name Il nome del personaggio da impostare.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Imposta l'ID del personaggio.
     * 
     * @param id L'ID del personaggio da impostare.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Imposta le informazioni sul personaggio.
     * 
     * @param info Le informazioni sul personaggio da impostare.
     */
    public void setInfo(String info) {
        this.info = info;
    }

    public void setTrivia(List<Trivia> trivia) {
        this.trivia = trivia;
    }

    public void setTriviaId(Set<Integer> ids) {
        for (int id : ids) {
            Trivia newTrivia = new Trivia();
            newTrivia.setId(id);
            trivia.add(newTrivia);
        }
        for (Trivia t : trivia) {
            System.out.println(t.getId());
        }
    }

    /**
     * Calcola l'hash code del personaggio.
     * 
     * @return L'hash code del personaggio.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    /**
     * Confronta se il personaggio è uguale all'oggetto specificato.
     * 
     * @param obj L'oggetto da confrontare.
     * @return true se il personaggio è uguale all'oggetto specificato, false altrimenti.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Characters other = (Characters) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public List<DialogGraph> getDialogue() {
        return dialogue;
    }   
}