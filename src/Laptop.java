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

    public int getMemorySize() {
        return memorySize;
    }

    public int getSsdCapacity() {
        return ssdCapacity;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public void setSsdCapacity(int ssdCapacity) {
        this.ssdCapacity = ssdCapacity;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}
