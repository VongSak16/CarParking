package DAO;

import java.util.List;
import Models.Vehicle;
import java.util.ArrayList;

/**
 *
 * @author SAK
 */
public interface VehicleDao {
    List<Vehicle> vehicles = new ArrayList<>();
    List<Vehicle> getAllVehicles();
    void addVehicle(Vehicle vehicle);
}
