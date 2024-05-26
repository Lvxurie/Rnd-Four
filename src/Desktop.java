public class Desktop extends Computer {
    private int memorySize;
    private int ssdCapacity;
    public Desktop(String catagory, String type, String id, String brand, String cpuFamily, int memorySize, int ssdCapacity, double price) {
        super(catagory, type, id, brand, cpuFamily, price);
        this.memorySize = memorySize;
        this.ssdCapacity = ssdCapacity;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public int getSsdCapacity() {
        return ssdCapacity;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public void setSsdCapacity(int ssdCapacity) {
        this.ssdCapacity = ssdCapacity;
    }
}
