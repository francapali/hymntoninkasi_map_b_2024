package ninteam_map_b.hymn_to_ninkasi.dialogue;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class NinDialogueNode implements Serializable {

    private int id;

    private String npcDialogue;

    private List<NinChoice> choices = new ArrayList<NinChoice>();

    private String c1;

    private String c2;

    private boolean isMarked = false;

    public NinDialogueNode(int id, String npcDialogue, String c1, String c2) {
        this.id = id;
        this.npcDialogue = npcDialogue;
        this.c1 = c1;
        this.c2 = c2;
    }
 
    public void addChoice(String choiceText, NinDialogueNode nextChoice) {
        choices.add(new NinChoice(choiceText, nextChoice));
    }

    //non dovrebbe servire


    public String getNpcDialogue() {
        return npcDialogue;
    }

    public int getId() {
        return id;
    }

    public List<NinChoice> getChoices() {
        return choices;
    }

    public void setMarked(boolean isMarked) {
        this.isMarked = isMarked;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public String getC1() {
        return c1;
    }

    public String getC2() {
        return c2;
    }
}
