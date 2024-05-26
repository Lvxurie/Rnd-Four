public class Computer {
    protected String catagory;
    protected String type;
    protected String id;
    protected String brand;
    protected String cpuFamily;
    protected double price;

    public Computer(String catagory, String type, String id, String brand, String cpuFamily, double price){
        this.catagory = catagory;
        this.type = type;
        this.id = id;
        this.brand = brand;
        this.cpuFamily = cpuFamily;
        this.price = price;
    }

    public String getCatagory() {
        return catagory;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getCpuFamily() {
        return cpuFamily;
    }
    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCpuFamily(String cpuFamily) {
        this.cpuFamily = cpuFamily;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
