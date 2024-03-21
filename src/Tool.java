import java.util.ArrayList;


public class Tool extends Item {
    //Tools have an arraylist of strings associated with them called uses.
    //For example, a crowbar has uses such as removing planks or breaking open a window.
    //However, not all tools need multiple uses. A flashlight might only have "lightup"
    private ArrayList<String> uses;

    public Tool(String name) {
        super(name);
        this.uses = new ArrayList<>();
    }
    public ArrayList<String> getUses() {
        return uses;
    }
    public void setUses(ArrayList<String> uses) {
        this.uses = uses;
    }
    public void addUse(String newUse) {
        uses.add(newUse);
    }

    //Capabilities is a class we will cycle through to check for matches. All tools you have will have their capabilities added to the ArrayList.
    //Some tools will have overlap- a crowbar could open a locked door but so could an appropriate key. This static ArrayList will cover for that and allow for easy polling.
    private static ArrayList<String> capabilities;
}
