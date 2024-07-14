/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ninteam_map_b.hymn_to_ninkasi.other;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameDesc;

/**
 *
 * @author Michele
 */
public class SaveManager {
    
    
    public static void saveGame(GameDesc game, String filename) {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(game);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    
    public static GameDesc loadGame(String filename) {
        GameDesc game = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            game = (GameDesc) in.readObject();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        return game;
    }
}
