/**
 * Command.java
 * 
 */
package ninteam_map_b.hymn_to_ninkasi.type;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Classe che rappresenta un comando in Hymn To Ninkasi.
 * Ad ogni comando è assegnato un tipo, un nome e può avere alias.
 * 
 * @author francapali-NinTeam
 */
public class Command implements Serializable {
    
    private final CommandType type;
    private final String name;
    private Set<String> alias;
    
    /**
     * Costruttore per creare un comando senza alias.
     * 
     * @param type il tipo di comando
     * @param name il nome del comando
     */
    public Command(CommandType type, String name) {
        this.type = type;
        this.name = name;
        this.alias = new HashSet<>();
    }
    
    /**
     * Costruttore per creare un comando con alias.
     * 
     * @param type  il tipo di comando
     * @param name  il nome del comando
     * @param alias un set di alias per il comando
     */
    public Command(CommandType type, String name, Set<String> alias) {
        this.type = type;
        this.name = name;
        this.alias = alias;
    }
    
    /**
     * Ottiene il nome del comando
     * 
     * @return il nome del comando
     */
    public String getName() {
        return name;
    }
    
    /**
     * Ottiene gli alias del comando.
     * 
     * @return un set di alias del comando
     */
    public Set<String> getAlias() {
        return alias;
    }
    
    /**
     * Imposta gli alias del comando.
     * 
     * @param alias un set di alias per il comando
     */
    public void setAlias(Set<String> alias) {
        this.alias = alias;
    }
    
    /**
     * Imposta gli alias del comando.
     * 
     * @param alias un array di alias per il comando
     */
    public void setAlias(String[] alias) {
        this.alias = new HashSet<>(Arrays.asList(alias));
    }
    
    /**
     * Ottiene il tipo di comando.
     * 
     * @return il tipo di comando
     */
    public CommandType getType() {
        return type;
    }
    
    /**
     * Calcola il codice hash per l'oggetto Command.
     * 
     * @return il codice hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.type);
        hash = 97 * hash + Objects.hashCode(this.name); // Aggiunta del nome al calcolo dell'hash
        return hash;
    }
    
    /**
     * Verifica l'uguaglianza tra due oggetti Command.
     * 
     * @param obj l'oggetto da confrontare
     * @return true se gli oggetti sono uguali, altrimenti false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Command other = (Command) obj;
        return Objects.equals(this.type, other.type) && Objects.equals(this.name, other.name);
    }
}
