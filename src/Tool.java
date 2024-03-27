import java.util.ArrayList;
public class Tool extends Item {
    //Tools have an arraylist of strings associated with them called uses.
    //For example, a crowbar has uses such as removing planks or breaking open a window.
    //However, not all tools need multiple uses. A flashlight might only have "lightup"
    private ArrayList<String> uses = new ArrayList<>();
    public Tool(String name) {
        super(name);
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
}
