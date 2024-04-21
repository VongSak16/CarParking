package DAO;

import Models.Vehicle;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class VehicleDaoImpl implements VehicleDao {

    private List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    @Override
    public Vehicle getVehicleById(String vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public int getVehicleCountFloorById(String floorId) {
        int count = 0;
        for (Vehicle vehicle : vehicles) {
            if (null == vehicle.getTimeOut() && vehicle.getFloor().getFloorId().equals(floorId)) {
                count++;
            }
        }
        return count;
    }
}
