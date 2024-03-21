import java.util.ArrayList;

public class Main {
    //Inventory: can be accessed anywhere, and there is only one of them.
    static ArrayList<Item> inventory = new ArrayList<>();
    public static void main(String[] args) {
        Scene strangeRoom1 = new Scene();
        //If scanner.lastword() = posChoice.getText.
        //go to hallway.
        Scene hallway = new Scene();
        Key bluekey = new Key("Blue Key", "blue");
        inventory.add(bluekey);
        strangeRoom1.setStoryText("a");

    }
}
