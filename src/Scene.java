public class Scene {
    //Scene will hold the storyline given to you along with the changes that should be made to your inventory
    private String storyText;
    private String transition;
    private Item obtainedItem;
    private Item lostItem;
    private Choice positiveChoice;
    private Choice negativeChoice;

    public Scene(String transition, Item obtainedItem, Item lostItem) {
        this.transition = transition;
        this.obtainedItem = obtainedItem;
        this.lostItem = lostItem;
    }
    public Scene(){

    }

    //Getters and setters
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
    public Item getLostItem() {
        return lostItem;
    }
    public void setLostItem(Item lostItem) {
        this.lostItem = lostItem;
    }
}
