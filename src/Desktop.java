public class Desktop extends Computer {
    private String memorySize;
    private String ssdCapacity;

    public Desktop(String catagory, String type, String id, String brand, String cpuFamily, String memorySize, String ssdCapacity, String price) {
        super(catagory, type, id, brand, cpuFamily, price);
        this.memorySize = memorySize;
        this.ssdCapacity = ssdCapacity;
    }

    public String getMemorySize() {
        return memorySize;
    }

    public String getSsdCapacity() {
        return ssdCapacity;
    }

    public void setMemorySize(String memorySize) {
        this.memorySize = memorySize;
    }

    public void setSsdCapacity(String ssdCapacity) {
        this.ssdCapacity = ssdCapacity;
    }
}
