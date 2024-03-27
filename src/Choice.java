import java.util.ArrayList;

public class Choice {
    //Text description for the user to read when deciding what to do
    private String choiceDescription;
    //There's multiple outcomes. Via an if statement, we can decide which outcome is correct for this scenario.
    private ArrayList<Outcome> outcomes;


    public Choice(String choiceDescription, Outcome outcome) {
        this.choiceDescription = choiceDescription;
        outcomes.add(outcome);
    }
    public Choice(String choiceDescription, Outcome outcome1, Outcome outcome2) {
        this.choiceDescription = choiceDescription;
        outcomes.add(outcome1);
        outcomes.add(outcome2);
    }
    //Multiple methods for creating choices with more than 1 outcome
    public Choice(String choiceDescription, Outcome outcome1, Outcome outcome2, Outcome outcome3) {
        this.choiceDescription = choiceDescription;
        outcomes.add(outcome1);
        outcomes.add(outcome2);
        outcomes.add(outcome2);
    }
    public Choice(String choiceDescription, Outcome outcome1, Outcome outcome2, Outcome outcome3, Outcome outcome4) {
        this.choiceDescription = choiceDescription;
        outcomes.add(outcome1);
        outcomes.add(outcome2);
        outcomes.add(outcome3);
        outcomes.add(outcome4);
    }


    public String getChoiceDescription() {
        return choiceDescription;
    }

    public void setChoiceDescription(String choiceDescription) {
        this.choiceDescription = choiceDescription;
    }


}
