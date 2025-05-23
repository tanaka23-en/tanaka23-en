class HeavyVehicle extends Vehicle {
    private String type; // e.g., container, open, refrigerated

    public HeavyVehicle(String vehicleId, String model, double maxLoad, String type) {
        super(vehicleId, model, maxLoad);
        this.type = type;
    }

    @Override
    public boolean checkOverload(Shipment shipment) {
        return shipment.getQuantity() > maxLoad; // Example check
    }
}
