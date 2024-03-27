public class Outcome {
    //Printed to the user after a choice is picked.
    private String description;
    //Can be die, return, gainItem, nextScene, or other stuff. Used on the backend; the user won't see this.
    private String event;
    private Item gainedItem;
    private Item usedItem;

    public Outcome(String description, String event) {
        this.description = description;
        this.event = event;
    }
}
/* Stolen from old stuff
//Text description for the user to read after they pick a choice
    private String outcomeDescription;
    private String outcomeDescriptionReturn;

    //Can be die, return, gainItem, nextScene, or other stuff. Used on the backend; the user won't see this.
    private ArrayList<String> outcomes;
 */