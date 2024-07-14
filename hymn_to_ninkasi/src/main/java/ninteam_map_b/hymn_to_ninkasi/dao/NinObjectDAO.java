/**
 * NinObjectDAO.java
 */
package ninteam_map_b.hymn_to_ninkasi.dao;

import java.io.Serializable;
import ninteam_map_b.hymn_to_ninkasi.config.DatabaseConfig;
import ninteam_map_b.hymn_to_ninkasi.dialogue.NinDialogueNode;
import ninteam_map_b.hymn_to_ninkasi.type.Characters;
import ninteam_map_b.hymn_to_ninkasi.type.NinObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import ninteam_map_b.hymn_to_ninkasi.type.NinRoom;
import ninteam_map_b.hymn_to_ninkasi.dialogue.NinDialogueNode;
import ninteam_map_b.hymn_to_ninkasi.dialogue.NinChoice;
import java.util.ArrayList;
/**
 * Data Access Object per la gestione degli oggetti nel database.
 * Questa classe fornisce i metodi per inserire e recuperare oggetti di tipo NinObject.
 * 
 * @autor francapali-NinTeam
 */
public class NinObjectDAO implements Serializable {

    /**
     * Inserisce un oggetto nel database.
     *
     * @param ninObject Oggetto da inserire nel database
     */
    public static void insertNinObject(NinObject ninObject) {
        String sql = "INSERT INTO NinObjectTable (name, description, alias, pickupable, throwable, readable, usable, openable, lockable, open, read, relatedObjects) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ninObject.getName());
            pstmt.setString(2, ninObject.getDescription());
            pstmt.setString(3, String.join(",", ninObject.getAlias()));
            pstmt.setBoolean(4, ninObject.isPickupable());
            pstmt.setBoolean(5, ninObject.isThrowable());
            pstmt.setBoolean(6, ninObject.isReadable());
            pstmt.setBoolean(7, ninObject.isUsable());
            pstmt.setBoolean(8, ninObject.isOpenable());
            pstmt.setBoolean(9, ninObject.isLockable());
            pstmt.setBoolean(10, ninObject.isOpen());
            pstmt.setBoolean(11, ninObject.isRead());
            pstmt.setInt(12, ninObject.getRelatedObject());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Recupera un oggetto dal database
     * 
     * @param id l'identificatore univoco per l'oggetto
     * @return ninObject ossia l'oggetto ricercato e ritrovato, null se non trovato
     */
    public static NinObject getNinObject(int id) {
        String sql = "SELECT * FROM NinObjectTable WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                Set<String> alias = new HashSet<>(Arrays.asList(rs.getString("alias").split(",")));
                boolean pickupable = rs.getBoolean("pickupable");
                boolean throwable = rs.getBoolean("throwable");
                boolean readable = rs.getBoolean("readable");
                boolean usable = rs.getBoolean("usable");
                boolean openable = rs.getBoolean("openable");
                boolean lockable = rs.getBoolean("lockable");
                boolean open = rs.getBoolean("open");
                boolean read = rs.getBoolean("read");
                int relatedObject = rs.getInt("relatedObjects");
                
                NinObject ninObject = new NinObject(id, name, description, alias);
                ninObject.setPickupable(pickupable);
                ninObject.setThrowable(throwable);
                ninObject.setReadable(readable);
                ninObject.setUsable(usable);
                ninObject.setOpenable(openable);
                ninObject.setLockable(lockable);
                ninObject.setOpen(open);
                ninObject.setRead(read);
                ninObject.setRelatedObject(relatedObject);
                return ninObject;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Recupera un oggetto dal database
     * 
     * @param id l'identificatore univoco per l'oggetto
     * @return ninObject ossia l'oggetto ricercato e ritrovato, null se non trovato
     */
    public static NinRoom getNinRoom(int id) {
        String sql = "SELECT * FROM NinRoomTable WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String lookNorth = rs.getString("look_north");
                String lookSouth = rs.getString("look_south");
                String lookEast = rs.getString("look_east");
                String lookWest = rs.getString("look_west");
                
                NinRoom ninRoom = new NinRoom(id, name, description);
                ninRoom.setLookNorth(lookNorth);
                ninRoom.setLookSouth(lookSouth);
                ninRoom.setLookEast(lookEast);
                ninRoom.setLookWest(lookWest);
                return ninRoom;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Restituisce un Characters corrispondente all'ID specificato.
     *
     * @param id l'ID del personaggio da recuperare
     * @return l'oggetto Characters corrispondente all'ID specificato, o null se non trovato
     */
    public static Characters getNinCharacters(int id) {
        String sql = "SELECT * FROM NinCharactersTable WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String bio = rs.getString("bio");
                
                Characters characters = new Characters(id, name, bio);
                return characters;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static NinDialogueNode getNinDialogue(int id) {
        String sql = "SELECT * FROM NinDialogueTable WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String npcDialogue = rs.getString("text");
                String userChoiche1 = rs.getString("choice1");
                String userChoiche2 = rs.getString("choice2");
                
                NinDialogueNode ninDialogue = new NinDialogueNode(id, npcDialogue, userChoiche1, userChoiche2);
                return ninDialogue;
            }
        } catch (SQLException e) {
            e.printStackTrace();
    }
    return null;
    }
}