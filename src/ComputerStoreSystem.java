
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public abstract class ComputerStoreSystem {
    public static Vector<String> categories = new Vector<>();
    public static Vector<String> types = new Vector<>();
    public static void intialiseComputerHashMap(HashMap<String, Computer> computerHashMap) {
        String line = null;
        String[] parts;
        try {
            BufferedReader br = new BufferedReader(new FileReader("computers.txt"));
                while((line = br.readLine()) != null) {
                    parts = line.split(",");
                    ComputerBuilder computerBuilder = new ComputerBuilder();
                    Computer temp = computerBuilder.buildComputer(parts);
                    if(temp==null){break;}
                    computerHashMap.put(temp.getId(),temp);
                    addCategory(temp);
                    addType(temp);
                }
                br.close();
        }         catch (IOException e) {
            System.out.println("Failed to get file");
            System.exit(0);
        }

    }
    public static void initialiseStaffLogins(List<Staff> staffCredentialsList){
        staffCredentialsList.add(new Salesperson("p1", "p1"));
        staffCredentialsList.add(new Salesperson("p2", "p2"));
        staffCredentialsList.add(new Salesperson("p3", "p3"));
        staffCredentialsList.add(new Manager("m1", "m1"));
        staffCredentialsList.add(new Manager("m2", "m2"));
    }
    public static void addCategory(Computer computer){
        if(categories.isEmpty()){ categories.add("---Show All---");}
        if(!categories.contains(computer.category)){
            categories.add(computer.category);
        }
    }
    public static void addType(Computer computer){
        if(types.isEmpty()){ types.add("---Show All---");}
        if(!types.contains(computer.type)){
            types.add(computer.type);
        }
    }

}
