import java.util.HashSet;

//item class that tool and key inherit from
public class Item {
    protected String name;

    public Item(String name){
        this.name = name;
    }
    //gives the tools different capabilities used in the game such as "smash"
    public void gain(){
        Main.capabilities.add(name);
        clearDuplicates();
    }
    public void clearDuplicates(){
        HashSet<String> set = new HashSet<>(Main.capabilities);
        Main.capabilities.clear();
        Main.capabilities.addAll(set);
    }
}
