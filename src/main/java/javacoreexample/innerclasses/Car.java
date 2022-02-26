package javacoreexample.innerclasses;

public class Car {
    private String model;
    Engine engine = new Engine();

    public Car(String model) {
        this.model = model;
    }

    public Car() {
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void getModelOfTheCar(){
        System.out.println("Модель машины - " + model + ".");
    }

    class Engine {
        int km;
         public void work(){
             System.out.println("У машины есть пробег " + km + " км.");
         }

        public void setKm(int km) {
            this.km = km;
        }
    }
}
