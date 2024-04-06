import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Scene {
    //Scene will hold the storyline given to you along with the changes that should be made to your inventory
    private String storyText;
    private String storyTextRepeat;
    private final ArrayList<Choice> choices = new ArrayList<>();
    private final ArrayList<Scene> nextScenes = new ArrayList<>();
    private boolean scenePlayed = false;

    // Method to wait for user to press enter
    public static void waitForEnter() {
        System.out.println("Press enter to continue.");
        Main.scanner.nextLine(); // Waits for user to press enter1
    }

    public Scene(){
    }
    public void printScene(){
        if(scenePlayed && storyTextRepeat != null){
            System.out.println(storyTextRepeat);
        }
        else{
            System.out.println(storyText);
        }
        //sets scenePlayed
        scenePlayed = true;
        System.out.println("You can:");
        for (Choice choice : choices) {
            System.out.println(choice.getChoiceDescription());
        }
    }

    //Each Scene has multiple choices, and each choice can have multiple outcomes. This method, choice, outputs a scene to go to after a choice is picked.
    //It decides this based on what the capabilities are.
    //It can also do other things, like say "this.setRead = true;" which makes the game aware to do repeatText, and add items to the inventory and therefore to the capabilities
    public Scene choice(int userChoice){
        //Cycle through all choices to check if what the user typed matches an option
        //Get current choice of cycle, call this pickedChoice
        for (Choice pickedChoice : choices) {//Cycle through all of choices
            //However, pickedChoice doesn't really make sense as "picked" if it's not picked. This if statement makes sure it is picked.
            if (userChoice == Character.getNumericValue(pickedChoice.getChoiceDescription().charAt(0))) {
                //If it does match, get the outcome and do the appropriate thing, like giving an item.

                //However, to get the outcome, we must check what the player can do. In a scenario with a locked door, the player will not be able to pass unless the capabilities array says it can open this door.
                //So, we will cycle through the capabilities array, and then compare that to the getOutcome class. If the outcome requirement string matches our capabilites, it happens.
                //However, if the outcome requirement string doesn't match a capability, then we default to outcome index of 0.
                Outcome pickedChoiceOutcome = pickedChoice.getOutcome(0);

                //Cycle through all capabilities
                for (int j = 0; j < Main.capabilities.size(); j++) {
                    //Cycle through all outcomes
                    for (int k = 0; k < pickedChoice.getOutcomes().size(); k++) {
                        //Cycle through all requirements for every outcome
                        for (int l = 0; l < pickedChoice.getOutcomes().get(k).getRequirements().size(); l++) {
                            //This one's a bit of a doozy in terms of readability
                            //It means that we look at the pickedChoice, then look at the first outcome (k) and it's requirement (l).
                            //Then we cycle through the requirements of the first outcome, by using the for loop for l
                            //Then we cycle through the outcomes, repeating the previous requirement cycle every time.
                            //With every one of these cycles, we compare the requirement from the requirements from the outcome from the choice.
                            //We compare this requirement to the current capability.
                            if (Objects.equals(pickedChoice.getOutcome(k).getRequirements().get(l), Main.capabilities.get(j))) {
                                pickedChoiceOutcome = pickedChoice.getOutcome(k);
                            }
                        }
                    }
                }
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
                    case "nextScene3" -> {
                        return nextScenes.get(2);
                    }
                    case "ending" -> {
                        System.out.println("Congratulations! You Escaped! Restart to play again!");
                        System.exit(0);
                    }

                    default -> throw new IllegalStateException("Unexpected value: " + pickedChoiceOutcome.getEvent());
                }
            }
        }
        //if it makes it out of this for loop, we need to make it so the user is told that that's not an option, and is given a chance to retype a choice. Remove the return null.
        return null;

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
    public boolean isScenePlayed() {
        return scenePlayed;
    }
    public void setScenePlayed(boolean scenePlayed) {
        this.scenePlayed = scenePlayed;
    }


    public void play() {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        this.printScene();
        this.choice(scanner.nextInt()).play();

    }
}
