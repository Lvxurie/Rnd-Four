public class ComputerBuilder {
    public Computer buildComputer(String[] parts) {
        String catagory = parts[0];
        String type = parts[1];
        String id = parts[2];
        String brands = parts[3];
        String cpuFamily = parts[4];

        switch(catagory){
            case "Desktop PC":
                String pc_memorySize = parts[5];
                String pc_ssdCapacity = parts[6];
                String pc_price = parts[7];
                return new Desktop(catagory, type, id, brands, cpuFamily, pc_memorySize, pc_ssdCapacity, pc_price);
            case "Laptop":
                String lt_memorySize = parts[5];
                String lt_ssdCapacity = parts[6];
                String lt_screenSize = parts[7];
                String lt_price = parts[8];
                return new Laptop(catagory, type, id, brands, cpuFamily, lt_memorySize, lt_ssdCapacity, lt_screenSize, lt_price);
            case "Tablet":
                String tab_screenSize = parts[5];
                String tab_price = parts[6];
                return new Tablet(catagory, type, id, brands, cpuFamily, tab_screenSize, tab_price);
        }
    return null;
    }
}