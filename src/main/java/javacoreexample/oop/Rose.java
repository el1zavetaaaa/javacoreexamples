package javacoreexample.oop;

public class Rose extends Plant{
    private String roseName;

    public Rose(String plantFamily, String roseGroup) {
        super(plantFamily);
        this.roseName = roseGroup;
    }

    public String getRoseName() {
        return roseName;
    }

    public void setRoseName(String roseName) {
        this.roseName = roseName;
    }

    @Override
    public void display() {
        System.out.println("Plant name: " + getPlantFamily() + "Rose group: " + roseName);
    }
}
