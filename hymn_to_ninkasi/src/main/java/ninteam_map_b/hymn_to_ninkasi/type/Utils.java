/**
 * Utils.java
 */
package ninteam_map_b.hymn_to_ninkasi.type;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe di utilità per la gestione di file e stringhe.
 * Contiene metodi per caricare un file in un set di stringhe e per analizzare una stringa escludendo stopwords.
 * 
 * @author francapali-NinTeam
 */
public class Utils {

    /**
     * Carica le righe di un file in un set di stringhe.
     * Ogni riga viene convertita in minuscolo e gli spazi bianchi iniziali e finali vengono rimossi.
     *
     * @param file Il file da leggere
     * @return Un set di stringhe contenente le righe del file
     * @throws IOException Se si verifica un errore di I/O durante la lettura del file
     */
    public static Set<String> loadFileListInSet(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("Il file non può essere nullo");
        }

        Set<String> set = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                set.add(line.trim().toLowerCase());
            }
        }
        return set;
    }

    /**
     * Divide una stringa in parole, escludendo le parole presenti nel set di stopwords.
     * 
     * @param string La stringa da analizzare
     * @param stopwords Un set di parole da escludere
     * @return Una lista di parole non presenti nelle stopwords
     */
    public static List<String> parseString(String string, Set<String> stopwords) {
        if (string == null) {
            throw new IllegalArgumentException("La stringa non può essere nulla");
        }
        if (stopwords == null) {
            throw new IllegalArgumentException("Il set di stopwords non può essere nullo");
        }

        List<String> tokens = new ArrayList<>();
        String[] split = string.toLowerCase().split("\\s+");
        for (String t : split) {
            if (!stopwords.contains(t)) {
                tokens.add(t);
            }
        }
        return tokens;
    }

}

