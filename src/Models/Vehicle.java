package Models;

import java.util.Date;

/**
 *
 * @author SAK
 */
public class Vehicle {

    private String vehicleId;
    private String floorId;
    private Date timeIn;
    private Date timeOut;

    public Vehicle(String vehicleId, String floorId, Date timeIn, Date timeOut) {

        this.vehicleId = vehicleId;
        this.floorId = floorId;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public String getFloorId() {
        return floorId;
    }
;
}
