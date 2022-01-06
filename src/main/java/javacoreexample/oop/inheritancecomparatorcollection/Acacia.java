package javacoreexample.oop.inheritancecomparatorcollection;

public class Acacia extends Plant {
    private String acaciaName;

    public Acacia(String plantFamily, String acaciaName) {
        super(plantFamily);
        this.acaciaName = acaciaName;
    }

    public String getAcaciaName() {
        return acaciaName;
    }

    public void setAcaciaName(String acaciaName) {
        this.acaciaName = acaciaName;
    }

    @Override
    public void display() {
        System.out.println("Plant family: " + getPlantFamily() + " Acacia group: " + acaciaName);
    }
}
