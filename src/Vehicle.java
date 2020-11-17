package vehicle;
import java.util.Objects;
public class Vehicle {
    private String licensePlate;
    private int wheels;

    public Vehicle(String licensePlate, int wheels) {
        this.licensePlate = licensePlate;
        this.wheels = wheels;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getWheels() {
        return wheels;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {

            return false;
        }
        final Vehicle other = (Vehicle) obj;

        if (!Objects.equals(this.licensePlate, other.licensePlate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "licensePlate=" + licensePlate + ", wheels=" + wheels;
    }

}
