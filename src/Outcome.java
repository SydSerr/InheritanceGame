public class Outcome {
    //Printed to the user after a choice is picked.
    private String description;
    //Can be return, gainItem, nextScene, or other stuff. Used on the backend; the user won't see this.
    private String event;
    private Item gainedItem;
    private Item usedItem;
    private String requirement = "none";

    public Outcome(String description, String event, String requirement) {
        this.description = description;
        this.event = event;
        this.requirement = requirement;
    }
    public Outcome(String description, String event) {
        this.description = description;
        this.event = event;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
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
}
/* Stolen from old stuff
//Text description for the user to read after they pick a choice
    private String outcomeDescription;
    private String outcomeDescriptionReturn;

    //Can be die, return, gainItem, nextScene, or other stuff. Used on the backend; the user won't see this.
    private ArrayList<String> outcomes;
 */