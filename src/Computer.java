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
}
