import java.util.HashSet;

//item class for tool and key
public class Item {
    protected String name;

    public Item(String name){
        this.name = name;
    }
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
