package javacoreexample.innerclasses;

public class MainClassForCar {
    public static void main(String[] args) {
        Car car = new Car("BMW");
        car.engine.setKm(1000);
        car.engine.work();

        Car flyCar = new Car("Fly Car"){
            @Override
            public void getModelOfTheCar() {
                super.getModelOfTheCar();
                System.out.println("Машина летит!");
            }
        };

        flyCar.getModelOfTheCar();
    }
}
