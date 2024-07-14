/**
 * Trivia.java
 */
package ninteam_map_b.hymn_to_ninkasi.type;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author michelet-NinTeam
 */
public class Trivia implements Serializable {
    private int id;
    
    private String question;
    
    private String answer1;
    
    private String answer2;
    
    public Trivia(int id, String question, String answer1, String answer2) {
        this.id = id;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
    }

    public Trivia() {

    }
    
    public int getId() {
        return id;
    }
    
    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    @Override
    public String toString() {
        return "Trivia{" + "question=" + question + ", answer1=" + answer1 + ", answer2=" + answer2 + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trivia other = (Trivia) obj;
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        if (!Objects.equals(this.answer1, other.answer1)) {
            return false;
        }
        return Objects.equals(this.answer2, other.answer2);
    }
}
