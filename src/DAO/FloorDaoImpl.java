package DAO;

import Models.Floor;
import java.util.LinkedHashMap;

public class FloorDaoImpl implements FloorDao {

    private LinkedHashMap<Floor, Integer> floors = new LinkedHashMap<>();

    @Override
    public void addFloor(Floor floor) {
        floors.put(floor, 0);
    }

    @Override
    public LinkedHashMap<Floor, Integer> getAllFloors() {
        return floors;
    }

    @Override
    public Floor getFloorById(String floorId) {
        for (Floor floor : floors.keySet()) {
            if (floor.getFloorId().equals(floorId)) {
                return floor;
            }
        }
        return null;
    }
    
    @Override
    public void setVehicleCountById(String floorId, int amount) {
        for (Floor floor : floors.keySet()) {
            if (floor.getFloorId().equals(floorId)) {
                floors.put(floor, amount);
                return;
            }
        }
    }
}
