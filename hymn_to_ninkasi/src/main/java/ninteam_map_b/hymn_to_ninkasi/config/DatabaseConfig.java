/**
 * DatabaseConfig.java
 */
package ninteam_map_b.hymn_to_ninkasi.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.h2.tools.RunScript;

import java.io.FileReader;
import java.io.IOException;

/**
 * Classe per la configurazione del database H2 per il gioco Hymn To Ninkasi.
 * Questa classe gestisce la connessione al database e l'inizializzazione delle tabelle.
 * 
 * @autor francapali-NinTeam
 */
public class DatabaseConfig {
    private static final String JDBC_URL = "jdbc:h2:./resources/db";
    private static final String JDBC_USER = "NinTeam";
    private static final String JDBC_PASSWORD = "NinTeam2024";
    private static final String SQL_SCRIPT_PATH = "./resources/populate_database.sql"; // Percorso del file SQL

    /**
     * Ottiene una connessione al database H2.
     *
     * @return Connessione al database H2
     * @throws SQLException se si verifica un errore durante la connessione
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    /**
     * Inizializza il database creando le tabelle necessarie.
     */
    public static void initializeDatabase() {
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS NinObjectTable");
            stmt.execute("CREATE TABLE IF NOT EXISTS NinObjectTable ("
                    + "id INT PRIMARY KEY,"
                    + "name VARCHAR(255) NOT NULL, "
                    + "description TEXT, "
                    + "alias VARCHAR(255), "
                    + "pickupable BOOLEAN DEFAULT TRUE, "
                    + "throwable BOOLEAN DEFAULT TRUE, "
                    + "readable BOOLEAN DEFAULT FALSE, "
                    + "usable BOOLEAN DEFAULT FALSE, "
                    + "openable BOOLEAN DEFAULT FALSE,"
                    + "lockable BOOLEAN DEFAULT FALSE,"
                    + "open BOOLEAN DEFAULT FALSE, "
                    + "read BOOLEAN DEFAULT FALSE, "
                    + "relatedObjects INT);");
            
            stmt.execute("DROP TABLE IF EXISTS NinRoomTable");
            stmt.execute("CREATE TABLE IF NOT EXISTS NinRoomTable (" 
                    + " id INT PRIMARY KEY NOT NULL,"
                    + " name VARCHAR(255) NOT NULL,"
                    + " description TEXT,"
                    + " north INT,"
                    + " look_north VARCHAR(300),"
                    + " south INT,"
                    + " look_south VARCHAR(300),"
                    + " east INT,"
                    + " look_east VARCHAR(300),"
                    + " west INT,"
                    + " look_west VARCHAR(300));");
            
            stmt.execute("DROP TABLE IF EXISTS NinDialogueTable");
            stmt.execute("CREATE TABLE IF NOT EXISTS NinDialogueTable ("
                    + " id INT PRIMARY KEY NOT NULL,"
                    + " title VARCHAR(50),"
                    + " text TEXT,"
                    + " choice1 VARCHAR (150),"
                    + " choice2 VARCHAR (150),"
                    + " user_choice1 INT,"
                    + " user_choice2 INT);");
            
            stmt.execute("DROP TABLE IF EXISTS NinCharactersTable");
            stmt.execute("CREATE TABLE IF NOT EXISTS NinCharactersTable ("
                    + " id INT PRIMARY KEY NOT NULL,"
                    + " name VARCHAR(50),"
                    + " bio TEXT);");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Popola il database eseguendo uno script SQL.
     */
    public static void populateDatabase() {
        try (Connection conn = getConnection()) {
            System.out.println("Avviso: Connessione al database completata.");
            RunScript.execute(conn, new FileReader(SQL_SCRIPT_PATH));
            System.out.println("Avviso: Script eseguito.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
