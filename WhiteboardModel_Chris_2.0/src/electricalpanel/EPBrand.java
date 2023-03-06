package electricalpanel;

public enum EPBrand {
    SIEMENS("Siemens"),
    SQUARE_D("Square D"),
    GE("General Electric");

    private String display;

    EPBrand(String display){
        this.display = display;
    }

    public String display() {
        return display;
    }

    public String toString(){
        return display();
    }
}
