import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    //Inventory: can be accessed anywhere, and there is only one of them.
    public static ArrayList<Item> inventory = new ArrayList<>();

    //Capabilities is a class we will cycle through to check for matches. All items in your inventory will have their capabilities added to the ArrayList.
    //Some items will have overlap- a crowbar could open a locked door but so could an appropriate key. This static ArrayList will not break in those scenarios.
    public static ArrayList<String> capabilities = new ArrayList<>();
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
        Tool wrench = new Tool("Wrench");
        Tool crowbar = new Tool("Crowbar");

        //First room, and example setup.
        strangeRoom1.setStoryText("You wake up in a strange room in an unfamiliar house… There’s a locked door, dresser and a desk to your right. Maybe there’s something useful around.");
        strangeRoom1.setStoryTextRepeat("You’re still in the room. There’s a locked door, dresser and a desk to your right. Maybe there’s something useful around");
        strangeRoom1.addChoice(new Choice("Check the desk", new Outcome("You find a blue key in the drawer. You take it with you.", "gainItem", bluekey)));
        strangeRoom1.addChoice(new Choice("Check the dresser", new Outcome("There’s nothing but dust bunnies in here... Go back", "return")));
        strangeRoom1.addChoice(new Choice("Check the door", new Outcome("It’s definitely locked", "return"), new Outcome("You try the blue key, and it opens the door.", "nextScene1", "bluekey" )));

        //2nd scene connected with choices and outcomes
        investigation.setStoryText("The key unlocks the door. You need to find a way out. Maybe look around?");
        investigation.setStoryTextRepeat("Keep Looking Around");
        investigation.addChoice(new Choice("Check Front Door",new Outcome("The front door is jammed shut. There's no real way to open it. Find another way out.","return")));
        investigation.addChoice(new Choice("Check Back Door",new Outcome("It looks like it’s locked, bolted and boarded up. Maybe there’s tools around the house that can help unlock the door…","return"), new Outcome ("You use the red key, wrench and crowbar to open the door and escape","ending","redkey")));
        investigation.addChoice(new Choice("Check the Kitchen", new Outcome("You walk over to the kitchen","nextScene1")));
        investigation.addNextScene(kitchen);
        investigation.addChoice(new Choice("Check the Garage", new Outcome("You walk into the garage.","nextScene2")));
        investigation.addNextScene(garage);
        investigation.addChoice(new Choice("Check window", new Outcome("The window could probably break if you hit it with something.","return"), new Outcome ("You break the window with the wrench, but it's too small to fit through. You need to find another way out.","return")));






        //Adding all the scenes that need to be accessed
        strangeRoom1.addNextScene(investigation);

        //begin
        strangeRoom1.printScene();
        System.out.println("Type the number of your choice, and hit enter.");
        //Runs the play method of the output scene.
        strangeRoom1.choice(scanner.nextInt()).play();





    }
}
