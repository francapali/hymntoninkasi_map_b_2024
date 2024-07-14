/**
 * NinChoice.java
 * 
 */
package ninteam_map_b.hymn_to_ninkasi.dialogue;

import java.io.Serializable;

/**
 * 
 * @author WilliTini-NinTeam
 */
public class NinChoice implements Serializable {

    private String text;
    private NinDialogueNode nextNode;

    public NinChoice (String text, NinDialogueNode nextNode) {
        this.text = text;
        this.nextNode = nextNode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public NinDialogueNode getNextNode() {
        return nextNode;
    }
}