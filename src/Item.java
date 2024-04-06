//item class for tool and key
public class Item {
    protected String name;

    public Item(String name){
        this.name = name;
    }
    public void gain(){
        Main.capabilities.add(name);
    }
}
