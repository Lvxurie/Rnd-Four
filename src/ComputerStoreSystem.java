
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public abstract class ComputerStoreSystem {
    private static HashMap<String, Computer> computerHashMap = new HashMap<>();
    private static List<Staff> staffList;

    public static void intialiseComputerHashMap() {
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

                }
                br.close();
        }         catch (IOException e) {
            System.out.println("Failed to get file");
            System.exit(0);
        }

    }
}
