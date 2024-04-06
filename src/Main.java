import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //Capabilities is a class we will cycle through to check for matches. All items in your inventory will have their capabilities added to the ArrayList.
    //Some items will have overlap- a crowbar could open a locked door but so could an appropriate key. This static ArrayList will not break in those scenarios.
    public static ArrayList<String> capabilities = new ArrayList<>();
    
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
        wrench.addUse("bolt");
        wrench.addUse("smash");
        Tool crowbar = new Tool("crowbar");
        crowbar.addUse("pry");
        crowbar.addUse("smash");

        //First room
        System.out.println("Tip: Drag up on the console to view more text!");
        strangeRoom1.setStoryText("You wake up in a strange room in an unfamiliar house… There’s a locked door, dresser and a desk to your right. Maybe there’s something useful around.");
        strangeRoom1.setStoryTextRepeat("You’re still in the room. Maybe there’s something useful around. ");
        strangeRoom1.addChoice(new Choice("1. Check the desk", new Outcome("You find a blue key in the drawer. You take it with you.", "gainItem", bluekey)));
        strangeRoom1.addChoice(new Choice("2. Check the dresser", new Outcome("There’s nothing but dust bunnies in here...", "return")));
        strangeRoom1.addChoice(new Choice("3. Check the door", new Outcome("You try to open the door. It's definitely locked.", "return"), new Outcome("You try the blue key, and it opens the door.", "nextScene1", "bluekey")));
        strangeRoom1.addNextScene(investigation);

        //investigation scene connected with choices and outcomes
        investigation.setStoryText("With the door unlocked, you gain access to the rest of the house. You need to find a way out. Maybe look around?");
        investigation.setStoryTextRepeat("Not much to do besides looking around.");
        investigation.addChoice(new Choice("1. Check front door",new Outcome("The front door is solid metal, and seems to be jammed shut from the outside. Might as well be impossible to open. Find another way out.","return")));
        investigation.addChoice(new Choice("2. Check back door",new Outcome("It looks like it’s locked, bolted and boarded up. Maybe there’s tools around the house that can help unlock the door...","return"), new Outcome ("You pry off the boards, remove the bolts, and open the lock, and finally escape","ending","redkey","bolt","pry")));
        investigation.addChoice(new Choice("3. Check the kitchen", new Outcome("You walk over to the kitchen...","nextScene1")));
        investigation.addNextScene(kitchen);
        investigation.addChoice(new Choice("4. Check the garage", new Outcome("You walk into the garage...","nextScene2")));
        investigation.addNextScene(garage);
        investigation.addChoice(new Choice("5. Check window", new Outcome("The window could probably break if you had something to hit it with.","return"), new Outcome ("You smash open the window with a tool, but it's too small to fit through. You need to find another way out.","return", "smash")));

        //kitchen scene
        kitchen.setStoryText("The kitchen's a mess. Maybe there's something in this mess..");
        kitchen.setStoryTextRepeat("Keep looking around the kitchen?");
        kitchen.addChoice(new Choice("1. Check the fridge",new Outcome("There's nothing but empty containers...","return")));
        kitchen.addChoice(new Choice("2. Check under the sink",new Outcome("It isn't opening. Maybe you could use something to pry it open.","return"), new Outcome("You pry open the cabinet door and find a red key.","gainItem", redkey,"pry")));
        kitchen.addChoice(new Choice( "3. Leave kitchen",new Outcome("You leave the kitchen.","nextScene1")));
        kitchen.addNextScene(investigation);

        //garage scene
        garage.setStoryText("It's dusty. An old car lies untouched. It probably doesn't run anymore. There could be useful tools laying around.");
        garage.setStoryTextRepeat("Keep looking around the garage?");
        garage.addChoice(new Choice("1. Check the metal chest",new Outcome("You find an old adjustable wrench in one of the drawers. Versatile. You pocket it.","gainItem", wrench)));
        garage.addChoice(new Choice("2. Check the shelves",new Outcome("In the back of the shelves you find a crowbar. You carry it along with you.","gainItem", crowbar)));
        garage.addChoice(new Choice("3. Leave the garage",new Outcome("You leave the garage.","nextScene1")));
        garage.addNextScene(investigation);

        //begin
        strangeRoom1.printScene();
        System.out.println("Type the number of your choice, and hit enter.");
        //Runs the play method of the output scene.
        Scanner scanner = new Scanner(System.in);
        strangeRoom1.choice(scanner.nextInt()).play();



    }
}
