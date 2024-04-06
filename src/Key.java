//key class that inherits from item
public class    Key extends Item {
    public Key(String color){
        //Basically takes 1 input- what color the key is. Then uses that to set the use as that + door because keys are for doors silly
        super(color + "key");
    }

}
