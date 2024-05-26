public class Laptop extends Computer {
    private int memorySize;
    private int ssdCapacity;
    private double screenSize;
    public Laptop(String catagory, String type, String id, String brand, String cpuFamily, int memorySize, int ssdCapacity, double screenSize, double price) {
        super(catagory, type, id, brand, cpuFamily, price);
        this.memorySize = memorySize;
        this.ssdCapacity = ssdCapacity;
        this.screenSize = screenSize;
    }
}
