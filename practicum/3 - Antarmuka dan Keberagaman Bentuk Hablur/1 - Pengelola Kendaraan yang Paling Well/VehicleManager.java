// 18222082
// 24y-03m-18d

import java.util.ArrayList;
import java.util.List;

public class VehicleManager {
    private List<Vehicle> list = new ArrayList<Vehicle>();

    /**
     * Menambahkan kendaraan ke array
     * 
     * @param vehicle objek Vehicle
     */
    public void addVehicle(Vehicle vehicle) {
        // Tambahkan kendaraan ke list
        // jawab
        list.add(vehicle);
    }

    /**
     * Memarkirkan semua kendaraan pada list menggunakan method park pada Vehicle
     */
    public void parkAllVehicles() {
        for (Vehicle vehicle : this.list) {
            vehicle.park();
        }
    }

    /**
     * Membuka semua pintu pada kendaraan yang memiliki pintu menggunakan method
     * openDoor pada Door
     */
    public void openAllDoors() {
        // jawab
        for( Vehicle vehicle : this.list) {
            if(vehicle instanceof Door) {
                ((Door) vehicle).openDoor();
            }
        }
    }

    /**
     * Menutup semua pintu pada kendaraan yang memiliki pintu menggunakan method
     * closeDoor pada Door
     */
    public void closeAllDoors() {
        // jawab
        for( Vehicle vehicle : this.list) {
            if(vehicle instanceof Door) {
                ((Door) vehicle).closeDoor();
            }
        }
    }

    /**
     * Menyalakan semua mesin pada kendaraan yang memiliki mesin menggunakan method
     * startEngine pada Engine
     */
    public void startAllEngines() {
        // jawab
        for (Vehicle vehicle : this.list) {
            if(vehicle instanceof Engine) {
                ((Engine) vehicle).startEngine();
            }
        }
    }

    /**
     * Mematikan semua mesin pada kendaraan yang memiliki mesin menggunakan method
     * stopEngine pada Engine
     */
    public void stopAllEngines() {
        // jawab
        for (Vehicle vehicle : this.list) {
            if(vehicle instanceof Engine) {
                ((Engine) vehicle).stopEngine();
            }
        }
    }

    /**
     * Mengganti semua ban pada kendaraan yang memiliki ban menggunakan method
     * changeTyre pada Tyre
     */
    public void changeAllTyres() {
        // jawab
        for (Vehicle vehicle : this.list) {
            if(vehicle instanceof Tyre) {
                ((Tyre) vehicle).changeTyre();
            }
        }
    }
}
