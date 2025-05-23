class LightVehicle extends Vehicle {
    private double maxWeight;
    private double length, width, height;

    public LightVehicle(String vehicleId, String model, double maxLoad, double maxWeight, double length, double width, double height) {
        super(vehicleId, model, maxLoad);
        this.maxWeight = maxWeight;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean checkOverload(Shipment shipment) {
        return shipment.getQuantity() > maxWeight; // Example check
    }
}
