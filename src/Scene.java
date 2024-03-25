import java.util.Objects;

public class Scene {
    //Scene will hold the storyline given to you along with the changes that should be made to your inventory
    private String storyText;
    private String storyTextRepeat;
    private String transition;
    private Item obtainedItem;
    private Item usedItem;
    private Choice positiveChoice;
    private Choice negativeChoice;

    public Scene(String transition, Item obtainedItem, Item usedItem) {
        this.transition = transition;
        this.obtainedItem = obtainedItem;
        this.usedItem = usedItem;
    }
    public Scene(){

    }
    public void printScene(){
        System.out.println(storyText);
        System.out.println("You can:");
        System.out.println(positiveChoice);
        System.out.println("or");
        System.out.println(negativeChoice);
    }
    public Scene choice(String userChoice){
        if(Objects.equals(userChoice, positiveChoice.getDescription())){
            return
        }
        else if (Objects.equals(userChoice, negativeChoice.getDescription())) {
            if
            return this;
        }


    }

    //Getters and setters
    public Choice getPositiveChoice() {
        return positiveChoice;
    }
    public void setPositiveChoice(Choice positiveChoice) {
        this.positiveChoice = positiveChoice;
    }
    public Choice getNegativeChoice() {
        return negativeChoice;
    }
    public void setNegativeChoice(Choice negativeChoice) {
        this.negativeChoice = negativeChoice;
    }

    public String getStoryTextRepeat() {
        return storyTextRepeat;
    }

    public void setStoryTextRepeat(String storyTextRepeat) {
        this.storyTextRepeat = storyTextRepeat;
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
    public Item getObtainedItem() {
        return obtainedItem;
    }
    public void setObtainedItem(Item obtainedItem) {
        this.obtainedItem = obtainedItem;
    }
    public Item getUsedItem() {
        return usedItem;
    }
    public void setUsedItem(Item usedItem) {
        this.usedItem = usedItem;
    }
}
