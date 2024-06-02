
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public abstract class ComputerStoreSystem {
    public static Vector<String> catagories = new Vector<>();
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
                    addCatagory(temp);
                    addType(temp);
                }
                br.close();
        }         catch (IOException e) {
            System.out.println("Failed to get file");
            System.exit(0);
        }

    }
    public static void initialiseStaffLogins(List<Staff> staffCredentialsList){
        staffCredentialsList.add(new Staff("p1", "p1", false));
        staffCredentialsList.add(new Staff("p2", "p2", false));
        staffCredentialsList.add(new Staff("p3", "p3", false));
        staffCredentialsList.add(new Staff("m1", "m1", true));
        staffCredentialsList.add(new Staff("m2", "m2", true));
    }
    public static void addCatagory(Computer computer){
        if(!catagories.contains(computer.catagory)){
            catagories.add(computer.catagory);
        }
    }
    public static void addType(Computer computer){
        if(!types.contains(computer.type)){
            types.add(computer.type);
        }
    }

}
