public class Tablet extends Computer {
    private double screenSize;
    public Tablet(String catagory, String type, String id, String brand, String cpuFamily, double screenSize, double price) {
        super(catagory, type, id, brand, cpuFamily, price);
        this.screenSize = screenSize;
    }
}
