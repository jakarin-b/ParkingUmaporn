package parking;
import java.time.LocalDateTime;
import vehicle.Vehicle;
/**
 *<h1>A Simple Parking Application</h1>
 * The parking area contains parking lots for vehicle parking 
 * 
 * @author Umaporn
 * @version 1.0
 * @since 2020-11-16
 */
public class Parking {
    private final String parkingName;
    private final ParkingLot parkingLots[];
    private final ParkingFeeCalculation parkingFeeCalculation;
    private final ParkedVehicle[] parkedVehicles;
    private int numberOfParkedVehicle;
    
    public Parking(String parkingName, int parkingRate, int numberOfParkingLot) {
        this.parkingName = parkingName;
        this.parkingFeeCalculation= new ParkingFeeCalculation(parkingRate);
        this.parkingLots=new ParkingLot[numberOfParkingLot];
        setParkingLotAllAvailable();
        this.parkedVehicles=new ParkedVehicle[numberOfParkingLot];
     
    }
   
    private void setParkingLotAllAvailable(){
        for (int i = 0; i < parkingLots.length; i++) {
            parkingLots[i] = new ParkingLot("SIT-"+(100+i));   
            System.out.println(parkingLots[i]);
        }
    }
     /**
     * remove the exit parked vehicle at the specified position in this parking and move the last parked vehicle to the removed position.
     * @param exitVehicleIndex  the index of the exit parked vehicle to be removed 
     * @return true if this vehicle at the specified position was removed from the parking 
     * @see ParkedVehicle
     */
    private boolean removeParkedVehicle(int exitVehicleIndex){
        parkedVehicles[exitVehicleIndex].getParkedLot().setAvailable(true);
        numberOfParkedVehicle--;
        parkedVehicles[exitVehicleIndex]=parkedVehicles[numberOfParkedVehicle];
        return true;
    }
    
    private boolean addParkedVehicle(ParkedVehicle inVehicle){
        if(numberOfParkedVehicle==parkedVehicles.length) return false;
        parkedVehicles[numberOfParkedVehicle] = inVehicle;
        parkedVehicles[numberOfParkedVehicle].getParkedLot().setAvailable(false);
        numberOfParkedVehicle++;
        return true;
    }
    
  
    private int getParkedVehicleAt(Vehicle exitVehicle){
        for (int i = 0; i < parkedVehicles.length; i++) {
           if(parkedVehicles[i]!=null && (parkedVehicles[i].getParkedVehicle()).equals(exitVehicle)){
               return i;
           }
        }
        return -1;
    } 
    
    private int getAvailableLotAt(){
          for(int i=0;i<parkingLots.length;i++){
             if(parkingLots[i].isAvailable()){
                 return i;
             }
          }
          return -1;
    }
    
    public int getTotalParkingLots() {
        return parkingLots.length;
    }
    
    public int getNumberOfAvailableParkingLots() {
        System.out.println("last: "+numberOfParkedVehicle);
        return parkingLots.length-numberOfParkedVehicle;
    }
	/** Returns parking lot id if this parking contains the specified vehicle. 
     * 
     * @param exitVehicle the parked vehicle to search for 
     * @return parking lot id or "not found" if this parking does not contain this parked vehicle
	 * @see #exit(vehicle.Vehicle) 
     * @see #exit(vehicle.Vehicle, java.time.LocalDateTime) 
     */
    public String findParkingLot(Vehicle exitVehicle){
        int foundAt=getParkedVehicleAt(exitVehicle);
        if(foundAt==-1)return "Not Found";
        return parkedVehicles[foundAt].getParkedLot().toString();
    }
    
    public boolean entry(Vehicle vehicle) {
        int availableLot=getAvailableLotAt();
        if(availableLot==-1)return false;
        ParkedVehicle inVehicle=new ParkedVehicle(vehicle, parkingLots[availableLot]);
        inVehicle.stampTimeIn();
        return addParkedVehicle(inVehicle);
    }

    public boolean exit(Vehicle vehicle) {
       return exit(vehicle, LocalDateTime.now());
    }
    
    public boolean exit(Vehicle vehicle, LocalDateTime exitTime) {
        int foundAt=getParkedVehicleAt(vehicle);
        if(foundAt==-1)
            return false;
        parkedVehicles[foundAt].stampTimeOut(exitTime);
        int fee=parkingFeeCalculation.getFee(parkedVehicles[foundAt].getTimeIn(), parkedVehicles[foundAt].getTimeOut());
        System.out.println("your parking fee: "+fee);
        return removeParkedVehicle(foundAt);
    }

    @Override
    public String toString() {
        return "Parking{" + "parkingName=" + parkingName + ",available =" + (parkingLots.length-numberOfParkedVehicle) + " parking lots, lastParkedVehicle=" + numberOfParkedVehicle + '}';
    }

    
    
    
    
    
}
