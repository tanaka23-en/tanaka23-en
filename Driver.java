class Driver {
    private String driverId;
    private String name;
    private String licenseNumber;
    private Vehicle currentVehicle;

    public Driver(String driverId, String name, String licenseNumber) {
        this.driverId = driverId;
        this.name = name;
        this.licenseNumber = licenseNumber;
    }

    public void updateShipmentStatus(Shipment shipment, String status) {
        shipment.updateStatus(status);
    }

    public String getDriverId() {
        return driverId;
    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }
}