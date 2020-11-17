package parking;

/**
 *
 * @author Umaporn
 */
class ParkingLot {
    private String parkingLotId;
    private boolean available;

    ParkingLot(String parkingLotId) {
        this.parkingLotId = parkingLotId;
        this.available=true;
    }

    String getParkingLotId() {
        return parkingLotId;
    }

    boolean isAvailable() {
        return available;
    }

    void setAvailable(boolean available) {
        this.available = available;
    }
    
    @Override
    public String toString() {
        return "ParkingLot{" + "parkingLotId=" + parkingLotId + '}';
    }
    
    
    
    
}
