public class Laptop extends Computer {
    private String memorySize;
    private String ssdCapacity;
    private String screenSize;

    public Laptop(String catagory, String type, String id, String brand, String cpuFamily, String memorySize, String ssdCapacity, String screenSize, String price) {
        super(catagory, type, id, brand, cpuFamily, price);
        this.memorySize = memorySize;
        this.ssdCapacity = ssdCapacity;
        this.screenSize = screenSize;
    }

    public String getMemorySize() {
        return memorySize;
    }

    public String getSsdCapacity() {
        return ssdCapacity;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setMemorySize(String memorySize) {
        this.memorySize = memorySize;
    }

    public void setSsdCapacity(String ssdCapacity) {
        this.ssdCapacity = ssdCapacity;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }
}
