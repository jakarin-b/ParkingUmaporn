
import java.time.LocalDateTime;
import java.time.Month;
import parking.Parking;
import vehicle.Vehicle;

/**
 *
 * @author Umaporn
 */
public class TestParking {

    public static void main(String[] args) {
        LocalDateTime exitTime1 = LocalDateTime.of(2020, Month.NOVEMBER, 17, 23, 50);
        LocalDateTime exitTime2 = LocalDateTime.of(2020, Month.NOVEMBER, 17, 18, 40);
        LocalDateTime exitTime3 = LocalDateTime.of(2020, Month.NOVEMBER, 17, 05, 30);

        Parking sitParking = new Parking("LX Parking", 10, 10);
        System.out.println("Total Parking Lots: " + sitParking.getTotalParkingLots());
        System.out.println("Number of Available Parking Lots: " + sitParking.getNumberOfAvailableParkingLots());

        Vehicle v1 = new Vehicle("AA-1100", 4);
        Vehicle v2 = new Vehicle("BB-2345", 4);
        Vehicle v3 = new Vehicle("CC-5555", 4);

        System.out.println("v1 entry:" + sitParking.entry(v1));
        System.out.println("v2 entry:" + sitParking.entry(v2));

        System.out.println("v2 at: " + sitParking.findParkingLot(v2));
        
        System.out.println("v3 entry:" + sitParking.entry(v3));
        
        System.out.println("v1 exit:" + sitParking.exit(v1, exitTime1));
        System.out.println("v3 exit:" + sitParking.exit(v3, exitTime3));
        System.out.println("v2 exit:" + sitParking.exit(v2, exitTime2));
        

    }
}
