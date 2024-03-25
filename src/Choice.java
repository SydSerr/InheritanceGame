import java.util.ArrayList;

public class Choice {
    //Text description for the user to read
    private String description;
    //Can be die, return, gainItem, nextScene, or other stuff
    private ArrayList<String> outcomes;

    public Choice(String description, String outcome) {
        this.description = description;
        outcomes.add(outcome);
    }
    //Multiple methods for creating choices with more than 1 outcome
    public Choice(String description, String outcome1, String outcome2) {
        this.description = description;
        outcomes.add(outcome1);
        outcomes.add(outcome2);
    }
    public Choice(String description, String outcome1, String outcome2, String outcome3) {
        this.description = description;
        outcomes.add(outcome1);
        outcomes.add(outcome2);
        outcomes.add(outcome3);
    }


    public String getDescription() {
        return description;
    }

    public ArrayList<String> getOutcomes() {
        return outcomes;
    }
    public String getOutcome(int i) {
        return outcomes.get(i);
    }

    public void setOutcome(ArrayList<String> outcomes) {
        this.outcomes = outcomes;
    }
    public void addOutcome(String outcome){
        outcomes.add(outcome);
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
