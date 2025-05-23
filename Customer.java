import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Customer {
    private String customerId;
    private String name;
    private String contactDetails;
    private List<Shipment> shipments;
    private boolean isCorporate;
    private String nationalId; // For individuals
    private List<String> contactPersonnel; // For corporates

    public Customer(String customerId, String name, String contactDetails, boolean isCorporate) {
        this.customerId = customerId;
        this.name = name;
        this.contactDetails = contactDetails;
        this.isCorporate = isCorporate;
        this.shipments = new ArrayList<>();
        this.contactPersonnel = new ArrayList<>();
    }

    // Add a shipment
    public void addShipment(Shipment shipment) {
        shipments.add(shipment);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public List<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }

    public boolean isCorporate() {
        return isCorporate;
    }

    public void setCorporate(boolean corporate) {
        isCorporate = corporate;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public List<String> getContactPersonnel() {
        return contactPersonnel;
    }

    public void setContactPersonnel(List<String> contactPersonnel) {
        this.contactPersonnel = contactPersonnel;
    }

}
