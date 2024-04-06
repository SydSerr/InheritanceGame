import java.util.ArrayList;

public class Outcome {
    //Printed to the user after a choice is picked.
    private String description;

    //Can be return, gainItem, nextScene, or other stuff. Used on the backend; the user won't see this.
    //private ArrayList<String> events = new ArrayList<>();
    private String event;
    private Item gainedItem;
    private Item usedItem;
    private ArrayList<String> requirements = new ArrayList<>();


    //Overloaded constructors for different types of outcomes: some with requirements, some with gaineditems, some both
    public Outcome(String description, String event, String requirement) {
        this.description = description;
        this.event = event;
        this.requirements.add(requirement);
    }
    public Outcome(String description, String event, Item gainedItem, String requirement) {
        this.description = description;
        this.event = event;
        this.requirements.add(requirement);
    }
    public Outcome(String description, String event) {
        this.description = description;
        this.event = event;
    }
    public Outcome(String description, String event, String requirement1, String requirement2, String requirement3) {
        this.description = description;
        this.event = event;
        this.requirements.add(requirement1);
        this.requirements.add(requirement2);
        this.requirements.add(requirement3);
    }
    public Outcome(String description, String event, Item gainedItem) {
        this.description = description;
        this.event = event;
        this.gainedItem = gainedItem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public ArrayList<String> getRequirements() {
        return requirements;
    }

    public void setRequirements(ArrayList<String> requirements) {
        this.requirements = requirements;
    }


    public Item getGainedItem() {
        return gainedItem;
    }

    public void setGainedItem(Item gainedItem) {
        this.gainedItem = gainedItem;
    }

    public Item getUsedItem() {
        return usedItem;
    }

    public void setUsedItem(Item usedItem) {
        this.usedItem = usedItem;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }
}
/* Stolen from old stuff
//Text description for the user to read after they pick a choice
    private String outcomeDescription;
    private String outcomeDescriptionReturn;

    //Can be die, return, gainItem, nextScene, or other stuff. Used on the backend; the user won't see this.
    private ArrayList<String> outcomes;
 */