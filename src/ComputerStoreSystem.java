
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

        try {
            BufferedReader br = new BufferedReader(new FileReader("computers.txt"));

                while((line = br.readLine()) != null) {
                    String[] var1 = line.split(",");
                }
                br.close();
        }         catch (IOException var8) {
            System.out.println("Failed to get file");
            System.exit(0);
        }

    }
}
