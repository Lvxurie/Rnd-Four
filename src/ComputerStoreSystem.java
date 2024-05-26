
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public abstract class ComputerStoreSystem {
    private static HashMap<Computer, Computer> computerHashMap = new HashMap();
    private static List<Staff> staffList;

    public ComputerStoreSystem() {
    }

    public static void intialiseComputerHashMap(HashMap<Computer, Computer> computerHashMap) {
        String line = null;
        String[] parts;
        try {
            BufferedReader br = new BufferedReader(new FileReader("computers.txt"));
                while((line = br.readLine()) != null) {
                    parts = line.split(",");
                    ComputerBuilder computerBuilder = new ComputerBuilder();
                    Computer temp = computerBuilder.buildComputer(parts);
                    if(temp==null){break;}


                }
                br.close();
        }         catch (IOException e) {
            System.out.println("Failed to get file");
            System.exit(0);
        }

    }
}
