package DAO;

import java.util.List;
import Models.Vehicle;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author SAK
 */
public interface VehicleDao {
    List<Vehicle> vehicles = new ArrayList<>();
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(String vehicleId);
    void addVehicle(Vehicle vehicle);
    int getVehicleCountFloorById(String floorId);
}
