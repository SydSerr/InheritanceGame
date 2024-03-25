import java.util.ArrayList;

public class Item {
    private String name;
    private String use;
    public Item(String name, String use){
        this.name = name;
        this.use = use;
    }
    public Item(String use){
        this.use = use;
    }



    public String getUse() {
        return use;
    }
    public String setUse() {
        return use;
    }

}
