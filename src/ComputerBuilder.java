public class ComputerBuilder {
    public Computer buildComputer(String[] parts) {
        String catagory = parts[0];
        String type = parts[1];
        String id = parts[2];
        String brands = parts[3];
        String cpuFamily = parts[4];

        switch(catagory){
            case "Desktop PC":
                int pc_memorySize = Integer.parseInt(parts[5]);
                int pc_ssdCapacity = Integer.parseInt(parts[6]);
                double pc_price = Double.parseDouble(parts[7]);
                return new Desktop(catagory, type, id, brands, cpuFamily, pc_memorySize, pc_ssdCapacity, pc_price);
            case "Laptop":
                int lt_memorySize = Integer.parseInt(parts[5]);
                int lt_ssdCapacity = Integer.parseInt(parts[6]);
                double lt_screenSize = Double.parseDouble(parts[7]);
                double lt_price = Double.parseDouble(parts[8]);
                return new Laptop(catagory, type, id, brands, cpuFamily, lt_memorySize, lt_ssdCapacity, lt_screenSize, lt_price);
            case "Tablet":
                double tab_screenSize = Double.parseDouble(parts[5]);
                double tab_price = Double.parseDouble(parts[6]);
                return new Tablet(catagory, type, id, brands, cpuFamily, tab_screenSize, tab_price);
        }
    return null;
    }
}