import java.util.ArrayList;

public class Choice {
    //Text description for the user to read when deciding what to do
    private String choiceDescription;
    //Text description for the user to read after they pick a choice
    private String outcomeDescription;
    private String outcomeDescriptionReturn;

    //Can be die, return, gainItem, nextScene, or other stuff. Used on the backend; the user won't see this.
    private ArrayList<String> outcomes;

    public Choice(String choiceDescription, String outcomeDescription,String outcome) {
        this.choiceDescription = choiceDescription;
        this.outcomeDescription = outcomeDescription;
        outcomes.add(outcome);
    }
    public Choice(String choiceDescription, String outcomeDescription, String outcome1, String outcome2) {
        this.choiceDescription = choiceDescription;
        this.outcomeDescription = outcomeDescription;
        outcomes.add(outcome1);
        outcomes.add(outcome2);
    }
    //Multiple methods for creating choices with more than 1 outcome
    public Choice(String choiceDescription, String outcomeDescription, String outcome1, String outcome2, String outcome3) {
        this.choiceDescription = choiceDescription;
        this.outcomeDescription = outcomeDescription;
        outcomes.add(outcome1);
        outcomes.add(outcome2);
        outcomes.add(outcome3);
    }
    public Choice(String choiceDescription, String outcomeDescription, String outcome1, String outcome2, String outcome3, String outcome4) {
        this.choiceDescription = choiceDescription;
        this.outcomeDescription = outcomeDescription;
        outcomes.add(outcome1);
        outcomes.add(outcome2);
        outcomes.add(outcome3);
    }


    public String getChoiceDescription() {
        return choiceDescription;
    }

    public void setChoiceDescription(String choiceDescription) {
        this.choiceDescription = choiceDescription;
    }

    public String getOutcomeDescription() {
        return outcomeDescription;
    }

    public void setOutcomeDescription(String outcomeDescription) {
        this.outcomeDescription = outcomeDescription;
    }

    public void setOutcomes(ArrayList<String> outcomes) {
        this.outcomes = outcomes;
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
