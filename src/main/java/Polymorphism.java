class Vehicle {
    public void getWheelsNumber() {
        System.out.println("Cannot get number of wheels");
    }
}

class Car extends Vehicle {
    public void getWheelsNumber() {
        System.out.println("Number of wheels: 4");
    }
}

class Bycicle extends Vehicle {
    public void getWheelsNumber() {
        System.out.println("Number of wheels: 2");
    }
}

public class Polymorphism {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Car car = new Car();
        Bycicle bycicle = new Bycicle();

        vehicle.getWheelsNumber();
        car.getWheelsNumber();
        bycicle.getWheelsNumber();
    }
}
