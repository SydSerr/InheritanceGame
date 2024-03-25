import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {


    //Inventory: can be accessed anywhere, and there is only one of them.
    static ArrayList<Item> inventory = new ArrayList<>();

    //Capabilities is a class we will cycle through to check for matches. All items in your inventory will have their capabilities added to the ArrayList.
    //Some items will have overlap- a crowbar could open a locked door but so could an appropriate key. This static ArrayList will not break in those scenarios.
    public static ArrayList<String> capabilities;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        //General format for creating a new scene: Create scene. Give it story text. Give it choices. Give it other optional features
        //First room, and example setup.
        Scene strangeRoom1 = new Scene();
        Key bluekey = new Key("blue");
        strangeRoom1.setStoryText("You wake up in a strange room in an unfamiliar house… You try the door but it's locked. Maybe there’s a key nearby… Check the desk or check the dresser?");
        strangeRoom1.setPositiveChoice(new Choice(true, "Check the desk"));
        strangeRoom1.setNegativeChoice(new Choice(false, "Check the dresser"));
        strangeRoom1.setObtainedItem(bluekey);
        strangeRoom1.printScene();
        strangeRoom1.choice(scanner.nextLine());

        Scene hallway = new Scene();
        hallway.setStoryText("You wake up in a strange room in an unfamiliar house… You try the door but it's locked. Maybe there’s a key nearby…");
        hallway.setPositiveChoice(new Choice(true, "Front Door"));
        hallway.setNegativeChoice(new Choice(false, "Back Door"));
        hallway.setObtainedItem(bluekey);

    }
}
