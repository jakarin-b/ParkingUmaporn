
package parking;
import java.time.LocalDateTime;
import vehicle.Vehicle;


class ParkedVehicle {
    private Vehicle parkedVehicle;
    private ParkingLot parkedLot;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;

    ParkedVehicle(Vehicle parkedVehicle, ParkingLot parkedLot) {
        this.parkedVehicle = parkedVehicle;
        this.parkedLot=parkedLot;
    }
   
    void stampTimeIn(){
        timeIn=LocalDateTime.now();
    }
   
    void stampTimeOut(){
        timeOut = LocalDateTime.now();
    }
    
    void stampTimeIn(LocalDateTime in){
        timeIn=in;
    }
   
    void stampTimeOut(LocalDateTime out){
        timeOut = out;
    }

    Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
    
    ParkingLot getParkedLot() {
        return parkedLot;
    }

    LocalDateTime getTimeIn() {
        return timeIn;
    }

    LocalDateTime getTimeOut() {
        return timeOut;
    }
    
    @Override
    public String toString() {
        return "VehicleTimeStamp{" + "parkedVehicle=" + parkedVehicle + ", timeIn=" + timeIn + ", timeOut=" + timeOut + '}';
    }
    
    
}
