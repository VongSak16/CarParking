package Models;

import java.util.Date;

/**
 *
 * @author SAK
 */
public class Vehicle {

    private String vehicleId;
    private Date timeIn;
    private Date timeOut;
    
    private Floor floor;

    public Vehicle(String vehicleId, Floor floor, Date timeIn, Date timeOut) {

        this.vehicleId = vehicleId;
        this.floor = floor;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public Date getTimeIn() {
        return timeIn;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public Floor getFloor() {
        return floor;
    }
    
    public void setTimeOut(Date newtimeOut) {
    this.timeOut = newtimeOut;
  }
}
