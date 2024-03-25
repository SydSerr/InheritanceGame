public class Key extends Item {
    private String color;
    public Key(String color){
        //Basically takes 1 input- what color the key is. Then uses that to set the use as that + door because keys are for doors silly
        super(color + "door");
        this.color = color;
    }

}
