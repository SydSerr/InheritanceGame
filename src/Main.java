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

        //Declaring all the scene objects
        Scene strangeRoom1 = new Scene();
        Scene investigation = new Scene();
        Scene kitchen = new Scene();
        Scene garage = new Scene();
        Key bluekey = new Key("blue");
        Key redkey = new Key("red");

        //First room, and example setup.
        strangeRoom1.setStoryText("You wake up in a strange room in an unfamiliar house… There’s a locked door, dresser and a desk to your right. Maybe there’s something useful around.");
        strangeRoom1.setStoryTextRepeat("You’re still in the room. There’s a locked door, dresser and a desk to your right. Maybe there’s something useful around");
        strangeRoom1.addChoice(new Choice("Check the desk", new Outcome("You find a blue key in the drawer.", "gainItem")));
        strangeRoom1.addChoice(new Choice("Check the dresser", new Outcome("There’s nothing but dust bunnies in here... Go back", "return")));
        strangeRoom1.addChoice(new Choice("Check the door", new Outcome("It’s definitely locked", "return"), new Outcome("You try the blue key, and it opens the door.", "nextScene1")));

        //
        investigation.setStoryText("The key unlocks the door. You need to find a way out. Maybe look around?");
        investigation.setStoryTextRepeat("Keep Looking Around");
        investigation.addChoice();
        investigation.addChoice();
        investigation.addChoice();
        investigation.addChoice();
        investigation.addChoice();

        //add scenes and add scanner to give numbers to choices and user inputs number to select

        //
//        investigation.setStoryText("You decide to look elsewhere for a way out");
//        investigation.setStoryTextRepeat("The key unlocks the door. You decide to look around for a way out");
//        investigation.addChoice(new Choice("Check the front door", "return"));
//        investigation.addChoice(new Choice("Check the back door", "return"));
//        investigation.addChoice(new Choice("Check the kitchen", "nextScene1"));
//        investigation.addNextScene(kitchen);
//        investigation.addChoice(new Choice("Check the garage", "nextScene2"));
//        investigation.addNextScene(garage);



        //Adding all the scenes that need to be accessed
        strangeRoom1.addNextScene(investigation);


        //begin
        strangeRoom1.printScene();
        //Runs the play method of the output scene.
        strangeRoom1.choice(scanner.nextLine()).play();





    }
}
