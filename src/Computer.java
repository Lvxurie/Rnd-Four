public class Computer {
    protected String category;
    protected String type;
    protected String id;
    protected String brand;
    protected String cpuFamily;
    protected String price;

    public Computer(String category, String type, String id, String brand, String cpuFamily, String price){
        this.category = category;
        this.type = type;
        this.id = id;
        this.brand = brand;
        this.cpuFamily = cpuFamily;
        this.price = price;
    }

    public String getCategory() {
        return category;
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
    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
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

    public void setPrice(String price) {
        this.price = price;
    }
}
