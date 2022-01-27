import java.util.ArrayList;
import java.util.List;

class Vehicle {
    String vehicleName, vehicleColor, vehicleType; 
    Vehicle(String vehicleName, String vehicleColor, String vehicleType) {
        this.vehicleColor = vehicleColor;
        this.vehicleName = vehicleName;
        this.vehicleType = vehicleType;
    }
}

class Person {
    String name;
    Person(String name) {
        this.name = name;
    }
}

public class Test {
    public static void main(String[] args) {
        Person person = new Person("Bhaskar");
        ArrayList<Vehicle> list = new ArrayList<Vehicle>();
        
    }
}
