import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Scene {
    //Scene will hold the storyline given to you along with the changes that should be made to your inventory
    private String storyText;
    private String storyTextRepeat;
    private final ArrayList<Choice> choices = new ArrayList<>();
    private final ArrayList<Scene> nextScenes = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    // Method to wait for user to press enter
    public static void waitForEnter() {
        System.out.println("(press enter to continue.)");
        scanner.nextLine(); // Waits for user to press enter
    }
    public Scene(){
    }
    public void printScene(){
        System.out.println(storyText);
        System.out.println("You can:");
        for(int i = 0; i <choices.size(); i++){
            System.out.println(i+1+". " + choices.get(i).getChoiceDescription());
        }
    }
    //Each Scene has multiple choices, and each choice can have multiple outcomes. This method, choice, outputs a scene to go to after a choice is picked.
    //It decides this based on what the capabilities are.
    //It can also do other things, like say "this.setRead = true;" which makes the game aware to do repeatText, and add items to the inventory and therefore to the capabilities
    public Scene choice(int userChoice){
        //Cycle through all choices to check if what the user typed matches an option
        for(int i = 0; i< choices.size(); i++) {//Cycle through every choice
            
            //Go through all the indexes in 'choices' until you find which index the user typed in.
            if (userChoice == i+1) {
                //Use this index to find the choice the user typed, and use our capabilities to determine what outcome will happen. Call that outcome pickedChoiceOutcome.
                Outcome pickedChoiceOutcome = getOutcome(i);
                System.out.println(pickedChoiceOutcome.getDescription());
                waitForEnter();
                switch (pickedChoiceOutcome.getEvent()) {
                    case "gainItem" -> {
                        Main.inventory.add(pickedChoiceOutcome.getGainedItem());
                        return this;
                    }
                    case "return" -> {
                        return this;
                    }
                    case "nextScene1" -> {
                        return nextScenes.get(0);
                    }
                    case "nextScene2" -> {
                        return nextScenes.get(1);
                    }
                    case "ending" -> {
                        System.out.println("You Escaped! Congrats");
                        System.exit(0);
                        return null;
                    }
                }

            }

        }
        //if it makes it out of this for loop, we need to make it so the user is told that that's not an option, and is given a chance to retype a choice. Remove the return null.
        return null;

    }

    //This method gets the outcome from the choice, taking in the index of the choice and reading from the capabilities array and the requirement value.
    private Outcome getOutcome(int i) {
        //Once you reach the correct index, name the choice at that index "pickedChoice"
        Choice pickedChoice = choices.get(i);
        //However, to get the outcome, we must check what the player can do. In a scenario with a locked door, the player will not be able to pass unless the capabilities array says it can open this door.
        //So, we will cycle through the capabilities array, and then compare that to the getOutcome class. If the outcome requirement string matches our capabilities, it happens.
        //However, if the outcome requirement string doesn't match a capability, then we default to outcome index of 0.
        Outcome pickedChoiceOutcome = pickedChoice.getOutcome(0);
        String requirement = "a";

        //These two loops cycle through all of Main.capabilities, a list of what you can do, and through the outcome requirements.
        for(int j = 0; j < Main.capabilities.size(); j++) {
            for (int k = 0; k < pickedChoice.getOutcomes().size(); k++) {
                if (pickedChoice.getOutcome(k).getRequirement().equals(Main.capabilities.get(j))) {
                    pickedChoiceOutcome = pickedChoice.getOutcome(k);
                }
            }
        }
        return pickedChoiceOutcome;
    }

    //Getters and setters
    public String getStoryTextRepeat() {
        return storyTextRepeat;
    }
    public void setStoryTextRepeat(String storyTextRepeat) {
        this.storyTextRepeat = storyTextRepeat;
    }
    public ArrayList<Choice> getChoices() {
        return choices;
    }
    public void addChoice(Choice newChoice) {
        choices.add(newChoice);
    }
    public ArrayList<Scene> getNextScenes() {
        return nextScenes;
    }
    public void addNextScene(Scene newScene) {
        nextScenes.add(newScene);
    }
    public String getStoryText() {
        return storyText;
    }
    public void setStoryText(String storyText) {
        this.storyText = storyText;
    }



    public void play() {
        this.printScene();
        this.choice(scanner.nextInt()).play();
    }
}
