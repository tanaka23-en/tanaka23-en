class ShipmentProcessor extends Thread {
    private Shipment shipment;
    private Vehicle vehicle;
    private Driver driver;

    public ShipmentProcessor(Shipment shipment, Vehicle vehicle, Driver driver) {
        this.shipment = shipment;
        this.vehicle = vehicle;
        this.driver = driver;
    }

    @Override
    public void run() {
        try {
            if (vehicle.checkOverload(shipment)) {
                throw new VehicleOverloadException("Vehicle overload for shipment: " + shipment.getShipmentId());
            }

            synchronized (vehicle) {
                shipment.updateStatus("processed");
                vehicle.getAssignedShipments().add(shipment);
                driver.updateShipmentStatus(shipment, "in transit");
            }

            // Simulate processing time
            Thread.sleep(2000);

            synchronized (vehicle) {
                shipment.updateStatus("delivered");
                driver.updateShipmentStatus(shipment, "delivered");
            }

        } catch (VehicleOverloadException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}