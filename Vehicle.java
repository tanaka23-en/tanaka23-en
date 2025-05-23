import java.util.ArrayList;
import java.util.List;
abstract class Vehicle {
    protected String vehicleId;
    protected String model;
    protected double maxLoad;
    protected Driver assignedDriver;
    protected List<Shipment> assignedShipments;

    public Vehicle(String vehicleId, String model, double maxLoad) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.maxLoad = maxLoad;
        this.assignedShipments = new ArrayList<>();
    }

    public abstract boolean checkOverload(Shipment shipment);

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(double maxLoad) {
        this.maxLoad = maxLoad;
    }

    public Driver getAssignedDriver() {
        return assignedDriver;
    }

    public void setAssignedDriver(Driver assignedDriver) {
        this.assignedDriver = assignedDriver;
    }

    public List<Shipment> getAssignedShipments() {
        return assignedShipments;
    }

    public void setAssignedShipments(List<Shipment> assignedShipments) {
        this.assignedShipments = assignedShipments;
    }
}
