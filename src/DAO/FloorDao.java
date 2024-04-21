package DAO;

import Models.Floor;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedHashMap;

/**
 *
 * @author SAK
 */
public interface FloorDao {
    Dictionary<Floor, Integer> floors = new Hashtable<>(); // create tbl_floor with query count of vehicle in it
    void addFloor(Floor floor); //insert
    LinkedHashMap<Floor, Integer> getAllFloors(); //select * from tbl_floor;
    Floor getFloorById(String floorId); //select * from tbl_floor where floorid = "";
    void setVehicleCountById(String floorId, int amount);
}
