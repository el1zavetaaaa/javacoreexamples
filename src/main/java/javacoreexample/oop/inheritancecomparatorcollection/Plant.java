package javacoreexample.oop.inheritancecomparatorcollection;

public abstract class Plant {
    private String plantFamily;

    public Plant(String name) {
        this.plantFamily = name;
    }

    public String getPlantFamily() {
        return plantFamily;
    }

    public void setPlantFamily(String plantFamily) {
        this.plantFamily = plantFamily;
    }

    public abstract void display();
}
