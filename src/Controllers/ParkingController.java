package Controllers;

import Models.Floor;
import DAO.FloorDao;
import DAO.FloorDaoImpl;
import Models.Vehicle;
import DAO.VehicleDao;
import DAO.VehicleDaoImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SAK
 */
public class ParkingController {

    private FloorDao floorDao = new FloorDaoImpl();
    private VehicleDao vehicleDao = new VehicleDaoImpl();

    public ParkingController() {

        floorDao.addFloor(new Floor("FG", 10));
        floorDao.addFloor(new Floor("F1", 10));
        floorDao.addFloor(new Floor("F2", 10));
    }

    public void updateFloorTable(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);

        List<Floor> floors = floorDao.getAllFloors();
        for (Floor floor : floors) {
            Object[] rowData = {floor.getFloorId(), floor.getVehicle().size(), floor.getCapacity()};
            tableModel.addRow(rowData);
        }
    }

    public void updateFloorCombo(JComboBox<String> cbo) {
        List<String> floorsID = new ArrayList<>();
        for (Floor floor : floorDao.getAllFloors()) {
            floorsID.add(floor.getFloorId());
        }
        cbo.removeAllItems();
        for (String item : floorsID) {
            cbo.addItem(item);
        }
    }

    int count = 0;

    public void CheckIn(String selectedFloorId) {

        Date date = new Date();
        count++;
        vehicleDao.addVehicle(new Vehicle(count + "", floorDao.getFloorById(selectedFloorId), date, date));
    }

    public void updateVehicleTable(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);

        List<Vehicle> vehicles = vehicleDao.getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            Object[] rowData = {
                vehicle.getVehicleId(), 
                vehicle.getFloor().getFloorId(), 
                vehicle.getTimeIn(), 
                vehicle.getTimeOut(),
                "",
                ""
            };
            tableModel.addRow(rowData);
        }
    }

    public void CheckOut() {

    }

}
