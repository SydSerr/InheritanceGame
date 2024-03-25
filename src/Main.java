import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {


    //Inventory: can be accessed anywhere, and there is only one of them.
    public static ArrayList<Item> inventory = new ArrayList<>();

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
        strangeRoom1.addChoice(new Choice("Check the desk", "gainItem"));
        strangeRoom1.addChoice(new Choice("Check the dresser", "return"));
        strangeRoom1.addChoice(new Choice("Check the door", "return", "nextScene1"));
        strangeRoom1.setGainedItem(bluekey);
        Scene hallway = new Scene();
        hallway.setStoryText("The key unlocks the door. You decide to look around for a way out");
        hallway.setGainedItem(bluekey);



        //Adding all the scenes that need to be accessed
        strangeRoom1.addNextScene(hallway);

        //begin
        strangeRoom1.printScene();
        strangeRoom1.choice(scanner.nextLine()).play();





    }
}
