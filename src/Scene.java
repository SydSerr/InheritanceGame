import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Scene {
    //Scene will hold the storyline given to you along with the changes that should be made to your inventory
    private String storyText;
    private String storyTextRepeat;
    private final ArrayList<Choice> choices = new ArrayList<>();
    private final ArrayList<Scene> nextScenes = new ArrayList<>();
    public Scene(){
    }
    public void printScene(){
        System.out.println(storyText);
        System.out.println("You can:");
        for(int i = 0; i < choices.size(); i++){
            System.out.println(choices.get(i).getChoiceDescription());
            if(i < choices.size()-1) {
                System.out.println("or");
            }
        }
    }
    //Each Scene has multiple choices, and each choice can have multiple outcomes. This method, choice, outputs a scene to go to after a choice is picked.
    //It decides this based on what the capabilities are.
    //It can also do other things, like say "this.setRead = true;" which makes the game aware to do repeatText, and add items to the inventory and therefore to the capabilities
    public Scene choice(String userChoice){
        //Cycle through all choices to check if what the user typed matches an option
        for(int i = 0; i< choices.size(); i++) {//Cycle

            Choice pickedChoice = choices.get(i);//Get current choice of cycle


            //
            //REPLACE WITH 1. 2. 3. SYSTEM. DON'T DO USERCHOICE.EQUALS(PICKEDCHOICE). ALSO CHANGE USERCHOICE INSIDE OF THE MAIN TO BE AN INT.
            //

            //Then, compare the current cycle's choice matches the user's input
            if (userChoice.equals(pickedChoice.getChoiceDescription())) {
                //If it does match, get the outcome and do the appropriate thing, like giving an item.

                //However, to get the outcome, we must check what the player can do. In a scenario with a locked door, the player will not be able to pass unless the capabilities array says it can open this door.
                //So, we will cycle through the capabilities array, and then compare that to the getOutcome class. If the outcome requirement string matches our capabilites, it happens.
                //However, if the outcome requirement string doesn't match a capability, then we default to outcome index of 0.
                Outcome pickedChoiceOutcome = pickedChoice.getOutcome(0);
                String requirement = "a";

//                for(int j = 0; j < Main.capabilities.size(); j++) {
//                    for (int k = 0; k < pickedChoice.get)
//                    if (pickedChoice.getOutcome(1).getRequirement() == Main.capabilities.get(j)) {
//                        pickedChoiceOutcome = pickedChoice.getOutcome(1);
//                    }
//                }

                switch (pickedChoiceOutcome.getDescription()) {

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
                        return nextScenes.get(3);
                    }
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


    public void play() {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        this.printScene();
        this.choice(scanner.nextLine()).play();
    }
}
