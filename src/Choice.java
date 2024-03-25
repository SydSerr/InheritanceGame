public class Choice {
    private boolean positive;
    //Text description for the user to read
    private String description;
    //Not user end- used for seeing what the code should do next. Can either be return, continue, die,
    private String ending;

    public Choice(boolean positive, String description, String ending) {
        this.positive = positive;
        this.description = description;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
