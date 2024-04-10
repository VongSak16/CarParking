package DAO;

import Models.Vehicle;
import java.util.List;
import java.util.ArrayList;

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
}
