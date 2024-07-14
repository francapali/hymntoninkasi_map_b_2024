/**
 * DialogGraph.java
 */

package ninteam_map_b.hymn_to_ninkasi.dialogue;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author WilliTini_NinTeam
 */
public class DialogGraph implements Serializable {

    private NinDialogueNode startNode;

    private Map<Integer, NinDialogueNode> nodes;

    public DialogGraph() {
        nodes = new HashMap<>();
    }   

    public void addNode(int id, NinDialogueNode node) {
        nodes.put(id, node);
        if (startNode == null) {
            startNode = node;
        }
    }

    public NinDialogueNode getNode(int id) {
        return nodes.get(id);
    }

}
