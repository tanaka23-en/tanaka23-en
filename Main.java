import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Custom Exception for Vehicle Overload
class VehicleOverloadException extends Exception {
    public VehicleOverloadException(String message) {
        super(message);
    }
}


public class Main {
    private static List<Customer> customers = new ArrayList<>();
    private static List<Vehicle> vehicles = new ArrayList<>();
    private static List<Driver> drivers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Customer");
            System.out.println("2. Add Vehicle");
            System.out.println("3. Add Driver");
            System.out.println("4. Request Shipment");
            System.out.println("5. Exit");
            System.out.println("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    addVehicle();
                    break;
                case 3:
                    addDriver();
                    break;
                case 4:
                    requestShipment();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private static void addCustomer() {
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact Details: ");
        String contactDetails = scanner.nextLine();
        System.out.print("Is Corporate (true/false): ");
        boolean isCorporate = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        Customer customer = new Customer(customerId, name, contactDetails, isCorporate);
        customers.add(customer);
        System.out.println("Customer added successfully.");
    }

    private static void addVehicle() {
        System.out.print("Enter Vehicle ID: ");
        String vehicleId = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Maximum Load: ");
        double maxLoad = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Is Light Vehicle (true/false): ");
        boolean isLight = scanner.nextBoolean();
        scanner.nextLine();

        Vehicle vehicle;
        if (isLight) {
            System.out.print("Enter Max Weight: ");
            double maxWeight = scanner.nextDouble();
            System.out.print("Enter Length: ");
            double length = scanner.nextDouble();
            System.out.print("Enter Width: ");
            double width = scanner.nextDouble();
            System.out.print("Enter Height: ");
            double height = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            vehicle = new LightVehicle(vehicleId, model, maxLoad, maxWeight, length, width, height);
        } else {
            System.out.print("Enter Vehicle Type (container/open/refrigerated): ");
            String type = scanner.nextLine();
            vehicle = new HeavyVehicle(vehicleId, model, maxLoad, type);
        }

        vehicles.add(vehicle);
        System.out.println("Vehicle added successfully.");
    }

    private static void addDriver() {
        System.out.print("Enter Driver ID: ");
        String driverId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter License Number: ");
        String licenseNumber = scanner.nextLine();

        Driver driver = new Driver(driverId, name, licenseNumber);
        drivers.add(driver);
        System.out.println("Driver added successfully.");
    }

    private static void requestShipment() {
        System.out.print("Enter Shipment ID: ");
        String shipmentId = scanner.nextLine();
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Pickup Location: ");
        String pickupLocation = scanner.nextLine();
        System.out.print("Enter Delivery Location: ");
        String deliveryLocation = scanner.nextLine();

        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        Customer customer = customers.stream()
                .filter(c -> c.getCustomerId().equals(customerId))
                .findFirst()
                .orElse(null);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        Shipment shipment = new Shipment(shipmentId, description, quantity, pickupLocation, deliveryLocation, customer);
        customer.addShipment(shipment);

        System.out.print("Enter Vehicle ID: ");
        String vehicleId = scanner.nextLine();
        Vehicle vehicle = vehicles.stream()
                .filter(v -> v.getVehicleId().equals(vehicleId))
                .findFirst()
                .orElse(null);

        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        System.out.print("Enter Driver ID: ");
        String driverId = scanner.nextLine();
        Driver driver = drivers.stream()
                .filter(d -> d.getDriverId().equals(driverId))
                .findFirst()
                .orElse(null);

        if (driver == null) {
            System.out.println("Driver not found.");
            return;
        }

        // Process shipment in a new thread
        ShipmentProcessor processor = new ShipmentProcessor(shipment, vehicle, driver);
        processor.start();
    }
}
