package DAO;

import java.util.List;
import Models.Floor;
import java.util.ArrayList;

/**
 *
 * @author SAK
 */
public class FloorDaoImpl implements FloorDao {

    private List<Floor> floors = new ArrayList<>();
    
    @Override
    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    @Override
    public List<Floor> getAllFloors() {
        return floors;
    }
}
