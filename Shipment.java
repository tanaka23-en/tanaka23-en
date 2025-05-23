class Shipment {
    private String shipmentId;
    private String description;
    private int quantity;
    private String pickupLocation;
    private String deliveryLocation;
    private String status; // e.g., "pending", "processed", "in transit", "delivered"
    private Customer customer;
    private Vehicle assignedVehicle;

    public Shipment(String shipmentId, String description, int quantity, String pickupLocation, String deliveryLocation, Customer customer) {
        this.shipmentId = shipmentId;
        this.description = description;
        this.quantity = quantity;
        this.pickupLocation = pickupLocation;
        this.deliveryLocation = deliveryLocation;
        this.status = "pending";
        this.customer = customer;
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getAssignedVehicle() {
        return assignedVehicle;
    }

    public void setAssignedVehicle(Vehicle assignedVehicle) {
        this.assignedVehicle = assignedVehicle;
    }
}
