import java.util.ArrayList;

public class Choice {
    //Text description for the user to read when deciding what to do
    private final String choiceDescription;
    //There's multiple outcomes. Via an if statement, we can decide which outcome is correct for this scenario.
    private final ArrayList<Outcome> outcomes = new ArrayList<>();

    public Choice(String choiceDescription, Outcome outcome) {
        this.choiceDescription = choiceDescription;
        this.outcomes.add(outcome);
    }
    public Choice(String choiceDescription, Outcome outcome1, Outcome outcome2) {
        this.choiceDescription = choiceDescription;
        outcomes.add(outcome1);
        outcomes.add(outcome2);
    }

    public String getChoiceDescription() {
        return choiceDescription;
    }
    public Outcome getOutcome(int index) {
        if (outcomes == null || index < 0 || index >= outcomes.size()) {
            // Handle invalid index or empty list appropriately, e.g., throw exception or return null
            return null;
        }
        return outcomes.get(index);
    }

    public ArrayList<Outcome> getOutcomes() {
        return outcomes;
    }

}
