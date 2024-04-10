package Models;

import java.util.ArrayList;

/**
 *
 * @author SAK
 */
public class Floor {

    private String floorId;
    private int capacity;
    
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    public Floor(String floorId, int capacity) {
        this.floorId = floorId;
        this.capacity = capacity;
    }

    public String getFloorId() {
        return floorId;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Vehicle> getVehicle() {
        return vehicles;
    }
}
