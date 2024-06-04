public class Tablet extends Computer {
    private String screenSize;

    public Tablet(String catagory, String type, String id, String brand, String cpuFamily, String screenSize, String price) {
        super(catagory, type, id, brand, cpuFamily, price);
        this.screenSize = screenSize;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }
}
