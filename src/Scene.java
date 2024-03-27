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
            System.out.println(choices.get(i).getDescription());
            if(i < choices.size()-1) {
                System.out.println("or");
            }
        }
    }
    //Will comment later
    public Scene choice(String userChoice){
        //Cycle through all choices to check if what the user typed matches an option
        for(int i = 0; i< choices.size(); i++) {//Cycle
            Choice pickedChoice = choices.get(i);//Get current choice of cycle
            if (userChoice.equals(pickedChoice.getDescription())) {//Check if user input matches the current cycle's choice's description.
                //If it does match, get the outcome and do the appropriate thing, like giving an item.
                if (pickedChoice.getOutcome(i).equals("gainItem")){
                    Main.inventory.add(gainedItem);
                    return this;
                }
                else if (pickedChoice.getOutcome(i).equals("return")){
                    return this;
                }
                else if (pickedChoice.getOutcome(i).equals("nextScene1")){
                    return nextScenes.get(0);
                }
                else if (pickedChoice.getOutcome(i).equals("nextScene2")){
                    return nextScenes.get(1);
                }
                else if (pickedChoice.getOutcome(i).equals("nextScene3")){
                    return nextScenes.get(2);
                }
                else if (pickedChoice.getOutcome(i).equals("die")){
                    System.out.println("You Died");
                    //end program immediately
                    System.exit(0);
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

    public String getTransition() {
        return transition;
    }
    public void setTransition(String transition) {
        this.transition = transition;
    }
    public Item getGainedItem() {
        return gainedItem;
    }
    public void setGainedItem(Item gainedItem) {
        this.gainedItem = gainedItem;
    }
    public Item getUsedItem() {
        return usedItem;
    }
    public void setUsedItem(Item usedItem) {
        this.usedItem = usedItem;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        this.printScene();
        this.choice(scanner.nextLine()).play();
    }
}
