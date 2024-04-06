import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //Inventory: can be accessed anywhere, and there is only one of them.
    public static ArrayList<Item> inventory = new ArrayList<>();
    //Capabilities is a class we will cycle through to check for matches. All items in your inventory will have their capabilities added to the ArrayList.
    //Some items will have overlap- a crowbar could open a locked door but so could an appropriate key. This static ArrayList will not break in those scenarios.
    public static ArrayList<String> capabilities = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    // Example usage

    public static void main(String[] args) {

        //General format for creating a new scene: Create scene. Give it story text. Give it choices. Give it other optional features

        //Declaring all the scene objects
        Scene strangeRoom1 = new Scene();
        Scene investigation = new Scene();
        Scene kitchen = new Scene();
        Scene garage = new Scene();

        Key bluekey = new Key("blue");
        Key redkey = new Key("red");
        Tool wrench = new Tool("wrench");
        Tool crowbar = new Tool("crowbar");

        //First room, and example setup.
        strangeRoom1.setStoryText("You wake up in a strange room in an unfamiliar house… There’s a locked door, dresser and a desk to your right. Maybe there’s something useful around.");
        strangeRoom1.setStoryTextRepeat("You’re still in the room. There’s a locked door, dresser and a desk to your right. Maybe there’s something useful around");
        strangeRoom1.addChoice(new Choice("1. Check the desk", new Outcome("You find a blue key in the drawer. You take it with you.", "gainItem", bluekey)));
        strangeRoom1.addChoice(new Choice("2. Check the dresser", new Outcome("There’s nothing but dust bunnies in here... Go back", "return")));
        strangeRoom1.addChoice(new Choice("3. Check the door", new Outcome("It’s definitely locked", "return"), new Outcome("You try the blue key, and it opens the door.", "nextScene1", "bluekey")));
        strangeRoom1.addNextScene(investigation);

        //investigation scene connected with choices and outcomes
        investigation.setStoryText("The key unlocks the door. You need to find a way out. Maybe look around?");
        investigation.setStoryTextRepeat("Keep Looking Around");
        investigation.addChoice(new Choice("1. Check Front Door",new Outcome("The front door is jammed shut. There's no real way to open it. Find another way out.","return")));
        investigation.addChoice(new Choice("2. Check Back Door",new Outcome("It looks like it’s locked, bolted and boarded up. Maybe there’s tools around the house that can help unlock the door…","return"), new Outcome ("You use the red key, wrench and crowbar to open the door and escape","ending","redkey","wrench","crowbar")));
        investigation.addChoice(new Choice("3. Check the Kitchen", new Outcome("You walk over to the kitchen","nextScene1")));
        investigation.addNextScene(kitchen);
        investigation.addChoice(new Choice("4. Check the Garage", new Outcome("You walk into the garage.","nextScene2")));
        investigation.addNextScene(garage);
        investigation.addChoice(new Choice("5. Check window", new Outcome("The window could probably break if you hit it with something.","return"), new Outcome ("You break the window with the wrench, but it's too small to fit through. You need to find another way out.","return")));

        //kitchen scene
        kitchen.setStoryText("The kitchen's a mess. Maybe there's something in this mess");
        kitchen.setStoryTextRepeat("Keep looking around the kitchen");
        kitchen.addChoice(new Choice("1. Check the Fridge",new Outcome("There's nothing but empty containers","return")));
        kitchen.addChoice(new Choice("2. Check Under the Sink",new Outcome("It isn't opening. Maybe you could use something to pry it open","return"), new Outcome("You use the crowbar to pry open the cabinet door and find a red key.","gainItem",redkey,"crowbar")));
        kitchen.addChoice(new Choice( "3. Leave Kitchen",new Outcome("You leave the kitchen","nextScene1")));
        kitchen.addNextScene(investigation);

        //garage scene
        garage.setStoryText("It's dusty. An old car lies untouched. It probably doesn't run anymore. Look around for tools");
        garage.setStoryTextRepeat("Keep looking around for tools");
        garage.addChoice(new Choice("1. Check the Tool Chest",new Outcome("You find an old wrench in one of the drawers.Maybe you can use it to break or open something?","gainItem",wrench,"return")));
        garage.addChoice(new Choice("2. Check the Shelves",new Outcome("In the back of the shelves you find a crowbar. Maybe you can use it to open something?","gainItem",crowbar,"return")));
        garage.addChoice(new Choice("3. Leave the garage",new Outcome("You leave the garage","nextScene1")));
        garage.addNextScene(investigation);

        //begin
        strangeRoom1.printScene();
        System.out.println("Type the number of your choice, and hit enter.");
        //Runs the play method of the output scene.
        strangeRoom1.choice(scanner.nextInt()).play();



    }
}
