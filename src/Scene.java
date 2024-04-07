import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


public class Scene {
    //Scene will hold the storyline given to you along with the changes that should be made to your inventory
    private String storyText;
    private String storyTextRepeat;
    private final ArrayList<Choice> choices = new ArrayList<>();
    private final ArrayList<Scene> nextScenes = new ArrayList<>();
    private boolean scenePlayed = false;
    private static final Scanner enterscanner = new Scanner(System.in);
    private static final Scanner intscanner = new Scanner(System.in);

    // Method to wait for user to press enter
    public static void waitForEnter() {
        System.out.println("Press enter to continue.");
        enterscanner.nextLine(); // Waits for user to press enter
    }

    public Scene() {
    }

    public void printScene() {
        //Prints the story text
        if (scenePlayed && storyTextRepeat != null) {
            System.out.println(storyTextRepeat);
        } else {
            System.out.println(storyText);
        }
        //sets scenePlayed
        scenePlayed = true;
        //Prints the choices
        System.out.println("You can:");
        for (Choice choice : choices) {
            System.out.println(choice.getChoiceDescription());
        }
    }

    /* Each Scene has multiple choices, and each choice can have multiple outcomes. This method, choice, outputs a scene to go to after a choice is picked.
    It decides this based on what the capabilities are.
    It can also do other things, like say "this.setRead = true;" which makes the game aware to do repeatText, and add items to the inventory and therefore to the capabilities */
    public Scene choice(int userChoice) {

        /* Cycle through all choices to check if what the user typed matches an option
        Get current choice of cycle, call this pickedChoice */
        for (Choice pickedChoice : choices) {

            //This if statement makes sure it is picked.
            if (userChoice == Character.getNumericValue(pickedChoice.getChoiceDescription().charAt(0))) {
                AtomicReference<Outcome> pickedChoiceOutcome = new AtomicReference<>(pickedChoice.getOutcome(0));

                /* If it does match, get the outcome and do the appropriate thing, like giving an item.
                However, to get the outcome, we must check what the player can do. In a scenario with a locked door, the player will not be able to pass unless the capabilities array says it can open this door.
                So, we will cycle through the capabilities array, and then compare that to the getOutcome class. If the outcome requirement string matches our capabilities, it happens.
                However, if the outcome requirement string doesn't match a capability, then we default to outcome index of 0.
                Additionally, this default has to be atomic as we change it off of getOutcome(0) inside a lambda expression if we recognize the outcome has all requirements met */

                //Cycle through all outcomes
                pickedChoice.getOutcomes().forEach(outcome -> {
                    //IDE demands this is atomic because it is in a lambda, and it ensures thread safety as it runs
                    AtomicInteger requirementsCounter = new AtomicInteger(0);
                    //Cycle through all requirements for every outcome
                    outcome.getRequirements().forEach(requirement -> {
                        //Cycle through all capabilities
                        Main.capabilities.forEach(capability -> {
                            //Need to make sure all requirements are met. So, this if statement does that by going through all capabilities, and adding to the counter everytime the capability is met.
                            if (Objects.equals(requirement, capability)) {
                                requirementsCounter.getAndIncrement();
                            }
                        });
                    });
                    if (requirementsCounter.get() >= outcome.getRequirements().size()) {
                        pickedChoiceOutcome.set(outcome);
                    }
                });

                System.out.println(pickedChoiceOutcome.get().getDescription());
                waitForEnter();

                switch (pickedChoiceOutcome.get().getEvent()) {

                    case "gainItem" -> {
                        pickedChoiceOutcome.get().getGainedItem().gain();
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
                        System.out.println("Congratulations! You Escaped! Restart to play again!");
                        System.exit(0);
                    }

                    default ->
                            throw new IllegalStateException("Unexpected value: " + pickedChoiceOutcome.get().getEvent());
                }
            }
        }
        //if user number picked isn't a choice number (validChoice): shows error message and prompts user to continue to try again
        System.out.println("Not a Valid Option! Continue to retry!");
        waitForEnter();
        return this;

    }

    //Getters and setters
    public void setStoryTextRepeat(String storyTextRepeat) {
        this.storyTextRepeat = storyTextRepeat;
    }

    public void addChoice(Choice newChoice) {
        choices.add(newChoice);
    }

    public void addNextScene(Scene newScene) {
        nextScenes.add(newScene);
    }

    public void setStoryText(String storyText) {
        this.storyText = storyText;
    }

    public void play() {
        this.printScene();
        this.choice(intscanner.nextInt()).play();

    }
}

