package Models;

import java.util.ArrayList;

/**
 *
 * @author SAK
 */
public class Floor {

    private String floorId;
    private int capacity;
    

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

}
