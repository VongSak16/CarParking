package DAO;

import Models.Floor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SAK
 */
public interface FloorDao {
    List<Floor> floors = new ArrayList<>();
    void addFloor(Floor floor);
    List<Floor> getAllFloors();
    Floor getFloorById(String id);
}
