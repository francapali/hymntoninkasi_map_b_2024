/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ninteam_map_b.hymn_to_ninkasi.impl;

import java.io.Serializable;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameDesc;
import ninteam_map_b.hymn_to_ninkasi.hymntoninkasi.GameObserver;
import ninteam_map_b.hymn_to_ninkasi.other.SaveManager;
import ninteam_map_b.hymn_to_ninkasi.parser.ParserOutput;
import ninteam_map_b.hymn_to_ninkasi.type.CommandType;

/**
 *
 * @author Michele
 */
public class SaveObserver implements GameObserver, Serializable {

    @Override
    public String update(ParserOutput output, GameDesc game) {
        StringBuilder msg = new StringBuilder();
        if (output.getCommand().getType() == CommandType.SAVE) {
            SaveManager.saveGame(game, "src\\save.dat");
            msg.append("Salvataggio effettuato con apparente successo!");
        }
        return msg.toString();
    }
    
}
