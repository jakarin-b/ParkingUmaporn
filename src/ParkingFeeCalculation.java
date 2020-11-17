package parking;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class ParkingFeeCalculation {
    private int parkingRate;
    
    ParkingFeeCalculation(int parkingRatePerHour) {
        this.parkingRate=parkingRatePerHour;
    }
    
    private int getParkingHours(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        long minutes = ChronoUnit.MINUTES.between(fromDateTime, toDateTime);
        int hours = (int)(minutes / 60);
        int mins = (int)(minutes % 60);
        if (mins != 0) {
            hours += 1;
        }

        return hours;

    }
    int getFee(LocalDateTime fromDateTime, LocalDateTime toDateTime){
        int hours = getParkingHours(fromDateTime, toDateTime);
        return hours*this.parkingRate;
    }
}
