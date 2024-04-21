package Controllers;

import Models.Floor;
import DAO.FloorDao;
import DAO.FloorDaoImpl;
import Models.Vehicle;
import DAO.VehicleDao;
import DAO.VehicleDaoImpl;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author SAK
 */
public class ParkingController {

    private FloorDao floorDao = new FloorDaoImpl();
    private VehicleDao vehicleDao = new VehicleDaoImpl();

    public ParkingController() {
        floorDao.addFloor(new Floor("FG", 10));
        floorDao.addFloor(new Floor("F1", 11));
        floorDao.addFloor(new Floor("F2", 12));
    }

    public LinkedHashMap<Floor, Integer> getAllFloors() {
        return floorDao.getAllFloors();
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleDao.getAllVehicles();
    }

    int ma_id = 0;

    public void CheckIn(String selectedFloorId) {

        Floor selectedFloor = floorDao.getFloorById(selectedFloorId);
        if (selectedFloor == null) {
            return;
        }

        //int vehicleCount = vehicleDao.getVehicleCountFloorById(selectedFloorId);
        if (vehicleDao.getVehicleCountFloorById(selectedFloorId) >= selectedFloor.getCapacity()) {
            return;
        }

        Date date = new Date();

        ma_id++;
        vehicleDao.addVehicle(new Vehicle(ma_id + "", selectedFloor, date, null));
        floorDao.setVehicleCountById(selectedFloorId, vehicleDao.getVehicleCountFloorById(selectedFloorId));
    }

    public String CheckOut(String selectedVehicleId, Date newTimeOut) {

        Vehicle selectedVehicle = vehicleDao.getVehicleById(selectedVehicleId);

        if (selectedVehicle.getTimeOut() == null) {

            SimpleDateFormat formatter = new SimpleDateFormat("H:m:s a dd/MM/yy");
            String strPrint = "Vehicle ID: " + selectedVehicle.getVehicleId() + "\n"
                    + "Floor ID: " + selectedVehicle.getFloor().getFloorId() + "\n"
                    + "Time In: " + formatter.format(selectedVehicle.getTimeIn()) + "\n"
                    + "Time Out: " + formatter.format(newTimeOut) + "\n"
                    + "Duration: " + CalculateDuration(selectedVehicle.getTimeIn(), newTimeOut) + "\n"
                    + "--------------------------------" + "\n"
                    + "Cost: " + CalculateCost(selectedVehicle.getTimeIn(), newTimeOut) + " \n";
            return strPrint;
        } else {
            return "he/she already out!";
        }
    }

    public void ConfirmPayment(String selectedVehicleId, Date TimeOut) {
        Vehicle selectedVehicle = vehicleDao.getVehicleById(selectedVehicleId);
        String selectedFloorId = selectedVehicle.getFloor().getFloorId();

        if (vehicleDao.getVehicleCountFloorById(selectedFloorId) <= 0) {
            return;
        }
        selectedVehicle.setTimeOut(TimeOut);
        floorDao.setVehicleCountById(selectedFloorId, vehicleDao.getVehicleCountFloorById(selectedFloorId));

    }

    public String CalculateDuration(Date timeIn, Date timeOut) {

        if (timeOut != null) {
            long durationMillis = timeOut.getTime() - timeIn.getTime();
            long durationSeconds = durationMillis / 1000;
            long hours = durationSeconds / 3600;
            long minutes = (durationSeconds % 3600) / 60;
            long seconds = durationSeconds % 60;

            String durationFormatted = String.format("%02d:%02d:%02d", hours, minutes, seconds);

            return durationFormatted;
        } else {
            return "";
        }
    }

    public String CalculateCost(Date timeIn, Date timeOut) {

        if (timeOut != null) {
            long durationMillis = timeOut.getTime() - timeIn.getTime();
            long durationSeconds = durationMillis / 1000;
            long hours = durationSeconds / 3600;
            long minutes = (durationSeconds % 3600) / 60;
            long seconds = durationSeconds % 60;

            double cost = 0;
            if (hours < 1) {
                cost = 0;
            } else if (hours < 2) {
                cost = 2000;
            } else if (hours < 3) {
                cost = 3000;
            } else if (hours < 4) {
                cost = 4000;
            } else if (hours < 5) {
                cost = 5000;
            } else if (hours < 12) {
                cost = 6000;
            }
            // Check if exit time is on a different day than entry time
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(timeIn);
            int entryDay = calendar.get(Calendar.DAY_OF_WEEK);

            calendar.setTime(timeOut);
            int exitDay = calendar.get(Calendar.DAY_OF_WEEK);

            if (entryDay != exitDay) {
                cost = 20000;
            }
            return "$ " + cost;
        
        } else {
            return "";
        }
    }
}
