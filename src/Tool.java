import java.util.ArrayList;
//tool class that inherits from item
public class Tool extends Item {
    //Tools have an arraylist of strings associated with them called uses.
    //For example, a crowbar has uses such as removing planks or breaking open a window.
    //However, not all tools need multiple uses. A flashlight might only have "lightup"
    private ArrayList<String> uses;
    public Tool(String name) {
        super(name);
        this.uses = new ArrayList<>();
    }
    public void addUse(String newUse) {
        uses.add(newUse);
        Main.capabilities.add(newUse);
    }
}
